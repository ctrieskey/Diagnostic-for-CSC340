package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import query.Query;
import query.QueryManager;

/**
 * This class will be in charge of reading and writing data supplied by
 * the data manager into actual documents.
 * reader writer
 * Last Updated: 4/13/2020
 * @author Conner Trieskey
 * 
 */
public class ReaderWriter {
	
	public static final String QUERY_DOC_FILENAME = "queries.txt";
	
	private File queryDoc;
	private FileInputStream input;
	private ObjectInputStream objectInput;
	
	private FileOutputStream output;
	private ObjectOutputStream objectOutput;
	
	/**
	 * This constructor sets up the file
	 */
	public ReaderWriter() {
		queryDoc = new File(QUERY_DOC_FILENAME);
		loadDoc();
	}
	
	/**
	 * This method makes sure there is a file.
	 */
	private void loadDoc() {
		if(!queryDoc.exists()) {
			try {
				queryDoc.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * @param _q
	 * This method writes a list of queries to the document.
	 */
	public void writeQuery(ArrayList<Query> _q) {
		System.out.println("writing the query");
		try {
			this.output = new FileOutputStream(queryDoc);
			this.objectOutput = new ObjectOutputStream(output);
			this.objectOutput.writeObject(_q);
			System.out.println("query has been written");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return
	 * This method reads a list of queries from the document.
	 */
	public ArrayList<Query> readQueries() {
		ArrayList<Query> q = null;

		try {
			this.input = new FileInputStream(queryDoc);
			this.objectInput = new ObjectInputStream(input);
			q = (ArrayList<Query>) objectInput.readObject();
			objectInput.close();
			return q;
		}
		catch (ClassNotFoundException e) {
			System.out.println("class not found exception");
			return null;
			//e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("IO exception");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param _q
	 * This method will mark a query as deleted.
	 */
	public void deleteQuery(Query _q) {
		QueryManager.getCurrentQuery().setActive(false);
	}
	
}
