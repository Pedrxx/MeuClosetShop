-- os comandos sql deve ser na mesma linha

INSERT INTO `permissao` (nome,data_criacao) VALUES ('administrador',CURRENT_TIMESTAMP());
INSERT INTO `permissao` (nome,data_criacao) VALUES ('cliente',CURRENT_TIMESTAMP());

INSERT INTO `pessoa` (`nome`,`cpf`,`email`,`senha`,`endereco`,`cep`,data_criacao) VALUES ('administrador','00000000000','pedrosa.costa93@gmail.com','admin','none','00000000',CURRENT_TIMESTAMP());


INSERT INTO marca (nome) VALUES ('Marca A');
INSERT INTO marca (nome) VALUES ('Marca B');
INSERT INTO marca (nome) VALUES ('Marca C');

INSERT INTO categorias (nome) VALUES ('Categoria A');
INSERT INTO categorias (nome) VALUES ('Categoria B');
INSERT INTO categorias (nome) VALUES ('Categoria C');

INSERT INTO produto (descCurta, descDetalhada, valorCusto, valorVenda, marca_id, categoria_id) VALUES ('Produto A', 'Descrição detalhada do Produto A', 10.50, 19.99, 1, 1);
INSERT INTO produto (descCurta, descDetalhada, valorCusto, valorVenda, marca_id, categoria_id)VALUES ('Produto B', 'Descrição detalhada do Produto B', 15.99, 29.99, 2, 2);
INSERT INTO produto (descCurta, descDetalhada, valorCusto, valorVenda, marca_id, categoria_id)VALUES ('Produto C', 'Descrição detalhada do Produto C', 8.75, 16.99, 1, 2);