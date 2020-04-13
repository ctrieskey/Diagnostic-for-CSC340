package search;

import query.Query;
import query.QueryManager;

/*
 * This Class will deliver search terms entered in the GUI to the Query manager to look up.
 * 
 * search
 * Last Updated: 4/13/2020
 * @author Conner Trieskey
 */

public class Search {

	
	
	//This submits search terms to the query manager.
	public static void submitSearch(String _make, String _model, String _year, String _date) {
		QueryManager.findQuery(_make, _model, _year, _date);
	}
	
}
