/*
Navicat MySQL Data Transfer

Source Server         : abc
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : sms

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-07-17 16:49:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` varchar(100) NOT NULL DEFAULT '0',
  `question` varchar(20) NOT NULL,
  `optA` varchar(20) NOT NULL,
  `optB` varchar(20) NOT NULL,
  `optC` varchar(20) NOT NULL,
  `optD` varchar(20) NOT NULL,
  `answer` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('0', '1+0=', '1', '2', '3', '4', 'A');
INSERT INTO `question` VALUES ('1', '1+1=', '1', '2', '3', '4', 'B');
INSERT INTO `question` VALUES ('2', '1+2=', '1', '2', '3', '4', 'C');
INSERT INTO `question` VALUES ('3', '1+3', '1', '2', '3', '4', 'D');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `question` varchar(20) NOT NULL DEFAULT '0',
  `optA` varchar(20) NOT NULL,
  `optB` varchar(20) NOT NULL,
  `optC` varchar(20) NOT NULL,
  `optD` varchar(20) NOT NULL,
  `answer` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1+0', '1', '2', '3', '4', 'A');
INSERT INTO `student` VALUES ('1+1', '1', '2', '3', '4', 'B');
INSERT INTO `student` VALUES ('1+2', '1', '2', '3', '4', 'C');
INSERT INTO `student` VALUES ('1+3', '1', '2', '3', '4', 'D');
INSERT INTO `student` VALUES ('1+4', '5', '6', '7', '8', 'A');
INSERT INTO `student` VALUES ('1+5', '5', '6', '7', '8', 'B');
INSERT INTO `student` VALUES ('1+6', '5', '6', '7', '8', 'C');
INSERT INTO `student` VALUES ('1+7', '5', '6', '7', '8', 'D');
