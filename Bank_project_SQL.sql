create database bankmanagmentsystem;

use bankmanagmentsystem;



create table singin(formNo varchar(20),name varchar(20),fname varchar(20),email varchar(30),adress varchar(50),
city varchar(20),state varchar(30),pincode bigint(20),dob varchar(20),gender varchar(20),status varchar(20) );

create table singin2(formNo varchar(20),Religion varchar(20),Category varchar(20),Income varchar(20),Education varchar(20),
Acupation varchar(20),PanNumber varchar(20),AdharNumber bigint(20),SetizenShip varchar(10),AccountExisting varchar(10));

create table bank(pin varchar(20),date varchar(50),type varchar(20),Amount varchar(30));

show tables;
select * from longin;
select * from bank;
select * from singin3;
select * from singin2;
select * from longin;

delete from longin;

drop table bank;