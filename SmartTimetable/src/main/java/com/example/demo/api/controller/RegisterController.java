package com.example.demo.api.controller;

import com.example.demo.api.model.RegisterUser;
import com.example.demo.api.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutionException;

@Controller
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @RequestMapping("/SignUp")
    public String WriteUsers(@ModelAttribute RegisterUser registerUser, Model model) throws ExecutionException, InterruptedException {
        model.addAttribute("registerUser", registerUser);
        return "register";
    }
}
