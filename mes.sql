/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.190
Source Server Version : 50726
Source Host           : 192.168.0.190:3306
Source Database       : mes

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2022-03-25 09:09:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for basic_craft
-- ----------------------------
DROP TABLE IF EXISTS `basic_craft`;
CREATE TABLE `basic_craft` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `craft_id` varchar(255) NOT NULL,
  `craft_code` varchar(255) DEFAULT NULL,
  `production_versions` varchar(255) DEFAULT NULL,
  `material_code` varchar(255) DEFAULT NULL,
  `material_name` varchar(255) DEFAULT NULL,
  `enable` tinyint(2) DEFAULT '1',
  `create_user` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_deleted` tinyint(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of basic_craft
-- ----------------------------
INSERT INTO `basic_craft` VALUES ('5', '19A9B3EC1635464895186D14B3CC4DBD', 'craftCode1', '生产版本1', 'material888', '物料描述1', '1', '超级管理员', '2022-03-22 10:34:27', '超级管理员', '2022-03-22 10:34:27', '1');
INSERT INTO `basic_craft` VALUES ('6', 'E7CC54FEFFC74432AD7FEF39A977CF00', 'craftCode2', '生产版本2', 'material999', '物料描述2', '1', '超级管理员', '2022-03-22 10:34:27', '超级管理员', '2022-03-22 10:34:27', '1');
INSERT INTO `basic_craft` VALUES ('7', '19A9B3EC1635464895186D14B3CC4DBD', 'craftCode1.0', '生产版本1.0', 'material888', '物料描述1.0', '1', '超级管理员', '2022-03-22 10:34:27', '超级管理员', '2022-03-22 14:12:54', '1');
INSERT INTO `basic_craft` VALUES ('8', '19A9B3EC1635464895186D14B3CC4DBD', 'craftCode1.1', '生产版本1.1', 'material888', '物料描述1.1', '1', '超级管理员', '2022-03-22 10:34:27', '超级管理员', '2022-03-16 14:14:44', '1');
INSERT INTO `basic_craft` VALUES ('9', 'E79B5CB07BEC4354910AEFCEFCD19EA8', 'craftCode1', '生产版本1', 'material8881', '物料修改修改修改', '1', '超级管理员', '2022-03-22 16:06:30', '超级管理员', '2022-03-22 16:06:30', '0');
INSERT INTO `basic_craft` VALUES ('10', '19A9B3EC1635464895186D14B3CC4DBD', 'craftCode1.1', '生产版本1.1', 'material8881', '物料修改修改修改', '1', '超级管理员', '2022-03-22 10:34:27', '超级管理员', '2022-03-22 16:07:49', '1');
INSERT INTO `basic_craft` VALUES ('11', '19A9B3EC1635464895186D14B3CC4DBD', 'craftCode1.2', '生产版本1.2', 'material888', '物料修改修改修改', '1', '超级管理员', '2022-03-22 10:34:27', '超级管理员', '2022-03-22 17:25:50', '1');
INSERT INTO `basic_craft` VALUES ('12', '19A9B3EC1635464895186D14B3CC4DBD', 'craftCode1.3', '生产版本1.3', 'material888', '物料修改修改修改', '1', '超级管理员', '2022-03-22 10:34:27', '超级管理员', '2022-03-22 17:28:17', '1');
INSERT INTO `basic_craft` VALUES ('13', '19A9B3EC1635464895186D14B3CC4DBD', 'craftCode1.4', '生产版本1.4', 'material888', '物料修改修改修改', '1', '超级管理员', '2022-03-22 10:34:27', '超级管理员', '2022-03-22 17:28:43', '0');
INSERT INTO `basic_craft` VALUES ('14', 'E7CC54FEFFC74432AD7FEF39A977CF00', 'craftCode2', '生产版本2', 'material6', null, '0', '超级管理员', '2022-03-22 10:34:27', '超级管理员', '2022-03-23 09:24:48', '1');
INSERT INTO `basic_craft` VALUES ('15', 'E7CC54FEFFC74432AD7FEF39A977CF00', 'craftCode2', '生产版本2', 'material6', null, '0', '超级管理员', '2022-03-22 10:34:27', '超级管理员', '2022-03-23 09:24:56', '1');
INSERT INTO `basic_craft` VALUES ('16', 'E7CC54FEFFC74432AD7FEF39A977CF00', 'craftCode2', '生产版本2', 'material6', '测试物料6', '1', '超级管理员', '2022-03-22 10:34:27', '超级管理员', '2022-03-23 09:27:17', '1');
INSERT INTO `basic_craft` VALUES ('17', 'E7CC54FEFFC74432AD7FEF39A977CF00', 'craftCode2', '生产版本2', 'material999', '测试添加999', '1', '超级管理员', '2022-03-22 10:34:27', '超级管理员', '2022-03-23 09:30:55', '0');
INSERT INTO `basic_craft` VALUES ('18', 'C04E4EC3ADC842DBB2835D6C745291BF', 'craftCodeTest', '生产版本测试', 'updatematerial1', '测试更新物料1', '1', '超级管理员', '2022-03-23 09:31:36', '超级管理员', '2022-03-23 09:31:36', '0');

-- ----------------------------
-- Table structure for basic_device
-- ----------------------------
DROP TABLE IF EXISTS `basic_device`;
CREATE TABLE `basic_device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `device_name` varchar(50) NOT NULL COMMENT '设备名称',
  `device_category` varchar(50) NOT NULL COMMENT '设备类别',
  `device_type` varchar(50) NOT NULL COMMENT '设备类型',
  `device_speed` int(11) NOT NULL COMMENT '设备速度',
  `enable` tinyint(1) NOT NULL COMMENT '启用标识 ( 1表示启用, 0表示未启用 )',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除 ( 0表示未删除, 1表示已删除 )',
  `create_user` varchar(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(20) NOT NULL COMMENT '修改人',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `UUID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='设备主数据表';

-- ----------------------------
-- Records of basic_device
-- ----------------------------
INSERT INTO `basic_device` VALUES ('13', 'device1', '设备1', '设备类别1', '设备类型1', '10', '1', '1', '超级管理员', '2022-03-18 17:06:54', '超级管理员', '2022-03-18 17:14:23', '13603ABB28F0417E8F699D431064DF7B');
INSERT INTO `basic_device` VALUES ('14', 'device2', '设备2', '设备类别2', '设备类型2', '11', '1', '0', '超级管理员', '2022-03-18 17:06:54', '超级管理员', '2022-03-18 17:16:24', '999FED64F42446E98D5E9A12E0DED1DF');
INSERT INTO `basic_device` VALUES ('15', 'deviceId123', '测试设备11', '测试更新设备类别1', '测试更新设备类型1', '88', '1', '1', '超级管理员', '2022-03-18 17:06:54', '超级管理员', '2022-03-18 17:14:23', '13603ABB28F0417E8F699D431064DF7B');
INSERT INTO `basic_device` VALUES ('16', 'deviceId12', '测试设备11', '测试更新设备类别1', '测试更新设备类型1', '88', '1', '1', '超级管理员', '2022-03-18 17:06:54', '超级管理员', '2022-03-18 17:14:23', '13603ABB28F0417E8F699D431064DF7B');
INSERT INTO `basic_device` VALUES ('17', 'deviceId12', '测试设备11', '测试更新设备类别1', '测试更新设备类型1', '88', '1', '1', '超级管理员', '2022-03-18 17:06:54', '超级管理员', '2022-03-24 09:59:03', '13603ABB28F0417E8F699D431064DF7B');
INSERT INTO `basic_device` VALUES ('18', 'd1', '设备1', '设备类别1', '设备类型1', '160', '1', '0', '超级管理员', '2022-03-24 09:51:19', '超级管理员', '2022-03-24 09:51:19', '4F1CA2DA540D4B03831D32222F78BB96');
INSERT INTO `basic_device` VALUES ('19', 'deviceId12', '测试设备11test', '测试更新设备类别1', '测试更新设备类型1', '88', '1', '1', '超级管理员', '2022-03-18 17:06:54', '超级管理员', '2022-03-24 10:00:48', '13603ABB28F0417E8F699D431064DF7B');
INSERT INTO `basic_device` VALUES ('20', 'deviceId12', '测试设备11test', '测试更新设备类别1', '测试更新设备类型1', '88', '1', '1', '超级管理员', '2022-03-18 17:06:54', '超级管理员', '2022-03-24 10:12:21', '13603ABB28F0417E8F699D431064DF7B');
INSERT INTO `basic_device` VALUES ('21', 'deviceId12', '测试设备11test', '测试更新设备类别1', '测试更新设备类型1', '88', '0', '1', '超级管理员', '2022-03-18 17:06:54', '超级管理员', '2022-03-24 10:12:26', '13603ABB28F0417E8F699D431064DF7B');
INSERT INTO `basic_device` VALUES ('22', 'deviceId12', '测试设备11test', '测试更新设备类别1', '测试更新设备类型1', '88', '1', '0', '超级管理员', '2022-03-18 17:06:54', '超级管理员', '2022-03-24 10:12:26', '13603ABB28F0417E8F699D431064DF7B');

-- ----------------------------
-- Table structure for basic_materials
-- ----------------------------
DROP TABLE IF EXISTS `basic_materials`;
CREATE TABLE `basic_materials` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物料编码',
  `material_code` varchar(20) NOT NULL COMMENT '物料编码',
  `material_name` varchar(20) NOT NULL COMMENT '物料名称',
  `material_type` varchar(50) NOT NULL COMMENT '物料类型',
  `material_series` varchar(50) NOT NULL COMMENT '物料系列',
  `unit` varchar(20) NOT NULL COMMENT '计量单位',
  `enable` tinyint(1) NOT NULL COMMENT '启用标识 ( 1表示启用, 0表示未启用 )',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除 ( 0表示未删除, 1表示已删除 )',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(50) NOT NULL COMMENT '最后修改人',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `material_id` varchar(50) DEFAULT NULL COMMENT '物料id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='物料主数据表';

-- ----------------------------
-- Records of basic_materials
-- ----------------------------
INSERT INTO `basic_materials` VALUES ('1', 'updatematerial1', '测试更新物料1', '测试更新物料类型1', '测试更新物料系列1', '测试更新计量单位1', '1', '1', '超级管理员', '2022-02-12 16:38:23', '超级管理员', '2022-02-15 15:42:12', '6FE81108802B4BEC82581ECE37004B20');
INSERT INTO `basic_materials` VALUES ('2', 'material2', '测试物料2', '测试物料类型1', '测试物料系列2', '测试计量单位2', '1', '1', '超级管理员', '2022-02-14 16:24:04', '超级管理员', '2022-02-15 15:42:12', '22326311E8224CDCBE91F8B16285D7D4');
INSERT INTO `basic_materials` VALUES ('3', 'material3', '测试物料3', '测试物料类型1', '测试物料系列3', '测试计量单位3', '1', '0', '超级管理员', '2022-02-14 16:24:15', '超级管理员', '2022-02-05 16:32:00', '97CA8BA6E51F4DB0A96555EE3A08FF76');
INSERT INTO `basic_materials` VALUES ('4', 'material4', '测试物料4', '测试物料类型2', '测试物料系列1', '测试计量单位4', '1', '0', '超级管理员', '2022-02-14 16:24:30', '超级管理员', '2022-02-14 16:32:24', '6917BA88C3F642D9AE6FB48750A49985');
INSERT INTO `basic_materials` VALUES ('5', 'material5', '测试物料5', '测试物料类型2', '测试物料系列1', '测试计量单位5', '1', '0', '超级管理员', '2022-02-14 16:24:35', '超级管理员', '2022-02-14 16:32:26', '2EBF9E0F683A4818BF23468AAEC8009D');
INSERT INTO `basic_materials` VALUES ('6', 'material6', '测试物料6', '测试物料类型2', '测试物料系列16', '测试计量单位6', '1', '1', '超级管理员', '2022-02-14 16:24:40', '超级管理员', '2022-03-18 15:55:28', '23ADDA02B51F42F9B5A51B8C9EB49DAC');
INSERT INTO `basic_materials` VALUES ('7', 'material7', '测试物料7', '测试物料类型12', '测试物料系列19', '测试计量单位7', '1', '0', '超级管理员', '2022-02-14 16:24:47', '超级管理员', '2022-02-14 16:32:33', 'FCF9FBF3CCF74BB8BC8959BF9D2ECFE8');
INSERT INTO `basic_materials` VALUES ('8', 'material8', '测试物料8', '测试物料类型12', '测试物料系列161', '测试计量单位8', '1', '0', '超级管理员', '2022-02-14 16:24:56', '超级管理员', '2022-02-14 16:32:36', '385C5C47D2D244A8B42B0BA5D3301D64');
INSERT INTO `basic_materials` VALUES ('9', 'material9', '测试物料9', '测试物料类型12', '测试物料系列162', '测试计量单位9', '1', '0', '超级管理员', '2022-02-14 16:25:01', '超级管理员', '2022-03-18 15:47:48', '50037C662B7D41F988A76654B5C52C75');
INSERT INTO `basic_materials` VALUES ('10', 'material10', '测试物料10', '测试物料类型11', '测试物料系列1', '测试计量单位10', '1', '0', '超级管理员', '2022-02-14 16:25:06', '超级管理员', '2022-03-18 15:47:48', '03A85AF16D6B46D79F602AF339EEA5C2');
INSERT INTO `basic_materials` VALUES ('11', 'material11', '测试物料11', '测试物料类型13', '测试物料系列12', '测试计量单位11', '1', '0', '超级管理员', '2022-02-14 16:25:10', '超级管理员', '2022-02-14 16:32:44', '1328844C876B4B7E9FB42AE2A0BCDE79');
INSERT INTO `basic_materials` VALUES ('12', 'material12', '测试物料12', '测试物料类型13', '测试物料系列11', '测试计量单位12', '1', '0', '超级管理员', '2022-02-14 16:25:15', '超级管理员1', '2022-02-14 16:38:52', '5BBB7E0CB86E494FA2EBF8D13FE4650C');
INSERT INTO `basic_materials` VALUES ('13', 'addMaterial1', '测试添加物料1', '测试添加物料类型1', '测试物料系列', '测试添加计量单位1', '1', '0', '超级管理员', '2022-02-15 15:24:42', '超级管理员', '2022-02-15 15:24:42', '98FDC0F928B04CF28E247F41D58BE22E');
INSERT INTO `basic_materials` VALUES ('14', 'addMaterial2', '测试添加物料2', '测试添加物料类型1', '测试物料系列', '测试添加计量单位1', '1', '1', '超级管理员', '2022-02-15 15:24:42', '超级管理员', '2022-02-19 13:25:51', '906A9A92E1CB48069D3D9913581D89F3');
INSERT INTO `basic_materials` VALUES ('15', 'updatematerial1', '测试更新物料1', '测试更新物料类型1', '测试更新物料系列1', '测试更新计量单位1', '1', '0', '超级管理员', '2022-02-15 15:24:42', '超级管理员', '2022-02-19 13:34:22', '906A9A92E1CB48069D3D9913581D89F3');
INSERT INTO `basic_materials` VALUES ('16', 'addMaterial2', '测试添加物料2', '测试添加物料类型1', '测试物料系列', '测试添加计量单位1', '1', '1', '超级管理员', '2022-03-14 15:26:42', '超级管理员', '2022-03-18 14:15:37', '57A133F1B2BC42C1969F342FD4A9429E');
INSERT INTO `basic_materials` VALUES ('17', 'materialCode123', '物料物料物料物料', '测试更新物料类型1', '测试更新物料系列1', '测试更新计量单位1', '1', '0', '超级管理员', '2022-03-14 15:26:42', '超级管理员', '2022-03-18 14:15:25', '57A133F1B2BC42C1969F342FD4A9429E');
INSERT INTO `basic_materials` VALUES ('18', 'material6', '测试物料6', '测试物料类型2', '0', '测试计量单位6', '1', '1', '超级管理员', '2022-02-14 16:24:40', '超级管理员', '2022-03-18 16:00:14', '23ADDA02B51F42F9B5A51B8C9EB49DAC');
INSERT INTO `basic_materials` VALUES ('19', 'material6', '测试物料6', '测试物料类型2', '0', '测试计量单位6修改', '1', '1', '超级管理员', '2022-02-14 16:24:40', '超级管理员', '2022-03-18 16:06:36', '23ADDA02B51F42F9B5A51B8C9EB49DAC');
INSERT INTO `basic_materials` VALUES ('20', 'material6', '测试物料6', '测试物料类型2', '0', '测试计量单位6修改', '1', '1', '超级管理员', '2022-02-14 16:24:40', '超级管理员', '2022-03-18 16:06:43', '23ADDA02B51F42F9B5A51B8C9EB49DAC');
INSERT INTO `basic_materials` VALUES ('21', 'material6', '测试物料6', '测试物料类型2', '0', '测试单位6修改', '1', '0', '超级管理员', '2022-02-14 16:24:40', '超级管理员', '2022-03-18 16:06:43', '23ADDA02B51F42F9B5A51B8C9EB49DAC');
INSERT INTO `basic_materials` VALUES ('22', 'material999', '测试添加999', '测试添加999类型', '测试添加999系列', '测试添加999单位', '1', '0', '超级管理员', '2022-03-18 16:07:43', '超级管理员', '2022-03-18 16:07:43', '9354CF9C8CE8438197CE9D8071BC8E6E');
INSERT INTO `basic_materials` VALUES ('23', '测试添加888', '测试添加888名称', '测试添加888类型', '测试添加888系列', '测试添加888单位', '1', '1', '超级管理员', '2022-03-18 16:08:52', '超级管理员', '2022-03-18 16:09:22', '6935D3C30F004FB9B8F86A5466D7B9F5');
INSERT INTO `basic_materials` VALUES ('24', 'material888', '测试添加888名称', '测试添加888类型', '0', '测试添加888单位', '1', '1', '超级管理员', '2022-03-18 16:08:52', '超级管理员', '2022-03-18 16:09:22', '6935D3C30F004FB9B8F86A5466D7B9F5');
INSERT INTO `basic_materials` VALUES ('25', 'material888', '测试添加888', '测试添加888类型', '0', '测试添加888单位', '1', '1', '超级管理员', '2022-03-18 16:08:52', '超级管理员', '2022-03-22 16:23:49', '6935D3C30F004FB9B8F86A5466D7B9F5');
INSERT INTO `basic_materials` VALUES ('27', 'material8881', '物料修改修改修改', '测试物料类型2', '0', '测试计量单位6修改', '1', '0', '超级管理员', '2022-03-18 16:08:52', '超级管理员', '2022-03-22 16:23:35', '6935D3C30F004FB9B8F86A5466D7B9F5');

-- ----------------------------
-- Table structure for basic_process
-- ----------------------------
DROP TABLE IF EXISTS `basic_process`;
CREATE TABLE `basic_process` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `process_code` varchar(255) DEFAULT NULL COMMENT '工序编码',
  `process_name` varchar(255) DEFAULT NULL COMMENT '工序名称',
  `create_user` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `enable` tinyint(1) DEFAULT '1',
  `is_deleted` tinyint(1) DEFAULT '0',
  `process_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of basic_process
-- ----------------------------
INSERT INTO `basic_process` VALUES ('7', 'process1', '工序1', '超级管理员', '2022-03-18 17:26:14', '超级管理员', '2022-03-18 17:26:14', '1', '0', 'E5D979E2848442FF98163E54A2C51606');
INSERT INTO `basic_process` VALUES ('8', 'process2', '工序2', '超级管理员', '2022-03-18 17:26:15', '超级管理员', '2022-03-18 17:26:15', '1', '1', '977B59162ABA4B7F8A13E56C51F1105B');
INSERT INTO `basic_process` VALUES ('13', 'process3', '工序3', '超级管理员', '2022-03-18 17:26:15', '超级管理员', '2022-03-19 08:51:14', '1', '1', '977B59162ABA4B7F8A13E56C51F1105B');
INSERT INTO `basic_process` VALUES ('14', 'process2', '工序2', '超级管理员', '2022-03-18 17:26:15', '超级管理员', '2022-03-21 09:05:32', '1', '1', '977B59162ABA4B7F8A13E56C51F1105B');
INSERT INTO `basic_process` VALUES ('15', 'process4', '工序3', '超级管理员', '2022-03-21 09:05:59', '超级管理员', '2022-03-21 09:05:59', '1', '1', '3D71C6B8FBA348A89C2206B12D6EC3F9');
INSERT INTO `basic_process` VALUES ('16', 'process4', '工序3', '超级管理员', '2022-03-21 09:05:59', '超级管理员', '2022-03-22 17:17:24', '1', '0', '3D71C6B8FBA348A89C2206B12D6EC3F9');
INSERT INTO `basic_process` VALUES ('17', 'process3', '工序', '超级管理员', '2022-03-18 17:26:15', '超级管理员', '2022-03-22 17:19:34', '1', '1', '977B59162ABA4B7F8A13E56C51F1105B');
INSERT INTO `basic_process` VALUES ('18', 'process3.0', '工序.0', '超级管理员', '2022-03-18 17:26:15', '超级管理员', '2022-03-22 17:21:15', '1', '0', '977B59162ABA4B7F8A13E56C51F1105B');

-- ----------------------------
-- Table structure for collect_bad_production
-- ----------------------------
DROP TABLE IF EXISTS `collect_bad_production`;
CREATE TABLE `collect_bad_production` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `controller_id` int(4) NOT NULL COMMENT '控制器编号',
  `collect_time` datetime(3) NOT NULL COMMENT '采集时间, 每3秒采集一次',
  `bad_type` varchar(20) NOT NULL COMMENT '不良类型',
  `qualified_products` int(11) NOT NULL COMMENT '合格品数',
  `defective_products` int(11) NOT NULL COMMENT '不良品数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20017 DEFAULT CHARSET=utf8 COMMENT='产品不良数据表 ( 源数据保留30天,30天前数据每月归档一次 )';

-- ----------------------------
-- Records of collect_bad_production
-- ----------------------------
INSERT INTO `collect_bad_production` VALUES ('20007', 'd0', '0', '2020-10-01 15:00:00.000', '0', '0', '0');
INSERT INTO `collect_bad_production` VALUES ('20008', 'd0', '0', '2020-10-01 15:00:00.000', '1', '10', '1');
INSERT INTO `collect_bad_production` VALUES ('20009', 'd0', '0', '2020-10-01 15:00:00.000', '2', '20', '2');
INSERT INTO `collect_bad_production` VALUES ('20010', 'd0', '0', '2020-10-01 15:00:00.000', '3', '30', '3');
INSERT INTO `collect_bad_production` VALUES ('20011', 'd0', '0', '2020-10-01 15:00:00.000', '4', '40', '4');
INSERT INTO `collect_bad_production` VALUES ('20012', 'd0', '1', '2020-10-01 15:00:00.000', '5', '50', '5');
INSERT INTO `collect_bad_production` VALUES ('20013', 'd0', '1', '2020-10-01 15:00:00.000', '6', '60', '6');
INSERT INTO `collect_bad_production` VALUES ('20014', 'd0', '1', '2020-10-01 15:00:00.000', '7', '70', '7');
INSERT INTO `collect_bad_production` VALUES ('20015', 'd0', '1', '2020-10-01 15:00:00.000', '8', '80', '8');
INSERT INTO `collect_bad_production` VALUES ('20016', 'd0', '1', '2020-10-01 15:00:00.000', '9', '90', '9');

-- ----------------------------
-- Table structure for collect_device_alarm
-- ----------------------------
DROP TABLE IF EXISTS `collect_device_alarm`;
CREATE TABLE `collect_device_alarm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `controller_id` int(11) NOT NULL COMMENT '控制器编号',
  `collect_time` datetime(3) NOT NULL COMMENT '采集时间, 每3秒采集一次',
  `plc_point` varchar(128) NOT NULL COMMENT 'PLC点位',
  `plc_point_state` int(11) NOT NULL COMMENT 'PLC点位状态',
  `alarm_description` varchar(50) NOT NULL COMMENT 'plc 报警描述',
  `alarm_type` varchar(50) NOT NULL COMMENT '报警类型',
  `start_time` datetime(3) NOT NULL COMMENT '开始时间',
  `end_time` datetime(3) DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=331 DEFAULT CHARSET=utf8 COMMENT='设备报警数据表 ( 源数据保留1年,1年前数据每月归档一次 )';

-- ----------------------------
-- Records of collect_device_alarm
-- ----------------------------
INSERT INTO `collect_device_alarm` VALUES ('321', 'd1', '1', '2020-10-01 15:20:00.000', 'plc', '1', 'alarm_desc_1_name', 'alarm_type_1', '2020-10-01 15:20:00.000', '2020-10-01 15:20:00.000');
INSERT INTO `collect_device_alarm` VALUES ('322', 'd1', '1', '2020-10-01 15:30:00.000', 'plc', '1', 'alarm_desc_1_name', 'alarm_type_1', '2020-10-01 15:20:00.000', '2020-10-01 15:30:00.000');
INSERT INTO `collect_device_alarm` VALUES ('323', 'd1', '1', '2020-10-01 15:40:00.000', 'plc', '0', 'alarm_desc_1_name', 'alarm_type_1', '2020-10-01 15:20:00.000', '2020-10-01 15:40:00.000');
INSERT INTO `collect_device_alarm` VALUES ('324', 'd1', '1', '2020-10-01 15:50:00.000', 'plc', '1', 'alarm_desc_1_name', 'alarm_type_1', '2020-10-01 15:50:00.000', '2020-10-01 15:50:00.000');
INSERT INTO `collect_device_alarm` VALUES ('325', 'd1', '1', '2020-10-01 17:55:00.000', 'plc', '1', 'alarm_desc_1_name', 'alarm_type_1', '2020-10-01 17:55:00.000', '2020-10-01 17:55:00.000');
INSERT INTO `collect_device_alarm` VALUES ('326', 'd1', '1', '2020-10-01 17:56:00.000', 'plc', '1', 'alarm_desc_1_name', 'alarm_type_1', '2020-10-01 17:55:00.000', '2020-10-01 17:56:00.000');
INSERT INTO `collect_device_alarm` VALUES ('327', 'd1', '1', '2020-10-01 17:57:00.000', 'plc', '1', 'alarm_desc_1_name', 'alarm_type_1', '2020-10-01 17:55:00.000', '2020-10-01 17:57:00.000');
INSERT INTO `collect_device_alarm` VALUES ('328', 'd1', '1', '2020-10-01 18:10:00.000', 'plc', '1', 'alarm_desc_1_name', 'alarm_type_1', '2020-10-01 17:55:00.000', '2020-10-01 17:57:00.000');
INSERT INTO `collect_device_alarm` VALUES ('330', 'd1', '1', '2022-03-24 13:41:09.000', 'plc', '1', 'alarm_desc_1_name', 'alarm_type_1', '2022-03-23 13:41:23.000', null);

-- ----------------------------
-- Table structure for collect_device_energy
-- ----------------------------
DROP TABLE IF EXISTS `collect_device_energy`;
CREATE TABLE `collect_device_energy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `controller_id` int(11) NOT NULL COMMENT '控制器编号',
  `collect_time` datetime(3) NOT NULL COMMENT '采集时间',
  `ep` float(15,3) NOT NULL COMMENT '能耗',
  `i` float(15,3) NOT NULL COMMENT '电流',
  `u` float(15,3) NOT NULL COMMENT '电压',
  `lc` float(15,3) NOT NULL COMMENT '漏电流',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='设备能耗数据表 ( 源数据保留1年,1年前数据每月归档一次 )';

-- ----------------------------
-- Records of collect_device_energy
-- ----------------------------
INSERT INTO `collect_device_energy` VALUES ('2', 'd1', '1', '2020-10-01 15:00:00.002', '1.000', '1.000', '1.000', '1.000');
INSERT INTO `collect_device_energy` VALUES ('3', 'd1', '1', '2020-10-01 15:00:00.003', '2.000', '2.000', '2.000', '2.000');
INSERT INTO `collect_device_energy` VALUES ('4', 'd1', '1', '2020-10-01 15:00:00.004', '3.000', '3.000', '3.000', '3.000');
INSERT INTO `collect_device_energy` VALUES ('5', 'd1', '1', '2020-10-01 15:00:00.005', '4.000', '4.000', '4.000', '4.000');
INSERT INTO `collect_device_energy` VALUES ('6', 'd1', '1', '2020-10-01 15:00:00.006', '5.000', '5.000', '5.000', '5.000');
INSERT INTO `collect_device_energy` VALUES ('7', 'd1', '1', '2020-10-01 15:00:00.007', '6.000', '6.000', '6.000', '6.000');
INSERT INTO `collect_device_energy` VALUES ('8', 'd1', '1', '2020-10-01 15:00:00.008', '7.000', '7.000', '7.000', '7.000');
INSERT INTO `collect_device_energy` VALUES ('9', 'd1', '1', '2020-10-01 15:00:00.009', '8.000', '8.000', '8.000', '8.000');
INSERT INTO `collect_device_energy` VALUES ('10', 'd1', '1', '2020-10-01 15:00:00.010', '9.000', '9.000', '9.000', '9.000');
INSERT INTO `collect_device_energy` VALUES ('11', 'd1', '1', '2020-10-01 15:00:00.011', '10.000', '10.000', '10.000', '10.000');
INSERT INTO `collect_device_energy` VALUES ('12', 'd1', '1', '2020-10-01 15:00:00.012', '11.000', '11.000', '11.000', '11.000');
INSERT INTO `collect_device_energy` VALUES ('13', 'd1', '1', '2020-10-01 15:00:00.013', '12.000', '12.000', '12.000', '12.000');
INSERT INTO `collect_device_energy` VALUES ('14', 'd1', '1', '2020-10-01 15:00:00.014', '13.000', '13.000', '13.000', '13.000');
INSERT INTO `collect_device_energy` VALUES ('15', 'd1', '1', '2020-10-01 15:00:00.015', '14.000', '14.000', '14.000', '14.000');
INSERT INTO `collect_device_energy` VALUES ('16', 'd1', '1', '2020-10-01 15:00:00.016', '15.000', '15.000', '15.000', '15.000');
INSERT INTO `collect_device_energy` VALUES ('17', 'd1', '1', '2020-10-01 15:00:00.017', '16.000', '16.000', '16.000', '16.000');
INSERT INTO `collect_device_energy` VALUES ('18', 'd1', '1', '2020-10-01 15:00:00.018', '17.000', '17.000', '17.000', '17.000');
INSERT INTO `collect_device_energy` VALUES ('19', 'd1', '1', '2020-10-01 15:00:00.019', '18.000', '18.000', '18.000', '18.000');
INSERT INTO `collect_device_energy` VALUES ('20', 'd1', '1', '2020-10-01 15:00:00.020', '19.000', '19.000', '19.000', '19.000');
INSERT INTO `collect_device_energy` VALUES ('21', 'd1', '1', '2020-10-01 15:00:00.021', '20.000', '20.000', '20.000', '20.000');

-- ----------------------------
-- Table structure for collect_device_parameter
-- ----------------------------
DROP TABLE IF EXISTS `collect_device_parameter`;
CREATE TABLE `collect_device_parameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `controller_id` int(11) NOT NULL COMMENT '控制器编号',
  `collect_time` datetime(3) NOT NULL COMMENT '采集时间, 每3秒采集一次',
  `parameter_code` varchar(20) NOT NULL COMMENT '参数编码',
  `parameter_name` varchar(20) NOT NULL COMMENT '参数名称, 预压时间、预热时间、预热电流、缓升间隔、缓升、焊接时间、焊接电流、缓降间隔、缓降、回火时间、回火电流、维持时间、休止时间、增压延时、增压时间',
  `parameter_value` varchar(20) NOT NULL COMMENT '参数值',
  `value_data_type` int(11) NOT NULL COMMENT '值数据类型',
  `parameter_unit` int(11) NOT NULL COMMENT '参数单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='设备参数数据表 ( 源数据保留30天,每月清理一次 )';

-- ----------------------------
-- Records of collect_device_parameter
-- ----------------------------
INSERT INTO `collect_device_parameter` VALUES ('1', 'd1', '1', '2020-10-01 15:00:00.002', 'U', '默认参数名称', '1', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('2', 'd1', '1', '2020-10-01 15:00:00.002', 'I', '默认参数名称', '1', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('3', 'd1', '1', '2020-10-01 15:00:00.002', 'T', '默认参数名称', '1', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('4', 'd1', '1', '2020-10-01 15:00:00.003', 'U', '默认参数名称', '2', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('5', 'd1', '1', '2020-10-01 15:00:00.003', 'I', '默认参数名称', '2', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('6', 'd1', '1', '2020-10-01 15:00:00.003', 'T', '默认参数名称', '2', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('7', 'd1', '1', '2020-10-01 15:00:00.004', 'U', '默认参数名称', '3', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('8', 'd1', '1', '2020-10-01 15:00:00.004', 'I', '默认参数名称', '3', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('9', 'd1', '1', '2020-10-01 15:00:00.004', 'T', '默认参数名称', '3', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('10', 'd1', '1', '2020-10-01 15:00:00.005', 'U', '默认参数名称', '4', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('11', 'd1', '1', '2020-10-01 15:00:00.005', 'I', '默认参数名称', '4', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('12', 'd1', '1', '2020-10-01 15:00:00.005', 'T', '默认参数名称', '4', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('13', 'd1', '1', '2020-10-01 15:00:00.006', 'U', '默认参数名称', '5', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('14', 'd1', '1', '2020-10-01 15:00:00.006', 'I', '默认参数名称', '5', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('15', 'd1', '1', '2020-10-01 15:00:00.006', 'T', '默认参数名称', '5', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('16', 'd1', '1', '2020-10-01 15:00:00.007', 'U', '默认参数名称', '6', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('17', 'd1', '1', '2020-10-01 15:00:00.007', 'I', '默认参数名称', '6', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('18', 'd1', '1', '2020-10-01 15:00:00.007', 'T', '默认参数名称', '6', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('19', 'd1', '1', '2020-10-01 15:00:00.008', 'U', '默认参数名称', '7', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('20', 'd1', '1', '2020-10-01 15:00:00.008', 'I', '默认参数名称', '7', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('21', 'd1', '1', '2020-10-01 15:00:00.008', 'T', '默认参数名称', '7', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('22', 'd1', '1', '2020-10-01 15:00:00.009', 'U', '默认参数名称', '8', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('23', 'd1', '1', '2020-10-01 15:00:00.009', 'I', '默认参数名称', '8', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('24', 'd1', '1', '2020-10-01 15:00:00.009', 'T', '默认参数名称', '8', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('25', 'd1', '1', '2020-10-01 15:00:00.010', 'U', '默认参数名称', '9', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('26', 'd1', '1', '2020-10-01 15:00:00.010', 'I', '默认参数名称', '9', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('27', 'd1', '1', '2020-10-01 15:00:00.010', 'T', '默认参数名称', '9', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('28', 'd1', '1', '2020-10-01 15:00:00.011', 'U', '默认参数名称', '10', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('29', 'd1', '1', '2020-10-01 15:00:00.011', 'I', '默认参数名称', '10', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('30', 'd1', '1', '2020-10-01 15:00:00.011', 'T', '默认参数名称', '10', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('31', 'd1', '1', '2020-10-01 15:00:00.012', 'U', '默认参数名称', '11', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('32', 'd1', '1', '2020-10-01 15:00:00.012', 'I', '默认参数名称', '11', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('33', 'd1', '1', '2020-10-01 15:00:00.012', 'T', '默认参数名称', '11', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('34', 'd1', '1', '2020-10-01 15:00:00.013', 'U', '默认参数名称', '12', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('35', 'd1', '1', '2020-10-01 15:00:00.013', 'I', '默认参数名称', '12', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('36', 'd1', '1', '2020-10-01 15:00:00.013', 'T', '默认参数名称', '12', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('37', 'd1', '1', '2020-10-01 15:00:00.014', 'U', '默认参数名称', '13', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('38', 'd1', '1', '2020-10-01 15:00:00.014', 'I', '默认参数名称', '13', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('39', 'd1', '1', '2020-10-01 15:00:00.014', 'T', '默认参数名称', '13', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('40', 'd1', '1', '2020-10-01 15:00:00.015', 'U', '默认参数名称', '14', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('41', 'd1', '1', '2020-10-01 15:00:00.015', 'I', '默认参数名称', '14', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('42', 'd1', '1', '2020-10-01 15:00:00.015', 'T', '默认参数名称', '14', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('43', 'd1', '1', '2020-10-01 15:00:00.016', 'U', '默认参数名称', '15', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('44', 'd1', '1', '2020-10-01 15:00:00.016', 'I', '默认参数名称', '15', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('45', 'd1', '1', '2020-10-01 15:00:00.016', 'T', '默认参数名称', '15', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('46', 'd1', '1', '2020-10-01 15:00:00.017', 'U', '默认参数名称', '16', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('47', 'd1', '1', '2020-10-01 15:00:00.017', 'I', '默认参数名称', '16', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('48', 'd1', '1', '2020-10-01 15:00:00.017', 'T', '默认参数名称', '16', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('49', 'd1', '1', '2020-10-01 15:00:00.018', 'U', '默认参数名称', '17', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('50', 'd1', '1', '2020-10-01 15:00:00.018', 'I', '默认参数名称', '17', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('51', 'd1', '1', '2020-10-01 15:00:00.018', 'T', '默认参数名称', '17', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('52', 'd1', '1', '2020-10-01 15:00:00.019', 'U', '默认参数名称', '18', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('53', 'd1', '1', '2020-10-01 15:00:00.019', 'I', '默认参数名称', '18', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('54', 'd1', '1', '2020-10-01 15:00:00.019', 'T', '默认参数名称', '18', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('55', 'd1', '1', '2020-10-01 15:00:00.020', 'U', '默认参数名称', '19', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('56', 'd1', '1', '2020-10-01 15:00:00.020', 'I', '默认参数名称', '19', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('57', 'd1', '1', '2020-10-01 15:00:00.020', 'T', '默认参数名称', '19', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('58', 'd1', '1', '2020-10-01 15:00:00.021', 'U', '默认参数名称', '20', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('59', 'd1', '1', '2020-10-01 15:00:00.021', 'I', '默认参数名称', '20', '0', '0');
INSERT INTO `collect_device_parameter` VALUES ('60', 'd1', '1', '2020-10-01 15:00:00.021', 'T', '默认参数名称', '20', '0', '0');

-- ----------------------------
-- Table structure for collect_device_production
-- ----------------------------
DROP TABLE IF EXISTS `collect_device_production`;
CREATE TABLE `collect_device_production` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `controller_id` int(11) NOT NULL COMMENT '控制器编号',
  `collect_time` datetime(3) NOT NULL COMMENT '采集时间, 每3秒采集一次',
  `state` varchar(20) NOT NULL COMMENT '设备状态, [ 运行, 暂停, 待机, 离线 ]',
  `startup_time` float(15,3) DEFAULT NULL COMMENT '开机时间',
  `running_time` float(15,3) DEFAULT NULL COMMENT '运行时间',
  `down_time` float(15,3) DEFAULT NULL COMMENT '停机时间',
  `scheduled_down_time` float(15,3) DEFAULT NULL COMMENT '计划停机时间',
  `OEE` float(15,3) NOT NULL COMMENT '设备综合效率 ( 设备实际的生产能力相对于理论产能的比率 )',
  `last_reset_time` datetime(3) DEFAULT NULL COMMENT '上次清零时间',
  `qualified_products` int(11) NOT NULL COMMENT '合格品数',
  `defective_products` int(11) NOT NULL COMMENT '不良品数',
  `qualified_rate` float(15,3) NOT NULL COMMENT '合格率',
  `actual_speed` int(11) NOT NULL COMMENT '实际速度',
  `theory_speed` int(11) NOT NULL COMMENT '理论速度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='设备生产数据表 ( 源数据保留30天,30天前数据每月归档一次 )';

-- ----------------------------
-- Records of collect_device_production
-- ----------------------------
INSERT INTO `collect_device_production` VALUES ('1', 'd1', '1', '2020-10-01 15:00:00.002', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '10', '1', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('2', 'd1', '1', '2020-10-01 15:00:00.003', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '20', '2', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('3', 'd1', '1', '2020-10-01 15:00:00.004', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '30', '3', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('4', 'd1', '1', '2020-10-01 15:00:00.005', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '40', '4', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('5', 'd1', '1', '2020-10-01 15:00:00.006', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '50', '5', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('6', 'd1', '1', '2020-10-01 15:00:00.007', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '60', '6', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('7', 'd1', '1', '2020-10-01 15:00:00.008', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '70', '7', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('8', 'd1', '1', '2020-10-01 15:00:00.009', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '80', '8', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('9', 'd1', '1', '2020-10-01 15:00:00.010', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '90', '9', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('10', 'd1', '1', '2020-10-01 15:00:00.011', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '100', '10', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('11', 'd1', '1', '2020-10-01 15:00:00.012', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '110', '11', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('12', 'd1', '1', '2020-10-01 15:00:00.013', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '120', '12', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('13', 'd1', '1', '2020-10-01 15:00:00.014', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '130', '13', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('14', 'd1', '1', '2020-10-01 15:00:00.015', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '140', '14', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('15', 'd1', '1', '2020-10-01 15:00:00.016', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '150', '15', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('16', 'd1', '1', '2020-10-01 15:00:00.017', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '160', '16', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('17', 'd1', '1', '2020-10-01 15:00:00.018', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '170', '17', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('18', 'd1', '1', '2020-10-01 15:00:00.019', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '180', '18', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('19', 'd1', '1', '2020-10-01 15:00:00.020', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '190', '19', '0.909', '0', '0');
INSERT INTO `collect_device_production` VALUES ('20', 'd1', '1', '2020-10-01 15:00:00.021', '0', '0.100', '0.200', '0.300', '0.400', '0.000', '2020-10-01 15:00:00.001', '200', '20', '0.909', '0', '0');

-- ----------------------------
-- Table structure for collect_realtime_current
-- ----------------------------
DROP TABLE IF EXISTS `collect_realtime_current`;
CREATE TABLE `collect_realtime_current` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `controller_id` int(11) NOT NULL COMMENT '控制器编号',
  `collect_time` datetime NOT NULL COMMENT '采集时间, 每3秒采集一次',
  `i` float(15,3) NOT NULL COMMENT '电流',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='实时电流数据表 ( 源数据保留1年,1年前数据每月归档一次 )';

-- ----------------------------
-- Records of collect_realtime_current
-- ----------------------------
INSERT INTO `collect_realtime_current` VALUES ('2', 'd0', '0', '2020-10-01 15:00:00', '0.000');
INSERT INTO `collect_realtime_current` VALUES ('3', 'd0', '0', '2020-10-01 15:00:00', '1.100');
INSERT INTO `collect_realtime_current` VALUES ('4', 'd0', '0', '2020-10-01 15:00:00', '2.200');
INSERT INTO `collect_realtime_current` VALUES ('5', 'd0', '0', '2020-10-01 15:00:00', '3.300');
INSERT INTO `collect_realtime_current` VALUES ('6', 'd0', '0', '2020-10-01 15:00:00', '4.400');
INSERT INTO `collect_realtime_current` VALUES ('7', 'd0', '1', '2020-10-01 15:00:00', '5.500');
INSERT INTO `collect_realtime_current` VALUES ('8', 'd0', '1', '2020-10-01 15:00:00', '6.600');
INSERT INTO `collect_realtime_current` VALUES ('9', 'd0', '1', '2020-10-01 15:00:00', '7.700');
INSERT INTO `collect_realtime_current` VALUES ('10', 'd0', '1', '2020-10-01 15:00:00', '8.800');
INSERT INTO `collect_realtime_current` VALUES ('11', 'd0', '1', '2020-10-01 15:00:00', '9.900');

-- ----------------------------
-- Table structure for craft_process
-- ----------------------------
DROP TABLE IF EXISTS `craft_process`;
CREATE TABLE `craft_process` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `craft_code` varchar(255) DEFAULT NULL,
  `process_code` varchar(255) DEFAULT NULL,
  `order_num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of craft_process
-- ----------------------------
INSERT INTO `craft_process` VALUES ('15', 'craftCode1.1', 'process3', '1');
INSERT INTO `craft_process` VALUES ('112', 'craftCode1.4', 'process4', '1');
INSERT INTO `craft_process` VALUES ('113', 'craftCode1.4', 'process3.0', '2');
INSERT INTO `craft_process` VALUES ('114', 'craftCode1.4', 'process1', '3');

-- ----------------------------
-- Table structure for param_set
-- ----------------------------
DROP TABLE IF EXISTS `param_set`;
CREATE TABLE `param_set` (
  `code` varchar(255) NOT NULL COMMENT '逻辑参数码',
  `param_name` varchar(255) NOT NULL COMMENT '参数说明',
  `param_value` varchar(255) DEFAULT '' COMMENT '参数值',
  `param_min` varchar(255) DEFAULT '' COMMENT '应用标识',
  `param_max` varchar(255) DEFAULT '' COMMENT '应用标识',
  `param_type` int(2) DEFAULT NULL COMMENT '前端使用',
  `param_desc` varchar(255) DEFAULT '' COMMENT '额外描述',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of param_set
-- ----------------------------
INSERT INTO `param_set` VALUES ('ALARM_MAX_INTERVAL', '报警数据最大时间间隔', '60', '0', '60', '1', 'int');
INSERT INTO `param_set` VALUES ('CAPACITY_FEATURE_IS_WARN', '产能特征预警应用标识', '1', '', '', '1', '1或0, 1表示true, 0表示false');
INSERT INTO `param_set` VALUES ('CAPACITY_FEATURE_WARN_CONTINUOUS_TIMES', '产能特征预警连续次数', '5', '1', '10', '1', 'int');
INSERT INTO `param_set` VALUES ('CAPACITY_SINGLE_IS_WARN', '产能单次预警应用标识', '1', '', '', '1', '1或0, 1表示true, 0表示false');
INSERT INTO `param_set` VALUES ('CAPACITY_SINGLE_WARN_LOWER_LIMIT', '产能单次预警下限', '0.8', '0', '1', '1', 'double');
INSERT INTO `param_set` VALUES ('CAPACITY_TREND_IS_WARN', '产能趋势预警应用标识', '1', '', '', '1', '1或0, 1表示true, 0表示false');
INSERT INTO `param_set` VALUES ('CAPACITY_TREND_WARN_CONTINUOUS_TIMES', '产能趋势预警连续次数', '3', '1', '10', '1', 'int');
INSERT INTO `param_set` VALUES ('DEFECTIVE_FEATURE_WARN_CONTINUOUS_TIMES', '不良率特征预警连续次数', '3', '1', '10', '1', 'int');
INSERT INTO `param_set` VALUES ('DEFECTIVE_FEATURE_WARN_IS_WARN', '不良率特征预警应用标识', '1', '', '', '1', '1或0, 1表示true, 0表示false');
INSERT INTO `param_set` VALUES ('DEFECTIVE_FEATURE_WARN_UPPER_LIMIT', '不良率特征预警上限', '0.015', '0', '0.1', '1', 'double');
INSERT INTO `param_set` VALUES ('DEFECTIVE_SINGLE_IS_WARN', '不良率单次预警应用标识', '1', '', '', '1', '1或0, 1表示true, 0表示false');
INSERT INTO `param_set` VALUES ('DEFECTIVE_SINGLE_WARN_UPPER_LIMIT', '不良率单次预警上限', '0.02', '0', '0.1', '1', 'double');
INSERT INTO `param_set` VALUES ('DEFECTIVE_TREND_WARN_CONTINUOUS_TIMES', '不良率趋势预警连续次数', '3', '1', '10', '1', 'int');
INSERT INTO `param_set` VALUES ('DEFECTIVE_TREND_WARN_IS_WARN', '不良率趋势预警应用标识', '1', '', '', '1', '1或0, 1表示true, 0表示false');
INSERT INTO `param_set` VALUES ('DEFECTIVE_TREND_WARN_UPPER_LIMIT', '不良率趋势预警上限', '0.01', '0', '0.1', '1', 'double');
INSERT INTO `param_set` VALUES ('MONITORING_PERIOD', '监控时间段', '0;1;2;3;4;5;6;7;8;9;10;11;12;13;14;15;16;17;18;19;20;21;22;23', '', '', '1', '用 ; 分割, 从 0 到 23');
INSERT INTO `param_set` VALUES ('PLAN_MONITORING_INTERVAL', '计划监控时间间隔', '30', '10', '60', '1', 'int');
INSERT INTO `param_set` VALUES ('PLAN_REMAINING_TIME_IS_WARN', '计划达成剩余时间预警应用标识', '1', '', '', '1', '1或0, 1表示true, 0表示false');
INSERT INTO `param_set` VALUES ('PLAN_REMAINING_TIME_UPPER_LIMIT', '计划达成预警剩余时间', '30', '0', '720', '1', 'int');
INSERT INTO `param_set` VALUES ('PLAN_SINGLE_IS_WARN', '计划达成单次预警应用标识', '1', '', '', '1', '1或0, 1表示true, 0表示false');
INSERT INTO `param_set` VALUES ('PLAN_SINGLE_WARN_LOWER_LIMIT', '计划达成单次预警下限', '0.95', '1', '1', '1', 'double');
INSERT INTO `param_set` VALUES ('PLAN_TREND_IS_WARN', '计划达成趋势预警应用标识', '1', '', '', '1', '1或0, 1表示true, 0表示false');
INSERT INTO `param_set` VALUES ('PLAN_TREND_WARN_CONTINUOUS_TIMES', '计划达成预警连续次数', '3', '1', '10', '1', 'int');
INSERT INTO `param_set` VALUES ('QUALITY_FEATURE_IS_WARN', '质控点特征预警应用标识', '1', '', '', '1', '1或0, 1表示true, 0表示false');
INSERT INTO `param_set` VALUES ('QUALITY_FEATURE_WARN_CONTINUOUS_TIMES', '质控点特征预警连续次数', '9', '5', '15', '1', 'int');
INSERT INTO `param_set` VALUES ('QUALITY_MONITORING_INTERVAL', '质量监控时间间隔', '5', '5', '30', '1', 'int');
INSERT INTO `param_set` VALUES ('QUALITY_SINGLE_IS_WARN', '质控点单次预警应用标识', '1', '', '', '1', '1或0, 1表示true, 0表示false');
INSERT INTO `param_set` VALUES ('QUALITY_SINGLE_WARN_LOWER_LIMIT', '质控点单次预警下限', '1', '', '', '1', '默认值 μ-3σ');
INSERT INTO `param_set` VALUES ('QUALITY_SINGLE_WARN_UPPER_LIMIT', '质控点单次预警上限', '5', '', '', '1', '默认值 μ+3σ');
INSERT INTO `param_set` VALUES ('QUALITY_TREND_IS_WARN', '质控点趋势预警应用标识', '1', '', '', '1', '1或0, 1表示true, 0表示false');
INSERT INTO `param_set` VALUES ('QUALITY_TREND_WARN_CONTINUOUS_TIMES', '质控点趋势预警连续次数', '6', '3', '10', '1', 'int');
INSERT INTO `param_set` VALUES ('WORKING_HOURS', '单日工作时长', '24', '0', '24', '1', 'double');

-- ----------------------------
-- Table structure for production_programme
-- ----------------------------
DROP TABLE IF EXISTS `production_programme`;
CREATE TABLE `production_programme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `device_name` varchar(20) NOT NULL COMMENT '设备名称',
  `process_code` varchar(20) NOT NULL COMMENT '工序编码',
  `process_name` varchar(20) NOT NULL COMMENT '工序名称',
  `material_code` varchar(20) NOT NULL COMMENT '物料编码',
  `material_name` varchar(20) NOT NULL COMMENT '物料名称',
  `plan_capacity` int(11) NOT NULL COMMENT '计划产能',
  `enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '启用标识 ( 1表示启用, 0表示未启用 )',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除 ( 0表示未删除, 1表示已删除 )',
  `update_user` varchar(20) NOT NULL COMMENT '最后修改人',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `production_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='生产规划表';

-- ----------------------------
-- Records of production_programme
-- ----------------------------
INSERT INTO `production_programme` VALUES ('31', 'updateDevice3', '测试更新设备3', 'p1', 'pl', 'addMaterial2', '测试添加物料2', '10', '1', '1', '超级管理员', '2022-03-18 13:55:11', 'B7F4D89B67BF4D4E9B080D5142CD65FE');
INSERT INTO `production_programme` VALUES ('32', 'addDevice12343', '测试添加设备3', 'p1', 'pl', 'addMaterial2', '测试添加物料2', '15', '1', '1', '超级管理员', '2022-03-18 14:12:20', 'E3D7C555FE294D15B311F596AFE77129');
INSERT INTO `production_programme` VALUES ('34', 'updateDevice3', '测试更新设备3', 'p1', 'pl', 'addMaterial2', '测试添加物料2', '44', '1', '1', '超级管理员', '2022-03-18 14:12:20', 'E3D7C555FE294D15B311F596AFE77129');
INSERT INTO `production_programme` VALUES ('35', 'updateDevice3', '测试更新设备3', 'p1', 'pl', 'addMaterial2', '测试添加物料2', '44', '1', '1', '超级管理员', '2022-03-18 14:12:20', 'E3D7C555FE294D15B311F596AFE77129');
INSERT INTO `production_programme` VALUES ('36', 'updateDevice3', '测试更新设备3', 'p1', 'pl', 'addMaterial2', '测试添加物料2', '44', '1', '1', '超级管理员', '2022-03-18 14:12:20', 'E3D7C555FE294D15B311F596AFE77129');
INSERT INTO `production_programme` VALUES ('37', 'deviceupdate1321321', '设备测试设备测试设备11', 'p1', 'pl', 'materialCode123', '物料物料物料物料', '44', '1', '1', '超级管理员', '2022-03-18 15:03:46', 'E3D7C555FE294D15B311F596AFE77129');
INSERT INTO `production_programme` VALUES ('40', 'deviceupdate1321321', '设备测试设备测试设备11', 'p3', 'p3', 'materialCode123', '物料物料物料物料', '10', '1', '0', '超级管理员', '2022-03-18 14:15:37', 'B7F4D89B67BF4D4E9B080D5142CD65FE');
INSERT INTO `production_programme` VALUES ('41', 'deviceupdate1321321', '设备测试设备测试设备11', 'p2', 'p2', 'materialCode123', '物料物料物料物料', '44', '1', '1', '超级管理员', '2022-03-18 15:05:56', 'E3D7C555FE294D15B311F596AFE77129');
INSERT INTO `production_programme` VALUES ('42', 'deviceupdate1321321', '设备测试设备测试设备11', 'p2', 'p2', 'materialCode123', '物料物料物料物料', '44', '1', '0', '超级管理员', '2022-03-18 15:05:56', 'E3D7C555FE294D15B311F596AFE77129');
INSERT INTO `production_programme` VALUES ('43', 'addDevice1', '测试添加设备1', 'p2', 'p2', 'material11', '测试物料11', '60', '1', '0', '超级管理员', '2022-03-18 15:16:53', '9ABA14855A7C49F6AB6A233F15CA445F');
INSERT INTO `production_programme` VALUES ('44', 'addDevice3', '测试添加设备3', 'p3', 'p3', 'material12', '测试物料12', '60', '1', '1', '超级管理员', '2022-03-18 16:01:15', '153DF9BA6D2B422ABC574B1B74C2C707');
INSERT INTO `production_programme` VALUES ('45', 'addDevice3', '测试添加设备3', 'p3', 'p3', 'material12', '测试物料12', '60', '1', '1', '超级管理员', '2022-03-23 17:30:52', '153DF9BA6D2B422ABC574B1B74C2C707');
INSERT INTO `production_programme` VALUES ('46', 'device2', '设备2', 'process1', '工序1', 'material12', '测试物料12', '60', '1', '0', '超级管理员', '2022-03-23 17:30:52', '153DF9BA6D2B422ABC574B1B74C2C707');

-- ----------------------------
-- Table structure for statistical_bad_production
-- ----------------------------
DROP TABLE IF EXISTS `statistical_bad_production`;
CREATE TABLE `statistical_bad_production` (
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `device_name` varchar(50) NOT NULL COMMENT '设备名称',
  `controller_id` int(11) NOT NULL COMMENT '控制器编号',
  `day` date NOT NULL COMMENT '日期',
  `hour` int(11) NOT NULL COMMENT '时段(小时级)',
  `material_code` varchar(20) NOT NULL COMMENT '物料编码',
  `material_name` varchar(20) NOT NULL COMMENT '物料名称',
  `defective_type` varchar(20) NOT NULL COMMENT '不良类型',
  `qualified_products` int(11) NOT NULL COMMENT '合格品数',
  `defective_products` int(11) NOT NULL COMMENT '不良品数',
  PRIMARY KEY (`device_id`,`controller_id`,`day`,`hour`,`defective_type`),
  KEY `device` (`device_id`,`day`,`hour`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品不良统计表';

-- ----------------------------
-- Records of statistical_bad_production
-- ----------------------------
INSERT INTO `statistical_bad_production` VALUES ('deviceId', 'deviceName', '2', '2022-03-22', '1', 'materialCode', 'materialName', '不良类型', '212', '12');
INSERT INTO `statistical_bad_production` VALUES ('deviceId', 'deviceName', '2', '2022-03-22', '2', 'materialCode', 'materialName', '不良类型', '100', '5');

-- ----------------------------
-- Table structure for statistical_capacity
-- ----------------------------
DROP TABLE IF EXISTS `statistical_capacity`;
CREATE TABLE `statistical_capacity` (
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `device_name` varchar(50) NOT NULL COMMENT '设备名称',
  `material_code` varchar(20) NOT NULL COMMENT '物料编码',
  `material_name` varchar(20) NOT NULL COMMENT '物料名称',
  `capacity` float(15,3) NOT NULL COMMENT '产能(默认30天（后台可配）内平均小时产量)',
  `ep` float(15,3) NOT NULL COMMENT '能耗',
  PRIMARY KEY (`device_id`,`material_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产产能统计表';

-- ----------------------------
-- Records of statistical_capacity
-- ----------------------------
INSERT INTO `statistical_capacity` VALUES ('1', '1', '1', '1', '1.000', '1.000');

-- ----------------------------
-- Table structure for statistical_device_alarm
-- ----------------------------
DROP TABLE IF EXISTS `statistical_device_alarm`;
CREATE TABLE `statistical_device_alarm` (
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `device_name` varchar(50) NOT NULL COMMENT '设备名称',
  `controller_id` int(11) NOT NULL COMMENT '控制器编号',
  `day` date NOT NULL COMMENT '日期',
  `hour` int(11) NOT NULL COMMENT '时段(小时级)',
  `alarm_code` varchar(20) NOT NULL COMMENT '报警编码',
  `alarm_type` varchar(50) NOT NULL COMMENT '报警类型',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `alarm_time_length` float(15,3) NOT NULL COMMENT '报警耗时(分钟)',
  `alarm_num` int(11) NOT NULL COMMENT '报警次数',
  PRIMARY KEY (`device_id`,`controller_id`,`day`,`hour`,`alarm_code`,`start_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备报警统计表';

-- ----------------------------
-- Records of statistical_device_alarm
-- ----------------------------
INSERT INTO `statistical_device_alarm` VALUES ('d1', '', '1', '2020-10-01', '15', 'alarm_code_1', 'alarm_type_1', '2020-10-01 15:20:00', '2020-10-01 15:40:00', '20.000', '2');
INSERT INTO `statistical_device_alarm` VALUES ('d1', '', '1', '2020-10-01', '15', 'alarm_code_1', 'alarm_type_1', '2020-10-01 15:55:00', '2020-10-01 16:00:00', '5.000', '1');
INSERT INTO `statistical_device_alarm` VALUES ('d1', '', '1', '2020-10-01', '16', 'alarm_code_1', 'alarm_type_1', '2020-10-01 16:00:00', '2020-10-01 16:10:00', '10.000', '1');
INSERT INTO `statistical_device_alarm` VALUES ('d1', '', '1', '2020-10-01', '16', 'alarm_code_1', 'alarm_type_1', '2020-10-01 16:25:00', '2020-10-01 16:40:00', '15.000', '2');
INSERT INTO `statistical_device_alarm` VALUES ('d1', '', '1', '2020-10-01', '16', 'alarm_code_1', 'alarm_type_1', '2020-10-01 16:50:00', '2020-10-01 17:00:00', '10.000', '2');
INSERT INTO `statistical_device_alarm` VALUES ('d1', '', '1', '2020-10-01', '17', 'alarm_code_1', 'alarm_type_1', '2020-10-01 17:00:00', '2020-10-01 17:05:00', '5.000', '2');
INSERT INTO `statistical_device_alarm` VALUES ('d1', '', '1', '2020-10-01', '17', 'alarm_code_1', 'alarm_type_1', '2020-10-01 17:06:00', '2020-10-01 17:40:00', '34.000', '4');
INSERT INTO `statistical_device_alarm` VALUES ('d1', '', '1', '2020-10-01', '17', 'alarm_code_1', 'alarm_type_1', '2020-10-01 17:50:00', '2020-10-01 18:00:00', '10.000', '1');
INSERT INTO `statistical_device_alarm` VALUES ('d1', '', '1', '2020-10-01', '18', 'alarm_code_1', 'alarm_type_1', '2020-10-01 18:00:00', '2020-10-01 18:10:00', '10.000', '1');
INSERT INTO `statistical_device_alarm` VALUES ('d1', '', '1', '2020-10-01', '18', 'alarm_code_1', 'alarm_type_1', '2020-10-01 18:45:00', '2020-10-01 18:50:00', '5.000', '2');
INSERT INTO `statistical_device_alarm` VALUES ('d1', '', '1', '2020-10-01', '19', 'alarm_code_1', 'alarm_type_1', '2020-10-01 19:55:00', '2020-10-01 19:56:00', '1.000', '2');

-- ----------------------------
-- Table structure for statistical_device_current
-- ----------------------------
DROP TABLE IF EXISTS `statistical_device_current`;
CREATE TABLE `statistical_device_current` (
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `device_name` varchar(50) NOT NULL COMMENT '设备名称',
  `controller_id` int(11) NOT NULL COMMENT '控制器编号',
  `day` date NOT NULL COMMENT '日期',
  `hour` int(11) NOT NULL COMMENT '时段( 小时级 )',
  `minute` int(11) NOT NULL,
  `charge` float(15,3) NOT NULL COMMENT '电荷量, 一个完成电流信息的电荷量',
  `current_peak` float(15,3) NOT NULL COMMENT '电流峰值, 一个完成电流信息的电流峰值',
  `current_lowest` float(15,3) NOT NULL COMMENT '电流低值, 一个完成电流信息的电流低值',
  `current_average` float(15,3) NOT NULL COMMENT '电流均值, 一个完成电流信息的电流均值',
  PRIMARY KEY (`device_id`,`controller_id`,`day`,`hour`,`minute`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备电流分析表';

-- ----------------------------
-- Records of statistical_device_current
-- ----------------------------
INSERT INTO `statistical_device_current` VALUES ('deviceId12', '测试设备11', '1', '2022-03-21', '10', '1', '50.000', '52.000', '30.000', '48.000');
INSERT INTO `statistical_device_current` VALUES ('deviceId12', '测试设备11', '1', '2022-03-21', '10', '2', '53.000', '55.000', '35.000', '47.000');
INSERT INTO `statistical_device_current` VALUES ('deviceId12', '测试设备11', '1', '2022-03-24', '1', '1', '52.000', '53.000', '36.000', '48.000');
INSERT INTO `statistical_device_current` VALUES ('deviceId12', '测试设备11', '1', '2022-03-24', '1', '2', '56.000', '54.000', '33.000', '44.000');
INSERT INTO `statistical_device_current` VALUES ('deviceId12', '测试设备11', '1', '2022-03-24', '1', '3', '54.000', '58.000', '31.000', '45.000');
INSERT INTO `statistical_device_current` VALUES ('deviceId12', '测试设备11', '1', '2022-03-24', '2', '1', '44.000', '56.000', '32.000', '43.000');

-- ----------------------------
-- Table structure for statistical_device_energy
-- ----------------------------
DROP TABLE IF EXISTS `statistical_device_energy`;
CREATE TABLE `statistical_device_energy` (
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `device_name` varchar(50) NOT NULL COMMENT '设备名称',
  `day` date NOT NULL COMMENT '日期',
  `hour` int(11) NOT NULL COMMENT '时段(小时级)',
  `charge` float(15,3) NOT NULL COMMENT '电荷量',
  `i_peak` float(15,3) NOT NULL COMMENT '电流峰值',
  `i_average` float(15,3) NOT NULL COMMENT '电流均值',
  `u` float(15,3) NOT NULL COMMENT '电压值',
  `ep` float(15,3) NOT NULL COMMENT '能耗',
  PRIMARY KEY (`device_id`,`day`,`hour`),
  KEY `主` (`device_id`,`day`,`hour`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备能耗统计表';

-- ----------------------------
-- Records of statistical_device_energy
-- ----------------------------
INSERT INTO `statistical_device_energy` VALUES ('deviceId', 'deviceName', '2022-03-21', '1', '120.000', '12.000', '1.000', '5.000', '22.000');
INSERT INTO `statistical_device_energy` VALUES ('deviceId', 'deviceName', '2022-03-22', '1', '100.000', '5.000', '10.000', '1.000', '20.000');

-- ----------------------------
-- Table structure for statistical_device_info
-- ----------------------------
DROP TABLE IF EXISTS `statistical_device_info`;
CREATE TABLE `statistical_device_info` (
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `device_name` varchar(50) NOT NULL COMMENT '设备名称',
  `controller_id` int(11) NOT NULL COMMENT '控制器编号',
  `day` date NOT NULL COMMENT '日期',
  `hour` int(11) NOT NULL COMMENT '时段',
  `startup_time` float(15,3) DEFAULT NULL COMMENT '开机时间',
  `running_time` float(15,3) DEFAULT NULL COMMENT '运行时间',
  `down_time` float(15,3) DEFAULT NULL COMMENT '停机时间',
  `scheduled_down_time` float(15,3) DEFAULT NULL COMMENT '计划停机时间',
  `OEE` float(15,3) NOT NULL COMMENT '设备综合效率 ( 设备实际的生产能力相对于理论产能的比率 )',
  `last_reset_time` datetime DEFAULT NULL COMMENT '上次清零时间',
  `qualified_products` int(11) NOT NULL COMMENT '合格品数',
  `defective_products` int(11) NOT NULL COMMENT '不良品数',
  `qualified_rate` float(15,3) NOT NULL COMMENT '合格率',
  `actual_speed` int(11) NOT NULL COMMENT '实际速度',
  `theory_speed` int(11) NOT NULL COMMENT '理论速度',
  PRIMARY KEY (`device_id`,`controller_id`,`day`,`hour`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备生产数据表 ( 设备信息统计表 )';

-- ----------------------------
-- Records of statistical_device_info
-- ----------------------------
INSERT INTO `statistical_device_info` VALUES ('d1', '', '1', '2020-10-01', '15', '0.000', '0.000', '0.000', '0.000', '0.000', null, '6', '3', '0.667', '0', '50');
INSERT INTO `statistical_device_info` VALUES ('d1', '', '1', '2020-10-01', '16', '0.000', '0.000', '0.000', '0.000', '0.000', null, '6', '2', '0.750', '0', '50');

-- ----------------------------
-- Table structure for statistical_device_parameter
-- ----------------------------
DROP TABLE IF EXISTS `statistical_device_parameter`;
CREATE TABLE `statistical_device_parameter` (
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `device_name` varchar(50) NOT NULL COMMENT '设备名称',
  `controller_id` int(11) NOT NULL COMMENT '控制器编号',
  `update_time` datetime(3) NOT NULL COMMENT '更新时间',
  `effective_identification` int(11) NOT NULL COMMENT '生效标识',
  `parameter_code` varchar(20) NOT NULL COMMENT '参数编码',
  `parameter_name` varchar(20) NOT NULL COMMENT '参数名称, 预压时间、预热时间、预热电流、缓升间隔、缓升、焊接时间、焊接电流、缓降间隔、缓降、回火时间、回火电流、维持时间、休止时间、增压延时、增压时间',
  `parameter_value` varchar(20) NOT NULL COMMENT '参数值',
  `value_data_type` int(11) NOT NULL COMMENT '值数据类型',
  `parameter_unit` int(11) NOT NULL COMMENT '参数单位',
  PRIMARY KEY (`device_id`,`controller_id`,`parameter_code`,`update_time`,`effective_identification`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备参数记录表';

-- ----------------------------
-- Records of statistical_device_parameter
-- ----------------------------
INSERT INTO `statistical_device_parameter` VALUES ('deviceId', 'deviceName', '1', '2022-03-21 15:10:21.000', '1', 'paramterCode', 'paramterName', 'paramterValue', '0', '1');

-- ----------------------------
-- Table structure for statistical_production
-- ----------------------------
DROP TABLE IF EXISTS `statistical_production`;
CREATE TABLE `statistical_production` (
  `device_id` varchar(20) NOT NULL COMMENT '设备编号',
  `device_name` varchar(50) NOT NULL COMMENT '设备名称',
  `day` date NOT NULL COMMENT '日期',
  `hour` int(11) NOT NULL COMMENT '时段(小时级)',
  `material_code` varchar(20) NOT NULL COMMENT '物料编码',
  `material_name` varchar(20) NOT NULL COMMENT '物料名称',
  `output` int(11) NOT NULL COMMENT '产量',
  PRIMARY KEY (`device_id`,`day`,`hour`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产产量统计表';

-- ----------------------------
-- Records of statistical_production
-- ----------------------------
INSERT INTO `statistical_production` VALUES ('d1', '', '2020-10-01', '15', '', '', '2');

-- ----------------------------
-- Table structure for statistical_production_early_warning
-- ----------------------------
DROP TABLE IF EXISTS `statistical_production_early_warning`;
CREATE TABLE `statistical_production_early_warning` (
  `object` varchar(20) NOT NULL COMMENT '预警对象',
  `object_id` varchar(20) NOT NULL COMMENT '对象编号',
  `object_name` varchar(50) NOT NULL COMMENT '对象名称',
  `warning_time` datetime(3) NOT NULL COMMENT '预警时间',
  `warning_type` varchar(20) NOT NULL COMMENT '预警类型',
  `warning_info` varchar(50) NOT NULL COMMENT '预警信息',
  PRIMARY KEY (`object`,`object_id`,`warning_time`,`warning_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产预警信息表';

-- ----------------------------
-- Records of statistical_production_early_warning
-- ----------------------------
INSERT INTO `statistical_production_early_warning` VALUES ('device2', 'device2', '设备2', '2022-03-17 09:14:24.000', '456', 'edg');
INSERT INTO `statistical_production_early_warning` VALUES ('deviceId12', 'deviceId12', '测试设备11', '2022-03-23 09:13:36.000', '123', 'abc');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `userId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '25d55ad283aa400af464c76d713c07ad', '超级管理员', '', '2022-03-17 10:10:34', '2022-03-17 10:10:34', '1EA2B9B0E95E4768A078ABF6B500059C');
