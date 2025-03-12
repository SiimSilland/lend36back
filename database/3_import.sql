INSERT INTO lend.role (id, name) VALUES (default, 'admin');
INSERT INTO lend.role (id, name) VALUES (default, 'student');
INSERT INTO lend.role (id, name) VALUES (default, 'company');

INSERT INTO lend."group" (id, number, period, lector_name, status) VALUES (2, 36, 'jan 25 - feb 25', 'Rain', 'A');

INSERT INTO lend.group_email (id, group_id, first_name, last_name, email, status) VALUES (default, 2, 'Siim', 'Silland', 'siim@mail.ee', 'P');
INSERT INTO lend.group_email (id, group_id, first_name, last_name, email, status) VALUES (default, 2, 'Krisse', 'Talts', 'krisse@mail.ee', 'A');


INSERT INTO lend."user" (id, role_id, email, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO lend."user" (id, role_id, email, password, status) VALUES (default, 2, 'student', '123', 'A');
INSERT INTO lend."user" (id, role_id, email, password, status) VALUES (default, 3, 'company', '123', 'A');

INSERT INTO lend.company_profile (id, user_id, name, registration_number, description, www, address, phone) VALUES (default, 1, 'Apple', '123421341234', 'IT and Communication', null, 'Smith Street Tallinn', '234234234');

INSERT INTO lend.internship (id, company_user_id, title, description, coordinator_name, coordinator_email, status) VALUES (default, 2, 'Kasutaja', 'Testija', 'Mets', 'mets@mail.ee', 'A');

INSERT INTO lend.city (id, name) VALUES (default, 'Tallinn');
INSERT INTO lend.city (id, name) VALUES (default, 'Tartu');
INSERT INTO lend.city (id, name) VALUES (default, 'Narva');
INSERT INTO lend.city (id, name) VALUES (default, 'Pärnu');
INSERT INTO lend.city (id, name) VALUES (default, 'Kohtla-Järve');
INSERT INTO lend.city (id, name) VALUES (default, 'Viljandi');
INSERT INTO lend.city (id, name) VALUES (default, 'Maardu');
INSERT INTO lend.city (id, name) VALUES (default, 'Rakvere');
INSERT INTO lend.city (id, name) VALUES (default, 'Kuressaare');
INSERT INTO lend.city (id, name) VALUES (default, 'Sillamäe');
INSERT INTO lend.city (id, name) VALUES (default, 'Valga');
INSERT INTO lend.city (id, name) VALUES (default, 'Võru');
INSERT INTO lend.city (id, name) VALUES (default, 'Jõhvi');
INSERT INTO lend.city (id, name) VALUES (default, 'Keila');
INSERT INTO lend.city (id, name) VALUES (default, 'Haapsalu');
INSERT INTO lend.city (id, name) VALUES (default, 'Paide');
INSERT INTO lend.city (id, name) VALUES (default, 'Saue');
INSERT INTO lend.city (id, name) VALUES (default, 'Elva');
INSERT INTO lend.city (id, name) VALUES (default, 'Tapa');
INSERT INTO lend.city (id, name) VALUES (default, 'Põlva');
INSERT INTO lend.city (id, name) VALUES (default, 'Türi');
INSERT INTO lend.city (id, name) VALUES (default, 'Rapla');
INSERT INTO lend.city (id, name) VALUES (default, 'Jõgeva');
INSERT INTO lend.city (id, name) VALUES (default, 'Kiviõli');
INSERT INTO lend.city (id, name) VALUES (default, 'Põltsamaa');
INSERT INTO lend.city (id, name) VALUES (default, 'Sindi');
INSERT INTO lend.city (id, name) VALUES (default, 'Paldiski');
INSERT INTO lend.city (id, name) VALUES (default, 'Kärdla');
INSERT INTO lend.city (id, name) VALUES (default, 'Kunda');
INSERT INTO lend.city (id, name) VALUES (default, 'Tõrva');
INSERT INTO lend.city (id, name) VALUES (default, 'Narva-Jõesuu');
INSERT INTO lend.city (id, name) VALUES (default, 'Kehra');
INSERT INTO lend.city (id, name) VALUES (default, 'Loksa');
INSERT INTO lend.city (id, name) VALUES (default, 'Otepää');
INSERT INTO lend.city (id, name) VALUES (default, 'Räpina');
INSERT INTO lend.city (id, name) VALUES (default, 'Tamsalu');
INSERT INTO lend.city (id, name) VALUES (default, 'Kilingi-Nõmme');
INSERT INTO lend.city (id, name) VALUES (default, 'Karksi-Nuia');
INSERT INTO lend.city (id, name) VALUES (default, 'Võhma');
INSERT INTO lend.city (id, name) VALUES (default, 'Antsla');
INSERT INTO lend.city (id, name) VALUES (default, 'Lihula');
INSERT INTO lend.city (id, name) VALUES (default, 'Mustvee');
INSERT INTO lend.city (id, name) VALUES (default, 'Suure-Jaani');
INSERT INTO lend.city (id, name) VALUES (default, 'Abja-Paluoja');
INSERT INTO lend.city (id, name) VALUES (default, 'Püssi');
INSERT INTO lend.city (id, name) VALUES (default, 'Mõisaküla');
INSERT INTO lend.city (id, name) VALUES (default, 'Kallaste');
INSERT INTO lend.city (id, name) VALUES (default, 'Nõmme');
INSERT INTO lend.city (id, name) VALUES (default, 'Petseri');
INSERT INTO lend.city (id, name) VALUES (default, 'Mustla');
INSERT INTO lend.city (id, name) VALUES (default, 'Ahtme');


