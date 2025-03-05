INSERT INTO lend.role (id, name) VALUES (default, 'admin');
INSERT INTO lend.role (id, name) VALUES (default, 'student');
INSERT INTO lend.role (id, name) VALUES (default, 'company');

INSERT INTO lend."group" (id, number, period, lector_name) VALUES (2, 36, 'jan 25 - feb 25', 'Rain');

INSERT INTO lend.group_email (id, group_id, group_number, first_name, last_name, email, status) VALUES (8, 2, 36, 'Siim', 'Silland', 'siim@mail.ee', 'P');
INSERT INTO lend.group_email (id, group_id, group_number, first_name, last_name, email, status) VALUES (9, 2, 36, 'Krisse', 'Talts', 'krisse@mail.ee', 'A');


INSERT INTO lend."user" (id, role_id, email, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO lend."user" (id, role_id, email, password, status) VALUES (default, 2, 'student', '123', 'A');
INSERT INTO lend."user" (id, role_id, email, password, status) VALUES (default, 3, 'company', '123', 'A');



