-- os comandos sql deve ser na mesma linha

INSERT INTO `permissao` (nome,data_criacao) VALUES ('administrador',CURRENT_TIMESTAMP());
INSERT INTO `permissao` (nome,data_criacao) VALUES ('cliente',CURRENT_TIMESTAMP());

INSERT INTO `pessoa` (`nome`,`cpf`,`email`,`senha`,`endereco`,`cep`,data_criacao) VALUES ('administrador','00000000000','pedrosa.costa93@gmail.com','admin','none','00000000',CURRENT_TIMESTAMP());

--INSERT INTO `permissao_pessoa` (permissao,pessoa,data_criacao) VALUES (1,1,CURRENT_TIMESTAMP());


