package dao;

import model.Ingredient;
import model.Product;

import java.util.ArrayList;

public interface IngredientDAO {

    Ingredient getIngredientById(int id);
    Ingredient getIngredientByName(String name);
    ArrayList<Ingredient> getIngredientsOfProduct(Product product);
    boolean addIngredient(Ingredient ingredient);
    boolean deleteIngredient(Ingredient ingredient);
    boolean updateIngredient(Ingredient ingredient);
}
