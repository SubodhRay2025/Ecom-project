package com.ecommerce.ecom.dtos;

import com.ecommerce.ecom.modal.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductsDtos {
    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
