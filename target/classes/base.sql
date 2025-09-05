DROP TABLE IF EXISTS usuario CASCADE;
DROP TABLE IF EXISTS endereco CASCADE;
DROP TABLE IF EXISTS paciente CASCADE;
DROP TABLE IF EXISTS equipe CASCADE;
DROP TABLE IF EXISTS consultoria CASCADE;
DROP TABLE IF EXISTS veiculo CASCADE;
DROP TABLE IF EXISTS corrida CASCADE;
DROP TABLE IF EXISTS manutencao CASCADE;
DROP TABLE IF EXISTS visita CASCADE;
DROP TABLE IF EXISTS relatorio CASCADE;
DROP TABLE IF EXISTS relatorio_usuario CASCADE;
DROP TABLE IF EXISTS posicao CASCADE;


CREATE TABLE usuario (
  id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  email VARCHAR(150) NOT NULL UNIQUE,
  nome VARCHAR(150) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  roles VARCHAR(50) NOT NULL CHECK (roles IN ('ADMIN', 'USUARIO_TECNICO', 'USUARIO_ENFERMEIRO','USUARIO_MOTORISTA','USUARIO_MEDICO'))
);

create table relatorio (
  id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  agudizou BOOLEAN NOT NULL,
  intercorreu BOOLEAN NOT NULL,
  internacao_evitada BOOLEAN NOT NULL,
  medicamentos varchar(100),
  via_admin VARCHAR(50) CHECK (via_admin IN ('VO', 'EV', 'IM','CVC','PICC','PORT_A_CATH','SC')),
  data_relatorio DATE,
  observacoes varchar(250)
);


CREATE TABLE endereco (
  id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  logradouro VARCHAR(150),
  complemento VARCHAR(150),
  numero VARCHAR(10),
  bairro VARCHAR(100),
  cidade VARCHAR(100),
  estado VARCHAR(2),
  cep VARCHAR(9)
);


CREATE TABLE paciente (
  id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,
  idade INT NOT NULL,
  data_nascimento DATE NOT NULL,
  endereco_id BIGINT NOT NULL,
  cpf VARCHAR(30),
  cid VARCHAR(50),
  telefone1 VARCHAR(40) NOT NULL,
  telefone2 VARCHAR(40) ,
  status BOOLEAN NOT NULL,
  CONSTRAINT fk_endereco FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);


CREATE TABLE equipe (
  id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  nome VARCHAR(150) NOT NULL
);


CREATE TABLE consultoria (
  id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  paciente_id BIGINT NOT NULL,
  usuario_id BIGINT NOT NULL,
  unidade_saude VARCHAR(150) NOT NULL,
  equipe_id BIGINT NOT NULL,
  data_consultoria DATE NOT NULL,
  solicitante VARCHAR(150) NOT NULL,
  hora TIME NOT NULL,
  status_baixa VARCHAR(50)
  CHECK (status_baixa IN ('OBITO_HOSPITALAR', 'REINTERNACAO_HOSPITALAR', 'ILPI','SEM_REDE_APOIO','MUDANCA_ENDERECO','INTERNACAO_HOSPITALAR','CANCELAMENTO_SOLICITANTE', 'RECUSA_PACIENTE_FAMILIAR', 'NAO_LOCALIZADO', 'OBITO_DOMICILIAR' ,'SITUACOES_ESPECIFICAS' )),
  modalidade_visita VARCHAR(50) CHECK (modalidade_visita IN ('EMERGENCIA', 'UNIDADE_SAUDE', 'HOSPITAL','PRONTO_ATENDIMENTO')),
  status_consultoria boolean not null default true,
  status_sala varchar(50) check (status_sala in ('AGUARDANDO_DISCUSSAO_EMADS','AGUARDANDO_CONTATO','AGUARDANDO_PRIMEIRA_VD','AGUARDANDO_ALTA_HOSPITALAR','SITUACOES_ESPECIFICAS','OBITO_HOSPITALAR', 'REINTERNACAO_HOSPITALAR', 'ILPI','SEM_REDE_APOIO','MUDANCA_ENDERECO','INTERNACAO_HOSPITALAR','CANCELAMENTO_SOLICITANTE', 'RECUSA_PACIENTE_FAMILIAR', 'NAO_LOCALIZADO', 'OBITO_DOMICILIAR')),
  situacoes_especificas varchar(200),
  hospital varchar(50),

  CONSTRAINT fk_consultoria_paciente FOREIGN KEY (paciente_id) REFERENCES paciente(id),
  CONSTRAINT fk_consultoria_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id),
  CONSTRAINT fk_consultoria_equipe FOREIGN KEY (equipe_id) REFERENCES equipe(id)
);


CREATE TABLE veiculo (
  id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  placa VARCHAR(10) NOT NULL UNIQUE,
  modelo VARCHAR(100) NOT NULL,
  km_rodado DECIMAL(10,2),
  km_atual DECIMAL(10,2) NOT NULL,
  latitude DECIMAL(9,6),
  longitude DECIMAL(9,6),
  status boolean default false
);


CREATE TABLE posicao (
  id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  latitude DECIMAL(9,6),
  longitude DECIMAL(9,6)
);


CREATE TABLE corrida (
  id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  veiculo_id BIGINT NOT NULL,
  usuario_id BIGINT NOT NULL,
  km_inicial DECIMAL(10,2) NOT NULL,
  km_final DECIMAL(10,2),
  hora_inicial TIME NOT NULL,
  hora_final TIME,
  posicao_inicial_id BIGINT not null,
  posicao_final_id BIGINT,
  data_corrida DATE,
  tipo_corrida varchar(50) not null check (tipo_corrida in ('VISITA','MANUTENÇÃO','OUTROS')),
  status_corrida varchar(50) not null check (status_corrida in ('INICIADA','ENCERRADA')),
  outros_descricao varchar(300),
  motivo_cancelamento varchar(300),

  CONSTRAINT fk_corrida_veiculo FOREIGN KEY (veiculo_id) REFERENCES veiculo(id),
  CONSTRAINT fk_corrida_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id),
  CONSTRAINT fk_corrida_posicao_inicial FOREIGN KEY (posicao_inicial_id) REFERENCES posicao(id),
  CONSTRAINT fk_corrida_posicao_final FOREIGN KEY (posicao_final_id) REFERENCES posicao(id)
);


CREATE TABLE manutencao (
  id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  corrida_id BIGINT,
  solicitacao_manutencao VARCHAR(50) NOT NULL CHECK (solicitacao_manutencao IN (
    'MANUTENCAO_PREVENTIVA',
    'MANUTENCAO_CORRETIVA',
    'LAVAGEM_EXTRA',
    'REVISAO_CITYCAR',
    'OUTROS'
  )),
  status_manutencao varchar(50) not null check (status_manutencao in ('INICIADA', 'ENCERRADA')),
  explicacao TEXT,

  CONSTRAINT fk_manutencao_corrida FOREIGN KEY (corrida_id) REFERENCES corrida(id)
);


CREATE TABLE visita (
  id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  paciente_id BIGINT NOT NULL,
  corrida_id BIGINT,
  equipe_id BIGINT NOT NULL,
  usuario_id BIGINT not null,
  relatorio_id BIGINT,
  hora_inicial TIME,
  hora_final TIME,
  classificacao varchar(50) not null check (classificacao in ('PRIMEIRA_VD','MEDICACAO_PARENTERAL','VD_PROGRAMADA', 'VD_NAO_PROGRAMADA', 'POS_OBITO','REMOTO')),
  status_visita VARCHAR(50) NOT NULL CHECK (status_visita IN ('CONSULTORIA_AGENDADA','CONSULTORIA_A_CAMINHO','CONSULTORIA_CORRIDA_FINALIZADA','CONSULTORIA_INICIADA', 'CONSULTORIA_REALIZADA','CONSULTORIA_RELATORIO','CONSULTORIA_FINALIZADA','AGENDADA','A_CAMINHO','CORRIDA_FINALIZADA','INICIADA','REALIZADA','RELATORIO','ENCERRADA')),

  CONSTRAINT fk_visita_paciente FOREIGN KEY (paciente_id) REFERENCES paciente(id),
  CONSTRAINT fk_visita_corrida FOREIGN KEY (corrida_id) REFERENCES corrida(id),
  CONSTRAINT fk_visita_equipe FOREIGN KEY (equipe_id) REFERENCES equipe(id),
  CONSTRAINT fk_visita_relatorio FOREIGN KEY  (relatorio_id) REFERENCES  relatorio(id)
);

CREATE TABLE relatorio_usuario (
  relatorio_id BIGINT NOT NULL,
  usuario_id BIGINT NOT NULL,

  CONSTRAINT pk_relatorio_usuario PRIMARY KEY (relatorio_id, usuario_id),
  CONSTRAINT fk_relatorio_usuario_relatorio FOREIGN KEY (relatorio_id) REFERENCES relatorio(id),
  CONSTRAINT fk_visita_usuario_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
