/*
 Navicat Premium Data Transfer

 Source Server         : 本机mysql
 Source Server Type    : MySQL
 Source Server Version : 50534
 Source Host           : localhost:3306
 Source Schema         : backstage

 Target Server Type    : MySQL
 Target Server Version : 50534
 File Encoding         : 65001

 Date: 02/03/2021 17:03:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for system_menu
-- ----------------------------
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE `system_menu`  (
  `id` varchar(35) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `title` varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `icon` varchar(100) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `href` varchar(100) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `target` varchar(100) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `has_children` varchar(5) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `sort` decimal(10, 0) NULL DEFAULT NULL,
  `parent` varchar(35) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `parent_ids` varchar(180) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `show_flag` varchar(5) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `type` varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `permission` varchar(100) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `create_by` varchar(35) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `create_date` datetime NULL DEFAULT NULL,
  `update_by` varchar(35) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `update_date` datetime NULL DEFAULT NULL,
  `remarks` varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `del_flag` varchar(5) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of system_menu
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
