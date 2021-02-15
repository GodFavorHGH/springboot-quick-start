create table menu
(
    menuid       varchar(32) primary key not null,
    parentmenuid varchar(32) default '',

);