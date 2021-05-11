INSERT INTO tb_specialty (name, description, is_active) VALUES ('Clínico Geral', 'Geral', false);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Angiologia', 'Doenças vasculares como vasos sanguíneos e linfáticos', true);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Dermatologia', 'Doenças da pele', true);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Cardiologia', 'Doenças do Coração', true);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Gastroenterologia', 'Doenças do estômago', true);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Otorrinolaringologia', 'Nariz, garganta, ouvidos', true);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Pneumologia', 'Pulmões', true);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Pediatria', 'Crianças', true);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Nefrologia', 'Nervos', true);
INSERT INTO tb_specialty (name, description, is_active) VALUES ('Neurologia', 'Cérebro', true);

INSERT INTO tb_doctor (name, birth_date, is_active) VALUES ('João Felipe', '1980-10-10', true);
INSERT INTO tb_doctor (name, birth_date, is_active) VALUES ('Janaina Souza', '1978-05-22', false);
INSERT INTO tb_doctor (name, birth_date, is_active) VALUES ('Raimundo Girão', '1990-03-02', true);
INSERT INTO tb_doctor (name, birth_date, is_active) VALUES ('Lisontro Souza', '1962-07-18', true);

INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (1, 1);
INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (1, 6);
INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (2, 1);
INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (2, 5);
INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (2, 6);
INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (3, 3);
INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (3, 4);
INSERT INTO tb_doctor_specialty (doctor_id, specialty_id) VALUES (4, 1);
