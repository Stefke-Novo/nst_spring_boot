insert into department (name,short_name) values ('Department 1','D1');
insert into department (name,short_name) values ('Department 2','D2');
insert into department (name,short_name) values ('Department 3','D3');
insert into department (name,short_name) values ('Department 4','D4');
insert into department (name,short_name) values ('Department 5','D5');

insert into subject (name, espb, department_id) values ('Subject 1', 3, (select id from department where name = 'Department 1'));
insert into subject (name, espb, department_id) values ('Subject 2', 4, (select id from department where name = 'Department 1'));
insert into subject (name, espb, department_id) values ('Subject 3', 5, (select id from department where name = 'Department 2'));
insert into subject (name, espb, department_id) values ('Subject 4', 3, (select id from department where name = 'Department 2'));
insert into subject (name, espb, department_id) values ('Subject 5', 4, (select id from department where name = 'Department 3'));
insert into subject (name, espb, department_id) values ('Subject 6', 5, (select id from department where name = 'Department 3'));
insert into subject (name, espb, department_id) values ('Subject 7', 3, (select id from department where name = 'Department 4'));
insert into subject (name, espb, department_id) values ('Subject 8', 4, (select id from department where name = 'Department 4'));
insert into subject (name, espb, department_id) values ('Subject 9', 5, (select id from department where name = 'Department 5'));
insert into subject (name, espb, department_id) values ('Subject 10', 3, (select id from department where name = 'Department 5'));

insert into education_title (title) values ('Education title 1');
insert into education_title (title) values ('Education title 2');
insert into education_title (title) values ('Education title 3');
insert into education_title (title) values ('Education title 4');
insert into education_title (title) values ('Education title 5');

insert into member ( first_name, last_name, department_id, education_title_id)
values ('First name 1','Last name 1',(select id from department where name='Department 1'), (select id from education_title where title = 'Education title 1'));
insert into member (first_name, last_name, department_id, education_title_id)
values ('First name 2','Last name 2',(select id from department where name='Department 1'), (select id from education_title where title = 'Education title 2'));
insert into member (first_name, last_name, department_id, education_title_id)
values ('First name 3','Last name 3',(select id from department where name='Department 2'), (select id from education_title where title = 'Education title 3'));
insert into member (first_name, last_name, department_id, education_title_id)
values ('First name 4','Last name 4',(select id from department where name='Department 2'), (select id from education_title where title = 'Education title 4'));
insert into member (first_name, last_name, department_id, education_title_id)
values ('First name 5','Last name 5',(select id from department where name='Department 3'), (select id from education_title where title = 'Education title 5'));
insert into member (first_name, last_name, department_id, education_title_id)
values ('First name 6','Last name 6',(select id from department where name='Department 3'), (select id from education_title where title = 'Education title 1'));
insert into member (first_name, last_name, department_id, education_title_id)
values ('First name 7','Last name 7',(select id from department where name='Department 4'), (select id from education_title where title = 'Education title 2'));
insert into member (first_name, last_name, department_id, education_title_id)
values ('First name 8','Last name 8',(select id from department where name='Department 4'), (select id from education_title where title = 'Education title 3'));
insert into member (first_name, last_name, department_id, education_title_id)
values ('First name 9','Last name 9',(select id from department where name='Department 5'), (select id from education_title where title = 'Education title 4'));
insert into member (first_name, last_name, department_id, education_title_id)
values ('First name 10','Last name 10',(select id from department where name='Department 5'), (select id from education_title where title = 'Education title 5'));

insert into head_of_department (id,department_id,member_id) values (1,(select department_id from member where first_name = 'First name 1' and last_name = 'Last name 1'),(select id from member where first_name = 'First name 1' and last_name = 'Last name 1'));
insert into head_of_department (id,department_id,member_id) values (2,(select department_id from member where first_name = 'First name 2' and last_name = 'Last name 2'),(select id from member where first_name = 'First name 2' and last_name = 'Last name 2') );
insert into head_of_department (id,department_id,member_id) values (3,(select department_id from member where first_name = 'First name 3' and last_name = 'Last name 3'), (select id from member where first_name = 'First name 3' and last_name = 'Last name 3'));

insert into department_secretary (id, department_id, member_id) values (1,(select department_id from member where first_name = 'First name 4' and last_name = 'Last name 4'),(select id from member where first_name = 'First name 4' and last_name = 'Last name 4'));
insert into department_secretary (id, department_id, member_id) values (2,(select department_id from member where first_name = 'First name 5' and last_name = 'Last name 5'),(select id from member where first_name = 'First name 5' and last_name = 'Last name 5'));
insert into department_secretary (id, department_id, member_id) values (3,(select department_id from member where first_name = 'First name 6' and last_name = 'Last name 6'),(select id from member where first_name = 'First name 6' and last_name = 'Last name 6'));

insert into academic_title (title) values ('Academic title 1');
insert into academic_title (title) values ('Academic title 2');
insert into academic_title (title) values ('Academic title 3');
insert into academic_title (title) values ('Academic title 4');
insert into academic_title (title) values ('Academic title 5');

insert into scientific_field (name) values ('Scientific field 1');
insert into scientific_field (name) values ('Scientific field 2');
insert into scientific_field (name) values ('Scientific field 3');
insert into scientific_field (name) values ('Scientific field 4');
insert into scientific_field (name) values ('Scientific field 5');

insert into academic_title_history (member_id, academic_title_id, start_date, end_date, scientific_field_id)
values (
(select id from member where first_name = 'First name 4' and last_name = 'Last name 4'),
(select id from academic_title where title = 'Academic title 1'),
'2023-05-29',
'2023-10-29',
(select id from scientific_field where name = 'Scientific field 1'));

insert into academic_title_history (member_id, academic_title_id, start_date, end_date, scientific_field_id)
values (
(select id from member where first_name = 'First name 3' and last_name = 'Last name 3'),
(select id from academic_title where title = 'Academic title 2'),
'2022-05-29',
'2022-10-29',
(select id from scientific_field where name = 'Scientific field 3'));

insert into academic_title_history (member_id, academic_title_id, start_date, end_date, scientific_field_id)
values (
(select id from member where first_name = 'First name 2' and last_name = 'Last name 2'),
(select id from academic_title where title = 'Academic title 4'),
'2021-05-29',
'2021-10-29',
(select id from scientific_field where name = 'Scientific field 4'));

insert into academic_title_history (member_id, academic_title_id, start_date, end_date, scientific_field_id)
values (
(select id from member where first_name = 'First name 1' and last_name = 'Last name 1'),
(select id from academic_title where title = 'Academic title 5'),
'2023-01-15',
'2023-09-23',
(select id from scientific_field where name = 'Scientific field 2'));

insert into academic_title_history (member_id, academic_title_id, start_date, end_date, scientific_field_id)
values (
(select id from member where first_name = 'First name 5' and last_name = 'Last name 5'),
(select id from academic_title where title = 'Academic title 1'),
'2020-05-14',
'2020-10-02',
(select id from scientific_field where name = 'Scientific field 1'));


