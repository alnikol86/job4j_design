insert into comments1(name) values ('comment1');

insert into attaches(name) values ('attach1');

insert into items(name, comments1_id, attaches_id, categories_id, states_id) values ('position1', 1, 1, 1, 1);

insert into users(name, roles_id, items_id) values ('user1', 1, 1);

insert into rules(name) values ('individual');
insert into rules(name) values ('corporation');

insert into roles(name, rules_id) values ('customer', 1);
insert into roles(name, rules_id) values ('company', 2);

insert into categories(name) values ('purchase');
insert into categories(name) values ('refund');
insert into categories(name) values ('return');

insert into states(name) values ('in stock');
insert into states(name) values ('in delivery')
