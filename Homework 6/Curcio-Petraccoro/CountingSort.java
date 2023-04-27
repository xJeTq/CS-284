package count;

import java.util.Arrays;

/*
 * Name: Anthony Curcio-Petraccoro 
 * Pledge: I pledge my honor that I have abided by the Stevens Honor System. 
 */

public class CountingSort {
	
	/*
	 * Sorts an unsorted array with O(n) efficiency. 
	 */
	
	public static int[] sort(int[] A) {
		
	    if (A == null || A.length == 0) {
	    	
	        throw new IllegalArgumentException("The inputted array is empty");
	        
	    }
	    
	    int max = A[0];
	    
	    for (int i = 1; i < A.length; i++) {
	    	
	        if (A[i] > max) {
	        	
	            max = A[i];
	            
	        }
	        
	    }
	    
	    int[] count = new int[max + 1];
	    
	    for (int j = 0; j < A.length; j++) {
	    	
	    	int temp = count[A[j]];
	        temp ++;
	        count[A[j]] = temp;
	        
	    }
	    
	    for (int k = 1; k < count.length; k++) {
	    	
	        count[k] += count[k - 1];
	        
	    }
	    
	    int[] output = new int[A.length];
	    
	    for (int l = A.length - 1; l >= 0; l--) {
	    	
	        output[count[A[l]] - 1] = A[l];
	        int temp = count[A[l]];
	        temp --;
	        count[A[l]] = temp;
	        
	    }
	    
	    for (int m = 0; m < A.length; m++) {
	    	
	        A[m] = output[m];
	        
	    }
	    
    	/* for (int n = 0; n < A.length; n ++) {
    		
    		System.out.print(A[n] + " ");
    		
    	}
    	
    	System.out.println(); */
	    
	    return A;
    	
	}
	
	/*
	 * Prints an array. Implemented for testing purposes. 
	 */
	
    /* public static void print(int[] arr) {
    	
    	for (int i = 0; i < arr.length; i ++) {
    		
    		System.out.print(arr[i] + " ");
    		
    	}
    	
    	// System.out.println();
    	
    } */
	
}
