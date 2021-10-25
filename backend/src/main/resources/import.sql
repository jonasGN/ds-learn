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
