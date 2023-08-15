package DataStructures;

import java.awt.*;
/*Single_ll Class holds nodes, where each node in the Single_ll has a next Node, unless it is the end node
where the next Node is None.*/
public class SingleLinkedList<T> {
    private SingleNode<T> head;
    private int size;
    public SingleLinkedList(){
        head = null;
        size = 0;
    }

    // return the first node
    public SingleNode<T> getHead() {
        return this.head;
    }

    // return the last node
    public SingleNode<T> getBack(){
        if (this.size == 0){
            return null;
        }
        // traverse to the last node
        SingleNode<T> cur_node = head;
        while (cur_node.getNext() != null){
            cur_node = cur_node.getNext();
        }
        return cur_node;
    }

    // return list size
    public int size(){
        return this.size;
    }

    // find a node
    public SingleNode<T> findNote(T p){
        if (this.size == 0){
            return null;
        }
        SingleNode<T> cur_node = this.head;

        if (cur_node.getValue().equals(p)){
            return cur_node;
        }

        while (cur_node.getNext() != null){
            cur_node = cur_node.getNext();
            if (cur_node.getValue().equals(p)){
                return cur_node;
            }
        }
        return null;
    }

    public boolean nodeExists(SingleNode<T> p){
        if (p==null){
            return false;
        }
        SingleNode<T> result = findNote(p.getValue());
        return result != null;
    }
    // insert the node e immediately after node p. If p is Null or does not exist in list then add e at the beginning of the list
    public String insertAfter(SingleNode<T> p, SingleNode<T> e){
        if (e == null){
            return "No nodes given.";
        }
        if (nodeExists(e)){
            return "Node " + e.getValue() + " already exists.";
        }
        if (p == null || !nodeExists(p)){
            e.setNext(this.getHead());
            this.head = e;
            this.size++;
            return "Added node " + e.getValue() + " to the beginning of list since only 1 node is given or first node does not exist.";
        }
        e.setNext(p.getNext());
        p.setNext(e);
        this.size++;
        return "Added node " + e.getValue() + " after node "  + p.getValue() + ".";
    }

    // Removes the node p
    public String removeNode(SingleNode<T> p){
        if (!nodeExists(p)) {
            return "Node " + p.getValue() + " does not exist.";
        }
        this.size--;
        SingleNode<T> cur_node = this.getHead();
        if (cur_node == p){
            this.head = cur_node.getNext();
            cur_node.setNext(null);
            return "Node " + p.getValue() + " has been removed.";
        }
        while (cur_node.getNext() != p){
            cur_node = cur_node.getNext();
        }
        cur_node.setNext(p.getNext());
        return "Node " + p.getValue() + " has been removed.";
    }

}
