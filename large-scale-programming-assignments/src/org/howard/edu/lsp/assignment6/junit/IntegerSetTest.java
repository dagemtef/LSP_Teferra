package org.howard.edu.lsp.assignment6.junit;
import org.howard.edu.lsp.assignment5.implementation.IntegerSetException;
import org.howard.edu.lsp.assignment6.integerset.IntegerSet;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class IntegerSetTest {
	@Test
    @DisplayName("Test case for IntegerSet.clear")
    public void testClear() {
       IntegerSet set1 = new IntegerSet();
       
       set1.add(1);
       set1.add(2);
       set1.clear();
       
       assertTrue(set1.isEmpty());
       set1.clear();
       assertTrue(set1.isEmpty());    
    }
	
	@Test
    @DisplayName("Test case for IntegerSet.length")
    public void testLength() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		assertEquals(set1.length(), 0);
	       
	    set1.add(1);
	    set1.add(2);
	    assertEquals(set1.length(), 2);
	    set1.remove(2);
	    assertEquals(set1.length(), 1);
		set1.clear();
		assertEquals(set1.length(), 0);
		set1.add(1);
		set1.add(1);
		assertEquals(set1.length(), 1);
    }
	
	@Test
    @DisplayName("Test case for IntegerSet.equals")
    public void testEquals() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		assertTrue(set1.equals(set2));
		
		set1.add(1);
		set2.add(2);
		assertFalse(set1.equals(set2));
		assertFalse(set2.equals(set1));
		
		set1.add(2);
		set2.add(1);
		assertTrue(set1.equals(set2));
		assertTrue(set2.equals(set1));
		
		set1.add(1);
		set2.add(2);
		assertTrue(set1.equals(set2));
		assertTrue(set2.equals(set1));
		
		set1.clear();
		set2.clear();
		assertTrue(set1.equals(set2));
		assertTrue(set2.equals(set1));
		
		set1.add(5);
		set1.add(6);
		set1.add(7);
		set2.add(5);
		set2.add(6);
		set2.add(2);
		assertFalse(set1.equals(set2));
		assertFalse(set2.equals(set1));
		
		
    }
	
	
	
	@Test
    @DisplayName("Test case for IntegerSet.contains")
    public void testContains() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		assertTrue(set1.contains(1));
		assertTrue(set1.contains(2));
		assertTrue(set1.contains(3));
		assertFalse(set1.contains(0));
		set1.remove(2);
		assertFalse(set1.contains(2));
		set1.clear();
		assertFalse(set1.contains(0));
    }
	
	@Test
    @DisplayName("Test case for IntegerSet.largest")
    public void testLargest() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		assertEquals(set1.largest(),3);
		set1.remove(3);
		assertEquals(set1.largest(),2);
		set1.remove(2);
		assertEquals(set1.largest(),1);
		set1.clear();
		set1.add(82);
		set1.add(89);
		set1.add(89);
		assertEquals(set1.largest(),89);
		
    }
	
	@Test
    @DisplayName("Test case for exception in IntegerSet.largest")
    public void testLargest_THROWS_EXCEPTION() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		
		Exception exception1 = assertThrows(org.howard.edu.lsp.assignment5.implementation.IntegerSetException.class, () -> {
			set1.largest();
		});
		
		String expectedmessage = "Cannot find largest value: the set is empty";
		String actualmessage = exception1.getMessage();
		assertTrue(actualmessage.contains(expectedmessage));
		
		set1.add(1);
		set1.add(2);
		set1.clear();
		
		Exception exception2 = assertThrows(org.howard.edu.lsp.assignment5.implementation.IntegerSetException.class, () -> {
			set1.largest();
		});
		
		String expectedmessage2 = "Cannot find largest value: the set is empty";
		String actualmessage2 = exception2.getMessage();
		assertTrue(actualmessage2.contains(expectedmessage2));
		
		
		
    }
	
	
	@Test
    @DisplayName("Test case for IntegerSet.smallest")
    public void testSmallest() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		assertEquals(set1.smallest(),1);
		set1.remove(1);
		assertEquals(set1.smallest(),2);
		set1.remove(2);
		assertEquals(set1.smallest(),3);
		set1.clear();
		set1.add(82);
		set1.add(82);
		set1.add(89);
		assertEquals(set1.smallest(),82);
		
    }
	
	@Test
    @DisplayName("Test case for exception in IntegerSet.smallest")
    public void testSmallest_THROWS_EXCEPTION() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		
		Exception exception = assertThrows(org.howard.edu.lsp.assignment5.implementation.IntegerSetException.class, () -> {
			set1.smallest();
		});
		
		String expectedmessage = "Cannot find smallest value: the set is empty";
		String actualmessage = exception.getMessage();
		
		assertTrue(actualmessage.contains(expectedmessage));
		
		
    }
	
	@Test
    @DisplayName("Test case for add")
    public void testAdd() {
		IntegerSet set1 = new IntegerSet();
		assertEquals(set1.toString(),"[]");
		set1.add(1);
		set1.add(2);
		set1.add(3);
		assertEquals(set1.toString(),"[1, 2, 3]");
		set1.add(1);
		set1.add(1);
		assertEquals(set1.toString(),"[1, 2, 3]");
    }
	
	@Test
    @DisplayName("Test case for equals")
    public void testRemove() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		assertEquals(set1.toString(),"[]");
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.remove(1);
		assertEquals(set1.toString(),"[2, 3]");
		set1.remove(2);
		assertEquals(set1.toString(),"[3]");
		set1.remove(3);
		assertEquals(set1.toString(),"[]");
    }
	
	@Test
    @DisplayName("Test case for exception in IntegerSet.remove")
    public void testRemove_THROWS_EXCEPTION() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		
		Exception exception = assertThrows(org.howard.edu.lsp.assignment5.implementation.IntegerSetException.class, () -> {
			set1.remove(0);
		});
		
		String expectedmessage = "Cannot remove element: the set is empty";
		String actualmessage = exception.getMessage();
		
		assertTrue(actualmessage.contains(expectedmessage));
		
		
    }
	
	@Test
    @DisplayName("Test case for union")
    public void testUnion() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		IntegerSet set2 = new IntegerSet();		
		set2.add(3);
		set2.add(4);
		set2.add(5);
		
		set1.union(set2);
		assertEquals(set1.toString(), "[1, 2, 3, 4, 5]");
		
		IntegerSet set3 = new IntegerSet();
		set3.add(23);
		set3.add(22);
		set3.add(21);
		IntegerSet set4 = new IntegerSet();
		
		set3.union(set4);
		assertEquals(set3.toString(), "[23, 22, 21]");
		
		set3.clear();
		set3.union(set4);
		assertEquals(set3.toString(), "[]");
		
		set3.add(1);
		set3.add(2);
		set3.add(3);
		set4.add(2);
		set4.add(3);
		set4.add(4);
		set3.union(set4);
		assertEquals(set3.toString(), "[1, 2, 3, 4]");		
		
    }
	
	@Test
    @DisplayName("Test case for intersect")
    public void testIntersect() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		IntegerSet set2 = new IntegerSet();		
		set2.add(2);
		
		set1.intersect(set2);
		assertEquals(set1.toString(), "[2]");
		
		IntegerSet set3 = new IntegerSet();
		set3.add(1);
		set3.add(2);
		IntegerSet set4 = new IntegerSet();		
		set4.add(3);
		set4.add(4);
		
		set3.intersect(set4);
		assertEquals(set3.toString(), "[]");
    }
	
	@Test
    @DisplayName("Test case for difference")
    public void testDiff() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		IntegerSet set2 = new IntegerSet();		
		set2.add(2);
		set2.add(4);
		set2.add(5);
		
		set1.diff(set2);
		assertEquals(set1.toString(), "[1]");	
		
		IntegerSet set3 = new IntegerSet();
		set3.add(1);
		set3.add(2);
		IntegerSet set4 = new IntegerSet();		
		set4.add(2);
		set4.add(4);
		set4.add(5);
		
		set4.diff(set3);
		assertEquals(set4.toString(), "[4, 5]");
		
		IntegerSet set5 = new IntegerSet();
		set5.add(1);
		set5.add(2);
		IntegerSet set6 = new IntegerSet();		
		set6.add(2);
		set6.add(1);
		
		set5.diff(set6);
		assertEquals(set5.toString(), "[]");
		
    }


	@Test
    @DisplayName("Test case for isEmpty")
	public void testIsEmpty() {
	       IntegerSet set1 = new IntegerSet();
	       assertTrue(set1.isEmpty());
	       set1.add(1);
	       assertFalse(set1.isEmpty());
	       set1.clear();
	       assertTrue(set1.isEmpty());
	}
	
	@Test
    @DisplayName("Test case for toString")
	public void testToString() {
	       IntegerSet set1 = new IntegerSet();
	       
	       assertEquals(set1.toString(), "[]");
	       set1.add(1);
	       assertEquals(set1.toString(), "[1]");
	       set1.add(2);
	       assertEquals(set1.toString(), "[1, 2]");
	       set1.clear();
	       assertEquals(set1.toString(), "[]");
	}
	
	
}
