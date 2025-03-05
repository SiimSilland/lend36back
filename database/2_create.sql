-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2025-02-28 11:53:27.671

-- tables
-- Table: city
CREATE TABLE city
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: company_profile
CREATE TABLE company_profile
(
    id serial  NOT NULL,
    user_id int  NOT NULL,
    name varchar(255)  NOT NULL,
    registration_number varchar(30)  NOT NULL,
    description varchar(1000)  NULL,
    www varchar(255)  NULL,
    address varchar(225)  NOT NULL,
    phone varchar(25)  NOT NULL,
    CONSTRAINT enterprises_pk PRIMARY KEY (id)
);


-- Table: cv
CREATE TABLE cv
(
    id      serial NOT NULL,
    data    bytea  NOT NULL,
    user_id int    NOT NULL,
    CONSTRAINT cv_pk PRIMARY KEY (id)
);

-- Table: group
CREATE TABLE "group"
(
    id          serial       NOT NULL,
    number      int          NOT NULL,
    period      varchar(255) NOT NULL,
    lector_name varchar(255) NOT NULL,
    CONSTRAINT group_pk PRIMARY KEY (id)
);

-- Table: group_email
CREATE TABLE group_email
(
    id       serial       NOT NULL,
    group_id int          NOT NULL,
    first_name varchar(255) NOT NULL,
    last_name  varchar(255) NOT NULL,
    email    varchar(255) NOT NULL,
    status   varchar(1)   NOT NULL,
    CONSTRAINT group_email_pk PRIMARY KEY (id)
);

-- Table: interest
CREATE TABLE interest
(
    id              serial     NOT NULL,
    company_user_id int        NOT NULL,
    student_user_id int        NOT NULL,
    status          varchar(1) NOT NULL,
    CONSTRAINT enterprise_interests_pk PRIMARY KEY (id)
);

-- Table: internship
CREATE TABLE internship
(
    id                serial        NOT NULL,
    company_user_id   int           NOT NULL,
    title             varchar(255)  NOT NULL,
    description       varchar(1000) NOT NULL,
    coordinator_name  varchar(255)  NOT NULL,
    coordinator_email varchar(255)  NOT NULL,
    status            varchar(1)    NOT NULL,
    CONSTRAINT internship_pk PRIMARY KEY (id)
);

-- Table: preferred_city
CREATE TABLE preferred_city
(
    id      serial NOT NULL,
    user_id int    NOT NULL,
    city_id int    NOT NULL,
    CONSTRAINT preferred_city_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role
(
    id   serial      NOT NULL,
    name varchar(50) NOT NULL,
    CONSTRAINT AK_0 UNIQUE (name) NOT DEFERRABLE INITIALLY IMMEDIATE,
    CONSTRAINT roles_pk PRIMARY KEY (id)
);

-- Table: student_preference
CREATE TABLE student_preference
(
    id        serial NOT NULL,
    user_id   int    NOT NULL,
    from_date int    NOT NULL,
    CONSTRAINT student_preference_pk PRIMARY KEY (id)
);

-- Table: student_profile
CREATE TABLE student_profile
(
    id         serial       NOT NULL,
    user_id    int          NOT NULL,
    first_name varchar(255) NOT NULL,
    last_name  varchar(255) NOT NULL,
    address    varchar(255) NULL,
    phone      varchar(255) NULL,
    linkedin   varchar(255) NULL,
    email      varchar(255) NOT NULL,
    CONSTRAINT student_profile_pk PRIMARY KEY (id)
);

-- Table: task
CREATE TABLE task
(
    id          serial        NOT NULL,
    title       varchar(255)  NOT NULL,
    description varchar(1000) NOT NULL,
    created_at  timestamp     NOT NULL DEFAULT current_timestamp,
    deadline    date          NULL,
    status      varchar(1)    NOT NULL,
    CONSTRAINT tasks_pk PRIMARY KEY (id)
);

-- Table: task_answer
CREATE TABLE task_answer
(
    id            serial     NOT NULL,
    user_id       int        NOT NULL,
    task_id       int        NOT NULL,
    solution_file bytea      NULL,
    submitted_at  timestamp  NOT NULL DEFAULT current_timestamp,
    status        varchar(1) NOT NULL,
    CONSTRAINT student_task_answers_pk PRIMARY KEY (id)
);

-- Table: task_file
CREATE TABLE task_file
(
    id      serial NOT NULL,
    data    bytea  NOT NULL,
    task_id int    NOT NULL,
    CONSTRAINT task_file_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user"
(
    id       serial       NOT NULL,
    role_id  int          NOT NULL,
    email    varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    status   varchar(1)   NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (id)
);

-- Table: user_group
CREATE TABLE user_group
(
    id       serial NOT NULL,
    group_id int    NOT NULL,
    user_id  int    NOT NULL,
    CONSTRAINT user_group_pk PRIMARY KEY (id)
);

-- Table: user_image
CREATE TABLE user_image
(
    id      serial NOT NULL,
    data    bytea  NOT NULL,
    user_id int    NOT NULL,
    CONSTRAINT user_image_pk PRIMARY KEY (id)
);

-- Table: user_task
CREATE TABLE user_task
(
    id              serial     NOT NULL,
    student_user_id int        NOT NULL,
    task_id         int        NOT NULL,
    status          varchar(1) NOT NULL,
    CONSTRAINT user_task_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: allowed_email_group (table: group_email)
ALTER TABLE group_email
    ADD CONSTRAINT allowed_email_group
        FOREIGN KEY (group_id)
            REFERENCES "group" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: company_profile_user (table: company_profile)
ALTER TABLE company_profile
    ADD CONSTRAINT company_profile_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: company_user (table: interest)
ALTER TABLE interest
    ADD CONSTRAINT company_user
        FOREIGN KEY (company_user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: cv_user (table: cv)
ALTER TABLE cv
    ADD CONSTRAINT cv_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: internship_user (table: internship)
ALTER TABLE internship
    ADD CONSTRAINT internship_user
        FOREIGN KEY (company_user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: preferred_city_city (table: preferred_city)
ALTER TABLE preferred_city
    ADD CONSTRAINT preferred_city_city
        FOREIGN KEY (city_id)
            REFERENCES city (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: preferred_city_user (table: preferred_city)
ALTER TABLE preferred_city
    ADD CONSTRAINT preferred_city_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: profile_user (table: student_profile)
ALTER TABLE student_profile
    ADD CONSTRAINT profile_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: student_preference_user (table: student_preference)
ALTER TABLE student_preference
    ADD CONSTRAINT student_preference_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: student_user (table: interest)
ALTER TABLE interest
    ADD CONSTRAINT student_user
        FOREIGN KEY (student_user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: task_answer_task (table: task_answer)
ALTER TABLE task_answer
    ADD CONSTRAINT task_answer_task
        FOREIGN KEY (task_id)
            REFERENCES task (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: task_answer_user (table: task_answer)
ALTER TABLE task_answer
    ADD CONSTRAINT task_answer_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: task_file_task (table: task_file)
ALTER TABLE task_file
    ADD CONSTRAINT task_file_task
        FOREIGN KEY (task_id)
            REFERENCES task (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_group_group (table: user_group)
ALTER TABLE user_group
    ADD CONSTRAINT user_group_group
        FOREIGN KEY (group_id)
            REFERENCES "group" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_group_user (table: user_group)
ALTER TABLE user_group
    ADD CONSTRAINT user_group_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_image_user (table: user_image)
ALTER TABLE user_image
    ADD CONSTRAINT user_image_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user"
    ADD CONSTRAINT user_role
        FOREIGN KEY (role_id)
            REFERENCES role (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_task_task (table: user_task)
ALTER TABLE user_task
    ADD CONSTRAINT user_task_task
        FOREIGN KEY (task_id)
            REFERENCES task (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_task_user (table: user_task)
ALTER TABLE user_task
    ADD CONSTRAINT user_task_user
        FOREIGN KEY (student_user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- End of file.

