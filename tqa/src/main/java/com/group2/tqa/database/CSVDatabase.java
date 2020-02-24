package com.group2.tqa.database;

import java.io.File;

// this is an object that will contain an instance of a CSVReader from the OpenCSV library
// since a CSVReader doesn't contain a search by default (only a read) this object will implement search methods
public class CSVDatabase {

    public CSVDatabase(File file){
    }

    // these methods allows a user to search schools, research, and classes WITH NO input
    public String searchSchools(){
        return null;
    }

    public String searchResearch(){
        return null;
    }
    public String searchClasses(){
        return null;
    }

    // these methods allows a user to search schools, research, and classes WITH input
    public String[] searchSchools(String[] search){
        return null;
    }

    public String[] searchResearch(String[] search){
        return null;
    }
    public String[] searchClasses(String[] search){
        return null;
    }

    // this checks if something already exists (valid types would be "Project","Course", etc.)
    public boolean exists(String type, String name){
        return true;
    }

    public void addCourse(String name){
    }

    public void addProject(String name){
    }

}
