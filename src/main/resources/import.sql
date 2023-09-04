
INSERT INTO table_user(uuid_user, user_email, user_password) VALUES ('6d39ebf2-4608-11ee-be56-0242ac120002', 'oguilherme@gmail.com', 'gui123456');
INSERT INTO table_user(uuid_user, user_email, user_password) VALUES ('6d39ee54-4608-11ee-be56-0242ac120002', 'vinicius@gmail.com', 'vinicius12345');

INSERT INTO tabela_eletro(uuid_eletro, ean, horas_uso, marca, potencia, titulo, voltagem) VALUES ('5328ffea-43a7-11ee-be56-0242ac120002', '7899711165084', 3, 'POSITIVO', 9, 'Smart Lâmpada Wi-Fi', 'V110');
INSERT INTO tabela_eletro(uuid_eletro, ean, horas_uso, marca, potencia, titulo, voltagem) VALUES ('532902b0-43a7-11ee-be56-0242ac120002', '7899711165084', 5, 'PHILIPS', 66, 'AirFry', 'V220');

INSERT INTO tabela_pessoa(uuid_pessoa, cpf, data, email, genero, nome, parentesco) VALUES ('5329153e-43a7-11ee-be56-0242ac120002', '43900748810', '14/02/1996', 'oguilhermefranco@gmail', 'MASCULINO_CIS', 'Guilherme franco', 'PAI');
INSERT INTO tabela_pessoa(uuid_pessoa, cpf, data, email, genero, nome, parentesco) VALUES ('53291700-43a7-11ee-be56-0242ac120002', '37073011092', '25/05/1998', 'pedrodelara@gmail.com', 'MASCULINO_CIS', 'Pedro Lara', 'FILHO');

INSERT INTO tabela_endereco(uuid_endereco, bairro, cep, cidade, complemento, estado, numero, rua) VALUES ('53291962-43a7-11ee-be56-0242ac120002', 'Itaquera', 08210715, 'Sao Paulo', 'casa2', 'SP', 34, 'Goncalves Dias');
INSERT INTO tabela_endereco(uuid_endereco, bairro, cep, cidade, complemento, estado, numero, rua) VALUES ('f6a6bede-46d9-11ee-be56-0242ac120002', 'se', 01005010, 'Sao Paulo', 'terreo', 'SP', 175, 'Largo Sao Francisco');

INSERT INTO endereco_relation (usuario_id, endereco_id) VALUES ('6d39ebf2-4608-11ee-be56-0242ac120002','53291962-43a7-11ee-be56-0242ac120002');

INSERT INTO endereco_pessoa(uuid_endereco, uuid_pessoa) VALUES ('53291962-43a7-11ee-be56-0242ac120002','5329153e-43a7-11ee-be56-0242ac120002');

INSERT INTO uso_eletro_endereco (uuid_uso_eletro_endereco, horas_uso, id_eletro, uuid_endereco) VALUES ( '5bb15d18-4a8e-11ee-be56-0242ac120002','10','5328ffea-43a7-11ee-be56-0242ac120002', '53291962-43a7-11ee-be56-0242ac120002');

