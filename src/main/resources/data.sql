INSERT INTO tb_restaurante (id,cep,complemento,nome) VALUES 
(1L,'0000001','Complemento Endereço Restaurante 1','Restaurante 1' );


INSERT INTO tb_cliente (id,cep,complemento,nome) VALUES
(1L,'0000001','Complemento Endereço Cliente 1', 'Cliente 1');

INSERT INTO tb_produto (id,disponivel,nome,valor_unitario,restaurante_id) VALUES 
(1L,true,'Produto 1', 5.0,1L),
(2L,true,'Produto 2', 6.0,1L),
(3L,true,'Produto 3', 8.0,1L);

INSERT INTO tb_sacola (id,forma_pagamento,fechada,valor_total,cliente_id) VALUES 
(1L,0,false,0.0,1L);