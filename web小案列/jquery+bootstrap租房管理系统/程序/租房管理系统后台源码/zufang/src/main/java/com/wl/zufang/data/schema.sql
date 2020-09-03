CREATE database rent_house;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
  `id` bigint NOT NULL auto_increment comment 'ID',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `telephone` varchar(11) NOT NULL COMMENT '手机号',
  `email` varchar (20) NOT NULL COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `sex` char(2) COMMENT '性别,非必填',
  `image` varchar (255) COMMENT '头像',
  `salt` varchar (255) COMMENT '盐值',
  primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 auto_increment=1 comment '表用户信息';


DROP TABLE IF EXISTS `house`;
CREATE TABLE `house`(
  `id` bigint NOT NULL auto_increment comment 'ID',
  `house_number` varchar(20) NOT NULL COMMENT '房源编号,必填',
  `area` varchar (255) NOT NULL COMMENT '地区,必填',
  `layout` varchar (255) NOT NULL COMMENT '户型,必填',
  `price` varchar (255) NOT NULL COMMENT '价格,必填',
  `state` int NOT NULL default '0' COMMENT '房源状态:0,待租;1,已租;',
  `house_type` varchar (255) NOT NULL COMMENT '房源属性:楼盘,商铺,必填;',
  `content` varchar (255) COMMENT '更多信息,非必填',
  `image1` varchar (255) COMMENT '图片1',
  `image2` varchar (255) COMMENT '图片2',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 auto_increment=1 comment '房源信息表';


DROP TABLE IF EXISTS `rent_house`;
CREATE TABLE `rent_house`(
  `id` bigint NOT NULL auto_increment comment 'ID',
  `user_id` bigint NOT NULL default '0' COMMENT '用户id',
  `house_id` bigint NOT NULL default '0' COMMENT '房源id',
  `house_number` varchar(20) NOT NULL COMMENT '房源编号',
  `price` varchar (255) NOT NULL COMMENT '价格',
  `duration` varchar (255) COMMENT '租房时长',
  `content` varchar (255) COMMENT '更多信息,非必填',
  `state` int not null default '1' COMMENT '房源状态,0:待租;1:已租;默认为1',
  `gmt_create`   timestamp NULL     DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间戳',
  `gmt_modify` timestamp NULL     DEFAULT CURRENT_TIMESTAMP  COMMENT '修改时间戳',
  primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 auto_increment=1 comment '用户租房信息';
