--liquibase formatted sql

--changeset sbt-eltyshev-vs:1
create table persons (
    id int NOT NULL AUTO_INCREMENT,
    employeeNumber int NOT NULL UNIQUE,
    name varchar(255),
    surName varchar(255),
    lastName varchar(255),
    birthDate DATE,
    city varchar(255),
    postalCode varchar(255),
    email varchar(255),
    phoneNumber varchar(255),
    PRIMARY KEY (id)
);

--rollback drop table persons;

--changeset sbt-eltyshev-vs:2
insert into persons (id, employeeNumber, name, surName, lastName, birthDate, city, postalCode, email, phoneNumber)
values ('1', '1223', 'Vit', 'Serg', 'Elt', STR_TO_DATE('1986-11-03', '%Y-%m-%d'), 'Moscow', '1234567', 'ss1@gmail', '+7123456789');
insert into persons (id, employeeNumber, name, surName, lastName, birthDate, city, postalCode, email, phoneNumber)
values ('2', '1456', 'Serg', 'Stanisl', 'Petrov', STR_TO_DATE('1999-01-07', '%Y-%m-%d'), 'Tula', '3234567', 'sddw@gmail', '+7123459989');
insert into persons (id, employeeNumber, name, surName, lastName, birthDate, city, postalCode, email, phoneNumber)
values ('3', '5345', 'Alex', 'Petr', 'JT', STR_TO_DATE('1999-06-23', '%Y-%m-%d'), 'New York', '1234560', 'sdfds@mail', '+7123455789');
insert into persons (id, employeeNumber, name, surName, lastName, birthDate, city, postalCode, email, phoneNumber)
values ('4', '6897', 'Tom', 'Jr', 'Barkley', STR_TO_DATE('1987-11-13', '%Y-%m-%d'), 'Perm', '1234599','gfdfd@mail', '+7123499789');
commit;

--changeset sbt-eltyshev-vs:3
insert into persons (id, employeeNumber, name, surName, lastName, birthDate, city, postalCode, email, phoneNumber)
values ('5', '1073', 'Bill', 'Phillipovch', 'Murray', STR_TO_DATE('1955-12-03', '%Y-%m-%d'), 'Zlatoust', '1231167','1234@gmail', '+7003456789');
insert into persons (id, employeeNumber, name, surName, lastName, birthDate, city, postalCode, email, phoneNumber)
values ('6', '4793', 'Nikita', 'Termit', 'Gelio', STR_TO_DATE('1936-11-04', '%Y-%m-%d'), 'Eburg', '1230087', 'fdf@gmail', '+7123442789');
insert into persons (id, employeeNumber, name, surName, lastName, birthDate, city, postalCode, email, phoneNumber)
values ('7', '1689', 'Slava', 'Ctanis', 'Popov', STR_TO_DATE('1991-04-07', '%Y-%m-%d'), 'Nursultan', '1234534', 'dffdf@gmail','+7128756789');
insert into persons (id, employeeNumber, name, surName, lastName, birthDate, city, postalCode, email, phoneNumber)
values ('8', '9999', 'Clark', 'Nemov', 'Rudko', STR_TO_DATE('1977-09-07', '%Y-%m-%d'), 'Nursultan', '1236667', 'dfdf@gmail', '+7123676789');
commit;
