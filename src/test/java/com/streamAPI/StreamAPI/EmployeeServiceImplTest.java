package com.streamAPI.StreamAPI;

import com.streamAPI.StreamAPI.exception.EmployeeAlreadyAddedException;
import com.streamAPI.StreamAPI.exception.EmployeeNotFoundException;
import com.streamAPI.StreamAPI.exception.EmployeeStorageIsFullException;
import com.streamAPI.StreamAPI.service.EmployeeService;
import com.streamAPI.StreamAPI.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static com.streamAPI.StreamAPI.EmployeeTestConstants.*;
import static java.util.List.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Test
    public void shouldAddEmployee() {
        assertEquals(0, employeeService.findAll().size());


        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME);
        assertEquals(1, employeeService.findAll().size());
        assertTrue(employeeService.findAll().contains(addedEmployee));
    }

    @Test
    public void shouldThrowEmployeeStorageIsFullException() {
        employeeService.add(FIRST_NAME, LAST_NAME);
        employeeService.add(FIRST_NAME2, LAST_NAME2);
        employeeService.add(FIRST_NAME3, LAST_NAME3);
        employeeService.add(FIRST_NAME4, LAST_NAME4);
        employeeService.add(FIRST_NAME5, LAST_NAME5);
        employeeService.add(FIRST_NAME6, LAST_NAME6);
        employeeService.add(FIRST_NAME7, LAST_NAME7);
        employeeService.add(FIRST_NAME8, LAST_NAME8);
        employeeService.add(FIRST_NAME9, LAST_NAME9);
        employeeService.add(FIRST_NAME10, LAST_NAME10);

        assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.add(FIRST_NAME11, LAST_NAME11));
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedException() {
        employeeService.add(FIRST_NAME, LAST_NAME);
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.add(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void shouldRemoveEmployee() {
        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME);

        Employee removedEmployee = employeeService.remove(FIRST_NAME, LAST_NAME);
        assertFalse(employeeService.findAll().contains(addedEmployee));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenRemove() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.remove(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void shouldFindEmployee() {
        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME);

        assertEquals(addedEmployee, employeeService.find(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void shouldThrowEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.find(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void shouldFindAllEmployees() {
        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME);
        Employee addedEmployee2 = employeeService.add(FIRST_NAME2, LAST_NAME2);


        Collection<Employee> addedEmployees = employeeService.findAll();
        assertIterableEquals(List.of(addedEmployee, addedEmployee2), addedEmployees);
    }
}
