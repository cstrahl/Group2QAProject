package com.group2.tqa.database;

import com.group2.tqa.entities.OfferedClass;
import com.group2.tqa.entities.Project;
import com.group2.tqa.entities.School;

import java.util.List;

public interface CSVDatabase {
    // these methods allows a user to search schools, research, and classes WITH NO input
    List<School> searchSchools();

    List<Project> searchResearch();

    List<OfferedClass> searchClasses();

    // these methods allows a user to search schools, research, and classes WITH input
    List<School> searchSchools(String[] search);

    List<Project> searchResearch(String[] search);

    List<OfferedClass> searchClasses(String[] search);

    // this checks if something already exists (valid types would be "Project","Course", etc.)
    boolean exists(String type, String name);

    void addCourse(String name);

    void addProject(String name);
}
