CREATE TABLE IF NOT EXISTS specialization
(
    id                  bigint not null
        primary key,
    specialization      varchar(255),
    specialization_name varchar(255)
);
CREATE SEQUENCE IF NOT EXISTS specialization_seq
    increment by 50;
CREATE TABLE IF NOT EXISTS academic_discipline
(
    id                bigint not null
        primary key,
    discipline_number varchar(255),
    name              varchar(255)
);
CREATE SEQUENCE IF NOT EXISTS academic_discipline_seq
    increment by 50;
CREATE TABLE IF NOT EXISTS academic_work
(
    id                     bigint not null
        primary key,
    absolute_results       real,
    group_name             varchar(255),
    incomplete_reason      varchar(255),
    quality_results        real,
    academic_discipline_id bigint not null
        constraint fkkkkpm2fh5am9x0ecnh5mmj91i
            references academic_discipline,
    specialization_id      bigint not null
        constraint fkr11j2dxpiqalwbtge4po5ei5x
            references specialization
);
CREATE SEQUENCE IF NOT EXISTS academic_work_seq
    increment by 50;
CREATE TABLE IF NOT EXISTS academic_methods
(
    id                     bigint not null
        primary key,
    activity_type          varchar(255),
    complete_info          varchar(255),
    dead_line              date,
    academic_discipline_id bigint not null
        constraint fkaqkuujflwbrksut4tdqrt5t5u
            references academic_discipline,
    specialization_id      bigint not null
        constraint fkfvfon5jaw36leq4n4th07i2ql
            references specialization
);
CREATE SEQUENCE IF NOT EXISTS methods_work_seq
    increment by 50;