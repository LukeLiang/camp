
package com.example.week05.starter;

import lombok.Data;

import java.util.List;

@Data
public class Klasss {

    List<Student> students;

    public Klasss(List<Student> students) {
        this.students = students;
    }

    public void dong() {
        System.out.println("班级一共有" + this.getStudents().size() + "名同学");
    }
}
