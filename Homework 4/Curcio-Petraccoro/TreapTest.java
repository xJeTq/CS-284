import static org.junit.jupiter.api.Assertions.*;

/*
 * Name: Anthony Curcio-Petraccoro 
 * Pledge: I pledge my honor that I have abided by the Stevens Honor System. 
 */

class TreapTest {
	
	/*
	 * Cannot test Node constructor directly.  
	 * Node constructor is tested within other methods, such as the add methods. 
	 */
	
	/*
	 * Cannot test rotate methods directly. 
	 * Rotate methods are tested within other methods, such as reheap, which is tested by the add methods. 
	 */
	
	
	/*
	 * Tests the first Treap constructor without any parameters.  
	 */
	
	@org.junit.jupiter.api.Test
	void Treap1() {
		
        Treap<Integer> testTree1 = new Treap<Integer>();
        Treap<Integer> testTree2 = new Treap<Integer>();
        Treap<Integer> testTree3 = new Treap<Integer>();
		
	}
	
	/*
	 * Tests the second Treap constructor with one "long" parameter. 
	 */
	
	@org.junit.jupiter.api.Test
	void Treap2() {
		
        Treap<Integer> testTree1 = new Treap<Integer>(1);
        Treap<Integer> testTree2 = new Treap<Integer>(2);
        Treap<Integer> testTree3 = new Treap<Integer>(3);
		
	}
	
	/*
	 * Cannot test reheap directly becuase reheap is private. 
	 * Reheap is tested within other methods, such as the add methods. 
	 */
	
	/*
	 * Tests the add method that takes only a key parameter. 
	 */
	
	@org.junit.jupiter.api.Test
	void add1() {
		
		// How to test this with random priorities? How to test both toString methods, reheap, borth rotate methods, node and treap methods? 

	       Treap<Integer> testTree = new Treap<Integer>();
	        
			testTree.add(4);
			testTree.add(2);
			testTree.add(6);
			testTree.add(1);
			testTree.add(3);
			testTree.add(5);
			testTree.add(7);
			testTree.add(null);

		
	}
	
	/*
	 * Tests the add method that takes in a key and a priority parameter. 
	 */

    @org.junit.jupiter.api.Test
    void add2() {
    	
        Treap<Integer> testTree = new Treap<Integer>();
        
		testTree.add(4, 19);
		testTree.add(2, 31);
		testTree.add(6, 70);
		testTree.add(1, 84);
		testTree.add(3, 12);
		testTree.add(5, 83);
		testTree.add(7, 26);
		testTree.add(null);
        
        String result = "(key=1, priority=84)\n" +
                "  null\n" +
                "  (key=5, priority=83)\n" +
                "    (key=2, priority=31)\n" +
                "      null\n" +
                "      (key=4, priority=19)\n" +
                "        (key=3, priority=12)\n" +
                "          null\n" +
                "          null\n" +
                "        null\n" +
                "    (key=6, priority=70)\n" +
                "      null\n" +
                "      (key=7, priority=26)\n" +
                "        null\n" +
                "        null\n";
        
        assertEquals(result,testTree.toString());
        
    }
    
    /*
     * Tests the delete method. 
     */

    @org.junit.jupiter.api.Test
    void delete() {
    	
        Treap<Integer> testTree = new Treap<Integer>();
        
        testTree.add(4, 19);
        testTree.add(2, 31);
        testTree.add(6, 70);
        testTree.add(1, 84);
        testTree.add(3, 12);
        testTree.add(5, 83);
        testTree.add(7, 26);
        testTree.add(null);
        testTree.delete(3);
        
        String result1 = "(key=1, priority=84)\n" +
                "  null\n" +
                "  (key=5, priority=83)\n" +
                "    (key=2, priority=31)\n" +
                "      null\n" +
                "      (key=4, priority=19)\n" +
                "        null\n" +
                "        null\n" +
                "    (key=6, priority=70)\n" +
                "      null\n" +
                "      (key=7, priority=26)\n" +
                "        null\n" +
                "        null\n";
        
        assertEquals(result1, testTree.toString());
        
        Treap<Integer> testTreeNull = new Treap<Integer>();
        
        testTreeNull.add(4, 19);
        testTreeNull.add(2, 31);
        testTreeNull.add(6, 70);
        testTreeNull.add(1, 84);
        testTreeNull.add(3, 12);
        testTreeNull.add(5, 83);
        testTreeNull.add(7, 26);
        testTreeNull.add(null);
        testTreeNull.delete(9);
        
        String result2 = "(key=1, priority=84)\n" +
                "  null\n" +
                "  (key=5, priority=83)\n" +
                "    (key=2, priority=31)\n" +
                "      null\n" +
                "      (key=4, priority=19)\n" +
                "        (key=3, priority=12)\n" +
                "          null\n" +
                "          null\n" +
                "        null\n" +
                "    (key=6, priority=70)\n" +
                "      null\n" +
                "      (key=7, priority=26)\n" +
                "        null\n" +
                "        null\n";
        
        assertEquals(result2, testTreeNull.toString());
        
    }
    
    /*
     * Tests the find method that takes in a key a Node and a key. 
     */

    @org.junit.jupiter.api.Test
    void find1() {
    	
        Treap<Integer> testTree = new Treap<Integer>();
        
        testTree.add(4, 19);
        testTree.add(2, 31);
        testTree.add(6, 70);
        testTree.add(1, 84);
        testTree.add(3, 12);
        testTree.add(5, 83);
        testTree.add(7, 26);
        testTree.add(null);
        
        assertEquals(true, testTree.find(7));
        assertEquals(false, testTree.find(9));
        
    }
    
    /*
     * Tests the find method that only takes a key parameter. 
     */
    
	@org.junit.jupiter.api.Test
	void find2() {
		
        Treap<Integer> testTree = new Treap<Integer>();
        
        testTree.add(4);
        testTree.add(2);
        testTree.add(6);
        testTree.add(1);
        testTree.add(3);
        testTree.add(5);
        testTree.add(7);
        
        assertEquals(true, testTree.find(7));
        assertEquals(false, testTree.find(9));
		
	}
	
	/*
	 * toString methods are tested within the add method. 
	 */
    
	public static void main(String[] args) {

		Treap<Integer> testTree = new Treap<Integer>();
		
		testTree.add(4, 19);
		testTree.add(2, 31);
		testTree.add(6, 70);
		testTree.add(1, 84);
		testTree.add(3, 12);
		testTree.add(5, 83);
		testTree.add(7, 26);
		
		System.out.println(testTree.toString());
		
	}
    
}

