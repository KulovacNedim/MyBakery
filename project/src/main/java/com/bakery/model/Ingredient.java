package com.bakery.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredientId")
    private Long ingredientId;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private Collection<Product> products;

    public Ingredient() {
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient(String name, Collection<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(ingredientId, that.ingredientId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientId, name, products);
    }
}
