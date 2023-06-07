INSERT INTO ROLE(ROLE) VALUES ('ROLE_ADMIN');
INSERT INTO ROLE(ROLE) VALUES ('ROLE_STUDENT');

insert into client(EMAIL, LOGIN, NAME, PASSWORD) values ('email1', 'thalyson', 'name1', '$2a$12$wtHu.7I/jlGNzCu1CBunueEFtc5GjLI21.XLYpbWTmfJJmfYIHPJq');
INSERT INTO CLIENT_ROLE(CLIENT_ID, ROLE_ID) VALUES (1, 1);

insert into client(EMAIL, LOGIN, NAME, PASSWORD) values ('email2', 'saulo', 'name2', '$2a$12$wtHu.7I/jlGNzCu1CBunueEFtc5GjLI21.XLYpbWTmfJJmfYIHPJq');
INSERT INTO CLIENT_ROLE(CLIENT_ID, ROLE_ID) VALUES (2, 2);

insert into client(EMAIL, LOGIN, NAME, PASSWORD) values ('email3', 'adriano', 'name3', '$2a$12$wtHu.7I/jlGNzCu1CBunueEFtc5GjLI21.XLYpbWTmfJJmfYIHPJq');
INSERT INTO CLIENT_ROLE(CLIENT_ID, ROLE_ID) VALUES (3, 2);

insert into box(NAME, CAPACITY, CREATED_BY) values ('Box do Saulo', 50, 'Saulo');
insert into box(NAME, CAPACITY, CREATED_BY) values ('Box do Thiago', 40, 'Thiago');
insert into box(NAME, CAPACITY, CREATED_BY) values ('Box do Adriano', 25, 'Adriano');

insert into student(CLIENT_ID) values (1);
insert into student(CLIENT_ID) values (2);
insert into student(CLIENT_ID) values (3);

insert into team(SCHEDULE, BOX_ID) values ('35_16', 1);
insert into team(SCHEDULE, BOX_ID) values ('35_17', 1);
insert into team(SCHEDULE, BOX_ID) values ('35_18', 1);

insert into enrollment(TEAM_ID, STUDENT_ID) values (1, 2)
insert into enrollment(TEAM_ID, STUDENT_ID) values (2, 2)
insert into enrollment(TEAM_ID, STUDENT_ID) values (3, 2)
insert into enrollment(TEAM_ID, STUDENT_ID) values (1, 3)