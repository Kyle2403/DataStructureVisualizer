package DataStructures;

import java.util.Arrays;

public class Queue<T> {
    private T[] array;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public Queue() {
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

    // push an element to the queue
    public String enqueue(T e) {
        if (!this.isEmpty()) {
            int i = 0;
            while (i<size){
                if (array[i].equals(e)){
                    return e + " is already in the queue.";
                }
                i++;
            }
        }
        this.reSize();
        array[size++] = e;
        return e + " is enqueued to the queue.";
    }

    // get at element out of the queue
    public String dequeue() {
        if (this.size == 0) {
            return "The queue is empty.";
        }
        T item = array[0];
        size--;
        for (int i = 0; i<size;i++){
            array[i] = array[i+1];
        }
        array[size] = null;
        return item + " has been dequeued.";
    }

    // look at the top without removing it
    public T first() {
        if (this.size == 0) {
            return null;
        }
        return array[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String[] getQueue() {
        String[] ls = new String[size];
        for (int i =0; i < size; i++){
            ls[i] = (String) array[i];
        }
        return ls;
    }

}


