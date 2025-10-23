package com.garaje.ideas.employees_web.dto;

public class EmployeeRequest {
    private String name;
    private String lastName;
    private String position;

    public EmployeeRequest() {}

    public EmployeeRequest(String name, String lastName, String position) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
