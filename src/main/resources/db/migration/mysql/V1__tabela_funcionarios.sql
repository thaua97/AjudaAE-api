CREATE TABLE funcionario (
    id integer (11) NOT NULL,
    nome varchar (60) NOT NULL,
    senha varchar (20) NOT NULL,
    email varchar (120) NOT NULL,
    cpf varchar (14) NOT NULL,
    endereco varchar (80) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE funcionario
  ADD PRIMARY KEY (id);

ALTER TABLE funcionario
  MODIFY id integer(11) NOT NULL AUTO_INCREMENT;