package com.example.demo.api.controller;

import com.example.demo.api.model.LoginUser;
import com.example.demo.api.model.RegisterUser;
import com.example.demo.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.concurrent.ExecutionException;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login/{uniqueID}")
    public String getRegisteredUsers(RedirectAttributes redirectAttributes, LoginUser loginUser, Model model, HttpSession httpSession) throws ExecutionException, InterruptedException {
        RegisterUser registerUser = new RegisterUser();
        registerUser = loginService.getRegisteredUsers(loginUser);

        model.addAttribute("login",registerUser);

        if(registerUser == null){
            redirectAttributes.addFlashAttribute("error", true);
            return "redirect:/login";
        }else if(loginUser.getEmail().equals(registerUser.getEmail()) && loginUser.getPassword().equals(registerUser.getPassword())){
            redirectAttributes.addFlashAttribute("message", "Welcome "+ registerUser.getFirstName());

            httpSession.setAttribute("StudentId", registerUser.getStudentID());
            return "redirect:/timetable";
        }else
            redirectAttributes.addFlashAttribute("error", true);
        return "redirect:/login";

    }
}
