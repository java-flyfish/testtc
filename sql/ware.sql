# ************************************************************
# Sequel Pro SQL dump
# Version 5446
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 192.168.1.3 (MySQL 5.7.30)
# Database: testtc_wms
# Generation Time: 2020-12-05 10:42:37 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


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



# Dump of table wms_ware_sku
# ------------------------------------------------------------

DROP TABLE IF EXISTS `wms_ware_sku`;

CREATE TABLE `wms_ware_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sku_id` bigint(20) DEFAULT NULL COMMENT 'sku_id',
  `ware_id` bigint(20) DEFAULT NULL COMMENT '仓库id',
  `stock` int(11) DEFAULT NULL COMMENT '库存数',
  `sku_name` varchar(200) DEFAULT NULL COMMENT 'sku_name',
  `stock_locked` int(11) DEFAULT '0' COMMENT '锁定库存',
  PRIMARY KEY (`id`),
  KEY `sku_id` (`sku_id`) USING BTREE,
  KEY `ware_id` (`ware_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品库存';

LOCK TABLES `wms_ware_sku` WRITE;
/*!40000 ALTER TABLE `wms_ware_sku` DISABLE KEYS */;

INSERT INTO `wms_ware_sku` (`id`, `sku_id`, `ware_id`, `stock`, `sku_name`, `stock_locked`)
VALUES
	(2,1,1,5,'华为 x001 2019 红色 6+64',0),
	(3,2,1,10,'华为 x001 2019 红色 6+128',0),
	(4,3,1,10,'华为 x001 2019 黑色 6+64',0),
	(5,4,1,10,'华为 x001 2019 黑色 6+128',0),
	(6,5,1,10,'华为 x001 2019 白色 6+64',0),
	(7,6,1,10,'华为 x001 2019 白色 6+128',0);

/*!40000 ALTER TABLE `wms_ware_sku` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
