create sequence seq_task start 1 increment 50;
create sequence seq_test start 1 increment 50;
create sequence seq_user start 1 increment 50;

create table task (
	id  bigserial not null,
	address varchar(255),
	description varchar(255),
	product varchar(255),
	taskname varchar(255),
	taskstatus varchar(255),
	user_id int8,
	primary key (id)
);

create table task_photo (
	task_id int8 not null,
	photonames varchar(255)
);

create table test (
	id  bigserial not null,
	firstname varchar(255),
	lastname varchar(255),
	oldname varchar(255),
	primary key (id)
);

create table user_role (
	user_id int8 not null,
	roles varchar(255)
);

create table usr (
	id bigserial not null,
	activation_code varchar(255),
	active boolean not null,
	email varchar(255),
	firstname varchar(255),
	lastname varchar(255),
	password varchar(255),
	username varchar(255),
	primary key (id)
);

alter table if exists task add constraint task_user_fk foreign key (user_id) references usr;
alter table if exists task_photo add constraint task_photo_task_fk foreign key (task_id) references task;
alter table if exists user_role add constraint user_role_user_fk foreign key (user_id) references usr;

