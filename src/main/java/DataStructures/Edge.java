package DataStructures;

// Edge class for MyGraph
public class Edge<T> {
    private T element;
    private Vertex<T> u;
    private Vertex<T> v;

    public Edge(T element, Vertex<T> u, Vertex<T> v){
        this.element = element;
        this.u = u;
        this.v = v;
    }

    public T getElement() {
        return element;
    }

    public Vertex<T> getU() {
        return u;
    }

    public Vertex<T> getV() {
        return v;
    }
}
