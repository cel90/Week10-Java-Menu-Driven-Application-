create database week10_Vehicules ; 
use week10_Vehicules ;
create table vehicules (
car_id int NOT NULL auto_increment Primary key ,
make_name varchar(100) NOT NULL ,
model_name varchar(100) NOT NULL ,
car_year year NOT NULL ,
price decimal(10,2) NOT NULL ,
color varchar(25) NOT NULL  , 
vin varchar(25) NOT NULL 
) ;
desc vehicules ;