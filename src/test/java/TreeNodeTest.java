import DataStructures.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TreeNodeTest {

    @Test
    public void testNode(){
        TreeNode<String> a = new TreeNode<>("a");
        Assertions.assertNull(a.getParent());
        ArrayList<TreeNode<String>> exp = new ArrayList<>();
        Assertions.assertEquals(a.getChildren(),exp);
        Assertions.assertEquals(a.getValue(),"a");
        a.setValue("b");
        Assertions.assertEquals(a.getValue(),"b");
    }

    public void testSize(){
        TreeNode<String> a = new TreeNode<>("a");
        Assertions.assertEquals(a.getSubSize(),1);
        a.setSubSize(2);
        Assertions.assertEquals(a.getSubSize(),2);
    }
}
