CREATE TABLE countries
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    emoji    VARCHAR(255),
    currency VARCHAR(255),
    code     VARCHAR(255),
    capital  VARCHAR(255)
);