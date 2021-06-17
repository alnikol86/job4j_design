create table level_education(
	id serial primary key,
	name varchar(255)
);

create table peoples(
	id serial primary key,
	name varchar(255),
	levelEducation_id int references level_education(id)
);