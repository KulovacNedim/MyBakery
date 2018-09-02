package com.bakery.configuration;

import com.bakery.model.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Profile("dev")
@Component
public class DatabaseSeederHelperClass {

    static Company getCompanyAndOfficies() {

        // create company
        Company company = new Company("Laboulangerie Bakery", "Laboulangerie", true);

        // create list of officies
        List<Office> offices = new ArrayList<>();

        // create office1 and set address, email list, phone list
        Office office1 = new Office(company,"Logan Square");
        Address address1 = new Address("3129 W Logan Blvd", "Illinois",
                "Chicago", "60640");
        office1.setAddress(address1);
        address1.setOffice(office1);

        List<Email> emailList1 = new ArrayList<>();
        Email email1 = new Email("laboulangeriechicago@gmail.com", office1);
        Email email2 = new Email("thisIsNotRealEmail@no1.com", office1);
        emailList1.add(email1);
        emailList1.add(email2);
        office1.setEmails(emailList1);

        List<Phone> phoneList1 = new ArrayList<>();
        Phone phone1 = new Phone("(773) 666-5880", office1);
        phoneList1.add(phone1);
        office1.setPhones(phoneList1);

        // create office2 and set address, email list, phone list
        Office office2 = new Office(company,"Ravenswood");
        Address address2 = new Address("1945 W Wilson Ave", "Illinois",
                "Chicago", "60640");
        office2.setAddress(address2);
        address2.setOffice(office2);

        List<Email> emailList2 = new ArrayList<>();
        Email email3 = new Email("thisIsNotRealEmail@no2.com", office2);
        Email email4 = new Email("thisIsNotRealEmail@no3.com", office2);
        emailList2.add(email3);
        emailList2.add(email4);
        office2.setEmails(emailList2);

        List<Phone> phoneList2 = new ArrayList<>();
        Phone phone2 = new Phone("(872) 208-3479", office2);
        phoneList2.add(phone2);
        office2.setPhones(phoneList2);

        // asocciate created officies with company
        offices.add(office1);
        offices.add(office2);
        company.setOffices(offices);

        return company;
    }

    static List<SocialMediaAccount> getAllSocialMedia() {
        List<SocialMediaAccount> socialMediaAccounts = new ArrayList<>();

        socialMediaAccounts.add(new SocialMediaAccount("Facebook","facebook icon"));
        socialMediaAccounts.add(new SocialMediaAccount("Twitter","twitter icon"));
        socialMediaAccounts.add(new SocialMediaAccount("Instagram","instagram icon"));
        socialMediaAccounts.add(new SocialMediaAccount("Pinterest","pinterest icon"));
        socialMediaAccounts.add(new SocialMediaAccount("Google+","googlr+ icon"));
        socialMediaAccounts.add(new SocialMediaAccount("Yelp","yelp icon"));

        return socialMediaAccounts;
    }

    static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("Nedim", "Kulovac", "testemail1@gmail.com", "password1", "123456789"));
        users.add(new User("Dino", "Spreco", "testemail2@gmail.com", "password2", "223456789"));
        users.add(new User("Zeljko", "Dobrojevic", "testemail3@gmail.com", "password3", "323456789"));
        users.add(new User("Mujo", "Ramic", "testemail4@gmail.com", "password4", "423456789"));
        users.add(new User("Slobodan", "Vukovic", "testemail5@gmail.com", "password5", "523456789"));
        users.add(new User("Boris", "Nunic", "testemail6@gmail.com", "password6", "623456789"));
        users.add(new User("Ilinka", "Poletan", "testemail7@gmail.com", "password7", "723456789"));
        users.add(new User("Jasmin", "Mustafic", "testemail8@gmail.com", "password8", "823456789"));
        users.add(new User("Dejan", "Sipovac", "testemail9@gmail.com", "password9", "923456789"));
        return users;
    }

    static List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();

        roles.add(new Role("Superadmin", true));
        roles.add(new Role("Client"));
        roles.add(new Role("Administrator"));
        roles.add(new Role("Menager"));
        roles.add(new Role("Headcheaf"));
        roles.add(new Role("Weiter"));
        roles.add(new Role("Cashier"));

        return roles;
    }

    static List<Capability> getAllCapabilities() {
        List<Capability> capabilities = new ArrayList<>();

        capabilities.add(new Capability("SystemSettings", "systemSettings"));
        capabilities.add(new Capability("MenagementSettings", "menagementSettings"));
        capabilities.add(new Capability("UserMenagement", "userMenagement"));
        capabilities.add(new Capability("ProductsMenagement", "productsMenagement"));
        capabilities.add(new Capability("OrdersMenagement", "ordersMenagement"));
        capabilities.add(new Capability("SocialMediaMenagement", "socialMediaMenagement"));

        return capabilities;
    }

    static List<SubCapability> getAllSubCapabilities() {
        List<SubCapability> subCapabilities = new ArrayList<>();

        // Be very careful with order becouse DatabeseSeeder.updateCapabilitiesWithSubCapabilities use this list

        // Seeding SubCapabilities for SystemSetting Capability
        subCapabilities.add(new SubCapability("SystemSettingsFeature1", "1path"));
        subCapabilities.add(new SubCapability("SystemSettingsFeature2", "2path"));

        // Seeding SubCapabilities for MenagementSettings Capability
        subCapabilities.add(new SubCapability("MenagementSettingsFeature1", "1path"));
        subCapabilities.add(new SubCapability("MenagementSettingsFeature2", "2path"));

        // Seeding SubCapabilities for UserMenagement Capability
        subCapabilities.add(new SubCapability("UserMenagementFeature1", "1path"));
        subCapabilities.add(new SubCapability("UserMenagementFeature12", "2path"));

        // Other SubCapabilities will be added during app development

        return subCapabilities;
    }

    static List<ProductCategory> getAllProductCategories() {
        List<ProductCategory> productCategories = new ArrayList<>();

        productCategories.add(new ProductCategory("Bread"));
        productCategories.add(new ProductCategory("Crepe"));
        productCategories.add(new ProductCategory("Sandwich"));
        productCategories.add(new ProductCategory("Cookie"));
        productCategories.add(new ProductCategory("Cracker"));

        return productCategories;
    }

    static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Ordinary bread", 2.5, "Description for just Ordinary bread", "productImage"));
        products.add(new Product("Whole wheat bread", 3.5, "Description for just Whole weath bread", "productImage"));
        products.add(new Product("Anadama bread", 3.5, "Description for just Anadama bread", "productImage"));
        products.add(new Product("Cuban bread", 3.5, "Description for just Cuban bread", "productImage"));
        products.add(new Product("Salt-rising bread", 3.5, "Description for just Salt-rising bread", "productImage"));
        products.add(new Product("Honey crepes", 1.0, "Description for Honey crepes", "productImage"));
        products.add(new Product("Jam crepes", 1.5, "Description for just Jam crepes", "productImage"));
        products.add(new Product("Cheese sandwich", 4.5, "Description for just Cheese sandwich", "productImage"));
        products.add(new Product("Tuna sandwich", 3.5, "Description for just Tuna sandwich", "productImage"));
        products.add(new Product("Afghan biscuit", 3.5, "Description for just Afghan biscuit", "productImage"));
        products.add(new Product("Almond biscuit", 3.5, "Description for just Almond biscuit", "productImage"));
        products.add(new Product("Fortune cookie", 3.5, "Description for just Fortune cookie", "productImage"));
        products.add(new Product("Rice cracker", 3.5, "Description for just Rice cracker", "productImage"));
        products.add(new Product("Cheese cracker", 3.5, "Description for just Cheese cracker\"", "productImage"));

        return products;
    }

    static List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();

        ingredients.add(new Ingredient("Flour"));
        ingredients.add(new Ingredient("Water"));
        ingredients.add(new Ingredient("Salt"));
        ingredients.add(new Ingredient("Sugar"));
        ingredients.add(new Ingredient("Honey"));
        ingredients.add(new Ingredient("Jam"));
        ingredients.add(new Ingredient("Butter"));
        ingredients.add(new Ingredient("Eggs"));
        ingredients.add(new Ingredient("Milk"));
        ingredients.add(new Ingredient("Baking powder"));
        ingredients.add(new Ingredient("Rice"));
        ingredients.add(new Ingredient("Chese"));
        ingredients.add(new Ingredient("Tuna"));
        ingredients.add(new Ingredient("Almond"));
        ingredients.add(new Ingredient("Fortune"));
        ingredients.add(new Ingredient("Bread"));
        ingredients.add(new Ingredient("Cocoa"));
        ingredients.add(new Ingredient("Cornflakes"));
        ingredients.add(new Ingredient("Walnuts"));
        ingredients.add(new Ingredient("Vanilla extraxt"));

        return ingredients;
    }
}