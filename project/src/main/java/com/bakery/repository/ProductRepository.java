package com.bakery.repository;

import com.bakery.model.Product;
import com.bakery.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> getProductsByProductCategory(ProductCategory productCategory);

}
