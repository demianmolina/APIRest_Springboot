package com.garaje.ideas.employees.mapper;

import com.garaje.ideas.employees.dto.EmployeeRequest;
import com.garaje.ideas.employees.dto.EmployeeResponse;
import com.garaje.ideas.employees.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {
    public static Employee toEntity(EmployeeRequest req, Long id) {
        return new Employee(id, req.getName(), req.getLastName(), req.getPosition());
    }
    public static EmployeeResponse toResponse(Employee e) {
        EmployeeResponse res = new EmployeeResponse();
        res.setId(e.getId());
        res.setName(e.getName());
        res.setLastName(e.getLastName());
        res.setPosition(e.getPosition());
        return res;
    }
    public static List<EmployeeResponse> toResponseList(List<Employee> list) {
        return list.stream().map(EmployeeMapper::toResponse).collect(Collectors.toList());
    }
}
