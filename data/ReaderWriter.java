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

/*
 * This class will be in charge of reading and writing data supplied by
 * the data manager into actual documents.
 * Last Updated: 2/17/2020
 * @author Conner Trieskey
 * 
 */
public class ReaderWriter {
	
	public static final String QUERY_DOC_FILENAME = "/queries.txt";
	
	private File queryDoc = new File(QUERY_DOC_FILENAME);
	private FileInputStream input;
	private ObjectInputStream objectInput;
	
	private FileOutputStream output;
	private ObjectOutputStream objectOutput;
	
	public ReaderWriter() {
		loadDoc(this.queryDoc);
	}
	
	private void createDoc(File _doc) {
		try {
			this.output = new FileOutputStream(_doc);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.objectOutput = new ObjectOutputStream(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadDoc(File _doc) {
		try {
			this.input = new FileInputStream(_doc);
		} catch (FileNotFoundException e) {
			createDoc(_doc);
			e.printStackTrace();
		}

		try {
			this.objectInput = new ObjectInputStream(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeQuery(Query _q) {
		try {
			this.objectOutput.writeObject(_q);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Query> readQueries() {
		ArrayList<Query> q = null;
		
		try {
			q = (ArrayList<Query>) objectInput.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}
	
}
