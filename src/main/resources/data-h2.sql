INSERT INTO user (id, login, first_name, email, password_hash, activated) VALUES (1, 'admin', 'administrador', 'admin@porras.es', '$2a$11$b8zILFych1k7ge3cCnzrEepHA7LOHNAk.x2iG9zd/8K0vypCJ5ODC', 1);
INSERT INTO role (name) VALUES ('ROLE_ADMIN');
INSERT INTO user_role (id_user, role_name) VALUES (1, 'ROLE_ADMIN');
