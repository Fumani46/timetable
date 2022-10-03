package com.example.demo.api.model;

import lombok.Data;

@Data
public class RegisterUser {

    private String StudentID;
    private String StudNo;
    private String FirstName;
    private String LastName;
    private String Email;
    private String password;
}
