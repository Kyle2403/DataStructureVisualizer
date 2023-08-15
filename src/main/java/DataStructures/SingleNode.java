package DataStructures;
import java.util.Objects;
// This class represents node inside a Single Linked List
public class SingleNode<T> {
    private T value;
    private SingleNode<T> next;

    public SingleNode(T v){
        this.value = v;
        next = null;
    }
    public SingleNode<T> getNext(){
        return this.next;
    }
    public void setNext(SingleNode<T> n){
        this.next = n;
    }
    public T getValue(){
        return this.value;
    }
    public void setValue(T v){
        this.value = v;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SingleNode<?> other = (SingleNode<?>) obj;
        return Objects.equals(value, other.value);
    }
}

