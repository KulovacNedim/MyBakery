package com.bakery.dao;

import com.bakery.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDAO extends JpaRepository<Ingredient, Long> {
}
