import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
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
     *
     */
    public static void main(String[] args)
    {
        File file = new File("numbers10.txt");
        BufferedReader reader = new BufferedReader(new FileReader("numbers10.txt"));
        
    }

}
