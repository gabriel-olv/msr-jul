CREATE TABLE ocorrencias (
    id bigint not null generated by default as identity,
    descricao character varying(150) not null,
    data_registro timestamp with time zone not null,
    id_entrega bigint not null,

    PRIMARY KEY (id),
    FOREIGN KEY (id_entrega) REFERENCES entregas (id)
);