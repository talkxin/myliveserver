/*
MySQL Data Transfer
Source Host: 192.168.1.207
Source Database: play
Target Host: 192.168.1.207
Target Database: play
Date: 2013/11/1 13:32:08
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_auth_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_menu`;
CREATE TABLE `t_auth_menu` (
  `menuId` int(9) NOT NULL AUTO_INCREMENT,
  `menuTitle` varchar(50) DEFAULT NULL,
  `menuType` int(1) DEFAULT NULL,
  `menuDescription` varchar(200) DEFAULT NULL,
  `menuLink` varchar(500) DEFAULT '#',
  `menuOperateType` int(1) DEFAULT '1',
  `menuPsersonScope` int(1) DEFAULT '1',
  `menuAreaScope` int(1) DEFAULT '1',
  `menuParentId` int(9) DEFAULT '0',
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_auth_role
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_role`;
CREATE TABLE `t_auth_role` (
  `roleId` int(9) NOT NULL AUTO_INCREMENT,
  `roleTitle` varchar(50) DEFAULT NULL,
  `roleDescription` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_auth_role_vs_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_role_vs_menu`;
CREATE TABLE `t_auth_role_vs_menu` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `roleId` int(9) DEFAULT '0',
  `menuId` int(9) DEFAULT NULL,
  `menuOperateType` int(1) DEFAULT NULL,
  `menuPersonScope` int(1) DEFAULT NULL,
  `menuAreaScope` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_auth_user
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_user`;
CREATE TABLE `t_auth_user` (
  `userId` int(9) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `loginName` varchar(20) DEFAULT NULL,
  `password` char(90) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `roleId` int(9) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_auth_menu` VALUES ('1', '系统管理', '1', '1', '1', '1', '1', '1', '0');
INSERT INTO `t_auth_menu` VALUES ('2', '菜单管理', '2', '1', 'mainEditMenu.do', '1', '1', '1', '1');
INSERT INTO `t_auth_menu` VALUES ('3', '角色管理', '2', '1', 'listRole.do', '1', '1', '1', '1');
INSERT INTO `t_auth_menu` VALUES ('4', '用户管理', '2', '1', 'listUser.do', '1', '1', '1', '1');
INSERT INTO `t_auth_role` VALUES ('1', '超级管理员', '超级管理员');
INSERT INTO `t_auth_role_vs_menu` VALUES ('1', '1', '1', '1', '1', '');
INSERT INTO `t_auth_role_vs_menu` VALUES ('2', '1', '2', '1', '1', '');
INSERT INTO `t_auth_role_vs_menu` VALUES ('3', '1', '3', '1', '1', '');
INSERT INTO `t_auth_role_vs_menu` VALUES ('4', '1', '4', '1', '1', '');
INSERT INTO `t_auth_user` VALUES ('1', 'admin', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin@c-platform.com', '1');
