package DataStructures;
import GUI.GUI;

public class Main {
    public static void main(String[]args) {
        System.setProperty("org.graphstream.ui", "swing");

        // initiate handler for user input and pass it to GUI
        InputHandler handler = new InputHandler();
        GUI GUI = new GUI(handler);
        }
}
