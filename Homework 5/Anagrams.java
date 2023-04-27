import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Name: Anthony Curcio-Petraccoro 
 * Pledge: I pledge my honor that I have abided by the Stevens Honor System. 
 */

public class Anagrams {
	
	final Integer[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
	Map<Character,Integer> letterTable;
	Map<Long,ArrayList<String>> anagramTable;

	/*
	 * Constructs the anagram object. 
	 */
	
	public Anagrams() {
		
		buildLetterTable();
		anagramTable = new HashMap<Long,ArrayList<String>>();
		
	}
	
	/*
	 * Builds the letter table in terms of a hash. Uses ascii values and prime numbers. 
	 */
	
	public void buildLetterTable() { 
		
		int aAscii = 97;
		int bound = 0;
		
		letterTable = new HashMap();
		
		while (bound < 26) {
			
			letterTable.put((char) aAscii, primes[bound]);
			aAscii ++;
			bound ++;
			
		}
		
		// System.out.println(letterTable);
		
	}
	
	/*
	 * Checks to see if a word is already in the map. Properly adds the word to the map or discards it based on hash value. 
	 */
	
	private int wordChecker(String s, long hash) {
		
		if (anagramTable.containsKey(hash) == true && anagramTable.get(hash).contains(s) == true) {
							
				return 0;
			
		} else if (anagramTable.containsKey(hash) == true && anagramTable.get(hash).contains(s) == false) {
			
			return 1;
			
		} else {
		
			return 2;
			
		}
				
	}
	
	/*
	 * Computes the hash code of an inputted string. Then adds it to the hash table.  
	 */

	public void addWord(String s) {  
		    
		ArrayList<String> word = new ArrayList<String>();
		long hash = myHashCode(s);
		
		if (s == null || s == "") {
			
			throw new IllegalArgumentException("Input is null.");
			
		} 
		
		if (wordChecker(s, hash) == 0) {
			
			throw new IllegalArgumentException("Word already exists.");	
			
		} 
		
		if (wordChecker(s, hash) == 1) {
				
			anagramTable.get(hash).add(s);
			
		} 
		
		if (wordChecker(s, hash) == 2) {
				
			word.add(s);
			anagramTable.put(hash, word);

		}
				
	}
	
	/*
	 * Computes the hash code of a string. 
	 */
	
	public long myHashCode(String s) {
		
		/* long hash = s.hashCode();
		
		System.out.println(hash);
		
		return hash; */
		    
		/* if (s == null) {
			
			throw new IllegalArgumentException("Input is empty.");
			
		} else if (s.length() == 1) {
			
			return (long) letterTable.get(s.charAt(0));
			
		} else {
			
			return (long) letterTable.get(s.charAt(0)) * this.myHashCode(s.substring(1, s.length()));
			
		} */ 
		
		long hash = 1;
		
		if (s == "" || s == null) {
			
			throw new IllegalArgumentException("Input is empty or null.");
			
		} else {
			
			int bound = 0;
			
			while (bound < s.length()) {
				
				hash *= letterTable.get(s.charAt(bound));
				bound ++;
				
			}
			
		}
					
		return hash;
		
	}
		
	/*
	 * Processes the text file and properly formats it. 
	 */
	
	public void processFile(String s) throws IOException {
		
		FileInputStream fstream = new FileInputStream(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		
		while ((strLine = br.readLine()) != null)   {
			
		  this.addWord(strLine);
		  
		}
		
		br.close();
		
	}
	
	/*
	 * Checks to see if the array size of the words of the anagram is larger than the pre-established max size. 
	 */
	
	private int getMaxEntriesHelper(int arraySize, int maxSize) {
		
		if (arraySize == maxSize) {
			
			return 0;
			
		} 
		
		if (arraySize > maxSize) {
			
			return 1;
			
		}
		
		return -1;
		
	}
	
	/*
	 * Returns the entries in the anagram table with the largest number of anagrams. 
	 */
			
	public ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries() {  
			
		ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries = new ArrayList<Map.Entry<Long,ArrayList<String>>>();
		ArrayList<String> words;
		int maxHash = 0;
		
		for (Map.Entry<Long,ArrayList<String>> element: anagramTable.entrySet()) {
			
			words = element.getValue();
			
			if (getMaxEntriesHelper(words.size(), maxHash) == 0) {
				
				maxEntries.add(element);
				
			} 
			
			if (getMaxEntriesHelper(words.size(), maxHash) == 1) {
				
				maxHash = words.size();
				
				maxEntries.clear();
				maxEntries.add(element);
				
			}
			
		}
		
		return maxEntries;
		
	}
	
	/*
	 * Tests the functionality of the methods implemented above. 
	 */
	
	public static void main(String[] args) {
		
		Anagrams a = new Anagrams();

		final long startTime = System.nanoTime();
		
		try {
			
			a.processFile("words_alpha.txt");
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
			
		}
		
		ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries = a.getMaxEntries();
		final long estimatedTime = System.nanoTime() - startTime;
		final double seconds = ((double) estimatedTime/1000000000);
		System.out.println("Time: "+ seconds);
		System.out.println("List of max anagrams: "+ maxEntries);
		
	}
	
}

