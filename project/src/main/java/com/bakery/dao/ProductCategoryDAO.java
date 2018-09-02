package com.bakery.dao;

import com.bakery.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryDAO extends JpaRepository<ProductCategory, Long> {

    ProductCategory getProductCategoryByName(String name);

}
