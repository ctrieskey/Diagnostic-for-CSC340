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

/*
 * This class will be in charge of reading and writing data supplied by
 * the data manager into actual documents.
<<<<<<< HEAD
 * 
 * reader writer
=======
>>>>>>> 43d29e0184cb963d9c1265ad5892623bd4e8fd8b
 * Last Updated: 4/13/2020
 * @author Conner Trieskey
 * 
 */
public class ReaderWriter {
	
	public static final String QUERY_DOC_FILENAME = "/res/queries.txt";
	
	private File queryDoc;
	private FileInputStream input;
	private ObjectInputStream objectInput;
	
	private FileOutputStream output;
	private ObjectOutputStream objectOutput;
	
	//constructor that loads list of queries from a file
	public ReaderWriter() {
		queryDoc = new File(QUERY_DOC_FILENAME);
		loadDoc(this.queryDoc);
	}
	
	//creates a query doc
	private void createDoc(File _doc) {
		try {
			this.output = new FileOutputStream(_doc);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			this.objectOutput = new ObjectOutputStream(output);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		try {
			objectOutput.close();
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//loads a query doc
	private void loadDoc(File _doc) {
		try {
			this.input = new FileInputStream(_doc);
		}
		catch (FileNotFoundException e) {
			//if there's no doc, create one
			createDoc(_doc);
			e.printStackTrace();
		}

		try {
			this.objectInput = new ObjectInputStream(input);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	//writes a query to the doc
	public void writeQuery(ArrayList<Query> _q) {
		try {
			this.objectOutput.writeObject(_q);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//reads queries from the doc
	public ArrayList<Query> readQueries() {
		ArrayList<Query> q = null;
		
		try {
			q = (ArrayList<Query>) objectInput.readObject();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}
	
	//marks a query as inactive
	public void deleteQuery(Query _q) {
		QueryManager.getCurrentQuery().setActive(false);
	}
	
}
