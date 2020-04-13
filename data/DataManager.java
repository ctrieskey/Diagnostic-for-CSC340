package data;

import java.util.ArrayList;

import query.Query;

/*
 * This Data Manager class will get and save queries to a document(s) and interface with the QueryManager
 * 
 * data manager
 * Last Updated: 4/13/2020
 * @author Conner Trieskey
 * 
 */
public class DataManager {

	private static ReaderWriter readerWriter = new ReaderWriter();
	private static ArrayList<Query> queries;
	
	public static ArrayList<Query> getQueryList() {
		queries = readerWriter.readQueries();
		
		return queries;
	}
	
	public static void submitQuery(Query _q) {
		queries.add(_q);
		readerWriter.writeQuery(queries);
		
	}
	
}
