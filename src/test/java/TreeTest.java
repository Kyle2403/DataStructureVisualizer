import DataStructures.TreeNode;
import org.junit.jupiter.api.Test;
import DataStructures.Tree;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TreeTest {
    TreeNode<String> a = new TreeNode<>("a");
    TreeNode<String> b = new TreeNode<>("b");
    TreeNode<String> c = new TreeNode<>("c");
    TreeNode<String> d = new TreeNode<>("d");
    TreeNode<String> e = new TreeNode<>("e");
    TreeNode<String> f = new TreeNode<>("f");
    @Test
    public void testTree(){
        Tree<String> tree = new Tree<>();
        Assertions.assertEquals(tree.getSize(),0);
        Assertions.assertNull(tree.getRoot());
    }

    @Test
    public void testRemove(){
        Tree<String> tree = new Tree<>();
        tree.removeNode(e);
        tree.addNode(null,a);
        tree.addNode(a,b);
        tree.addNode(b,d);
        tree.addNode(a,c);
        ArrayList<TreeNode<String>> exp = new ArrayList<>();
        tree.preorder(a,exp);
        tree.removeNode(e);
        ArrayList<TreeNode<String>> exp2 = new ArrayList<>();
        tree.preorder(a,exp2);
        Assertions.assertEquals(exp,exp2);
    }

    @Test
    public void testAddRemove(){
        Tree<String> tree = new Tree<>();
        tree.removeNode(a);
        tree.addNode(null,a);
        tree.addNode(a,b);
        tree.addNode(b,d);
        tree.addNode(a,c);
        Assertions.assertEquals(tree.getSize(),4);
        Assertions.assertEquals(b.getParent(),a);
        Assertions.assertEquals(d.getParent(),b);
        tree.removeNode(c);
        Assertions.assertEquals(tree.getSize(),3);
        ArrayList<TreeNode<String>> exp = new ArrayList<>();
        exp.add(b);
        Assertions.assertEquals(a.getChildren(),exp);
        tree.removeNode(a);
        Assertions.assertNull(tree.getRoot());
    }

    @Test
    public void testRemove2(){
        Tree<String> tree = new Tree<>();
        tree.addNode(null,a);
        tree.addNode(a,b);
        tree.addNode(a,a);
        tree.addNode(b,d);
        tree.addNode(a,c);
        tree.removeNode(b);
        Assertions.assertEquals(tree.getSize(),2);
        ArrayList<TreeNode<String>> exp = new ArrayList<>();
        Collections.addAll(exp,a,c);
        ArrayList<TreeNode<String>> ls = new ArrayList<>();
        tree.preorder(a,ls);
        Assertions.assertEquals(exp,ls);
    }

    @Test
    public void testPreOrder(){
        Tree<String> tree = new Tree<>();
        tree.addNode(null,a);
        tree.addNode(a,b);
        tree.addNode(b,d);
        tree.addNode(a,c);
        ArrayList<TreeNode<String>> ls = new ArrayList<>();
        tree.preorder(a,ls);
        ArrayList<TreeNode<String>> exp = new ArrayList<>();
        Collections.addAll(exp,a,b,d,c);
        Assertions.assertEquals(exp,ls);
    }

    @Test
    public void testPostOrder(){
        Tree<String> tree = new Tree<>();
        tree.addNode(null,a);
        tree.addNode(a,b);
        tree.addNode(b,d);
        tree.addNode(a,c);
        ArrayList<TreeNode<String>> ls = new ArrayList<>();
        tree.postorder(a,ls);
        ArrayList<TreeNode<String>> exp = new ArrayList<>();
        Collections.addAll(exp,d,b,c,a);
        Assertions.assertEquals(exp,ls);
    }

    @Test
    public void testLevel(){
        Tree<String> tree = new Tree<>();
        tree.addNode(null,a);
        tree.addNode(a,b);
        tree.addNode(b,d);
        tree.addNode(a,c);
        Assertions.assertEquals(0,a.getLevel());
        Assertions.assertEquals(1,b.getLevel());
        Assertions.assertEquals(1,c.getLevel());
        Assertions.assertEquals(2,d.getLevel());
    }

    @Test
    public void testOffSet(){
        Tree<String> tree = new Tree<>();
        tree.addNode(null,a);
        tree.addNode(a,b);
        tree.addNode(b,d);
        tree.addNode(a,c);
        tree.addNode(a,f);
        tree.addNode(b,e);
        Assertions.assertEquals(0,a.offSetFromParent());
        Assertions.assertEquals(-2,b.offSetFromParent());
        Assertions.assertEquals(-1,c.offSetFromParent());
        Assertions.assertEquals(-1,d.offSetFromParent());
        Assertions.assertEquals(0,e.offSetFromParent());
        Assertions.assertEquals(0,f.offSetFromParent());
    }
    /*
        Tree<String> tree = new Tree<>();
        TreeNode<String> a = new TreeNode<>("a");
        TreeNode<String> b = new TreeNode<>("b");
        TreeNode<String> c = new TreeNode<>("c");
        TreeNode<String> d = new TreeNode<>("d");
        TreeNode<String> e = new TreeNode<>("e");
        TreeNode<String> f = new TreeNode<>("f");
        TreeNode<String> g = new TreeNode<>("g");
        TreeNode<String> h = new TreeNode<>("h");
        TreeNode<String> j = new TreeNode<>("j");
        TreeNode<String> k = new TreeNode<>("k");
        TreeNode<String> l = new TreeNode<>("l");
        TreeNode<String> r = new TreeNode<>("r");
        TreeNode<String> t = new TreeNode<>("t");
        TreeNode<String> y = new TreeNode<>("y");
        TreeNode<String> u = new TreeNode<>("u");
        tree.addNode(null, a);
        tree.addNode(a, b);
        tree.addNode(a, f);
        tree.addNode(a, c);
        tree.addNode(a, d);
        tree.addNode(c, r);
        tree.addNode(c, t);
        tree.addNode(d, y);
        tree.addNode(d, u);
        tree.addNode(b, e);
        tree.addNode(b, l);
        tree.addNode(f, g);
        tree.addNode(f, h);
        tree.addNode(f, j);
        tree.addNode(f, k);
        Graph graph = GraphStreamConverter.treeToGraphStream(tree);
        Viewer v = graph.display();
        v.disableAutoLayout();
        PriorityItem a = new PriorityItem(1,"a");
        PriorityItem b = new PriorityItem(4,"b");
        PriorityItem c = new PriorityItem(0,"c");
        PriorityItem d = new PriorityItem(6,"d");
        PriorityQueue pq = new PriorityQueue();
        pq.insert(a);
        pq.insert(b);
        pq.insert(c);
        pq.insert(d);
        pq.removeMin();
        Graph graph = GraphStreamConverter.priorityQueueToGraphStream(pq);
        Viewer v = graph.display();
        v.disableAutoLayout();
        /*Queue<String> Queue = new Queue<>();
        Queue.enqueue("Hello");
        Queue.enqueue("Goodbye");
        Queue.enqueue("Hi");
        Queue.enqueue("HiAgain");
        Queue.dequeue() ;
        Graph graph = GraphStreamConverter.queueToGraphStream(Queue);
        Viewer v = graph.display();
        v.disableAutoLayout();
        /*Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.pop();
        //stack.push("3");
        //stack.push("4");
       // stack.push("5");
        //stack.push("6");
        //stack.push("7");
        //stack.push("8");
        //stack.push("9");
        //stack.push("10");
        //stack.push("11");




        Graph graph = GraphStreamConverter.stackToGraphStream(stack);
        Viewer v = graph.display();
        v.disableAutoLayout();


        /* Add nodes (elements) to the graph
        for (int i = 0; i < 5; i++) {
            Node node = graph.addNode("Node" + i);
            node.setAttribute("ui.label", "Element " + i);
            node.setAttribute("ui.style", "shape:box;fill-color:white;size:100,50;stroke-mode:plain;stroke-color:red;");

            node.setAttribute("x", 100);
            node.setAttribute("y", i*50);
        }

        Viewer v = graph.display();
        v.disableAutoLayout();*/





        /*

        MyGraph<String> gr = new MyGraph<>();
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        gr.insertVertex(A);
        gr.insertVertex(B);
        gr.insertVertex(C);
        gr.insertEdge(A,B,"ab");
        gr.insertEdge(C,B,"bc");
        gr.insertEdge(A,C,"ca");
        Graph graph2 = GraphStreamConverter.myGraphToGraphStream(gr);
        Viewer v2 = graph2.display();

        SingleNode<String> k = new SingleNode<>("k");
        SingleNode<String> f = new SingleNode<>("f");
        SingleNode<String> g = new SingleNode<>("g");
        SingleNode<String> h = new SingleNode<>("h");
        SingleNode<String> j = new SingleNode<>("j");
        SingleLinkedList<String> ls = new SingleLinkedList<>();
        ls.insertAfter(null, k);
        ls.insertAfter(k, f);
        ls.insertAfter(f, g);
        ls.insertAfter(g, h);
        ls.insertAfter(h, j);
        Graph graph3 = GraphStreamConverter.linkedListToGraphStream(ls);
        Viewer v3 = graph3.display();*/

}
