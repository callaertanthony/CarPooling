INSERT INTO user (email, password_hash, role, first_name, gender, last_name)
VALUES ('demo@localhost', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'ADMIN', NULL , NULL , NULL );


INSERT INTO `user` (`email`, `first_name`, `gender`, `last_name`, `password_hash`, `role`, `picture_path`)
VALUES
  ('nat@cha', 'Nat', 'WOMAN', 'Acha', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'MEMBER', 'woman.gif'),
  ('bruno@marshmal.low', 'Bruno', 'MAN', 'Marshmallow', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'MEMBER', 'Frank.jpg'),
  ('alfred@yeah', 'Alf', 'MAN', 'Fred', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'MEMBER', NULL);

INSERT INTO `city` (`id`, `latitude`, `locality`, `longitude`) VALUES
  (1, 50.6292, 'Lille', 3.05726),
  (2, 48.8566, 'Paris', 2.35222),
  (3, 45.764, 'Lyon', 4.83566);

INSERT INTO `journey` (`id`, `creator_id`) VALUES
(1, 2);

INSERT INTO `step` (`id`, `date_calendar`, `city_id`, `journey_id`) VALUES
(1, '2015-04-09 00:00:00', 1, 1),
(2, '2015-04-09 10:25:33', 4, 1),
(3, '2015-04-09 19:46:45', 2, 1);



