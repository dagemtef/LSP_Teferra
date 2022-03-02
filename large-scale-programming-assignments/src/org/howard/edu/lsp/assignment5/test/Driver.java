package org.howard.edu.lsp.assignment5.test;
import org.howard.edu.lsp.assignment5.implementation.IntegerSet;
import org.howard.edu.lsp.assignment5.implementation.IntegerSetException;

public class Driver {
	public static void main(String[] args) {
	
	IntegerSet set1 = new IntegerSet();
	set1.add(1);
	set1.add(2);
	set1.add(3);
	set1.add(4);
	set1.add(5);

	System.out.println("Value of Set1 is: " + set1.toString());
	System.out.println("Length: " + set1.length());
	try {
		System.out.println("Smallest value: " + set1.smallest());
	} catch (IntegerSetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		System.out.println("Largest value: " + set1.largest());
	} catch (IntegerSetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	IntegerSet set2 = new IntegerSet();
	set2.add(4);
	set2.add(5);
	set2.add(6);
	set2.add(7);
	set2.add(8);
	

	System.out.println("\nUnion of Set1 and Set2");
	System.out.println("Set1: " + set1.toString());
	System.out.println("Set2: " + set2.toString());
	set1.union(set2);
	System.out.println("Result of union of Set1 and Set2");
	System.out.println(set1.toString());
	System.out.println("\nLets remove the extra numbers and return Set1 to its original size...");
	try {
		set1.remove(6);
	} catch (IntegerSetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		set1.remove(7);
	} catch (IntegerSetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		set1.remove(8);
	} catch (IntegerSetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Now the value of Set1 is: " + set1.toString());
	System.out.println("Set2: " + set2.toString());
	set1.intersect(set2);
	System.out.println("Intersection of Set1 and Set2 is: " + set1.toString());
	
	System.out.println("\nLets add back the values to Set1...");
	set1.add(1);
	set1.add(2);
	set1.add(3);
	System.out.println("Now the value of Set1 is: " + set1.toString());
	System.out.println("Set2: " + set2.toString());
	set1.diff(set2);
	System.out.println("The difference of Set1 from Set2 is: " + set1.toString());
	
	System.out.println("\nValue of Set1 right now is: " + set1.toString());
	System.out.println("Is Set1 empty? " + set1.isEmpty());
	System.out.println("Lets clear Set1... ");
	set1.clear();
	System.out.println("Set1: " + set1.toString());
	System.out.println("Is Set1 empty? " + set1.isEmpty());
	System.out.println("Lets try checking for the smallest and largest numbers...");
	try {
		System.out.println("Smallest value: " + set1.smallest());
	} catch (IntegerSetException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	try {
		System.out.println("Largest value: " + set1.largest());
	} catch (IntegerSetException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	
	System.out.println("\nLets compare new sets");
	IntegerSet set3 = new IntegerSet();
	set3.add(21);
	set3.add(22);
	set3.add(23);
	
	IntegerSet set4 = new IntegerSet();
	set4.add(21);
	set4.add(22);
	set4.add(23);
	
	System.out.println("Set3: " + set3.toString());
	System.out.println("Set4: " + set4.toString());
	System.out.println("Are these two equal? " + set3.equals(set4));
	System.out.println("\nNow let's add a value to Set4... ");
	set4.add(24);
	System.out.println("Set3: " + set3.toString());
	System.out.println("Set4: " + set4.toString());
	System.out.println("Are these two equal? " + set3.equals(set4));
	System.out.println("\nNow let's add a value to Set3... ");
	set3.add(25);
	System.out.println("Set3: " + set3.toString());
	System.out.println("Set4: " + set4.toString());
	System.out.println("Are these two equal? " + set3.equals(set4));
	System.out.println("Does Set3 contain the value 25? " + set3.contains(25));
	System.out.println("Does Set4 contain the value 25? " + set4.contains(25));
	
	}
	
	
}
