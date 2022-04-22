package org.howard.edu.lsp.finalExam;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.howard.edu.lsp.assignment5.implementation.IntegerSetException;
import org.howard.edu.lsp.assignment6.integerset.IntegerSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MapUtilitiesTest {
	@Test
    @DisplayName("Test case for commonKeyValuePairs")
    public void testcommonKeyValuePairs() throws NullMapException {
       HashMap<String, String> map1 = new HashMap<String, String>();
       HashMap<String, String> map2 = new HashMap<String, String>();
       
       map1.put("Alice", "Healthy");
       map1.put("Mary", "Ecstatic");
       map1.put("Bob", "Happy");
       map1.put("Chuck", "Fine");
       map1.put("Felix", "Sick");
       
       map2.put("Mary", "Ecstatic");
       map2.put("Felix", "Healthy");
       map2.put("Ricardo", "Superb");
       map2.put("Tam", "Fine");
       map2.put("Bob", "Happy");
       
       assertEquals(MapUtilities.commonKeyValuePairs(map1, map2), 2);
       
       HashMap<String, String> map3 = new HashMap<String, String>();
       HashMap<String, String> map4 = new HashMap<String, String>();
       
       map3.put("Alice", "Healthy");
       map3.put("Mary", "Ecstatic");
       
       map4.put("Tam", "Fine");
       map4.put("Bob", "Happy");
       
       assertEquals(MapUtilities.commonKeyValuePairs(map3, map4), 0);
       
       HashMap<String, String> map5 = new HashMap<String, String>();
       HashMap<String, String> map6 = new HashMap<String, String>();
       
       map5.put("Mary", "Ecstatic");
       map5.put("Felix", "Healthy");
       map5.put("Ricardo", "Superb");
       
       map6.put("Mary", "Ecstatic");
       map6.put("Felix", "Healthy");
       map6.put("Ricardo", "Superb");
       
       assertEquals(MapUtilities.commonKeyValuePairs(map5, map6), 3);
       
       
           
    }
	
	@Test
    @DisplayName("Test case for exception in commonKeyValuePairs")
    public void testRemove_THROWS_EXCEPTION() throws NullMapException {
		HashMap<String, String> map1 = new HashMap<String, String>();
	    HashMap<String, String> map2 = new HashMap<String, String>();
	    
	    
		Exception exception = assertThrows(org.howard.edu.lsp.finalExam.NullMapException.class, () -> {
			MapUtilities.commonKeyValuePairs(map1, map2);
		});
		
		String expectedmessage = "One or both maps are null!";
		String actualmessage = exception.getMessage();
		
		assertTrue(actualmessage.contains(expectedmessage));
		
		HashMap<String, String> map3 = new HashMap<String, String>();
	    HashMap<String, String> map4 = new HashMap<String, String>();
	    
	    map3.put("Alice", "Healthy");
	    map3.put("Mary", "Ecstatic");
	    
	    
		Exception exception2 = assertThrows(org.howard.edu.lsp.finalExam.NullMapException.class, () -> {
			MapUtilities.commonKeyValuePairs(map3, map4);
		});
		
		String expectedmessage2 = "One or both maps are null!";
		String actualmessage2 = exception.getMessage();
		
		assertTrue(actualmessage2.contains(expectedmessage2));
		
		
    }
	
}