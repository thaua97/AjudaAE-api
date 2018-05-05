CREATE TABLE chamado(
id INT (11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR (50) NOT NULL,
descricao VARCHAR (120) NOT NULL,
tipo VARCHAR (10) NOT NULL,
status VARCHAR (10) NOT NULL,
email VARCHAR (80) NOT NULL,
email2 VARCHAR (80),
email3 VARCHAR (80),
telefone VARCHAR (12) NOT NULL,
telefone2 VARCHAR (12),
funcionario_id INT,
FOREIGN KEY (funcionario_id) REFERENCES funcionario (id)

);

INSERT INTO chamado(titulo, descricao, tipo, status, email, telefone, funcionario_id)
VALUES('teste001', '1 teste', 'teste', 'enviado', 'teste@gmail.com', '984342124', '2');