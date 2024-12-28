
INSERT INTO students (surname, name, patronymic, gender, nationality, date_of_birth, exam_scores, passing_score, email)
VALUES ('Иванов', 'Кирилл', 'Сергеевич', 'Мужской', 'Русский', '2000-09-16', 90, 50,  'kafedra.pin@mail.ru');

INSERT INTO students (surname, name, patronymic, gender, nationality, date_of_birth, exam_scores, passing_score, email)
VALUES ('Карпов', 'Денис', 'Васильеивч', 'Мужской', 'Русский', '1999-01-40', 85, 45,  'kafedra.pin@mail.ru');


INSERT INTO users (username, password, role) VALUES ('admingood', 'good', 'ROLE_ADMIN'),
INSERT INTO users (username, password, role) VALUES ('usergood', 'good', 'ROLE_USER');
