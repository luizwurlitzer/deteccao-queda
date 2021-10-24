create table orientacao_history(
    id UUID not null,
    orientacao_id Integer,
    orientacao_descricao text,
    created_at     timestamp,
    updated_at     timestamp,
    deleted        boolean not null,

    CONSTRAINT orientacao_history_pkey PRIMARY KEY(id)
);