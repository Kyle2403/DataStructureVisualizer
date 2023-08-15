package DataStructures;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.ArrayList;

// This class is to convert different data structures to a SingleGraph of
// graphStream to visualize them
public class GraphStreamConverter {

    // turn stack to graphStream
    public static Graph stackToGraphStream(Stack<String> stack){
        Graph graph = new SingleGraph("StackVisualization");
        int j = 0;
        while (j < 10){
            Node node = graph.addNode("PlaceHolder" + (j+1));
            node.setAttribute("ui.label", "PlaceHolder " + (j+1));
            node.setAttribute("ui.style", "shape:box;fill-color:white;size:100px,75px;stroke-mode:plain;stroke-color:white;text-size: 16px;text-color:white;");
            node.setAttribute("x",100);
            node.setAttribute("y",100+j);
            j++;
        }
        int i = 0;
        for (String s: stack.getStack()){
            Node node = graph.addNode(s);
            node.setAttribute("ui.label", s);
            node.setAttribute("ui.style", "shape:box;fill-color:white;size:100px,75px;stroke-mode:plain;stroke-color:blue;text-size: 16px;text-color:blue;");
            graph.removeNode(i);
            node.setAttribute("x",100);
            node.setAttribute("y",100+i);
            i+=1;
        }
        return graph;
    }

    // turn tree to graphStream
    public static Graph treeToGraphStream (Tree<String> tree){
        Graph graph = new SingleGraph("Tree");
        if (tree.getSize()==0){
            return graph;
        }
        ArrayList<TreeNode<String>> ls = new ArrayList<>();
        tree.preorder(tree.getRoot(),ls);  // get all the nodes

        // adding the root
        Node root = graph.addNode(ls.get(0).getValue());
        root.setAttribute("ui.label", ls.get(0).getValue());
        root.setAttribute("ui.style", "text-color:red;text-alignment:above;text-size: 60px;fill-color:red;");
        root.setAttribute("x",100);
        root.setAttribute("y",100);
        ls.remove(0);
        int y = 10;
        int x = 20;

        // adding the nodes
        for (TreeNode<String> n: ls){
            Node t = graph.addNode(n.getValue());
            t.setAttribute("ui.label", n.getValue());
            t.setAttribute("ui.style", "text-color:orange;text-offset:10;text-alignment:at-right;text-size: 40px;fill-color:orange;");
            TreeNode<String> parent = n.getParent();
            int parentX = (int) graph.getNode(parent.getValue()).getAttribute("x");
            int parentY = (int) graph.getNode(parent.getValue()).getAttribute("y");
            int offSet = n.offSetFromParent();

            // positioning the nodes according to level
            t.setAttribute("x",parentX-offSet*x);
            t.setAttribute("y",parentY-y*n.getLevel());
            t.setAttribute("ui.label",n.getValue());
            org.graphstream.graph.Edge e =graph.addEdge(parent.getValue() + n.getValue(),parent.getValue(),n.getValue());
            e.setAttribute("ui.style","fill-color:red;");
            x-=1;
        }
        return graph;
    }

    // turn myGraph to graphStream
    public static Graph myGraphToGraphStream(MyGraph<String> myGraph){
        Graph graph = new SingleGraph("Graph");
        for(Vertex<String> v:myGraph.getVertices()){
            Node V = graph.addNode(v.getElement());
            V.setAttribute("ui.label",v.getElement());
            V.setAttribute("ui.style", "text-color:brown;text-alignment:above;text-size: 40px;fill-color:brown;");

        }
        for(Edge<String> e:myGraph.getEdges()) {
            org.graphstream.graph.Edge f = graph.addEdge(e.getElement(), e.getU().getElement(), e.getV().getElement());
            f.setAttribute("ui.label", e.getElement());
            f.setAttribute("ui.style", "text-alignment:along;text-size: 40px;");
        }
        return graph;
    }

    // turn priority queue to graphStream, similar to stack
    public static Graph priorityQueueToGraphStream(PriorityQueue pq){
        Graph graph = new SingleGraph("PriorityQueueVisualization");
        int j = 0;
        while (j < 10){
            Node node = graph.addNode("PlaceHolder" + (j+1));
            node.setAttribute("ui.label", "PlaceHolder " + (j+1));
            node.setAttribute("ui.style", "shape:box;fill-color:white;size:100px,75px;stroke-mode:plain;stroke-color:white;text-size: 16px;text-color:white;");
            node.setAttribute("x",100);
            node.setAttribute("y",100+j);
            j++;
        }
        int i = pq.size()- 1;
        for (PriorityItem p: pq.getPQ()){
            String val = p.getValue();
            int key = p.getKey();
            Node node = graph.addNode(val);
            node.setAttribute("ui.label", key + "-" + val);
            node.setAttribute("ui.style", "shape:box;fill-color:white;size:100px,75px;stroke-mode:plain;stroke-color:red;text-size: 16px;text-color:red;");
            graph.removeNode(i);
            node.setAttribute("x",100);
            node.setAttribute("y",100+i);
            i-=1;
        }
        return graph;
    }

    // turn linked list to graphStream
    // linked list is basically a graph with the edges being references between nodes
    public static Graph linkedListToGraphStream(SingleLinkedList<String> sll){
        Graph graph = new SingleGraph("SingleList");
        if (sll.size()==0){
            return graph;
        }
        SingleNode<String> current = sll.getHead();
        Node node = graph.addNode(current.getValue());
        node.setAttribute("ui.label",current.getValue());
        node.setAttribute("ui.style", "text-color:blue;text-alignment:above;text-size: 60px;fill-color:blue;");

        // while it is not the end of list, keep adding nodes
        while (current.getNext() != null) {
            Node next = graph.addNode(current.getNext().getValue());
            next.setAttribute("ui.label",current.getNext().getValue());
            next.setAttribute("ui.style", "text-color:cyan;text-alignment:above;text-size: 40px;fill-color:cyan;");
            org.graphstream.graph.Edge e = graph.addEdge(current.getValue() + current.getNext().getValue(), current.getValue(), current.getNext().getValue(),true);
            e.setAttribute("ui.style","fill-color:navy;");
            current = current.getNext();
        }
        return graph;
    }


    // turn queue to graphStream, similar to stack
    public static Graph queueToGraphStream(Queue<String> queue){
        Graph graph = new SingleGraph("QueueVisualization");
        int j = 0;
        while (j < 10){
            Node node = graph.addNode("PlaceHolder" + (j+1));
            node.setAttribute("ui.label", "PlaceHolder " + (j+1));
            node.setAttribute("ui.style", "shape:box;fill-color:white;size:100px,75px;stroke-mode:plain;stroke-color:white;text-size: 16px;text-color:white;");
            node.setAttribute("x",100);
            node.setAttribute("y",100+j);
            j++;
        }
        int i = 0;
        for (String s: queue.getQueue()){
            Node node = graph.addNode(s);
            node.setAttribute("ui.label", s);
            node.setAttribute("ui.style", "shape:box;fill-color:white;size:100px,75px;stroke-mode:plain;stroke-color:brown;text-size: 16px;text-color:brown;");
            graph.removeNode(i);
            node.setAttribute("x",100);
            node.setAttribute("y",100+i);
            i+=1;
        }
        return graph;
    }
}
