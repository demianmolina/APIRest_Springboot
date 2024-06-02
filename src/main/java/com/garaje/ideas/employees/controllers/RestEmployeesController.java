package com.garaje.ideas.employees.controllers;


import com.garaje.ideas.employees.entities.Employee;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestEmployeesController {

    private static final List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(1L, "Juan", "Pérez", "Developer"));
        employees.add(new Employee(2L, "María", "Gómez", "Designer"));
        employees.add(new Employee(3L, "Carlos", "López", "Manager"));
    }

    @GetMapping("/")
    public String home() {
        return "Esta es la página de inicio de la API de empleados.";
    }

    @GetMapping("/employees")
    public List<Employee> employees() {
        return employees;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);

    }

    //@RequestMapping(path = "/employee/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        Employee employee = employees.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
        if (employee != null) {
            employees.remove(employee);
            return "Empleado eliminado correctamente.";
        } else {
            return "Empleado no encontrado.";
        }
    }

    @PostMapping("/employee/")
    public String addEmployee(@RequestBody Employee employee) {
        Long id = employees.stream().mapToLong(Employee::getId).max().orElse(0) + 1;
        employee.setId(id);
        employees.add(employee);
        return "Empleado añadido correctamente.";
    }

    @PutMapping("/employee/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee employeeToUpdate = employees.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
        if (employeeToUpdate != null) {
            employeeToUpdate.setName(employee.getName());
            employeeToUpdate.setLastName(employee.getLastName());
            employeeToUpdate.setPosition(employee.getPosition());
            return "Empleado actualizado correctamente.";
        } else {
            return "Empleado no encontrado.";
        }
    }
}
