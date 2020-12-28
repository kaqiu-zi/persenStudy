--
-- Table structure for table `material`
--
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `material_name` varchar(255) DEFAULT NULL COMMENT '素材名',
  `subject` varchar(255) DEFAULT NULL COMMENT '主题',
  `tag` varchar(30) DEFAULT NULL COMMENT '演标签',
  `material_type` varchar(10) NOT NULL COMMENT '素材类型',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='素材表';

--
-- Table structure for table `material_tag_ref`
--
DROP TABLE IF EXISTS `material_tag_ref`;
CREATE TABLE `material_tag_ref` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `material_id` bigint(20) NOT NULL COMMENT '素材id',
  `tag_id` int(11) NOT NULL COMMENT '素材tag_id',
  `content` varchar(45) NOT NULL COMMENT 'tag内容',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_material_tr_material` (`material_id`),
  KEY `idx_material_tr_tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='素材tag表';

--
-- Table structure for table `material_tag_type`
--
DROP TABLE IF EXISTS `material_tag_type`;
CREATE TABLE `material_tag_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `material_type` varchar(45) DEFAULT NULL COMMENT '素材类型',
  `key` varchar(45) NOT NULL COMMENT '素材tag的key',
  `name` varchar(45) NOT NULL COMMENT '素材tag的名称',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='素材tag类型';

