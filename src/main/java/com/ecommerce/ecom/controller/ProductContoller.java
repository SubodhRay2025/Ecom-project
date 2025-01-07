package com.ecommerce.ecom.controller;


import com.ecommerce.ecom.modal.Category;
import com.ecommerce.ecom.modal.Product;
import com.ecommerce.ecom.services.FakeProductStoreServices;
import com.ecommerce.ecom.services.ProductServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductContoller {
     ProductServices productServices;

     public ProductContoller(ProductServices productServices) {
         this.productServices = productServices;
     }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productServices.getSingleProduct(id);
    }
    @GetMapping()
    public List<Product>getAllProducts(){
        return productServices.getAllProducts();
    }
}
