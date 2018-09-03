package com.bakery.controller;

import com.bakery.dao.CompanyDAO;
import com.bakery.model.Company;
import com.bakery.model.Product;
import com.bakery.model.ProductCategory;
import com.bakery.services.ProductCategoriesService;
import com.bakery.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class MenuPageController {

    @Autowired
    private CompanyDAO companyDAO;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoriesService productCategoriesService;

    @GetMapping("/menu")
    public String getAllProducts(Model model) {

        List<ProductCategory> categories = productCategoriesService.getAllCategories();
        Company company = companyDAO.findByIsActive(true);

        model.addAttribute("company",company);
        model.addAttribute("categories", categories);

        return "menu";
    }
}
