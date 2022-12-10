
    create table planilha_controle (
       id  bigserial not null,
        data date,
        destino varchar(255),
        rg_cpf varchar(255),
        empresa varchar(255),
        hora_de_entrada varchar(255),
        hora_de_saida varchar(255),
        motivo varchar(255),
        nome varchar(255),
        primary key (id)
    );
INSERT INTO PLANILHA_CONTROLE (id, data, destino, rg_cpf, empresa, hora_de_entrada, hora_de_saida, motivo, nome) VALUES (1, '2022-11-26', '2/305', '20.345.564-9', 'Ifood', '21:45', '21:50', 'entrega', 'Pedro Silva');
INSERT INTO PLANILHA_CONTROLE (id, data, destino, rg_cpf, empresa, hora_de_entrada, hora_de_saida, motivo, nome) VALUES (2, '2022-11-26', '2/301', '097.034.567-45', 'Ifood', '20:15', '20:20', 'entrega', 'José Silva');
INSERT INTO PLANILHA_CONTROLE (id, data, destino, rg_cpf, empresa, hora_de_entrada, hora_de_saida, motivo, nome) VALUES (3, '2022-11-26', '2/303', '134.009.987-12', 'Ifood',  '20:31', '20:36', 'entrega', 'Tiago');
INSERT INTO PLANILHA_CONTROLE (id, data, destino, rg_cpf, empresa, hora_de_entrada, hora_de_saida, motivo, nome) VALUES (4, '2022-11-26', '2/304', '120.789.987-43', 'Ifood', '19:15', '19:20', 'entrega', 'João');
