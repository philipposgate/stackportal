package com.posgate.stackportal.model;

public class StackPortalModel {
    
    private String name;

    @Override
    public String toString() {
        return "StackPortalModel [name=" + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
