CREATE TABLE users
(
    id   INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    email VARCHAR NOT NULL UNIQUE,
    first_name VARCHAR NOT NULL,
    second_name VARCHAR NOT NULL,
    middle_name VARCHAR NOT NULL,
    phone VARCHAR NOT NULL
);