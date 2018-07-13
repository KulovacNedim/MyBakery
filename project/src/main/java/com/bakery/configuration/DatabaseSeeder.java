package com.bakery.configuration;

import com.bakery.dao.ProductDAO;
import com.bakery.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;

@Profile("dev")
public class DatabaseSeeder {

    @Autowired
    private ProductDAO productDAO;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedProducts();
    }

    private void seedProducts() {
        if (productDAO.count() == 0) {
            List<Product> products = new ArrayList<>();

            products.add(new Product("Ordinary bread", 2.5 , "Description for just Ordinary bread" , "productImage" , 1L));
            products.add(new Product("Whole weath bread", 3.5 , "Description for just Whole weath bread" , "productImage" , 1L));
            products.add(new Product("Honey crepes", 1.0 , "Description for Honey crepes" , "productImage" , 2L));
            products.add(new Product("Jam crepes", 1.5 , "Description for just Jam crepes" , "productImage" , 2L));
            products.add(new Product("Cheese sandwich", 4.5 , "Description for just Cheese sandwich" , "productImage" , 3L));
            products.add(new Product("Tuna sandwich", 3.5 , "Description for just Tuna sandwich" , "productImage" , 3L));
            productDAO.saveAll(products);
        }
    }

}
