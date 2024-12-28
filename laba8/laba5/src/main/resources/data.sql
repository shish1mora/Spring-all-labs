
DROP TABLE IF EXISTS workers;
DROP TABLE IF EXISTS factories;

CREATE TABLE factories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);




CREATE TABLE workers (
    id SERIAL PRIMARY KEY,
    surname VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    patronym VARCHAR(50),
    home_address VARCHAR(255),
    nationality VARCHAR(50),
    date_of_birth DATE,
    department_no INT,
    tab_number INT,
    education VARCHAR(100),
    employment_date DATE,
    factory_id BIGINT,
    FOREIGN KEY (factory_id) REFERENCES factories(id) ON DELETE SET NULL
);



INSERT INTO factories (name) VALUES ('Кондитер');
INSERT INTO factories (name) VALUES ('Инженер');
INSERT INTO factories (name) VALUES ('Водитель');
INSERT INTO factories (name) VALUES ('Программист');
INSERT INTO workers (id, surname, name, patronym, home_address, nationality, date_of_birth, department_no, tab_number, education, employment_date) VALUES (DEFAULT, 'Карпов', 'Михаил', 'Алексеевич', 'Москва, ул. Ленина, д. 10, кв. 20', 'Русский', '2002-02-19', 1, 12345, 'Высшее образование', CURRENT_DATE);
INSERT INTO workers (id, surname, name, patronym, home_address, nationality, date_of_birth, department_no, tab_number, education, employment_date) VALUES (DEFAULT, 'Карпов', 'Михаил', 'Алексеевич', 'Москва, ул. Ленина, д. 10, кв. 20', 'Русский', '2002-02-19', 1, 12345, 'Высшее образование', CURRENT_DATE);