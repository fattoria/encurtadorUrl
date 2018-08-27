create database shorturl;

use shorturl;

create table url(id int primary key auto_increment,
url_longa varchar(255),
url_curta varchar(50)
);