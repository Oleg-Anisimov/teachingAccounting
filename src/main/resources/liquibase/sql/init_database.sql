CREATE TABLE IF NOT EXISTS public.department
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT department_pkey PRIMARY KEY (id)
);
CREATE SEQUENCE IF NOT EXISTS public.department_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
CREATE TABLE IF NOT EXISTS public.teacher
 (
     id bigint NOT NULL,
     category character varying(255) COLLATE pg_catalog."default",
     certification_date date,
     employment_type character varying(255) COLLATE pg_catalog."default",
     firstname character varying(255) COLLATE pg_catalog."default",
     lastname character varying(255) COLLATE pg_catalog."default",
     middlename character varying(255) COLLATE pg_catalog."default",
     "position" character varying(255) COLLATE pg_catalog."default",
     department_id bigint NOT NULL,
     CONSTRAINT teacher_pkey PRIMARY KEY (id),
     CONSTRAINT fkd419q6obhj46eoye136y7rjyq FOREIGN KEY (department_id)
         REFERENCES public.department (id) MATCH SIMPLE
         ON UPDATE NO ACTION
         ON DELETE NO ACTION
 );
 CREATE SEQUENCE IF NOT EXISTS public.teacher_seq
     INCREMENT 50
     START 1
     MINVALUE 1
     MAXVALUE 9223372036854775807
     CACHE 1;