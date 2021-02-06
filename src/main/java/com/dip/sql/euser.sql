create table euser(
	id int not null auto_increment comment 'id',
	name varchar(64) not null comment '用户名',
	password varchar(256) not null comment '登录密码',
	phone varchar(64) not null comment '注册手机号',
	idno varchar(32) not null comment '证件号码',
	idtype char(4) not null comment '证件类型',
	createtime timestamp default current_timestamp not null comment '创建时间',
	updatetime timestamp default null comment '更新时间',
	status char(1) not null default 'N' comment '状态',
	primary key(id),
	unique index(phone),
	unique index(idno)
);
