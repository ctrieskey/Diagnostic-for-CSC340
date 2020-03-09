package query;

import java.time.LocalDateTime;
import java.util.ArrayList;

/*
 * This Query class holds the information about the car that is having issues. Eventually it will also 
 * hold possible diagnoses.
 * Last Updated: 3/9/2020
 * @author Conner Trieskey
 * 
 */
public class Query {

	private String make, model, year;
	private LocalDateTime date;
	private boolean isActive = true;
	private ArrayList<String> symptoms = new ArrayList<String>();	
	public Query(String make, String model, String year, LocalDateTime date) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.date = date;
	}

	//=========symptom editing=========
	
	public void clearSymptoms() {
		symptoms.clear();
	}
	
	public void addSymptom(String _symptom) {
		symptoms.add(_symptom);
	}
	
	public void removeSymptom(String _symptom) {
		symptoms.remove(_symptom);
	}
	
	public boolean hasSymptom(String _symptom) {
		return symptoms.contains(_symptom);
	}
	
	//=============Getters============
	
	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getYear() {
		return year;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public boolean isActive() {
		return isActive;
	}
	
	public ArrayList<String> getSymptoms(){
		return symptoms;
	}
	
	//=============Setters============

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}