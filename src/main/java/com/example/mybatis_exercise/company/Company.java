package com.example.mybatis_exercise.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Company {


    private int id;
    private String name;
    private String address;
}
