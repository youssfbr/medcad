INSERT INTO tb_specialty (name, description, is_active) VALUES ('Clínico Geral', 'Geral', 0);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Angiologia', 'Doenças vasculares como vasos sanguíneos e linfáticos', 1);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Dermatologia', 'Doenças da pele', 1);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Cardiologia', 'Doenças do Coração', 1);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Gastroenterologia', 'Doenças do estômago',1);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Otorrinolaringologia', 'Nariz, garganta, ouvidos',1);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Pneumologia', 'Pulmões',1);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Pediatria', 'Crianças',1);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Nefrologia', 'Nervos',1);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Neurologia', 'Cérebro',1);

INSERT INTO tb_doctor (name, birth_date, is_active) VALUES ('João Felipe', '1980-10-10', 1);
INSERT INTO tb_doctor (name, birth_date, is_active) VALUES ('Janaina Souza', '1978-05-22', 0);
INSERT INTO tb_doctor (name, birth_date, is_active) VALUES ('Raimundo Girão', '1990-03-02', 1);
INSERT INTO tb_doctor (name, birth_date, is_active) VALUES ('Lisontro Souza', '1962-07-18', 1);

INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (1, 1);
INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (1, 6);
INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (2, 1);
INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (2, 5);
INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (2, 6);
INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (3, 3);
INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (3, 4);
INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (4, 1);
