
package com.example.week05.starter;


import org.springframework.beans.factory.annotation.Autowired;

public class School implements ISchool {

    @Autowired
    private Klasss class1;

    @Autowired
    private Student student01;

    @Override
    public void ding() {
        System.out.println("Class1 have " +
                this.class1.getStudents().size() +
                " students and one is " + this.student01);
    }
}
