package GUI;
import DataStructures.*;
import org.graphstream.graph.Graph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;


// This class is user interface, displaying graphical content and visualizing data structures from inputHandler
public class GUI implements ActionListener {
    JFrame f;
    JMenuBar mb;
    JMenu menu;
    JMenuItem list, stack, queue, pq, tree, graph;
    JPanel buttonPanel;
    JTextPane notificationLabel;

    InputHandler inputHandler;
    public GUI(InputHandler i) {
        inputHandler = i;
        f = new JFrame("GUI");

        // make a menu of data structure items
        mb = new JMenuBar();
        menu = new JMenu("Data Structures");
        list = new JMenuItem("Linked List");
        stack = new JMenuItem("Stack");
        queue = new JMenuItem("Queue");
        pq = new JMenuItem("Priority Queue");
        tree = new JMenuItem("Tree");
        graph = new JMenuItem("Graph");

        list.addActionListener(this);
        stack.addActionListener(this);
        queue.addActionListener(this);
        pq.addActionListener(this);
        tree.addActionListener(this);
        graph.addActionListener(this);

        menu.add(list);
        menu.add(stack);
        menu.add(queue);
        menu.add(pq);
        menu.add(tree);
        menu.add(graph);
        mb.add(menu);
        f.setJMenuBar(mb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(810, 850);
        f.setResizable(false);
        f.setVisible(true);

        // add buttonPanel to hold buttons
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(Color.white);

        // add notificationLabel to give user response to different input
        notificationLabel = new JTextPane();
        notificationLabel.setBounds(600, 400, 200, 450);
        notificationLabel.setBackground(Color.black);
        notificationLabel.setEditable(false);
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setForeground(attributes, Color.WHITE);
        notificationLabel.setCharacterAttributes(attributes, true);

        f.add(notificationLabel);
        f.add(buttonPanel);

    }

    // visualize data structures
    public void graphVisualizer(Graph graph, String origin){
        Component[] components = f.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                f.remove(component);
            }
        }
        SwingViewer viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);

        // myGraph and list need the autoLayout of graphStream, while others must not use it
        // (e.g, tree would not display levels if we use autoLayout)
        if (origin.equals("myGraph")||origin.equals("list")){
            viewer.enableAutoLayout();
        }
        else {
            viewer.disableAutoLayout();
        }
        View view = viewer.addDefaultView(false);
        JPanel viewComponent = (JPanel) view;
        viewComponent.setBounds(0, 0, 600, 750);

        f.add(viewComponent);
        f.add(buttonPanel);

        f.revalidate();
        f.repaint();
    }

    // Some buttons need input such as push(item) of stack, some do not such as pop() of stack
    public void makeButtonWithInput(String type, String buttonName,int x, int y){
        JTextField listInputField = new JTextField();
        listInputField.setBounds(x, y+50, 200, 50);
        buttonPanel.add(listInputField);

        JButton button = new JButton(buttonName);
        button.setBounds(x,y,200,50);
        buttonPanel.add(button);
        button.addActionListener(new ActionListener() {

            // when a button is clicked after entering some input, call inputHandler to execute commands
            public void actionPerformed(ActionEvent e) {
                String input = listInputField.getText();

                // if input is empty do nothing
                if (input.equals("")){return;}
                String[] command = new String[3];
                command[0] = type;
                command[1] = buttonName;
                command[2] = input.replace(" ","");
                String response = inputHandler.execute(command);

                // visualize the data structure
                if (type.equals("list")) {graphVisualizer(inputHandler.getList(),"list");}
                if (type.equals("stack")) {graphVisualizer(inputHandler.getStack(),"");}
                if (type.equals("queue")) {graphVisualizer(inputHandler.getQueue(),"");}
                if (type.equals("pq")) {graphVisualizer(inputHandler.getPq(),"");}
                if (type.equals("tree")) {graphVisualizer(inputHandler.getTree(),"");}
                if (type.equals("graph")) {graphVisualizer(inputHandler.getGraph(),"myGraph");}

                // clear the input field, update the notificationLabel
                listInputField.setText("");
                String currentMessage = notificationLabel.getText();
                if (!currentMessage.isEmpty()) {currentMessage += " | ";} // Add a separator if there's already a message
                currentMessage += response;
                int wordCount = currentMessage.trim().split(" ").length;
                if (wordCount > 170){
                    currentMessage=response;
                }
                notificationLabel.setText(currentMessage);
            }
        });
    }

    // similar to makeButtonWithInput, but no input is needed to execute command
    public void makeButtonWithoutInput(String type, String buttonName,int x, int y){
        JButton button = new JButton(buttonName);
        button.setBounds(x,y,200,50);
        buttonPanel.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] command = new String[2];
                command[0] = type;
                command[1] = buttonName;
                String response = inputHandler.execute(command);
                if (type.equals("list")) {graphVisualizer(inputHandler.getList(),"list");}
                if (type.equals("stack")) {graphVisualizer(inputHandler.getStack(),"");}
                if (type.equals("queue")) {graphVisualizer(inputHandler.getQueue(),"");}
                if (type.equals("pq")) {graphVisualizer(inputHandler.getPq(),"");}
                if (type.equals("tree")) {graphVisualizer(inputHandler.getTree(),"");}
                if (type.equals("graph")) {graphVisualizer(inputHandler.getGraph(),"myGraph");}
                String currentMessage = notificationLabel.getText();
                if (!currentMessage.isEmpty()) {currentMessage += " | ";} // Add a separator if there's already a message
                currentMessage += response;
                notificationLabel.setText(currentMessage);
            }
        });
    }

    // when one of the menu item is clicked, displays corresponding buttons (e.g, stack has push and pop) and visualization
    public void actionPerformed(ActionEvent e){
        buttonPanel.removeAll();
        notificationLabel.setText("The syntax is described inside the parentheses () of each button's name, refer to ReadMe for more details!");
        if (e.getSource()==list){
            makeButtonWithInput("list","InsertAfter(node,node)",600,0);
            makeButtonWithInput("list","Remove(node)",600,100);
            graphVisualizer(inputHandler.getList(),"list");
        }
        if (e.getSource()==stack){
            makeButtonWithInput("stack","Push(item)",600,0);
            makeButtonWithoutInput("stack","Pop",600,100);
            graphVisualizer(inputHandler.getStack(),"");
        }
        if (e.getSource()==queue){
            makeButtonWithInput("queue","Enqueue(item)",600,0);
            makeButtonWithoutInput("queue","Dequeue",600,100);
            graphVisualizer(inputHandler.getQueue(),"");
        }
        if (e.getSource()==pq){
            makeButtonWithInput("pq","Insert(key,value)",600,0);
            makeButtonWithoutInput("pq","RemoveMin",600,100);
            graphVisualizer(inputHandler.getPq(),"");
        }
        if (e.getSource()==tree){
            makeButtonWithInput("tree","Add(parentNode,childNode)",600,0);
            makeButtonWithInput("tree","Remove(node)",600,100);
            graphVisualizer(inputHandler.getTree(),"");
        }
        if (e.getSource()==graph) {
            makeButtonWithInput("graph","InsertVertex(vertex)",600,0);
            makeButtonWithInput("graph","RemoveVertex(vertex)",600,100);
            makeButtonWithInput("graph","InsertEdge(vertex,vertex)",600,200);
            makeButtonWithInput("graph","RemoveEdge(vertex,vertex)",600,300);
            graphVisualizer(inputHandler.getGraph(),"myGraph");
        }
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

}
