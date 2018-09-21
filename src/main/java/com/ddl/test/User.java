package com.ddl.test;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class User implements Serializable {

    private int id;
    private String name;
    private int age;
    private String mobile;

}
