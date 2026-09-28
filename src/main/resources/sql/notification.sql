-- 通知消息表
CREATE TABLE `notification` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL COMMENT '接收通知的用户ID',
  `from_user_id` int DEFAULT NULL COMMENT '触发通知的用户ID',
  `type` varchar(20) DEFAULT NULL COMMENT '通知类型：comment/follow/apply/like',
  `rel_id` int DEFAULT NULL COMMENT '关联内容ID',
  `content` varchar(500) DEFAULT NULL COMMENT '通知内容',
  `is_read` tinyint(1) DEFAULT '0' COMMENT '是否已读 0未读 1已读',
  `time` varchar(20) DEFAULT NULL COMMENT '通知时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;