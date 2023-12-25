package com.StreamApi.demo;

import java.util.Objects;

public class Employee {
    private int departament;
    private int salary;

    public Employee(int departament, int salary) {
        this.departament = departament;
        this.salary = salary;
    }

    public int getDepartament() {
        return departament;
    }

    public int getSalary() {
        return salary;

    }

    public void setDepartament(int departament) {
        this.departament = departament;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
