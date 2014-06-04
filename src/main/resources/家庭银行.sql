/*
Navicat MySQL Data Transfer

Source Server         : 11
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : mylive

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2014-06-04 11:30:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_paybank_card
-- ----------------------------
DROP TABLE IF EXISTS `t_paybank_card`;
CREATE TABLE `t_paybank_card` (
  `id` int(19) NOT NULL AUTO_INCREMENT,
  `uid` int(19) DEFAULT NULL COMMENT '创建人',
  `cardNo` varchar(10) DEFAULT NULL COMMENT '卡号',
  `name` varchar(50) DEFAULT NULL COMMENT '卡名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_paybank_home
-- ----------------------------
DROP TABLE IF EXISTS `t_paybank_home`;
CREATE TABLE `t_paybank_home` (
  `id` int(19) NOT NULL AUTO_INCREMENT,
  `foundID` int(19) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_paybank_home_all
-- ----------------------------
DROP TABLE IF EXISTS `t_paybank_home_all`;
CREATE TABLE `t_paybank_home_all` (
  `homeID` int(19) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `uid` int(19) DEFAULT NULL,
  PRIMARY KEY (`homeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_paybank_shouzhi
-- ----------------------------
DROP TABLE IF EXISTS `t_paybank_shouzhi`;
CREATE TABLE `t_paybank_shouzhi` (
  `id` int(19) NOT NULL AUTO_INCREMENT,
  `uid` int(19) DEFAULT NULL COMMENT '创建者',
  `time` varchar(25) DEFAULT NULL COMMENT '创建时间',
  `type` int(1) DEFAULT NULL COMMENT '创建类型',
  `money` varchar(25) DEFAULT NULL COMMENT '金额',
  `paymode` int(1) DEFAULT NULL COMMENT '支付类型',
  `cardName` int(19) DEFAULT NULL COMMENT '信用卡',
  `applyto` int(19) DEFAULT NULL COMMENT '分配至',
  `note` varchar(2000) DEFAULT NULL,
  `datajson` varchar(5000) DEFAULT NULL COMMENT '图片或者语音的json保存位置',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_paybank_user
-- ----------------------------
DROP TABLE IF EXISTS `t_paybank_user`;
CREATE TABLE `t_paybank_user` (
  `uid` int(19) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(50) DEFAULT NULL COMMENT '登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_paybank_zhichutype
-- ----------------------------
DROP TABLE IF EXISTS `t_paybank_zhichutype`;
CREATE TABLE `t_paybank_zhichutype` (
  `id` int(19) NOT NULL AUTO_INCREMENT,
  `homeID` int(19) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
