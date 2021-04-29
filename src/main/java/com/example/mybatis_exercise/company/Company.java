package com.example.mybatis_exercise.company;

import com.example.mybatis_exercise.employee.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class Company {

    private int id;
    private String name;
    private String address;
    private List<Employee> employeeList;


}
