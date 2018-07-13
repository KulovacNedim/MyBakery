package com.bakery.controller;

import com.bakery.model.Product;
import com.bakery.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FrontPageController {

    @Autowired
    private ProductService productService;

    @GetMapping("/test")
    public String getAllProducts(Model model) {

        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "home";
    }

}
