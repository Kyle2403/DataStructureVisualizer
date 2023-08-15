package DataStructures;
import java.util.ArrayList;

// This class is a priority queue that implements RemoveMin (Not removeMax)
// item with the smallest key get removed
public class PriorityQueue {
    private ArrayList<PriorityItem> ls;

    public PriorityQueue(){
        this.ls = new ArrayList<>();
    }

    public int size(){
        return ls.size();
    }

    public ArrayList<PriorityItem> getPQ() {
        return ls;
    }

    // insert an item, return a string as response
    public String insert(PriorityItem p){
        if (p.getKey() == null || p.getValue() == null){
            return "No Item was given.";
        }
        if (ls.size()==0){
            ls.add(p);
            return "An item with value "+ p.getValue() +" and key "+p.getKey()+ " has been added to the Priority queue.";
        }
        for (PriorityItem q: ls){
            if (p.getValue().equals(q.getValue())){
                return "An item with value " + p.getValue() + " has already existed.";
            }
        }
        for (int i = 0;i < ls.size(); i++) {
            Integer current_key = ls.get(i).getKey();
            if (current_key > p.getKey()) {
                ls.add(i, p);
                return "An item with value "+ p.getValue() +" and key "+p.getKey()+ " has been added to the Priority queue.";
            }
        }
        ls.add(p);
        return "An item with value "+ p.getValue() +" and key "+p.getKey()+ " has been added to the Priority queue.";

    }
    // Remove the item with the smallest key.
    public String removeMin(){
        if (this.size()==0){
            return "The Priority queue is empty.";
        }
        PriorityItem min = this.min();
        ls.remove(min);
        return "Item with value "+ min.getValue() + " and key " + min.getKey() + " has been removed.";
    }

    public PriorityItem min(){
        if (ls.size()==0){
            return null;
        }
        return ls.get(0);
    }



}
