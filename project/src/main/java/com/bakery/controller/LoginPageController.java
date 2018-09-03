package com.bakery.controller;

import com.bakery.dao.CompanyDAO;
import com.bakery.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

    @Autowired
    private CompanyDAO companyDAO;

    @GetMapping("/login")
    public String getLoginPage(Model model) {

        Company company = companyDAO.findByIsActive(true);

        model.addAttribute("company",company);

        return "login";
    }
}
