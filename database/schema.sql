create database bgg;
use bgg;
create table users(
	id 				int not null auto_increment,
    user_id 			char(8) not null,
    username		varchar(100) not null,
    fullname		varchar(100),
    constraint		user_id_pk 	primary key (id)
);