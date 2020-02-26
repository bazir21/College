import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author	 Bair Buyrchiyev
 *  @version HT 2020
 *									Insert		Selection		MergeRecursive		MergeIterative		Quick
 *	numbers10						0.33ms		0ms				0.33ms				0ms					0ms
 *	numbers100						0.33ms		0.33ms			0					0.33ms				0ms
 *	numbers1000						1.33ms		2ms				0.33ms				0.33ms				0.33ms
 *	numbers1000Duplicates			2ms			2ms				0.66ms				0.33ms				0.33ms
 *	numbersNearlyOrdered1000		0ms			0ms				0ms					0ms					5ms
 *	numbersReverse1000				0.66ms		0ms				0ms					0ms					0ms
 *	numbersSorted1000				0.33ms		2ms				0.66ms				0ms					0ms
 *`	AVERAGE RUN TIME:				0.714ms		0.9ms			0.285ms				0.142ms				0.808ms
 *
 *
 *
 *
 *	a. Which of the sorting algorithms does the order of input have an impact on? Why?
 *			
 *			Quicksort, because it will check the pivot value against each value, which in this case is already sorted so it will run through every single value
 *
 *
 *	b. Which algorithm has the biggest difference between the best and worst performance, based
 *		on the type of input, for the input of size 1000? Why?
 *			
 *			SelectionSort has the biggest difference based on the size of the input
 *			
 *	c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
 *		based on the input size? Please consider only input files with random order for this answer.
 *		
 *			SelectionSort has the worst scalability as it went from 0ms to 2ms run time
 *			QuickSort and MergeSortIterative have the best scalability as it only went up to 0.33ms each for 1000 items
 *		
 *	d. Did you observe any difference between iterative and recursive implementations of merge
 *		sort?
 *		
 *			MergeSortRecursive ran longer on the already sorted array and with the duplicates
 *		
 *	e. Which algorithm is the fastest for each of the 7 input files?
 *		
 *			MergeSortIterative
 */

@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    
    @Test
    public void testEmpty()
    {
    	double[] emptyArray = new double[0];
    	assertArrayEquals(emptyArray, SortComparison.insertionSort(emptyArray), 0);
    	assertArrayEquals(emptyArray, SortComparison.selectionSort(emptyArray), 0);
    	assertArrayEquals(emptyArray, SortComparison.quickSort(emptyArray), 0);
    	assertArrayEquals(emptyArray, SortComparison.mergeSortIterative(emptyArray), 0);
    	assertArrayEquals(emptyArray, SortComparison.mergeSortRecursive(emptyArray), 0);
    }

    @Test
    public void testInsertionSort() {
    	double[] testArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    	double[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    	assertArrayEquals(sortedArray, SortComparison.insertionSort(testArray), 0);
    }
    
    @Test
    public void testSelectionSort() {
    	double[] testArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    	double[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    	assertArrayEquals(sortedArray, SortComparison.selectionSort(testArray), 0);
    }
    
    @Test
    public void testQuickSort() {
    	double[] testArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    	double[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    	assertArrayEquals(sortedArray, SortComparison.quickSort(testArray), 0);
    }
    
    @Test
    public void testMergeSortIterative() {
    	double[] testArray = {10, 3, 8, 2, 6, 5, 4, 9, 7, 1};
    	double[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    	assertArrayEquals(sortedArray, SortComparison.mergeSortIterative(testArray), 0);
    }
    
    @Test
    public void testMergeSortRecursive() {
    	double[] testArray = {10, 3, 8, 2, 6, 5, 4, 9, 7, 1};
    	double[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    	assertArrayEquals(sortedArray, SortComparison.mergeSortRecursive(testArray), 0);
    	
    	double[] testArray1 = null;
    	assertArrayEquals(null, SortComparison.mergeSortRecursive(testArray1), 0);
    }
    
    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     * @throws IOException 
     *
     */
    public static void main(String[] args) throws IOException 
    {
        File file = new File(".\\src\\numbersSorted1000.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        double[] array = new double[1000];
        int i = 0;
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
        	array[i++] = Double.parseDouble(line);
        }
        double timeStart = 0, timeEnd = 0;
        
        double[] testArray = array;
        timeStart = System.currentTimeMillis();
        for (i = 0; i < 3; i++) {
        	SortComparison.insertionSort(testArray);
        }
        timeEnd = System.currentTimeMillis();
        System.out.println("Insertion Sort: " + ((timeEnd - timeStart) / 3));
        
        
        testArray = array;
        timeStart = System.currentTimeMillis();
        for (i = 0; i < 3; i++) {;
        	SortComparison.selectionSort(testArray);
        }
        timeEnd = System.currentTimeMillis();
        System.out.println("Selection Sort: " + ((timeEnd - timeStart) / 3));
        
        
        testArray = array;
        timeStart = System.currentTimeMillis();
        for (i = 0; i < 3; i++) {
        	SortComparison.quickSort(testArray);
        }
        timeEnd = System.currentTimeMillis();
        System.out.println("Quick Sort: " + ((timeEnd - timeStart) / 3));
        
        
        testArray = array;
        timeStart = System.currentTimeMillis();
        for (i = 0; i < 3; i++) {
        	SortComparison.mergeSortIterative(testArray);
        }
        timeEnd = System.currentTimeMillis();
        System.out.println("Merge Sort Iterative: " + ((timeEnd - timeStart) / 3));
        
        
        testArray = array;
        timeStart = System.currentTimeMillis();
        for (i = 0; i < 3; i++) {
        	SortComparison.mergeSortRecursive(testArray);
        }
        timeEnd = System.currentTimeMillis();
        System.out.println("Merge Sort Recursive: " + ((timeEnd - timeStart) / 3));
        
        reader.close();
    }

}
