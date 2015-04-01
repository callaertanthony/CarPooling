INSERT INTO user (email, password_hash, role, first_name, gender, last_name)
VALUES ('demo@localhost', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'ADMIN', NULL , NULL , NULL );

INSERT INTO city (name)
VALUES
('Lille'),
('Paris'),
('Marseille'),
('Lyon');

INSERT INTO `step` (`id`, `date`, `city_id`, `journey_id`) VALUES
  (1, '2015-04-02 00:00:00', 1, 1),
  (2, '2015-04-03 08:42:53', 2, 1),
  (3, '2015-04-23 09:43:31', 4, 1);
