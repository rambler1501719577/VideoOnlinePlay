/*
 Navicat Premium Data Transfer

 Source Server         : Localhost
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : teacher

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 09/02/2020 10:54:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apply
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `nation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '民族',
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生日',
  `politics` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '政治面貌',
  `professional` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称',
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `we_chat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信',
  `mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `graduate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业学校',
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `degree` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学位',
  `come_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来校工作时间',
  `train_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '培养起止时间',
  `teacher_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指导教师姓名',
  `teacher_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指导教师性别',
  `teacher_age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指导教师年龄',
  `teacher_professional` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指导教师职称',
  `train_plan` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '培养计划',
  `teaching_option` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教研室意见',
  `unit_option` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教学单位意见',
  `office_option` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教务处意见',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态,0表示提交审核, 1表示通过, 2表示未通过',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  `apartment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属学院',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of apply
-- ----------------------------
INSERT INTO `apply` VALUES ('055b7a8e29b34379bbad40a12be796ee', '2', '男', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '1', '2019-01-01 00:00:00', '计算机学院');
INSERT INTO `apply` VALUES ('534483ed8a25476f80e2877d41d868cb', '', '男', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2', '2020-02-09 00:00:00', '计算机学院');
INSERT INTO `apply` VALUES ('a9053000c11044bfb540075a73dcd377', '3', '男', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1', '2020-02-09 00:00:00', '计算机学院');
INSERT INTO `apply` VALUES ('e73acb5bdc9741f1818dce81d5c965a8', '2', '男', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2019-01-01 00:00:00', '计算机学院');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单url',
  `parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('5e395532602041728f5242765ed0e833', '教师信息', 'teachers', '-1');
INSERT INTO `menu` VALUES ('6e1f99d8c4b6419581d85cfea8f8dc79', '修改资料', 'info', '-1');
INSERT INTO `menu` VALUES ('9410f25ad60a40b4b42aadd84710c7b0', '培养审批', 'approval', '-1');
INSERT INTO `menu` VALUES ('a53b324e040e4491abbc1f2719ac0a33', '申请培养', 'apply', '-1');
INSERT INTO `menu` VALUES ('ae255e0c57674786ad17a184efa5fa07', '提交考核', 'access', '-1');
INSERT INTO `menu` VALUES ('b2c16a05697d4300a1773f07b1db0269', '新增老师', 'add', '-1');
INSERT INTO `menu` VALUES ('b301cd2bb9ef4a7ab9d8a263b641ba9f', '在培养老师', 'train', '-1');
INSERT INTO `menu` VALUES ('b441eac61e314860aed0f0a855066efd', '添加学习记录', 'study', '-1');
INSERT INTO `menu` VALUES ('db31e8bedf864b8bb142eb74c6ae0dd9', '综合评分', 'mark', '-1');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限简称(如删除-->DELETE)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('188534eb5c50441ea46e6d338219a6d7', '学校管理员');
INSERT INTO `role` VALUES ('608d103440ed4e4281e7f9b6332c80bf', '教师');
INSERT INTO `role` VALUES ('bdebe1db07504577bb8fe89c3c46f6ef', '学院管理员');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `menu_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('608d103440ed4e4281e7f9b6332c80bf', 'a53b324e040e4491abbc1f2719ac0a33');
INSERT INTO `role_menu` VALUES ('608d103440ed4e4281e7f9b6332c80bf', '6e1f99d8c4b6419581d85cfea8f8dc79');
INSERT INTO `role_menu` VALUES ('608d103440ed4e4281e7f9b6332c80bf', 'ae255e0c57674786ad17a184efa5fa07');
INSERT INTO `role_menu` VALUES ('608d103440ed4e4281e7f9b6332c80bf', 'b441eac61e314860aed0f0a855066efd');
INSERT INTO `role_menu` VALUES ('bdebe1db07504577bb8fe89c3c46f6ef', '5e395532602041728f5242765ed0e833');
INSERT INTO `role_menu` VALUES ('bdebe1db07504577bb8fe89c3c46f6ef', '6e1f99d8c4b6419581d85cfea8f8dc79');
INSERT INTO `role_menu` VALUES ('bdebe1db07504577bb8fe89c3c46f6ef', '9410f25ad60a40b4b42aadd84710c7b0');
INSERT INTO `role_menu` VALUES ('bdebe1db07504577bb8fe89c3c46f6ef', 'db31e8bedf864b8bb142eb74c6ae0dd9');
INSERT INTO `role_menu` VALUES ('188534eb5c50441ea46e6d338219a6d7', '5e395532602041728f5242765ed0e833');
INSERT INTO `role_menu` VALUES ('188534eb5c50441ea46e6d338219a6d7', '6e1f99d8c4b6419581d85cfea8f8dc79');
INSERT INTO `role_menu` VALUES ('188534eb5c50441ea46e6d338219a6d7', 'db31e8bedf864b8bb142eb74c6ae0dd9');
INSERT INTO `role_menu` VALUES ('bdebe1db07504577bb8fe89c3c46f6ef', 'b2c16a05697d4300a1773f07b1db0269');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '打分状态,1表示学院, 2表示学校,3表示结束',
  `score1` int(11) NULL DEFAULT NULL COMMENT '学院打分项',
  `score2` int(11) NULL DEFAULT NULL COMMENT '学校打分项',
  `score` int(11) NULL DEFAULT NULL COMMENT '最终成绩',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('d3465ff093854bb996e64d202114b62d', 'f2e1b4ceec7e48d4b3ec9eac2df2df53', '3', 999, 1, NULL);

-- ----------------------------
-- Table structure for study_activity
-- ----------------------------
DROP TABLE IF EXISTS `study_activity`;
CREATE TABLE `study_activity`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '培训时间',
  `place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地点',
  `people` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '培训人',
  `topic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主题',
  `organization` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织单位',
  `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '培训内容',
  `think` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '心得',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of study_activity
-- ----------------------------
INSERT INTO `study_activity` VALUES ('1bb5ee4e10cc4af5894527ea8e98189d', '2019-12-31', '2', '3', '关于中国近代史的探究', '5', '中国近代史是从第一次鸦片战争1840年到1949年南京国民党政权迁至台湾、 [1]  中华人民共和国成立的历史。历经清王朝晚期、中华民国临时政府时期、 [2]  北洋军阀时期和国民政府时期，是中国半殖民地半封建社会逐渐形成到瓦解的历史。', '7');
INSERT INTO `study_activity` VALUES ('2ed16fb72cfc4052b2f23747ce638064', '2020-12-12', '芝罘区', '苏浩', 'topic', '烟台大学', '123', '1233');
INSERT INTO `study_activity` VALUES ('cb5f1c8657424b928c6a0c9f0ccd3a33', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `study_activity` VALUES ('d2bf3c82d04c4a8a96ae82e99a44caf2', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `study_activity` VALUES ('e4d3c4fc7060444aa452cf8ce92c353a', '2020-1-1', '3', '4', '泰山石刻文化探究', '6', '泰山石刻涵括了整个中国的书法史，展示了中国书法艺术形变神异、一脉相承的发展脉络，书法艺术在泰山主要以石刻形式保存下来，其中大部为自然石刻，少量为碑碣。泰山石刻源远流长，分布广泛，数量众多，现存碑刻500余座、摩崖题刻800余处，碑刻题名之多冠中国名山之首，成为一处天然的书法展览，具有很高的艺术和史料价值。', '8');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'uuid',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `graduate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业院校',
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `score` int(11) NOT NULL COMMENT '分数',
  `apply_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请表id',
  `apartment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属学院',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2c70f7fc5dfb4ff6adf123b2db80e6a3', '201658503120', '123456', '校长大人', 27, '男', '烟台大学', '软件工程', '13573530115', '123456789@qq.com', 99, '', '计算机学院');
INSERT INTO `user` VALUES ('764b0e01ec774541a44e96620f13c559', '111', '111', '', NULL, '男', '', '', '', '', 0, NULL, '');
INSERT INTO `user` VALUES ('8d60a41776e04cdfb874f600847005a2', '201658503121', '123456', '院长', 27, '男', '烟台大学', '计算机学院', '13573530115', '123456789@qq.com', 99, NULL, '计算机学院');
INSERT INTO `user` VALUES ('ca8f706710064232a61a6c510d406dd4', '123456789', '123456', '测试人员', 11, '男', '山东大学', '软件工程', '17865569225', '1501719577@qq.com', 0, '534483ed8a25476f80e2877d41d868cb', '计算机学院');
INSERT INTO `user` VALUES ('f2e1b4ceec7e48d4b3ec9eac2df2df53', '201658503119', '123456', '张三老师', 27, '男', '烟台大学', '医学天才', '13573530115', '123456789@qq.com', 99, 'e73acb5bdc9741f1818dce81d5c965a8', '计算机学院');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('f2e1b4ceec7e48d4b3ec9eac2df2df53', '608d103440ed4e4281e7f9b6332c80bf');
INSERT INTO `user_role` VALUES ('2c70f7fc5dfb4ff6adf123b2db80e6a3', '188534eb5c50441ea46e6d338219a6d7');
INSERT INTO `user_role` VALUES ('8d60a41776e04cdfb874f600847005a2', 'bdebe1db07504577bb8fe89c3c46f6ef');
INSERT INTO `user_role` VALUES ('b863473814124c8aa784f6f0f306f706', '608d103440ed4e4281e7f9b6332c80bf');
INSERT INTO `user_role` VALUES ('ca8f706710064232a61a6c510d406dd4', '608d103440ed4e4281e7f9b6332c80bf');
INSERT INTO `user_role` VALUES ('1099bc0b083e4796a5179eea30fbedf3', '608d103440ed4e4281e7f9b6332c80bf');
INSERT INTO `user_role` VALUES ('6b59ed9d4e84453bbfbddcf3e7b9b92e', '608d103440ed4e4281e7f9b6332c80bf');
INSERT INTO `user_role` VALUES ('764b0e01ec774541a44e96620f13c559', '608d103440ed4e4281e7f9b6332c80bf');

-- ----------------------------
-- Table structure for user_study_activity
-- ----------------------------
DROP TABLE IF EXISTS `user_study_activity`;
CREATE TABLE `user_study_activity`  (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `study_activity_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_study_activity
-- ----------------------------
INSERT INTO `user_study_activity` VALUES ('ca8f706710064232a61a6c510d406dd4', 'd2bf3c82d04c4a8a96ae82e99a44caf2');
INSERT INTO `user_study_activity` VALUES ('f2e1b4ceec7e48d4b3ec9eac2df2df53', 'cb5f1c8657424b928c6a0c9f0ccd3a33');

SET FOREIGN_KEY_CHECKS = 1;
