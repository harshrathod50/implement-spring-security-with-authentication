SELECT 'MySQL Database';

INSERT IGNORE INTO user (`first_name`, `last_name`, `email`, `password`, `date_modified`, `date_created`) VALUES ('Harsh', 'Rathod', 'hrathore50@ymail.com', '{bcrypt}$2a$10$pqyOpq60OHBFWqWLBy489OIrnEZoNgLz3jJBf2eSVznTnhgy4/aTy', NOW(), NOW());
