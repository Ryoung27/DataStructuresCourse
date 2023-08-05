/**
 * class MyQueue implemented using ArrayList. The index 0 element is the front of the queue
 * The last element of the queue has index tail
 * @author Ronnie Young
 * @version 06-16-23
 */
import java.util.ArrayList;

public class MyQueue<E>
{
    private ArrayList<E> list; // hold the elements in queue
    private int tail; // index of the last element in queue
    
    /**
     * constructor construct an empty queue
     */
    public MyQueue()
    {
        list = new ArrayList<>();
        tail = 0;
    }
    
    /**
     * isEmpty return true if the queue is empty; false otherwise
     * @return true if the queue is empty; false otherwise
     */
    public boolean isEmpty()
    {
        return tail == 0; //If tail is 0 it is empty, else it is not.

    }
    
    /**
     * size return the size of the queue
     * @return the number of elements in queue
     */
    public int size()
    {
        return tail;
    }
    
    /**
     * peek return the front element of the queue
     * @return the front element of the queue. If the queue is empty, return null
     */
    public E peek()
    {
        return list.get(0);
    }
    
    /**
     * pop remove the front element of the queue
     */
    public void pop()
    {
       list.remove(0);
       tail--;
    }
    
    /**
     * push push a new element to the queue
     */
    public void push(E item)
    {
        list.add(item);
        tail++;
    }
}