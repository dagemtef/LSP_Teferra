package org.howard.edu.lsp.finalExam;

import java.util.*;

public class MapUtilities {
    public static int commonKeyValuePairs(
    		HashMap<String, String> map1,
    		HashMap<String, String> map2)throws NullMapException {
    	
    	int counter = 0;
    	if (map1.isEmpty() || map2.isEmpty()) {
    		throw new NullMapException("One or both maps are null!");
    	}
    	
    	
    	if (!map1.isEmpty() && !map2.isEmpty()) {
    		
    		for (String key1 : map1.keySet()) {
    			for (String key2 : map2.keySet()) {
    				if (key1.equals(key2)){
    					String value1 = map1.get(key1);
    					String value2 = map2.get(key2);
    					if(value1.equals(value2)) {
    						counter += 1;
    					}
    				}
    			}
    		}
    		return counter;
    	}
    	return 0;
    }
}
