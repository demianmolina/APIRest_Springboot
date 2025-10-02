package com.garaje.ideas.employees.repository;

import com.garaje.ideas.employees.model.Employee;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public EmployeeRepository() {
        employees.add(new Employee(1L, "Juan", "Pérez", "Developer"));
        employees.add(new Employee(2L, "María", "Gómez", "Designer"));
        employees.add(new Employee(3L, "Carlos", "López", "Manager"));
        idCounter.set(3);
    }

    public List<Employee> findAll() { return employees; }
    public Optional<Employee> findById(Long id) {
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst();
    }
    public Employee save(Employee e) {
        if (e.getId() == null) e.setId(idCounter.incrementAndGet());
        employees.removeIf(emp -> emp.getId().equals(e.getId()));
        employees.add(e);
        return e;
    }
    public boolean deleteById(Long id) {
        return employees.removeIf(e -> e.getId().equals(id));
    }
}
