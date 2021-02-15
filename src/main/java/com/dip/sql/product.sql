create table product(
	prdid varchar(64) not null default '' comment '产品id',
	prdname varchar(64) not null comment '产品名称',
	createtime timestamp not null default current_timestamp comment '创建时间',
	updatetime timestamp default null on update current_timestamp comment '更新时间',
	primary key(prdid)
);