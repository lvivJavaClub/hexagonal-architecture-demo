-- Створення послідовності для генерації ID
CREATE SEQUENCE users_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE USERS (
    id BIGINT PRIMARY KEY DEFAULT nextval('users_seq'),
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    status VARCHAR(32) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
