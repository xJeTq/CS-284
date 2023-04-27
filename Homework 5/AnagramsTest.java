import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * Name: Anthony Curcio-Petraccoro 
 * Pledge: I pledge my honor that I have abided by the Stevens Honor System. 
 */

class AnagramsTest {
	
	/*
	 * Tests the Anagram class. 
	 */

	@org.junit.jupiter.api.Test
	void test1() {
		
		Anagrams anagram = new Anagrams();
		
		long hashA = anagram.myHashCode("a");
		long hashB = anagram.myHashCode("b");
		long hashC = anagram.myHashCode("c");
		long hashD = anagram.myHashCode("d");
		long hashE = anagram.myHashCode("e");
		long hashF = anagram.myHashCode("f");
		long hashG = anagram.myHashCode("g");
		long hashH = anagram.myHashCode("h");
		long hashI = anagram.myHashCode("i");
		long hashJ = anagram.myHashCode("j");
		long hashK = anagram.myHashCode("k");
		long hashL = anagram.myHashCode("l");
		long hashM = anagram.myHashCode("m");
		long hashN = anagram.myHashCode("n");
		long hashO = anagram.myHashCode("o");
		long hashP = anagram.myHashCode("p");
		long hashQ = anagram.myHashCode("q");
		long hashR = anagram.myHashCode("r");
		long hashS = anagram.myHashCode("s");
		long hashT = anagram.myHashCode("t");
		long hashU = anagram.myHashCode("u");
		long hashV = anagram.myHashCode("v");
		long hashW = anagram.myHashCode("w");
		long hashX = anagram.myHashCode("x");
		long hashY = anagram.myHashCode("y");
		long hashZ = anagram.myHashCode("z");

		assertEquals(hashA, 2);
		assertEquals(hashB, 3);
		assertEquals(hashC, 5);
		assertEquals(hashD, 7);
		assertEquals(hashE, 11);
		assertEquals(hashF, 13);
		assertEquals(hashG, 17);
		assertEquals(hashH, 19);
		assertEquals(hashI, 23);
		assertEquals(hashJ, 29);
		assertEquals(hashK, 31);
		assertEquals(hashL, 37);
		assertEquals(hashM, 41);
		assertEquals(hashN, 43);
		assertEquals(hashO, 47);
		assertEquals(hashP, 53);
		assertEquals(hashQ, 59);
		assertEquals(hashR, 61);
		assertEquals(hashS, 67);
		assertEquals(hashT, 71);
		assertEquals(hashU, 73);
		assertEquals(hashV, 79);
		assertEquals(hashW, 83);
		assertEquals(hashX, 89);
		assertEquals(hashY, 97);
		assertEquals(hashZ, 101);

	}
	
	/*
	 * Tests the Anagram class. 
	 */
	
	@org.junit.jupiter.api.Test
	void test2() {
		
		Anagrams anagram = new Anagrams();
		
		long longHash = anagram.myHashCode("cz");
		
		assertEquals(longHash, (long) 505);
		
	}
	
	/*
	 * Tests the Anagram class. 
	 */
	
	@org.junit.jupiter.api.Test
	void test3() {
		
		Anagrams anagram = new Anagrams();
		
		assertEquals(anagram.letterTable.size(), 26);
		assertEquals(anagram.anagramTable.size(), 0);
		
	}
	
	/*
	 * Tests the Anagram class. 
	 */
	
	@org.junit.jupiter.api.Test
	void test4() {
		
		Anagrams anagram = new Anagrams();
		
		anagram.addWord("a");
		
		assertThrows(IllegalArgumentException.class, () -> { anagram.addWord("a");});
		
	}
	
	/*
	 * Tests the Anagram class. 
	 */
	
	@org.junit.jupiter.api.Test
	void test5() {
		
		Anagrams anagram = new Anagrams();
		
		anagram.addWord("cz");
		
		long hash = 505;
		
		assertEquals(anagram.anagramTable.get(hash).get(0), "cz");
		
	}
	
	/*
	 * Tests the Anagram class. 
	 */
	
	@org.junit.jupiter.api.Test
	void test6() {
		
		Anagrams anagram = new Anagrams();
		
		anagram.addWord("abc");
		anagram.addWord("cba");
		anagram.addWord("bca");
		anagram.addWord("bac");
		anagram.addWord("bat");
		assertEquals(anagram.getMaxEntries().toString(), "[30=[abc, cba, bca, bac]]");
		
	}
	
	/*
	 * Tests the Anagram class. 
	 */
	
	@org.junit.jupiter.api.Test
	void test7() {
		
		Anagrams anagram = new Anagrams();
		
		anagram.addWord("a");
		anagram.addWord("b");
		anagram.addWord("c");
		anagram.addWord("d");
		anagram.addWord("e");
		assertEquals(anagram.getMaxEntries().toString(), "[2=[a], 3=[b], 5=[c], 7=[d], 11=[e]]");

		
	}

}

