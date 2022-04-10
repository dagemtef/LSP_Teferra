package org.howard.edu.lsp.assignment6.integerset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.howard.edu.lsp.assignment5.implementation.IntegerSetException;

/**
 * This class implements several operations on a number set and compares it to others
 * @author Dagem Teferra
 *
 */

public class IntegerSet {
	
	
	/**
	 * A class method called "numbers" is generated as an integer list.
	 * Numbers will act as a representation of the number set.  
	 */
	private List<Integer> numbers = new ArrayList<Integer>();

	/**
	 * This is a simple constructor that doesn't take any parameters
	 */
	public IntegerSet() {	
		}

	/**
	 * This method clears all the values in the set and makes it empty
	 */
	public void clear() {
		numbers.clear();
	};

	/**
	 * This method finds the length of the set by using .size()
	 * @return the length of the set
	 */
	public int length(){
		return numbers.size();
		
	};

	/**
	 * Compares to sets and returns whether they are equal or not.
	 * It first checks if the two sets are of equal length and returns false if not
	 * Then it creates java set variables 'set1' and 'set2' then assigns the elements from the first set into set1 and so on 
	 * thorough a for loop.
	 * Finally it compares the two sets using .equals() method and returns a boolean
	 * @param b - this is the second set that our original set will be compared to
	 * @return true if they are equal and false if they are not
	 */
	
	public boolean equals(IntegerSet b){
		if (b.length() != numbers.size()) {
			return false;
		}
		
		else {
			Set<Integer> set1 = new HashSet<Integer> ();
			Set<Integer> set2 = new HashSet<Integer> (); 
			
			for(int i:numbers) {
				set1.add(i);
			}
			for(int j: b.numbers) {
				set2.add(j);
			}
			
			if (set1.equals(set2)) {
				return true;
			}
			else {
				return false;
			}
		
		}
	}; 

	/**
	 * Checks if our set contains a specific value.
	 * It checks for the value using .contains() method and returns a boolean.
	 * @param value - this is an integer value we are checking for existence in our set
	 * @return true if the value is found and false otherwise
	 */
	public boolean contains(int value){
		if(numbers.contains(value)){
			return true;
		}
		else{
			return false;
		}
	};    

	/**
	 * Finds the largest item in our set and Throws an IntegerSetException if the set is empty.
	 * First an variable 'len' is established as the length of our set.
	 * Then it checks if len is zero (if the set is empty). If this is true then an IntegerSetException with a message is thrown.
	 * After that the set 'numbers' is sorted and the last element of the sorted list is returned using .get().
	 * @return int largest element of the set
	 * @throws IntegerSetException custom exception that catches empty sets and notifies user of error
	 */
	public int largest() throws IntegerSetException{
		int len = numbers.size();
		if (len == 0) {
			throw new IntegerSetException("Cannot find largest value: the set is empty");
		}
		
		Collections.sort(numbers);
		return numbers.get(len-1);	
	}; 

	/**
	 * Finds the smallest item in our set and Throws an IntegerSetException if the set is empty.
	 * First an variable 'len' is established as the length of our set.
	 * Then it checks if len is zero (if the set is empty). If this is true then an IntegerSetException with a message is thrown.
	 * After that the set 'numbers' is sorted and the first element of the sorted list is returned using .get()
	 * @return int smallest element of the set
	 * @throws IntegerSetException custom exception that catches empty sets and notifies user of error
	 */
	public int smallest() throws IntegerSetException{
		int len = numbers.size();
		if (len == 0) {
			throw new IntegerSetException("Cannot find smallest value: the set is empty");
		}
		
		Collections.sort(numbers);
		return numbers.get(0);	
	};


	/**
	 * Adds an item to the set or does nothing if it is already there.
	 * A boolean called exists is initialized as false then a for loop is called that searches for the existence of the value we 
	 * are trying to add. If the value is found 'exists' will be made true if not it will remain false.
	 * At the end of the loop we check for 'exists' is false then add to the set 'numbers' using .add()	
	 * @param item is an int value to be added to the set 
	 */
	public void add(int item) {
		boolean exists = false;
		for (int i : numbers) {
			if(i == item) {
				exists = true;
			}
		}
		
		if (exists == false) {
			numbers.add(item);
		}
}; 

	/**
	 * Removes an item from the set or does nothing if not there.
	 * First an variable 'len' is established as the length of our set.
	 * Then it checks if len is zero (if the set is empty). If this is true then an IntegerSetException with a message is thrown.
	 * Then a for loop is started that goes through the set to catch the intended value.
	 * If we find the value it is removed from the set using .remove().
	 * If not caught then the loop will terminate and nothing will happen.
	 * @param item is an int value that is going to be removed from the set
	 * @throws IntegerSetException
	 */
	public void remove(int item) throws IntegerSetException{
		int len = numbers.size();
		if (len == 0) {
			throw new IntegerSetException("Cannot remove element: the set is empty");
		}
		for (int i : numbers) {
			if(i == item) {
				int pos = numbers.indexOf(i);
				numbers.remove(pos);
				break;
			}
		}
	};

	/**
	 * Finds the union between the first set and second one by adding all elements of the second one to the first set.
	 * Integer lists called 'set1' and 'set2' are initialized to represent the sets. 
	 * A for loop goes through the elements of the second set and checks if each element exists in the 'set1'.
	 * If it does not already exist in 'set1' then it is added using .add().
	 * @param intSetb this is the second set whose elements will be added to the first set to find a union
	 */
	public void union(IntegerSet intSetb){
		List<Integer> set1 = numbers;
		List<Integer> set2 = intSetb.numbers;
		
		for (int j : set2) {
			if (set1.contains(j)) {
			} else {
				set1.add(j);
			}
		}
		numbers = set1;
	};

	/**
	 * This finds the intersection between two sets. 
	 * Integer lists called 'set1' and 'set2' are initialized to represent the sets. 
	 * Another list called 'intersect' is created to add all the common elements.
	 * A for loop goes through the elements of set2 then checks if each exist in set1.
	 * If they already exist then they are added to the set called 'intersect'.
	 * Finally set1 is made to be equal to the list 'intersect'
	 * @param intSetb this is the second set whose elements will intersected to the first set
	 */
	public void intersect(IntegerSet intSetb) {
		List<Integer> set1 = numbers;
		List<Integer> set2 = intSetb.numbers;
		List<Integer> intersect = new ArrayList<Integer>();
		for (int i : set2) {
			if (set1.contains(i)) {
				intersect.add(i);
			}
		}
		numbers = intersect;
	}; 

	/**
	 * Finds the difference between set1 and set2. That means the elements in set1 that do not exist in set2.
	 * Integer lists called 'set1' and 'set2' are initialized to represent the sets. 
	 * Another list called 'diff' is created to add all the difference.
	 * A for loop goes through the elements of set1 then checks if each of them exist in set2.
	 * If the element is not in set2 then it is added to the list called 'diff'.
	 * Finally set1 is made to be equal to the list 'diff'.
	 * @param intSetb this is the second set whose elements will intersected to the first set
	 */
	public void diff(IntegerSet intSetb) {
		List<Integer> set1 = numbers;
		List<Integer> set2 = intSetb.numbers;
		List<Integer> diff = new ArrayList<Integer>();
		for (int i : set1) {
			if (set2.contains(i) == false) {
				diff.add(i);
			}
		}
		numbers = diff;
	};

	/**
	 * Checks if the set is empty using .isEmpty() method.
	 * @return true is set is empty and false otherwise
	 */
	public boolean isEmpty() {
		return numbers.isEmpty();
	}; 

	/**
	 * Returns the string representation of the set using .toString() method
	 * @return string called 'result' which is the string representation of our set.
	 */
	public String toString(){
		String result = numbers.toString();
		return result;
	};	

}
