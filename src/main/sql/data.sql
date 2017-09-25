insert into SampleModel (name) values ('Sample Model');

-- Users

insert into Credentials (id, username, password, enabled) values (1, 'user1', '$2a$04$onojKV4YJ8/T7v9eRzwM7.Qk0kv2rDztIN9odhY/ozm1PMmzUS9rG', true);
insert into Authority (id, user_id, authority) values (2, 1 , 'USER_ROLE');