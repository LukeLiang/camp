
package com.example.week05.starter;

import com.sun.xml.internal.bind.v2.schemagen.episode.Klass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Collections;

@Configuration
@EnableConfigurationProperties(KlassProperties.class)
public class KlassConfiguration {


    @Bean
    @Order(100)
    public Student student01() {
        return new Student("zhangsan", 12);
    }

    @Bean
    @Order(101)
    public Klasss klass1() {
        return new Klasss(new ArrayList<Student>(Collections.singleton(student01())));
    }
}
