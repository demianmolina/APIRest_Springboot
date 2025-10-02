package com.garaje.ideas.employees.service.impl;

import com.garaje.ideas.employees.dto.EmployeeRequest;
import com.garaje.ideas.employees.dto.EmployeeResponse;
import com.garaje.ideas.employees.exception.NotFoundException;
import com.garaje.ideas.employees.mapper.EmployeeMapper;
import com.garaje.ideas.employees.model.Employee;
import com.garaje.ideas.employees.repository.EmployeeRepository;
import com.garaje.ideas.employees.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repo;
    public EmployeeServiceImpl(EmployeeRepository repo) { this.repo = repo; }

    @Override
    public EmployeeResponse create(EmployeeRequest req) {
        Employee e = EmployeeMapper.toEntity(req, null);
        repo.save(e);
        return EmployeeMapper.toResponse(e);
    }
    @Override
    public List<EmployeeResponse> list() {
        return EmployeeMapper.toResponseList(repo.findAll());
    }
    @Override
    public EmployeeResponse getById(Long id) {
        Employee e = repo.findById(id).orElseThrow(() -> new NotFoundException("Empleado no encontrado"));
        return EmployeeMapper.toResponse(e);
    }
    @Override
    public EmployeeResponse update(Long id, EmployeeRequest req) {
        Employee existing = repo.findById(id).orElseThrow(() -> new NotFoundException("Empleado no encontrado"));
        existing.setName(req.getName());
        existing.setLastName(req.getLastName());
        existing.setPosition(req.getPosition());
        repo.save(existing);
        return EmployeeMapper.toResponse(existing);
    }
    @Override
    public void delete(Long id) {
        if (!repo.deleteById(id)) throw new NotFoundException("Empleado no encontrado");
    }
}
