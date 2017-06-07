-- USER
INSERT INTO user (id, login, first_name, email, password_hash, activated) VALUES (1, 'admin', 'administrador', 'admin@porras.es', '$2a$11$b8zILFych1k7ge3cCnzrEepHA7LOHNAk.x2iG9zd/8K0vypCJ5ODC', 1);

-- ROLES
INSERT INTO role (name) VALUES ('ROLE_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_USER');
INSERT INTO role (name) VALUES ('ROLE_JUDGE');
INSERT INTO role (name) VALUES ('ROLE_ANONYMOUS');
INSERT INTO user_role (id_user, role_name) VALUES (1, 'ROLE_ADMIN');

-- PORRAS
INSERT INTO porra (id, external_id, name, creator_id, type, max_participants, finish_time) VALUES (1, 'porraca1-estodeberiaserunhash', 'madrid-barsa', 1, 'MATCH', 20, '2017-06-20 22:19:33.925');
INSERT INTO porra (id, external_id, name, creator_id, type, max_participants, finish_time) VALUES (2, 'porraca2-estodeberiaserunhash', 'Atlético de Madrid - Sevilla', 1, 'MATCH', 20, '2017-06-20 22:19:33.925');
INSERT INTO porra (id, external_id, name, creator_id, type, max_participants, finish_time) VALUES (3, 'porraca3-estodeberiaserunhash', 'Barcelona - Valencia C.F.', 1, 'MATCH', 20, '2017-06-20 22:19:33.925');
INSERT INTO porra (id, external_id, name, creator_id, type, max_participants, finish_time) VALUES (4, 'porraca4-estodeberiaserunhash', 'Deportivo - Celta de Vigo', 1, 'MATCH', 20, '2017-06-20 22:19:33.925');
INSERT INTO porra (id, external_id, name, creator_id, type, max_participants, finish_time) VALUES (5, 'porraca5-estodeberiaserunhash', 'Equipos que descienden', 1, 'POSSIBLES', 20, '2017-06-20 22:19:33.925');
INSERT INTO porra (id, external_id, name, creator_id, type, max_participants, finish_time) VALUES (6, 'porraca6-estodeberiaserunhash', 'Próximo entrenador despedido', 1, 'OPEN', 20, '2017-06-20 22:19:33.925');
