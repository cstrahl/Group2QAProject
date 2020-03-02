package com.group2.tqa.entities;

import java.util.List;

public class School {

    private long id;

    private String name;

    private State state;

    private String initials;

    private List<Tag> altNames;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public List<Tag> getAltNames() {
        return altNames;
    }

    public void setAltNames(List<Tag> altNames) {
        this.altNames = altNames;
    }
}
