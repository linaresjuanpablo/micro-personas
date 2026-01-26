CREATE SCHEMA IF NOT EXISTS persons;

CREATE TABLE persons (
  id UUID PRIMARY KEY,
  document_type VARCHAR(20) NOT NULL,
  document_number VARCHAR(50) NOT NULL,
  names VARCHAR(150) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phone VARCHAR(50),
  created_at TIMESTAMP DEFAULT NOW(),
  UNIQUE (document_type, document_number),
  UNIQUE (email)
);

CREATE TABLE matricula (
  id UUID PRIMARY KEY,
  id_persons UUID NOT NULL,
  id_bootcamp UUID NOT NULL,
  created_at TIMESTAMP DEFAULT NOW(),
  FOREIGN KEY (id_persons) REFERENCES persons(id)
);