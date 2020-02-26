package com.group2.tqa.database;

import java.util.List;

public interface CSVDatabase {
    // these methods allows a user to search schools, research, and classes WITH NO input
    List<String[]> searchSchools();

    List<String[]> searchResearch();

    List<String[]> searchClasses();

    // these methods allows a user to search schools, research, and classes WITH input
    List<String[]> searchSchools(String[] search);

    List<String[]> searchResearch(String[] search);

    List<String[]> searchClasses(String[] search);

    // this checks if something already exists (valid types would be "Project","Course", etc.)
    boolean exists(String type, String name);

    void addCourse(String name);

    void addProject(String name);
}
