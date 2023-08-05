/**
 * CSCI251ProjOne. 
 * 
 * @author Ronnie Young
 * @version June 08, 2023
 */
import java.util.*;

public class MySorts{
    public static void insertSort(int[] array){
        //Generate a loop over the length of our array.
        for (int i  = 1; i < array.length; i++){
            int temp = numbers[i]; //temp variable for swap.
            int j = i = 1;
            while(j >= 0 && array[j] > temp){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }

    public static void selectSort(int[] array){

    }

    public static void quickSort(int[] array){
        
    }

    public static void mergeSort(int[] array){
        
    }


}