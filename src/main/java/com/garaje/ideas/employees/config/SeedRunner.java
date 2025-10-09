package com.garaje.ideas.employees.config;

import com.garaje.ideas.employees.dto.EmployeeRequest;
import com.garaje.ideas.employees.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev") // solo corre con el perfil dev activo
public class SeedRunner implements CommandLineRunner {

    private final EmployeeService service;

    public SeedRunner(EmployeeService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        if (!service.list().isEmpty()) return; // si ya hay datos, no sembrar

        EmployeeRequest e1 = new EmployeeRequest();
        e1.setName("Juan"); e1.setLastName("Pérez"); e1.setPosition("Developer");
        service.create(e1);

        EmployeeRequest e2 = new EmployeeRequest();
        e2.setName("María"); e2.setLastName("Gómez"); e2.setPosition("Designer");
        service.create(e2);

        EmployeeRequest e3 = new EmployeeRequest();
        e3.setName("Carlos"); e3.setLastName("López"); e3.setPosition("Manager");
        service.create(e3);
    }
}
