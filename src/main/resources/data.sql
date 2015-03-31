INSERT INTO user (email, password_hash, role, first_name, gender, last_name, picture_path)
VALUES ('demo@localhost', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'ADMIN', 'Demo' , 'Localhost' , NULL, 'man.gif' );


INSERT INTO `note` (`id`, `note`) VALUES (1, 0), (2, 1), (3, 2), (4, 3), (5, 4), (6, 5);

INSERT INTO `carpooling`.`user_note` (`user_id`, `note_id`) VALUES ('82', '3'), ('82', '3');

INSERT INTO `user` (`email`, `first_name`, `gender`, `last_name`, `password_hash`, `role`, `picture_path`)
VALUES
('nat@cha', 'Nat', 'WOMAN', 'Acha', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'MEMBER', 'woman.gif'),
('bruno@marshmal.low', 'Bruno', 'MAN', 'Marshmallow', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'MEMBER', 'Frank.jpg'),
('alfred@yeah', 'Alf', 'MAN', 'Fred', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'MEMBER', NULL);