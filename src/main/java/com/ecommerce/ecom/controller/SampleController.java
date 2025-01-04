package com.ecommerce.ecom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say/")
public class SampleController {
    @GetMapping("/hello/{name}/{time}")
    public String sayHello (@PathVariable("name") String xyz,
                            @PathVariable("time") int count) {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < count; i++) {
            output.append("Hello "+xyz);
        }
        return output.toString();
    }

    @GetMapping("/bye")
    public String sayBye () {
        return "Hello World bye";
    }
}
