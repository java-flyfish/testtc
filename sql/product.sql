# ************************************************************
# Sequel Pro SQL dump
# Version 5446
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 192.168.1.3 (MySQL 5.7.30)
# Database: testtc_pms
# Generation Time: 2020-12-05 10:42:01 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table pms_sku_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pms_sku_info`;

CREATE TABLE `pms_sku_info` (
  `sku_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'skuId',
  `sku_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'sku名称',
  `sku_desc` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'sku介绍描述',
  `brand_id` bigint(20) DEFAULT NULL COMMENT '品牌id',
  `sku_default_img` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '默认图片',
  `sku_title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标题',
  `sku_subtitle` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '副标题',
  `price` decimal(18,4) DEFAULT NULL COMMENT '价格',
  `sale_count` bigint(20) DEFAULT NULL COMMENT '销量',
  PRIMARY KEY (`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='sku信息';

LOCK TABLES `pms_sku_info` WRITE;
/*!40000 ALTER TABLE `pms_sku_info` DISABLE KEYS */;

INSERT INTO `pms_sku_info` (`sku_id`, `sku_name`, `sku_desc`, `brand_id`, `sku_default_img`, `sku_title`, `sku_subtitle`, `price`, `sale_count`)
VALUES
	(1,'华为 x001 2019 红色 6+64',NULL,1,'https://wwmall-wwy.oss-cn-hangzhou.aliyuncs.com/2020-06-20//88c74679-e78c-49c8-8168-016dea4ea4b7_1f15cdbcf9e1273c.jpg','华为 x001 2019 红色 6+64','华为 x001 2019 红色 6+64',3990.0000,0),
	(2,'华为 x001 2019 红色 6+128',NULL,1,'https://wwmall-wwy.oss-cn-hangzhou.aliyuncs.com/2020-06-20//88c74679-e78c-49c8-8168-016dea4ea4b7_1f15cdbcf9e1273c.jpg','华为 x001 2019 红色 6+128','为 x001 2019 红色 6+128',4550.0000,0),
	(3,'华为 x001 2019 黑色 6+64',NULL,1,'https://wwmall-wwy.oss-cn-hangzhou.aliyuncs.com/2020-06-20//88c74679-e78c-49c8-8168-016dea4ea4b7_1f15cdbcf9e1273c.jpg','华为 x001 2019 黑色 6+64','华为 x001 2019 黑色 6+64',3990.0000,0),
	(4,'华为 x001 2019 黑色 6+128',NULL,1,'https://wwmall-wwy.oss-cn-hangzhou.aliyuncs.com/2020-06-20//88c74679-e78c-49c8-8168-016dea4ea4b7_1f15cdbcf9e1273c.jpg','华为 x001 2019 黑色 6+128','华为 x001 2019 黑色 6+128',4550.0000,0),
	(5,'华为 x001 2019 白色 6+64',NULL,1,'https://wwmall-wwy.oss-cn-hangzhou.aliyuncs.com/2020-06-20//88c74679-e78c-49c8-8168-016dea4ea4b7_1f15cdbcf9e1273c.jpg','华为 x001 2019 白色 6+64','华为 x001 2019 白色 6+64',3990.0000,0),
	(6,'华为 x001 2019 白色 6+128',NULL,1,'https://wwmall-wwy.oss-cn-hangzhou.aliyuncs.com/2020-06-20//88c74679-e78c-49c8-8168-016dea4ea4b7_1f15cdbcf9e1273c.jpg','华为 x001 2019 白色 6+128','华为 x001 2019 白色 6+128',4550.0000,0);

/*!40000 ALTER TABLE `pms_sku_info` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table undo_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `undo_log`;

CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
