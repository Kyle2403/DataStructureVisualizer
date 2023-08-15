package DataStructures;
// This class represents vertices of myGraph
public class Vertex<T> {
    private T element;

    public Vertex(T element){
        this.element = element;
    }

    public T getElement() {
        return element;
    }
}
