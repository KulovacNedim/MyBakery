# Laboulangerie bakery

Java Web Application made with Spring Boot. Started with three other people in the BILD-IT office. Still in progress.

---

Application will cover all aspects of restaurant (chain) management:<br>
    - Employee management <br>
    - Products/offer management<br>
    - Supply management<br>
    - Customer service management<br>
    - Online order management
    - Social media management
    
Roles: <br>
    - Super admin<br>
    - Client<br>
    - Admin<br>
    - Office manager<br>
    - Office head cheaf<br>
    - Office waiter<br>
    - Office cashier<br>
    
---

<img src="index.png" alt="index.png">

---

### Clone

- Clone this repo to your local machine using `https://github.com/KulovacNedim/MyBakery`

---

### database 

- Import database script 'bakery.sql' from /documentation/DBconfiguration folder. <br>
- Don't forget to enter credentials for your database in /project/src/main/resources/application.properties
- In same file tune spring.jpa.hibernate.ddl-auto properties for generating schema utils
- In /project/src/main/java/com/bakery/configuration/DatabaseSeeder.java file edit doUpdate field to set database seeder to seed items every time or not
---

<img src="admin.png" alt="admin.png">