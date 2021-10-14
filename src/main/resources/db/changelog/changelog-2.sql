--liquibase formatted sql

--changeset alepeshko:2
CREATE TABLE task_types(
    code varchar(10),
    name varchar(60) NOT NULL,
    description varchar(300),
    PRIMARY KEY(code)
);

CREATE TABLE tasks(
    id serial,
    language_code varchar(2) NOT NULL,
    task_name varchar(100) NOT NULL,
    header varchar(200) NOT NULL,
    task_path varchar(30) NOT NULL,
    task_type_code varchar(10) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(language_code) REFERENCES languages(code),
    FOREIGN KEY(task_type_code) REFERENCES task_types(code)
);

CREATE TABLE answers(
    id serial,
    task_id INT NOT NULL,
    text TEXT NOT NULL,
    correct boolean NOT NULL DEFAULT FALSE,
    PRIMARY KEY(id),
    FOREIGN KEY(task_id) REFERENCES tasks(id)
);

INSERT INTO task_types (code, name) VALUES('UI', 'User interface');
INSERT INTO task_types (code, name) VALUES('F', 'Function');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(1,'ru','Грамматика', '[Тестирование UI] - ', 'grammar', 'UI');
INSERT INTO answers (task_id, text) VALUES(1, 'Чекбокс нельзя активировать');
INSERT INTO answers (task_id, text) VALUES(1, 'Грамматическая ошибка в абзаце \"с\"');
INSERT INTO answers (task_id, text, correct) VALUES(1, 'Курсор не изменяет вид при наведении на чекбокс', true);

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(2,'ru','Выравнивание', '[Тестирование UI] - ', 'alignment', 'UI');
INSERT INTO answers (task_id, text) VALUES(2, 'Чекбокс нельзя активировать');
INSERT INTO answers (task_id, text, correct) VALUES(2, 'Текст в абзаце \"а\" не выровнен по левому краю', true);
INSERT INTO answers (task_id, text) VALUES(2, 'Курсор не изменяет вид при наведении на чекбокс');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(3,'ru','Кнопка', '[Тестирование функциональности] - ', 'button-double-click', 'F');
INSERT INTO answers (task_id, text) VALUES(3, 'Введенный текст не отображается в полях ввода');
INSERT INTO answers (task_id, text, correct) VALUES(3, 'Кнопка выполняет назначение только при двойном нажатии', true);
INSERT INTO answers (task_id, text) VALUES(3, 'Курсор не изменяет вид при наведении на кнопку');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(4,'ru','Кнопка', '[Тестирование функциональности] - ', 'button-function', 'F');
INSERT INTO answers (task_id, text) VALUES(4, 'Введенный текст не отображается в полях ввода');
INSERT INTO answers (task_id, text, correct) VALUES(4, 'Кнопка не выполняет предписанное назначение: очищает заполненные поля, но авторизация не происходит', true);
INSERT INTO answers (task_id, text) VALUES(4, 'Курсор не изменяет вид при наведении на кнопку');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(5,'ru','Календарь', '[Тестирование функциональности] - ', 'calendar', 'F');
INSERT INTO answers (task_id, text) VALUES(5, 'Регистрация невозможна при нажатии на кнопку \"Зарегистрироваться\"');
INSERT INTO answers (task_id, text, correct) VALUES(5, 'Регистрация возможна с датой рождения, которая превышает текущую дату', true);
INSERT INTO answers (task_id, text) VALUES(5, 'Курсор не изменяет вид при наведении на кнопку');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(6,'ru','Радиобаттон', '[Тестирование UI] - ', 'checkbox', 'UI');
INSERT INTO answers (task_id, text) VALUES(6, 'Невозможно ввести латинские символы в поля ввода');
INSERT INTO answers (task_id, text, correct) VALUES(6, 'Радиобаттон становится активным не при нажатии, а при наведении курсора', true);
INSERT INTO answers (task_id, text) VALUES(6, 'Курсор не изменяет вид при наведении на радиобаттон');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(7,'ru','Чекбокс', '[Тестирование функциональности] - ', 'checkbox-check', 'F');
INSERT INTO answers (task_id, text) VALUES(7, 'Грамматическая ошибка в заглавии задания');
INSERT INTO answers (task_id, text, correct) VALUES(7, 'Невозможно выбрать два и более варианта времени для записи', true);
INSERT INTO answers (task_id, text) VALUES(7, 'Курсор не изменяет вид при наведении на чекбокс');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(8,'ru','Курсор', '[Тестирование UI] - ', 'cursor', 'UI');
INSERT INTO answers (task_id, text) VALUES(8, 'Текст в абзаце \"а\" не выровнен по левому краю');
INSERT INTO answers (task_id, text) VALUES(8, 'Грамматическая ошибка в абзаце \"с\"');
INSERT INTO answers (task_id, text, correct) VALUES(8, 'Курсор не изменяет вид при наведении на чекбокс', true);

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(9,'ru','Загрузка файла', '[Тестирование функциональности] - ', 'file-type-check', 'F');
INSERT INTO answers (task_id, text) VALUES(9, 'Можно зарузить файл с расширением .docx');
INSERT INTO answers (task_id, text, correct) VALUES(9, 'Можно загрузить файл с расширением .jpg', true);
INSERT INTO answers (task_id, text) VALUES(9, 'Невозможно зарузить файл с расширением .png');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(10,'ru','Фильтрация контента таблицы', '[Тестирование функциональности] - ', 'filter', 'F');
INSERT INTO answers (task_id, text, correct) VALUES(10, 'Фильтр для населения срабатывает на первый столбец с названиями городов', true);
INSERT INTO answers (task_id, text) VALUES(10, 'Фильтрация не работает для первого столбца');
INSERT INTO answers (task_id, text) VALUES(10, 'Невозможно ввести данные в фильтр для третьего столбца');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(11,'ru','Шрифт', '[Тестирование UI] - ', 'font', 'UI');
INSERT INTO answers (task_id, text, correct) VALUES(11, 'Шрифт в абзаце \"а\" отличается от общего форматирования текста', true);
INSERT INTO answers (task_id, text) VALUES(11, 'Текст в абзаце \"а\" не выровнен по левому краю');
INSERT INTO answers (task_id, text) VALUES(11, 'Курсор не изменяет вид при наведении на чекбокс');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(12,'ru','Обязательные данные', '[Тестирование функциональности] - ', 'form-problem', 'F');
INSERT INTO answers (task_id, text, correct) VALUES(12, 'Авторизация возможна, если одно из обязательных полей не заполнено', true);
INSERT INTO answers (task_id, text) VALUES(12, 'Введенные данные сбрасываются при попытке авторизоваться, если не было заполнено одно или все обязательные поля');
INSERT INTO answers (task_id, text) VALUES(12, 'Курсор не изменяет вид при наведении на поле ввода');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(13,'ru','Всплывающая подсказка', '[Тестирование UI] - ', 'hint', 'UI');
INSERT INTO answers (task_id, text, correct) VALUES(13, 'Всплывающая подсказка не соответствует по смыслу полю ввода', true);
INSERT INTO answers (task_id, text) VALUES(13, 'Невозможно заполнить поле, пока отображается всплывающая подсказка');
INSERT INTO answers (task_id, text) VALUES(13, 'Курсор не изменяет вид при наведении на поле ввода');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(14,'ru','Раскрывающийся список', '[Тестирование UI] - ', 'illumination', 'UI');
INSERT INTO answers (task_id, text) VALUES(14, 'Невозможно выбрать значение из списка');
INSERT INTO answers (task_id, text, correct) VALUES(14, 'Значение не выделяется при наведении курсора на значение из списка', true);
INSERT INTO answers (task_id, text) VALUES(14, 'Раскрывающийся список не развертывается при нажатии');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(15,'ru','Раскрывающееся меню', '[Тестирование UI] - ', 'link', 'UI');
INSERT INTO answers (task_id, text, correct) VALUES(15, 'Ссылка в меню не выделяется при наведении курсора, меню не раскрывается при нажатии на пункт меню', true);
INSERT INTO answers (task_id, text) VALUES(15, 'Ссылка в меню выделяется при наведении курсора,но меню не раскрывается при нажатии на пункт меню');
INSERT INTO answers (task_id, text) VALUES(15, 'Невозможно нажать на пункт меню');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(16,'ru','"Ссылка",', '[Тестирование функциональности] - ', 'link-work', 'F');
INSERT INTO answers (task_id, text, correct) VALUES(16, 'Невозможно перейти по ссылке под текстом', true);
INSERT INTO answers (task_id, text) VALUES(16, 'Невозможно выбрать чекбокс');
INSERT INTO answers (task_id, text) VALUES(16, 'Курсор не изменяет вид при наведении на кнопку');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(17,'ru','Поле ввода', '[Тестирование UI] - ', 'location', 'UI');
INSERT INTO answers (task_id, text, correct) VALUES(17, 'Набранный текст выходит за рамки поля ввода', true);
INSERT INTO answers (task_id, text) VALUES(17, 'Невозможно ввести текст в поле \"Фамилия\"');
INSERT INTO answers (task_id, text) VALUES(17, 'Курсор не изменяет вид при наведении на поле ввода');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(18,'ru','Радиобаттон', '[Тестирование функциональности] - ', 'radiobutton-check', 'F');
INSERT INTO answers (task_id, text, correct) VALUES(18, 'Можно выбрать два радиобаттона одновременно', true);
INSERT INTO answers (task_id, text) VALUES(18, 'Невозможно выбрать ни один радиобаттон');
INSERT INTO answers (task_id, text) VALUES(18, 'Курсор не изменяет вид при наведении на радиобаттон');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(19,'ru','Сортировка контента таблицы', '[Тестирование функциональности] - ', 'sort-problem', 'F');
INSERT INTO answers (task_id, text, correct) VALUES(19, 'Сортировка в третьем столбце работает на основании типа данных string', true);
INSERT INTO answers (task_id, text) VALUES(19, 'Сортировка не работает в первом столбце');
INSERT INTO answers (task_id, text) VALUES(19, 'Сортировка во втором столбце работает по числовому типу данных');

INSERT INTO tasks (id, language_code, task_name, header, task_path, task_type_code)
VALUES(20,'ru','Чекбокс', '[Тестирование функциональности] - ', 'uncheck-param', 'F');
INSERT INTO answers (task_id, text) VALUES(20, 'Невозможно выбрать чекбокс');
INSERT INTO answers (task_id, text, correct) VALUES(20, 'Невозможно снять выбор с чекбокса', true);
INSERT INTO answers (task_id, text) VALUES(20, 'Курсор не изменяет вид при наведении на чекбокс');

