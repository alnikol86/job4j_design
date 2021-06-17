create table peoples1(
	id serial primary key,
	name varchar(255)
);

create table banks(
	id serial primary key,
	name varchar(255)
);

create table accounts(
	id serial primary key,
	people_id int references peoples1(id),
	bank_id int references banks(id)
);