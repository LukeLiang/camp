package com.example.week05;

import com.example.week05.starter.Klasss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class Week05Application {

    public static void main(String[] args) {
        SpringApplication.run(Week05Application.class, args);
    }


    @Autowired
    private Klasss klass1;

    @GetMapping("test")
    public void getKlass1() {
        klass1.dong();
    }

}
