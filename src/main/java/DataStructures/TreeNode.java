package DataStructures;
import java.util.ArrayList;

public class TreeNode<T> {
    private TreeNode<T> parent;
    private T value;
    private ArrayList<TreeNode<T>> children;
    private int subSize;
    private int level;
    public TreeNode(T v){
        this.parent = null;
        this.value = v;
        this.children = new ArrayList<>();
        subSize = 1;

    }
    public T getValue(){
        return this.value;
    }

    public void setValue(T v){
        this.value = v;
    }

    public int getSubSize(){
        return subSize;
    }

    public void setSubSize(int subSize){
        this.subSize = subSize;
    }
    public TreeNode<T> getParent(){
        return this.parent;
    }
    public void setLevel(){
        int level = 0;
        TreeNode<T> current = this;
        while (current.getParent()!= null){
            level++;
            current = current.getParent();
        }
        this.level = level;
    }

    public int getLevel(){
        return this.level;
    }

    public void addChild(TreeNode<T> child){
        this.children.add(child);
        child.parent = this;
        child.setLevel();
    }

    public void removeChild(TreeNode<T> child){
        this.children.remove(child);
        child.parent = null;
    }

    public ArrayList<TreeNode<T>> getChildren(){
        return this.children;
    }

    public boolean isRoot(){
        return this.parent == null;
    }
    public int offSetFromParent(){
        if (this.parent == null){
            return 0;
        }
        TreeNode<T> parent = this.getParent();
        ArrayList<TreeNode<T>> children = parent.getChildren();
        int i = 0;
        while (i<children.size()){
            if (this == children.get(i)){
                break;
            }
            i++;
        }


        return (i - children.size() +1);
    }
}
