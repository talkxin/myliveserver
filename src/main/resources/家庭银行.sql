/*
MySQL Data Transfer
Source Host: localhost
Source Database: mylive
Target Host: localhost
Target Database: mylive
Date: 2014/4/4 16:48:14
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_paybank_card
-- ----------------------------
DROP TABLE IF EXISTS `t_paybank_card`;
CREATE TABLE `t_paybank_card` (
  `id` int(19) NOT NULL AUTO_INCREMENT,
  `uid` int(19) DEFAULT NULL,
  `cardNo` varchar(10) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_paybank_home
-- ----------------------------
DROP TABLE IF EXISTS `t_paybank_home`;
CREATE TABLE `t_paybank_home` (
  `id` int(19) NOT NULL AUTO_INCREMENT,
  `uid` int(19) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `pinyinName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_paybank_shouzhi
-- ----------------------------
DROP TABLE IF EXISTS `t_paybank_shouzhi`;
CREATE TABLE `t_paybank_shouzhi` (
  `id` int(19) NOT NULL AUTO_INCREMENT,
  `uid` int(19) DEFAULT NULL,
  `time` varchar(25) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `money` double(25,0) DEFAULT NULL,
  `paymode` int(1) DEFAULT NULL,
  `cardName` int(19) DEFAULT NULL,
  `applyto` int(19) DEFAULT NULL,
  `note` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_paybank_zhichutype
-- ----------------------------
DROP TABLE IF EXISTS `t_paybank_zhichutype`;
CREATE TABLE `t_paybank_zhichutype` (
  `id` int(19) NOT NULL AUTO_INCREMENT,
  `uid` int(19) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `pinyinName` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
