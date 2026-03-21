package com.product.repository;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import com.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // 🔹 Derived Queries
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // 🔹 JPQL Queries

    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getAllSorted();

    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> getExpensive(@Param("price") double price);

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> getByCategory(@Param("category") String category);
}