create table ejnl(
	jnlno int not null auto_increment comment '流水号',
	userid int not null default 0 comment '用户id',
	transcode varchar(64) not null comment '',
	returncode varchar(16) not null comment '',
	returnmsg varchar(64) not null comment '',
	localaddr varchar(64) not null comment '',
	remoteaddr varchar(64) not null comment '',
	transdate date not null,
	transtime timestamp not null default current_timestamp,
	localname varchar(64) not null comment '',
    primary key(jnlno),
    key idx_userid(userid),
    key idx_transcode(transcode),
    key idx_transdate(transdate)
);