package data;

import java.time.LocalDateTime;
import java.util.Scanner;

import query.Query;
import query.QueryManager;

public class TestQueryRecords {

	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("What would you like to do? lookup, enter");
		String option = input.next();

		System.out.println("Make:");
		String make = input.next();
		System.out.println("Model:");
		String model = input.next();
		System.out.println("Year:");
		String year = input.next();
		System.out.println("Date:");
		String date = input.next();
		
		if(option.contentEquals("enter")) {
			
			Query q = QueryManager.createQuery(make, model, year, LocalDateTime.now());
			
		}
	}
	
}
