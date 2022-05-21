drop table if exists pfc_clientes, pfc_pessoas_juridicas, pfc_enderecos, pfc_modelos_purificadores, pfc_modelos_refil, pfc_pessoas_fisicas, pfc_purificadores; 

CREATE TABLE pfc_enderecos(
	cod_endereco INTEGER UNIQUE NOT NULL,
	rua VARCHAR(50),
	bairro VARCHAR(50),
	cidade VARCHAR(50),
	uf VARCHAR(2),
	numero INTEGER,
	CONSTRAINT pk_endereco PRIMARY KEY (cod_endereco)
);

CREATE TABLE pfc_modelos_refil(
	cod_modelo_refil INTEGER NOT NULL,
	nome_modelo VARCHAR(50) NOT NULL,
	preco NUMERIC(18,2),
	descricao TEXT,
	CONSTRAINT pk_modelo_refil PRIMARY KEY (cod_modelo_refil)
);

CREATE TABLE pfc_modelos_purificadores(
	cod_modelo_purificador INTEGER NOT NULL,
	nome_modelo VARCHAR(50) NOT NULL,
	qtd_litros NUMERIC(10,2),
	descricao TEXT,
	CONSTRAINT pk_modelo_purificador PRIMARY KEY (cod_modelo_purificador)
);

CREATE TABLE pfc_clientes(
	cod_cliente INTEGER UNIQUE NOT NULL,
	nome VARCHAR(50),
	observacao TEXT,
	cod_endereco INTEGER,
	numero_celular VARCHAR(11),
	numero_telefone VARCHAR(50),
	email VARCHAR(50),
	cpf_cnpj VARCHAR(15),
	tip_cliente VARCHAR(1) NOT NULL, -- F.Pessoa Fisica J.Pessoa Juridica
	CONSTRAINT pk_cliente PRIMARY KEY (cod_cliente),
	CONSTRAINT fk_endereco FOREIGN KEY (cod_endereco) REFERENCES pfc_enderecos(cod_endereco)
);


CREATE TABLE pfc_purificadores(
	cod_purificador INTEGER UNIQUE NOT NULL,
	cod_modelo_refil INTEGER NOT NULL,
	cod_modelo_purificador INTEGER NOT NULL,
	dta_ultima_troca DATE,
	dta_proxima_troca DATE,
	cod_cliente INTEGER,
	CONSTRAINT pk_purificador PRIMARY KEY (cod_purificador),
	CONSTRAINT fk_modelo_refil FOREIGN KEY (cod_modelo_refil) REFERENCES pfc_modelos_refil(cod_modelo_refil),
	CONSTRAINT fk_modelo_purificador FOREIGN KEY (cod_modelo_purificador) REFERENCES pfc_modelos_purificadores(cod_modelo_purificador),
	CONSTRAINT fk_cliente FOREIGN KEY (cod_cliente) REFERENCES pfc_clientes(cod_cliente)
);


GRANT ALL ON TABLE public.pfc_clientes TO clientespurific WITH GRANT OPTION;

GRANT ALL ON TABLE public.pfc_enderecos TO clientespurific WITH GRANT OPTION;

GRANT ALL ON TABLE public.pfc_modelos_purificadores TO clientespurific WITH GRANT OPTION;

GRANT ALL ON TABLE public.pfc_modelos_refil TO clientespurific WITH GRANT OPTION;

GRANT ALL ON TABLE public.pfc_purificadores TO clientespurific WITH GRANT OPTION;
