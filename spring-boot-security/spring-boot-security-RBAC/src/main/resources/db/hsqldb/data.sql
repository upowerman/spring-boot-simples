-- 初始化-用户信息表数据
insert into sys_user
values (1, 'admin', 'admin');
insert into sys_user
values (2, 'luke', 'luke');

-- 初始化-角色信息表数据
insert into sys_role
values ('1', '管理员', 'admin');
insert into sys_role
values ('2', '普通角色', 'common');


-- 初始化-菜单信息表数据
insert into sys_menu
values ('1', '用户相关', '0', 'user');
insert into sys_menu
values ('2', '系统相关', '0', 'system');


-- 初始化-用户和角色关联表数据
insert into sys_user_role
values ('1', '1');
insert into sys_user_role
values ('2', '2');

-- 初始化-角色和菜单关联表数据
insert into sys_role_menu
values ('1', '2');
insert into sys_role_menu
values ('2', '1');
insert into sys_role_menu
values ('1', '1');