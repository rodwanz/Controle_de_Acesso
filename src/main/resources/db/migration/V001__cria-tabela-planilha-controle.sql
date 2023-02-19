create table planilha_controle(
          id bigint not null auto_increment,
          nome varchar(60) not null,
          motivo varchar(60) not null,
          empresa varchar(60) not null,
          documento varchar(60) not null,
          destino varchar(5) not null,
          data_acesso datetime not null,

         primary key (id)
);
