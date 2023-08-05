
/**
 * class TreeNode. This is a TreeNode. The students should understand the structure of a binary tree node
 * 
 * @author Ronnie Young
 * @version 06-20-23
 */
public class TreeNode<E extends Comparable<E>>
{
    E data;
    TreeNode<E> parent;
    TreeNode<E> left;
    TreeNode<E> right;
    
    /**
     * constructor construct a tree node with every field as null
     */
    public TreeNode()
    {
        //represents the value stored in the node.
        this.data = null;
        //Set the parent to null.
        //parent represents the parent node.
        this.parent = null;
        //Set the left to null.
        //left represents the leftt child node.
        this.left = null;
        //Set the right to null.
        //right represents the right child node.
        this.right = null;
    }
    
    /**
     * constructor construct a tree node with all node referece null to hold given data
     * @param data The given data of type E
     */
    public TreeNode(E data)
    {
        //Initialize the data field to provided value.
        this.data = data;
        //Initialized node has no parent node to begin.
        this.parent = null;
        //Initialized node has no left child node to begin.
        this.left = null;
        //Initialized node has no right child node to begin.
        this.right = null;
    }
    
    /**
     * set this node's data as given data
     * @param data The given data of type E
     */
    public void setData(E data)
    {
        this.data = data;
    }
    
    /**
     * get this node's data
     * @return the node's data of type E
     */
    public E getData()
    {
        //Return data to get the value stored in node.
        return data;
    }
    
    /**
     * set this node's parent node as given node
     * @param parent The given node 
     */
    public void setParent(TreeNode<E> parent)
    {
        //Set node's parent 
        this.parent = parent;
    }
    
    /**
     * get this node's parent node
     * @return the node's parent node
     */
    public TreeNode<E> getParent()
    {
        return parent;
    }
    
    /**
     * set this node's left child node as given node
     * @param left The given node 
     */
    public void setLeft(TreeNode<E> left)
    {
        this.left = left;
    }
    
    /**
     * get this node's left child node
     * @return the node's left child node
     */
    public TreeNode<E> getLeft()
    {
        return left;
    }
    
    /**
     * set this node's right child node as given node
     * @param right The given node 
     */
    public void setRight(TreeNode<E> right)
    {
        this.right = right;
    }
    
    /**
     * get this node's right child node
     * @return the node's right child node
     */
    public TreeNode<E> getRight()
    {
        return right;
    }
    
    /**
     * check if this node is the left child of its parent
     * @return true if this node is the left child of its parent; false otherwise.
     * If this node is root, i.e. it has no parent, it also return false
     */
    public boolean isLeftChild(){
        return parent != null && parent.left == this;
    }
    
    /**
     * check if this node is the right child of its parent
     * @return true if this node is the right child of its parent; false otherwise.
     * If this node is root, i.e. it has no parent, it also return false
     */
    public boolean isRightChild(){
       return parent != null && parent.right == this;
    }
    
    /**
     * check if this node is a leaf
     * @return true if this node is a leaf; false otherwise.
     */
    public boolean isLeaf(){
       return left == null && right == null;
    }
    
    /**
     * check if this node is a root
     * @return true if this node is a root; false otherwise.
     */
    public boolean isRoot(){
        return parent == null;
    }
}