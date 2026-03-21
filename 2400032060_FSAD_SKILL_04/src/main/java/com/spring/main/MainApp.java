package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.entity.Student;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Student s1 = (Student) context.getBean("student1");
        s1.display();

        Student s2 = (Student) context.getBean("student2");
        s2.display();
    }
}