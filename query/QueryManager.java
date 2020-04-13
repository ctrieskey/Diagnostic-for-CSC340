package query;

import java.time.LocalDateTime;
import java.util.ArrayList;

import data.DataManager;

/*
 * This Query Manager class creates and looks up saved query documents for the user to view.
 * These documents use the make, model, year, or date of query creation to look up a query.
 * The search model can give the findQuery method null values if only part of the information on the 
 * query is known. The method will return any queries that match the search terms.
 * 
 * QueryManager
 * Last Updated: 4/13/2020
 * @author Conner Trieskey
 * 
 */

public class QueryManager {

	private static ArrayList<Query> availableQueries;
	
	private static Query currentQuery;
	
	//updates the query list
	public static void refreshQueries() {
		availableQueries = DataManager.getQueryList();
	}
	
	//creates a new query
	public static Query createQuery(String _make, String _model, String _year, LocalDateTime _date) {
		currentQuery = new Query(_make, _model, _year, LocalDateTime.now());
		DataManager.submitQuery(currentQuery);
		return currentQuery;
		
	}

	//searches list for a query that contains a matching term.
	public static ArrayList<Query> findQuery(String _make, String _model, String _year, String _date) {
		ArrayList<Query> q = new ArrayList<Query>();
		
		Query terms = new Query(_make, _model ,_year, _date);

		for(int i=0; i<availableQueries.size(); i++) {
			Query checking = availableQueries.get(i);
			if(checking.isActive() && matchQuery(checking, terms)) {
				q.add(checking);
			}
		}
		
		return q;
	}
	
	//helper for findQuery
	private static boolean matchQuery(Query _q, Query _terms) {
		if(_terms.getMake() != null && !_terms.getMake().contentEquals("") && _terms.getMake() != _q.getMake()) {
			return false;
		}
		if(_terms.getModel() != null && !_terms.getModel().contentEquals("")  && _terms.getModel() != _q.getModel()) {
			return false;
		}
		if(_terms.getYear() != null && !_terms.getYear().contentEquals("")  && _terms.getYear() != _q.getYear()) {
			return false;
		}
		if(_terms.getDate() != null && !_terms.getDate().contentEquals("")  && _terms.getDate() != _q.getDate()) {
			return false;
		}
		return true;
		
	}
	
	//selects a query to view or edit
	public void selectQuery(Query _q) {
		currentQuery = _q;
	}
	
	//updates a query in the doc
	public void updateQuery(String _make, String _model, String _year, String _symptoms) {
		currentQuery.setMake(_make);
		currentQuery.setModel(_model);
		currentQuery.setYear(_year);
		currentQuery.setSymptoms(_symptoms);
		
	}
	
	public ArrayList<Query> getAvailableQueries(){
		return availableQueries;
	}

	public static Query getCurrentQuery() {
		return currentQuery;
	}

	public static void setCurrentQuery(Query currentQuery) {
		QueryManager.currentQuery = currentQuery;
	}
	
}
