INSERT INTO lend.role (id, name) VALUES (default, 'admin');
INSERT INTO lend.role (id, name) VALUES (default, 'student');
INSERT INTO lend.role (id, name) VALUES (default, 'company');


INSERT INTO lend."user" (id, role_id, email, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO lend."user" (id, role_id, email, password, status) VALUES (default, 2, 'student', '123', 'A');
INSERT INTO lend."user" (id, role_id, email, password, status) VALUES (default, 3, 'company', '123', 'A');

INSERT INTO lend."group" (id, number, period, lector_name) VALUES (default, 26, 'veebruar 2025 - märts 2025 ', 'Rain');

INSERT INTO lend.group_email (id, group_id, first_name, last_name, email, status) VALUES (1, 1, 'Rain', 'Tüür', 'rain@gmail.ee', 'P');
INSERT INTO lend.group_email (id, group_id, first_name, last_name, email, status) VALUES (2, 1, 'Siim', 'Silland', 'Siim@mail.ee', 'A');
INSERT INTO lend.group_email (id, group_id, first_name, last_name, email, status) VALUES (3, 1, 'Kalle', 'Bammer', 'Kalle@mail.ee', 'P');
INSERT INTO lend.group_email (id, group_id, first_name, last_name, email, status) VALUES (4, 1, 'Krisse Desiree', 'Talts', 'Krisse@mail.ee', 'P');
