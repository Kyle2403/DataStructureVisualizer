import DataStructures.SingleNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingleNodeTest {

    @Test
    public void test(){
        SingleNode<String> a = new SingleNode<>("a");
        SingleNode<String> b = new SingleNode<>("b");
        a.setNext(b);
        Assertions.assertEquals(a.getValue(),"a");
        Assertions.assertEquals(a.getNext(),b);
        a.setValue("a2");
        Assertions.assertEquals(a.getValue(),"a2");

    }
}
