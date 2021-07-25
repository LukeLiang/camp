
package com.example.week05.jdbc;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class User implements Serializable {


    private Long id;

    private String name;

    private String job;

}
