package com.garaje.ideas.employees.dto;

import jakarta.validation.constraints.NotBlank;

public class EmployeeRequest {
    @NotBlank private String name;
    @NotBlank private String lastName;
    @NotBlank private String position;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
}
