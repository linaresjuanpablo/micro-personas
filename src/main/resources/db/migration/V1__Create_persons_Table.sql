CREATE SCHEMA IF NOT EXISTS person;

  CREATE TABLE person.persons (
  id SERIAL PRIMARY KEY,
  document_type VARCHAR(20) NOT NULL,
  document_number VARCHAR(50) NOT NULL,
  names VARCHAR(150) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phone VARCHAR(50),
  created_at TIMESTAMP DEFAULT NOW(),
  UNIQUE (document_type, document_number),
  UNIQUE (email)
);

  CREATE TABLE person.matricula (
  id SERIAL PRIMARY KEY,
  id_persons INT NOT NULL,
  id_bootcamp INT NOT NULL,
  created_at TIMESTAMP DEFAULT NOW(),
  FOREIGN KEY (id_persons) REFERENCES person.persons(id)
);