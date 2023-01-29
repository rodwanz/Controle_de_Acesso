create table planilha_controle(
          id bigint not null auto_increment,
          nome varchar(60) not null,
          motivo varchar(60) not null,
          empresa varchar(60) not null,
          documento varchar(11) not null,
          bloco_apartamento varchar(5) not null,
          hora_entrada datetime not null,
          hora_saida datetime,

         primary key (id)
);