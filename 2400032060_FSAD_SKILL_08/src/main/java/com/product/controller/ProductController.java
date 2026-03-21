package com.product.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.product.model.Product;
import com.product.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    // Insert sample data
    @PostMapping("/add")
    public String addProduct(@RequestBody Product p) {
        repo.save(p);
        return "Product Added";
    }

    // Category filter
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // Price range
    @GetMapping("/filter")
    public List<Product> filter(@RequestParam double min, @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    // Sorted
    @GetMapping("/sorted")
    public List<Product> sorted() {
        return repo.getAllSorted();
    }

    // Expensive
    @GetMapping("/expensive/{price}")
    public List<Product> expensive(@PathVariable double price) {
        return repo.getExpensive(price);
    }
}