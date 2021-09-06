package com.technoelevate.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Employee implements Serializable{  
private int id;  
private String password;
private String name;  
private String designation;
private double salary;   
}  