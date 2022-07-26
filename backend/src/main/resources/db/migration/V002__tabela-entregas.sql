CREATE TABLE entregas (
    id bigint not null generated by default as identity,
    data_pedido timestamp with time zone not null,
    data_finalizacao timestamp with time zone,
    status character varying(20) not null,
    destinatario_nome character varying(60) not null,
    destinatario_logradouro character varying(100) not null,
    destinatario_logradouro_numero character varying(10) not null,
    destinatario_logradouro_complemento character varying(60),
    destinatario_logradouro_bairro character varying(30) not null,
    id_cliente bigint not null,

    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente) REFERENCES clientes (id)
);