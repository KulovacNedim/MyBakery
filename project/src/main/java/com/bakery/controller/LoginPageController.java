package com.bakery.controller;

import com.bakery.model.User;
import com.bakery.repository.CompanyRepository;
import com.bakery.repository.RoleRepository;
import com.bakery.model.Company;
import com.bakery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginPageController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/login", "/registration"}, method = RequestMethod.GET)
    public String getLoginPage(Model model) {

        Company company = companyRepository.findByIsActive(true);
        User user = new User();

        model.addAttribute("user", user);
        model.addAttribute("company",company);

        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        System.out.println("//////////////////////////////////////////////////////////////////ffffffffffffffffffffffffffffffffffffffff");
        ModelAndView modelAndView = new ModelAndView();
        Company company = companyRepository.findByIsActive(true);
        modelAndView.addObject("company", company);


        if (user.getPassword().equals(user.getPasswordConfirm())) {
            User userExists = userService.findUserByEmail(user.getEmail());
            if (userExists != null) {
                bindingResult
                        .rejectValue("email", "error.user",
                                "There is already a user registered with the email provided");
            }
            if (bindingResult.hasErrors()) {
                modelAndView.setViewName("login");
            } else {
                user.setRole(roleRepository.findByName("Client"));
                userService.saveUser(user);
                modelAndView.addObject("successMessage", "User has been registered successfully");
                modelAndView.addObject("user", new User());
                modelAndView.setViewName("login");
                System.out.println("moedl and wiew: " + modelAndView);
            }
        } else {
            bindingResult
                    .rejectValue("passwordConfirm", "error.password",
                            "Password and Confirm Password is not match!");
            modelAndView.setViewName("login");
        }


        return modelAndView;
    }

//    @RequestMapping(value="/registration", method = RequestMethod.GET)
//    public void registrationRedirect(Model model){
//
//
//        return "login";
//    }
//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute("user") User user, BindingResult bindingResult, HttpServletRequest request) {
//        userService.saveUser(user);
//        return "login";
//    }
}
