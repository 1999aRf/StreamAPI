package com.streamAPI.StreamAPI.service.impl;

import com.streamAPI.StreamAPI.Employee;
import com.streamAPI.StreamAPI.exception.EmployeeAlreadyAddedException;
import com.streamAPI.StreamAPI.exception.EmployeeNotFoundException;
import com.streamAPI.StreamAPI.exception.EmployeeStorageIsFullException;
import com.streamAPI.StreamAPI.exception.IllegalArgumentException;
import com.streamAPI.StreamAPI.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int EMPLOYEE_STORAGE_SIZE = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee add(String firstName,  String lastName, int departmentId, int salary) {
        String[] names = validateAndCapitalizeName(firstName, lastName);
        Employee employee = new Employee(names[0], names[1], departmentId, salary);
        return add(employee);
    }
    @Override
    public Employee add(String firstName, String lastName) {
        String[] names = validateAndCapitalizeName(firstName, lastName);
        Employee employee = new Employee(names[0], names[1]);
        return add(employee);
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        String[] names = validateAndCapitalizeName(firstName, lastName);
        Employee employee = new Employee(names[0], names[1]);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String[] names = validateAndCapitalizeName(firstName, lastName);
        Employee employee = new Employee(names[0], names[1]);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(employee.getFullName());
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }

    private Employee add(Employee employee) {
        if (employees.size() == EMPLOYEE_STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
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
