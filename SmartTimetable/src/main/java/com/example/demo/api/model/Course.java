package com.example.demo.api.model;

public class Course {
    private String course_id;
    private String course_name;
    private String uniqueID;

    public Course() {
    }

    public Course(String course_id, String course_name, String uniqueID) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.uniqueID = uniqueID;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", uniqueID='" + uniqueID + '\'' +
                '}';
    }
}
