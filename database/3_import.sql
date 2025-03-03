INSERT INTO lend.role (id, name) VALUES (default, 'admin');
INSERT INTO lend.role (id, name) VALUES (default, 'student');
INSERT INTO lend.role (id, name) VALUES (default, 'company');


INSERT INTO lend."user" (id, role_id, email, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO lend."user" (id, role_id, email, password, status) VALUES (default, 2, 'student', '123', 'A');
INSERT INTO lend."user" (id, role_id, email, password, status) VALUES (default, 3, 'company', '123', 'A');
