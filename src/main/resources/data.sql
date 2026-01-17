-- Restaurantes
INSERT INTO restaurante (nome, categoria, avaliacao, ativo) VALUES ('Pizzaria Tech', 'Italiana', 4.5, true);
INSERT INTO restaurante (nome, categoria, avaliacao, ativo) VALUES ('Sushi Java', 'Japonesa', 4.8, true);

-- Clientes
INSERT INTO cliente (nome, email, endereco, ativo) VALUES ('Gustavo', 'gustavo@email.com', 'Rua Java, 21', true);
INSERT INTO cliente (nome, email, endereco, ativo) VALUES ('Mayara', 'mayara@email.com', 'Av Spring, 3', true);

-- Produtos (Assumindo IDs 1 e 2 para restaurantes)
INSERT INTO produto (nome, preco, disponivel, restaurante_id) VALUES ('Pizza Calabresa', 45.0, true, 1);
INSERT INTO produto (nome, preco, disponivel, restaurante_id) VALUES ('Temaki Salmão', 22.0, true, 2);