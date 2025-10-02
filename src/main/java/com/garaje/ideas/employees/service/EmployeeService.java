package com.garaje.ideas.employees.service;

import com.garaje.ideas.employees.dto.EmployeeRequest;
import com.garaje.ideas.employees.dto.EmployeeResponse;
import java.util.List;

public interface EmployeeService {
    EmployeeResponse create(EmployeeRequest req);
    List<EmployeeResponse> list();
    EmployeeResponse getById(Long id);
    EmployeeResponse update(Long id, EmployeeRequest req);
    void delete(Long id);
}
