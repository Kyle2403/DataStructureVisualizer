package DataStructures;

// This class is item of a priority queue.
public class PriorityItem {
    private Integer key;
    private String value;

    public PriorityItem(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    public Integer getKey(){
        return this.key;
    }
    public String getValue(){
        return this.value;
    }


}
