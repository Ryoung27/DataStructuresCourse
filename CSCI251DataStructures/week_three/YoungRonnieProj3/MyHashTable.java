
/**
 * class MyHashTable. A simple HashTable. Handle collision by chain
 * 
 * @author Ronnie Young
 * @version June 18, 2023
 */
import java.util.ArrayList;

public class MyHashTable<K extends Comparable<K>, V>
{
    private ArrayList<MyHashEntry<K, V>> table; //ArrayList to store the buckets.
    private int count; // how many elements in table
    
    /**
     * Constructor. Constructor an empty MyHashTable with given number of Buckets
     * @param tableSize The number of Buckets of the table
     */
    public MyHashTable(int tableSize){
       this.table = new ArrayList<>(tableSize);
       for (int i = 0; i < tableSize; i++){
           table.add(null);
       }
       this.count = 0;
    }
    
    /**
     * constructor. Construct an empty MyHashTable with capacity 10 buckets
     */
    public MyHashTable(){
       this(10);
    }
    
    /**
     * get the number of elements in the table
     * @return the number of elements in the table
     */
    public int size(){
       return count;
    }
    
    /**
     * clear the table
     */
    public void clear(){
        for(int i = 0; i < table.size(); i++){
            table.set(i, null);
        }
        count = 0;
    }
    
    /**
     * get the value with given key.
     * @param key The given key
     * @return the value that have the key matches the given key. If no such a value, return null
     */
    public V get(K key){
       for (MyHashEntry<K, V> entry : table){
           while (entry != null){
               if(entry.getKey().equals(key)){
                   return entry.getValue();
               }
               entry = entry.getNext();
           }
       }
       return null; //Key was not found.
    }
    
    /**
     * insert (key, value) pair into the table
     * @param key The key of the pair
     * @param value The value of the pair
     */
    public void insert(K key, V value){
        if (table == null) {
        table = new ArrayList<>();
        table.add(null);
    }

        int index = Math.abs(key.hashCode()) % table.size();
        MyHashEntry<K, V> entry = table.get(index);

        // Check if the key is already in the table.
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return; // Key already exists.
            }
            if (entry.getNext() == null) {
                break; // End of the list.
            }
            entry = entry.getNext();
        }

        // If the key doesn't exist, add a new entry at the end of the bucket.
        MyHashEntry<K, V> newEntry = new MyHashEntry<>(key, value);
        if (entry == null) {
            table.set(index, newEntry); // Use set() instead of add()
        } else {
            entry.setNext(newEntry);
        }
        count++;
    }
    
    /**
     * remove the value with given key from the table
     * @param key The given key
     * @return the value whose key matches the given key. If no such value, null is returned
     */
    public V remove(K key){
        int index = Math.abs(key.hashCode()) % table.size();
        MyHashEntry<K, V> entry = table.get(index);
        MyHashEntry<K, V> prev = null;

        while(entry != null){
            if(entry.getKey().equals(key)){
                if(prev == null){
                    table.add(index, entry.getNext());
                }else{
                    prev.setNext(entry.getNext());
                }
                count--;
                return entry.getValue();
            }
            prev = entry;
            entry = entry.getNext();
        }
        return null;
    }
    
    /**
     * check if the table is empty,i.e. no entry
     * @return true if the table holds no elements; false otherwise
     */
    public boolean isEmpty(){
        return count == 0;
    }
    
    /**
     * return a String representation of the table
     * @return a String representation of the table
     */
    public String toString(){
        StringBuilder stringBuild = new StringBuilder();
        for(int i = 0; i < table.size(); i++){
            stringBuild.append("Bucket ").append(i).append(": ");

            MyHashEntry<K, V> entry = table.get(i);
            if(entry == null){
                stringBuild.append("\n");
                continue;
            }

            while(entry != null){
                stringBuild.append(entry.getValue()).append(" ");
                entry = entry.getNext();
            }

            stringBuild.append("\n");
        }

        return stringBuild.toString();
    
    }
}