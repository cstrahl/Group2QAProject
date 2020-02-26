package com.group2.tqa.database;

import java.io.File;
import java.util.List;

// this is an object that will contain an instance of a CSVReader from the OpenCSV library
// since a CSVReader doesn't contain a search by default (only a read) this object will implement search methods
public class NoOpCSVDatabase implements CSVDatabase {

    private File file;

    public NoOpCSVDatabase(final File file){
        this.file = file;
    }

    // these methods allows a user to search schools, research, and classes WITH NO input
    @Override
    public List<String[]> searchSchools(){
        return null;
    }

    @Override
    public List<String[]> searchResearch(){
        return null;
    }
    @Override
    public List<String[]> searchClasses(){
        return null;
    }

    // these methods allows a user to search schools, research, and classes WITH input
    @Override
    public List<String[]> searchSchools(String[] search){
        return null;
    }

    @Override
    public List<String[]> searchResearch(String[] search){
        return null;
    }
    @Override
    public List<String[]> searchClasses(String[] search){
        return null;
    }

    // this checks if something already exists (valid types would be "Project","Course", etc.)
    @Override
    public boolean exists(String type, String name){
        return true;
    }

    @Override
    public void addCourse(String name){
    }

    @Override
    public void addProject(String name){
    }

}
