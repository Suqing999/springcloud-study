/*
 Navicat Premium Data Transfer

 Source Server         : javaee
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : 192.168.1.100:3306
 Source Schema         : dbsuki

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 08/11/2021 16:09:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `deptno` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '部门表',
  `dname` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `db_source` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '数据库名字',
  PRIMARY KEY (`deptno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '开发部', 'dbsuki');
INSERT INTO `dept` VALUES (2, '财务部', ' dbsuki');
INSERT INTO `dept` VALUES (3, '市场部', ' dbsuki');
INSERT INTO `dept` VALUES (4, '运维部', ' dbsuki');
INSERT INTO `dept` VALUES (5, '人事部', ' dbsuki');
INSERT INTO `dept` VALUES (7, '游戏部', 'dbsuki');

SET FOREIGN_KEY_CHECKS = 1;
