INSERT INTO `users` (username, password, email, name, phone, active, deleted) VALUES ('admin', '$10$iQtnm/OOjS3WHvPMVkSQX.0Jikp84MCGNP8BB.3CTNn7lP5sdmh7O', 'admin@mail.com', 'administrador', '+584246266732', 1, 0);
INSERT INTO `users` (username, password, email, name, phone, active, deleted) VALUES ('ronald', '$10$iQtnm/OOjS3WHvPMVkSQX.0Jikp84MCGNP8BB.3CTNn7lP5sdmh7O', 'ronald@mail.com', 'ronald alfonso', '+584246266732', 1, 0);
INSERT INTO `users` (username, password, email, name, phone, active, deleted) VALUES ('alejandro', '$10$iQtnm/OOjS3WHvPMVkSQX.0Jikp84MCGNP8BB.3CTNn7lP5sdmh7O', 'alejandro@mail.com', 'alejandro parra', '+584246266732', 0, 1);

INSERT INTO `roles` (name) VALUES ('ROLE_ADMIN');
INSERT INTO `roles` (name) VALUES ('ROLE_USER');

INSERT INTO `users_to_roles` (user_id, role_id) VALUES (1, 1);
INSERT INTO `users_to_roles` (user_id, role_id) VALUES (2, 2);
INSERT INTO `users_to_roles` (user_id, role_id) VALUES (2, 1);
INSERT INTO `users_to_roles` (user_id, role_id) VALUES (3, 2);
