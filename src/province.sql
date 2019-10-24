/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50525
 Source Host           : localhost:3306
 Source Schema         : chenxue

 Target Server Type    : MySQL
 Target Server Version : 50525
 File Encoding         : 65001

 Date: 24/10/2019 19:04:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province`  (
  `pid` int(2) NOT NULL AUTO_INCREMENT,
  `pName` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES (1, '北京市');
INSERT INTO `province` VALUES (2, '广东省');
INSERT INTO `province` VALUES (3, '山东省');
INSERT INTO `province` VALUES (4, '江苏省');
INSERT INTO `province` VALUES (5, '河南省');
INSERT INTO `province` VALUES (6, '上海市');
INSERT INTO `province` VALUES (7, '河北省');
INSERT INTO `province` VALUES (8, '浙江省');
INSERT INTO `province` VALUES (9, '香港特别行政区');
INSERT INTO `province` VALUES (10, '陕西省');
INSERT INTO `province` VALUES (11, '湖南省');
INSERT INTO `province` VALUES (12, '重庆市');
INSERT INTO `province` VALUES (13, '福建省');
INSERT INTO `province` VALUES (14, '天津市');
INSERT INTO `province` VALUES (15, '云南省');
INSERT INTO `province` VALUES (16, '四川省');
INSERT INTO `province` VALUES (17, '广西壮族自治区');
INSERT INTO `province` VALUES (18, '安徽省');
INSERT INTO `province` VALUES (19, '海南省');
INSERT INTO `province` VALUES (20, '江西省');
INSERT INTO `province` VALUES (21, '湖北省');
INSERT INTO `province` VALUES (22, '山西省');
INSERT INTO `province` VALUES (23, '辽宁省');
INSERT INTO `province` VALUES (24, '台湾省');
INSERT INTO `province` VALUES (25, '黑龙江');
INSERT INTO `province` VALUES (26, '内蒙古自治区');
INSERT INTO `province` VALUES (27, '澳门特别行政区');
INSERT INTO `province` VALUES (28, '贵州省');
INSERT INTO `province` VALUES (29, '甘肃省');
INSERT INTO `province` VALUES (30, '青海省');
INSERT INTO `province` VALUES (31, '新疆维吾尔自治区');
INSERT INTO `province` VALUES (32, '西藏区');
INSERT INTO `province` VALUES (33, '吉林省');
INSERT INTO `province` VALUES (34, '宁夏回族自治区');

SET FOREIGN_KEY_CHECKS = 1;
