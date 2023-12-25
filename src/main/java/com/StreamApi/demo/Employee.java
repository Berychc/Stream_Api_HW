package com.StreamApi.demo;

import java.util.Objects;

public class Employee {
    private int department;
    private int salary;

    public Employee(int department, int salary) {
        this.department = department;
        this.salary = salary;
    }

    public int getDepartament() {
        return department;
    }

    public int getSalary() {
        return salary;

    }

    public void setDepartment(int departament) {
        this.department = departament;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
