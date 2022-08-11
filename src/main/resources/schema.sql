create table users (
id int(11) NOT NULL AUTO_INCREMENT,
username varchar(50) not null,
email varchar(70) not null,
password varchar(500) not null,
enabled tinyint(1) not null,
authority enum('ADMIN', 'USER') not null,
tempkey varchar(255) DEFAULT NULL,
PRIMARY KEY (id)
);

CREATE TABLE task_type (
  id int(2) NOT NULL,
  type varchar(20) NOT NULL,
  comment varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE task (
  id int(5) NOT NULL AUTO_INCREMENT,
  user_id int(5) NOT NULL,
  type_id int(2) NOT NULL,
  title varchar(50) NOT NULL,
  detail text,
  deadline datetime NOT NULL,
  PRIMARY KEY (id)
) ;