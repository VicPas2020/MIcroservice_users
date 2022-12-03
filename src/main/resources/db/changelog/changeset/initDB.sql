
DROP TABLE IF EXISTS users_scheme.user_hard_skills;
DROP TABLE IF EXISTS users_scheme.user_subscriptions;
DROP TABLE IF EXISTS users_scheme.hard_skills;
DROP TABLE IF EXISTS users_scheme.user_profile;

CREATE TABLE IF NOT EXISTS users_scheme.user_profile
(
    id                uuid                                                NOT NULL PRIMARY KEY,
    FirstName         character varying(100) COLLATE pg_catalog."default" NOT NULL,
    LastName          character varying(100) COLLATE pg_catalog."default" NOT NULL,
    MiddleName        character varying(100) COLLATE pg_catalog."default",
    Gender            boolean                                             NOT NULL,
    Birthday          character varying(10)  COLLATE pg_catalog."default" NOT NULL,
    CurrentLocation   character varying(100) COLLATE pg_catalog."default" NOT NULL,
    AvatarLink        character varying(255) COLLATE pg_catalog."default" NOT NULL,
    PersonalInfo      character varying(255) COLLATE pg_catalog."default" NOT NULL,
    NickName          character varying(20)  COLLATE pg_catalog."default" NOT NULL,
    Email             character varying(50)  COLLATE pg_catalog."default",
    Phone             character varying(25)  COLLATE pg_catalog."default",
    isDeleted         boolean                default false                NOT NULL
);


CREATE RULE orders_rl AS ON DELETE TO users_scheme.user_profile
    DO INSTEAD NOTHING;


CREATE TABLE IF NOT EXISTS users_scheme.hard_skills (
    id          uuid                                                 NOT NULL PRIMARY KEY,
    hard_skill  character varying(100) COLLATE pg_catalog."default"  NOT NULL
);


CREATE TABLE IF NOT EXISTS users_scheme.user_hard_skills(
       user_id        uuid NOT NULL,
       hard_skill_id  uuid NOT NULL,
       FOREIGN KEY (user_id)       REFERENCES users_scheme.user_profile (id) ON DELETE RESTRICT,
       FOREIGN KEY (hard_skill_id) REFERENCES users_scheme.hard_skills  (id) ON DELETE RESTRICT
);


CREATE TABLE IF NOT EXISTS users_scheme.user_subscriptions(
       user_id          uuid NOT NULL,
       subscriber_id    uuid NOT NULL,
       FOREIGN KEY (user_id)        REFERENCES users_scheme.user_profile (id) ON DELETE RESTRICT,
       FOREIGN KEY (subscriber_id)  REFERENCES users_scheme.user_profile (id) ON DELETE RESTRICT
);

-- CREATE USERS
INSERT INTO users_scheme.user_profile values ('039fb3b6-6693-11ed-9022-0242ac120002', 'Petroff', 'Ivan', 'Sidorovich', true, '01.01.2000', 'Moscow', 'http://avatars.com/random/123', 'Some personal info', 'Bojor', 'petroff@mail.ru', '+7(951)125-15-15', false);
INSERT INTO users_scheme.user_profile values ('1460a278-6693-11ed-9022-0242ac120002', 'Bashiroff', 'Asher', 'Mtsanovich', true, '05.05.2001', 'Dubai', 'http://avatars.com/random/321', 'Like personal info', 'Dub', 'dubjay@gmail.ru', '+81(091)001-74-07', false);
INSERT INTO users_scheme.user_profile values ('039fb3b6-6693-11ed-9022-0242ac120000', 'Ivanova', 'Ivanka', 'Ivanovna', false , '01.01.2002', 'Moscow', 'http://avatars.com/random/222', 'Some other personal info', 'Ivanka', 'ivanka@mail.ru', '+7(949)840-49-61', false);


--CREATE SKILLS
INSERT INTO users_scheme.hard_skills values ('5d3f806a-e1e0-42c8-8683-f4a7de551a11', 'JAVA');
INSERT INTO users_scheme.hard_skills values ('f1d063cf-a421-49bc-b9e4-d3840885f2ea', 'KOTLIN');
INSERT INTO users_scheme.hard_skills values ('f1d063cf-a421-49bc-b9e4-d3840885f299', 'C++');


--MATCH users and skills
INSERT INTO users_scheme.user_hard_skills values ('039fb3b6-6693-11ed-9022-0242ac120002', '5d3f806a-e1e0-42c8-8683-f4a7de551a11');
INSERT INTO users_scheme.user_hard_skills values ('1460a278-6693-11ed-9022-0242ac120002', '5d3f806a-e1e0-42c8-8683-f4a7de551a11');
INSERT INTO users_scheme.user_hard_skills values ('039fb3b6-6693-11ed-9022-0242ac120000', 'f1d063cf-a421-49bc-b9e4-d3840885f299');

--MATCH users and subscribers
INSERT INTO users_scheme.user_subscriptions values ('039fb3b6-6693-11ed-9022-0242ac120002', '1460a278-6693-11ed-9022-0242ac120002');
INSERT INTO users_scheme.user_subscriptions values ('1460a278-6693-11ed-9022-0242ac120002', '039fb3b6-6693-11ed-9022-0242ac120002');