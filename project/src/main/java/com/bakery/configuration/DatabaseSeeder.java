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
import java.util.Arrays;
import java.util.List;

@Profile("dev")
@Component
@Transactional
public class DatabaseSeeder implements ApplicationRunner {

    @Autowired
    private CompanyDAO companyDAO;

    @Autowired
    private SocialMediaAccountDAO socialMediaAccountDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private CapabilityDAO capabilityDAO;

    @Autowired
    private SubCapitabilityDAO subCapitabilityDAO;

    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private IngredientDAO ingredientDAO;

    private boolean doUpdate = false;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if (doUpdate) {
            updateDatebase();
        }
    }

    private void updateDatebase() {

        // set Company
        seedCompanyAndOfficies();
        seedSocialMedia();
        seedCompaniesWithSocialMediaAccounts();


        // set Users and Capabilities
        seedUsers();
        seedRoles();
        seedCapabilities();
        seedSubCapabilities();
        updateUsersWithRoles();
        updateRolesWithCapabilities();
        updateCapabilitiesWithSubCapabilities();

        // associate users with officies
        updateOfficiesWithUsers();


        // set ProductCategories, Products and Ingredients
        seedProductCategories();
        seedProducts();
        seedIngredients();
        updateProductsWithIngredientsAndCategories();
    }


    private void seedCompanyAndOfficies() {companyDAO.save(DatabaseSeederHelperClass.getCompanyAndOfficies()); }

    private void seedSocialMedia() {socialMediaAccountDAO.saveAll(DatabaseSeederHelperClass.getAllSocialMedia()); }

    private void seedCompaniesWithSocialMediaAccounts() {

        Company company = companyDAO.getOne((long)1);

        CompanySocialMedia facebook1 = new CompanySocialMedia();
        facebook1.setCompany(company);
        facebook1.setSocialMediaAccount(socialMediaAccountDAO.getOne((long) 1));
        facebook1.setName("La Boulangerie Wilson");
        facebook1.setPath("https://www.facebook.com/laboulangeriewilsonchicago/");
        company.getCompanySocialMediaList().add(facebook1);

        CompanySocialMedia facebook2 = new CompanySocialMedia();
        facebook2.setCompany(company);
        facebook2.setSocialMediaAccount(socialMediaAccountDAO.getOne((long) 1));
        facebook2.setName("La Boulangerie Belmont");
        facebook2.setPath("https://www.facebook.com/La-Boulangerie-Belmont-250542121715336/");
        company.getCompanySocialMediaList().add(facebook2);

        CompanySocialMedia twitter1 = new CompanySocialMedia();
        twitter1.setCompany(company);
        twitter1.setSocialMediaAccount(socialMediaAccountDAO.getOne((long) 2));
        twitter1.setName("La Boulangerie Wilson");
        twitter1.setPath("https://twitter.com/boulangerie_wil");
        company.getCompanySocialMediaList().add(twitter1);

        CompanySocialMedia twitter2 = new CompanySocialMedia();
        twitter2.setCompany(company);
        twitter2.setSocialMediaAccount(socialMediaAccountDAO.getOne((long) 2));
        twitter2.setName("La Boulangerie Belmont");
        twitter2.setPath("https://twitter.com/laboulangerie1");
        company.getCompanySocialMediaList().add(twitter2);

        CompanySocialMedia twitter3 = new CompanySocialMedia();
        twitter3.setCompany(company);
        twitter3.setSocialMediaAccount(socialMediaAccountDAO.getOne((long) 2));
        twitter3.setName("La Boulangerie Foodtruck");
        twitter3.setPath("https://twitter.com/lbfoodtruck");
        company.getCompanySocialMediaList().add(twitter3);

        CompanySocialMedia instagram1 = new CompanySocialMedia();
        instagram1.setCompany(company);
        instagram1.setSocialMediaAccount(socialMediaAccountDAO.getOne((long) 3));
        instagram1.setName("La Boulangerie Chicago");
        instagram1.setPath("https://www.instagram.com/laboulangeriechicago/");
        company.getCompanySocialMediaList().add(instagram1);

        CompanySocialMedia yelp = new CompanySocialMedia();
        yelp.setCompany(company);
        yelp.setSocialMediaAccount(socialMediaAccountDAO.getOne((long) 6));
        yelp.setName("La Boulangerie Chicago");
        yelp.setPath("https://www.yelp.com/biz/la-boulangerie-chicago-4");
        company.getCompanySocialMediaList().add(yelp);

        companyDAO.save(company);
    }

    private void seedUsers() {
        userDAO.saveAll(DatabaseSeederHelperClass.getAllUsers());
    }

    private void seedRoles() {
        roleDAO.saveAll(DatabaseSeederHelperClass.getAllRoles());
    }

    private void seedCapabilities() {
        capabilityDAO.saveAll(DatabaseSeederHelperClass.getAllCapabilities());
    }

    private void seedSubCapabilities() { subCapitabilityDAO.saveAll(DatabaseSeederHelperClass.getAllSubCapabilities()); }

    private void updateUsersWithRoles() {

        List<Role> roles = roleDAO.findAll();
        List<User> users = userDAO.findAll();

        List<Role> managerRoles = new ArrayList<>();
        managerRoles.add(roles.get(1));

        users.get(0).setRole(roles.get(0));
        users.get(1).setRole(roles.get(1));
        users.get(2).setRole(roles.get(2));
        users.get(3).setRole(roles.get(3));
        users.get(4).setRole(roles.get(4));
        users.get(5).setRole(roles.get(5));
        users.get(6).setRole(roles.get(5));
        users.get(7).setRole(roles.get(6));
        users.get(8).setRole(roles.get(6));

        userDAO.saveAll(users);
    }

    private void updateRolesWithCapabilities() {

        List<Capability> capabilities = capabilityDAO.findAll();
        List<Role> roles = roleDAO.findAll();

        // Roles are not defined yet. Will be defined later, when become necessaray
        // Belove settings have purpose to populate database and are not relevant
        roles.get(0).setRoleCapabilities(capabilities);
        roles.get(1).setRoleCapabilities(capabilities);

        roleDAO.saveAll(roles);
    }

    private void updateCapabilitiesWithSubCapabilities() {

        List<Capability> capabilities = capabilityDAO.findAll();

        // Updating Capabilities With SubCapabilities for SystemSetting
        // Be careful with IDs
        capabilities.get(0).setSubCapabilities(Arrays.asList(subCapitabilityDAO.getOne((long) 1),
                subCapitabilityDAO.getOne((long) 2)));

        // Updating Capabilities With SubCapabilities for MenagementSettings
        // Be careful with IDs
        capabilities.get(1).setSubCapabilities(Arrays.asList(subCapitabilityDAO.getOne((long) 3),
                subCapitabilityDAO.getOne((long) 4)));

        // Updating Capabilities With SubCapabilities for UserMenagement
        // Be careful with IDs
        capabilities.get(2).setSubCapabilities(Arrays.asList(subCapitabilityDAO.getOne((long) 5),
                subCapitabilityDAO.getOne((long) 6)));
    }

    private void updateOfficiesWithUsers() {
        Company company = companyDAO.getOne((long) 1);

        company.getOffices().get(0).getUsers().add(userDAO.getOne((long)1));
        company.getOffices().get(0).getUsers().add(userDAO.getOne((long)2));
        company.getOffices().get(0).getUsers().add(userDAO.getOne((long)3));
        company.getOffices().get(0).getUsers().add(userDAO.getOne((long)4));
        company.getOffices().get(0).getUsers().add(userDAO.getOne((long)5));
        company.getOffices().get(1).getUsers().add(userDAO.getOne((long)6));
        company.getOffices().get(1).getUsers().add(userDAO.getOne((long)7));
        company.getOffices().get(1).getUsers().add(userDAO.getOne((long)8));
        company.getOffices().get(1).getUsers().add(userDAO.getOne((long)9));

        companyDAO.save(company);
    }

    private void seedProductCategories() {
        productCategoryDAO.saveAll(DatabaseSeederHelperClass.getAllProductCategories());
    }
    private void seedProducts() {
        productDAO.saveAll(DatabaseSeederHelperClass.getAllProducts());
    }

    private void seedIngredients() {
        ingredientDAO.saveAll(DatabaseSeederHelperClass.getAllIngredients());
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
}
