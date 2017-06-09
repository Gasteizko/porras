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
INSERT INTO porra (id, title, creator_id, type, max_participants, finish_time, created_time, min_bet) VALUES (1, 'madrid-barsa',                  1, 'MATCH',     20, '2017-06-20 22:19:33.925', '2017-06-04 22:19:33.925',5);
INSERT INTO porra (id, title, creator_id, type, max_participants, finish_time, created_time, min_bet) VALUES (2, 'Atlético de Madrid - Sevilla',  1, 'MATCH',     20, '2017-06-20 22:19:33.925', '2017-06-2 22:19:33.925',5);
INSERT INTO porra (id, title, creator_id, type, max_participants, finish_time, created_time, min_bet) VALUES (3, 'Barcelona - Valencia C.F.',     3, 'MATCH',     20, '2017-06-20 22:19:33.925', '2017-06-7 22:19:33.925',5);
INSERT INTO porra (id, title, creator_id, type, max_participants, finish_time, created_time, min_bet) VALUES (4, 'Deportivo - Celta de Vigo',     2, 'MATCH',     20, '2017-06-20 22:19:33.925', '2017-06-3 22:19:33.925',5);
INSERT INTO porra (id, title, creator_id, type, max_participants, finish_time, created_time, min_bet) VALUES (5, 'Equipos que descienden',        3, 'POSSIBLES', 20, '2017-06-20 22:19:33.925', '2016-11-8 22:19:33.925',5);
INSERT INTO porra (id, title, creator_id, type, max_participants, finish_time, created_time, min_bet) VALUES (6, 'Próximo entrenador despedido',  4, 'POSSIBLES', 20, '2017-06-20 22:19:33.925', '2016-06-20 22:19:33.925',4);
INSERT INTO porra (id, title, creator_id, type, max_participants, finish_time, created_time, min_bet) VALUES (7, '¿Quién gana euromierdón?',      5, 'OPEN',      20, '2017-06-20 22:19:33.925', '2017-06-20 22:19:33.925',4);
INSERT INTO porra (id, title, creator_id, type, max_participants, finish_time, created_time, min_bet) VALUES (8, '¿Ganará o no el madrid?',       6, 'POSSIBLES', 20, '2017-06-20 22:19:33.925', '2017-06-20 22:19:33.925',4);

-- POSSIBLE_BETS
INSERT INTO possible_bet (id, porra_id, bet) VALUES (1, 8, 'pierde');
INSERT INTO possible_bet (id, porra_id, bet) VALUES (2, 8, 'gana');
INSERT INTO possible_bet (id, porra_id, bet) VALUES (3, 8, 'empate');
INSERT INTO possible_bet (id, porra_id, bet) VALUES (4, 5, 'valencia');
INSERT INTO possible_bet (id, porra_id, bet) VALUES (5, 5, 'sporting gijón');
INSERT INTO possible_bet (id, porra_id, bet) VALUES (6, 5, 'osasuna');
INSERT INTO possible_bet (id, porra_id, bet) VALUES (7, 5, 'celta');
INSERT INTO possible_bet (id, porra_id, bet) VALUES (8, 6, 'simeone');
INSERT INTO possible_bet (id, porra_id, bet) VALUES (9, 6, 'zidane');

-- USER_PORRAS
INSERT INTO user_porra (user_id, porra_id, bet, possible_bet_id, winned, paid, paid_time, bet_amount) VALUES (3, 1, 'betString', null, 0, 0, null, 5);
INSERT INTO user_porra (user_id, porra_id, bet, possible_bet_id, winned, paid, paid_time, bet_amount) VALUES (3, 2, 'betString', null, 0, 0, null, 5);
INSERT INTO user_porra (user_id, porra_id, bet, possible_bet_id, winned, paid, paid_time, bet_amount) VALUES (3, 3, 'betString', null, 1, 1, null, 5);
INSERT INTO user_porra (user_id, porra_id, bet, possible_bet_id, winned, paid, paid_time, bet_amount) VALUES (1, 1, 'betString', null, 0, 0, null, 5);
INSERT INTO user_porra (user_id, porra_id, bet, possible_bet_id, winned, paid, paid_time, bet_amount) VALUES (3, 6, null, 8, 0, 0, null, 6);
INSERT INTO user_porra (user_id, porra_id, bet, possible_bet_id, winned, paid, paid_time, bet_amount) VALUES (3, 8, null, 1, 0, 0, null, 6);
INSERT INTO user_porra (user_id, porra_id, bet, possible_bet_id, winned, paid, paid_time, bet_amount) VALUES (3, 4, 'betString', null, 0, 0, null, 8);
INSERT INTO user_porra (user_id, porra_id, bet, possible_bet_id, winned, paid, paid_time, bet_amount) VALUES (3, 5, null, 5, 0, 0, null, 9);
INSERT INTO user_porra (user_id, porra_id, bet, possible_bet_id, winned, paid, paid_time, bet_amount) VALUES (5, 5, null, 5, 0, 0, null, 9);
INSERT INTO user_porra (user_id, porra_id, bet, possible_bet_id, winned, paid, paid_time, bet_amount) VALUES (6, 5, null, 5, 0, 0, null, 6);
INSERT INTO user_porra (user_id, porra_id, bet, possible_bet_id, winned, paid, paid_time, bet_amount) VALUES (7, 5, null, 5, 0, 0, null, 6);
INSERT INTO user_porra (user_id, porra_id, bet, possible_bet_id, winned, paid, paid_time, bet_amount) VALUES (8, 5, null, 5, 0, 0, null, 6);
INSERT INTO user_porra (user_id, porra_id, bet, possible_bet_id, winned, paid, paid_time, bet_amount) VALUES (4, 5, null, 5, 0, 0, null, 6);