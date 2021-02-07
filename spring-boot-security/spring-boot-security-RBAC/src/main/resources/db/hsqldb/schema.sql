-- 1、用户信息表
drop table if exists sys_user;
create table sys_user
(
    id        bigint      not null,
    user_name varchar(30) not null,
    password  varchar(100) default '',
    primary key (id)
);

-- 2、角色信息表
drop table if exists sys_role;
create table sys_role
(
    id        bigint       not null,
    role_name varchar(30)  not null,
    role_key  varchar(100) not null,
    primary key (id)
);

-- 3、菜单权限表
drop table if exists sys_menu;
create table sys_menu
(
    id        bigint      not null,
    menu_name varchar(50) not null,
    parent_id bigint       default 0,
    perms     varchar(100) default null,
    primary key (id)
);

-- 4、用户和角色关联表  用户N-1角色
drop table if exists sys_user_role;
create table sys_user_role
(
    user_id bigint not null,
    role_id bigint not null,
    primary key (user_id, role_id)
);

-- 5、角色和菜单关联表  角色1-N菜单
drop table if exists sys_role_menu;
create table sys_role_menu
(
    role_id bigint not null,
    menu_id bigint not null,
    primary key (role_id, menu_id)
);

-- 5、用户token
drop table if exists sys_user_token;
create table sys_user_token
(
    id      bigint IDENTITY primary key,
    user_id bigint   not null,
    token   varchar(100) not null,
    expire  datetime not null
);
