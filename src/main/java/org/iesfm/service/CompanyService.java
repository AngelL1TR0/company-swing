package org.iesfm.service;

import org.iesfm.dto.Department;
import org.iesfm.dto.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CompanyService {
    private Map<String, Department> departments = new HashMap<>();

    private Map<String, Employee> employees = new HashMap<>();


    public boolean add(Department department) {
        return departments.putIfAbsent(department.getName(), department) == null;
    }

    public boolean delete(String departmentName) {
        return departments.remove(departmentName) != null;
    }

    public List<Department> getDepartments() {
        return new LinkedList<>(departments.values());
    }

    public List<Employee> getEmployees() {
        return new LinkedList<>(employees.values());
    }

    public boolean addEmployee(Employee employee) {
        return employees.putIfAbsent(employee.getNif(), employee) == null;
    }

    public boolean deleteEmployee(String nif) {
        return employees.remove(nif) != null;
    }

}