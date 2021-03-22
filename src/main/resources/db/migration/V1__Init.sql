create sequence seq_group start 1 increment 1;;
create sequence seq_student start 1 increment 1;
create sequence seq_teacher start 1 increment 1;
create sequence seq_user start 1 increment 1;

create table groups
(
    id            int8 not null,
    group_full_id varchar(255),
    info          varchar(255),
    primary key (id)
);

create table student_data
(
    id            int8 not null,
    birth_date    date,
    course_number int2 not null,
    email         varchar(255),
    first_name    varchar(255),
    last_name     varchar(255),
    primary key (id)
);

create table students_groups
(
    group_id        int8,
    student_data_id int8 not null,
    primary key (student_data_id)
);

create table teacher_data
(
    id         int8 not null,
    email      varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    primary key (id)
);

create table teacher_data_disciplines
(
    teacher_data_id int8 not null,
    disciplines     varchar(255)
);

create table teachers_groups
(
    teacher_id int8 not null,
    groups_id  int8 not null,
    primary key (teacher_id, groups_id)
);

create table user_role
(
    user_id int8 not null,
    roles   varchar(255)
);

create table usr
(
    id              int8 not null,
    is_active       boolean,
    password        varchar(255),
    username        varchar(255),
    student_data_id int8,
    teacher_data_id int8,
    primary key (id)
);

alter table if exists students_groups
    add constraint students_groups_group_fk foreign key (group_id) references groups;

alter table if exists students_groups
    add constraint students_groups_studdata_fk foreign key (student_data_id) references student_data;

alter table if exists teacher_data_disciplines
    add constraint teacher_data_disc_fk foreign key (teacher_data_id) references teacher_data;

alter table if exists teachers_groups
    add constraint teachers_groups_group_fk foreign key (groups_id) references groups;

alter table if exists teachers_groups
    add constraint teachers_groups_teachdata_fk foreign key (teacher_id) references teacher_data;

alter table if exists user_role
    add constraint user_role_user_fk foreign key (user_id) references usr;

alter table if exists usr
    add constraint usr_studdata_fk foreign key (student_data_id) references student_data;

alter table if exists usr
    add constraint usr_teachdata_fk foreign key (teacher_data_id) references teacher_data;
