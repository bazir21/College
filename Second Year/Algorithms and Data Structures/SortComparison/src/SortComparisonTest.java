import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
        //TODO: implement this method
    }

}
