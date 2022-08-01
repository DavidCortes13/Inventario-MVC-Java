create database navesEspaciales;
use navesEspaciales;

create table nave(
id int(10) primary key not null auto_increment,
nombreNave varchar(30) not null,
tipoNave  varchar(30) not null,
fechaLanzamiento varchar(30) not null,
pesoTonelada float(8) not null
);

insert into nave (nombreNave,tipoNave,fechaLanzamiento,pesoTonelada  ) values ("Saturno V","Lanzadera","1973",2900);
insert into nave (nombreNave,tipoNave,fechaLanzamiento,pesoTonelada  ) values ("Protón","Lanzadera","2001",5);
insert into nave (nombreNave,tipoNave,fechaLanzamiento,pesoTonelada  ) values ("Falcon IX","Lanzadera","2010",6000.5);



select *from nave;