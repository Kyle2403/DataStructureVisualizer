package DataStructures;

import java.util.ArrayList;

public class MyGraph<T> {

    private ArrayList<Vertex<T>> vertices;
    private ArrayList<Edge<T>> edges;

    public MyGraph(){
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public int numEdges(){
        return this.edges.size();
    }

    public int numVertices(){
        return this.vertices.size();
    }

    public ArrayList<Vertex<T>> getVertices(){
        return this.vertices;
    }

    public ArrayList<Edge<T>> getEdges(){
        return this.edges;
    }

    /*
    Returns the edge from vertex u to vertex v, if one exists;
    Otherwise return None (including when either u or v is None).
    param u: The vertex object representing vertex u.
    param v: The vertex object representing vertex v.
    return: The edge object representing the edge connecting vertices u and v.*/
    public Edge<T> getEdge(Vertex<T> u, Vertex<T> v){
        if (u == null || v == null){
            return null;
        }
        for(Edge<T> e : this.edges){
            if ((e.getU() == u & e.getV() == v) || (e.getV() == u & e.getU() == v)){
                return e;
            }
        }
        return null;
    }

    /*Returns an array containing the two endpoint vertices of edge e.
    Return None if edge e is None.
    param e: The edge object representing edge e.
    return: The list containing vertex objects which represent the two endpoint vertices of edge e*/
    public ArrayList<Vertex<T>> endVertices(Edge<T> e){
        if (e == null){
            return null;
        }
        ArrayList<Vertex<T>> ls = new ArrayList<>();
        ls.add(e.getU());
        ls.add(e.getV());
        return ls;
    }

    /*For edge e incident to vertex v, returns the other vertex of the edge;
    Return None if e is not incident to v, or if either v or e is None.
    param v: The vertex object representing vertex v.
    param e: The edge object representing edge e.
    return: The vertex object that represents the other vertex endpoint of edge e.*/
    public Vertex<T> Opposite(Vertex<T> v, Edge<T> e){
        if (v == null || e == null){
            return null;
        }
        if (e.getU()==v){
            return e.getV();
        }
        if (e.getV()==v){
            return e.getU();
        }
        return null;
    }

    /*
    Returns a list of all edges incident to vertex v.
    Return None if v is None.
    param v: The vertex object representing vertex v.
    return: The list of edge objects representing all the edges incident to vertex v.*/
    public ArrayList<Edge<T>> incidentEdges(Vertex<T> v){
        if (v == null){
            return null;
        }
        ArrayList<Edge<T>> ls = new ArrayList<>();
        for (Edge<T> e : this.edges){
            ArrayList<Vertex<T>> ls2 = this.endVertices(e);
            for (Vertex<T> t:ls2){
                if (t.getElement().equals(v.getElement())){
                    ls.add(e);
                }
            }
            /*if (this.endVertices(e).contains(v)){
                ls.add(e);
            }*/
        }
        return ls;
    }

    /*
    Returns the number of edges incident to vertex v.
    Return None if v is None.
    param v: The vertex object representing vertex v.
    return: The integer representing the number of edges incident to v.*/
    public Integer degree(Vertex<T> v){
        if (v == null){
            return null;
        }
        return this.incidentEdges(v).size();
    }

    public boolean contain(Vertex<T> v){
        if ( v== null){
            return false;
        }
        for (Vertex<T> u: this.vertices){
            if (u.getElement().equals(v.getElement())){
                return true;
            }
        }
        return false;
    }

    // insert a vertex and return a response
    public String insertVertex(Vertex<T> v){
        if (v == null){
            return "Vertex is null.";
        }
        Vertex<T> v1 = findVertex(v.getElement());
        if (v1 != null){
            return "Vertex " + v.getElement() + " has already existed.";
        }
        this.vertices.add(v);
        return "Vertex " + v.getElement() + " has been added to the graph.";
    }

    /*Creates a new Edge from vertex u to vertex v,
    storing element x*/
    public String insertEdge(Vertex<T> v, Vertex<T> u, T element){
        if (v == null || u == null){
            return "One or both vertices are null.";
        }
        if (!this.contain(v) || !this.contain(u)){
            return "At least one of the vertices " + v.getElement() + " and " + u.getElement() + " does not exist.";
        }
        if (this.getEdge(u,v) != null){
            return "An edge between vertex " +u.getElement() + " and " + v.getElement() +" has already existed.";
        }
        Edge<T> e = new Edge<>(element,u,v);
        this.edges.add(e);
        return "An edge between vertex " +u.getElement() + " and " + v.getElement() +" has been added.";
    }

    /*Removes vertex v and all its incident edges from the graph.*/
    public String removeVertex(Vertex<T> v){
        if (v==null){
            return "No vertex was given.";
        }
        if (!this.contain(v)){
            return "Vertex does not exist.";
        }
        for (Vertex<T> u: this.vertices){
            if (u.getElement().equals(v.getElement())){
                ArrayList<Edge<T>> incidentEdges = this.incidentEdges(v);
                for (Edge<T> e: incidentEdges){
                    this.edges.remove(e);
                }
                this.vertices.remove(v);
                return "Vertex " + v.getElement() + ", along with its edges, have been removed.";
            }
        }
        return "";
    }


    //Removes edge e from the graph.
    public String removeEdge(Edge<T> e){
        if (e == null){
            return "No edge was given.";
        }
        for (Edge<T> ed: this.edges){
            if (ed.getElement().equals(e.getElement())){
                this.edges.remove(e);
                return "Edge " + e.getElement() + " has been removed.";
            }
        }
        return "Edge " + e.getElement() + " does not exist.";
    }

    public Vertex<T> findVertex(T s){
        for (Vertex<T> v: this.vertices){
            if (v.getElement().equals(s)){
                return v;
            }
        }
        return null;
    }
}
