CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    surname VARCHAR(255),
    name VARCHAR(255),
    patronymic VARCHAR(255),
    gender VARCHAR(10),
    nationality VARCHAR(100),
    date_of_birth DATE,
    exam_scores INT,
    passing_score INT
);