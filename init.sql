create schema calculator default character set utf8 collate utf8_general_ci;
flush privileges;
create user 'calculator'@'%' identified by 'calculator123456';
flush privileges;
grant select,delete,update,insert on calculator.* to 'calculator'@'%'
flush privileges;

CREATE TABLE calculator.user(
  openid varchar(32) not null COMMENT '微信用户唯一标示',
  nickName VARCHAR(256) not null COMMENT '微信昵称',
  avatarUrl varchar(5000) COMMENT '微信头像URL',
  gender int COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  city varchar(256) COMMENT '用户所在城市',
  province varchar(256) COMMENT '用户所在省份',
  country varchar(256) COMMENT '用户所在国家',
  `language` varchar(8) COMMENT '用户的语言，简体中文为zh_CN',
  PRIMARY KEY (openid)
);