create table tb_doctor (id int8 generated by default as identity, birth_date timestamp, is_active boolean not null, name varchar(255), primary key (id));
create table tb_doctor_specialty (doctor_id int8 not null, specialty_id int8 not null, primary key (doctor_id, specialty_id));
create table tb_specialty (id int8 generated by default as identity, description TEXT, is_active boolean not null, name varchar(255), primary key (id));
alter table if exists tb_doctor_specialty add constraint FKi8xtene99bf93rc9ukxciimka foreign key (specialty_id) references tb_specialty;
alter table if exists tb_doctor_specialty add constraint FKm0tqfr3godb6irtt1g29bamwt foreign key (doctor_id) references tb_doctor;
