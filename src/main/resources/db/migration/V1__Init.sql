create table department (
                                   id uuid not null,
                                   name varchar(255),
                                   faculty_id uuid,
                                   primary key (id)
);


create table faculty (
                                id uuid not null,
                                name varchar(255),
                                primary key (id)
);

create table groups (
                        id uuid not null,
                        group_full_id varchar(255),
                        program_id uuid,
                        primary key (id)
);


create table personal_data (
                                      id uuid not null,
                                      birth_date date,
                                      first_name varchar(255),
                                      last_name varchar(255),
                                      patronymic varchar(255),
                                      email varchar(255),
                                      primary key (id)
);

create table program (
                                id uuid not null,
                                name varchar(255),
                                type varchar(255),
                                faculty_id uuid,
                                primary key (id)
);

create table student (
                         id uuid not null,
                         info varchar(255),
                         group_id uuid,
                         personal_data_id uuid,
                         primary key (id)
);

create table teacher (
                                id uuid not null,
                                achievements varchar(255),
                                info varchar(255),
                                department_id uuid,
                                personal_data_id uuid,
                                primary key (id)
);

create table user_role (
                           user_id uuid not null,
                           roles varchar(255)
);

create table usr (
                     id uuid not null,
                     credentials_non_expired boolean,
                     is_active boolean,
                     password varchar(255),
                     username varchar(255),
                     personal_data_id uuid,
                     student_id uuid,
                     teacher_id uuid,
                     primary key (id)
);

alter table if exists department
    add constraint department_faculty_fk
        foreign key (faculty_id)
            references faculty;


alter table if exists groups
    add constraint groups_program_fk
        foreign key (program_id)
            references program;

alter table if exists program
    add constraint program_faculty_fk
        foreign key (faculty_id)
            references faculty;

alter table if exists student
    add constraint student_group_fk
        foreign key (group_id)
            references groups;

alter table if exists student
    add constraint student_personal_data_fk
        foreign key (personal_data_id)
            references personal_data;

alter table if exists teacher
    add constraint teacher_department_fk
        foreign key (department_id)
            references department;

alter table if exists teacher
    add constraint teacher_personal_data_fk
        foreign key (personal_data_id)
            references personal_data;

alter table if exists user_role
    add constraint user_fk
        foreign key (user_id)
            references usr;

alter table if exists usr
    add constraint user_personal_data_fk
        foreign key (personal_data_id)
            references personal_data;

alter table if exists usr
    add constraint usr_student_fk
        foreign key (student_id)
            references student;

alter table if exists usr
    add constraint usr_teacher_fk
        foreign key (teacher_id)
            references teacher;
