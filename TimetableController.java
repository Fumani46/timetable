package com.example.demo.api.controller;

import com.example.demo.api.model.Course;
import com.example.demo.api.model.CourseModule;
import com.example.demo.api.model.TimetableSlot;
import com.example.demo.api.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Controller
public class TimetableController {
    @Autowired
    TimetableService timetableService;

    @RequestMapping("/timetable/slot/{uniqueID}")
    public String getTimetableSlot(@PathVariable String uniqueID, Model model) throws ExecutionException, InterruptedException {
    TimetableSlot timetableSlot = new TimetableSlot();
    timetableSlot = timetableService.getTimetableSlot(uniqueID);

    model.addAttribute("courseModule", timetableSlot);

    return "timetable";
    }


    @RequestMapping("/timetable/{uniqueID}")
    public String getAllModule(@PathVariable String uniqueID, Model model) throws ExecutionException, InterruptedException {

        ArrayList<CourseModule> courseModules = new ArrayList<>();
        Course course = new Course();

        course = timetableService.getCourseData(uniqueID);
        courseModules = timetableService.getCourseModules(course.getCourse_id());

        model.addAttribute("course", course);
        model.addAttribute("courseModules", courseModules);

        return "timetable";
    }
}
