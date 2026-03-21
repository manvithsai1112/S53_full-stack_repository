package com.inventory.demo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.inventory.entity.Product;
import com.inventory.loader.ProductDataLoader;
import com.inventory.util.HibernateUtil;

public class HQLDemo {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        // Load data
        ProductDataLoader.loadData(session);

        // 🔹 SORT ASC
        Query<Product> q1 = session.createQuery("FROM Product p ORDER BY p.price ASC", Product.class);
        System.out.println("\nPrice ASC:");
        q1.list().forEach(System.out::println);

        // 🔹 SORT DESC
        Query<Product> q2 = session.createQuery("FROM Product p ORDER BY p.price DESC", Product.class);
        System.out.println("\nPrice DESC:");
        q2.list().forEach(System.out::println);

        // 🔹 QUANTITY DESC
        Query<Product> q3 = session.createQuery("FROM Product p ORDER BY p.quantity DESC", Product.class);
        System.out.println("\nQuantity DESC:");
        q3.list().forEach(p -> System.out.println(p.getName()+" "+p.getQuantity()));

        // 🔹 PAGINATION
        Query<Product> q4 = session.createQuery("FROM Product", Product.class);
        q4.setFirstResult(0);
        q4.setMaxResults(3);
        System.out.println("\nFirst 3:");
        q4.list().forEach(System.out::println);

        Query<Product> q5 = session.createQuery("FROM Product", Product.class);
        q5.setFirstResult(3);
        q5.setMaxResults(3);
        System.out.println("\nNext 3:");
        q5.list().forEach(System.out::println);

        // 🔹 COUNT
        Long count = session.createQuery("SELECT COUNT(p) FROM Product p", Long.class).uniqueResult();
        System.out.println("\nTotal: "+count);

        // 🔹 GROUP BY
        List<Object[]> group = session.createQuery(
                "SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description",
                Object[].class).list();

        System.out.println("\nGroup:");
        for(Object[] row : group){
            System.out.println(row[0]+" -> "+row[1]);
        }

        // 🔹 MIN MAX
        Object[] minmax = session.createQuery(
                "SELECT MIN(p.price), MAX(p.price) FROM Product p",
                Object[].class).uniqueResult();

        System.out.println("\nMin: "+minmax[0]);
        System.out.println("Max: "+minmax[1]);

        // 🔹 WHERE
        Query<Product> range = session.createQuery(
                "FROM Product p WHERE p.price BETWEEN 30 AND 80", Product.class);
        System.out.println("\nRange:");
        range.list().forEach(System.out::println);

        // 🔹 LIKE
        Query<Product> like = session.createQuery(
                "FROM Product p WHERE p.name LIKE 'D%'", Product.class);
        System.out.println("\nStarts with D:");
        like.list().forEach(p -> System.out.println(p.getName()));

        session.close();
        factory.close();
    }
}