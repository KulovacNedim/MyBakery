-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 17, 2019 at 11:58 AM
-- Server version: 10.3.15-MariaDB
-- PHP Version: 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bakery`
--

-- --------------------------------------------------------

--
-- Table structure for table `addresses`
--

CREATE TABLE `addresses` (
  `address_id` bigint(20) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip_coode` varchar(255) DEFAULT NULL,
  `office_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `addresses`
--

INSERT INTO `addresses` (`address_id`, `city`, `state`, `street`, `zip_coode`, `office_id`) VALUES
(1, 'Chicago', 'Illinois', '3129 W Logan Blvd', '60640', 1),
(2, 'Chicago', 'Illinois', '1945 W Wilson Ave', '60640', 2);

-- --------------------------------------------------------

--
-- Table structure for table `capabilities`
--

CREATE TABLE `capabilities` (
  `capatability_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `capabilities`
--

INSERT INTO `capabilities` (`capatability_id`, `name`, `path`) VALUES
(1, 'SystemSettings', 'systemSettings'),
(2, 'MenagementSettings', 'menagementSettings'),
(3, 'UserMenagement', 'userMenagement'),
(4, 'ProductsMenagement', 'productsMenagement'),
(5, 'OrdersMenagement', 'ordersMenagement'),
(6, 'SocialMediaMenagement', 'socialMediaMenagement');

-- --------------------------------------------------------

--
-- Table structure for table `capabilities_roles`
--

CREATE TABLE `capabilities_roles` (
  `capability_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `capabilities_roles`
--

INSERT INTO `capabilities_roles` (`capability_id`, `role_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 6);

-- --------------------------------------------------------

--
-- Table structure for table `capabilities_subcapabilities`
--

CREATE TABLE `capabilities_subcapabilities` (
  `subcapatibility_id` int(11) NOT NULL,
  `capatability_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `capabilities_subcapabilities`
--

INSERT INTO `capabilities_subcapabilities` (`subcapatibility_id`, `capatability_id`) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 6);

-- --------------------------------------------------------

--
-- Table structure for table `companies`
--

CREATE TABLE `companies` (
  `company_id` bigint(20) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `short_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `companies`
--

INSERT INTO `companies` (`company_id`, `full_name`, `active`, `short_name`) VALUES
(1, 'Laboulangerie Bakery', b'1', 'Laboulangerie');

-- --------------------------------------------------------

--
-- Table structure for table `companysocialmedias`
--

CREATE TABLE `companysocialmedias` (
  `companysocialmedia_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `socialmedia_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `companysocialmedias`
--

INSERT INTO `companysocialmedias` (`companysocialmedia_id`, `name`, `path`, `company_id`, `socialmedia_id`) VALUES
(1, 'La Boulangerie Wilson', 'https://www.facebook.com/laboulangeriewilsonchicago/', 1, 1),
(2, 'La Boulangerie Belmont', 'https://www.facebook.com/La-Boulangerie-Belmont-250542121715336/', 1, 1),
(3, 'La Boulangerie Wilson', 'https://twitter.com/boulangerie_wil', 1, 2),
(4, 'La Boulangerie Belmont', 'https://twitter.com/laboulangerie1', 1, 2),
(5, 'La Boulangerie Foodtruck', 'https://twitter.com/lbfoodtruck', 1, 2),
(6, 'La Boulangerie Chicago', 'https://www.instagram.com/laboulangeriechicago/', 1, 3),
(7, 'La Boulangerie Chicago', 'https://www.yelp.com/biz/la-boulangerie-chicago-4', 1, 6);

-- --------------------------------------------------------

--
-- Table structure for table `emails`
--

CREATE TABLE `emails` (
  `email_id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `office` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emails`
--

INSERT INTO `emails` (`email_id`, `email`, `office`) VALUES
(1, 'laboulangeriechicago@gmail.com', 1),
(2, 'thisIsNotRealEmail@no1.com', 1),
(3, 'thisIsNotRealEmail@no2.com', 2),
(4, 'thisIsNotRealEmail@no3.com', 2);

-- --------------------------------------------------------

--
-- Table structure for table `officies`
--

CREATE TABLE `officies` (
  `office_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `officies`
--

INSERT INTO `officies` (`office_id`, `name`, `company_id`) VALUES
(1, 'Logan Square', 1),
(2, 'Ravenswood', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phones`
--

CREATE TABLE `phones` (
  `phone_id` bigint(20) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  `office` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phones`
--

INSERT INTO `phones` (`phone_id`, `number`, `office`) VALUES
(1, '(773) 666-5880', 1),
(2, '(872) 208-3479', 2);

-- --------------------------------------------------------

--
-- Table structure for table `productcategories`
--

CREATE TABLE `productcategories` (
  `product_category_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productcategories`
--

INSERT INTO `productcategories` (`product_category_id`, `name`) VALUES
(1, 'Bread'),
(2, 'Crepe'),
(3, 'Sandwich'),
(4, 'Cookie'),
(5, 'Cracker');

-- --------------------------------------------------------

--
-- Table structure for table `productcomponents`
--

CREATE TABLE `productcomponents` (
  `productcomponent_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productcomponents`
--

INSERT INTO `productcomponents` (`productcomponent_id`, `name`) VALUES
(1, 'Flour'),
(2, 'Water'),
(3, 'Salt'),
(4, 'Sugar'),
(5, 'Honey'),
(6, 'Jam'),
(7, 'Butter'),
(8, 'Eggs'),
(9, 'Milk'),
(10, 'Baking powder'),
(11, 'Rice'),
(12, 'Chese'),
(13, 'Tuna'),
(14, 'Almond'),
(15, 'Fortune'),
(16, 'Bread'),
(17, 'Cocoa'),
(18, 'Cornflakes'),
(19, 'Walnuts'),
(20, 'Vanilla extraxt');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `product_category_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `description`, `image_path`, `name`, `price`, `product_category_id`) VALUES
(1, 'Description for just Ordinary bread', 'sandwitch2', 'Ordinary bread', 2.5, 1),
(2, 'Description for just Whole weath bread', 'sandwitch2', 'Whole wheat bread', 3.5, 1),
(3, 'Description for just Anadama bread', 'sandwitch2', 'Anadama bread', 3.5, 1),
(4, 'Description for just Cuban bread', 'sandwitch2', 'Cuban bread', 3.5, 1),
(5, 'Description for just Salt-rising bread', 'sandwitch2', 'Salt-rising bread', 3.5, 1),
(6, 'Description for Honey crepes', 'sandwitch2', 'Honey crepes', 1, 2),
(7, 'Description for just Jam crepes', 'sandwitch2', 'Jam crepes', 1.5, 2),
(8, 'Description for just Cheese sandwich', 'sandwitch2', 'Cheese sandwich', 4.5, 3),
(9, 'Description for just Tuna sandwich', 'sandwitch2', 'Tuna sandwich', 3.5, 3),
(10, 'Description for just Afghan biscuit', 'sandwitch2', 'Afghan biscuit', 3.5, 4),
(11, 'Description for just Almond biscuit', 'sandwitch2', 'Almond biscuit', 3.5, 4),
(12, 'Description for just Fortune cookie', 'sandwitch2', 'Fortune cookie', 3.5, 4),
(13, 'Description for just Rice cracker', 'sandwitch2', 'Rice cracker', 3.5, 5),
(14, 'Description for just Cheese cracker\"', 'sandwitch2', 'Cheese cracker', 3.5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `products_productscomponents`
--

CREATE TABLE `products_productscomponents` (
  `product_id` bigint(20) NOT NULL,
  `productcomponent_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products_productscomponents`
--

INSERT INTO `products_productscomponents` (`product_id`, `productcomponent_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 10),
(2, 1),
(2, 2),
(2, 3),
(2, 10),
(2, 16),
(3, 1),
(3, 2),
(3, 3),
(3, 10),
(4, 1),
(4, 2),
(4, 3),
(4, 10),
(5, 1),
(5, 2),
(5, 3),
(5, 10),
(6, 1),
(6, 2),
(6, 5),
(6, 7),
(6, 8),
(6, 9),
(7, 1),
(7, 2),
(7, 6),
(7, 7),
(7, 8),
(7, 9),
(8, 12),
(8, 16),
(9, 13),
(9, 16),
(10, 1),
(10, 7),
(10, 4),
(10, 17),
(10, 18),
(10, 19),
(11, 1),
(11, 4),
(11, 7),
(11, 10),
(11, 14),
(11, 20),
(12, 1),
(12, 4),
(12, 7),
(12, 8),
(12, 15),
(12, 20),
(13, 1),
(13, 3),
(13, 4),
(13, 10),
(13, 11),
(14, 1),
(14, 3),
(14, 4),
(14, 10),
(14, 12);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `role_id` bigint(20) NOT NULL,
  `protected` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_id`, `protected`, `name`) VALUES
(1, b'1', 'Superadmin'),
(2, b'0', 'Client'),
(3, b'0', 'Administrator'),
(4, b'0', 'Menager'),
(5, b'0', 'Headcheaf'),
(6, b'0', 'Weiter'),
(7, b'0', 'Cashier');

-- --------------------------------------------------------

--
-- Table structure for table `socialmediaaccounts`
--

CREATE TABLE `socialmediaaccounts` (
  `socialmedia_id` bigint(20) NOT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `socialmediaaccounts`
--

INSERT INTO `socialmediaaccounts` (`socialmedia_id`, `image_path`, `name`) VALUES
(1, 'facebook icon', 'Facebook'),
(2, 'twitter icon', 'Twitter'),
(3, 'instagram icon', 'Instagram'),
(4, 'pinterest icon', 'Pinterest'),
(5, 'googlr+ icon', 'Google+'),
(6, 'yelp icon', 'Yelp');

-- --------------------------------------------------------

--
-- Table structure for table `subcapabilities`
--

CREATE TABLE `subcapabilities` (
  `subcapatibility_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subcapabilities`
--

INSERT INTO `subcapabilities` (`subcapatibility_id`, `name`, `path`) VALUES
(1, 'SystemSettingsFeature1', '1path'),
(2, 'SystemSettingsFeature2', '2path'),
(3, 'MenagementSettingsFeature1', '1path'),
(4, 'MenagementSettingsFeature2', '2path'),
(5, 'UserMenagementFeature1', '1path'),
(6, 'UserMenagementFeature12', '2path');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `email`, `first_name`, `last_name`, `password`, `phone_number`, `role_id`) VALUES
(1, 'testemail1@gmail.com', 'Nedim', 'Kulovac', '$2a$10$zWR5ZoIXWWQUG55.vqonreNST7gFhptdAXMR007kPdfVhKJSJKE9m', '123456789', 1),
(2, 'testemail2@gmail.com', 'Dino', 'Spreco', 'password2', '223456789', 2),
(3, 'testemail3@gmail.com', 'Zeljko', 'Dobrojevic', 'password3', '323456789', 3),
(4, 'testemail4@gmail.com', 'Mujo', 'Ramic', 'password4', '423456789', 4),
(5, 'testemail5@gmail.com', 'Slobodan', 'Vukovic', 'password5', '523456789', 5),
(6, 'testemail6@gmail.com', 'Boris', 'Nunic', 'password6', '623456789', 6),
(7, 'testemail7@gmail.com', 'Ilinka', 'Poletan', 'password7', '723456789', 6),
(8, 'testemail8@gmail.com', 'Jasmin', 'Mustafic', 'password8', '823456789', 7),
(9, 'testemail9@gmail.com', 'Dejan', 'Sipovac', 'password9', '923456789', 7);

-- --------------------------------------------------------

--
-- Table structure for table `users_officies`
--

CREATE TABLE `users_officies` (
  `user_id` bigint(20) NOT NULL,
  `office_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users_officies`
--

INSERT INTO `users_officies` (`user_id`, `office_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(2, 6),
(2, 7),
(2, 8),
(2, 9);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `addresses`
--
ALTER TABLE `addresses`
  ADD PRIMARY KEY (`address_id`),
  ADD KEY `FKjov4pve5e32cxpy4mavstwjfq` (`office_id`);

--
-- Indexes for table `capabilities`
--
ALTER TABLE `capabilities`
  ADD PRIMARY KEY (`capatability_id`);

--
-- Indexes for table `capabilities_roles`
--
ALTER TABLE `capabilities_roles`
  ADD KEY `FKewco2t52so4aiqwwaa95cyql9` (`role_id`),
  ADD KEY `FKcxh4q0vsad4nh5k3mgqy35ayc` (`capability_id`);

--
-- Indexes for table `capabilities_subcapabilities`
--
ALTER TABLE `capabilities_subcapabilities`
  ADD KEY `FKbadl4roic5ht2dhgqd9nugguq` (`capatability_id`),
  ADD KEY `FKc09vi81ufewxpn50kpomblbt6` (`subcapatibility_id`);

--
-- Indexes for table `companies`
--
ALTER TABLE `companies`
  ADD PRIMARY KEY (`company_id`);

--
-- Indexes for table `companysocialmedias`
--
ALTER TABLE `companysocialmedias`
  ADD PRIMARY KEY (`companysocialmedia_id`),
  ADD KEY `FKt07rjf50fn8u0r4i1pvt4y7kx` (`company_id`),
  ADD KEY `FKjrgu98xp7wj6274u50dtkyyc3` (`socialmedia_id`);

--
-- Indexes for table `emails`
--
ALTER TABLE `emails`
  ADD PRIMARY KEY (`email_id`),
  ADD KEY `FK2fibont99isf36uo4asut3rxh` (`office`);

--
-- Indexes for table `officies`
--
ALTER TABLE `officies`
  ADD PRIMARY KEY (`office_id`),
  ADD KEY `FKsntu82c54qvb46lw10lyufeud` (`company_id`);

--
-- Indexes for table `phones`
--
ALTER TABLE `phones`
  ADD PRIMARY KEY (`phone_id`),
  ADD KEY `FKbn9y4n2vancw0wd88nxduopt7` (`office`);

--
-- Indexes for table `productcategories`
--
ALTER TABLE `productcategories`
  ADD PRIMARY KEY (`product_category_id`);

--
-- Indexes for table `productcomponents`
--
ALTER TABLE `productcomponents`
  ADD PRIMARY KEY (`productcomponent_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `FKo3v47lwqdi2jpc7ydx8odamt9` (`product_category_id`);

--
-- Indexes for table `products_productscomponents`
--
ALTER TABLE `products_productscomponents`
  ADD KEY `FK4159d4993kyhl16msekft4gqh` (`productcomponent_id`),
  ADD KEY `FKhpcbb0v4c9t5tvhsa52uddb7h` (`product_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `socialmediaaccounts`
--
ALTER TABLE `socialmediaaccounts`
  ADD PRIMARY KEY (`socialmedia_id`);

--
-- Indexes for table `subcapabilities`
--
ALTER TABLE `subcapabilities`
  ADD PRIMARY KEY (`subcapatibility_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK9ri5nhf3ncj124f1j4tqaetv7` (`user_id`,`email`),
  ADD KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`);

--
-- Indexes for table `users_officies`
--
ALTER TABLE `users_officies`
  ADD KEY `FKtrtp1padj5krn42li12bmko31` (`office_id`),
  ADD KEY `FKh3vtjwovipuwuu17l58wtljvf` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `addresses`
--
ALTER TABLE `addresses`
  MODIFY `address_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `capabilities`
--
ALTER TABLE `capabilities`
  MODIFY `capatability_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `companies`
--
ALTER TABLE `companies`
  MODIFY `company_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `companysocialmedias`
--
ALTER TABLE `companysocialmedias`
  MODIFY `companysocialmedia_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `emails`
--
ALTER TABLE `emails`
  MODIFY `email_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `officies`
--
ALTER TABLE `officies`
  MODIFY `office_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `phones`
--
ALTER TABLE `phones`
  MODIFY `phone_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `productcategories`
--
ALTER TABLE `productcategories`
  MODIFY `product_category_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `productcomponents`
--
ALTER TABLE `productcomponents`
  MODIFY `productcomponent_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `role_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `socialmediaaccounts`
--
ALTER TABLE `socialmediaaccounts`
  MODIFY `socialmedia_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `subcapabilities`
--
ALTER TABLE `subcapabilities`
  MODIFY `subcapatibility_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `addresses`
--
ALTER TABLE `addresses`
  ADD CONSTRAINT `FKjov4pve5e32cxpy4mavstwjfq` FOREIGN KEY (`office_id`) REFERENCES `officies` (`office_id`);

--
-- Constraints for table `capabilities_roles`
--
ALTER TABLE `capabilities_roles`
  ADD CONSTRAINT `FKcxh4q0vsad4nh5k3mgqy35ayc` FOREIGN KEY (`capability_id`) REFERENCES `roles` (`role_id`),
  ADD CONSTRAINT `FKewco2t52so4aiqwwaa95cyql9` FOREIGN KEY (`role_id`) REFERENCES `capabilities` (`capatability_id`);

--
-- Constraints for table `capabilities_subcapabilities`
--
ALTER TABLE `capabilities_subcapabilities`
  ADD CONSTRAINT `FKbadl4roic5ht2dhgqd9nugguq` FOREIGN KEY (`capatability_id`) REFERENCES `subcapabilities` (`subcapatibility_id`),
  ADD CONSTRAINT `FKc09vi81ufewxpn50kpomblbt6` FOREIGN KEY (`subcapatibility_id`) REFERENCES `capabilities` (`capatability_id`);

--
-- Constraints for table `companysocialmedias`
--
ALTER TABLE `companysocialmedias`
  ADD CONSTRAINT `FKjrgu98xp7wj6274u50dtkyyc3` FOREIGN KEY (`socialmedia_id`) REFERENCES `socialmediaaccounts` (`socialmedia_id`),
  ADD CONSTRAINT `FKt07rjf50fn8u0r4i1pvt4y7kx` FOREIGN KEY (`company_id`) REFERENCES `companies` (`company_id`);

--
-- Constraints for table `emails`
--
ALTER TABLE `emails`
  ADD CONSTRAINT `FK2fibont99isf36uo4asut3rxh` FOREIGN KEY (`office`) REFERENCES `officies` (`office_id`);

--
-- Constraints for table `officies`
--
ALTER TABLE `officies`
  ADD CONSTRAINT `FKsntu82c54qvb46lw10lyufeud` FOREIGN KEY (`company_id`) REFERENCES `companies` (`company_id`);

--
-- Constraints for table `phones`
--
ALTER TABLE `phones`
  ADD CONSTRAINT `FKbn9y4n2vancw0wd88nxduopt7` FOREIGN KEY (`office`) REFERENCES `officies` (`office_id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FKo3v47lwqdi2jpc7ydx8odamt9` FOREIGN KEY (`product_category_id`) REFERENCES `productcategories` (`product_category_id`);

--
-- Constraints for table `products_productscomponents`
--
ALTER TABLE `products_productscomponents`
  ADD CONSTRAINT `FK4159d4993kyhl16msekft4gqh` FOREIGN KEY (`productcomponent_id`) REFERENCES `productcomponents` (`productcomponent_id`),
  ADD CONSTRAINT `FKhpcbb0v4c9t5tvhsa52uddb7h` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`);

--
-- Constraints for table `users_officies`
--
ALTER TABLE `users_officies`
  ADD CONSTRAINT `FKh3vtjwovipuwuu17l58wtljvf` FOREIGN KEY (`user_id`) REFERENCES `officies` (`office_id`),
  ADD CONSTRAINT `FKtrtp1padj5krn42li12bmko31` FOREIGN KEY (`office_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
