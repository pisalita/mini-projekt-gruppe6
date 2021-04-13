CREATE SCHEMA wishlink;
USE wishlink;

CREATE table usr (
id INT NOT NULL AUTO_INCREMENT,
username VARCHAR(30),
email  VARCHAR(50) unique,
pwd VARCHAR(20),
PRIMARY KEY (id)
);


CREATE TABLE wishlist(
id INT NOT NULL auto_increment,
title VARCHAR(50),
link VARCHAR (300),
cmnt VARCHAR(140),
reserved boolean,
email VARCHAR(50) references usr(email),
primary key (id)
);

INSERT INTO usr (username, email, pwd) VALUES ("Andreas", "Andreas@gmail.com", "hejmeddig123");
INSERT INTO usr (username, email, pwd) VALUES ("Jimmi", "Jimmi@gmail.com", "hejmeddig123");

INSERT INTO wishlist (title, link, cmnt, reserved, email) VALUES ("Teddy bear", "https://bamse.dk", "jeg vil gerne have en bjørn", false, "Jimmi@gmail.com");
INSERT INTO wishlist (title, link, cmnt, reserved, email) VALUES ("bil", "https://bil.dk", "jeg vil gerne have en bil", false, "Andreas@gmail.com");


