package com.streamAPI.StreamAPI.service;

import com.streamAPI.StreamAPI.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int departmentId, int salary);
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> findAll();

}
