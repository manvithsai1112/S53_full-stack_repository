package com.autowire.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id = 101;
    private String name = "Manvith";
    private String gender = "Male";

    // 🔹 Autowiring
    @Autowired
    private Certification certification;

    public void display() {
        System.out.println(id + " " + name + " " + gender);
        System.out.println("Certification: " + certification);
    }
}