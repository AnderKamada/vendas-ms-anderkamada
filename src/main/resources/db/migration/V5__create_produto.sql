CREATE TABLE produto (
                         id VARCHAR(255) PRIMARY KEY,
                         nome VARCHAR(255) NOT NULL,
                         descricao TEXT,
                         preco DECIMAL(10,2) NOT NULL,
                         categoria VARCHAR(100)
);