
/**
 * BinearySearchTree. Represent a binary search tree
 * The student cannot change the public interface
 * 
 * @author Ronnie Young
 * @version 06-20-23
 */

import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree<E extends Comparable<E>>
{
    TreeNode<E> root; // the root of the tree
    
    /**
     * constructor create a empty binary search tree by setting root to be null
     */
    public BinarySearchTree(){
        root = null;
    }
    
    /**
     * search the given data in this binary search tree
     * If the data is found, return a reference to the tree node
     * othewise, return null
     * @param data The target to search
     * @return a TreeNode reference to the node that contains the data
     *         if no node contains data, return null
     */
    public TreeNode<E> search(E data){
        TreeNode<E> current = root;

        while(current != null){
            int compar = data.compareTo(current.getData());

            if(compar == 0){
                //Found occurence we are looking for.
                return current;
            } else if (compar < 0){
                //Data we are looking for is smaller, so go left.
                current = current.getLeft();
            } else{
                //data we are looking for is larger, so go right.
                current = current.getRight();
            }
        }
        //Could not find anything.
        return null;
    }
    
    /**
     * insert given node to this binary search tree. If this tree 
     * was empty, the given node becomes the root of this tree.
     * @param newNode the given node to be inserted
     */
    public void insert(TreeNode<E> newNode){
        if(root == null){
            //Empty so we make the newNode the root.
            root = newNode;
        } else{
            //Tree was not empty.
            TreeNode<E> current = root;
            TreeNode<E> parent;

            while (true){
                parent = current;

                int compar = newNode.getData().compareTo(current.getData());
                if (compar < 0){
                    //The newNode is smaller, so we go to the left subtree.
                    current = current.getLeft();
                    if (current == null){
                        parent.setLeft(newNode);
                        newNode.setParent(parent);
                        return;
                    }
                } else {
                    //The newNode is greater, so we go to the right subtree.
                    current = current.getRight();
                    if (current == null){
                        parent.setRight(newNode);
                        newNode.setParent(parent);
                        return;
                    }
                }
            }
        }
    }
    
    /**
     * insert given data to this binary search tree. If this tree 
     * was empty, the given node becomes the root of this tree.
     * @param data the given data to be inserted
     */
    public void insert(E data){
        TreeNode<E> newNode = new TreeNode<>(data);
        insert(newNode);
    }
    
    /**
     * remove the given data from this binary search tree and return
     * true. If the data is not in the tree, return false
     */
    public boolean remove(E data){
        TreeNode<E> nodeToRemove = search(data);
        if(nodeToRemove == null){
            return false;
        }

        TreeNode<E> parent = nodeToRemove.getParent();
        if(nodeToRemove.getLeft() == null && nodeToRemove.getRight() == null){
            if (parent == null){
                root = null;
            } else if (nodeToRemove.isLeftChild()){
                parent.setLeft(null);
            } else{
                parent.setRight(null);
            }
        } else if(nodeToRemove.getLeft() == null || nodeToRemove.getRight() == null){
            TreeNode<E> child = (nodeToRemove.getLeft() != null) ? nodeToRemove.getLeft() : nodeToRemove.getRight();
            if (parent == null){
                root = child;
            } else if (nodeToRemove.isLeftChild()){
                parent.setLeft(child);
            } else{
                parent.setRight(child);
            }
            child.setParent(parent);
        } else {
            TreeNode<E> successorParent = nodeToRemove;
            TreeNode<E> successor = nodeToRemove.getRight();
            while(successor.getLeft() != null){
                successorParent = successor;
                successor = successor.getLeft();
            }
            if (successorParent != nodeToRemove){
                successorParent.setLeft(successor.getRight());
                if(successor.getRight() != null){
                    successor.getRight().setParent(successorParent);
                }
                successor.setRight(nodeToRemove.getRight());
            }
            if (parent == null){
                root = successor;
            } else if (nodeToRemove.isLeftChild()){
                parent.setLeft(successor);
            } else{
                parent.setRight(successor);
            }
            successor.setParent(parent);
            successor.setLeft(nodeToRemove.getLeft());
            nodeToRemove.getLeft().setParent(successor);
        }
        return true;
    }
    
    /**
     * return a string representation of the tree
     * @return a String representation of the tree
     */
    public String toString(){
        if(root == null){
            return "";
        }
        StringBuilder finalString = new StringBuilder();
        TreeNode<E> current = root;
        TreeNode<E> predecessor;

        while (current != null){
            if(current.getLeft() == null){
                finalString.append(current.getData()).append(" ");
                current = current.getRight();
            } else{
                predecessor = current.getLeft();
                while (predecessor.getRight() != null && predecessor.getRight() != current) {
                predecessor = predecessor.getRight();
            }
                        if (predecessor.getRight() == null) {
                predecessor.setRight(current);
                current = current.getLeft();
            } else {
                predecessor.setRight(null);
                finalString.append(current.getData()).append(" ");
                current = current.getRight();
                }    
            }
        }
        return finalString.toString().trim();
    }
    
    /**
     * return true if the tree is empty. False otherwise
     * @return true if the tree is empty; false othewise
     */
    public boolean isEmpty(){
        return root == null;
    }
    
    /**
     * return the height of the tree. Notice the height is defined as
     * the length of the longest path from nodes to root
     * @return the height of the tree
     */
    public int height(){
        if(root == null){
            return 0;
        }

        int height = 0;
        Queue<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();

            while(levelSize > 0){
                TreeNode<E> currentNode = queue.poll();

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }

                levelSize--;
            }
            height++;
        }

        return height;
    }
    
    /**
     * return the number of nodes in the tree
     * @return the number of nodes in this tree
     */
    public int size(){
        if (root == null){
            return 0;
        }

        int size = 0;
        Queue<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode<E> currentNode = queue.poll();
            size++;

            if (currentNode.left != null){
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null){
                queue.offer(currentNode.right);
            }
        }
        return size;
    }
}