???prompt PL/SQL Developer import file
prompt Created on 2018年3月22日 by Administrator
set feedback off
set define off
prompt Creating ARTICLE...
create table ARTICLE
(
  oid             NUMBER(18) not null,
  article_name    VARCHAR2(100),
  author          VARCHAR2(20),
  page_view       NUMBER(10),
  sort_number     NUMBER(10),
  article_type_id NUMBER(18),
  creater         NUMBER(18),
  create_time     VARCHAR2(20),
  updater         NUMBER(18),
  update_time     VARCHAR2(20),
  tag_id          NUMBER(18),
  state           NUMBER(1)
)
tablespace BLOGSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column ARTICLE.article_name
  is '标题';
comment on column ARTICLE.author
  is '作者';
comment on column ARTICLE.page_view
  is '浏览量';
comment on column ARTICLE.sort_number
  is '序号';
comment on column ARTICLE.article_type_id
  is '文章类型id';
comment on column ARTICLE.tag_id
  is '标签';
comment on column ARTICLE.state
  is '0 禁用 1启用 ';
alter table ARTICLE
  add constraint ARTICLE_PRIMARK_KEY primary key (OID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating ARTICLE_DETAIL...
create table ARTICLE_DETAIL
(
  oid        NUMBER(18) not null,
  article_id NUMBER(18),
  content    VARCHAR2(2000)
)
tablespace BLOGSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column ARTICLE_DETAIL.content
  is '内容';

prompt Creating ARTICLE_TYPE...
create table ARTICLE_TYPE
(
  create_time VARCHAR2(20),
  oid         NUMBER(18) not null,
  type_name   VARCHAR2(20),
  parent_id   NUMBER(18),
  parent_name VARCHAR2(20),
  state       NUMBER(1)
)
tablespace BLOGSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column ARTICLE_TYPE.parent_id
  is '上级id';
comment on column ARTICLE_TYPE.state
  is '0 no 1 ok';
alter table ARTICLE_TYPE
  add constraint ARTICLE_TYPE_PRIMARY_KEY primary key (OID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating TAG...
create table TAG
(
  oid         NUMBER(18) not null,
  tag_name    VARCHAR2(20),
  state       NUMBER(1),
  create_time VARCHAR2(20)
)
tablespace BLOGSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column TAG.state
  is '0 禁用 1 启用';
alter table TAG
  add constraint TAG_PRIMARK_KEY primary key (OID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Disabling triggers for ARTICLE...
alter table ARTICLE disable all triggers;
prompt Disabling triggers for ARTICLE_DETAIL...
alter table ARTICLE_DETAIL disable all triggers;
prompt Disabling triggers for ARTICLE_TYPE...
alter table ARTICLE_TYPE disable all triggers;
prompt Disabling triggers for TAG...
alter table TAG disable all triggers;
prompt Loading ARTICLE...
prompt Table is empty
prompt Loading ARTICLE_DETAIL...
prompt Table is empty
prompt Loading ARTICLE_TYPE...
prompt Table is empty
prompt Loading TAG...
prompt Table is empty
prompt Enabling triggers for ARTICLE...
alter table ARTICLE enable all triggers;
prompt Enabling triggers for ARTICLE_DETAIL...
alter table ARTICLE_DETAIL enable all triggers;
prompt Enabling triggers for ARTICLE_TYPE...
alter table ARTICLE_TYPE enable all triggers;
prompt Enabling triggers for TAG...
alter table TAG enable all triggers;
set feedback on
set define on
prompt Done.
