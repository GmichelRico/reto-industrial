-- Creación de base de datos
CREATE DATABASE IF NOT EXISTS userDB;
USE userDB;

-- Creación de tabla USERS
CREATE TABLE IF NOT EXISTS USERS (
    ID_USER BIGINT AUTO_INCREMENT PRIMARY KEY,
    FULL_NAME VARCHAR(100) NOT NULL,
    USERNAME VARCHAR(50) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL UNIQUE,
    USER_CREATION_DATE DATE
);

-- Inserción de registros de prueba
INSERT INTO USERS (FULL_NAME, USERNAME, PASSWORD, EMAIL, USER_CREATION_DATE)
VALUES
('Juan Pérez', 'juan12', 'cotrasena', 'juan@juan.com', CURDATE()),
('Ángel García', 'qrt123', 'cotrasena', 'angel@angel.com', CURDATE());