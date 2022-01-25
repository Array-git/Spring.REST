package org.spring.rest.controller;

import org.spring.rest.entity.Employee;
import org.spring.rest.exception_handling.EmployeeIncorrectData;
import org.spring.rest.exception_handling.NoSuchEmployeeException;
import org.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee==null) {
            throw new NoSuchEmployeeException("No employee with ID = " + id + " in DB.");
        }
        return employee;
    }
}