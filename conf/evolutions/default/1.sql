# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table game (
  id                        integer auto_increment not null,
  status                    varchar(255),
  word                      varchar(255),
  start_time                datetime,
  failed_guesses            varchar(255),
  right_guesses             varchar(255),
  constraint pk_game primary key (id))
;

create table seed_word (
  id                        integer auto_increment not null,
  word                      varchar(255),
  constraint pk_seed_word primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table game;

drop table seed_word;

SET FOREIGN_KEY_CHECKS=1;

