package com.streamAPI.StreamAPI.controller;

import com.streamAPI.StreamAPI.Employee;
import com.streamAPI.StreamAPI.exception.IllegalArgumentException;
import com.streamAPI.StreamAPI.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.add(firstName, lastName);
    }
    @GetMapping("/add2")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam int departmentId,
                        @RequestParam int salary) {
        return employeeService.add(firstName, lastName, departmentId, salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }

}
