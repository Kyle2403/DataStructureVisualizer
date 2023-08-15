package DataStructures;

import org.graphstream.graph.Graph;
// This class receives input from user, apply corresponding methods to
// its data structure. GUI class read the data structures and displays them.
public class InputHandler {
    private SingleLinkedList<String> list;
    private Stack<String> stack;
    private Queue<String> queue;
    private PriorityQueue pq;
    private Tree<String> tree;
    private MyGraph<String> graph;

    public InputHandler(){
        list = new SingleLinkedList<>();
        stack = new Stack<>();
        queue = new Queue<>();
        pq = new PriorityQueue();
        tree = new Tree<>();
        graph = new MyGraph<>();
    }

    public Graph getList(){
        return GraphStreamConverter.linkedListToGraphStream(list);
    }
    public Graph getStack(){
        return GraphStreamConverter.stackToGraphStream(stack);
    }
    public Graph getQueue(){
        return GraphStreamConverter.queueToGraphStream(queue);
    }
    public Graph getPq(){
        return GraphStreamConverter.priorityQueueToGraphStream(pq);
    }
    public Graph getTree(){
        return GraphStreamConverter.treeToGraphStream(tree);
    }
    public Graph getGraph(){
        return GraphStreamConverter.myGraphToGraphStream(graph);
    }

    // calling different methods based on user inputs, button name and the type of data structure.
    public String execute(String[] command){
        if (command[0].equals("list") & command[1].equals("InsertAfter(node,node)")){
            String[] nodes = command[2].split(",");
            if (nodes.length>2 || nodes.length == 0){
                return "1 or 2 nodes are required for Insert, separated by 1 comma ','.";
            }
            // only one node is given, add it to the beginning of list
            if (nodes.length == 1){
                SingleNode<String> node = new SingleNode<>(nodes[0]);
                return list.insertAfter(null,node);
            }

            // 2 nodes given, then node1 should exist already,while node2 is a new one, which means it does not exist yet, then
            // add it to the list
            SingleNode<String> node = list.findNote(nodes[0]);
            SingleNode<String> node2 = new SingleNode<>(nodes[1]);
            return list.insertAfter(node, node2);
        }
        // remove a node
        if (command[0].equals("list") & command[1].equals("Remove(node)")){
            SingleNode<String> node = list.findNote(command[2].replace(",",""));
            if (node == null){
                return "Node " + command[2].replace(",","") + " does not exist.";
            }
            return list.removeNode(node);
        }
        // push to stack
        if (command[0].equals("stack") & command[1].equals("Push(item)")){
            return stack.push(command[2].replace(",",""));
        }
        // pop the stack
        if (command[0].equals("stack") & command[1].equals("Pop")){
            return stack.pop();
        }
        // enqueue
        if (command[0].equals("queue") & command[1].equals("Enqueue(item)")){
            return queue.enqueue(command[2].replace(",",""));
        }
        // dequeue
        if (command[0].equals("queue") & command[1].equals("Dequeue")){
            return queue.dequeue();
        }
        // insert to priority queue
        if (command[0].equals("pq") & command[1].equals("Insert(key,value)")){
            String[] pair = command[2].split(",");
            if (pair.length<2){
                return "A pair of key,value must be provided, separated by 1 comma ','.";
            }
            // key must be an integer
            try{
                Integer.parseInt(pair[0]);
            } catch (Exception e){
                return "Key must be an integer.";
            }
            int key = Integer.parseInt(pair[0]);
            String value = pair[1];
            return pq.insert(new PriorityItem(key,value));
        }
        // remove the item with the smallest key from the priority queue
        if (command[0].equals("pq") & command[1].equals("RemoveMin")) {
            return pq.removeMin();
        }
        // add a node to the tree
        if (command[0].equals("tree") & command[1].equals("Add(parentNode,childNode)")) {
            String[] pair = command[2].split(",");
            if (pair.length == 0 || pair.length >2){
                return "1 node is needed for an empty tree, 2 nodes separated by 1 comma ',' otherwise.";
            }
            if (pair.length == 1){
                return tree.addNode(null,new TreeNode<>(pair[0]));
            }
            TreeNode<String> parent = tree.findNode(pair[0]);
            if (parent == null & tree.getSize()!=0){
                return "Parent node " + pair[0] + " does not exist.";
            }
            TreeNode<String> child = new TreeNode<>(pair[1]);
            return tree.addNode(parent,child);

        }
        // remove a node from the tree
        if (command[0].equals("tree") & command[1].equals("Remove(node)")) {
            TreeNode<String> node = tree.findNode(command[2].replace(",",""));
            if (node == null){
                return "Node " + command[2].replace(",","") + " does not exist.";
            }
            return tree.removeNode(node);
        }

        // insert a vertex to graph
        if (command[0].equals("graph") & command[1].equals("InsertVertex(vertex)")) {
            Vertex<String> v = new Vertex<>(command[2].replace(",",""));
            return graph.insertVertex(v);
        }
        // remove a vertex from graph
        if (command[0].equals("graph") & command[1].equals("RemoveVertex(vertex)")) {
            Vertex<String> v = graph.findVertex(command[2].replace(",",""));
            if (v == null){
                return "Vertex " + command[2].replace(",","") +" does not exist.";
            }
            return graph.removeVertex(v);
        }
        // insert an edge to 2 existing vertices
        if (command[0].equals("graph") & command[1].equals("InsertEdge(vertex,vertex)")) {
            String[]vertices = command[2].split(",");
            if (vertices.length != 2){
                return "Exactly 2 vertices separated by 1 comma ',' are needed to add an edge.";
            }
            Vertex<String> u = graph.findVertex(vertices[0]);
            Vertex<String> v = graph.findVertex(vertices[1]);
            if (u==null||v==null){
                return "At least one of the vertices " + vertices[0] + " and " + vertices[1] + " does not exist.";
            }
            return graph.insertEdge(u,v,u.getElement()+v.getElement());
        }
        // remove an existing edge
        if (command[0].equals("graph") & command[1].equals("RemoveEdge(vertex,vertex)")) {
            String[]vertices = command[2].split(",");
            if (vertices.length != 2){
                return "Exactly 2 vertices separated by 1 comma ',' are needed to remove an edge.";
            }
            Vertex<String> u = graph.findVertex(vertices[0]);
            Vertex<String> v = graph.findVertex(vertices[1]);
            if (u==null||v==null){
                return "At least one of the vertices " + vertices[0] + " and " + vertices[1] + " does not exist.";
            }
            Edge<String> e = graph.getEdge(u,v);
            if (e == null){
                return "An edge between vertex " + vertices[0] + " and " + vertices[1] + " does not exist.";
            }
            return graph.removeEdge(e);
        }
        return "";
    }


}
