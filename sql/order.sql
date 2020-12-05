# ************************************************************
# Sequel Pro SQL dump
# Version 5446
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 192.168.1.3 (MySQL 5.7.30)
# Database: testtc_oms
# Generation Time: 2020-12-05 10:40:42 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table oms_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `oms_order`;

CREATE TABLE `oms_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_sn` char(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '订单号',
  `create_time` datetime DEFAULT NULL COMMENT 'create_time',
  `total_amount` int(11) DEFAULT NULL COMMENT '订单数量',
  `pay_amount` decimal(18,4) DEFAULT NULL COMMENT '应付总额',
  `pay_type` tinyint(3) DEFAULT NULL COMMENT '支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】',
  `status` tinyint(3) DEFAULT NULL COMMENT '订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】',
  `note` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '订单备注',
  `confirm_status` tinyint(3) DEFAULT NULL COMMENT '确认收货状态[0->未确认；1->已确认]',
  `delete_status` tinyint(1) DEFAULT NULL COMMENT '删除状态【0->未删除；1->已删除】',
  `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='订单';



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
