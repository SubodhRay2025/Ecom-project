package com.ecommerce.ecom.services;

import com.ecommerce.ecom.modal.Product;

import java.util.List;

public interface ProductServices {

    Product getSingleProduct(Long id);
    List<Product> getAllProducts();
    Product updateProduct(Long id, Product product);
}
