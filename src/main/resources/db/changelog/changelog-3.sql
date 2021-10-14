--liquibase formatted sql

--changeset alepeshko:3

CREATE TABLE task_recommendations(
    id serial,
    language_code varchar(2) NOT NULL,
    task_type_code varchar(10) NOT NULL,
    minimum_value int NOT NULL,
    maximum_value int NOT NULL,
    recommendation text NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(language_code) REFERENCES languages(code),
    FOREIGN KEY(task_type_code) REFERENCES task_types(code)
);


INSERT INTO task_recommendations(language_code,task_type_code,minimum_value,maximum_value,recommendation)
VALUES('ru', 'UI', 0, 59, 'Вы ответили правильно на несколько заданий. Необходимо более внимательно подходить к
                           нахождению дефектов UI. Один из рекомендуемых блогов на эту тему «User Interface Тестирование – все ли
                           так просто?» (по ссылке https://sqadays.com/ru/talk/11077). Обратите внимание на уже существующие проверки
                           в виде чек-листа (https://software-testing.ru/library/testing/testing-for-beginners/2478-complete-web-application-testing-checklist)
                           Так же рекомендуется еще раз обратиться к теории.');

INSERT INTO task_recommendations(language_code,task_type_code,minimum_value,maximum_value,recommendation)
VALUES('ru', 'UI', 60, 99, 'Вы ответили правильно почти на все задания! Но все же не забывайте быть немного
                            внимательнее при нахождении дефектов UI, так же рекомендуется еще раз обратиться к теории.');

INSERT INTO task_recommendations(language_code,task_type_code,minimum_value,maximum_value,recommendation)
VALUES('ru', 'UI', 100, 100, 'Вы ответили правильно на все задания по нахождению дефектов UI!');

INSERT INTO task_recommendations(language_code,task_type_code,minimum_value,maximum_value,recommendation)
VALUES('ru', 'F', 0, 59, 'В дополнение, на основании результатов тестирования функциональных элементов, рекомендуется
                         изучить методы функционального тестирования.  Обратите внимание на уже существующие проверки в виде чек-листа
                         (https://software-testing.ru/library/testing/testing-for-beginners/2478-complete-web-application-testing-checklist)');

INSERT INTO task_recommendations(language_code,task_type_code,minimum_value,maximum_value,recommendation)
VALUES('ru', 'F', 60, 99, 'Вы также ответили правильно почти на все задания по поиску дефектов функциональности!
                          Так же полезным может оказаться уже существующий чек-лист с базовыми проверками функционала
                          (https://software-testing.ru/library/testing/testing-for-beginners/2478-complete-web-application-testing-checklist)');

INSERT INTO task_recommendations(language_code,task_type_code,minimum_value,maximum_value,recommendation)
VALUES('ru', 'F', 100, 100, 'Вы ответили правильно на все задания по нахождению дефектов функциональности!');