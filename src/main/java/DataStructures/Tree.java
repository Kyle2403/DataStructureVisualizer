package DataStructures;
import java.util.ArrayList;

public class Tree<T> {
    private int size;
    private TreeNode<T> root;

    public Tree(){
        this.size = 0;
        this.root = null;
    }
    public TreeNode<T> getRoot(){
        return root;
    }
    public int getSize(){
        return size;
    }
    public boolean isRoot(TreeNode<T> node){
        if (node == null) { return false; }
        return node.isRoot();
    }

    /*
    Add child node to a node in the tree
    Increase the size of the tree by 1 here as well
    */
    public String addNode(TreeNode<T> parent, TreeNode<T> child){
        if (nodeExists(child)){
            return "Node "+ child.getValue() + " has already existed";
        }
        if (this.size == 0 & child != null & parent == null){
            this.root = child;
            size++;
            return "Node "+ child.getValue()+ " has been added as root, since the tree is empty";
        }
        if(child == null){
            return "No child node given";
        }
        if (!nodeExists(parent)){
            return "Parent node does not exist";
        }
        parent.addChild(child);
        size++;
        TreeNode<T> current = child;
        while (current.getParent()!=null){
            current = current.getParent();
            current.setSubSize(current.getSubSize()+1);
        }
        return "Node "+ child.getValue() + " has been added as child of " + parent.getValue();
    }
    public boolean nodeExists(TreeNode<T> node){
        if (node == null||this.size == 0 ){
            return false;
        }
        if (node == this.root){
            return true;
        }
        ArrayList<TreeNode<T>> ls = new ArrayList<>();
        this.postorder(this.root,ls);
        for (TreeNode<T> n: ls){
            if (n.getValue().equals(node.getValue())){
                return true;
            }
        }
        return false;

    }
    /*
    Remove the subtree rooted at the given node from the tree
    If node is the root node, set the tree's root to be None
    Make sure each node's subtree size is appropriately updated
    */
    public String removeNode(TreeNode<T> node){
        if (this.size == 0){
            return "The tree is empty.";
        }
        if (!this.nodeExists(node)){
            return "Node does not exist.";
        }
        if (this.isRoot(node)){
            this.root = null;
            this.size = 0;
            ArrayList<TreeNode<T>> ls = new ArrayList<>();
            this.preorder(node,ls);
            for (int i = 0; i <ls.size(); i++){
                for (TreeNode<T> n: ls){
                    if (ls.get(i).getChildren().contains(n)){
                        ls.get(i).removeChild(n);
                    }
                }
            }
            return "Root node " + node.getValue() + " has been removed, the entire tree is deleted." ;
        }
        TreeNode<T> current = node;
        int subsize = current.getSubSize();
        while (current.getParent()!=null){
            current = current.getParent();
            current.setSubSize(current.getSubSize()-subsize);
        }
        TreeNode<T> parent = node.getParent();
        parent.removeChild(node);
        ArrayList<TreeNode<T>> ls = new ArrayList<>();
        this.preorder(node,ls);
        for (int i = 0; i <ls.size(); i++){
            for (TreeNode<T> n: ls){
                if (ls.get(i).getChildren().contains(n)){
                    ls.get(i).removeChild(n);
                }
            }
        }
        this.size -= subsize;
        return "Node " + node.getValue() + " ,along with its subtree has been removed.";
    }

    /*
    Preorder traversal of the tree starting from the node given
    Note: Add a newly visited node to the END of the supplied list
    */
    public void preorder(TreeNode<T> node, ArrayList<TreeNode<T>> ls){
        if (node == null){
            return;
        }
        ls.add(node);
        for (TreeNode<T> child : node.getChildren()){
            this.preorder(child,ls);
        }

    }
    /*
    Postorder traversal of the tree
    Note: Add a newly visited node to the END of the supplied list
    */
    public void postorder(TreeNode<T> node, ArrayList<TreeNode<T>> ls){
        if (node == null){
            return;
        }
        for (TreeNode<T> child : node.getChildren()){
            this.postorder(child,ls);
        }
        ls.add(node);
    }

    public TreeNode<T> findNode(T v){
        ArrayList<TreeNode<T>> ls = new ArrayList<>();
        preorder(this.root,ls);
        for (TreeNode<T> node: ls){
            if (node.getValue().equals(v)){
                return node;
            }
        }
        return null;
    }
}
