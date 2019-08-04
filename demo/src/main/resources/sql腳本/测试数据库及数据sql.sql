/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.17 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `test`;

/*Table structure for table `handle` */

DROP TABLE IF EXISTS `handle`;

CREATE TABLE `handle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `handle_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `handle_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `prev_handle_id` varchar(50) DEFAULT NULL,
  `next_handle_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `handle` */

insert  into `handle`(`id`,`handle_name`,`handle_id`,`prev_handle_id`,`next_handle_id`) values (1,'账号校验','accountVerificationHandle','blackListVerificationHandle','permissionVerificationHandle'),(2,'黑名单校验','blackListVerificationHandle',NULL,'accountVerificationHandle'),(3,'权限校验','permissionVerificationHandle','accountVerificationHandle',NULL);

/*Table structure for table `strategy` */

DROP TABLE IF EXISTS `strategy`;

CREATE TABLE `strategy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `strategy_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `class_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `strategy` */

insert  into `strategy`(`id`,`strategy_name`,`class_path`) values (1,'ALI_PAY','aliPayStrategy'),(2,'WEIXIN_PAY','weixinPayStrategy');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
