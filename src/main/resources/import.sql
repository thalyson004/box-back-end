insert into client(EMAIL, LOGIN, NAME, PASSWORD) values ('email1', 'login1', 'name1', 'password1');
insert into client(EMAIL, LOGIN, NAME, PASSWORD) values ('email2', 'login2', 'name2', 'password2');
insert into client(EMAIL, LOGIN, NAME, PASSWORD) values ('email3', 'login3', 'name3', 'password3');

insert into box(NAME, CAPACITY, CREATED_BY) values ('Box do Saulo', 50, 'Saulo');
insert into box(NAME, CAPACITY, CREATED_BY) values ('Box do Thiago', 40, 'Thiago');
insert into box(NAME, CAPACITY, CREATED_BY) values ('Box do Adriano', 25, 'Adriano');

insert into student(CLIENT_ID) values (1);
insert into student(CLIENT_ID) values (2);
insert into student(CLIENT_ID) values (3);

insert into team(SCHEDULE, BOX_ID) values ('35_16', 1);
insert into team(SCHEDULE, BOX_ID) values ('35_17', 1);
insert into team(SCHEDULE, BOX_ID) values ('35_18', 1);