package com.api.v1.employees.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super("The sought employee was not found.");
    }
}
