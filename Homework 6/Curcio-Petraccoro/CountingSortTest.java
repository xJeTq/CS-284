package count;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import count.CountingSort;

/*
 * Name: Anthony Curcio-Petraccoro 
 * Pledge: I pledge my honor that I have abided by the Stevens Honor System. 
 */

class CountingSortTest {
	
	/*
	 * Tests the sort algorithm. 
	 */
	
	@org.junit.jupiter.api.Test
	void sort1() {
				
		int[] arr1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		int[] sortedArr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		/* System.out.println("Test #1:");
		
		count.CountingSort.print(arr1);
		System.out.println("- Unsorted");
		count.CountingSort.print(sortedArr1);
		System.out.println("- Originally Sorted");
		count.CountingSort.sort(arr1);
		System.out.println("- Originally Unsorted");
		
		System.out.println("\n"); */
		
		assertEquals(Arrays.toString(sortedArr1), Arrays.toString(count.CountingSort.sort(arr1)));
		
	}
	
	/*
	 * Tests the sort algorithm. 
	 */
	
	@org.junit.jupiter.api.Test
	void sort2() {
		
		int[] arr2 = {3, 6, 9, 0, 1, 4, 7};
		int[] sortedArr2 = {0, 1, 3, 4, 6, 7, 9};
		
		/* System.out.println("Test #2:");

		count.CountingSort.print(arr2);
		System.out.println("- Unsorted");		
		count.CountingSort.print(sortedArr2);
		System.out.println("- Originally Sorted");
		count.CountingSort.sort(arr2);
		System.out.println("- Originally Unsorted");
		
		System.out.println("\n"); */
		
		assertEquals(Arrays.toString(sortedArr2), Arrays.toString(count.CountingSort.sort(arr2)));
		
	}
	
	/*
	 * Tests the sort algorithm. 
	 */
	
	@org.junit.jupiter.api.Test
	void sort3() {
		
		int[] arr3 = {0, 20, 10, 30, 70, 40, 60, 50, 80, 90};
		int[] sortedArr3 = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
						
		/* System.out.println("Test #3:");
		
		count.CountingSort.print(arr3);
		System.out.println("- Unsorted");		
		count.CountingSort.print(sortedArr3);
		System.out.println("- Originally Sorted");
		count.CountingSort.sort(arr3);
		System.out.println("- Originally Unsorted");
		
		System.out.println("\n"); */
		
		assertEquals(Arrays.toString(sortedArr3), Arrays.toString(count.CountingSort.sort(arr3)));
		
	}

	/*
	 * Tests the sort algorithm. 
	 */
	
	@org.junit.jupiter.api.Test
	void sort4() {
		
		int[] arr4 = {2, 5, 3, 0, 2, 3, 0, 3};
		int[] sortedArr4 = {0, 0, 2, 2, 3, 3, 3, 5};
						
		/* System.out.println("Test #4:");
		
		count.CountingSort.print(arr4);
		System.out.println("- Unsorted");		
		count.CountingSort.print(sortedArr4);
		System.out.println("- Originally Sorted");
		count.CountingSort.sort(arr4);
		System.out.println("- Originally Unsorted");
		
		System.out.println("\n"); */
		
		assertEquals(Arrays.toString(sortedArr4), Arrays.toString(count.CountingSort.sort(arr4)));
		
	}

	/*
	 * Tests the sort algorithm. 
	 */
	
	@org.junit.jupiter.api.Test
	void sort5() {
		
		int[] arr5 = {176, 59, 441, 192, 551, 521, 699};
		int[] sortedArr5 = {59, 176, 192, 441, 521, 551, 699};
						
		/* System.out.println("Test #5:");
		
		count.CountingSort.print(arr5);
		System.out.println("- Unsorted");		
		count.CountingSort.print(sortedArr5);
		System.out.println("- Originally Sorted");
		count.CountingSort.sort(arr5);
		System.out.println("- Originally Unsorted");
		
		System.out.println("\n"); */
		
		assertEquals(Arrays.toString(sortedArr5), Arrays.toString(count.CountingSort.sort(arr5)));
		
	}
	
	@org.junit.jupiter.api.Test
	void sort6() {
		
		int[] arr6 = {0, 1, 1, 3, 5, 6};
		int[] sortedArr6 = {0, 1, 1, 3, 5, 6};
						
		/* System.out.println("Test #4:");
		
		count.CountingSort.print(arr4);
		System.out.println("- Unsorted");		
		count.CountingSort.print(sortedArr4);
		System.out.println("- Originally Sorted");
		count.CountingSort.sort(arr4);
		System.out.println("- Originally Unsorted");
		
		System.out.println("\n"); */
		
		assertEquals(Arrays.toString(sortedArr6), Arrays.toString(count.CountingSort.sort(arr6)));
		
	}
	
	@org.junit.jupiter.api.Test
	void sort7() {
		
		int[] arr7 = {1, 1, 1, 0, 0, 0, 2, 2, 2, 4, 4, 4, 3, 3, 3, 5, 5, 5, 7, 7, 7, 6, 6, 6, 8, 8, 8, 9, 9, 9, 10, 10, 10};
		int[] sortedArr7 = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10};
						
		/* System.out.println("Test #4:");
		
		count.CountingSort.print(arr4);
		System.out.println("- Unsorted");		
		count.CountingSort.print(sortedArr4);
		System.out.println("- Originally Sorted");
		count.CountingSort.sort(arr4);
		System.out.println("- Originally Unsorted");
		
		System.out.println("\n"); */
		
		assertEquals(Arrays.toString(sortedArr7), Arrays.toString(count.CountingSort.sort(arr7)));
		
	}

}
