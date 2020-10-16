/*
 Navicat Premium Data Transfer

 Source Server         : xiaoyao
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : demo123

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 16/10/2020 10:41:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tengyt_todo
-- ----------------------------
DROP TABLE IF EXISTS `tengyt_todo`;
CREATE TABLE `tengyt_todo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datetime` date NULL DEFAULT NULL,
  `ttime` time(0) NULL DEFAULT NULL,
  `looptype` int(11) NULL DEFAULT NULL,
  `week` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usetime` int(11) NULL DEFAULT NULL,
  `grade` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tengyt_todo
-- ----------------------------
INSERT INTO `tengyt_todo` VALUES (20, '2020-10-17', '00:44:01', 5, '周二,周三,周四', 1, 0, '11111', NULL);
INSERT INTO `tengyt_todo` VALUES (21, '2020-10-17', '00:46:49', 5, '周三,周二,周一', 1, 0, '这是修改的内容111111111', NULL);
INSERT INTO `tengyt_todo` VALUES (22, '2020-10-15', '00:57:41', 1, NULL, 1, 0, '2222', NULL);
INSERT INTO `tengyt_todo` VALUES (23, '2020-10-17', '01:15:17', 3, NULL, 0, 0, '1213131`31313131', NULL);
INSERT INTO `tengyt_todo` VALUES (24, '2020-10-23', '01:17:27', 1, NULL, 0, 0, '12131', NULL);
INSERT INTO `tengyt_todo` VALUES (26, '2020-10-16', '10:36:41', 3, NULL, 1, 0, '驾驶的开发结案率', NULL);

-- ----------------------------
-- Table structure for tengyt_user
-- ----------------------------
DROP TABLE IF EXISTS `tengyt_user`;
CREATE TABLE `tengyt_user`  (
  `id` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `urole` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ustate` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tengyt_user
-- ----------------------------
INSERT INTO `tengyt_user` VALUES (1, 'admin', 'admin', '123@abcmail', '超级管理员', 1);
INSERT INTO `tengyt_user` VALUES (2, 'admin1', 'admin1', '123@abcmail', '超级管理员', 0);

SET FOREIGN_KEY_CHECKS = 1;
