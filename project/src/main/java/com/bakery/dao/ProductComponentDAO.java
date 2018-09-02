package com.bakery.dao;

import com.bakery.model.ProductComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductComponentDAO extends JpaRepository<ProductComponent, Long> {

    ProductComponent getProductComponentByName(String name);

}
