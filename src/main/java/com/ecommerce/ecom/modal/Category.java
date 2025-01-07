package com.ecommerce.ecom.modal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseModel {
//    private long id;
    private  String name;
    private  String description;
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
