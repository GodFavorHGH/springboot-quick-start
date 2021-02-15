create table producttrs(
	prdid varchar(64) not null default '',
	transcode varchar(64) not null,
	createtime timestamp not null default current_timestamp comment '创建时间',
	updatetime timestamp default null on update current_timestamp comment '更新时间',
	primary key(prdid,transcode)
);