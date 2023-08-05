/**
 * CSCI251ProjOne. 
 * 
 * @author Ronnie Young
 * @version June 08, 2023
 */
import java.util.*;

public class MySorts{
    public static void insertSort(int[] array){
        int numberSize = array.length; //Size of array

        //Generate a loop over the length of our array.
        for (int i  = 1; i < numberSize; i++){
            int temp = array[i]; //temp variable for swap.
            int j = i - 1;
            // Insert numbers[j] into sorted part
            // stopping once numbers[j] in correct position
            while(j >= 0 && array[j] > temp){
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = temp;
        }
    }

    public static void selectSort(int[] array){
        int numberSize = array.length;
        int temp = 0; // Temporary variable for swap
        
        for (int i = 0; i < numberSize - 1; i++) {
            // Find index of smallest remaining element
            int indexSmallest = i;
            for (int j = i + 1; j < numberSize; j++) {
                if (array[j] < array[indexSmallest]) {
                    indexSmallest = j;
                }
            }
            // Swap numbers[i] and numbers[indexSmallest]
            //Preserve element at indexSmallest.
            temp = array[indexSmallest];
            //Move smallest element found so far to it's position.
            array[indexSmallest] = array[i];
            //Complete the swap.
            array[i] = temp;
        }
    }

    public static void quickSort(int[] array){
        int numberSize = array.length;
        int lowIndex = 0;
        int highIndex = numberSize-1;

        quickSortRecursive(array, lowIndex, numberSize - 1);
        
    }

    public static void mergeSort(int[] array){
        int numberSize = array.length;
        int lowIndex = 0;
        mergeSortRecursive(array, lowIndex, numberSize - 1);
    }

private static void merge(int[] arr, int start, int middle, int end) {
    int leftSize = middle - start + 1;  // Size of left partition
    int rightSize = end - middle;       // Size of right partition
    
    int[] mergedNumbers = new int[leftSize + rightSize];  // Temporary array for merged numbers
    int mergePos = 0;   // Position to insert merged number
    int leftPos = start;   // Position of elements in left partition
    int rightPos = middle + 1;  // Position of elements in right partition
    
    // Add the smallest element from the left or right partition to mergedNumbers
    while (leftPos <= middle && rightPos <= end) {
        if (arr[leftPos] <= arr[rightPos]) {
            mergedNumbers[mergePos] = arr[leftPos];
            leftPos++;
        } else {
            mergedNumbers[mergePos] = arr[rightPos];
            rightPos++;
        }
        mergePos++;
    }
    
    // If the left partition is not empty, add the remaining elements to mergedNumbers
    while (leftPos <= middle) {
        mergedNumbers[mergePos] = arr[leftPos];
        leftPos++;
        mergePos++;
    }
    
    // If the right partition is not empty, add the remaining elements to mergedNumbers
    while (rightPos <= end) {
        mergedNumbers[mergePos] = arr[rightPos];
        rightPos++;
        mergePos++;
    }
    
    // Copy the merged numbers back to the original array
    for (int i = 0; i < mergePos; i++) {
        arr[start + i] = mergedNumbers[i];
    }
}

    private static void mergeSortRecursive(int[] arr, int begin, int end){
        int j = 0;
        
        if (begin < end) {
            j = (begin + end) / 2;  // Find the midpoint in the partition
            
            // Recursively sort left and right partitions
            mergeSortRecursive(arr, begin, j);
            mergeSortRecursive(arr, j + 1, end);
            
            // Merge left and right partition in sorted order
            merge(arr, begin, j, end);
        }    

    }

private static int pivot(int[] arr, int begin, int end) {
    // Pick middle element as pivot
    int midpoint = begin + (end - begin) / 2;
    int pivot = arr[midpoint];
    
    boolean done = false;
    while (!done) {
        // Increment lowIndex while arr[begin] < pivot
        while (arr[begin] < pivot) {
            begin += 1;
        }
        
        // Decrement end while pivot < arr[end]
        while (pivot < arr[end]) {
            end -= 1;
        }
        
        // If zero or one elements remain, then all numbers are 
        // partitioned. Return end.
        if (begin >= end) {
            done = true;
        } else {
            // Swap arr[begin] and arr[end]
            int temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            
            // Update lowIndex and highIndex
            begin += 1;
            end -= 1;
        }
    }
    
    return end;
}

    private static void quickSortRecursive(int[] arr, int begin, int end){
        // Base case: If the partition size is 1 or zero 
        // elements, then the partition is already sorted
        if (begin >= end) {
            return;
        }
        
        // Partition the data within the array. Value begin
        // returned from partitioning is the index of the low 
        // partition's last element.
        int lowEndIndex = pivot(arr, begin, end);
        
        // Recursively sort low partition (lowIndex to lowEndIndex) 
        // and high partition (lowEndIndex + 1 to highIndex)
        quickSortRecursive(arr, begin, lowEndIndex);
        quickSortRecursive(arr, lowEndIndex + 1, end);
    }
}