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

INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07Z', TIMESTAMP WITH TIME ZONE '2021-07-13T20:50:07Z', 1);
INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('2.0', TIMESTAMP WITH TIME ZONE '2021-07-13T20:50:07Z', TIMESTAMP WITH TIME ZONE '2022-07-13T20:50:07Z', 2);
INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('3.0', TIMESTAMP WITH TIME ZONE '2022-07-13T20:50:07Z', TIMESTAMP WITH TIME ZONE '2023-07-13T20:50:07Z', 3);
INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('4.0', TIMESTAMP WITH TIME ZONE '2024-07-13T20:50:07Z', TIMESTAMP WITH TIME ZONE '2025-07-13T20:50:07Z', 4);

INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('Trila de aprendizado', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 1, 'https://resource-img', 1, 2);

INSERT INTO tb_section (title, description, position, img_uri, prerequisite_id, resource_id) VALUES ('Capitulo 01', 'O início de tudo', 1, 'https://img-url', null, 1);
INSERT INTO tb_section (title, description, position, img_uri, prerequisite_id, resource_id) VALUES ('Capitulo 02', 'Instalando ferramentas', 2, 'https://img-url', 1, 1);

INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, available, only_update) VALUES (2, 1, TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07Z', null, true, false);
INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, available, only_update) VALUES (2, 2, TIMESTAMP WITH TIME ZONE '2021-07-13T20:50:07Z', null, true, false);
INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, available, only_update) VALUES (4, 2, TIMESTAMP WITH TIME ZONE '2021-07-13T20:50:07Z', null, true, true);
INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, available, only_update) VALUES (4, 3, TIMESTAMP WITH TIME ZONE '2021-07-13T20:50:07Z', TIMESTAMP WITH TIME ZONE '2021-08-12T20:50:07Z', false, false);

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 01 - Capitulo 1', 1, 1);
INSERT INTO tb_content (id, text_content, video_uri) VALUES (1, '', 'https://www.youtube.com/');

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 02 - Capitulo 1', 2, 1);
INSERT INTO tb_content (id, text_content, video_uri) VALUES (2, '', 'https://www.youtube.com/');

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Tarefa 01 - Capitulo 1', 3, 1);
INSERT INTO tb_task (id, description, question_count, approval_count, weight, due_date) VALUES (3, 'Tarefa de aprovação 01', 5, 4, 1.0, TIMESTAMP WITH TIME ZONE '2020-07-30T20:50:07Z');

INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id) VALUES (1, 2, 2);
