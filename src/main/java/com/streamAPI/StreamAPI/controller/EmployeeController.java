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

    @GetMapping("add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        String[] names = validateAndCapitalizeName(firstName, lastName);
        return employeeService.add(names[0], names[1]);
    }
    @GetMapping("add2")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam int departmentId,
                        @RequestParam int salary) {
        String[] names = validateAndCapitalizeName(firstName, lastName);
        return employeeService.add(names[0], names[1], departmentId, salary);
    }

    @GetMapping("remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        String[] names = validateAndCapitalizeName(firstName, lastName);
        return employeeService.remove(names[0], names[1]);
    }

    @GetMapping("find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        String[] names = validateAndCapitalizeName(firstName, lastName);
        return employeeService.find(names[0], names[1]);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }

    private String[] validateAndCapitalizeName(String firstName, String lastName) {
        if (StringUtils.isAnyEmpty(firstName, lastName) || !firstName.matches("[A-Za-z]+") || !lastName.matches("[A-Za-z]+"))  {
            throw new IllegalArgumentException();
        }
            firstName = StringUtils.capitalize(firstName);
            lastName = StringUtils.capitalize(lastName);
            return new String[]{firstName, lastName};
    }
}
