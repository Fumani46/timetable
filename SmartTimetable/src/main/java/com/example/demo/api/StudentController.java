package com.example.demo.api;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping(value = "/SignUp")
    public String authPage(){
        return "StudentSignUp";
    }
}
