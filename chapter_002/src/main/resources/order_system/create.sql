create table comments1(
	id serial primary key,
	name varchar(255),
	items_id int references items(id)
);

create table attaches(
	id serial primary key,
	name varchar(255),
	items_id int references items(id)
);

create table items(
	id serial primary key,
	name varchar(255),
	users_id int references users(id),
	categories_id int references categories(id),
	states_id int references states(id)
);

create table users(
	id serial primary key,
	name varchar(255),
	roles_id int references roles(id)
);

create table roles(
	id serial primary key,
	name varchar(255)
);

create table rules(
	id serial primary key,
	name varchar(255)
);

create table roles_rules(
	id serial primary key,
	rules_id int references rules(id),
	roles_id int references roles(id)
);

create table categories(
	id serial primary key,
	name varchar(255)
);

create table states(
	id serial primary key,
	name varchar(255)
);