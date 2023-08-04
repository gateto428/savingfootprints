CREATE TABLE IF NOT EXISTS users (
     id varchar(50) NOT NULL PRIMARY KEY,
     name varchar(50) NOT NULL,
     last_name varchar(50) NOT NULL,
     document_type varchar(3) NOT NULL,
     document varchar(20) NOT NULL UNIQUE,
     phone varchar(15) NOT NULL,
     email varchar(20) NOT NULL UNIQUE,
     CONSTRAINT users_document_type_check CHECK (document_type IN ('CC', 'CE', 'TI'))
);

CREATE TABLE IF NOT EXISTS Pet (
     id varchar(50) NOT NULL PRIMARY KEY,
     type_pet varchar(5) NOT NULL,
     size_pet varchar(10) NOT NULL,
     description_pet TEXT NOT NULL,
     location varchar(50) NOT NULL,
     state BOOLEAN NOT NULL DEFAULT true,
     owner varchar(50),
     creator varchar(50) NOT NULL,
     CONSTRAINT Pet_fk0 FOREIGN KEY (owner) REFERENCES users(id),
     CONSTRAINT Pet_fk1 FOREIGN KEY (creator) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS Picture (
     id varchar(50) NOT NULL PRIMARY KEY,
     path varchar(250) NOT NULL,
     pet varchar(50) NOT NULL,
     CONSTRAINT Picture_fk0 FOREIGN KEY (pet) REFERENCES Pet(id)
);

CREATE TABLE IF NOT EXISTS Initiative (
     id varchar(250) NOT NULL PRIMARY KEY,
     name varchar(50) NOT NULL,
     description varchar(250) NOT NULL,
     goal DECIMAL(50),
     state BOOLEAN NOT NULL DEFAULT true,
     pet varchar(50) NOT NULL,
     CONSTRAINT Initiative_fk0 FOREIGN KEY (pet) REFERENCES Pet(id)
);

CREATE TABLE IF NOT EXISTS Donation (
     id_initiative varchar(50) NOT NULL,
     id_users varchar(50) NOT NULL,
     donation_pay DECIMAL(50) NOT NULL,
     transfer_code varchar(100) NOT NULL,
     CONSTRAINT Donation_fk0 FOREIGN KEY (id_initiative) REFERENCES Initiative(id),
     CONSTRAINT Donation_fk1 FOREIGN KEY (id_users) REFERENCES users(id)
);
