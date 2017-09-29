insert into SampleModel (name) values ('Sample Model');

-- Dummy Users

insert into Credentials (id, username, password, enabled) values (1, 'user1', '$2a$04$onojKV4YJ8/T7v9eRzwM7.Qk0kv2rDztIN9odhY/ozm1PMmzUS9rG', true);
insert into Authority (id, user_id, authority) values (2, 1, 'USER_ROLE');

insert into Credentials (id, username, password, enabled) values (3, 'meron', '$2a$04$onojKV4YJ8/T7v9eRzwM7.Qk0kv2rDztIN9odhY/ozm1PMmzUS9rG', true);
insert into Authority (id, user_id, authority) values (4, 3, 'USER_ROLE');

insert into Credentials (id, username, password, enabled) values (5, 'rafael', '$2a$04$onojKV4YJ8/T7v9eRzwM7.Qk0kv2rDztIN9odhY/ozm1PMmzUS9rG', true);
insert into Authority (id, user_id, authority) values (6, 5, 'USER_ROLE');

insert into Credentials (id, username, password, enabled) values (7, 'yang', '$2a$04$onojKV4YJ8/T7v9eRzwM7.Qk0kv2rDztIN9odhY/ozm1PMmzUS9rG', true);
insert into Authority (id, user_id, authority) values (8, 7, 'USER_ROLE');

insert into Credentials (id, username, password, enabled) values (9, 'peter', '$2a$04$onojKV4YJ8/T7v9eRzwM7.Qk0kv2rDztIN9odhY/ozm1PMmzUS9rG', true);
insert into Authority (id, user_id, authority) values (10, 9, 'USER_ROLE');

INSERT INTO Address (`id`, `city`, `state`, `street`, `zipCode`) VALUES ('1', 'Fairfield', 'IA', 'North Street', '55335');
INSERT INTO UserProfile (`id`, `HostingStatus`, `aboutMe`, `countriesLived`, `countriesVisited`, `education`, `firstName`, `language`, `lastName`, `myInterests`, `occupation`, `location_id`, `user_id`) VALUES ('11', '1', 'about peter', 'USA', 'nanana', 'papa', 'peter', 'english', 'bern', 'nothing', 'student', '1', '9');

INSERT INTO Address (`id`, `city`, `state`, `street`, `zipCode`) VALUES ('2', 'Fairfield', 'IA', 'North Street', '55335');
INSERT INTO UserProfile (`id`, `HostingStatus`, `aboutMe`, `countriesLived`, `countriesVisited`, `education`, `firstName`, `language`, `lastName`, `myInterests`, `occupation`, `location_id`, `user_id`) VALUES ('12', '2', 'about yang', 'USA', 'nanana', 'papa', 'yang', 'chineses', 'yu', 'nothing', 'stud	ent', '2', '7');

insert into Reference (id, description, date, userProfileId, referenceType) values (1, 'He is a good guy.', '2017-3-04', 11, 1);
insert into Reference (id, description, date, userProfileId, referenceType) values (2, 'Not a good experience.', '2017-6-02', 11, 1);