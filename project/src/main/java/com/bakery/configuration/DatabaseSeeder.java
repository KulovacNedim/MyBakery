package com.bakery.configuration;

import com.bakery.repository.*;
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
    private CompanyRepository companyRepository;

    @Autowired
    private SocialMediaAccountRepository socialMediaAccountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CapabilityRepository capabilityRepository;

    @Autowired
    private SubCapitabilityRepository subCapitabilityRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductComponentRepository ingredientRepository;

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
        seedProductsComponents();
        updateProductsWithCategoriesAndProductsComponents();
    }


    private void seedCompanyAndOfficies() {
        companyRepository.save(DatabaseSeederHelperClass.getCompanyAndOfficies()); }

    private void seedSocialMedia() {
        socialMediaAccountRepository.saveAll(DatabaseSeederHelperClass.getAllSocialMedia()); }

    private void seedCompaniesWithSocialMediaAccounts() {

        Company company = companyRepository.getOne((long)1);

        CompanySocialMedia facebook1 = new CompanySocialMedia();
        facebook1.setCompany(company);
        facebook1.setSocialMediaAccount(socialMediaAccountRepository.getOne((long) 1));
        facebook1.setName("La Boulangerie Wilson");
        facebook1.setPath("https://www.facebook.com/laboulangeriewilsonchicago/");
        company.getCompanySocialMediaList().add(facebook1);

        CompanySocialMedia facebook2 = new CompanySocialMedia();
        facebook2.setCompany(company);
        facebook2.setSocialMediaAccount(socialMediaAccountRepository.getOne((long) 1));
        facebook2.setName("La Boulangerie Belmont");
        facebook2.setPath("https://www.facebook.com/La-Boulangerie-Belmont-250542121715336/");
        company.getCompanySocialMediaList().add(facebook2);

        CompanySocialMedia twitter1 = new CompanySocialMedia();
        twitter1.setCompany(company);
        twitter1.setSocialMediaAccount(socialMediaAccountRepository.getOne((long) 2));
        twitter1.setName("La Boulangerie Wilson");
        twitter1.setPath("https://twitter.com/boulangerie_wil");
        company.getCompanySocialMediaList().add(twitter1);

        CompanySocialMedia twitter2 = new CompanySocialMedia();
        twitter2.setCompany(company);
        twitter2.setSocialMediaAccount(socialMediaAccountRepository.getOne((long) 2));
        twitter2.setName("La Boulangerie Belmont");
        twitter2.setPath("https://twitter.com/laboulangerie1");
        company.getCompanySocialMediaList().add(twitter2);

        CompanySocialMedia twitter3 = new CompanySocialMedia();
        twitter3.setCompany(company);
        twitter3.setSocialMediaAccount(socialMediaAccountRepository.getOne((long) 2));
        twitter3.setName("La Boulangerie Foodtruck");
        twitter3.setPath("https://twitter.com/lbfoodtruck");
        company.getCompanySocialMediaList().add(twitter3);

        CompanySocialMedia instagram1 = new CompanySocialMedia();
        instagram1.setCompany(company);
        instagram1.setSocialMediaAccount(socialMediaAccountRepository.getOne((long) 3));
        instagram1.setName("La Boulangerie Chicago");
        instagram1.setPath("https://www.instagram.com/laboulangeriechicago/");
        company.getCompanySocialMediaList().add(instagram1);

        CompanySocialMedia yelp = new CompanySocialMedia();
        yelp.setCompany(company);
        yelp.setSocialMediaAccount(socialMediaAccountRepository.getOne((long) 6));
        yelp.setName("La Boulangerie Chicago");
        yelp.setPath("https://www.yelp.com/biz/la-boulangerie-chicago-4");
        company.getCompanySocialMediaList().add(yelp);

        companyRepository.save(company);
    }

    private void seedUsers() {
        userRepository.saveAll(DatabaseSeederHelperClass.getAllUsers());
    }

    private void seedRoles() {
        roleRepository.saveAll(DatabaseSeederHelperClass.getAllRoles());
    }

    private void seedCapabilities() {
        capabilityRepository.saveAll(DatabaseSeederHelperClass.getAllCapabilities());
    }

    private void seedSubCapabilities() { subCapitabilityRepository.saveAll(DatabaseSeederHelperClass.getAllSubCapabilities()); }

    private void updateUsersWithRoles() {

        List<Role> roles = roleRepository.findAll();
        List<User> users = userRepository.findAll();

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

        userRepository.saveAll(users);
    }

    private void updateRolesWithCapabilities() {

        List<Capability> capabilities = capabilityRepository.findAll();
        List<Role> roles = roleRepository.findAll();

        // Roles are not defined yet. Will be defined later, when become necessaray
        // Belove settings have purpose to populate database and are not relevant
        roles.get(0).setRoleCapabilities(capabilities);
        roles.get(1).setRoleCapabilities(capabilities);

        roleRepository.saveAll(roles);
    }

    private void updateCapabilitiesWithSubCapabilities() {

        List<Capability> capabilities = capabilityRepository.findAll();

        // Updating Capabilities With SubCapabilities for SystemSetting
        // Be careful with IDs
        capabilities.get(0).setSubCapabilities(Arrays.asList(subCapitabilityRepository.getOne((long) 1),
                subCapitabilityRepository.getOne((long) 2)));

        // Updating Capabilities With SubCapabilities for MenagementSettings
        // Be careful with IDs
        capabilities.get(1).setSubCapabilities(Arrays.asList(subCapitabilityRepository.getOne((long) 3),
                subCapitabilityRepository.getOne((long) 4)));

        // Updating Capabilities With SubCapabilities for UserMenagement
        // Be careful with IDs
        capabilities.get(2).setSubCapabilities(Arrays.asList(subCapitabilityRepository.getOne((long) 5),
                subCapitabilityRepository.getOne((long) 6)));
    }

    private void updateOfficiesWithUsers() {
        Company company = companyRepository.getOne((long) 1);

        company.getOffices().get(0).getUsers().add(userRepository.getOne((long)1));
        company.getOffices().get(0).getUsers().add(userRepository.getOne((long)2));
        company.getOffices().get(0).getUsers().add(userRepository.getOne((long)3));
        company.getOffices().get(0).getUsers().add(userRepository.getOne((long)4));
        company.getOffices().get(0).getUsers().add(userRepository.getOne((long)5));
        company.getOffices().get(1).getUsers().add(userRepository.getOne((long)6));
        company.getOffices().get(1).getUsers().add(userRepository.getOne((long)7));
        company.getOffices().get(1).getUsers().add(userRepository.getOne((long)8));
        company.getOffices().get(1).getUsers().add(userRepository.getOne((long)9));

        companyRepository.save(company);
    }

    private void seedProductCategories() {
        productCategoryRepository.saveAll(DatabaseSeederHelperClass.getAllProductCategories());
    }
    private void seedProducts() {
        productRepository.saveAll(DatabaseSeederHelperClass.getAllProducts());
    }

    private void seedProductsComponents() {
        ingredientRepository.saveAll(DatabaseSeederHelperClass.getAllProductComponents());
    }

    private void updateProductsWithCategoriesAndProductsComponents() {
        List<ProductComponent> productComponents = ingredientRepository.findAll();
        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        List<Product> products = productRepository.findAll();

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
        List<ProductComponent> tmp0 = new ArrayList<ProductComponent>();
        tmp0.add(productComponents.get(0));
        tmp0.add(productComponents.get(1));
        tmp0.add(productComponents.get(2));
        tmp0.add(productComponents.get(9));
        products.get(0).setProductcomponents(tmp0);

        List<ProductComponent> tmp1 = new ArrayList<ProductComponent>();
        tmp1.add(productComponents.get(0));
        tmp1.add(productComponents.get(1));
        tmp1.add(productComponents.get(2));
        tmp1.add(productComponents.get(9));
        tmp1.add(productComponents.get(15));
        products.get(1).setProductcomponents(tmp1);

        List<ProductComponent> tmp2 = new ArrayList<ProductComponent>();
        tmp2.add(productComponents.get(0));
        tmp2.add(productComponents.get(1));
        tmp2.add(productComponents.get(2));
        tmp2.add(productComponents.get(9));
        products.get(2).setProductcomponents(tmp2);

        List<ProductComponent> tmp3 = new ArrayList<ProductComponent>();
        tmp3.add(productComponents.get(0));
        tmp3.add(productComponents.get(1));
        tmp3.add(productComponents.get(2));
        tmp3.add(productComponents.get(9));
        products.get(3).setProductcomponents(tmp3);

        List<ProductComponent> tmp4 = new ArrayList<ProductComponent>();
        tmp4.add(productComponents.get(0));
        tmp4.add(productComponents.get(1));
        tmp4.add(productComponents.get(2));
        tmp4.add(productComponents.get(9));
        products.get(4).setProductcomponents(tmp4);

        List<ProductComponent> tmp5 = new ArrayList<ProductComponent>();
        tmp5.add(productComponents.get(0));
        tmp5.add(productComponents.get(1));
        tmp5.add(productComponents.get(4));
        tmp5.add(productComponents.get(6));
        tmp5.add(productComponents.get(7));
        tmp5.add(productComponents.get(8));
        products.get(5).setProductcomponents(tmp5);

        List<ProductComponent> tmp6 = new ArrayList<ProductComponent>();
        tmp6.add(productComponents.get(0));
        tmp6.add(productComponents.get(1));
        tmp6.add(productComponents.get(5));
        tmp6.add(productComponents.get(6));
        tmp6.add(productComponents.get(7));
        tmp6.add(productComponents.get(8));
        products.get(6).setProductcomponents(tmp6);

        List<ProductComponent> tmp7 = new ArrayList<ProductComponent>();
        tmp7.add(productComponents.get(11));
        tmp7.add(productComponents.get(15));
        products.get(7).setProductcomponents(tmp7);

        List<ProductComponent> tmp8 = new ArrayList<ProductComponent>();
        tmp8.add(productComponents.get(12));
        tmp8.add(productComponents.get(15));
        products.get(8).setProductcomponents(tmp8);

        List<ProductComponent> tmp9 = new ArrayList<ProductComponent>();
        tmp9.add(productComponents.get(0));
        tmp9.add(productComponents.get(6));
        tmp9.add(productComponents.get(3));
        tmp9.add(productComponents.get(16));
        tmp9.add(productComponents.get(17));
        tmp9.add(productComponents.get(18));
        products.get(9).setProductcomponents(tmp9);

        List<ProductComponent> tmp10 = new ArrayList<ProductComponent>();
        tmp10.add(productComponents.get(0));
        tmp10.add(productComponents.get(3));
        tmp10.add(productComponents.get(6));
        tmp10.add(productComponents.get(9));
        tmp10.add(productComponents.get(13));
        tmp10.add(productComponents.get(19));
        products.get(10).setProductcomponents(tmp10);

        List<ProductComponent> tmp11 = new ArrayList<ProductComponent>();
        tmp11.add(productComponents.get(0));
        tmp11.add(productComponents.get(3));
        tmp11.add(productComponents.get(6));
        tmp11.add(productComponents.get(7));
        tmp11.add(productComponents.get(14));
        tmp11.add(productComponents.get(19));
        products.get(11).setProductcomponents(tmp11);

        List<ProductComponent> tmp12 = new ArrayList<ProductComponent>();
        tmp12.add(productComponents.get(0));
        tmp12.add(productComponents.get(2));
        tmp12.add(productComponents.get(3));
        tmp12.add(productComponents.get(9));
        tmp12.add(productComponents.get(10));
        products.get(12).setProductcomponents(tmp12);

        List<ProductComponent> tmp13 = new ArrayList<ProductComponent>();
        tmp13.add(productComponents.get(0));
        tmp13.add(productComponents.get(2));
        tmp13.add(productComponents.get(3));
        tmp13.add(productComponents.get(9));
        tmp13.add(productComponents.get(11));
        products.get(13).setProductcomponents(tmp13);

        productRepository.saveAll(products);
    }
}
