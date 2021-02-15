create table menu
(
    id         int         not null auto_increment comment '主键id',
    parentid   varchar(64) not null comment '父级菜单id',
    menuid     varchar(64) not null comment '菜单id',
    menuname   varchar(64) not null comment '菜单名',
    status     char(1)     not null default '1' comment '菜单状态',
    isparent   char(1)     not null comment '是否父级菜单',
    menulevel  char(1)     not null comment '菜单级别',
    createtime timestamp            default current_timestamp comment '创建时间',
    updatetime timestamp comment '更新时间',
    primary key (id),
    key        idx_menuid(menuid),
    key        inx_parentid(parentid)
);
#新增一级菜单
个人中心 一级菜单的parentid统一插 root
insert into menu(parentid,menuid,menuname,isparent,menulevel)values('root','personCenter','个人中心','1','1');
#在一级菜单
个人中心 下新增二级菜单 信息设置
insert into menu(parentid,menuid,menuname,isparent,menulevel)values('personCenter','infoSetting','信息设置','1','2');
#在二级菜单
信息设置下新增三级菜单 添加账户 注销用户
insert into menu(parentid,menuid,menuname,isparent,menulevel)values('infoSetting','addAccount','添加账户','0','3');
insert into menu(parentid, menuid, menuname, isparent, menulevel)
values ('infoSetting', 'withdrawUser', '注销用户', '0', '3');
#新增一级菜单
事项管理 一级菜单的parentid统一插0
insert into menu(parentid,menuid,menuname,isparent,menulevel)values('root','eventMgmt','事项管理','1','1');
#在一级菜单
事项管理 下新增二级菜单 待办事项
insert into menu(parentid,menuid,menuname,isparent,menulevel)values('eventMgmt','scheduleEvents','待办事项','0','2');