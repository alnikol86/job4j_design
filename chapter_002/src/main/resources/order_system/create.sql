create table comments1(
	id serial primary key,
	name varchar(255)
);

create table attaches(
	id serial primary key,
	name varchar(255)
);

create table items(
	id serial primary key,
	name varchar(255),
	comments1_id int references comments1(id),
	attaches_id int references attaches(id),
	categories_id int references categories(id),
	states_id int references states(id)
);

create table users(
	id serial primary key,
	name varchar(255),
	roles_id int references roles(id),
	items_id int references items(id)
);

create table roles(
	id serial primary key,
	name varchar(255),
	rules_id int references users(id)
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