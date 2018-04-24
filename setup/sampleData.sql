----------------------------------------------------------------------
-- Create admin account, password is SHA-256 of 'admin'             --
----------------------------------------------------------------------

INSERT INTO user (username, email, password, firstname, lastname, gender, country, is_admin) 
VALUES ('admin', 'admin@pin.net', 'd82494f05d6917ba02f7aaa29689ccb444bb73f20380876cb05d1f37537b7892', 'Louisa', 'Cheong',true, 'Belgium', true);

INSERT INTO user (username, email, password, firstname, lastname, gender, country) 
VALUES ('adrian', 'adrian@gmail.com', 'c23ad6f18412014673b2d04794ca038ef6767fe94afe408dffb775362fe07e68', 'Adrian', 'Watson', false,'Belgium');

INSERT INTO user (username, email, password, firstname, lastname, gender, country) 
VALUES ('arek', 'arkadiusz@gmail.com', '7612af49c66b808e35e52ac425dab238a1bd9c9a9518275e95f3998074e2522a', 'Arkadiusz', 'Ry', false,'Belgium');

INSERT INTO user (username, email, password, firstname, lastname, gender, country) 
VALUES ('abyss', 'abyss@pin.net', '0e062e4c2ee475679d9cfd9cd30c295dec2a0eb7a02ffb0c5b239d2617022a8a', 'Alycia', 'Schmidt',true, 'Belgium');

INSERT INTO user (username, email, password, firstname, lastname, gender, country) 
VALUES ('bobby', 'bobby@pin.net', '69ff8042237aeef5ddf1ced10e851bc6104e1ebb15a304061dba43ea10106fa9', 'Robin','Bellemans', false, 'Belgium');

INSERT INTO user (username, email, password, firstname, lastname, gender, country) 
VALUES ('lmurtfeld', 'louisa@pin.net', 'afbdbfd5b8fbcb65f17a112222b82176077ab234cde34d4062138365951642fa', 'Louisa', 'Murtfeld',true, 'Belgium');



INSERT INTO user_follows_user(isPermitted, follower, personBeingFollowed) 
VALUES (0, 'admin@pin.net', 'louisa@pin.net');

INSERT INTO user_follows_user(isPermitted, follower, personBeingFollowed) 
VALUES (0, 'bobby@pin.net', 'louisa@pin.net');

INSERT INTO user_follows_user(isPermitted, follower, personBeingFollowed) 
VALUES (0, 'louisa@pin.net', 'admin@pin.net');

INSERT INTO topics(name)
VALUES ('Bridal Bouquet');

INSERT INTO topics(name)
VALUES ('Wedding Cake');

INSERT INTO topics(name)
VALUES ('Wedding Dresses and Suits');

INSERT INTO topics(name)
VALUES ('Wedding Locations');

INSERT INTO topics(name)
VALUES ('Wedding Hair');

