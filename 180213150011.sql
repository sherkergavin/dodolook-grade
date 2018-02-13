/*
MySQL Backup
Source Server Version: 5.5.8
Source Database: gradedb
Date: 2018/2/13 15:00:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `t_auth_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_group`;
CREATE TABLE `t_auth_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `depart_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `post_id` int(11) DEFAULT NULL COMMENT '职位ID',
  `is_delete` int(1) DEFAULT '0' COMMENT '是否删',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_auth_login`
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_login`;
CREATE TABLE `t_auth_login` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `login_name` varchar(50) DEFAULT NULL COMMENT '登录名',
  `login_pwd` varchar(50) DEFAULT NULL COMMENT '密码',
  `encode_pwd` varchar(50) DEFAULT NULL COMMENT '转码密码',
  `salt` int(4) DEFAULT NULL COMMENT '权重',
  `is_delete` int(1) unsigned DEFAULT '0' COMMENT '是否删',
  `owner_id` int(11) DEFAULT NULL COMMENT '人员外键',
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_auth_login_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_login_group`;
CREATE TABLE `t_auth_login_group` (
  `logup_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `group_id` int(11) DEFAULT NULL COMMENT '组外键',
  `login_id` int(11) DEFAULT NULL COMMENT '登录名外键',
  `is_delete` int(1) DEFAULT '0' COMMENT '是否删',
  PRIMARY KEY (`logup_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_auth_path`
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_path`;
CREATE TABLE `t_auth_path` (
  `path_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_id` int(11) DEFAULT NULL COMMENT 'menu外键',
  `path` varchar(255) DEFAULT NULL COMMENT '请求路径',
  PRIMARY KEY (`path_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_daily_belate`
-- ----------------------------
DROP TABLE IF EXISTS `t_daily_belate`;
CREATE TABLE `t_daily_belate` (
  `belate_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `owner_name` varchar(50) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `is_delete` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `score_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`belate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_daily_complain`
-- ----------------------------
DROP TABLE IF EXISTS `t_daily_complain`;
CREATE TABLE `t_daily_complain` (
  `complain_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `owner_name` varchar(50) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `is_delete` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `score_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`complain_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_daily_incident`
-- ----------------------------
DROP TABLE IF EXISTS `t_daily_incident`;
CREATE TABLE `t_daily_incident` (
  `incident_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `owner_name` varchar(50) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `is_delete` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `score_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`incident_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_daily_leave`
-- ----------------------------
DROP TABLE IF EXISTS `t_daily_leave`;
CREATE TABLE `t_daily_leave` (
  `leave_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `owner_name` varchar(50) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `is_delete` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `score_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`leave_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_stand_department`
-- ----------------------------
DROP TABLE IF EXISTS `t_stand_department`;
CREATE TABLE `t_stand_department` (
  `depart_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `depart_name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `is_delete` int(1) DEFAULT '0' COMMENT '是否删',
  PRIMARY KEY (`depart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_stand_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_stand_menu`;
CREATE TABLE `t_stand_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级id',
  `text` varchar(50) DEFAULT NULL COMMENT '目录名称',
  `menu_lev` int(1) DEFAULT NULL COMMENT '等级  1:目录   2:叶子 ',
  `is_leaf` int(1) DEFAULT NULL COMMENT '叶子   0: 否  1: 是 ',
  `is_expanded` int(1) DEFAULT NULL COMMENT '展开  0:否   1:是',
  `href_target` varchar(1000) DEFAULT NULL COMMENT '链接',
  `lo` int(3) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_stand_owner`
-- ----------------------------
DROP TABLE IF EXISTS `t_stand_owner`;
CREATE TABLE `t_stand_owner` (
  `owner_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `owner_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `depart_name` varchar(50) DEFAULT NULL COMMENT '所属部门',
  `work_num` varchar(50) DEFAULT NULL COMMENT '工号',
  `is_delete` int(1) DEFAULT '0' COMMENT '是否删',
  PRIMARY KEY (`owner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_stand_position`
-- ----------------------------
DROP TABLE IF EXISTS `t_stand_position`;
CREATE TABLE `t_stand_position` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_name` varchar(50) DEFAULT NULL COMMENT '职位名称',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `is_delete` int(1) DEFAULT '0' COMMENT '是否删',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_stand_score`
-- ----------------------------
DROP TABLE IF EXISTS `t_stand_score`;
CREATE TABLE `t_stand_score` (
  `score_id` int(11) NOT NULL COMMENT '主键',
  `item_name` varchar(50) NOT NULL COMMENT '分数名',
  `item_score` int(3) NOT NULL COMMENT '分值',
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_task_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_task_info`;
CREATE TABLE `t_task_info` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `task_creator` varchar(50) DEFAULT NULL COMMENT '创建者',
  `owner_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `task_title` varchar(255) DEFAULT NULL COMMENT '任务标题',
  `task_content` varchar(2000) DEFAULT NULL COMMENT '任务内容',
  `task_start` date DEFAULT NULL COMMENT '任务开始时间',
  `task_cycle` int(100) unsigned zerofill DEFAULT NULL COMMENT '任务周期(天记)',
  `task_status` enum('cancel','finish','overdue','pause','working','waiting') DEFAULT NULL COMMENT '任务状态',
  `is_delete` int(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_task_item`
-- ----------------------------
DROP TABLE IF EXISTS `t_task_item`;
CREATE TABLE `t_task_item` (
  `item_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `task_id` int(11) DEFAULT NULL COMMENT '任务外键',
  `task_title` varchar(255) DEFAULT NULL COMMENT '任务标题',
  `owner_id` int(11) DEFAULT NULL,
  `owner_name` varchar(50) DEFAULT NULL,
  `task_order` varchar(1000) DEFAULT NULL COMMENT '任务单',
  `owner_status` enum('wait','accept','pause','deny','cancel','finish') DEFAULT NULL COMMENT '人员 状态',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `is_delete` int(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_task_score`
-- ----------------------------
DROP TABLE IF EXISTS `t_task_score`;
CREATE TABLE `t_task_score` (
  `taskowner_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `task_id` int(11) DEFAULT NULL COMMENT '任务外键',
  `owner_id` int(11) DEFAULT NULL COMMENT '人员外键',
  `task_order` varchar(1000) DEFAULT NULL COMMENT '任务摊派',
  `owner_status` enum('pause','deny','accept') DEFAULT NULL COMMENT '人员任务状态',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`taskowner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_auth_group` VALUES ('14','2018-02-12 14:30:20','14','16','0'), ('15','2018-02-12 14:30:35','14','17','0'), ('16','2018-02-12 14:38:14','14','18','0'), ('17','2018-02-12 14:38:39','14','19','0');
INSERT INTO `t_auth_login` VALUES ('6','gavin','1234','8ba8f48712b83bcbf2acc3f2921a15d4','568','0','39'), ('7','wlw','1234','12eabc3652ce52b3a1e09aef4772423f','274','0','40'), ('8','zl','1234','faa7bc920dc8f9fd87bf717a07f8a8ad','104','0','41'), ('9','ljt','1234','de4b2b4907d567211629a886ea580ac9','203','0','42'), ('10','wc','1234','6c94ddead70f03c367132472bc54236a','648','0','43'), ('11','lxp','1234','6adc598932ed8b9f7d9d189f3246c878','605','0','44'), ('12','lf','1234','c4ed247c9fc62127c8accc447433e96d','172','0','45'), ('13','bmy','1234','6fd606ec864f0b403b2ae743b12f36ec','581','0','46'), ('14','www','1234','4a7ebe7a08a1f161170892b4c73d0de3','879','1','47'), ('15','wwwww','1234','385d4aeef8dd62d700b92eebe99d8677','814','1','48'), ('16','bbbbb','1234','457f0b6fcb84d663e160e7c8e9e7093d','799','1','49'), ('17','44444','1234','1950a41e9edaca3a5da94b35c033ace4','700','1','50');
INSERT INTO `t_auth_login_group` VALUES ('13','2018-02-12 14:30:20','14','6','0'), ('14','2018-02-12 14:30:35','15','8','0'), ('15','2018-02-12 14:30:35','15','6','0'), ('16','2018-02-12 14:31:00','15','7','0'), ('17','2018-02-12 14:38:14','16','9','0'), ('18','2018-02-12 14:38:39','17','9','0'), ('19','2018-02-12 14:38:39','17','12','0'), ('20','2018-02-12 14:38:39','17','13','0'), ('21','2018-02-12 16:55:07','15','11','0'), ('26','2018-02-13 10:00:26','15','10','0');
INSERT INTO `t_auth_path` VALUES ('1','11',NULL);
INSERT INTO `t_stand_department` VALUES ('14','软件部','2018-02-11 10:57:52','0'), ('15','自控部','2018-02-12 10:32:53','0');
INSERT INTO `t_stand_menu` VALUES ('1',NULL,'日常','1','0','1',NULL,NULL), ('2','1','迟到','2','1','0',NULL,NULL), ('3','1','请假','2','1','0',NULL,NULL), ('4',NULL,'异常','1','0','1',NULL,NULL), ('5','4','投诉','2','1','0',NULL,NULL), ('6','4','事故','2','1','0',NULL,NULL), ('7',NULL,'需求','1','0','1',NULL,NULL), ('8','7','任务进度','2','1','0',NULL,NULL), ('9',NULL,'标准','1','0','1',NULL,NULL), ('10','9','考核评分','2','1','0',NULL,NULL), ('11','12','人员总览','2','1','0','gwj.view.owner.OwnerListView',NULL), ('12',NULL,'权限','1','0','1',NULL,NULL), ('13','12','人员职位','2','1','0','gwj.view.ownsition.OwnsitionGroupView',NULL);
INSERT INTO `t_stand_owner` VALUES ('39','2018-02-08 14:21:16','干为杰',NULL,'162','0'), ('40','2018-02-08 14:31:16','王璐伟',NULL,'163','0'), ('41','2018-02-08 14:32:16','朱雷',NULL,'164','0'), ('42','2018-02-08 14:33:16','李金涛',NULL,'165','0'), ('43','2018-02-08 15:34:14','王聪',NULL,'166','0'), ('44','2018-02-08 14:35:16','刘小品',NULL,'167','0'), ('45','2018-02-08 14:36:16','龙芳',NULL,'168','0'), ('46','2018-02-08 14:37:16','毕梦杨',NULL,'169','0');
INSERT INTO `t_stand_position` VALUES ('16','开发组组长','2018-02-11 10:58:56','0'), ('17','开发组组员','2018-02-11 10:58:56','0'), ('18','运维组组长','2018-02-11 10:58:56','0'), ('19','运维组组员','2018-02-11 10:58:56','0');
INSERT INTO `t_task_info` VALUES ('1','111','111','2018-01-30 10:19:20','2018-01-30 10:19:23','111','111',NULL,'0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111',NULL,NULL), ('2','222','222','2018-01-30 10:19:42','2018-01-30 16:54:29','222','2222',NULL,'0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002222',NULL,'1'), ('3','333','222','2018-01-30 10:23:29','2018-01-30 10:23:32','333','333',NULL,'0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000333',NULL,NULL), ('4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0'), ('5',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0'), ('6','2222','222','2018-01-23 10:28:23',NULL,'22','22','2018-01-30','0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000033',NULL,'0'), ('7','333','333','2018-01-30 10:49:19',NULL,'333','333','2018-01-30','0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000044','pause','0'), ('8','555','1111','2018-01-30 10:55:00',NULL,'5555','789789798','2018-01-30','0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000012','waiting','0'), ('9','555','1111','2018-01-30 10:55:00',NULL,'5555','789789798','2018-01-30','0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000012','waiting','0'), ('10','555','1111','2018-01-30 10:55:00',NULL,'5555','789789798','2018-01-30','0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000012','overdue','0'), ('11','555','1111','2018-01-30 10:55:00',NULL,'5555','789789798','2018-01-30','0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000012','overdue','0'), ('12','555','1111','2018-01-30 10:55:00',NULL,'5555','789789798','2018-01-30','0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000012','overdue','0');
