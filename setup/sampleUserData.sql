----------------------------------------------------------------------
-- Create admin account, password is SHA-256 of 'admin'             --
----------------------------------------------------------------------

INSERT INTO user (username, email, password, firstname, lastname, gender, country) 
VALUES ('admin', 'admin@pin.net', 'd82494f05d6917ba02f7aaa29689ccb444bb73f20380876cb05d1f37537b7892', 'Louisa', 'Cheong',true, 'Belgium');

INSERT INTO user (username, email, password, firstname, lastname, gender) 
VALUES ('adrian', 'adrian@gmail.com', 'c23ad6f18412014673b2d04794ca038ef6767fe94afe408dffb775362fe07e68', 'Adrian', 'Watson', false,'Belgium');

INSERT INTO user (username, email, password, firstname, lastname, gender) 
VALUES ('arek', 'arkadiusz@gmail.com', 'c7612af49c66b808e35e52ac425dab238a1bd9c9a9518275e95f3998074e2522a', 'Arkadiusz', 'Ry', false,'Belgium');

INSERT INTO user (username, email, password, firstname, lastname, gender) 
VALUES ('abyss', 'abyss@pin.net', '0e062e4c2ee475679d9cfd9cd30c295dec2a0eb7a02ffb0c5b239d2617022a8a', 'Alycia', 'Schmidt',true, 'Belgium');
