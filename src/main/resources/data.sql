DROP TABLE IF EXISTS GAME;

CREATE TABLE GAME(
    id_game integer not null,
    name varchar(60) not null,
    description varchar(255),
    game_creator varchar(60),
    release_date Date,
    primary key(id_game)
);

INSERT INTO GAME VALUES(1,'Pokemon','Travel and capture all the Pokemons !','Satoshi Tajiri','1996-02-27');
INSERT INTO GAME VALUES(2,'Resident Evil','Dont be scared ! Its just zombies.','Shinji Mikami','1996-03-22');
INSERT INTO GAME VALUES(3,'Grand Theft Auto','This is America.','RockStar Games','1997-10-21');
INSERT INTO GAME VALUES(4,'Game of Life','Outcome impossible to predict.','God','0000-01-01');
INSERT INTO GAME VALUES(5,'Call Of Duty','War game classics never die','Activision','2003-10-23');