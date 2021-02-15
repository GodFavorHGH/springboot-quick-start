create table eaccount
(
    id         int                                 not null auto_increment comment 'id',
    userid     int                                 not null comment '关联用户id',
    acno       varchar(30)                         not null comment '账户',
    acname     varchar(64)                         not null comment '账户名',
    actype     char(2)                             not null comment '账户类型',
    acstate    char(1)                             not null comment '账户状态',
    createtime timestamp default current_timestamp not null comment '创建时间',
    updatetime timestamp default null comment '更新时间',
    primary key (id),
    index(userid),
    unique index(acno)
);