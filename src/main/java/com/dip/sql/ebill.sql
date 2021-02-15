create table ebill
(
    jnlno      int           not null auto_increment comment '流水号id',
    userid     int           not null comment '用户id',
    title      varchar(64)   not null comment '标题',
    iotype     varchar(1)    not null comment '收支类型',
    paytype    varchar(8)    not null comment '支付类型',
    amount     decimal(8, 2) not null comment '金额',
    content    varchar(256)  not null comment '内容',
    transdate  Date          not null comment '交易日期',
    recorddate date          not null comment '记账日期',
    createtime timestamp     not null default current_timestamp comment '创建时间',
    updatetime timestamp              default null on update current_timestamp comment '更新时间',
    primary key (jnlno),
    index      idx_uid(userid),
    index      idx_amt(amount),
    index      idx_dt(recorddate)
);
