package com.bakery.configuration;

import com.bakery.dao.ProductCategoryDAO;
import com.bakery.dao.ProductDAO;
import com.bakery.dao.RoleDAO;
import com.bakery.dao.UserDAO;
import com.bakery.model.Product;
import com.bakery.model.ProductCategory;
import com.bakery.model.Role;
import com.bakery.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Profile("dev")
@Component
public class DatabaseSeeder implements ApplicationRunner {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        seedCategories();
        seedProducts();
        seedRoles();
        seedUsers();

        System.out.println("Get Products By Category");
        for (Product product : productDAO.getProductsByProductCategory(productCategoryDAO.getProductCategoryByCategory("Bread"))) {
            System.out.println(product.toString());
        }
    }

    private void seedProducts() {
        if (productDAO.count() == 0) {
            List<Product> products = new ArrayList<>();
            List<ProductCategory> productCategories = productCategoryDAO.findAll();

            products.add(new Product("Ordinary bread", 2.5 , "Description for just Ordinary bread" , "productImage" , productCategories.get(0)));
            products.add(new Product("Whole weath bread", 3.5 , "Description for just Whole weath bread" , "productImage" , productCategories.get(0)));
            products.add(new Product("Anadama bread", 3.5 , "Description for just Anadama bread" , "productImage" , productCategories.get(0)));
            products.add(new Product("Cuban bread", 3.5 , "Description for just Cuban bread" , "productImage" , productCategories.get(0)));
            products.add(new Product("Salt-rising bread", 3.5 , "Description for just Salt-rising bread" , "productImage" , productCategories.get(0)));
            products.add(new Product("Honey crepes", 1.0 , "Description for Honey crepes" , "productImage" , productCategories.get(1)));
            products.add(new Product("Jam crepes", 1.5 , "Description for just Jam crepes" , "productImage" , productCategories.get(1)));
            products.add(new Product("Cheese sandwich", 4.5 , "Description for just Cheese sandwich" , "productImage" , productCategories.get(2)));
            products.add(new Product("Tuna sandwich", 3.5 , "Description for just Tuna sandwich" , "productImage" , productCategories.get(2)));
            products.add(new Product("Afghan biscuit", 3.5 , "Description for just Afghan biscuit" , "productImage" , productCategories.get(3)));
            products.add(new Product("Almond biscuit", 3.5 , "Description for just Almond biscuit" , "productImage" , productCategories.get(3)));
            products.add(new Product("Fortune cookie", 3.5 , "Description for just Fortune cookie" , "productImage" , productCategories.get(3)));
            products.add(new Product("Rice cracker", 3.5 , "Description for just Rice cracker" , "productImage" , productCategories.get(4)));
            products.add(new Product("Cheese cracker", 3.5 , "Description for just Cheese cracker\"" , "productImage" , productCategories.get(4)));

            productDAO.saveAll(products);
        }
    }

    private void seedCategories() {
        if (productCategoryDAO.count() == 0)  {
            List<ProductCategory> productCategories = new ArrayList<>();

            productCategories.add(new ProductCategory("Bread"));
            productCategories.add(new ProductCategory("Creep"));
            productCategories.add(new ProductCategory("Sandwich"));
            productCategories.add(new ProductCategory("Cookie"));
            productCategories.add(new ProductCategory("Cracker"));

            productCategoryDAO.saveAll(productCategories);
        }
    }

    private void seedRoles() {
        if (roleDAO.count() == 0) {
            List<Role> roles = new ArrayList<>();

            roles.add(new Role("Admin"));
            roles.add(new Role("Customer"));
            roles.add(new Role("Manager"));
            roles.add(new Role("Cook"));
            roles.add(new Role("Waiter"));

            roleDAO.saveAll(roles);
        }
    }

    private void seedUsers() {
        if (userDAO.count() == 0) {
            List<User> users = new ArrayList<>();
            List<Role> roles = roleDAO.findAll();

            users.add(new User("Dino", "Spreco", "dinospreco@gmail.com", "password", "123456789", roles.get(0)));
            users.add(new User("Nedim", "Kulovac", "kulvacnedim@gmail.com", "password", "456789123", roles.get(0)));
            users.add(new User("Zeljko", "Dobrojevic", "zeljkodobrojevic@gmail.com", "password", "465789159", roles.get(0)));
            users.add(new User("Ilinka", "Poletan", "ilinkapoletan@gmail.com", "password", "789624123", roles.get(1)));
            users.add(new User("Mujo", "Ramic", "mujoramic@gmail.com", "password", "789654123", roles.get(1)));
            users.add(new User("Jasmin", "Mustafic", "jasminmustafic@gmail.com", "password", "951753456", roles.get(2)));
            users.add(new User("Sipo", "Sipolo", "sipolo@gmail.com", "password", "154654873", roles.get(2)));
            users.add(new User("Moral", "Porasto", "porasto@gmail.com", "password", "356214987", roles.get(1)));
            users.add(new User("Sime", "Vrsaljko", "vrsaljko@gmail.com", "password", "225632145", roles.get(1)));
            users.add(new User("Vladimir", "Putin", "putin@gmail.com", "password", "369852147", roles.get(3)));
            users.add(new User("Josip", "Broz", "tito@gmail.com", "password", "948758147", roles.get(4)));
            users.add(new User("Spicek", "Mirko", "spicek@gmail.com", "password", "236514589", roles.get(4)));
//
            userDAO.saveAll(users);
        }
    }


}
