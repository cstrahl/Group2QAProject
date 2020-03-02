package com.group2.tqa.database;

import com.group2.tqa.entities.OfferedClass;
import com.group2.tqa.entities.Project;
import com.group2.tqa.entities.School;

import java.io.File;
import java.util.ArrayList;
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
    public List<School> searchSchools(){

        List<School> schoolList = new ArrayList<>();
        schoolList.add(new School());

        return schoolList;
    }

    @Override
    public List<Project> searchResearch(){
        return null;
    }
    @Override
    public List<OfferedClass> searchClasses(){
        return null;
    }

    // these methods allows a user to search schools, research, and classes WITH input
    @Override
    public List<School> searchSchools(String[] search){

        if(search == null)
            return null;

        List<School> schoolList = new ArrayList<>();

        for(int i = 0; i < search.length; i++) {
            switch (search[i].toLowerCase()) {
                case "":
                    break;
                case "kennesaw":
                    schoolList.add(new School());
                    break;
            }
        }
        return schoolList;
    }

    @Override
    public List<Project> searchResearch(String[] search){
        return null;
    }
    @Override
    public List<OfferedClass> searchClasses(String[] search){
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
