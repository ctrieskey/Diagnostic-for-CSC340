package datastore;
/*
This class is for pulling information via
the getters and setters on the cars to create an entry.
@author Taylor Headen
Last updated 5/1/2020.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataStore {


    private String UUID;
    protected String make;
    protected String model;
    protected String year;

    protected String activeFlag;
//Constructor
    public DataStore() {
    }

    public DataStore(String _uuid, String _make, String _model, String _year) {
        this.UUID = _uuid;
        this.make = _make;
        this.model = _model;
        this.year = _year;
 

    }
//Creates array for the car entries. 
    DataStore(String _data) {
        String[] carInfo = _data.split(" ");
        this.UUID = carInfo[0];
        this.make = carInfo[1];
        this.model = carInfo[2];
        this.year = carInfo[3];
      

    }

//====================GETTERS===============//
    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getYear() {
        return this.year;
    }

    public String getVIN() {
        return this.UUID;
    }

    public String getActiveFlag() {
        return this.activeFlag;
    }

//===================SETTERS================//
    public void setMake(String _make) {
        this.make = _make;
    }

    public void setModel(String _model) {
        this.make = _model;
    }

    public void setYear(String _year) {
        this.make = _year;
    }

    public void setVIN(String _uuid) {
        this.make = _uuid;
    }
    public void setActiveFlag(String _activeFlag){
    this.activeFlag = _activeFlag;
        
    }
    @Override
    public String toString() {
        return (this.UUID + " " + this.make + " " + this.model + " " + this.year);
    }
}
