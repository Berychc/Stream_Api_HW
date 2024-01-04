package com.StreamApi.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceIml implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private final EmployeeService employeeService;

    public EmployeeServiceIml(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartament() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee getEmployeeWithMinSalary(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartament() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public List<Employee> getAllEmployees(Integer departmentId) {
        Stream<Employee> employeeStream = employeeService.getAllEmployees().stream();

        if (departmentId != null) {
            employeeStream = employeeStream.filter(employee -> employee.getDepartament() == departmentId);
        }

        return employeeStream.collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesGrouped() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartament));
    }
}
