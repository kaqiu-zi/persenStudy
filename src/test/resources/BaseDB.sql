--
-- Table structure for table `user`
--
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(1000) NOT NULL COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `avatar_file_id` bigint(20) DEFAULT NULL COMMENT '头像对应的文件id',
  `avatar_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `capacity` bigint(20) DEFAULT NULL COMMENT '总容量',
  `footprint` bigint(20) DEFAULT '0' COMMENT '占用空间',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态，0=未启用，1=正常',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_user_name` (`username`),
  UNIQUE KEY `uk_user_nickname` (`nickname`),
  KEY `idx_user_email`(`email`(32)),
  KEY `idx_user_status`(`status`)
) ENGINE=InnoDB AUTO_INCREMENT=100000000 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

--
-- Table structure for table `file`
--
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `filename` varchar(255) DEFAULT NULL COMMENT '文件名',
  `target_url` varchar(255) NOT NULL COMMENT '目标url',
  `file_type` varchar(32) DEFAULT NULL COMMENT '文件类型',
  `folder_id` bigint(20) DEFAULT NULL COMMENT '文件夹id',
  `size` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `hash` bigint(64) DEFAULT '0' COMMENT 'md5文件加密码',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态，0=未启用，1=正常',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_file_user_id_folder_id`(`user_id`, `folder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文件表';

--
-- Table structure for table `folder`
--
DROP TABLE IF EXISTS `folder`;
CREATE TABLE `folder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `name` varchar(255) DEFAULT NULL COMMENT '文件夹名',
  `folder_id` bigint(20) DEFAULT NULL COMMENT '所在的文件夹id',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态，0=未启用，1=正常',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_folder_user_id_folder_id`(`user_id`, `folder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文件夹表';
