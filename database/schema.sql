-- create database bgg;
use railway;
create table users(
    user_id 		char(8) not null,
    username		varchar(100) not null,
    fullname		varchar(100),
    constraint		user_id_pk 	primary key (user_id)
);