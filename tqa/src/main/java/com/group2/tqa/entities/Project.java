package com.group2.tqa.entities;

import java.util.List;

public class Project {

    private long id;

    private String name;

    private School school;

    private List<Person> faculty;

    private List<Person> students;

    private double funding;

    private List<Tag> subjects;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Person> getFaculty() {
        return faculty;
    }

    public void setFaculty(List<Person> faculty) {
        this.faculty = faculty;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    public double getFunding() {
        return funding;
    }

    public void setFunding(double funding) {
        this.funding = funding;
    }

    public List<Tag> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Tag> subjects) {
        this.subjects = subjects;
    }
}
