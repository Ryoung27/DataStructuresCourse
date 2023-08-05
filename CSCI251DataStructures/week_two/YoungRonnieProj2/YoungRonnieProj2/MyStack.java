/**
 * class MyStack: A stack class implemented by using ArrayList
 * All stack elements are stored in an ArrayList. The top element
 * has index top
 * 
 * @author Ronnie Young
 * @version 06-16-23
 */
import java.util.ArrayList;

public class MyStack<E>
{
    //A stack is an ADT in which items are only inserted on or removed from the top of a stack.
    //-push: Input: Stack and element. Inserts element on top of stack. 
    //-pop: Input: Stack. Output: Returns and removes item at top of stack.
    //-peek: Input: Stack. Output: Returns but does not remove item at top of stack.
    //-getSize: Input: Stack. Output: Returns true if stack has no items.
    //-isEmpty Input: Stack. Output: Returns the number of items in the stack.
        
    private ArrayList<E> list; // used to store elements in stack
    private int top; // the index of top element
    
    /**
     * constructor construct an empty stack
     */
    public MyStack()
    {
        list = new ArrayList<>();
        top = -1;
    }
    
    /**
     * push push a given element on the top of the stack
     */
    public void push(E item)
    {
        list.add(item); //Add the element to the end of the list.
        top++; //Increment the top pointer.
    }
    
    /**
     * isEmpty return true if the stack is empty; false otherwise
     * @return true if the stack is empty; false otherwise
     */
    public boolean isEmpty()
    {
        return top == -1; //If top is -1 it is empty, else it is not.
    }
    
    /**
     * peek Return the top element
     */
    public E peek()
    {
        //Return the list element at top to do a "peek" of the stack.
       return list.get(top);
    }
    
    /**
     * pop Remove the top element from the stack. If the stack is empty,nothing happen
     */
    public void pop()
    {
        //Pop off the last element of the list.
       list.remove(top); 
       top--;
    }
    
    /**
     * size return the size of the stack
     * @return number of elements in stack
     */
    public int size()
    {
        return list.size();
    }
}