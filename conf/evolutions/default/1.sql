# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table surfer (
  id                        bigint not null,
  name                      varchar(255),
  home                      varchar(255),
  country                   varchar(255),
  awards                    varchar(255),
  carousel_url              varchar(255),
  bio_url                   varchar(255),
  bio                       clob,
  slug                      varchar(255),
  type                      varchar(255),
  footstyle                 varchar(255),
  constraint pk_surfer primary key (id))
;

create table updates (
  id                        bigint not null,
  date                      varchar(255),
  action                    varchar(255),
  name                      varchar(255),
  user_info_id              bigint,
  surfer_id                 bigint,
  constraint pk_updates primary key (id))
;

create table user_info (
  id                        bigint not null,
  name                      varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  admin                     boolean,
  constraint pk_user_info primary key (id))
;

create sequence surfer_seq;

create sequence updates_seq;

create sequence user_info_seq;

alter table updates add constraint fk_updates_userInfo_1 foreign key (user_info_id) references user_info (id) on delete restrict on update restrict;
create index ix_updates_userInfo_1 on updates (user_info_id);
alter table updates add constraint fk_updates_surfer_2 foreign key (surfer_id) references surfer (id) on delete restrict on update restrict;
create index ix_updates_surfer_2 on updates (surfer_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists surfer;

drop table if exists updates;

drop table if exists user_info;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists surfer_seq;

drop sequence if exists updates_seq;

drop sequence if exists user_info_seq;

