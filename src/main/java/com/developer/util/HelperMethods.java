package com.developer.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HelperMethods {
	static Scanner scan = new Scanner(System.in);  // Create a Scanner object
	
	public static String getOnlyAlphabet() {
		boolean isValidInput = false;
		String returnedString = "";

		while (!isValidInput) {
			try {
				returnedString = scan.next();
				
				if (returnedString.matches("[a-zA-Z]+")) {
					isValidInput = true;
				} else {
					System.out.println("Only alphabet letters allowed.");
				}
			} catch (InputMismatchException  e) {
				System.out.println("Invalid input.");
				scan.nextLine(); //Clear invalid input
			}
		}
		
		return returnedString;
	}
	
	public static String getOnlyAlphanumeric() {
		boolean isValidInput = false;
		String returnedString = "";

		while (!isValidInput) {
			try {
				returnedString = scan.next();
				
				if (returnedString.matches("^[a-zA-Z0-9]+$")) {
					isValidInput = true;
				} else {
					System.out.println("Only alphanumeric letters allowed.");
				}
			} catch (InputMismatchException  e) {
				System.out.println("Invalid input.");
				scan.nextLine(); //Clear invalid input
			}
		}
		
		return returnedString;
	}
	
	public static double getPositiveDoubleInput(String text) {
		boolean isValidInput = false;
		double amount = 0;
		
		while (!isValidInput) {
			try {
				System.out.println(text);
				
				amount = scan.nextDouble();
				
				if (amount > 0) {
					isValidInput = true;
				} else {
					System.out.println("Input a number greater than 0");
				}
			} catch (InputMismatchException  e) {
				System.out.println("Invalid input.");
				scan.nextLine(); //Clear invalid input
			}
		}
		
		return amount;
	}
	
	
	public static double getAnyDoubleInput(String text) {
		double amount = 0;
		
		try {
			System.out.println(text);
			amount = scan.nextDouble();
			
		} catch (InputMismatchException  e) {
			System.out.println("Invalid input.");
			scan.nextLine(); //Clear invalid input
		}
		
		return amount;
	}
	
	public static int getIntInput(String text) {
		boolean isValidInput = false;
		int input = 0;
		
		while (!isValidInput) {
			System.out.println(text);
			
			try {
				
				input = scan.nextInt(); 
				if (input > 0) {
					isValidInput = true;
				} else {
					System.out.println("Invalid input.");
				}
			} catch (InputMismatchException  e) {
				System.out.println("Invalid input.");
				scan.nextLine(); //Clear invalid input
			}
		}
		
		return input;
	}
	
	public static boolean getYesOrNo() {

		boolean isValidInput = false;
		char input = ' ';

		while (!isValidInput) {
			System.out.println("\nActivate an account? (Y/N)");
			
			try {
				
				input = Character.toLowerCase(scan.next().charAt(0)); 
				
				if (input == 'y' || input == 'n') {
					isValidInput = true;
				} else {
					System.out.println("Invalid input.");
				}
			} catch (InputMismatchException  e) {
				System.out.println("Invalid input.");
				scan.nextLine(); //Clear invalid input
			}
		}
		
		if (input == 'n') {
			return false;
		} 
		
		return true;
	}
	
	public static void holdAppFlow() {
		System.out.println("\nPress Enter key to continue...");
        try {
            System.in.read(); 
        }  
        catch(Exception e) {
        	System.out.println("App flow error");
        }  
	}
}
