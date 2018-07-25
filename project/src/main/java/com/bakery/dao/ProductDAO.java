package com.bakery.dao;

import com.bakery.model.Product;
import com.bakery.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

    List<Product> getProductsByProductCategory(ProductCategory productCategory);

}
