package com.streamAPI.StreamAPI.service;

import com.streamAPI.StreamAPI.Employee;

import java.util.Collection;

public interface EmployeeService {
//    Employee add(Employee employee);
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);
    int getTotalSalary();

    Collection<Employee> findAll();

//    Employee add(String firstName, String lastName);
}
