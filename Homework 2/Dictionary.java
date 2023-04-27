import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Dictionary {
	
	String file1 = "ionDictionary.txt";
	String file2 = "exampleOutput.txt";
	String s = "";
	
	/*
	 * 
	 * The string array list "wordList" contains every word present in the Ion Dictionary in alphabetical order. 
	 * The DictionaryItem array list "dicArrayList" contains every word and its word count in the Ion Dictionary in alphabetical order. 
	 * 
	 */

	private ArrayList<String> wordList;
	private ArrayList<DictionaryItem> dicArrayList;
	
	/*
	 * 
	 * Constructs a string arraylist and DictionaryItem array list, both with sizes 1300. Directs to readFile, which reads a generic text file. 
	 * 
	 */
	
	public Dictionary() {
				
		this.wordList = new ArrayList<String>(1300);
		this.dicArrayList = new ArrayList<DictionaryItem>(1300);
		readFile(file1);
		
	}
	
	/*
	 * 
	 * Constructs a string arraylist and DictionaryItem array list, both with sizes 1300. Takes in a text file name to be read in readFile. 
	 * 
	 */
	
	public Dictionary(String filename) {
		
		this.wordList = new ArrayList<String>(1300);
		this.dicArrayList = new ArrayList<DictionaryItem>(1300);
		readFile(filename);
		
	}
	
	/*
	 * 
	 * Reads a text file and throws a FileNotFound error if there is not text file in the directory. 
	 * 
	 */
	
	public void readFile(String filename) {
		
		try {
			File file = new File(filename);
			Scanner in = new Scanner(file);
			splitStoreLine(in);
			
		} catch(FileNotFoundException e) {
			
			System.out.println("File is not found.");
			System.out.println(e);
		}
		
	}
	
	/*
	 * 
	 * Properly splits and strips the text file to be stored in the wordList array list and DictionaryItem array list. wordList stores the word, and DictionaryItem stores the word and how many times it occurs.  
	 * 
	 */
	
	private void splitStoreLine(Scanner scan) {
		
		String newWord = "";
		String count = "";
		String line;
		for(int i = 0; i < 4; ++i) scan.nextLine();
		do {
			try {
				line = scan.nextLine();
			} catch(NoSuchElementException nsee) {
				break;
			}
			
			newWord = line.split("\\|")[0].strip();
			count = line.split("\\|")[1].strip();
			
			DictionaryItem temp = new DictionaryItem(newWord, Integer.parseInt(count));
			
			wordList.add(newWord);
			dicArrayList.add(temp);
		} while(true);
	
		
	}
	
	/*
	 * 
	 * Asks the user which option they would like. (1) prints list of words that appear. (2) takes in a word and returns how many times it appears. (3) exits the program.  
	 * 
	 */
		
	public void printMenu() {
		
		System.out.println("Welcome to the Ion Dictionary! This dictionary is created from the book Ion by Plato!");

		Scanner input = new Scanner(System.in);	
		
		int ans;
		
		do {
			
			System.out.println("Please choose one of the following menu items indicated with 1-3");
			System.out.println("1: To print all the words in the dictionary, choose 1");	
			System.out.println("2: To search a word in the dictionary, choose 2");
			System.out.println("3: To quit the program, choose 3");
			
			ans = input.nextInt();

			if (ans != 1 && ans != 2 && ans != 3) {
				
//				throw new IllegalArgumentException("ERROR! Please enter a number between 1 and 3.\r\n");
				System.out.print("ERROR! Please enter a number between 1 and 3.\n");
				
			}
			
			processMenuItem(ans, input);
			
		} while(ans != 3);
				
		System.out.println("Thanks for using Ion Dictionary! Bye!");
	
	}
	
	/*
	 * 
	 *  Process the user's input and directs the program to the proper functions. Returns 'true' if user inputs (1) or (2), and outputs 'false' if they input (3). 
	 * 
	 */
	
	private boolean processMenuItem(int menuItem, Scanner scan) {
		
		Scanner input = new Scanner(System.in);
					
		if (menuItem == 1) {
			
			System.out.println("All the words mentioned in the Ion book!\nWords\n-----");
			
			printDictionary();
			
			return true;
			
		} 
		
		if (menuItem == 2) {
			
			System.out.print("Please enter the word you would like to search:\n");
			String ans1 = input.nextLine();
			searchDictionary(ans1);
			
			return true;
				
		}
		
		return false;
		
	}
	
	/*
	 * 
	 * Prints wordList, which is the entire dictionary of words.  
	 * 
	 */
	
	public void printDictionary() {
		
		for (int i = 0; i < wordList.size(); i ++) {
			
			System.out.println(wordList.get(i));
			
		}
		
	}
	
	/*
	 * 
	 * Calls the binarySearch method to find the word. Handles user input and returning the proper count or null value to the user. 
	 * 
	 */
	
		public int searchDictionary(String word) {
			
			int index = binarySearch(word, 0, wordList.size());
			int counter = -1;
		
			if (index == -1) {
			
				System.out.print("The word '" + word + "' does not exist in the Ion dictionary!\n");
			
			}
		
			if (index >= 0) {
			
				counter = dicArrayList.get(index).getCount();
				System.out.println("The word '" + word + "' occurred " + counter + " times in the book!");	
			
			}
		
				return counter;
		
		}
		
	/*
	 * 
	 * Uses the Binary Search Algorithm to find a specific value within an array. Returns the index of the inputted word. 
	 * 
	 */
	
	private int binarySearch(String word, int low, int high) { 

	    int mid;

	    while (low <= high) {
	    	
	        mid = (low + high) / 2;

	        if (wordList.get(mid).compareTo(word) < 0) {
	        	
	            low = mid + 1;
	            
	        } else if (wordList.get(mid).compareTo(word) > 0) {
	        	
	            high = mid - 1;
	            
	        } else {
	        	
	            return mid;
	            
	        }
	    }

	    return -1;
		
	}
		
}
