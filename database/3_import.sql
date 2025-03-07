INSERT INTO lend.role (id, name) VALUES (default, 'admin');
INSERT INTO lend.role (id, name) VALUES (default, 'student');
INSERT INTO lend.role (id, name) VALUES (default, 'company');

INSERT INTO lend."group" (id, number, period, lector_name) VALUES (2, 36, 'jan 25 - feb 25', 'Rain');

INSERT INTO lend.group_email (id, group_id, first_name, last_name, email, status) VALUES (8, 2, 'Siim', 'Silland', 'siim@mail.ee', 'P');
INSERT INTO lend.group_email (id, group_id, first_name, last_name, email, status) VALUES (9, 2, 'Krisse', 'Talts', 'krisse@mail.ee', 'A');


INSERT INTO lend."user" (id, role_id, email, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO lend."user" (id, role_id, email, password, status) VALUES (default, 2, 'student', '123', 'A');
INSERT INTO lend."user" (id, role_id, email, password, status) VALUES (default, 3, 'company', '123', 'A');

INSERT INTO lend.company_profile (id, user_id, name, registration_number, description, www, address, phone) VALUES (default, 1, 'Apple', '123421341234', 'IT and Communication', null, 'Smith Street Tallinn', '234234234');

INSERT INTO lend.internship (id, company_user_id, title, description, coordinator_name, coordinator_email, status) VALUES (default, 2, 'Kasutaja', 'Testija', 'Mets', 'mets@mail.ee', 'A');



