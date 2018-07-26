package com.bakery.configuration;

import com.bakery.dao.*;
import com.bakery.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Profile("dev")
@Component
@Transactional
public class DatabaseSeeder implements ApplicationRunner {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private IngredientDAO ingredientDAO;

    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Autowired
    private PrivilegeDAO privilegeDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        seedIngredients();
        seedCategories();
        seedProducts();
        seedPrivileges();
        seedRoles();
        seedUsers();

        updateProductsWithIngredientsAndCategories();
        updateRolesWithPrivileges();
        updateUsersWithRoles();
    }

    private void seedIngredients() {
        if (ingredientDAO.count() == 0) {
            ingredientDAO.saveAll(DatabaseSeederHelperClass.getIngrediendList());
        }
    }

    private void seedProducts() {
        if (productDAO.count() == 0) {
            productDAO.saveAll(DatabaseSeederHelperClass.getProductList());
        }
    }

    private void seedCategories() {
        if (productCategoryDAO.count() == 0) {
            productCategoryDAO.saveAll(DatabaseSeederHelperClass.getProductCategoryList());
        }
    }

    private void seedPrivileges() {
        if (privilegeDAO.count() == 0) {
            privilegeDAO.saveAll(DatabaseSeederHelperClass.getALLPrivilegesList());
        }
    }

    private void seedRoles() {
        if (roleDAO.count() == 0) {
            roleDAO.saveAll(DatabaseSeederHelperClass.getRoleList());
        }
    }

    private void seedUsers() {
        if (userDAO.count() == 0) {
            userDAO.saveAll(DatabaseSeederHelperClass.getUserList());
        }
    }

    private void updateProductsWithIngredientsAndCategories() {
        List<Ingredient> ingredients = ingredientDAO.findAll();
        List<ProductCategory> productCategories = productCategoryDAO.findAll();
        List<Product> products = productDAO.findAll();

        //Updating categories
        //Bread
        products.get(0).setProductCategory(productCategories.get(0));
        products.get(1).setProductCategory(productCategories.get(0));
        products.get(2).setProductCategory(productCategories.get(0));
        products.get(3).setProductCategory(productCategories.get(0));
        products.get(4).setProductCategory(productCategories.get(0));
        //Crepe
        products.get(5).setProductCategory(productCategories.get(1));
        products.get(6).setProductCategory(productCategories.get(1));
        //Sandwich
        products.get(7).setProductCategory(productCategories.get(2));
        products.get(8).setProductCategory(productCategories.get(2));
        //Cookie
        products.get(9).setProductCategory(productCategories.get(3));
        products.get(10).setProductCategory(productCategories.get(3));
        products.get(11).setProductCategory(productCategories.get(3));
        //Cracker
        products.get(12).setProductCategory(productCategories.get(4));
        products.get(13).setProductCategory(productCategories.get(4));

        //Updating ingredints
        List<Ingredient> tmp0 = new ArrayList<Ingredient>();
        tmp0.add(ingredients.get(0));
        tmp0.add(ingredients.get(1));
        tmp0.add(ingredients.get(2));
        tmp0.add(ingredients.get(9));
        products.get(0).setIngredients(tmp0);

        List<Ingredient> tmp1 = new ArrayList<Ingredient>();
        tmp1.add(ingredients.get(0));
        tmp1.add(ingredients.get(1));
        tmp1.add(ingredients.get(2));
        tmp1.add(ingredients.get(9));
        tmp1.add(ingredients.get(15));
        products.get(1).setIngredients(tmp1);

        List<Ingredient> tmp2 = new ArrayList<Ingredient>();
        tmp2.add(ingredients.get(0));
        tmp2.add(ingredients.get(1));
        tmp2.add(ingredients.get(2));
        tmp2.add(ingredients.get(9));
        products.get(2).setIngredients(tmp2);

        List<Ingredient> tmp3 = new ArrayList<Ingredient>();
        tmp3.add(ingredients.get(0));
        tmp3.add(ingredients.get(1));
        tmp3.add(ingredients.get(2));
        tmp3.add(ingredients.get(9));
        products.get(3).setIngredients(tmp3);

        List<Ingredient> tmp4 = new ArrayList<Ingredient>();
        tmp4.add(ingredients.get(0));
        tmp4.add(ingredients.get(1));
        tmp4.add(ingredients.get(2));
        tmp4.add(ingredients.get(9));
        products.get(4).setIngredients(tmp4);

        List<Ingredient> tmp5 = new ArrayList<Ingredient>();
        tmp5.add(ingredients.get(0));
        tmp5.add(ingredients.get(1));
        tmp5.add(ingredients.get(4));
        tmp5.add(ingredients.get(6));
        tmp5.add(ingredients.get(7));
        tmp5.add(ingredients.get(8));
        products.get(5).setIngredients(tmp5);

        List<Ingredient> tmp6 = new ArrayList<Ingredient>();
        tmp6.add(ingredients.get(0));
        tmp6.add(ingredients.get(1));
        tmp6.add(ingredients.get(5));
        tmp6.add(ingredients.get(6));
        tmp6.add(ingredients.get(7));
        tmp6.add(ingredients.get(8));
        products.get(6).setIngredients(tmp6);

        List<Ingredient> tmp7 = new ArrayList<Ingredient>();
        tmp7.add(ingredients.get(11));
        tmp7.add(ingredients.get(15));
        products.get(7).setIngredients(tmp7);

        List<Ingredient> tmp8 = new ArrayList<Ingredient>();
        tmp8.add(ingredients.get(12));
        tmp8.add(ingredients.get(15));
        products.get(8).setIngredients(tmp8);

        List<Ingredient> tmp9 = new ArrayList<Ingredient>();
        tmp9.add(ingredients.get(0));
        tmp9.add(ingredients.get(6));
        tmp9.add(ingredients.get(3));
        tmp9.add(ingredients.get(16));
        tmp9.add(ingredients.get(17));
        tmp9.add(ingredients.get(18));
        products.get(9).setIngredients(tmp9);

        List<Ingredient> tmp10 = new ArrayList<Ingredient>();
        tmp10.add(ingredients.get(0));
        tmp10.add(ingredients.get(3));
        tmp10.add(ingredients.get(6));
        tmp10.add(ingredients.get(9));
        tmp10.add(ingredients.get(13));
        tmp10.add(ingredients.get(19));
        products.get(10).setIngredients(tmp10);

        List<Ingredient> tmp11 = new ArrayList<Ingredient>();
        tmp11.add(ingredients.get(0));
        tmp11.add(ingredients.get(3));
        tmp11.add(ingredients.get(6));
        tmp11.add(ingredients.get(7));
        tmp11.add(ingredients.get(14));
        tmp11.add(ingredients.get(19));
        products.get(11).setIngredients(tmp11);

        List<Ingredient> tmp12 = new ArrayList<Ingredient>();
        tmp12.add(ingredients.get(0));
        tmp12.add(ingredients.get(2));
        tmp12.add(ingredients.get(3));
        tmp12.add(ingredients.get(9));
        tmp12.add(ingredients.get(10));
        products.get(12).setIngredients(tmp12);

        List<Ingredient> tmp13 = new ArrayList<Ingredient>();
        tmp13.add(ingredients.get(0));
        tmp13.add(ingredients.get(2));
        tmp13.add(ingredients.get(3));
        tmp13.add(ingredients.get(9));
        tmp13.add(ingredients.get(11));
        products.get(13).setIngredients(tmp13);

        productDAO.saveAll(products);
    }

    private void updateRolesWithPrivileges() {
        List<Privilege> privileges = privilegeDAO.findAll();
        List<Role> roles = roleDAO.findAll();

        List<Privilege> productCrudRolePrivileges = new ArrayList<>();
        productCrudRolePrivileges.add(privileges.get(0));
        productCrudRolePrivileges.add(privileges.get(1));
        productCrudRolePrivileges.add(privileges.get(2));
        productCrudRolePrivileges.add(privileges.get(3));

        List<Privilege> roleCrudRolePrivileges = new ArrayList<>();
        roleCrudRolePrivileges.add(privileges.get(4));
        roleCrudRolePrivileges.add(privileges.get(5));
        roleCrudRolePrivileges.add(privileges.get(6));
        roleCrudRolePrivileges.add(privileges.get(7));

        roles.get(0).setPrivileges(productCrudRolePrivileges);
        roles.get(1).setPrivileges(roleCrudRolePrivileges);

        roleDAO.saveAll(roles);
    }

    private void updateUsersWithRoles() {
        List<Role> roles = roleDAO.findAll();
        List<User> users = userDAO.findAll();

        List<Role> managerRoles = new ArrayList<>();
        managerRoles.add(roles.get(1));

        users.get(0).setRoles(roles);
        users.get(1).setRoles(roles);
        users.get(2).setRoles(roles);
        users.get(3).setRoles(managerRoles);
        users.get(4).setRoles(managerRoles);
        users.get(5).setRoles(managerRoles);
        users.get(6).setRoles(managerRoles);
        users.get(7).setRoles(managerRoles);
        users.get(8).setRoles(managerRoles);
        
        userDAO.saveAll(users);
    }
}
