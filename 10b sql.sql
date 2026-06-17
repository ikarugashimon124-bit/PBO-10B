USE jdbc_mhs;
SELECT * FROM mahasiswa;

CREATE DATABASE jdbc_mhs;
USE jdbc_mhs;
CREATE TABLE mahasiswa (
    id   INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nama VARCHAR(20) NOT NULL
);

INSERT INTO mahasiswa(id, nama) VALUES(1,'Nina'),(2,'Rudi'),(3,'Beni');