package com.inventory.loader;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.inventory.entity.Product;

public class ProductDataLoader {

    public static void loadData(Session session) {

        Transaction tx = session.beginTransaction();

        session.save(new Product("Dell", "Electronics", 80, 5));
        session.save(new Product("iPhone", "Electronics", 100, 10));
        session.save(new Product("Shoes", "Fashion", 40, 15));
        session.save(new Product("Watch", "Fashion", 60, 7));
        session.save(new Product("Tablet", "Electronics", 70, 12));
        session.save(new Product("Bag", "Fashion", 30, 20));

        tx.commit();
    }
}