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
		return quickSort(shuffle(a), 0, a.length - 1);
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
			swap(a, i, j);
		}
		return a;
	}
	
	private static int partition(double a[], int low, int high) {
		double pivot = a[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (a[j] <= pivot) {
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i+1, high);
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
		for (int currentSize = 1; currentSize <= a.length - 1; currentSize *= 2) {
			for (int leftStart = 0; leftStart < a.length - 1; leftStart += (2 * currentSize)) {
				int mid = Math.min(leftStart + currentSize - 1, a.length - 1);
				int rightEnd = Math.min(leftStart + (2 * currentSize) - 1, a.length - 1);
				merge(a, leftStart, mid, rightEnd);
			}
		}
		return a;
	}
	
	private static void merge(double a[], int start, int middle, int end) {
		int n1 = middle - start + 1;
		int n2 = end - middle;
		double[] left = new double[n1];
		double[] right = new double[n2];
		
		for (int i = 0; i < n1; i++) left[i] = a[start + i];
		for (int i = 0; i < n2; i++) right[i] = a[middle + i + 1];
		
		int i = 0, j = 0;
		int k = start;
		
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) a[k++] = left[i++];
			else a[k++] = right[j++];
		}
		
		while (i < n1) a[k++] = left[i++];
		while (j < n2) a[k++] = right[j++];
	}
	
	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted order.
	 */
	static double[] mergeSortRecursive (double a[]) {
		if (a == null) return a;
		
		if (a.length > 1) {
			int mid = a.length / 2;
			double[] left = new double[mid];
			for (int i = 0; i < mid; i++) left[i] = a[i];
			
			double[] right = new double[a.length - mid];
			for (int i = mid; i < a.length; i++) right[i - mid] = a[i];
			
			mergeSortRecursive(left);
			mergeSortRecursive(right);
			
			int i = 0; int j = 0; int k = 0;
			while (i < left.length && j < right.length) {
				if (left[i] < right[j]) a[k++] = left[i++];
				else a[k++] = right[j++];
			}
			while (i < left.length) a[k++] = left[i++];
			while (j < right.length) a[k++] = right[j++];
		}
		return a;
	}

	public static void main(String[] args) {
		
	}

}
