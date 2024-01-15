-- H2 2.2.224; 
SET DB_CLOSE_DELAY -1;         
;              
CREATE USER IF NOT EXISTS "JH" SALT 'b0bec3d4a9b9ae7d' HASH '5aeea8a6fb83d88ba579e1903a727c1ed4893722cc3ca9b1ce089ac01e9bc1ce' ADMIN;          
CREATE CACHED TABLE "PUBLIC"."DATABASECHANGELOG"(
    "ID" CHARACTER VARYING(255) NOT NULL,
    "AUTHOR" CHARACTER VARYING(255) NOT NULL,
    "FILENAME" CHARACTER VARYING(255) NOT NULL,
    "DATEEXECUTED" TIMESTAMP NOT NULL,
    "ORDEREXECUTED" INTEGER NOT NULL,
    "EXECTYPE" CHARACTER VARYING(10) NOT NULL,
    "MD5SUM" CHARACTER VARYING(35),
    "DESCRIPTION" CHARACTER VARYING(255),
    "COMMENTS" CHARACTER VARYING(255),
    "TAG" CHARACTER VARYING(255),
    "LIQUIBASE" CHARACTER VARYING(20),
    "CONTEXTS" CHARACTER VARYING(255),
    "LABELS" CHARACTER VARYING(255),
    "DEPLOYMENT_ID" CHARACTER VARYING(10)
);   
-- 17 +/- SELECT COUNT(*) FROM PUBLIC.DATABASECHANGELOG;       
INSERT INTO "PUBLIC"."DATABASECHANGELOG" VALUES
('00000000000001', 'jhipster', 'config/liquibase/changelog/00000000000000_initial_schema.xml', TIMESTAMP '2024-01-08 10:12:11.391428', 1, 'EXECUTED', '9:3d15ce8389bddb1666f01b768d03e89b', 'createTable tableName=jhi_user; createTable tableName=jhi_authority; createTable tableName=jhi_user_authority; addPrimaryKey tableName=jhi_user_authority; addForeignKeyConstraint baseTableName=jhi_user_authority, constraintName=fk_authority_name, ...', '', NULL, '4.24.0', NULL, NULL, '4726731318'),
('20240108151016-1', 'jhipster', 'config/liquibase/changelog/20240108151016_added_entity_UserProfile.xml', TIMESTAMP '2024-01-08 10:14:08.169852', 2, 'EXECUTED', '9:c65f8c4302489b0d67ae2445a3414c4a', 'createTable tableName=user_profile', '', NULL, '4.24.0', NULL, NULL, '4726848137'),
('20240108151016-1-data', 'jhipster', 'config/liquibase/changelog/20240108151016_added_entity_UserProfile.xml', TIMESTAMP '2024-01-08 10:14:08.188522', 3, 'EXECUTED', '9:e34a08fc12addfa83c8696a12957de27', 'loadData tableName=user_profile', '', NULL, '4.24.0', 'faker', NULL, '4726848137'),
('20240108151116-1', 'jhipster', 'config/liquibase/changelog/20240108151116_added_entity_Video.xml', TIMESTAMP '2024-01-08 10:14:08.191821', 4, 'EXECUTED', '9:cec17a401ba262ff6279e824f102fc68', 'createTable tableName=video', '', NULL, '4.24.0', NULL, NULL, '4726848137'),
('20240108151116-1-data', 'jhipster', 'config/liquibase/changelog/20240108151116_added_entity_Video.xml', TIMESTAMP '2024-01-08 10:14:08.197028', 5, 'EXECUTED', '9:6eba8e69a2b5d14b09aa38c4b9229de9', 'loadData tableName=video', '', NULL, '4.24.0', 'faker', NULL, '4726848137'),
('20240108151216-1', 'jhipster', 'config/liquibase/changelog/20240108151216_added_entity_Playlist.xml', TIMESTAMP '2024-01-08 10:14:08.200625', 6, 'EXECUTED', '9:c775c5cf1c425fdb9c673a27fa0eb952', 'createTable tableName=playlist', '', NULL, '4.24.0', NULL, NULL, '4726848137'),
('20240108151216-1-relations', 'jhipster', 'config/liquibase/changelog/20240108151216_added_entity_Playlist.xml', TIMESTAMP '2024-01-08 10:14:08.203872', 7, 'EXECUTED', '9:67e5681d406a280b6ca828653490f81b', 'createTable tableName=rel_playlist__videos; addPrimaryKey tableName=rel_playlist__videos', '', NULL, '4.24.0', NULL, NULL, '4726848137'),
('20240108151216-1-data', 'jhipster', 'config/liquibase/changelog/20240108151216_added_entity_Playlist.xml', TIMESTAMP '2024-01-08 10:14:08.206749', 8, 'EXECUTED', '9:acb25ef0debdb0e40cbcc4c6243dc14a', 'loadData tableName=playlist', '', NULL, '4.24.0', 'faker', NULL, '4726848137'),
('20240108151316-1', 'jhipster', 'config/liquibase/changelog/20240108151316_added_entity_Comment.xml', TIMESTAMP '2024-01-08 10:14:08.20923', 9, 'EXECUTED', '9:a4abf60c31766d918bc488d65b09b359', 'createTable tableName=comment', '', NULL, '4.24.0', NULL, NULL, '4726848137'),
('20240108151316-1-data', 'jhipster', 'config/liquibase/changelog/20240108151316_added_entity_Comment.xml', TIMESTAMP '2024-01-08 10:14:08.212065', 10, 'EXECUTED', '9:6305f40eedf6ac73350aa44d5c30ff03', 'loadData tableName=comment', '', NULL, '4.24.0', 'faker', NULL, '4726848137'),
('20240108151416-1', 'jhipster', 'config/liquibase/changelog/20240108151416_added_entity_Category.xml', TIMESTAMP '2024-01-08 10:14:08.214811', 11, 'EXECUTED', '9:e5c68d8e1ef3d9e55239a966ed04ec67', 'createTable tableName=category', '', NULL, '4.24.0', NULL, NULL, '4726848137'),
('20240108151416-1-relations', 'jhipster', 'config/liquibase/changelog/20240108151416_added_entity_Category.xml', TIMESTAMP '2024-01-08 10:14:08.217414', 12, 'EXECUTED', '9:05195c6ecae7ac40de9a9c5eb6157518', 'createTable tableName=rel_category__videos; addPrimaryKey tableName=rel_category__videos', '', NULL, '4.24.0', NULL, NULL, '4726848137'),
('20240108151416-1-data', 'jhipster', 'config/liquibase/changelog/20240108151416_added_entity_Category.xml', TIMESTAMP '2024-01-08 10:14:08.219882', 13, 'EXECUTED', '9:a4b3622e1341399342efc10f48b96199', 'loadData tableName=category', '', NULL, '4.24.0', 'faker', NULL, '4726848137'),
('20240108151016-2', 'jhipster', 'config/liquibase/changelog/20240108151016_added_entity_constraints_UserProfile.xml', TIMESTAMP '2024-01-08 10:14:08.22411', 14, 'EXECUTED', '9:54bce104c0e8495f908ac6cea3d9963e', 'addForeignKeyConstraint baseTableName=user_profile, constraintName=fk_user_profile__playlist_id, referencedTableName=playlist', '', NULL, '4.24.0', NULL, NULL, '4726848137');         
INSERT INTO "PUBLIC"."DATABASECHANGELOG" VALUES
('20240108151216-2', 'jhipster', 'config/liquibase/changelog/20240108151216_added_entity_constraints_Playlist.xml', TIMESTAMP '2024-01-08 10:14:08.234716', 15, 'EXECUTED', '9:cce575eb0a42d727b0ea91a2130ec7be', 'addForeignKeyConstraint baseTableName=rel_playlist__videos, constraintName=fk_rel_playlist__videos__playlist_id, referencedTableName=playlist; addForeignKeyConstraint baseTableName=rel_playlist__videos, constraintName=fk_rel_playlist__videos__vide...', '', NULL, '4.24.0', NULL, NULL, '4726848137'),
('20240108151316-2', 'jhipster', 'config/liquibase/changelog/20240108151316_added_entity_constraints_Comment.xml', TIMESTAMP '2024-01-08 10:14:08.241457', 16, 'EXECUTED', '9:f9b5a076442334188d34a1393c7e79ac', 'addForeignKeyConstraint baseTableName=comment, constraintName=fk_comment__video_id, referencedTableName=video; addForeignKeyConstraint baseTableName=comment, constraintName=fk_comment__posted_by_id, referencedTableName=user_profile', '', NULL, '4.24.0', NULL, NULL, '4726848137'),
('20240108151416-2', 'jhipster', 'config/liquibase/changelog/20240108151416_added_entity_constraints_Category.xml', TIMESTAMP '2024-01-08 10:14:08.247148', 17, 'EXECUTED', '9:b698ab70f37529158d0b5db62227f8af', 'addForeignKeyConstraint baseTableName=rel_category__videos, constraintName=fk_rel_category__videos__category_id, referencedTableName=category; addForeignKeyConstraint baseTableName=rel_category__videos, constraintName=fk_rel_category__videos__vide...', '', NULL, '4.24.0', NULL, NULL, '4726848137');       
CREATE CACHED TABLE "PUBLIC"."DATABASECHANGELOGLOCK"(
    "ID" INTEGER NOT NULL,
    "LOCKED" BOOLEAN NOT NULL,
    "LOCKGRANTED" TIMESTAMP,
    "LOCKEDBY" CHARACTER VARYING(255)
);          
ALTER TABLE "PUBLIC"."DATABASECHANGELOGLOCK" ADD CONSTRAINT "PUBLIC"."PK_DATABASECHANGELOGLOCK" PRIMARY KEY("ID");             
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.DATABASECHANGELOGLOCK;    
INSERT INTO "PUBLIC"."DATABASECHANGELOGLOCK" VALUES
(1, FALSE, NULL, NULL);    
CREATE CACHED TABLE "PUBLIC"."JHI_USER"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1050) DEFAULT ON NULL NOT NULL,
    "LOGIN" CHARACTER VARYING(50) NOT NULL,
    "PASSWORD_HASH" CHARACTER VARYING(60) NOT NULL,
    "FIRST_NAME" CHARACTER VARYING(50),
    "LAST_NAME" CHARACTER VARYING(50),
    "EMAIL" CHARACTER VARYING(191),
    "IMAGE_URL" CHARACTER VARYING(256),
    "ACTIVATED" BOOLEAN NOT NULL,
    "LANG_KEY" CHARACTER VARYING(10),
    "ACTIVATION_KEY" CHARACTER VARYING(20),
    "RESET_KEY" CHARACTER VARYING(20),
    "CREATED_BY" CHARACTER VARYING(50) NOT NULL,
    "CREATED_DATE" TIMESTAMP DEFAULT NULL,
    "RESET_DATE" TIMESTAMP,
    "LAST_MODIFIED_BY" CHARACTER VARYING(50),
    "LAST_MODIFIED_DATE" TIMESTAMP
);         
ALTER TABLE "PUBLIC"."JHI_USER" ADD CONSTRAINT "PUBLIC"."PK_JHI_USER" PRIMARY KEY("ID");       
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.JHI_USER; 
INSERT INTO "PUBLIC"."JHI_USER" VALUES
(1, 'admin', '$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC', 'Administrator', 'Administrator', 'admin@localhost', '', TRUE, 'en', NULL, NULL, 'system', NULL, NULL, 'system', NULL),
(2, 'user', '$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K', 'User', 'User', 'user@localhost', '', TRUE, 'en', NULL, NULL, 'system', NULL, NULL, 'system', NULL);   
CREATE CACHED TABLE "PUBLIC"."JHI_AUTHORITY"(
    "NAME" CHARACTER VARYING(50) NOT NULL
);     
ALTER TABLE "PUBLIC"."JHI_AUTHORITY" ADD CONSTRAINT "PUBLIC"."PK_JHI_AUTHORITY" PRIMARY KEY("NAME");           
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.JHI_AUTHORITY;            
INSERT INTO "PUBLIC"."JHI_AUTHORITY" VALUES
('ROLE_ADMIN'),
('ROLE_USER');     
CREATE CACHED TABLE "PUBLIC"."JHI_USER_AUTHORITY"(
    "USER_ID" BIGINT NOT NULL,
    "AUTHORITY_NAME" CHARACTER VARYING(50) NOT NULL
);       
ALTER TABLE "PUBLIC"."JHI_USER_AUTHORITY" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_E" PRIMARY KEY("USER_ID", "AUTHORITY_NAME");     
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.JHI_USER_AUTHORITY;       
INSERT INTO "PUBLIC"."JHI_USER_AUTHORITY" VALUES
(1, 'ROLE_ADMIN'),
(1, 'ROLE_USER'),
(2, 'ROLE_USER');        
CREATE CACHED TABLE "PUBLIC"."USER_PROFILE"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1500) DEFAULT ON NULL NOT NULL,
    "USER_NAME" CHARACTER VARYING(255),
    "FIRST_NAME" CHARACTER VARYING(255),
    "LAST_NAME" CHARACTER VARYING(255),
    "EMAIL" CHARACTER VARYING(255),
    "PLAYLIST_ID" BIGINT
);              
ALTER TABLE "PUBLIC"."USER_PROFILE" ADD CONSTRAINT "PUBLIC"."PK_USER_PROFILE" PRIMARY KEY("ID");               
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.USER_PROFILE;             
INSERT INTO "PUBLIC"."USER_PROFILE" VALUES
(1, 'Error404', 'Cesily', 'Waters', 'ceslondon96@icloud.com', 1),
(2, 'TevTag', 'Tevin', 'Glover', 'tevwork.tg@gmail.com', 2),
(3, 'BetaLoc', 'Loc', 'Pham', 'beta.locpham@gmail.com', 3);          
CREATE CACHED TABLE "PUBLIC"."VIDEO"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1500 RESTART WITH 1522) DEFAULT ON NULL NOT NULL,
    "TITLE" CHARACTER VARYING(255),
    "DESCRIPTION" CHARACTER VARYING(255),
    "RELEASE_YEAR" INTEGER,
    "CLASSIFICATION" CHARACTER VARYING(255),
    "DURATION" INTEGER,
    "EPISODE" INTEGER,
    "SEASON" INTEGER,
    "RATING" CHARACTER VARYING(255),
    "VIDEO_URL" CHARACTER VARYING(255)
); 
ALTER TABLE "PUBLIC"."VIDEO" ADD CONSTRAINT "PUBLIC"."PK_VIDEO" PRIMARY KEY("ID");             
-- 31 +/- SELECT COUNT(*) FROM PUBLIC.VIDEO;   
INSERT INTO "PUBLIC"."VIDEO" VALUES
(1, 'Power', 'James "Ghost" St. Patrick, a wealthy New York nightclub owner who has it all; dreaming big, catering to the city''s elite, and living a double life as a drug kingpin.', 2014, 'TV Series', 58, 63, 6, 'TV_MA', ''),
(2, 'Run The World', U&'The story of a group of Black women \2013 vibrant, fiercely loyal best friends \2013 who work, live and play in Harlem as they strive for world domination.', 2021, 'TV Series', 26, 16, 2, 'TV_MA', ''),
(3, 'Courage The Cowardly Dog', 'A cowardly dog who must overcome his own fears to heroically defend his unknowing farmer owners from all kinds of dangers, paranormal events and menaces that appear around their land.', 1999, 'TV Series', 22, 52, 4, 'TV_Y7', ''),
(4, 'Kenan & Kel', 'Kenan and Kel: two best friends who live in Chicago are always dragged down by Kenan''s get rich quick schemes while orange soda-loving buddy Kel is dragged along but tends to mess things up.', 1996, 'TV Series', 24, 65, 4, 'G', ''),
(5, 'Baki', 'The protagonist, Baki Hanma, trains with an intense focus to become strong enough to surpass his father, Yujiro Hanma, the strongest fighter in the world.', 2018, 'TV Series', 43, 39, 2, 'TV_MA', ''),
(6, 'The Walking Dead', 'Sheriff Deputy Rick Grimes wakes up from a coma to learn the world is in ruins and must lead a group of survivors to stay alive.', 2010, 'TV Series', 44, 177, 11, 'TV_MA', ''),
(7, 'Titanic ', 'A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.', 1996, 'Movie', 195, 0, 0, 'PG13', ''),
(8, 'Drumline', 'A band director recruits an ego driven Harlem drummer to play at a Southern university.', 2002, 'Movie', 120, 0, 0, 'PG13', ''),
(9, 'Law Abiding Citizen', 'A frustrated man decides to take justice into his own hands after a plea bargain sets one of his family''s killers free.', 2009, 'Movie', 118, 0, 0, 'R', ''),
(10, 'Toy Story ', 'A cowboy doll is profoundly threatened and jealous when a new spaceman action figure supplants him as top toy in a boy''s bedroom.', 1995, 'Movie', 81, 0, 0, 'G', ''),
(1500, 'The Santa Claus 3: The Escape Clause', 'Santa, a.k.a. Scott Calvin, is faced with double-duty: how to keep his new family happy and how to stop Jack Frost from taking over Christmas.', 2006, 'Movie', 92, 0, 0, 'G', ''),
(1501, 'The Wolf of Wall Street ', 'Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.', 2013, 'Movie', 0, 0, 0, 'R', ''),
(1502, 'IT ', 'Set in Derry, Maine. The film tells the story of The Losers'' Club , a group of seven outcast children who are terrorized by the eponymous being which emerges from the sewer , only to face their own personal demons in the process.', 2017, 'Movie', 135, 0, 0, 'R', ''),
(1503, 'The Boondock Saints', 'Two Irish Catholic brothers become vigilantes and wipe out Boston''s criminal underworld in the name of God. ', 1999, 'Movie', 108, 0, 0, 'R', ''),
(1504, 'Baby Boy', 'The story of Jody, a misguided, 20-year-old African-American who is really just a baby boy finally forced-kicking and screaming to face the commitments of real life.', 2001, 'Movie', 130, 0, 0, 'R', ''),
(1505, 'The Boondocks', 'Brothers Huey and Riley Freeman experience a culture clash when they leave Chicago to move in with their grandfather in the suburbs.', 2005, 'TV Series', 22, 55, 4, 'TV_MA', ''),
(1506, 'Bluey', 'The slice-of-life adventures of an Australian Blue Heeler Cattle Dog puppy as she has fun with her family and friends in everyday situations.', 2018, 'TV Series', 7, 151, 3, 'TV_Y', 'https://nexflixclonefinal.s3.amazonaws.com/+Bluey+.mp4'),
(1507, 'The Grim Adventures of Billy & Mandy', 'Billy''s hamster turned 10 in human years, but was awaiting to see the Grim Reaper. Billy and his friend, Mandy challenge the Reaper to a game of limbo to become best friends.', 2001, 'TV Series', 30, 84, 6, 'TV_Y7', ''),
(1508, 'The Office ', 'A mockumentary on a group of typical office workers, where the workday consists of ego clashes, inappropriate behavior, and tedium.', 2005, 'TV Series', 22, 201, 9, 'TV_14', '');        
INSERT INTO "PUBLIC"."VIDEO" VALUES
(1509, 'All That', '"Saturday Night Live" for a Nickelodeon audience. A zany sketch comedy featuring many wacky characters hosted for kids and by kids.', 1994, 'TV Series', 30, 211, 11, 'G', ''),
(1510, 'The Lion King', 'Set in a kingdom of lions in Africa, The Lion King tells the story of Simba (Swahili for lion), a lion cub who is to succeed his father, Mufasa, as King of the Pride Lands.', 1994, 'Movie', 88, 0, 0, 'G', ''),
(1511, 'The Land Before Time', 'An orphaned brontosaurus teams up with other young dinosaurs in order to reunite with their families in a valley.', 1988, 'Movie', 69, 0, 0, 'G', ''),
(1512, 'SpongeBob SquarePants', 'The misadventures of a talking sea sponge who works at a fast food restaurant, attends a boating school, and lives in an underwater pineapple.', 1999, 'TV Series', 23, 296, 14, 'TV_Y7', ''),
(1513, 'Breaking Bad', 'A chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine with a former student in order to secure his family''s future.', 2008, 'TV Series', 58, 62, 5, 'TV_MA', ''),
(1514, 'Silicon Valley', 'Follows the struggle of Richard Hendricks, a Silicon Valley engineer trying to build his own company called Pied Piper.', 2014, 'TV Series', 28, 53, 6, 'TV_MA', ''),
(1515, 'My Hero Academia', 'A superhero-admiring boy enrolls in a prestigious hero academy and learns what it really means to be a hero, after the strongest superhero grants him his own powers.', 2016, 'TV Series', 24, 113, 6, 'TV_14', ''),
(1517, 'Key and Peele', 'Project sees Keegan-Michael Key and Jordan Peele in front of a live studio audience bantering about a topic weaved between filmed shorts and sketches.', 2012, 'TV Series', 30, 53, 5, 'TV_14', ''),
(1518, 'Shrek', 'A mean lord exiles fairytale creatures to the swamp of a grumpy ogre, who must go on a quest and rescue a princess for the lord in order to get his land back.', 2001, 'Movie', 90, 0, 0, 'PG', ''),
(1519, 'Thor: Ragnarok', U&'Imprisoned on the planet Sakaar, Thor must race against time to return to Asgard and stop Ragnar\00f6k, the destruction of his world, at the hands of the powerful and ruthless villain Hela.', 2017, 'Movie', 130, 0, 0, 'PG13', ''),
(1520, 'The Fast and the Furious: Tokyo Drift ', 'A teenager becomes a major competitor in the world of drift racing after moving in with his father in Tokyo to avoid a jail sentence in America.', 2006, 'Movie', 104, 0, 0, 'PG13', ''),
(1521, 'Joker', 'During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.', 2019, 'Movie', 122, 0, 0, 'R', '');               
CREATE CACHED TABLE "PUBLIC"."PLAYLIST" COMMENT 'not an ignored comment'(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1500) DEFAULT ON NULL NOT NULL
);        
ALTER TABLE "PUBLIC"."PLAYLIST" ADD CONSTRAINT "PUBLIC"."PK_PLAYLIST" PRIMARY KEY("ID");       
-- 10 +/- SELECT COUNT(*) FROM PUBLIC.PLAYLIST;
INSERT INTO "PUBLIC"."PLAYLIST" VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10);      
CREATE CACHED TABLE "PUBLIC"."REL_PLAYLIST__VIDEOS"(
    "VIDEOS_ID" BIGINT NOT NULL,
    "PLAYLIST_ID" BIGINT NOT NULL
);     
ALTER TABLE "PUBLIC"."REL_PLAYLIST__VIDEOS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_B" PRIMARY KEY("PLAYLIST_ID", "VIDEOS_ID");    
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.REL_PLAYLIST__VIDEOS;     
CREATE CACHED TABLE "PUBLIC"."COMMENT"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1500 RESTART WITH 1511) DEFAULT ON NULL NOT NULL,
    "POST" CHARACTER VARYING(255),
    "THUMBS_UP" INTEGER,
    "VIDEO_ID" BIGINT,
    "POSTED_BY_ID" BIGINT
);          
ALTER TABLE "PUBLIC"."COMMENT" ADD CONSTRAINT "PUBLIC"."PK_COMMENT" PRIMARY KEY("ID");         
-- 21 +/- SELECT COUNT(*) FROM PUBLIC.COMMENT; 
INSERT INTO "PUBLIC"."COMMENT" VALUES
(1, 'I wish the Southern Classic was still around! It''s also cool that 02'' alumni can say they were in this movie. ', NULL, 8, 1),
(2, 'Stop the Rose hate. The door couldn''t fit the both of them, it would''ve sunk with both of them on there.', NULL, 7, 1),
(3, 'Power Universe is the greatest series of Tv Series! How each show interconnects is so dope! But Power will forever be the BEST!', NULL, 1, 1),
(4, 'Poor dog, he didn''t ask for any of the shenanigans ', NULL, 3, 1),
(5, 'I started watching this during the pandemic lockdown and never realized how cool anime is', NULL, 5, 1),
(6, 'Ugh! Absolutely loveeee this show! Women friendship is precious and seeing these ladies navigate life together is beautiful! ', NULL, 2, 1),
(7, 'Very Spongey', 0, 1512, 3),
(8, 'Lots of blue lol', NULL, 1513, 3),
(9, 'This show is pretty dang funny!', NULL, 1514, 3),
(10, 'So this is what teachers do on their free time, hmm ', NULL, 1513, 1),
(1500, 'Listennnn I''m prepared for any walkers! Don''t play! lol', NULL, 6, 1),
(1501, 'Dope animations and the plot is plotting', NULL, 1515, 3),
(1502, 'My stomach hurts from laughing too much', NULL, 1517, 3),
(1503, 'Gotta love Jordan Peele''s range', NULL, 1517, 1),
(1504, U&'Is this even a children\2019s movie????', NULL, 1518, 3),
(1505, '@User1 Absolutely not, the humor is too spicy for kids', NULL, 1518, 1),
(1506, 'Korg', NULL, 1519, 3),
(1507, U&'I don\2019t got friends. I got FAMILY', NULL, 1520, 3),
(1508, 'Fifty percent of something is better than a hundred percent of nothing.', NULL, 1520, 1),
(1509, 'My mind has been boggled', NULL, 1521, 3),
(1510, 'Imagine someone walking around your city with a painted face causing terror, lawd! I thought clowns were bad but I guess jokers are worse', NULL, 1521, 1);            
CREATE CACHED TABLE "PUBLIC"."CATEGORY" COMMENT 'Task entity.\n@author The JHipster team.'(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1500 RESTART WITH 1514) DEFAULT ON NULL NOT NULL,
    "CATEGORY_NAME" CHARACTER VARYING(255)
);        
ALTER TABLE "PUBLIC"."CATEGORY" ADD CONSTRAINT "PUBLIC"."PK_CATEGORY" PRIMARY KEY("ID");       
-- 15 +/- SELECT COUNT(*) FROM PUBLIC.CATEGORY;
INSERT INTO "PUBLIC"."CATEGORY" VALUES
(1, 'Action'),
(3, 'Romance'),
(4, 'Comedy '),
(5, 'Fantasy '),
(6, 'Animation'),
(7, 'Horror'),
(8, 'Sci-Fi'),
(1500, 'Drama'),
(1501, 'Adventure'),
(1504, 'Crime'),
(1506, 'Thriller'),
(1507, 'Music'),
(1511, 'Family'),
(1512, 'Sport'),
(1513, 'Biography ');    
CREATE CACHED TABLE "PUBLIC"."REL_CATEGORY__VIDEOS"(
    "VIDEOS_ID" BIGINT NOT NULL,
    "CATEGORY_ID" BIGINT NOT NULL
);     
ALTER TABLE "PUBLIC"."REL_CATEGORY__VIDEOS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_D" PRIMARY KEY("CATEGORY_ID", "VIDEOS_ID");    
-- 105 +/- SELECT COUNT(*) FROM PUBLIC.REL_CATEGORY__VIDEOS;   
INSERT INTO "PUBLIC"."REL_CATEGORY__VIDEOS" VALUES
(1, 1500),
(5, 1),
(9, 1),
(1503, 1),
(1505, 1),
(1515, 1),
(1519, 1),
(1520, 1),
(7, 3),
(8, 3),
(1504, 3),
(1518, 3),
(1500, 4),
(10, 4),
(2, 4),
(3, 4),
(4, 4),
(8, 4),
(1501, 4),
(1519, 4),
(1514, 4),
(1505, 4),
(1509, 4),
(1512, 4),
(1507, 4),
(1517, 4),
(1508, 4),
(1518, 4),
(3, 5),
(10, 5),
(1500, 5),
(1507, 5),
(1512, 5),
(1515, 5),
(1518, 5),
(1519, 5),
(1510, 6),
(3, 6),
(5, 6),
(10, 6),
(1505, 6),
(1506, 6),
(1507, 6),
(1511, 6),
(1512, 6),
(1515, 6),
(1518, 6),
(3, 7),
(6, 7),
(1502, 7),
(1507, 7),
(1515, 8),
(1519, 8),
(2, 1500),
(5, 1500),
(1521, 1500),
(6, 1500),
(7, 1500),
(8, 1500),
(9, 1500),
(1501, 1500),
(1513, 1500),
(1504, 1500),
(1505, 1500),
(1511, 1500),
(1510, 1500),
(3, 1501),
(10, 1501),
(1500, 1501),
(1507, 1501),
(1510, 1501),
(1511, 1501),
(1515, 1501),
(1518, 1501),
(1519, 1501),
(1, 1504),
(9, 1504),
(1501, 1504),
(1503, 1504),
(1504, 1504),
(1513, 1504),
(1520, 1504),
(1521, 1504),
(6, 1506),
(9, 1506),
(1503, 1506),
(1504, 1506),
(1513, 1506),
(1520, 1506),
(1521, 1506),
(8, 1507),
(1509, 1507),
(1510, 1507),
(4, 1511),
(10, 1511),
(1500, 1511),
(1506, 1511),
(1507, 1511),
(1509, 1511),
(1510, 1511),
(1511, 1511),
(1512, 1511),
(1518, 1511),
(5, 1512),
(1501, 1513);         
ALTER TABLE "PUBLIC"."JHI_USER" ADD CONSTRAINT "PUBLIC"."UX_USER_LOGIN" UNIQUE("LOGIN");       
ALTER TABLE "PUBLIC"."JHI_USER" ADD CONSTRAINT "PUBLIC"."UX_USER_EMAIL" UNIQUE("EMAIL");       
ALTER TABLE "PUBLIC"."USER_PROFILE" ADD CONSTRAINT "PUBLIC"."UX_USER_PROFILE__PLAYLIST_ID" UNIQUE("PLAYLIST_ID");              
ALTER TABLE "PUBLIC"."COMMENT" ADD CONSTRAINT "PUBLIC"."FK_COMMENT__VIDEO_ID" FOREIGN KEY("VIDEO_ID") REFERENCES "PUBLIC"."VIDEO"("ID") NOCHECK;               
ALTER TABLE "PUBLIC"."REL_CATEGORY__VIDEOS" ADD CONSTRAINT "PUBLIC"."FK_REL_CATEGORY__VIDEOS__CATEGORY_ID" FOREIGN KEY("CATEGORY_ID") REFERENCES "PUBLIC"."CATEGORY"("ID") NOCHECK;            
ALTER TABLE "PUBLIC"."REL_PLAYLIST__VIDEOS" ADD CONSTRAINT "PUBLIC"."FK_REL_PLAYLIST__VIDEOS__VIDEOS_ID" FOREIGN KEY("VIDEOS_ID") REFERENCES "PUBLIC"."VIDEO"("ID") NOCHECK;   
ALTER TABLE "PUBLIC"."REL_PLAYLIST__VIDEOS" ADD CONSTRAINT "PUBLIC"."FK_REL_PLAYLIST__VIDEOS__PLAYLIST_ID" FOREIGN KEY("PLAYLIST_ID") REFERENCES "PUBLIC"."PLAYLIST"("ID") NOCHECK;            
ALTER TABLE "PUBLIC"."JHI_USER_AUTHORITY" ADD CONSTRAINT "PUBLIC"."FK_USER_ID" FOREIGN KEY("USER_ID") REFERENCES "PUBLIC"."JHI_USER"("ID") NOCHECK;            
ALTER TABLE "PUBLIC"."REL_CATEGORY__VIDEOS" ADD CONSTRAINT "PUBLIC"."FK_REL_CATEGORY__VIDEOS__VIDEOS_ID" FOREIGN KEY("VIDEOS_ID") REFERENCES "PUBLIC"."VIDEO"("ID") NOCHECK;   
ALTER TABLE "PUBLIC"."USER_PROFILE" ADD CONSTRAINT "PUBLIC"."FK_USER_PROFILE__PLAYLIST_ID" FOREIGN KEY("PLAYLIST_ID") REFERENCES "PUBLIC"."PLAYLIST"("ID") NOCHECK;            
ALTER TABLE "PUBLIC"."COMMENT" ADD CONSTRAINT "PUBLIC"."FK_COMMENT__POSTED_BY_ID" FOREIGN KEY("POSTED_BY_ID") REFERENCES "PUBLIC"."USER_PROFILE"("ID") NOCHECK;
ALTER TABLE "PUBLIC"."JHI_USER_AUTHORITY" ADD CONSTRAINT "PUBLIC"."FK_AUTHORITY_NAME" FOREIGN KEY("AUTHORITY_NAME") REFERENCES "PUBLIC"."JHI_AUTHORITY"("NAME") NOCHECK;       
