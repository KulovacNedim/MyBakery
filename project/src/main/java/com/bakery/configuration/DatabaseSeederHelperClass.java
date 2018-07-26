package com.bakery.configuration;

import com.bakery.model.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Profile("dev")
@Component
public class DatabaseSeederHelperClass {


    static List<Privilege> getALLPrivilegesList() {
        List<Privilege> privileges = new ArrayList<>();

        privileges.addAll(getProductCrudPrivileges());
        privileges.addAll(getRoleCrudPrivileges());

        return privileges;
    }

    static List<Privilege> getRoleCrudPrivileges() {
        List<Privilege> rolePrivileges = new ArrayList<>();

        rolePrivileges.add(new Privilege("CREATE_ROLE"));
        rolePrivileges.add(new Privilege("VIEW_ROLE"));
        rolePrivileges.add(new Privilege("DELETE_ROLE"));
        rolePrivileges.add(new Privilege("MODIFY_ROLE"));

        return rolePrivileges;
    }

    static List<Privilege> getProductCrudPrivileges() {
        List<Privilege> productPrivileges = new ArrayList<>();

        productPrivileges.add(new Privilege("CREATE_PRODUCT"));
        productPrivileges.add(new Privilege("VIEW_PRODUCT"));
        productPrivileges.add(new Privilege("DELETE_PRODUCT"));
        productPrivileges.add(new Privilege("MODIFY_PRODUCT"));

        return productPrivileges;
    }

    static List<Role> getRoleList() {
        List<Role> roles = new ArrayList<>();

        roles.add(new Role("ROLE_PRODUCT_CRUD"));
        roles.add(new Role("ROLE_ROLE_CRUD"));

        return roles;
    }

    static List<Ingredient> getIngrediendList() {
        List<Ingredient> ingredients = new ArrayList<>();

        ingredients.add(new Ingredient("Flour"));
        ingredients.add(new Ingredient("Water"));
        ingredients.add(new Ingredient("Salt"));
        ingredients.add(new Ingredient("Sugar"));
        ingredients.add(new Ingredient("Honey"));
        ingredients.add(new Ingredient("Jam"));
        ingredients.add(new Ingredient("Butter"));
        ingredients.add(new Ingredient("Eggs"));
        ingredients.add(new Ingredient("Milk"));
        ingredients.add(new Ingredient("Baking powder"));
        ingredients.add(new Ingredient("Rice"));
        ingredients.add(new Ingredient("Chese"));
        ingredients.add(new Ingredient("Tuna"));
        ingredients.add(new Ingredient("Almond"));
        ingredients.add(new Ingredient("Fortune"));         //14
        ingredients.add(new Ingredient("Bread"));           //15
        ingredients.add(new Ingredient("Cocoa"));           //16
        ingredients.add(new Ingredient("Cornflakes"));      //17
        ingredients.add(new Ingredient("Walnuts"));         //18
        ingredients.add(new Ingredient("Vanilla extraxt")); //19

        return ingredients;
    }

    static List<ProductCategory> getProductCategoryList() {
        List<ProductCategory> productCategories = new ArrayList<>();

        productCategories.add(new ProductCategory("Bread"));
        productCategories.add(new ProductCategory("Crepe"));
        productCategories.add(new ProductCategory("Sandwich"));
        productCategories.add(new ProductCategory("Cookie"));
        productCategories.add(new ProductCategory("Cracker"));

        return productCategories;
    }

    static List<Product> getProductList() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Ordinary bread", 2.5, "Description for just Ordinary bread", "productImage"));
        products.add(new Product("Whole wheat bread", 3.5, "Description for just Whole weath bread", "productImage"));
        products.add(new Product("Anadama bread", 3.5, "Description for just Anadama bread", "productImage"));
        products.add(new Product("Cuban bread", 3.5, "Description for just Cuban bread", "productImage"));
        products.add(new Product("Salt-rising bread", 3.5, "Description for just Salt-rising bread", "productImage"));
        products.add(new Product("Honey crepes", 1.0, "Description for Honey crepes", "productImage"));
        products.add(new Product("Jam crepes", 1.5, "Description for just Jam crepes", "productImage"));
        products.add(new Product("Cheese sandwich", 4.5, "Description for just Cheese sandwich", "productImage"));
        products.add(new Product("Tuna sandwich", 3.5, "Description for just Tuna sandwich", "productImage"));
        products.add(new Product("Afghan biscuit", 3.5, "Description for just Afghan biscuit", "productImage"));
        products.add(new Product("Almond biscuit", 3.5, "Description for just Almond biscuit", "productImage"));
        products.add(new Product("Fortune cookie", 3.5, "Description for just Fortune cookie", "productImage"));
        products.add(new Product("Rice cracker", 3.5, "Description for just Rice cracker", "productImage"));
        products.add(new Product("Cheese cracker", 3.5, "Description for just Cheese cracker\"", "productImage"));

        return products;
    }

    static List<User> getUserList() {
        List<User> users = new ArrayList<>();

        users.add(new User("Dino", "Spreco", "testemail1@gmail.com", "password1", "123456789"));
        users.add(new User("Nedim", "Kulovac", "testemail2@gmail.com", "password2", "223456789"));
        users.add(new User("Zeljko", "Dobrojevic", "testemail3@gmail.com", "password3", "323456789"));
        users.add(new User("Mujo", "Ramic", "testemail4@gmail.com", "password4", "423456789"));
        users.add(new User("Slobodan", "Vukovic", "testemail5@gmail.com", "password5", "523456789"));
        users.add(new User("Boris", "Nunic", "testemail6@gmail.com", "password6", "623456789"));
        users.add(new User("Ilinka", "Poletan", "testemail7@gmail.com", "password7", "723456789"));
        users.add(new User("Jasmin", "Mustafic", "testemail8@gmail.com", "password8", "823456789"));
        users.add(new User("Dejan", "Sipovac", "testemail9@gmail.com", "password9", "923456789"));

        return users;
    }
}
