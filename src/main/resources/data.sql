
--TB_EVENT
INSERT INTO tb_event (name, description, place, start_date, end_date, start_time, end_time, email) VALUES ('Comic con', 'Evento nerd', 'São Paulo', '2020-04-02', '2020-04-04', '10:30:00', '22:00:00', 'comiccon@gmail.com.br');
INSERT INTO tb_event (name, description, place, start_date, end_date, start_time, end_time, email) VALUES ('BGS', 'Evento gamer', 'São Paulo', '2020-12-01', '2020-12-05', '9:00:00', '22:00:00', 'BGS@gmail.com.br');
INSERT INTO tb_event (name, description, place, start_date, end_date, start_time, end_time, email) VALUES ('Roadsec', 'Evento nacional de hacking, segurança e tecnologia', 'Rio de Janeiro', '2021-07-22', '2021-07-27', '12:00:00', '20:30:00', 'Roadsec@yahoo.com.br');
INSERT INTO tb_event (name, description, place, start_date, end_date, start_time, end_time, email) VALUES ('DefCon', 'Maior conferência para hackers do mundo', 'Las Vegas', '2021-06-20', '2021-06-23', '09:30:00', '20:00:00', 'Defcon@outlook.com');
INSERT INTO tb_event (name, description, place, start_date, end_date, start_time, end_time, email) VALUES ('Anime Fest', 'Evento otaku', 'Campinas', '2021-06-10', '2021-06-13', '11:00:00', '20:30:00', 'Animefest@yahoo.com.br');
INSERT INTO tb_event (name, description, place, start_date, end_date, start_time, end_time, email) VALUES ('Lollapalooza', 'Evento de música indie', 'Chile', '2020-04-06', '2020-04-09', '10:30:00', '22:00:00', 'Lolapalooza@gmail.com');
INSERT INTO tb_event (name, description, place, start_date, end_date, start_time, end_time, email) VALUES ('Tomorrowland', 'Evento de música eletrônica', 'Bélgica', '2020-07-19', '2020-07-28', '09:30:00', '23:30:00', 'tomorrowland@eventfest.com');
INSERT INTO tb_event (name, description, place, start_date, end_date, start_time, end_time, email) VALUES ('Rock in Rio', 'Evento de rock paulera', 'Rio de Janeiro', '2021-10-04', '2021-10-06', '10:30:00', '23:30:00', 'rockinrio@yahoo.com.br');
INSERT INTO tb_event (name, description, place, start_date, end_date, start_time, end_time, email) VALUES ('E3', 'Electronic Entertainment Expo', 'Los Angeles', '2020-06-09', '2020-06-11', '10:30:00', '20:30:00', 'E3@gamerevent.com');
INSERT INTO tb_event (name, description, place, start_date, end_date, start_time, end_time, email) VALUES ('Sculpture Projects Münster', 'Evento de arte', 'Alemanha', '2022-07-10', '2022-08-01', '12:00:00', '20:00:00', 'SculptureMunster@gmail.com');

--TB_PLACE
INSERT INTO tb_place (name, address) VALUES ('Anzu', 'Indaiatuba');

--TB_BASEUSER
INSERT INTO tb_baseuser (name, email) VALUES ('Eduardo', 'edu@edu');
INSERT INTO tb_baseuser (name, email) VALUES ('Frate', 'frate@frate');

--TB_ADMIN
INSERT INTO tb_admin (phone_number, baseuser_id) VALUES ('(11)983661517', 1);

--TB_ATTEND
Insert INTO tb_attend (balance, baseuser_id) VALUES (120.50, 2);