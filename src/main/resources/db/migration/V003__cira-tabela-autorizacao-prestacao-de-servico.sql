create table autorizacao_prestacao_de_servico(
          id bigint not null auto_increment,
          apartamento_atendido varchar(60) not null,
          responsavel_pelo_servico varchar(60) not null,
          documento varchar(60) not null,
          hora_de_acesso datetime not null,

         primary key (id)
);