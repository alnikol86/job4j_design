create table number_plate(
	id serial primary key,
	number int
);

create table car(
	id serial primary key,
	name varchar(255),
	numberPlate_id int references number_plate(id) unique
);