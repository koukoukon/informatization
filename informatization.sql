/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : informatization

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 03/06/2020 22:07:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apply
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply`  (
  `apply_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `apply_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `apply_comment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_pid` bigint(0) NULL DEFAULT NULL,
  `apply_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `apply_end_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `approve_comment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `approve_user_pid` bigint(0) NULL DEFAULT NULL,
  `apply_status` int(0) NOT NULL,
  PRIMARY KEY (`apply_id`) USING BTREE,
  INDEX `FK1615FA3D51E1F6`(`approve_user_pid`) USING BTREE,
  INDEX `FK1615FA3C8F82AB5`(`user_pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of apply
-- ----------------------------
INSERT INTO `apply` VALUES (1, '出差申请', '出差申请', 3, '2017-04-18 20:04', NULL, NULL, NULL, 0);
INSERT INTO `apply` VALUES (14, '加班申请', '晚上加班申请', 1, '2018-01-30 10:47:50', '2018-01-30 15:22:06', '不通过', 1, 2);
INSERT INTO `apply` VALUES (15, '加班申请', '晚上加班3个小时申请', 1, '2018-01-30 10:47:50', '2018-01-30 15:24:26', '通过', 5, 3);
INSERT INTO `apply` VALUES (16, '加班申请', '加班申请', 1, '2020-05-07 04:14:08', NULL, NULL, NULL, 0);
INSERT INTO `apply` VALUES (17, '加班申请2', '加班申请2', 1, '2020-05-07 04:14:19', NULL, NULL, NULL, 0);
INSERT INTO `apply` VALUES (18, '请假申请', '请假申请', 1, '2020-05-07 04:14:23', NULL, NULL, NULL, 0);
INSERT INTO `apply` VALUES (19, '离职申请', '离职申请', 1, '2020-05-07 04:14:30', NULL, NULL, NULL, 0);
INSERT INTO `apply` VALUES (20, '请假申请', '探亲', 1, '2020-05-07 04:36:51', NULL, NULL, NULL, 0);
INSERT INTO `apply` VALUES (21, '测试', '测试', 1, '2020-05-11 21:04:45', '2020-05-11 21:06:12', '同意2', 1, -1);

-- ----------------------------
-- Table structure for approve
-- ----------------------------
DROP TABLE IF EXISTS `approve`;
CREATE TABLE `approve`  (
  `approve_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `apply_pid` bigint(0) NULL DEFAULT NULL,
  `user_pid` bigint(0) NULL DEFAULT NULL,
  `approve_comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `approve_date` datetime(0) NULL DEFAULT NULL,
  `approve_status` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`approve_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of approve
-- ----------------------------
INSERT INTO `approve` VALUES (1, 21, 1, '同意', '2020-05-08 18:54:01', 1);
INSERT INTO `approve` VALUES (2, 21, 1, '同意', '2020-05-08 19:02:26', 1);
INSERT INTO `approve` VALUES (3, 21, 1, '同意', '2020-05-08 19:04:32', 1);
INSERT INTO `approve` VALUES (4, 21, 1, '同意', '2020-05-11 20:59:41', -1);
INSERT INTO `approve` VALUES (5, 21, 1, '同意', '2020-05-11 21:03:19', -1);
INSERT INTO `approve` VALUES (6, 21, 1, '同意', '2020-05-11 21:04:45', -1);
INSERT INTO `approve` VALUES (7, 21, 1, '同意2', '2020-05-11 21:06:13', -1);

-- ----------------------------
-- Table structure for askforleave2
-- ----------------------------
DROP TABLE IF EXISTS `askforleave2`;
CREATE TABLE `askforleave2`  (
  `askforleave_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `askforleave_create_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `askforleave_end_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `askforleave_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `askforleave_start_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `askforleave_status` int(0) NOT NULL,
  `apply_user_pid` bigint(0) NULL DEFAULT NULL,
  `department_pid` bigint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`askforleave_id`) USING BTREE,
  INDEX `FKDAB35D7C879016C7`(`apply_user_pid`) USING BTREE,
  INDEX `FKDAB35D7CBCB3F055`(`department_pid`) USING BTREE,
  CONSTRAINT `FKDAB35D7CBCB3F055` FOREIGN KEY (`department_pid`) REFERENCES `department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of askforleave2
-- ----------------------------
INSERT INTO `askforleave2` VALUES (1, '2017-03-17 21:47', '2017-03-17', 'AL20170001', '2017-03-17', 3, 1, 1);
INSERT INTO `askforleave2` VALUES (2, '2017-04-18 20:00', '2017-04-18', 'AL20170002', '2017-04-18', 0, 1, 1);

-- ----------------------------
-- Table structure for authandsourceinfo
-- ----------------------------
DROP TABLE IF EXISTS `authandsourceinfo`;
CREATE TABLE `authandsourceinfo`  (
  `authandsourceinfoid` bigint(0) NOT NULL AUTO_INCREMENT,
  `authName_Chinese` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authid` int(0) NOT NULL,
  `menuTitle_Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `source_Url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`authandsourceinfoid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authandsourceinfo
-- ----------------------------
INSERT INTO `authandsourceinfo` VALUES (1, '员工信息管理', 1, '系统信息管理', 'userAction!list.action');
INSERT INTO `authandsourceinfo` VALUES (2, '部门管理', 1, '系统信息管理', 'departmentAction!list.action');
INSERT INTO `authandsourceinfo` VALUES (3, '请假管理', 2, '考勤信息管理', '#');
INSERT INTO `authandsourceinfo` VALUES (4, '文件管理', 3, '办公信息管理', 'userFileAction!list.action');
INSERT INTO `authandsourceinfo` VALUES (5, '申请管理', 3, '办公信息管理', 'applyAction!list.action');
INSERT INTO `authandsourceinfo` VALUES (6, '审批记录管理', 4, '申请审批管理', 'applyAction!recordList.action');
INSERT INTO `authandsourceinfo` VALUES (7, '请假审批管理', 4, '申请审批管理', '#');
INSERT INTO `authandsourceinfo` VALUES (8, '发送的消息', 5, '消息管理', '#');
INSERT INTO `authandsourceinfo` VALUES (9, '收到的消息', 5, '消息管理', '#');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `department_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `department_comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `department_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `department_delete_flag` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`department_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '人事部', '人力资源管理<br>', 'D20170001', 0);
INSERT INTO `department` VALUES (2, '研发部', '研发部研发部<br>', 'D20170002', 0);
INSERT INTO `department` VALUES (3, '安保部', '保护不了任何人', 'U20180003', 0);
INSERT INTO `department` VALUES (4, 'qq', 'qqq', 'U20180005', 0);
INSERT INTO `department` VALUES (5, 'aaaa', 'aaaa', 'U20180006', 0);
INSERT INTO `department` VALUES (6, 'aa', 'ddd', 'U20180007', 0);
INSERT INTO `department` VALUES (7, 'bbb', 'bb', 'bbb', 0);
INSERT INTO `department` VALUES (8, 'ggggg', 'ggg', 'ggg', 0);
INSERT INTO `department` VALUES (9, 'dd', 'dd', 'bbb3', 0);
INSERT INTO `department` VALUES (10, 's', 's', 'bbb2', 0);
INSERT INTO `department` VALUES (11, 'bb', 'b', 'b', 0);

-- ----------------------------
-- Table structure for master
-- ----------------------------
DROP TABLE IF EXISTS `master`;
CREATE TABLE `master`  (
  `masterid` bigint(0) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mastername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`masterid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of master
-- ----------------------------
INSERT INTO `master` VALUES (1, '001', '管理员', '管理员');
INSERT INTO `master` VALUES (2, '001', '部门经理', '部门经理');
INSERT INTO `master` VALUES (3, '001', '总经理', '总经理');
INSERT INTO `master` VALUES (4, '001', '普通员工', '普通员工');

-- ----------------------------
-- Table structure for messageinfo
-- ----------------------------
DROP TABLE IF EXISTS `messageinfo`;
CREATE TABLE `messageinfo`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deleteflag` int(0) NOT NULL,
  `messageflag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiveDate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `replayDate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sendDate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reciveUser_id` bigint(0) NULL DEFAULT NULL,
  `sendUser_id` bigint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK6A3D1DAAC13EED5B`(`sendUser_id`) USING BTREE,
  INDEX `FK6A3D1DAA8D8D4E9B`(`reciveUser_id`) USING BTREE,
  CONSTRAINT `FK6A3D1DAA8D8D4E9B` FOREIGN KEY (`reciveUser_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK6A3D1DAAC13EED5B` FOREIGN KEY (`sendUser_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of messageinfo
-- ----------------------------
INSERT INTO `messageinfo` VALUES (1, '玩儿去问', 0, 'send', 'SM20170001', '2017-04-01 10:51:14', '2017-04-01 10:51:14', '2017-04-01 10:49:01', 2, 5);
INSERT INTO `messageinfo` VALUES (2, '2222', 0, 'receive', 'SM20170002', '2017-04-01 10:54:30', '2017-04-01 10:54:30', '2017-04-01 10:51:14', 5, 2);
INSERT INTO `messageinfo` VALUES (3, '444', 0, 'receive', 'SM20170003', NULL, NULL, '2017-04-01 10:54:30', 2, 5);
INSERT INTO `messageinfo` VALUES (4, '吾问无为谓吾问无为谓', 0, 'send', 'SM20170004', '2017-04-01 20:28:27', '2017-04-01 20:28:27', '2017-04-01 20:26:35', 5, 1);
INSERT INTO `messageinfo` VALUES (5, '23234234', 0, 'receive', 'SM20170005', '2017-04-18 20:14', '2017-04-01 20:28:53', '2017-04-01 20:28:27', 1, 5);
INSERT INTO `messageinfo` VALUES (6, '11111', 0, 'receive', 'SM20170006', '2017-04-01 20:29', NULL, '2017-04-01 20:28:53', 5, 1);
INSERT INTO `messageinfo` VALUES (7, '消息内容消息内容消息内容消息内容消息内容<br>', 0, 'send', 'SM20170007', '2017-04-01 20:30', NULL, '2017-04-01 20:30:00', 5, 1);
INSERT INTO `messageinfo` VALUES (8, '333', 0, 'send', 'SM20170008', '2017-04-18 20:05', NULL, '2017-04-01 20:35:15', 3, 1);
INSERT INTO `messageinfo` VALUES (9, '测试', 0, 'send', 'SM20170009', NULL, NULL, '2017-04-18 20:02:39', 6, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authority_pid` int(0) NOT NULL,
  `department_pid` bigint(0) NULL DEFAULT NULL,
  `user_delete_flag` int(0) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `FK94B9B0D6BCB3F055`(`department_pid`) USING BTREE,
  CONSTRAINT `FK94B9B0D6BCB3F055` FOREIGN KEY (`department_pid`) REFERENCES `department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKs1rnm14ev9cb4bbxcspqmcto3` FOREIGN KEY (`department_pid`) REFERENCES `department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', '测试', '女', '13566568974@qq.com', '132xxxxx123', 1, 1, 0);
INSERT INTO `user` VALUES (2, 'U20170002', 'password', '部门经理', '男', '3252345@163.com', '139xxxxx678', 2, 1, 0);
INSERT INTO `user` VALUES (3, 'U20170003', 'password', '员工1', '男', '2352354@qq.com', '159xxxxx678', 4, 1, 0);
INSERT INTO `user` VALUES (4, 'U20170004', 'password', '公告', '男', '2345234523@qq.com', '136xxxxx678', 2, 1, 0);
INSERT INTO `user` VALUES (5, 'U20170005', 'password', '哈哈', '男', '34523@qq.com', '135xxxxx678', 3, 1, 0);
INSERT INTO `user` VALUES (6, 'U20170006', 'password', '张三', '男', 'zhangsan@163.com', '152xxxxx678', 4, 2, 0);
INSERT INTO `user` VALUES (7, 'test', 'test', 'test', '男', 'test', 'test', 1, 1, 0);
INSERT INTO `user` VALUES (9, 'admin2', 'admin', '测试', '女', '13566568974@qq.com', '132xxxxx123', 1, 1, 0);
INSERT INTO `user` VALUES (10, 'admin3', 'admin', '测试', '女', '13566568974@qq.com', '132xxxxx123', 1, 1, 0);
INSERT INTO `user` VALUES (11, 'admin4', 'admin', '测试', '女', '13566568974@qq.com', '132xxxxx123', 1, 1, 0);
INSERT INTO `user` VALUES (12, 'admin8', 'admin', '测试', '女', '13566568974@qq.com', '132xxxxx123', 1, 1, 0);
INSERT INTO `user` VALUES (13, 'test2', 'test2', 'test2', '男', 'test2', 'test2', 1, 1, 0);
INSERT INTO `user` VALUES (14, 'test3', 'test3', 'test3', '男', 'test3', 'test3', 1, 1, 0);
INSERT INTO `user` VALUES (15, 'asd5', 'asd', 'asd', '男', 'asd', 'asd', 1, 1, 0);
INSERT INTO `user` VALUES (16, '6669', '666', '666', '男', '666', '666', 1, 1, 0);
INSERT INTO `user` VALUES (17, 'sxc', 'sxc', 'sxc', '男', 'sxc', 'sxc', 1, 1, 0);

-- ----------------------------
-- Table structure for user_file
-- ----------------------------
DROP TABLE IF EXISTS `user_file`;
CREATE TABLE `user_file`  (
  `user_file_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `user_file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_file_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_file_comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_file_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_pid` bigint(0) NULL DEFAULT NULL,
  `user_file_delete_flag` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_file_id`) USING BTREE,
  INDEX `FK4C4A4352342BC5E3`(`user_pid`) USING BTREE,
  CONSTRAINT `FK4C4A4352342BC5E3` FOREIGN KEY (`user_pid`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK54ih4f631noix1tv1o5pgarlp` FOREIGN KEY (`user_pid`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_file
-- ----------------------------
INSERT INTO `user_file` VALUES (1, '1492516881087.txt', '转正', '转正申请', '2017-04-18 20:01', 1, 1);
INSERT INTO `user_file` VALUES (2, '1517205193187doc', '转正申请', '转正申请', '2018-01-29 13:53:13', 1, 1);
INSERT INTO `user_file` VALUES (3, '1517205727863.xlsx', '离职申请', '离职申请', '2018-01-29 14:02:07', 1, 1);
INSERT INTO `user_file` VALUES (4, '156165165.jpg', '日语发音', '日语发音', '2020-05-12 21:05:34', 1, 0);
INSERT INTO `user_file` VALUES (5, '1517207012186.doc', '转正申请', '转正申请', '2018-01-29 14:02:07', 2, 0);
INSERT INTO `user_file` VALUES (7, 'ace3b6bc7e4b6518d67571bd85781791_720w.jpg', '日语发音', '日语发音', '2020-05-12 21:09:57', 1, 0);
INSERT INTO `user_file` VALUES (8, 'ace3b6bc7e4b6518d67571bd85781791_720w.jpg', '日语发音', '日语发音', '2020-05-12 21:10:52', 1, 0);
INSERT INTO `user_file` VALUES (9, 'ace3b6bc7e4b6518d67571bd85781791_720w.jpg', '日语发音', '日语发音', '2020-05-12 21:13:40', 1, 0);
INSERT INTO `user_file` VALUES (10, 'ace3b6bc7e4b6518d67571bd85781791_720w.jpg', '日语发音', '日语发音', '2020-05-12 21:15:03', 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
