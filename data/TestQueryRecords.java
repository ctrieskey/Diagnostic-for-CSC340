package data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import query.Query;
import query.QueryManager;
/**
 * A class for testing the reading and writing of queries to a file
 * conner trieskey
 * 4/20/2020
 * 
 */
public class TestQueryRecords {

	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("What would you like to do? lookup, enter");
			String option = input.next();

			System.out.println("Make:");
			String make = input.next();
			System.out.println("Model:");
			String model = input.next();
			System.out.println("Year:");
			String year = input.next();
			String date = null;
			
			if(option.equals("enter")) {
				
				System.out.println("creating query from data");
				Query q = QueryManager.createQuery(make, model, year, LocalDateTime.now());
				
			}
			
			if(option.equals("lookup")) {
				ArrayList<Query> results = QueryManager.findQuery(make, model, year, date);
				
				if(results != null && !results.isEmpty()) {
					for(Query q : results) {
						q.printDetails();
					}
				}
				else {
					System.out.println("no queries matched");
				}
			}
		}
	}
	
}
