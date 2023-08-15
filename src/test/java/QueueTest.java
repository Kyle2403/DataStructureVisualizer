import DataStructures.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QueueTest {

    @Test
    public void testQueue(){
        Queue<String> Queue = new Queue<>();
        Assertions.assertTrue(Queue.isEmpty());
    }

    @Test
    public void testEnqueueDequeue(){
        Queue<String> Queue = new Queue<>();
        Assertions.assertEquals(Queue.dequeue(),"The queue is empty.");
        Assertions.assertNull(Queue.first());
        Queue.enqueue("Hello");
        Assertions.assertEquals(Queue.size(),1);
        String dequeue = Queue.dequeue();
        Assertions.assertEquals(dequeue,"Hello has been dequeued.");
    }

    @Test
    public void testFirst(){
        Queue<String> Queue = new Queue<>();
        Queue.enqueue("Hello");
        String first = Queue.first();
        Assertions.assertEquals(first,"Hello");
        Assertions.assertEquals(Queue.size(),1);
    }

    @Test
    public void testReSize(){
        Queue<String> Queue = new Queue<>();
        while (Queue.size()<10){
            Queue.enqueue("Hello"+Queue.size());
        }
        Queue.enqueue("Resize");
        Assertions.assertEquals(Queue.size(),11);
    }

    @Test
    public void testArray(){
        Queue<String> Queue = new Queue<>();
        Queue.enqueue("Hello");
        String first = Queue.first();
        Queue.enqueue("Goodbye");
        Queue.enqueue("Hi");
        Queue.enqueue("HiAgain");
        String de = Queue.dequeue();
        String[] expected = {"Goodbye", "Hi", "HiAgain"};
        Assertions.assertEquals(de, "Hello has been dequeued.");
        Assertions.assertEquals(Arrays.toString(Queue.getQueue()),Arrays.toString(expected));
    }
}
