package com.bakery.configuration;

import com.bakery.dao.ProductCategoryDAO;
import com.bakery.dao.ProductDAO;
import com.bakery.model.Product;
import com.bakery.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Profile("dev")
@Component
public class DatabaseSeeder implements ApplicationRunner {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        seedCategories();
        seedProducts();
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

}
