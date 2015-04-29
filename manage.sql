/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : manage

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2015-04-29 15:36:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for m_bookbinding
-- ----------------------------
DROP TABLE IF EXISTS `m_bookbinding`;
CREATE TABLE `m_bookbinding` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) default NULL,
  `material` varchar(255) default NULL,
  `form` varchar(255) default NULL,
  `style` varchar(255) default NULL,
  `flow` varchar(255) default NULL,
  `remark` varchar(255) default NULL,
  `created_date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_bookbinding
-- ----------------------------

-- ----------------------------
-- Table structure for m_contact
-- ----------------------------
DROP TABLE IF EXISTS `m_contact`;
CREATE TABLE `m_contact` (
  `id` varchar(32) NOT NULL,
  `contact_id` varchar(255) default NULL,
  `page` varchar(255) default NULL,
  `author` varchar(255) default NULL,
  `manuscript_out_date` datetime default NULL,
  `address` varchar(255) default NULL,
  `discount` varchar(255) default NULL,
  `type` tinyblob,
  `created_date` datetime default NULL,
  `remark` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_contact
-- ----------------------------
INSERT INTO `m_contact` VALUES ('5b1943db4cff58b9014cff5c9ae20001', '12', '12', '111', '2015-04-28 00:00:00', '123123', '0.2', 0xACED00057E7200316D652E6D616E6167652E646F6D61696E2E6D6F64656C2E6269616E77752E636F6E746163742E436F6E746163745479706500000000000000001200007872000E6A6176612E6C616E672E456E756D0000000000000000120000787074000A434F4D4D495353494F4E, '2015-04-28 17:30:01', '');

-- ----------------------------
-- Table structure for m_customer
-- ----------------------------
DROP TABLE IF EXISTS `m_customer`;
CREATE TABLE `m_customer` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) default NULL,
  `contact` varchar(255) default NULL,
  `tel` varchar(255) default NULL,
  `delivery_style` varchar(255) default NULL,
  `delivery_date` datetime default NULL,
  `delivery_address` varchar(255) default NULL,
  `type` tinyblob,
  `remark` varchar(255) default NULL,
  `created_date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_customer
-- ----------------------------
INSERT INTO `m_customer` VALUES ('f7d5593a4d018f18014d01939b950000', '123', '123', '123', '123', '2015-04-29 00:00:00', '123', 0xACED00057E7200336D652E6D616E6167652E646F6D61696E2E6D6F64656C2E666178696E672E637573746F6D65722E437573746F6D65725479706500000000000000001200007872000E6A6176612E6C616E672E456E756D000000000000000012000078707400084D45524348414E54, '', '2015-04-29 03:49:20');

-- ----------------------------
-- Table structure for m_delivery
-- ----------------------------
DROP TABLE IF EXISTS `m_delivery`;
CREATE TABLE `m_delivery` (
  `id` varchar(32) NOT NULL,
  `delivery_id` varchar(255) default NULL,
  `supplier` varchar(255) default NULL,
  `style` varchar(255) default NULL,
  `delivery_date` datetime default NULL,
  `product_id` varchar(255) default NULL,
  `product_name` varchar(255) default NULL,
  `product_type` varchar(255) default NULL,
  `isbn` varchar(255) default NULL,
  `author` varchar(255) default NULL,
  `press` varchar(255) default NULL,
  `store_address` varchar(255) default NULL,
  `num` varchar(255) default NULL,
  `price` varchar(255) default NULL,
  `total_amount` varchar(255) default NULL,
  `principal` varchar(255) default NULL,
  `remark` varchar(255) default NULL,
  `created_date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_delivery
-- ----------------------------

-- ----------------------------
-- Table structure for m_designing
-- ----------------------------
DROP TABLE IF EXISTS `m_designing`;
CREATE TABLE `m_designing` (
  `id` varchar(32) NOT NULL,
  `part` varchar(255) default NULL,
  `content` varchar(255) default NULL,
  `thing` varchar(255) default NULL,
  `department` varchar(255) default NULL,
  `principal` varchar(255) default NULL,
  `begin_date` datetime default NULL,
  `end_date` datetime default NULL,
  `created_date` datetime default NULL,
  `status` tinyblob,
  `user_id` varchar(32) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_65miwumwrq1803djmaeifj9e5` (`user_id`),
  CONSTRAINT `FK_65miwumwrq1803djmaeifj9e5` FOREIGN KEY (`user_id`) REFERENCES `m_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_designing
-- ----------------------------

-- ----------------------------
-- Table structure for m_editing
-- ----------------------------
DROP TABLE IF EXISTS `m_editing`;
CREATE TABLE `m_editing` (
  `id` varchar(32) NOT NULL,
  `part` varchar(255) default NULL,
  `content` varchar(255) default NULL,
  `thing` varchar(255) default NULL,
  `department` varchar(255) default NULL,
  `operator` varchar(255) default NULL,
  `begin_date` datetime default NULL,
  `end_date` datetime default NULL,
  `created_date` datetime default NULL,
  `status` tinyblob,
  `user_id` varchar(32) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_p0hpblxwty7ni889wak76h9f2` (`user_id`),
  CONSTRAINT `FK_p0hpblxwty7ni889wak76h9f2` FOREIGN KEY (`user_id`) REFERENCES `m_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_editing
-- ----------------------------

-- ----------------------------
-- Table structure for m_issue
-- ----------------------------
DROP TABLE IF EXISTS `m_issue`;
CREATE TABLE `m_issue` (
  `id` varchar(32) NOT NULL,
  `part` varchar(255) default NULL,
  `content` varchar(255) default NULL,
  `thing` varchar(255) default NULL,
  `department` varchar(255) default NULL,
  `principal` varchar(255) default NULL,
  `begin_date` datetime default NULL,
  `end_date` datetime default NULL,
  `created_date` datetime default NULL,
  `status` tinyblob,
  `user_id` varchar(32) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_5ipf3k6aaqtm2iuycc3njvt10` (`user_id`),
  CONSTRAINT `FK_5ipf3k6aaqtm2iuycc3njvt10` FOREIGN KEY (`user_id`) REFERENCES `m_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_issue
-- ----------------------------
INSERT INTO `m_issue` VALUES ('f7d5593a4d00dd71014d00e039080001', '1', '1', '1', '1', '1', '2015-04-29 00:00:00', '2015-04-29 00:00:00', '2015-04-29 00:33:24', 0xACED00057E72002F6D652E6D616E6167652E646F6D61696E2E6D6F64656C2E666178696E672E69737375652E497373756553746174757300000000000000001200007872000E6A6176612E6C616E672E456E756D0000000000000000120000787074000846494E4953484544, '5b1943db4cfe3828014cfe3e58860003');
INSERT INTO `m_issue` VALUES ('f7d5593a4d00dd71014d00e060920002', '2', '2', '2', '2', '2', '2015-04-29 00:00:00', '2015-04-29 00:00:00', '2015-04-29 00:33:34', 0xACED00057E72002F6D652E6D616E6167652E646F6D61696E2E6D6F64656C2E666178696E672E69737375652E497373756553746174757300000000000000001200007872000E6A6176612E6C616E672E456E756D0000000000000000120000787074000A554E46494E4953484544, '5b1943db4cfe3828014cfe3e58860003');

-- ----------------------------
-- Table structure for m_logistics_topic
-- ----------------------------
DROP TABLE IF EXISTS `m_logistics_topic`;
CREATE TABLE `m_logistics_topic` (
  `id` varchar(32) NOT NULL,
  `part` varchar(255) default NULL,
  `content` varchar(255) default NULL,
  `thing` varchar(255) default NULL,
  `department` varchar(255) default NULL,
  `principal` varchar(255) default NULL,
  `begin_date` datetime default NULL,
  `end_date` datetime default NULL,
  `created_date` datetime default NULL,
  `status` tinyblob,
  `user_id` varchar(32) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_pju4ftfk1r4nveoddwavwt7k` (`user_id`),
  CONSTRAINT `FK_pju4ftfk1r4nveoddwavwt7k` FOREIGN KEY (`user_id`) REFERENCES `m_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_logistics_topic
-- ----------------------------

-- ----------------------------
-- Table structure for m_manuscript
-- ----------------------------
DROP TABLE IF EXISTS `m_manuscript`;
CREATE TABLE `m_manuscript` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) default NULL,
  `author` varchar(255) default NULL,
  `count` varchar(255) default NULL,
  `discount` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `opinion` varchar(255) default NULL,
  `editor` varchar(255) default NULL,
  `principal` varchar(255) default NULL,
  `created_date` datetime default NULL,
  `remark` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_manuscript
-- ----------------------------

-- ----------------------------
-- Table structure for m_permission
-- ----------------------------
DROP TABLE IF EXISTS `m_permission`;
CREATE TABLE `m_permission` (
  `id` varchar(32) NOT NULL,
  `resource` varchar(50) default NULL,
  `describtion` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_permission
-- ----------------------------

-- ----------------------------
-- Table structure for m_printing
-- ----------------------------
DROP TABLE IF EXISTS `m_printing`;
CREATE TABLE `m_printing` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) default NULL,
  `type` varchar(255) default NULL,
  `paper` varchar(255) default NULL,
  `paper_type` varchar(255) default NULL,
  `ink` varchar(255) default NULL,
  `wrapper` varchar(255) default NULL,
  `print_date` varchar(255) default NULL,
  `remark` varchar(255) default NULL,
  `created_date` datetime default NULL,
  `isbn` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_printing
-- ----------------------------

-- ----------------------------
-- Table structure for m_procurement_sales
-- ----------------------------
DROP TABLE IF EXISTS `m_procurement_sales`;
CREATE TABLE `m_procurement_sales` (
  `id` varchar(32) NOT NULL,
  `product_id` varchar(255) default NULL,
  `product_name` varchar(255) default NULL,
  `product_style` varchar(255) default NULL,
  `unit` varchar(255) default NULL,
  `num` varchar(255) default NULL,
  `price` varchar(255) default NULL,
  `discount` varchar(255) default NULL,
  `tax_rate` varchar(255) default NULL,
  `amount_of_tax` varchar(255) default NULL,
  `type` tinyblob,
  `amount` varchar(255) default NULL,
  `created_date` datetime default NULL,
  `customer_id` varchar(32) default NULL,
  `remark` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_fibphgksm7idvo6163eyec9rn` (`customer_id`),
  CONSTRAINT `FK_fibphgksm7idvo6163eyec9rn` FOREIGN KEY (`customer_id`) REFERENCES `m_customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_procurement_sales
-- ----------------------------
INSERT INTO `m_procurement_sales` VALUES ('f7d5593a4d01a5fe014d01a7ff740001', '321', '321', '321', '321', '321', '321', '312', '321', '321', 0xACED00057E7200336D652E6D616E6167652E646F6D61696E2E6D6F64656C2E666178696E672E627573696E6573732E437573746F6D65725479706500000000000000001200007872000E6A6176612E6C616E672E456E756D000000000000000012000078707400084D45524348414E54, '321', '2015-04-29 04:11:36', 'f7d5593a4d018f18014d01939b950000', '');

-- ----------------------------
-- Table structure for m_role
-- ----------------------------
DROP TABLE IF EXISTS `m_role`;
CREATE TABLE `m_role` (
  `id` varchar(32) NOT NULL,
  `role` varchar(32) default NULL,
  `description` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_role
-- ----------------------------
INSERT INTO `m_role` VALUES ('5b1943db4cfe3828014cfe3c9ec90001', 'administrator', '超级管理员');
INSERT INTO `m_role` VALUES ('5b1943db4cfe3828014cfe47949e0004', 'bianwuadmin', '编务管理系统-管理员');
INSERT INTO `m_role` VALUES ('5b1943db4cfe3828014cfe47ffe50005', 'yinwuadmin', '印务管理系统-管理员');
INSERT INTO `m_role` VALUES ('5b1943db4cfe3828014cfe4862f00006', 'caiwuadmin', '财务管理系统-管理员');
INSERT INTO `m_role` VALUES ('5b1943db4cfe3828014cfe490fef0007', 'wuliuadmin', '物流管理系统-管理员');

-- ----------------------------
-- Table structure for m_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `m_role_permission`;
CREATE TABLE `m_role_permission` (
  `permission_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY  (`role_id`,`permission_id`),
  KEY `FK_q049us1lewp3aqmcel1448cka` (`permission_id`),
  CONSTRAINT `FK_q049us1lewp3aqmcel1448cka` FOREIGN KEY (`permission_id`) REFERENCES `m_permission` (`id`),
  CONSTRAINT `FK_4gc9jmgkj4e0wpidlolre8a4l` FOREIGN KEY (`role_id`) REFERENCES `m_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(32) default NULL,
  `real_name` varchar(32) default NULL,
  `password` varchar(32) default NULL,
  `salt` varchar(32) default NULL,
  `sex` bit(1) default NULL,
  `email` varchar(32) default NULL,
  `telephone` varchar(11) default NULL,
  `id_card` varchar(18) default NULL,
  `organization` varchar(64) default NULL,
  `created_date` datetime default NULL,
  `remark` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_brmb54ld0gqstogmb812xw951` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES ('5b1943db4cfe3828014cfe3e58860003', 'admin', 'admin', '6ee24ac0c801f83c67caecc430ed12a2', 'd76c5b360a504d168bcfac61a8a5e7cd', '', 'perman@163.com', '18883871276', '500236199308256789', '重庆', '2015-04-28 12:17:21', '');
INSERT INTO `m_user` VALUES ('5b1943db4cfe3828014cfe51d95d0008', 'zk123', 'zk123', '6fa62bf1c1d16dde412227a01c3cd480', 'f14b9bec4eb845ad8378c1cf568d9548', '\0', '1162336040@qq.com', '18883871276', '500236199308256789', '重庆', '2015-04-28 12:38:39', '');
INSERT INTO `m_user` VALUES ('f7d5531c4d036c77014d0373d2af0003', 'liwenhe', 'liwenhe', '0999117470c67535596d7b42fac1883b', '22585f26e8ae4702944f883d333f5a15', '', 'perman@163.com', '18883871276', '500236199308256789', '重庆', '2015-04-29 12:33:51', null);

-- ----------------------------
-- Table structure for m_user_role
-- ----------------------------
DROP TABLE IF EXISTS `m_user_role`;
CREATE TABLE `m_user_role` (
  `role_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  PRIMARY KEY  (`user_id`,`role_id`),
  KEY `FK_axgmpwl66rqvvsif5lmcibuul` (`role_id`),
  CONSTRAINT `FK_axgmpwl66rqvvsif5lmcibuul` FOREIGN KEY (`role_id`) REFERENCES `m_role` (`id`),
  CONSTRAINT `FK_cvgjrlab20dajhlwerybfu8cr` FOREIGN KEY (`user_id`) REFERENCES `m_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_user_role
-- ----------------------------
INSERT INTO `m_user_role` VALUES ('5b1943db4cfe3828014cfe3c9ec90001', '5b1943db4cfe3828014cfe3e58860003');
INSERT INTO `m_user_role` VALUES ('5b1943db4cfe3828014cfe47ffe50005', '5b1943db4cfe3828014cfe51d95d0008');

-- ----------------------------
-- Table structure for m_verified_user
-- ----------------------------
DROP TABLE IF EXISTS `m_verified_user`;
CREATE TABLE `m_verified_user` (
  `id` varchar(32) NOT NULL,
  `type` int(11) default NULL,
  `username` varchar(32) default NULL,
  `real_name` varchar(32) default NULL,
  `password` varchar(32) default NULL,
  `salt` varchar(32) default NULL,
  `sex` bit(1) default NULL,
  `email` varchar(32) default NULL,
  `telephone` varchar(11) default NULL,
  `id_card` varchar(255) default NULL,
  `organization` varchar(255) default NULL,
  `created_date` datetime default NULL,
  `remark` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_i412frxvvb4v27664xwgjp2nf` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_verified_user
-- ----------------------------

-- ----------------------------
-- Table structure for m_warehousing
-- ----------------------------
DROP TABLE IF EXISTS `m_warehousing`;
CREATE TABLE `m_warehousing` (
  `id` varchar(32) NOT NULL,
  `warehousing_id` varchar(255) default NULL,
  `supplier` varchar(255) default NULL,
  `style` varchar(255) default NULL,
  `warehousing_date` datetime default NULL,
  `product_id` varchar(255) default NULL,
  `product_name` varchar(255) default NULL,
  `product_type` varchar(255) default NULL,
  `isbn` varchar(255) default NULL,
  `author` varchar(255) default NULL,
  `press` varchar(255) default NULL,
  `store_address` varchar(255) default NULL,
  `num` varchar(255) default NULL,
  `price` varchar(255) default NULL,
  `total_amount` varchar(255) default NULL,
  `principal` varchar(255) default NULL,
  `remark` varchar(255) default NULL,
  `created_date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_warehousing
-- ----------------------------
INSERT INTO `m_warehousing` VALUES ('f7d5531c4d03bc12014d03be86010000', '123', '123', '123', '2014-12-04 00:00:00', '123123', '123123', '123123', '123123', '123123321', '123123123', '123123', '123123', '123123123', '123123', null, '12312', '2015-04-29 13:55:27');
INSERT INTO `m_warehousing` VALUES ('f7d5531c4d03bc12014d03c20cb30001', '1', '2', '3', '2009-11-01 00:00:00', '4', '5', '6', '7', '8', '9', '11', '12', '222222222222222', '13', 'ffff', '14', '2015-04-29 14:02:31');
