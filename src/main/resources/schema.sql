CREATE DATABASE employeedb;
USE employeedb;

CREATE TABLE employees (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    department VARCHAR(255)
);