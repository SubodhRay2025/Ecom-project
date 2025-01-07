package com.ecommerce.ecom.services;

import com.ecommerce.ecom.dtos.FakeStoreProductsDtos;
import com.ecommerce.ecom.modal.Category;
import com.ecommerce.ecom.modal.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeProductStoreServices implements ProductServices {
    RestTemplate restTemplate;
    public FakeProductStoreServices(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long ProductId) {
          FakeStoreProductsDtos fakeStoreProductsDtos=restTemplate.getForObject("http://localhost:8080/products/" + ProductId, FakeStoreProductsDtos.class);

        assert fakeStoreProductsDtos != null;
        return convertFakeStoreProductDtoToProduct(fakeStoreProductsDtos);
    }


    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductsDtos fakeStoreProductsDtos){
        Product product=new Product();
//        assert fakeStoreProductsDtos != null;
        product.setId(fakeStoreProductsDtos.getId());
        product.setCategory(new Category(fakeStoreProductsDtos.getCategory(),
                fakeStoreProductsDtos.getDescription()));
        product.setTitle(fakeStoreProductsDtos.getTitle());
        product.setPrice(fakeStoreProductsDtos.getPrice());
        return product;
    }
}
