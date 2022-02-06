package org.howard.edu.lsp.assignment2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TextProcessor {
	public static void main(String[] args){
		Scanner scan = new Scanner (System.in);
		System.out.println("String?");
		String input = scan.nextLine();
		
		if(input.equals("Goodbye")) {
			return;
		}
			
		int sum = 0;
		int prod = 1;
		String[] split_input = input.split(" ");
		List<String> list = new ArrayList<String>(Arrays.asList(split_input));
		
		
		for (String s : list) {				
			System.out.println(s);
			int num = Integer.parseInt(s);
			sum = sum + num;
			prod = prod * num;			
		}
		System.out.println("Sum: " + sum);
		System.out.println("Product: "+ prod);
		
	}
}
