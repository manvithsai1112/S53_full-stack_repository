package com.autowire.entity;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 1;
    private String name = "Java Certification";
    private String dateOfCompletion = "2026";

    public String toString() {
        return id + " " + name + " " + dateOfCompletion;
    }
}