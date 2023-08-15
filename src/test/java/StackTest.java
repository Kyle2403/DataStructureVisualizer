import DataStructures.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StackTest {

    @Test
    public void testStack(){
        Stack<String> stack = new Stack<>();
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    public void testpushpop(){
        Stack<String> stack = new Stack<>();
        Assertions.assertEquals(stack.pop(),"The stack is empty.");
        Assertions.assertNull(stack.top());
        stack.push("Hello");
        Assertions.assertEquals(stack.size(),1);
        String pop = stack.pop();
        Assertions.assertEquals(pop,"Hello has been popped.");
        Assertions.assertEquals(stack.size(),0);
    }

    @Test
    public void testTop(){
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        String top = stack.top();
        Assertions.assertEquals(top,"Hello");
    }

    @Test
    public void testReSize(){
        Stack<String> stack = new Stack<>();
        while (stack.size()<10){
            stack.push("Hello"+stack.size());
        }
        stack.push("Resize");
        Assertions.assertEquals(stack.size(),11);
    }

    @Test
    public void testArray(){
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        String top = stack.top();
        stack.push("Goodbye");
        stack.push("Hi");
        stack.pop();
        String[] expected = {"Hello", "Goodbye"};
        Assertions.assertEquals(Arrays.toString(stack.getStack()),Arrays.toString(expected));
    }
}
