drop table if exists SYS_MENU;

drop table if exists SYS_ROLE;

drop table if exists SYS_ROLE_MENU;

drop table if exists SYS_USER;

drop table if exists SYS_USER_ROLE;

/*==============================================================*/
/* Table: SYS_MENU                                              */
/*==============================================================*/
create table SYS_MENU
(
   ID                   BIGINT not null auto_increment,
   NAME                 varchar(50),
   URL                  varchar(50),
   MENU_TYPE            varchar(50),
   ORDER_NUM            varchar(50),
   primary key (ID)
);

/*==============================================================*/
/* Table: SYS_ROLE                                              */
/*==============================================================*/
create table SYS_ROLE
(
   ID                   bigint not null auto_increment,
   NAME                 varchar(50),
   REMARK               varchar(50),
   primary key (ID)
);

/*==============================================================*/
/* Table: SYS_ROLE_MENU                                         */
/*==============================================================*/
create table SYS_ROLE_MENU
(
   ID                   bigint not null auto_increment,
   ROLE_ID              varchar(50),
   MENU_ID              varchar(50),
   primary key (ID)
);

/*==============================================================*/
/* Table: SYS_USER                                              */
/*==============================================================*/
create table SYS_USER
(
   ID                   bigint not null auto_increment,
   NAME                 varchar(50),
   PASSWORD             varchar(50),
   EMAIL                varchar(50),
   DEPT_ID              bigint,
   ACTIVE_IND           tinyint,
   CREATE_TIME          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: SYS_USER_ROLE                                         */
/*==============================================================*/
create table SYS_USER_ROLE
(
   ID                   BIGINT not null auto_increment,
   USER_ID              BIGINT,
   ROLE_ID              BIGINT,
   primary key (ID)
);
