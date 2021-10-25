INSERT INTO tb_user (name, email, password) VALUES ('James Bond', 'james@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Alan Turing', 'alan@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Mariela Franco', 'mariela@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Junior Dias', 'junior@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 3);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 3);

INSERT INTO tb_course (name, img_uri, img_gray_uri) VALUES ('Spring React 1.0', 'https://spring-react-img', 'https://spring-react-img-gray');
INSERT INTO tb_course (name, img_uri, img_gray_uri) VALUES ('Spring React 2.0', 'https://spring-react-img', 'https://spring-react-img-gray');
INSERT INTO tb_course (name, img_uri, img_gray_uri) VALUES ('Spring React 3.0', 'https://spring-react-img', 'https://spring-react-img-gray');
INSERT INTO tb_course (name, img_uri, img_gray_uri) VALUES ('Spring React Definitivo', 'https://spring-react-img', 'https://spring-react-img-gray');

INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '2021-07-13T20:50:07.12345Z', 1);
INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('2.0', TIMESTAMP WITH TIME ZONE '2021-07-13T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '2022-07-13T20:50:07.12345Z', 2);
INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('3.0', TIMESTAMP WITH TIME ZONE '2022-07-13T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '2023-07-13T20:50:07.12345Z', 3);
INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('4.0', TIMESTAMP WITH TIME ZONE '2024-07-13T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '2025-07-13T20:50:07.12345Z', 4);

