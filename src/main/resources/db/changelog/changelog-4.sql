--liquibase formatted sql

--changeset alepeshko:4

CREATE TABLE task_sequences(
    id serial,
    user_id varchar(38) NOT NULL,
    task_id int NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(task_id) REFERENCES tasks(id)
);
