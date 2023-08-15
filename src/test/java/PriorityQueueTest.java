import DataStructures.PriorityItem;
import DataStructures.PriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueueTest {

    PriorityItem a = new PriorityItem(1,"a");
    PriorityItem b = new PriorityItem(4,"b");
    PriorityItem c = new PriorityItem(0,"c");
    PriorityItem d = new PriorityItem(6,"d");

    @Test
    public void testPQ(){
        PriorityQueue pq = new PriorityQueue();
        Assertions.assertEquals(0,pq.size());
    }

    @Test
    public void testInsertNull(){
        PriorityQueue pq = new PriorityQueue();
        PriorityItem pi = new PriorityItem(null,null);
        pq.insert(pi);
        Assertions.assertEquals(0,pq.size());
    }

    @Test
    public void testInsert(){
        PriorityQueue pq = new PriorityQueue();
        pq.insert(a);
        pq.insert(b);
        pq.insert(c);
        pq.insert(d);
        Assertions.assertEquals(4,pq.size());
        ArrayList<PriorityItem> exp = new ArrayList<>();
        Collections.addAll(exp,c,a,b,d);
        Assertions.assertEquals(exp,pq.getPQ());
    }

    @Test
    public void testRemoveMin(){
        PriorityQueue pq = new PriorityQueue();
        Assertions.assertNull(pq.min());
        pq.insert(a);
        pq.insert(b);
        pq.insert(c);
        pq.insert(d);
        String rm = pq.removeMin();
        Assertions.assertEquals("Item with value "+ c.getValue() + " and key " + c.getKey() + " has been removed.",rm);
        ArrayList<PriorityItem> exp = new ArrayList<>();
        Collections.addAll(exp,a,b,d);
        Assertions.assertEquals(exp,pq.getPQ());
    }
}
