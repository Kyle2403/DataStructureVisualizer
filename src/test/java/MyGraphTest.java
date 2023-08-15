import DataStructures.Edge;
import DataStructures.MyGraph;
import DataStructures.Vertex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;

public class MyGraphTest {

    Vertex<Integer> u = new Vertex<>(1);
    Vertex<Integer> v = new Vertex<>(2);
    Vertex<Integer> t = new Vertex<>(3);
    Edge<Integer> e = new Edge<>(3,u,t);


    @Test
    public void testVertex(){
        Assertions.assertEquals(1,u.getElement());
    }

    @Test
    public void testEdge(){
        Assertions.assertEquals(3,e.getElement());
        Assertions.assertEquals(u,e.getU());
        Assertions.assertEquals(t,e.getV());
    }

    @Test
    public void testMyGraph(){
        MyGraph<Integer> gr = new MyGraph<>();
        Assertions.assertEquals(0,gr.numEdges());
        Assertions.assertEquals(0,gr.numVertices());
    }

    @Test
    public void testMyGraphInsert(){
        MyGraph<Integer> gr = new MyGraph<>();
        gr.insertVertex(null);
        Assertions.assertEquals(0,gr.numVertices());
        gr.insertVertex(u);
        Assertions.assertEquals(1,gr.numVertices());
        gr.insertEdge(null, v, 12);
        gr.insertEdge(u, v, 12);
        Assertions.assertEquals(0,gr.numEdges());
        gr.insertVertex(v);
        gr.insertEdge(u, v, 12);
        Assertions.assertEquals(1,gr.numEdges());
        gr.insertEdge(u, v, 12);
        Assertions.assertEquals(1,gr.numEdges());
    }

    @Test
    public void testMyGraphRemove(){
        MyGraph<Integer> gr = new MyGraph<>();
        Assertions.assertEquals(gr.removeVertex(null),"No vertex was given.");
        gr.insertVertex(u);
        gr.insertVertex(v);
        gr.insertEdge(u, v, 12);
        Assertions.assertEquals("Vertex 1, along with its edges, have been removed.",gr.removeVertex(u));
        Assertions.assertEquals("Vertex does not exist.",gr.removeVertex(u));
        gr.insertVertex(u);
        gr.insertEdge(u, v, 12);
        Assertions.assertEquals("Edge " + e.getElement() + " does not exist.",gr.removeEdge(e));
        Assertions.assertEquals("No edge was given.",gr.removeEdge(null));


    }

    @Test
    public void testMyGraphGet(){
        MyGraph<Integer> gr = new MyGraph<>();
        gr.insertVertex(u);
        gr.insertVertex(v);
        gr.insertEdge(u, v, 12);
        ArrayList<Vertex<Integer>> vertexLs = new ArrayList<>();
        ArrayList<Edge<Integer>> edgeLs = new ArrayList<>();
        Collections.addAll(vertexLs,u,v);
        Collections.addAll(edgeLs,e);
        Assertions.assertEquals(vertexLs,gr.getVertices());
        Assertions.assertEquals(12,gr.getEdges().get(0).getElement());
    }

    @Test
    public void testMyGraphDegree(){
        MyGraph<Integer> gr = new MyGraph<>();
        gr.insertVertex(u);
        gr.insertVertex(v);
        Assertions.assertEquals(0,gr.degree(v));
        Assertions.assertNull(gr.degree(null));
        gr.insertEdge(u, v, 12);
        Assertions.assertEquals(1,gr.degree(v));
    }

    @Test
    public void testMyGraphOpposite(){
        MyGraph<Integer> gr = new MyGraph<>();
        gr.insertVertex(u);
        gr.insertVertex(v);
        Assertions.assertNull(gr.incidentEdges(null));
        gr.insertEdge(u, v, 12);
        Assertions.assertNull(gr.Opposite(null,null));
        Assertions.assertEquals(u,gr.Opposite(v,gr.getEdge(u,v)));
        Assertions.assertEquals(v,gr.Opposite(u,gr.getEdge(u,v)));
        Assertions.assertNull(gr.Opposite(t,gr.getEdge(u,v)));
    }

    @Test
    public void testMyGraphEndVertices(){
        MyGraph<Integer> gr = new MyGraph<>();
        gr.insertVertex(u);
        gr.insertVertex(v);
        gr.insertEdge(u, v, 12);
        Assertions.assertNull(gr.endVertices(null));
        Assertions.assertNull(gr.getEdge(null,null));
        Assertions.assertNull(gr.getEdge(t,v));
    }

}
