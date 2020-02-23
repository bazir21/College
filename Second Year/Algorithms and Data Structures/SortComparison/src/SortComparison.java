import java.util.Random;

// -------------------------------------------------------------------------


/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double[] insertionSort (double a[]) {
		for (int i = 1; i < a.length; i++) { 
            double key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
		return a;
	}

	/**
	 * Sorts an array of doubles using Selection Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] selectionSort (double a[]) {
		for (int i = 0; i < a.length - 1; i++) 
		{
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) { 
					min = j;
				}
			}
			double temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
		return a;
	}

	/**
	 * Sorts an array of doubles using Quick Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] quickSort (double a[]) {
		return quickSort(shuffle(a), 0, a.length / 2);
	}
	
	private static double[] quickSort(double a[], int low, int high) {
		if (low < high) {
			int part = partition(a, low, high);
			a = quickSort(a, low, part - 1);
			a = quickSort(a, part + 1, high);
		}
		return a;
	}
	
	private static double[] shuffle(double a[]) {
		Random random = new Random();
		for (int i = a.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			double temp = a[i];
			a[j] = a[i];
			a[i] = temp;
		}
		return a;
	}
	
	private static int partition(double a[], int low, int high) {
		double pivot = a[high];
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (a[j] <= pivot) {
				i++;
				swap(a, j, i);
			}
		}
		swap(a, i + 1, high);
		return i + 1;
	}
	
	private static void swap(double a[], int i, int j) {
		double temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return;
	}

	/**
	 * Sorts an array of doubles using Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted order.
	 */

	static double[] mergeSortIterative (double a[]) {
		
		
		
		
		
		
		return a;
	}
	
	private void merge(double a[], int start, int middle, int end) {
		int n1 = middle - start + 1;
		int n2 = end - middle;
		double[] left = new double[n1];
		double[] right = new double[n2];
		
		for (int i = 0; i < middle; i++) left[i] = a[i];
		for (int i = middle + 1; i < end; i++) right[i] = a[i];
		
		
	}
	
	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted order.
	 */
	static double[] mergeSortRecursive (double a[]) {
		return a;
	}

	public static void main(String[] args) {
		
	}

}
