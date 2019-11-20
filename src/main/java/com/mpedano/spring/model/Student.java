package com.mpedano.spring.model;

public class Student extends User {

    private String grade;

    private Double Average;

    public Student() {
        super();
    }

    public Student(Integer userId) {
        super();
        this.userId = userId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Double getAverage() {
        return Average;
    }

    public void setAverage(Double average) {
        Average = average;
    }

}
