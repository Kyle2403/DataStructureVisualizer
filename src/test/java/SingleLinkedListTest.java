import DataStructures.SingleLinkedList;
import DataStructures.SingleNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingleLinkedListTest {
    SingleNode<String> a = new SingleNode<>("a");
    SingleNode<String> b = new SingleNode<>("b");
    SingleNode<String> c = new SingleNode<>("c");
    SingleNode<String> d = new SingleNode<>("d");
    SingleNode<String> e = new SingleNode<>("e");

    @Test
    public void testGetBack(){
        SingleLinkedList<String> ls = new SingleLinkedList<>();
        Assertions.assertNull(ls.getBack());
    }

    @Test
    public void testSize(){
        SingleLinkedList<String> ls = new SingleLinkedList<>();
        ls.insertAfter(null,a);
        Assertions.assertEquals(ls.size(),1);
        ls.insertAfter(e,b);
        Assertions.assertEquals(ls.size(),2);
    }

    @Test
    public void testInsert1(){
        SingleLinkedList<String> ls = new SingleLinkedList<>();
        ls.insertAfter(null,a);
        Assertions.assertEquals(ls.getHead(),a);
    }
    @Test
    public void testInsert2(){
        SingleLinkedList<String> ls = new SingleLinkedList<>();
        ls.insertAfter(null,a);
        ls.insertAfter(a,b);
        Assertions.assertEquals(ls.getBack(),b);
    }

    @Test
    public void testInsert3(){
        SingleLinkedList<String> ls = new SingleLinkedList<>();
        ls.insertAfter(null,a);
        ls.insertAfter(a,b);
        ls.insertAfter(e,c);
        Assertions.assertEquals(ls.getHead(),c);
        Assertions.assertEquals(ls.getBack(),b);
    }

    @Test
    public void testInsert4(){
        SingleLinkedList<String> ls = new SingleLinkedList<>();
        ls.insertAfter(null,a);
        ls.insertAfter(a,a);
        Assertions.assertEquals(ls.size(),1);
    }

    @Test
    public void testRemove1(){
        SingleLinkedList<String> ls = new SingleLinkedList<>();
        ls.insertAfter(null,a);
        ls.insertAfter(a,b);
        ls.insertAfter(b,c);
        String removed = ls.removeNode(a);
        Assertions.assertEquals(ls.getHead(),b);
        Assertions.assertEquals(removed,"Node " + a.getValue() + " has been removed.");
    }

    @Test
    public void testRemove2(){
        SingleLinkedList<String> ls = new SingleLinkedList<>();
        ls.insertAfter(null,a);
        ls.insertAfter(a,null);
        ls.insertAfter(a,b);
        ls.insertAfter(b,c);
        String removed = ls.removeNode(b);
        Assertions.assertEquals(ls.getHead(),a);
        Assertions.assertEquals(ls.getBack(),c);
        Assertions.assertEquals(ls.getHead().getNext(),c);
        Assertions.assertEquals(removed,"Node " + b.getValue() + " has been removed.");
    }

    @Test
    public void testRemove3(){
        SingleLinkedList<String> ls = new SingleLinkedList<>();
        String removed = ls.removeNode(c);
        Assertions.assertEquals(removed,"Node " + c.getValue() + " does not exist.");
        ls.insertAfter(null,a);
        ls.insertAfter(a,b);
        ls.insertAfter(b,c);
        ls.insertAfter(c,d);
        String removed2 = ls.removeNode(c);
        Assertions.assertEquals(ls.getHead(),a);
        Assertions.assertEquals(ls.getBack(),d);
        Assertions.assertEquals(ls.getHead().getNext(),b);
        Assertions.assertEquals(removed2,"Node " + c.getValue() + " has been removed.");
    }

    @Test
    public void testFindNode(){
        SingleLinkedList<String> ls = new SingleLinkedList<>();

        Assertions.assertNull(ls.findNote(a.getValue()));
        ls.insertAfter(null,a);
        Assertions.assertEquals(ls.findNote(a.getValue()),a);
    }
}
