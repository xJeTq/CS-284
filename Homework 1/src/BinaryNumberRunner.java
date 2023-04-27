
public class BinaryNumberRunner {

	public static void main(String[] args) {

		BinaryNumber num1 = new BinaryNumber(4);
		BinaryNumber num2 = new BinaryNumber("101010");
		BinaryNumber num3 = new BinaryNumber("110011001100");
		BinaryNumber num4 = new BinaryNumber("1010");
		BinaryNumber num5 = new BinaryNumber("1100");
		BinaryNumber num6 = new BinaryNumber("01101");
		BinaryNumber num7 = new BinaryNumber("01001");
		BinaryNumber num8 = new BinaryNumber("10110");
		BinaryNumber num9 = new BinaryNumber("11101");
		//BinaryNumber num10 = new BinaryNumber("2023"); - Works 
		
		System.out.println("getLength: \n");
		System.out.println(num1.getLength() + " - Should print 4 \n");
		System.out.println(num2.getLength() + " - Should print 6 \n");
		
		System.out.println("getInnerArray: \n");
		
		for (int i = 0; i < num1.getLength(); i ++) {
			
			System.out.println(num1.getInnerArray()[i]);
			
		}
		
		System.out.println(" - Should print 0000 \n");
		
		for (int j = 0; j < num2.getLength(); j ++) {
			
			System.out.println(num2.getInnerArray()[j]);
			
		}
		
		System.out.println(" - Should print 101010 \n");
		
		for (int k = 0; k < num3.getLength(); k ++) {
			
			System.out.println(num3.getInnerArray()[k]);
			
		}
		
		System.out.println(" - Should print 110011001100 \n");
		
		System.out.println(num1.getDigit(1) + " - Should print 0 \n");
		System.out.println(num2.getDigit(2) + " - Should print 1 \n");
		System.out.println(num3.getDigit(3) + " - Should print 0 \n");
		
		System.out.println("getDecimal: \n");
		System.out.println(num1.getDecimal() + " - Should print 0 \n");
		System.out.println(num2.getDecimal() + " - Should print 42 \n");
		System.out.println(num3.getDecimal() + " - Should print 3276 \n");
		
		System.out.println("bitShift: \n");
		//num1.bitShift(-2, 1); - Works 
		//num1.bitShift(-1, -1); - Works  
		System.out.println(num1.toString());
		num1.bitShift(-1, 1);
		System.out.println(num1.toString() + " - Should print 00000 \n");
		System.out.println(num2.toString());
		num2.bitShift(1, 3);
		System.out.println(num2.toString() + " - Should print 101 \n");
		
		
		System.out.println("bwor: \n");
		//System.out.println(BinaryNumber.bwor(num1, num2)); - Works 
		for (int i = 0; i < num4.getLength(); i ++) {
			
			System.out.print(BinaryNumber.bwor(num4, num5)[i]);
			
		}
		System.out.println(" - Should print 1110 \n");
		
		System.out.println("bwand: \n");
		//System.out.println(BinaryNumber.bwand(num1, num2)); - Works 
		for (int j = 0; j < num4.getLength(); j ++) {
			
			System.out.print(BinaryNumber.bwand(num4, num5)[j]);
			
		}
		
		System.out.println(" - Should print 1000 \n");
		
		System.out.println("add: \n");
		num4.add(num5);
		System.out.println(num4 + " - Should print 10110" + "\n");
		
		System.out.println("toString: \n");
		System.out.println(num1.toString() + " - Should print 00000 \n");
		System.out.println(num2.toString() + " - Should print 101 \n");
		System.out.println(num3.toString() + " - Should print 110011001100 \n");
		
	}

}
