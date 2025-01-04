package com.ecommerce.ecom.controller;


import com.ecommerce.ecom.modal.Category;
import com.ecommerce.ecom.modal.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductContoller {

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return new Product();
    }
    @GetMapping()
    public List<Product>getAllProducts(){
        return new ArrayList<>();
    }
}
