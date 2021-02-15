create table rule
(
    ruleId    varchar(64)   not null,
    userType  char(1)       not null,
    ruleType  varchar(16)   not null,
    ruleDef   varchar(1024) not null,
    nameSpace varchar(16)   not null,
    primary key (ruleType, ruleId, userType)
);