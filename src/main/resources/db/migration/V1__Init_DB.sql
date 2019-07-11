create sequence hibernate_sequence start 1 increment 1;

create table task (
    id int8 not null,
    address varchar(255),
    description varchar(255),
    product varchar(255),
    taskname varchar(255),
    taskstatus varchar(255),
    primary key (id)
);

create table task_photo (
    task_id int8 not null,
    photonames varchar(255)
);

create table task_pictureee (task_id int8 not null, list_picturename varchar(255));


create table test (
    id int8 not null,
    testname varchar(255),
    primary key (id)
);
create table user_role (
    user_id int8 not null,
    roles varchar(255)
);
create table usr (
    id int8 not null,
    activation_code varchar(255),
    active boolean not null,
    email varchar(255),
    password varchar(255),
    username varchar(255),
    primary key (id)
);
alter table if exists task_photo
    add constraint task_photo_task_fk
    foreign key (task_id) references task;

alter table if exists task_pictureee
    add constraint task_pictureee_task_fk
    foreign key (task_id) references test;

alter table if exists user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr;