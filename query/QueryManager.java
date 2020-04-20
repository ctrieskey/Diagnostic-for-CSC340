package query;

import java.time.LocalDateTime;
import java.util.ArrayList;

import data.DataManager;

/**
 * This Query Manager class creates and looks up saved query documents for the user to view.
 * These documents use the make, model, year, or date of query creation to look up a query.
 * The search model can give the findQuery method null values if only part of the information on the 
 * query is known. The method will return any queries that match the search terms.
 * 
 * QueryManager
 * Last Updated: 4/20/2020
 * @author Conner Trieskey
 * 
 */

public class QueryManager {

	private static ArrayList<Query> availableQueries;
	
	private static Query currentQuery;
	
	/**
	 * This method makes sure that this class has the same list as the file.
	 */
	public static void refreshQueries() {
		availableQueries = DataManager.getQueryList();
	}
	
	/**
	 * @param _make
	 * @param _model
	 * @param _year
	 * @param _date
	 * @return
	 * This is a factory method for queries. It takes user data and turns it into a query object and then submits it to
	 * the data manager to be written to the file.
	 */
	public static Query createQuery(String _make, String _model, String _year, LocalDateTime _date) {
		System.out.println("submitting query to the datamanager");
		currentQuery = new Query(_make, _model, _year, LocalDateTime.now());
		DataManager.submitQuery(currentQuery);
		return currentQuery;
		
	}

	/**
	 * @param _make
	 * @param _model
	 * @param _year
	 * @param _date
	 * @return
	 * This method searches this class's list of queries for any that match user unput search terms and returns
	 * a list of matches.
	 */
	public static ArrayList<Query> findQuery(String _make, String _model, String _year, String _date) {
		ArrayList<Query> q = new ArrayList<Query>();
		
		Query terms = new Query(_make, _model ,_year, _date);
		refreshQueries();
		if(availableQueries == null) {
			return null;
		}
		for(int i=0; i<availableQueries.size(); i++) {
			Query checking = availableQueries.get(i);
			System.out.println("Checking a query for match");
			if(checking.isActive()) {
				if(matchQuery(checking, terms)) {
					System.out.println("found one");
					q.add(checking);
				}
				else {
					System.out.println("This query did not match");
				}
			}
			else {
				System.out.println("This Query is inactive");
			}
		}
		
		return q;
	}
	
	/**
	 * @param _q
	 * @param _terms
	 * @return
	 * This is a helper method for the method above. It checks each search term for a match.
	 */
	private static boolean matchQuery(Query _q, Query _terms) {
		if(_terms.getMake() != null && !_terms.getMake().equals("") && !_terms.getMake().equals(_q.getMake())) {
			return false;
		}
		System.out.println("make is good");
		if(_terms.getModel() != null && !_terms.getModel().equals("")  && !_terms.getMake().equals(_q.getModel())) {
			return false;
		}
		System.out.println("model is good");
		if(_terms.getYear() != null && !_terms.getYear().equals("")  && !_terms.getMake().equals(_q.getYear())) {
			return false;
		}
		System.out.println("year is good");
		if(_terms.getDate() != null && !_terms.getDate().equals("")  && !_terms.getMake().equals(_q.getDate())) {
			return false;
		}
		System.out.println("date is good");
		return true;
		
	}
	
	/**
	 * This method saves this class's list to the file.
	 */
	public static void saveQueries() {
		DataManager.saveQueries(availableQueries);
	}
	
	/**
	 * this class can be used to change this class's selected query.
	 */
	public static void selectQuery(Query _q) {
		currentQuery = _q;
	}
	
	/**
	 * @param _make
	 * @param _model
	 * @param _year
	 * @param _symptoms
	 * This method can be used to completely update this class's currently selected query.
	 */
	public static void updateQuery(String _make, String _model, String _year, String _symptoms) {
		currentQuery.setMake(_make);
		currentQuery.setModel(_model);
		currentQuery.setYear(_year);
		currentQuery.setSymptoms(_symptoms);
		
	}
	
	//==============Getters================
	
	public ArrayList<Query> getAvailableQueries(){
		return availableQueries;
	}

	public static Query getCurrentQuery() {
		return currentQuery;
	}
	
	//=============Setters=================

	public static void setCurrentQuery(Query currentQuery) {
		QueryManager.currentQuery = currentQuery;
	}
	
}
