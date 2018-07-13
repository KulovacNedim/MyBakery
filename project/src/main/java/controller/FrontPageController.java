package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.ProductService;

@Controller
public class FrontPageController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String showFrontPage(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "home";
    }

}
