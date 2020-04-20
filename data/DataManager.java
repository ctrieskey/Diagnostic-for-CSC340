package data;

import java.util.ArrayList;

import query.Query;

/**
 * This Data Manager class will get and save queries to a document(s) and interface with the QueryManager
 * 
 * data manager
 * Last Updated: 4/20/2020
 * @author Conner Trieskey
 * 
 */
public class DataManager {

	private static ReaderWriter readerWriter = new ReaderWriter();
	private static ArrayList<Query> queries;
	
	
	/**
	 * @return
	 * This method politely asks the reader/writer for its list of queries and returns it to whoever asked.
	 */
	public static ArrayList<Query> getQueryList() {
		queries = readerWriter.readQueries();
		
		return queries;
	}
	
	/**
	 * @param _q
	 * This method politely tells the reader/writer that its list of queries is wrong and gives it a new list.
	 */
	public static void saveQueries(ArrayList<Query> _q) {
		readerWriter.writeQuery(_q);
	}
	
	/**
	 * @param _q
	 * This method can be used to add a single query to the list recorded in the file.
	 */
	public static void submitQuery(Query _q) {
		System.out.println("sending query to the readerwriter");
		if(getQueryList() == null) {
			queries = new ArrayList<Query>();
		}
		queries.add(_q);
		readerWriter.writeQuery(queries);
		
	}
	
}
