create table member(
id bigint unsigned not null AUTO_INCREMENT,
first_name varchar(200) not null,
last_name varchar(200) not null,
academic_title bigint not null,
education_title bigint not null,
scientific_field bigint not null,
constraint foreign key academic_title references academic_title(id),
);