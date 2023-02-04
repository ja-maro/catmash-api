SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE cats;

INSERT INTO cats(popularity,creation_date,picture,json_id) VALUES (3,'2023-01-30 14:45:05','http://25.media.tumblr.com/tumblr_m4bgd9OXmw1qioo2oo1_500.jpg','bmp');
INSERT INTO cats(popularity,creation_date,picture,json_id) VALUES (1,'2023-01-30 14:45:05','http://25.media.tumblr.com/tumblr_m33r7lpy361qzi9p6o1_500.jpg','3kj');
INSERT INTO cats(popularity,creation_date,picture,json_id) VALUES (4,'2023-01-30 14:45:05','http://24.media.tumblr.com/tumblr_m29a9d62C81r2rj8po1_500.jpg','tt');
INSERT INTO cats(popularity,creation_date,picture,json_id) VALUES (10,'2023-01-30 14:45:05','http://24.media.tumblr.com/tumblr_m82woaL5AD1rro1o5o1_1280.jpg','MTgwODA3MA');
INSERT INTO cats(creation_date,picture,json_id) VALUES ('2023-01-30 14:45:05','http://25.media.tumblr.com/tumblr_m2p6dxhxul1qdvz31o1_500.jpg','9pu');
INSERT INTO cats(popularity,creation_date,picture,json_id) VALUES (2,'2023-01-30 14:45:05','http://24.media.tumblr.com/tumblr_lzxok2e2kX1qgjltdo1_1280.jpg','c8a');

SET FOREIGN_KEY_CHECKS = 1;