CREATE DATABASE myfinances;

CREATE SCHEMA finance;

DROP TABLE IF EXISTS finance.user;

CREATE TABLE finance.user
(
  id bigserial NOT NULL PRIMARY KEY,
  name character varying(150),
  email character varying(100),
  password character varying(100),
  insert_date date DEFAULT NOW()
);

DROP TABLE IF EXISTS finance.registry;

CREATE TABLE finance.registry
(
  id bigserial NOT NULL PRIMARY KEY,
  description character varying(100) NOT NULL,
  month integer NOT NULL,
  year integer NOT NULL,
  value numeric(16,2), 
  type character varying(20) CHECK ( type in ( 'REVENUE', 'EXPENSE' ) ) NOT NULL,
  status character varying(20) CHECK ( type in ( 'PENDING', 'EFFECTIVE', 'CANCELLED' ) ) NOT NULL,
  id_user bigint REFERENCES finance.user (id) NOT NULL,
  insert_date date DEFAULT NOW()
);
