-- use bgg;
create table task(
	task_id				int not null auto_increment,
    user_id				char(8),
    task_description	varchar(255),
    priority			tinyint,
    due_date			date,
    constraint	task_id_pk 	primary key (task_id),
    constraint 	chk_priority check(priority between 1 and 3),    
    constraint 	user_id_fk	foreign key (user_id)	references users(user_id)
);