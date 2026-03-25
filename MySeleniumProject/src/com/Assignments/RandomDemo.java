package com.Assignments;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		Random rnd = new Random();
		int i = rnd.nextInt(5);
		//This will generate random number in the range of 0 to 4
		System.out.println(i);
		
		System.out.println("number generated is " + i + " with random class");
		displayName("Sapana");
	}
	
	public static void displayName(String nm) {
		String n = "Dharmesh";
		System.out.println("Name: " + nm);
	}
}
