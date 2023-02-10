create table autorizacao_uso_de_vaga(
          id bigint not null auto_increment,
          apto_cedente varchar(60) not null,
          placa_morador varchar(60) not null,
          apto_beneficiado varchar(6) not null,
          placa_visitante varchar(60) not null,
          marca varchar(60) not null,
          modelo varchar(60) not null,
          nome_motorista varchar(60) not null,
          acesso_condominio datetime not null,

         primary key (id)
);