package query;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/*
 * This Query class holds the information about the car that is having issues. Eventually it will also 
 * hold possible diagnoses.
<<<<<<< HEAD
 * 
 * Query
=======
>>>>>>> 43d29e0184cb963d9c1265ad5892623bd4e8fd8b
 * Last Updated: 4/13/2020
 * @author Conner Trieskey
 * 
 */
public class Query implements Serializable{

	private String make, model, year, date, symptoms;
	private boolean isActive = true;
	
	public Query() {
		
	}
	
	public Query(String make, String model, String year, LocalDateTime date) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.date = date.toString();
	}
	
	public Query(String make, String model, String year, String date) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.date = date;
	}
	
	public void printDetails() {
		System.out.println(toString());
	}
	
	public String toString() {
		String s = "Date: " + date + " Car: " + year + " " + make + " " + model + ". Symptoms: " + symptoms;
		return s;
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

	public String getDate() {
		return date;
	}

	public boolean isActive() {
		return isActive;
	}
	
	public String getSymptoms(){
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

	public void setDate(String date) {
		this.date = date;
	}
	
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}