CREATE TABLE clientes (
    id bigint not null generated by default as identity,
    nome character varying(60) not null,
    email character varying(60) not null,
    telefone character varying(20) not null,

    PRIMARY KEY (id)
);