/*
 * Name: Anthony Curcio-Petraccoro
 * Date: 2/8/2023
 * Pledge: I pledge my honor that I have abided by the Stevens Honor System. 
 */


public class BinaryNumber {

	private int[] data;
	private int length;
	
	/*
	 * Constructor method that takes in a length and creates a binary number of inputted length with 0s.  
	 */
	
	public BinaryNumber(int length) {
		
		if (length <= 0) {
			
			throw new IllegalArgumentException("The length must be greater than 0.");
			
		} else {
			
			data = new int[length];
		
			for (int i = 0; i < length; i ++) {
			
				this.data[i] = 0;
			
			}
		
		}
		
		this.length = data.length;
		
	}
	
	/*
	 * Constructor method that takes in the string representation of a binary number. 
	 */
	
	public BinaryNumber(String str) {
		
		data = new int[str.length()];
		
		for (int i = 0; i < str.length(); i ++) {
			
			if (str.charAt(i) != 48 && str.charAt(i) != 49) {
				
				throw new IllegalArgumentException("Binary number must only contain 1's and 0's");
				
			}
			
			this.data[i] = Character.getNumericValue(str.charAt(i));
			
		}
		
		this.length = data.length;
		
	}
	
	/*
	 * Returns the length of a binary number. 
	 */
	
	public int getLength() {
		
		return this.length;
		
	}
	
	/*
	 * Returns the binary number in an integer array. 
	 */
	
	public int[] getInnerArray() {
		
		this.length = data.length;
		return data;
		
	}
	
	/*
	 * Returns a specific digit of a binary number. 
	 */
	
	public int getDigit(int index) {
		
		if (index >= this.getLength() || index < 0) {
			
			throw new ArrayIndexOutOfBoundsException("The index you chose is invalid.");
			
		}
		
		int[] binaryArray = getInnerArray();
		
		this.length = data.length;
		return binaryArray[index];
		
	}
	
	/*
	 * Returns the decimal value of a binary number. 
	 */
	
	public int getDecimal() {
		
		int decimal = 0;
		int count = 0;
		
		for (int i = this.length - 1; i >= 0; i --) {
			
			if (data[i] == 1) {
								
				decimal += Math.pow(2, count);
								
			} else {
				
				decimal += 0;
				
			}
						
			count ++;
			
		}
		
		this.length = data.length;
		return decimal;
		
	}
	
	/*
	 * Shifts a binary number left or right and takes in a specific shift amount. 
	 */
	
	public void bitShift(int direction, int amount) { // DOESN'T WORK. 
		
		if (direction != -1 && direction != 1) {
			
			throw new IllegalArgumentException("Direction value must be equal to -1 or 1.");
			
		}
		
		if (amount < 0) {
			
			throw new IllegalArgumentException("Amount value must be greater than 0");
			
		}
				
		if (direction == -1) {
			
			int[] newData = new int[this.length + amount];
			
			for (int i = this.length; i < newData.length; i ++) {
				
				newData[i] = 0; 
				
			}
			
			data = newData;
			
		} else {
						
			int[] newData = new int[this.length - amount];
			
			for (int j = 0; j < newData.length; j ++) {
				
				newData[j] = data[j];
				
			}
			
			data = newData;
			
		}
		
		this.length = data.length;
				
	}
	
	/*
	 * Returns the bitwise OR representation of two binary numbers. 
	 */
	
	public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2) {
		
		if (bn1.getLength() != bn2.getLength()) {
			
			throw new IllegalArgumentException("The two binary numbers must be the same size.");
			
		}
		
		int newData[] = new int[bn1.getLength()];
		
		for (int i = 0; i < newData.length; i ++) {
			
			if (bn1.getDigit(i) == 1 || bn2.getDigit(i) == 1) {
				
				newData[i] = 1;
				
			} else {
				
				newData[i] = 0;
				
			}
			
		}
		
		return newData;
		
	}
	
	/*
	 * Returns the bitwise AND representation of two binary numbers. 
	 */
	
	public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
		
		if (bn1.getLength() != bn2.getLength()) {
			
			throw new IllegalArgumentException("The two binary numbers must be the same size.");
			
		}
		
		int newData[] = new int[bn1.getLength()];
		
		for (int i = 0; i < newData.length; i ++) {
			
			if (bn1.getDigit(i) == 1 && bn2.getDigit(i) == 1) {
				
				newData[i] = 1;
				
			} else {
				
				newData[i] = 0;
				
			}
			
		}
		
		return newData;
		
	}
	
	/*
	 * Prepends 0s to the beginning of an array. Returns the new array.  
	 */
	
	public void prepend(int amount) {
		
		int[] change = new int[this.length + amount];
		
		for (int i = 0; i < amount; i ++) {
			
			change[i] = 0;
			
		}
		
		int count = 0;
		
		for (int j = amount; j < change.length; j ++) {
			
			change[j] = data[count];
			count ++;
			
		}
		
		data = change;
		this.length = data.length;
		
	}
	
	/*
	 * Adds two binary numbers together. 
	 */
	
	public void add(BinaryNumber aBinaryNumber) { // FIX! 
		
		if (this.length > aBinaryNumber.length) {
			
			int difference = this.length - aBinaryNumber.getLength();
			aBinaryNumber.prepend(difference);
			
		} else if (this.length < aBinaryNumber.length) {
			
			int difference = (aBinaryNumber.getLength() - this.length);
			this.prepend(difference);
			
		}
		
		int carry = 0;
		int addedBinary[] = new int[this.length];
		
		if (aBinaryNumber.getLength() == this.length) {
			
			for (int i = this.length - 1; i > -1; i --) {
				
				if ((this.getDigit(i) + aBinaryNumber.getDigit(i) + carry) == 0) {
					
					addedBinary[i] = 0;
					carry = 0;
					
				} else if ((this.getDigit(i) + aBinaryNumber.getDigit(i) + carry) == 3) {
					
					addedBinary[i] = 1;
					carry = 1;
					
				} else if ((this.getDigit(i) + aBinaryNumber.getDigit(i) + carry) == 2) {
					
					addedBinary[i] = 0;
					carry = 1;
					
				} else if ((this.getDigit(i) + aBinaryNumber.getDigit(i) + carry) == 1) {
					
					addedBinary[i] = 1;
					carry = 0;
					
				}
				
			}
			
			if (carry > 0) {
				
				int[] carryBinary = new int[(addedBinary.length + 1)];
				carryBinary[0] = carry;
				
				for (int k = 1; k < carryBinary.length; k ++) {
					
					carryBinary[k] = addedBinary[k - 1];
					
				}
			
				this.data = carryBinary;
				this.length = data.length;
				
			} else {
				
				this.data = addedBinary;
				this.length = data.length;
				
			}
			
		}
				
	}
	
	/*
	 * Returns a string representation of a binary number. 
	 */
	
	@Override
	public String toString() {
		
		String binaryNumber = "";
		
		for (int i = 0; i < this.length; i ++) {
			
			binaryNumber += data[i];
			
		}
		
		this.length = data.length;
		return binaryNumber;
		
	}
	
}
