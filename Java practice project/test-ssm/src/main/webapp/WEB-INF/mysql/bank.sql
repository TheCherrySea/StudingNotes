/*
 Navicat Premium Dump SQL

 Source Server         : sakura
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : bank

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 17/11/2024 22:37:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account`  (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '主键ID，唯一标识账户，方便程序中使用',
  `NUMBER` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '卡号',
  `NAME` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '账户名称',
  `MONEY` decimal(8, 2) NULL DEFAULT NULL COMMENT '账户余额',
  `TYPE_ID` int NULL DEFAULT NULL,
  `SEX` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `CARD_PICTURE` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_account
-- ----------------------------
INSERT INTO `t_account` VALUES (1, '6220998876674343', '张三', 2000.00, 1, '1', NULL);
INSERT INTO `t_account` VALUES (2, '6225789845435435', '李四', 3300.00, 1, '1', NULL);
INSERT INTO `t_account` VALUES (3, '6225789845435437', '王二', 1960.50, 2, '2', NULL);
INSERT INTO `t_account` VALUES (4, '6225789845435436', '张一', 3300.90, 3, '2', NULL);
INSERT INTO `t_account` VALUES (5, '4	6225789845435438', 'sakra', 46564.00, 1, '2', NULL);

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type`  (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '主键ID，唯一标识账户类型',
  `TYPE_NAME` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '类型名称，如：一类户，二类户，VIP户',
  `TYPE_ORDER` tinyint(1) NULL DEFAULT 1 COMMENT '账户类型顺序',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES (1, '一类户', 1);
INSERT INTO `t_type` VALUES (2, '二类户', 2);
INSERT INTO `t_type` VALUES (3, 'VIP户', 3);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户姓名',
  `PHONE` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `loginName` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '登录名',
  `loginPwd` varchar(8) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '登录密码',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '李一', '15900001234', 'liyi', '123456');
INSERT INTO `t_user` VALUES (2, '李二', '15911111234', 'lier', '12345678');
INSERT INTO `t_user` VALUES (3, 'sakra', '15913156564', 'sada', '123456');

SET FOREIGN_KEY_CHECKS = 1;
