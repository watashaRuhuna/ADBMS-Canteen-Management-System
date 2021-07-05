-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 05, 2021 at 03:11 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `canteen_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `canteen_owner`
--

DROP TABLE IF EXISTS `canteen_owner`;
CREATE TABLE IF NOT EXISTS `canteen_owner` (
  `ow_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ow_mobile` varchar(255) DEFAULT NULL,
  `ow_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ow_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `canteen_owner`
--

INSERT INTO `canteen_owner` (`ow_id`, `email`, `ow_mobile`, `ow_name`, `password`) VALUES
(1, 'supunchalaka@gmail.com', '0771712924', 'Supun', 'asd');

-- --------------------------------------------------------

--
-- Table structure for table `daily_report`
--

DROP TABLE IF EXISTS `daily_report`;
CREATE TABLE IF NOT EXISTS `daily_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `at_date` datetime DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `delete_order_details`
--

DROP TABLE IF EXISTS `delete_order_details`;
CREATE TABLE IF NOT EXISTS `delete_order_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_detail` varchar(500) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `delete_order_details`
--

INSERT INTO `delete_order_details` (`id`, `order_detail`, `order_time`, `user_id`) VALUES
(1, ' order_id : 8  food type : Lunch Order Quantity  1  Price 65', '2021-07-05 17:41:24', 7);

-- --------------------------------------------------------

--
-- Table structure for table `food_inventory`
--

DROP TABLE IF EXISTS `food_inventory`;
CREATE TABLE IF NOT EXISTS `food_inventory` (
  `food_id` int(11) NOT NULL,
  `category_type` varchar(255) DEFAULT NULL,
  `food_name` varchar(255) DEFAULT NULL,
  `food_qty` int(11) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  PRIMARY KEY (`food_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food_inventory`
--

INSERT INTO `food_inventory` (`food_id`, `category_type`, `food_name`, `food_qty`, `img`, `unit_price`) VALUES
(1, 'Break', 'Test', 2, 'tes', 100),
(2, 'asd', 'asd', 23, 'asd', 444),
(12, 'Dinner', 'kottu', 50, '123.png', 100),
(13, 'Dinner', 'Kottu new', 3, '12321321.png', 3),
(14, 'Lunch', 'Rice and Curry', NULL, '', 123),
(15, 'Dinner', 'Rice and Curry', 123, 'db backup.png', 23),
(16, 'Lunch', 'Kottu new g', 3, 'WhatsApp Image 2021-07-02 at 11.35.36 PM.jpeg', 3),
(17, 'Lunch', 'Rice and Curry', 323, 'WhatsApp Image 2021-07-02 at 11.35.36 PM.jpeg', 232),
(18, 'Dinner', 'Rice and Curry', 234, 'WhatsApp Image 2021-07-02 at 11.35.36 PM.jpeg', 234),
(19, 'Dinner', 'kottu', 676, 'WhatsApp Image 2021-07-02 at 11.35.36 PM.jpeg', 6767),
(20, 'Dinner', 'Kottu', 456, 'WhatsApp Image 2021-07-02 at 11.35.36 PM.jpeg', 546),
(21, 'Dinner', 'Rice and Curry', 56, 'WhatsApp Image 2021-07-02 at 11.35.36 PM.jpeg', 6756),
(22, 'Lunch', 'Rice and Curry', 787, 'WhatsApp Image 2021-07-02 at 11.35.36 PM.jpeg', 868);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(23);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE IF NOT EXISTS `invoice` (
  `invoice_id` int(11) NOT NULL,
  `invoice_pdf` varchar(255) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`invoice_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `new_order_details`
--

DROP TABLE IF EXISTS `new_order_details`;
CREATE TABLE IF NOT EXISTS `new_order_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_detail` varchar(500) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `new_order_details`
--

INSERT INTO `new_order_details` (`id`, `order_detail`, `order_time`, `user_id`) VALUES
(1, '  order_id : 9  food type : Lunch Order Quantity  1  Price 65', '2021-07-05 16:28:27', 7),
(2, '  order_id : 9  food type : Lunch Order Quantity  1  Price 65', '2021-07-05 17:24:16', 7),
(3, 'ORDERED   order_id : 9  food type : dinner Order Quantity  1  Price 65', '2021-07-05 17:33:59', 7);

-- --------------------------------------------------------

--
-- Table structure for table `order_count`
--

DROP TABLE IF EXISTS `order_count`;
CREATE TABLE IF NOT EXISTS `order_count` (
  `id` int(11) NOT NULL,
  `count` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `food_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_count`
--

INSERT INTO `order_count` (`id`, `count`, `date`, `food_name`) VALUES
(0, 0, '2021-07-04', 'kottu');

-- --------------------------------------------------------

--
-- Table structure for table `order_table`
--

DROP TABLE IF EXISTS `order_table`;
CREATE TABLE IF NOT EXISTS `order_table` (
  `order_id` int(11) NOT NULL,
  `food_id` int(11) DEFAULT NULL,
  `food_type` varchar(255) DEFAULT NULL,
  `is_cancel` int(11) DEFAULT NULL,
  `is_done` int(11) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `order_qty` int(11) DEFAULT NULL,
  `total_price` float NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_table`
--

INSERT INTO `order_table` (`order_id`, `food_id`, `food_type`, `is_cancel`, `is_done`, `order_date`, `order_qty`, `total_price`, `user_id`) VALUES
(1, 1, 'Lunch', 0, 0, '2021-07-04', 1, 65, 7),
(2, 1, 'Lunch', 0, 0, '2021-07-05', 1, 65, 7),
(3, 2, 'Lunch', 0, 0, '2021-07-05', 1, 65, 7),
(4, 3, 'Lunch', 0, 0, '2021-07-04', 1, 65, 7),
(5, 3, 'Lunch', 0, 0, '2021-07-02', 1, 65, 7),
(6, 3, 'Lunch', 0, 0, '2021-07-04', 1, 65, 7),
(7, 3, 'Lunch', 0, 0, '2021-07-04', 1, 65, 7),
(9, 3, 'dinner', 0, 0, '2021-07-04', 1, 65, 7);

--
-- Triggers `order_table`
--
DROP TRIGGER IF EXISTS `TR_delete_order`;
DELIMITER $$
CREATE TRIGGER `TR_delete_order` AFTER DELETE ON `order_table` FOR EACH ROW BEGIN
        DECLARE details VARCHAR(500);
        SET details = CONCAT(' order_id : ' , OLD.order_id , '  food type : ' , OLD.food_type , ' Order Quantity  ' , OLD.order_qty , '  Price ' , OLD.total_price);
        INSERT INTO delete_order_details(order_detail,order_time,user_id)
        values(details,now(),OLD.user_id);

        END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `TR_new_order`;
DELIMITER $$
CREATE TRIGGER `TR_new_order` AFTER INSERT ON `order_table` FOR EACH ROW BEGIN
        DECLARE details VARCHAR(500);
        SET details = CONCAT('ORDERED   order_id : ' , NEW.order_id , '  food type : ' , NEW.food_type , ' Order Quantity  ' , NEW.order_qty , '  Price ' , NEW.total_price);
        INSERT INTO new_order_details(order_detail,order_time,user_id)
        values(details,now(),NEW.user_id);

        END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `profile_update`
--

DROP TABLE IF EXISTS `profile_update`;
CREATE TABLE IF NOT EXISTS `profile_update` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profile_update`
--

INSERT INTO `profile_update` (`id`, `user_id`, `date`, `description`) VALUES
(1, 8, '2021-07-05', 'This user8updatedasdsadad@hhhhhtoWatasha@gmail.com,123to123');

-- --------------------------------------------------------

--
-- Table structure for table `spring_session`
--

DROP TABLE IF EXISTS `spring_session`;
CREATE TABLE IF NOT EXISTS `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `spring_session_attributes`
--

DROP TABLE IF EXISTS `spring_session_attributes`;
CREATE TABLE IF NOT EXISTS `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_mobile` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `password`, `user_mobile`, `user_name`, `user_position`) VALUES
(7, 'supun@gmail.com', 'asd', '0771712924', 'supun', 'Student'),
(8, 'Watasha@gmail.com', 'asd', '123', 'watasha', 'Lecturer'),
(9, 'adminextra1@livemart.lk', 'asd', '12312', 'asdas', 'Lecturer'),
(10, 'supunchalaka@gmail.coms', '123', '0174987412', 'test', 'Lecturer'),
(11, 'supunchalaka@gmail.com', 'supun', '0174987412', 'Supun', 'Student');

--
-- Triggers `user`
--
DROP TRIGGER IF EXISTS `TR_user_rofile_update`;
DELIMITER $$
CREATE TRIGGER `TR_user_rofile_update` AFTER UPDATE ON `user` FOR EACH ROW BEGIN
        DECLARE details VARCHAR(500);
        SET details = CONCAT('This user',NEW.user_id,'updated',OLD.email,'to',NEW.email,',',OLD.user_mobile,'to',NEW.user_mobile);
        INSERT INTO profile_update(user_id,date,description)
        values(NEW.user_id,now(),details);

        END
$$
DELIMITER ;

DELIMITER $$
--
-- Events
--
DROP EVENT `daily_report`$$
CREATE DEFINER=`root`@`localhost` EVENT `daily_report` ON SCHEDULE EVERY 1 MINUTE STARTS '2021-07-05 15:19:34' ON COMPLETION PRESERVE ENABLE DO BEGIN
        DECLARE tot_price int default 0;
        SELECT SUM(total_price)INTO tot_price FROM `order_table` WHERE order_date=curdate();
        insert INTO daily_report(date,amount)
        values(now(),tot_price);
  END$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
