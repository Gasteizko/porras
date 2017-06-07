-- TEST DATA
-- USERS
INSERT INTO user (id, login, first_name, email, password_hash, activated) VALUES (1, 'admin', 'administrador', 'admin@porras.es', '$2a$11$b8zILFych1k7ge3cCnzrEepHA7LOHNAk.x2iG9zd/8K0vypCJ5ODC', 1);
INSERT INTO user (id, login, first_name, email, password_hash, activated) VALUES (2, 'judge', 'juez', 'judge@porras.es', '$2a$11$b8zILFych1k7ge3cCnzrEepHA7LOHNAk.x2iG9zd/8K0vypCJ5ODC', 1);
INSERT INTO user (id, login, first_name, email, password_hash, activated) VALUES (3, 'user', 'ususario', 'user@porras.es', '$2a$11$b8zILFych1k7ge3cCnzrEepHA7LOHNAk.x2iG9zd/8K0vypCJ5ODC', 1);
INSERT INTO user (id, login, first_name, email, password_hash, activated) VALUES (4, 'porras', 'porrero', 'porra@porras.es', '$2a$11$b8zILFych1k7ge3cCnzrEepHA7LOHNAk.x2iG9zd/8K0vypCJ5ODC', 1);
INSERT INTO user (id, login, first_name, email, password_hash, activated) VALUES (5, 'dani', 'daniel', 'dani@porras.es', '$2a$11$b8zILFych1k7ge3cCnzrEepHA7LOHNAk.x2iG9zd/8K0vypCJ5ODC', 1);
INSERT INTO user (id, login, first_name, email, password_hash, activated) VALUES (6, 'riesco', 'hector', 'riesco@porras.es', '$2a$11$b8zILFych1k7ge3cCnzrEepHA7LOHNAk.x2iG9zd/8K0vypCJ5ODC', 1);
INSERT INTO user (id, login, first_name, email, password_hash, activated) VALUES (7, 'malagon', 'hector', 'malagon@porras.es', '$2a$11$b8zILFych1k7ge3cCnzrEepHA7LOHNAk.x2iG9zd/8K0vypCJ5ODC', 1);
INSERT INTO user (id, login, first_name, email, password_hash, activated) VALUES (8, 'pepe', 'pepe', 'pepe@porras.es', '$2a$11$b8zILFych1k7ge3cCnzrEepHA7LOHNAk.x2iG9zd/8K0vypCJ5ODC', 1);

-- ROLES
INSERT INTO role (name) VALUES ('ROLE_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_USER');
INSERT INTO role (name) VALUES ('ROLE_JUDGE');
INSERT INTO role (name) VALUES ('ROLE_ANONYMOUS');

-- USER_ROLE
INSERT INTO user_role (id_user, role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO user_role (id_user, role_name) VALUES (2, 'ROLE_JUDGE');
INSERT INTO user_role (id_user, role_name) VALUES (3, 'ROLE_USER');
INSERT INTO user_role (id_user, role_name) VALUES (4, 'ROLE_ANONYMOUS');

-- USER_FIENDS
INSERT INTO user_friend (id, id_user, id_friend, create_time, update_time, active) VALUES (1, 5, 6, null, null, 1);
INSERT INTO user_friend (id, id_user, id_friend, create_time, update_time, active) VALUES (2, 5, 7, null, null, 1);
INSERT INTO user_friend (id, id_user, id_friend, create_time, update_time, active) VALUES (3, 5, 8, null, null, 1);

-- PORRAS
INSERT INTO porra (id, external_id, name, creator_id, type, max_participants, finish_time) VALUES (1, 'porraca1-estodeberiaserunhash', 'madrid-barsa', 1, 'MATCH', 20, '2017-06-20 22:19:33.925');
INSERT INTO porra (id, external_id, name, creator_id, type, max_participants, finish_time) VALUES (2, 'porraca2-estodeberiaserunhash', 'Atlético de Madrid - Sevilla', 1, 'MATCH', 20, '2017-06-20 22:19:33.925');
INSERT INTO porra (id, external_id, name, creator_id, type, max_participants, finish_time) VALUES (3, 'porraca3-estodeberiaserunhash', 'Barcelona - Valencia C.F.', 1, 'MATCH', 20, '2017-06-20 22:19:33.925');
INSERT INTO porra (id, external_id, name, creator_id, type, max_participants, finish_time) VALUES (4, 'porraca4-estodeberiaserunhash', 'Deportivo - Celta de Vigo', 1, 'MATCH', 20, '2017-06-20 22:19:33.925');
INSERT INTO porra (id, external_id, name, creator_id, type, max_participants, finish_time) VALUES (5, 'porraca5-estodeberiaserunhash', 'Equipos que descienden', 1, 'POSSIBLES', 20, '2017-06-20 22:19:33.925');
INSERT INTO porra (id, external_id, name, creator_id, type, max_participants, finish_time) VALUES (6, 'porraca6-estodeberiaserunhash', 'Próximo entrenador despedido', 1, 'POSSIBLES', 20, '2017-06-20 22:19:33.925');
INSERT INTO porra (id, external_id, name, creator_id, type, max_participants, finish_time) VALUES (7, 'porraca7-estodeberiaserunhash', '¿Quién gana euromierdón?', 1, 'OPEN', 20, '2017-06-20 22:19:33.925');
INSERT INTO porra (id, external_id, name, creator_id, type, max_participants, finish_time) VALUES (8, 'porraca4-estodeberiaserunhash', '¿Ganará o no el madrid?', 1, 'POSSIBLES', 20, '2017-06-20 22:19:33.925');

-- POSSIBLE_BETS
INSERT INTO possible_bet (id, id_porra, bet) VALUES (1, 8, 'pierde');
INSERT INTO possible_bet (id, id_porra, bet) VALUES (2, 8, 'gana');
INSERT INTO possible_bet (id, id_porra, bet) VALUES (3, 8, 'empate');
INSERT INTO possible_bet (id, id_porra, bet) VALUES (4, 5, 'valencia');
INSERT INTO possible_bet (id, id_porra, bet) VALUES (5, 5, 'sporting gijón');
INSERT INTO possible_bet (id, id_porra, bet) VALUES (6, 5, 'osasuna');
INSERT INTO possible_bet (id, id_porra, bet) VALUES (7, 5, 'celta');
INSERT INTO possible_bet (id, id_porra, bet) VALUES (8, 6, 'simeone');
INSERT INTO possible_bet (id, id_porra, bet) VALUES (9, 6, 'zidane');

-- USER_PORRAS
INSERT INTO user_porra (id, id_user, id_porra, bet, id_possible_bet, winned, paid, paid_time) VALUES (1, 3, 1, 'betString', null, 0, 0, null);
INSERT INTO user_porra (id, id_user, id_porra, bet, id_possible_bet, winned, paid, paid_time) VALUES (2, 3, 2, 'betString', null, 0, 0, null);
INSERT INTO user_porra (id, id_user, id_porra, bet, id_possible_bet, winned, paid, paid_time) VALUES (3, 3, 3, 'betString', null, 1, 1, null);
INSERT INTO user_porra (id, id_user, id_porra, bet, id_possible_bet, winned, paid, paid_time) VALUES (4, 1, 1, 'betString', null, 0, 0, null);
INSERT INTO user_porra (id, id_user, id_porra, bet, id_possible_bet, winned, paid, paid_time) VALUES (5, 3, 6, null, 8, 0, 0, null);
INSERT INTO user_porra (id, id_user, id_porra, bet, id_possible_bet, winned, paid, paid_time) VALUES (6, 3, 8, null, 1, 0, 0, null);
INSERT INTO user_porra (id, id_user, id_porra, bet, id_possible_bet, winned, paid, paid_time) VALUES (7, 3, 4, 'betString', null, 0, 0, null);
INSERT INTO user_porra (id, id_user, id_porra, bet, id_possible_bet, winned, paid, paid_time) VALUES (8, 3, 5, null, 5, 0, 0, null);