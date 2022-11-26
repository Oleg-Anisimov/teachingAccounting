create table if not exists scientific_activity_type
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists scientific_activity_type_seq
    increment by 50;
create table if not exists promotion_form
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists promotion_form_seq
    increment by 50;
create table if not exists participation_type
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists participation_type_seq
    increment by 50;
create table if not exists organized_activity_type
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists organized_activity_type_seq
    increment by 50;
create table if not exists event_type
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists event_type_seq
    increment by 50;
create table if not exists event_level
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists event_level_seq
    increment by 50;
create table if not exists educate_activity_type
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists educate_activity_type_seq
    increment by 50;
create table if not exists academic_work_activity_type
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists academic_work_activity_type_seq
    increment by 50;

create table if not exists academic_production_activity_form
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists academic_production_activity_form_seq
    increment by 50;

create table if not exists academic_methods_activity_type
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists academic_methods_activity_type_seq
    increment by 50;
create table if not exists academic_methods_activity_form
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists academic_methods_activity_form_seq
    increment by 50;
create table if not exists work_vector
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists work_vector_seq
    increment by 50;
create table if not exists employment_type
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists employment_type_seq
    increment by 50;
create table if not exists position
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists position_seq
    increment by 50;
create table if not exists category
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists category_seq
    increment by 50;
create table if not exists cabinet
(
    id              bigint not null
        primary key,
    cabinet_name    varchar(255),
    cabinet_type_id bigint not null
        constraint fkbr7k45f57f9iysympj9ludvvx
            references cabinet_type
);
create sequence if not exists cabinet_seq
    increment by 50;
create table if not exists cabinet_type
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists cabinet_type_seq
    increment by 50;
create table if not exists academic_discipline
(
    id                bigint not null
        primary key,
    discipline_number varchar(255),
    name              varchar(255)
);
create sequence if not exists academic_discipline_seq
    increment by 50;
create table if not exists groups
(
    id         bigint not null
        primary key,
    group_name varchar(255)
);
create sequence if not exists group_seq
    increment by 50;
create table if not exists roles
(
    id        bigint not null
    primary key,
    role_name varchar(255)
    );
create sequence if not exists role_seq
    increment by 50;
create table if not exists specialization
(
    id                  bigint not null
    primary key,
    specialization      varchar(255),
    specialization_name varchar(255)
    );
create sequence if not exists specialization_seq
    increment by 50;
create table if not exists academic_methods
(
    id                               bigint not null
    primary key,
    complete_info                    varchar(255),
    dead_line                        date,
    academic_discipline_id           bigint not null
    constraint fkaqkuujflwbrksut4tdqrt5t5u
    references academic_discipline,
    academic_method_activity_form_id bigint not null
    constraint fk5fks58udu65ify2xuob6c7rmk
    references academic_methods_activity_form,
    academic_method_activity_type_id bigint not null
    constraint fklvbe2pwr3xbnyj7dfl4cqguxw
    references academic_methods_activity_type,
    activity_type_id                 bigint not null
    constraint fke25opprl5r55r3t4yt38yiauj
    references academic_work_activity_type,
    specialization_id                bigint not null
    constraint fkfvfon5jaw36leq4n4th07i2ql
    references specialization
);
create sequence if not exists methods_work_seq
    increment by 50;
create table if not exists academic_work
(
    id                         bigint not null
        primary key,
    absolute_results           real,
    academic_year_semestr_fact varchar(255),
    academic_year_semestr_plan varchar(255),
    first_semestr_fact         varchar(255),
    first_semestr_plan         varchar(255),
    incomplete_reason          varchar(255),
    quality_results            real,
    second_semestr_fact        varchar(255),
    second_semestr_plan        varchar(255),
    academic_discipline_id     bigint not null
        constraint fkkkkpm2fh5am9x0ecnh5mmj91i
            references academic_discipline,
    group_id                   bigint not null
        constraint fklctm3keifp2bxjw26bo7riyj6
            references groups,
    specialization_id          bigint not null
        constraint fkr11j2dxpiqalwbtge4po5ei5x
            references specialization
);
create sequence if not exists academic_work_seq
    increment by 50;
create table if not exists academic_production
(
    id                                   bigint not null
    primary key,
    date                                 date,
    result                               varchar(255),
    academic_production_activity_form_id bigint not null
    constraint fko5urg1ugs91ng2bjk3ptg7qmu
    references academic_production_activity_form,
    activity_type_id                     bigint not null
    constraint fk9dd2biylrkkeqyg4nkkq4j9sh
    references academic_work_activity_type,
    cabinet_id                           bigint not null
    constraint fk4mm6ugddj6143gmk1v3rmaqcj
    references cabinet,
    specialization_id                    bigint not null
    constraint fksn2cxxywymmauyosah8jqpwew
    references specialization
);
create sequence if not exists academic_production_seq
    increment by 50;
create table if not exists department
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists department_seq
    increment by 50;
create table if not exists educate
(
    id                  bigint not null
    primary key,
    date                date,
    event_name          varchar(255),
    result              varchar(255),
    student_information varchar(255),
    activity_type_id    bigint not null
    constraint fkcr57fb26aru4f6xbrkm2u4joo
    references educate_activity_type,
    event_level_id      bigint not null
    constraint fk9t3rjyr1nllyrfvi6kmy4agw9
    references event_level,
    event_type_id       bigint not null
    constraint fklvh334ply2jq5e7gaoe6pmtel
    references event_type,
    work_vector_id      bigint not null
    constraint fkodjrmuw7tlvi9mc7p7so71gx3
    references work_vector
);
create sequence if not exists educate_seq
    increment by 50;
create table if not exists organized_methods
(
    id                  bigint not null
    primary key,
    date                date,
    event_name          varchar(255),
    result              varchar(255),
    student_information varchar(255),
    activity_type_id    bigint not null
    constraint fktdidfg7pudxxn1gob96baj7qf
    references organized_activity_type,
    event_level_id      bigint not null
    constraint fke7k783pmvb76tq3fqk4xeh6ub
    references event_level,
    event_type_id       bigint not null
    constraint fk6mriys7qghsrdbufbsfnnpmky
    references event_type
);
create sequence if not exists organized_methods_seq
    increment by 50;
create table if not exists promotion_qualification_level
(
    id                 bigint not null
    primary key,
    date               date,
    document_or_result varchar(255),
    place              varchar(255),
    topic              varchar(255),
    promotion_form_id  bigint not null
    constraint fknnjyk9todn5nuvqcp9o940yld
    references promotion_form
);
create sequence if not exists promotion_qualification_level_seq
    increment by 50;
create table if not exists scientific_methods
(
    id                    bigint not null
    primary key,
    date                  date,
    event_name            varchar(255),
    place                 varchar(255),
    result                varchar(255),
    student_information   varchar(255),
    event_level_id        bigint not null
    constraint fk7lcr7884ju0ygnqm4f2fej29a
    references event_level,
    event_type_id         bigint not null
    constraint fkgecc0lf2ro7ishkkcu25wlnp1
    references event_type,
    participation_type_id bigint not null
    constraint fk4u5mph2l07uo3gqq0d52ebnwu
    references participation_type,
    activity_type_id      bigint not null
    constraint fki2e2pd0ivdf4tvpq1hkn6pc72
    references scientific_activity_type
);
create sequence if not exists scientific_methods_seq
    increment by 50;
create table if not exists teacher
(
    id                 bigint not null
    primary key,
    certification_date date,
    firstname          varchar(255),
    lastname           varchar(255),
    middlename         varchar(255),
    category_id        bigint not null
    constraint fkhmvb283nlhqgpyiupv2ayx0un
    references category,
    department_id      bigint not null
    constraint fkd419q6obhj46eoye136y7rjyq
    references department,
    employment_id      bigint not null
    constraint fk4kgyac58laic02jj1cwc4n5p9
    references employment_type,
    position_id        bigint not null
    constraint fkf1edqt9fou643gyfgj4fyfo10
    references position,
    user_id            bigint not null
    constraint fkcp1vpkh4bh0qux9vtvs0fkwrn
    references users
);
create sequence if not exists teacher_seq
    increment by 50;
create table if not exists users
(
    id       bigint not null
        primary key,
    login    varchar(255),
    password varchar(255)
);
create sequence if not exists user_seq
    increment by 50;
