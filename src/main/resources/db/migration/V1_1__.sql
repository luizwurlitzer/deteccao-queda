create table queda_history(
    id UUID not null,
    atividade Integer,
    descricao text,
    created_at     timestamp,
    updated_at     timestamp,
    deleted        boolean not null,

    CONSTRAINT queda_history_pkey PRIMARY KEY(id)
);