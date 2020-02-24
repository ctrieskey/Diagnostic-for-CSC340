package query;

import java.time.LocalDateTime;

/*
 * This Query class holds the information about the car that is having issues. Eventually it will also 
 * hold possible diagnoses.
 * Last Updated: 2/17/2020
 * @author Conner Trieskey
 * 
 */
public class Query {

	private String make, model, year;
	private LocalDateTime date;
	
	public Query(String make, String model, String year, LocalDateTime date) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.date = date;
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
	
}