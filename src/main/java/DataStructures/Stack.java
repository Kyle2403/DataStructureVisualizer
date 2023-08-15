package DataStructures;
import java.util.Arrays;
// This class represents a stack (Last in First out)
public class Stack<T> {
    private T[] array;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public Stack() {
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    // make a new array when overflown
    public void reSize() {
        if (this.size == this.capacity) {
            this.capacity = this.capacity * 2;
            this.array = Arrays.copyOf(this.array, this.capacity);
        }
    }

    // push an element to the stack
    public String push(T e) {
        if (!this.isEmpty()) {
            int i = 0;
            while (i<size){
                if (array[i].equals(e)){
                    return e + " is already in the stack.";
                }
                i++;
            }
        }
        this.reSize();
        array[size++] = e;
        return e + " is pushed to the stack.";
    }

    // get at element out of the stack
    public String pop() {
        if (this.size == 0) {
            return "The stack is empty.";
        }
        T item = array[--size];
        array[size] = null;
        return item + " has been popped.";
    }

    // look at the top without removing it
    public T top() {
        if (this.size == 0) {
            return null;
        }
        return array[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String[] getStack() {
        String[] ls = new String[size];
        for (int i =0; i < size; i++){
            ls[i] = (String) array[i];
        }
        return ls;
    }

}


