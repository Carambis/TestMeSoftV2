--liquibase formatted sql

--changeset alepeshko:1
CREATE TABLE languages(
    code varchar(2),
    name varchar(30) NOT NULL,
    PRIMARY KEY(code)
);

INSERT INTO languages (code, name) VALUES('en', 'ENGLISH');
INSERT INTO languages (code, name) VALUES('ru', 'RUSSIAN');
