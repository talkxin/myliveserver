/*
MySQL Data Transfer
Source Host: 192.168.174.130
Source Database: mylive
Target Host: 192.168.174.130
Target Database: mylive
Date: 2014/4/6 18:06:23
*/

SET FOREIGN_KEY_CHECKS=0;
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
  `datajson` varchar(5000) DEFAULT NULL COMMENT '图片或者语音的json保存位置',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
