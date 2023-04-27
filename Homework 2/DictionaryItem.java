public class DictionaryItem {
	
	/*
	 * 
	 * The string "word" contains a single word in the Ion Dictionary. 
	 * The int "count" contains the occurences of the word in Ion Dictionary. 
	 * 
	 */

	private String word;
	private int count;
	
	/*
	 * 
	 * Constructs the DictionaryItem. 
	 * 
	 */
	
	public DictionaryItem(String word, int count) {
		
		this.word = word;
		this.count = count;
		
	}
	
	/*
	 * 
	 * Returns the word from DictionaryItem. 
	 * 
	 */
	
	public String getWord() {
		
		return this.word;
		
	}
	
	/*
	 * 
	 * Returns the count from DictionaryItem. 
	 * 
	 */
	
	public int getCount() {
		
		return this.count;
		
	}
	
	/*
	 * 
	 * Sets the word in DictionaryItem. 
	 * 
	 */
	
	public void setWord(String word) {
		
		this.word = word;
		
	}
	
	/*
	 * 
	 * Sets the count in DictionaryItem. 
	 * 
	 */
	
	public void setCount(int count) {
		
		this.count = count;
		
	}
	
}
