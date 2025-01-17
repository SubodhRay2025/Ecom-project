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
    public Product getSingleProduct(Long productId) {
          FakeStoreProductsDtos fakeStoreProductsDtos=restTemplate.getForObject("https://fakestoreapi.com/products/" + productId, FakeStoreProductsDtos.class);

//        assert fakeStoreProductsDtos != null;
        return convertFakeStoreProductDtoToProduct(fakeStoreProductsDtos);
    }


    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductsDtos[] fakeStoreProductsDtos=
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductsDtos[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductsDtos fakeStoreProductsDto:fakeStoreProductsDtos){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductsDto));
        }
        return products;
    }
    @Override
    public void updateProduct(Long productId, Product product) {

    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductsDtos fakeStoreProductsDtos){
        Product product=new Product();
//        assert fakeStoreProductsDtos != null;
        product.setId(fakeStoreProductsDtos.getId());

        Category category = new Category();
        category.setDescription(fakeStoreProductsDtos.getDescription());
        category.setName(fakeStoreProductsDtos.getCategory());
        product.setCategory(category);
//        product.setCategory(new Category(fakeStoreProductsDtos.getCategory(),
//                fakeStoreProductsDtos.getDescription()));
        product.setTitle(fakeStoreProductsDtos.getTitle());
        product.setPrice(fakeStoreProductsDtos.getPrice());
        return product;
    }
}
