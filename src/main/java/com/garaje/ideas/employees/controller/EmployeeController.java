package com.garaje.ideas.employees.controller;

import com.garaje.ideas.employees.dto.EmployeeRequest;
import com.garaje.ideas.employees.dto.EmployeeResponse;
import com.garaje.ideas.employees.exception.UnauthorizedException;
import com.garaje.ideas.employees.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService service;
    public EmployeeController(EmployeeService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> list() {
        return ResponseEntity.ok(service.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> get(
            @PathVariable Long id,
            @RequestHeader(value = "Authorization", required = false) String token) {


        if (token == null || !token.equals("Bearer 1234")) {
            throw new UnauthorizedException("Token inválido o ausente");
        }


        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> create(@Valid @RequestBody EmployeeRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(req));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> update(@PathVariable Long id, @Valid @RequestBody EmployeeRequest req) {
        return ResponseEntity.ok(service.update(id, req));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
