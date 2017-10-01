insert into SampleModel (name) values ('Traveller');

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

INSERT INTO Address (`id`, `city`, `state`, `country`, `street`, `zipCode`) VALUES ('1', 'Fairfield', 'IA', 'USA', 'North Street', '55335');
INSERT INTO UserProfile (`id`, `HostingStatus`, `aboutMe`, `countriesLived`, `countriesVisited`, `education`, `firstName`, `language`, `lastName`, `myInterests`, `occupation`, `location_id`, `user_id`) VALUES ('11', '1', 'about peter', 'USA', 'nanana', 'papa', 'peter', 'english', 'bern', 'nothing', 'student', '1', '9');

INSERT INTO Address (`id`, `city`, `state`, `country`, `street`, `zipCode`) VALUES ('2', 'Fairfield', 'IA', 'USA', 'North Street', '55335');
INSERT INTO UserProfile (`id`, `HostingStatus`, `aboutMe`, `countriesLived`, `countriesVisited`, `education`, `firstName`, `language`, `lastName`, `myInterests`, `occupation`, `location_id`, `user_id`) VALUES ('12', '2', 'about yang', 'USA', 'nanana', 'papa', 'yang', 'chineses', 'yu', 'nothing', 'student', '2', '7');

INSERT INTO Address (`id`, `city`, `state`, `country`, `street`, `zipCode`) VALUES ('3', 'Recife', 'DL', 'Brazil', 'South Street', '11234');
INSERT INTO UserProfile (`id`, `HostingStatus`, `aboutMe`, `countriesLived`, `countriesVisited`, `education`, `firstName`, `language`, `lastName`, `myInterests`, `occupation`, `location_id`, `user_id`) VALUES ('13', '1', 'about rafael', 'Brazil', 'nanana', 'papa', 'rafel', 'portuguese', 'costa', 'nothing', 'student', '3', '5');

INSERT INTO Address (`id`, `city`, `state`, `country`, `street`, `zipCode`) VALUES ('4', 'Lakman', 'IA', 'Ethiopia', 'West Street', '22352');
INSERT INTO UserProfile (`id`, `HostingStatus`, `aboutMe`, `countriesLived`, `countriesVisited`, `education`, `firstName`, `language`, `lastName`, `myInterests`, `occupation`, `location_id`, `user_id`) VALUES ('14', '1', 'about meron', 'France', 'nanana', 'papa', 'meron', 'french', 'tollosa', 'nothing', 'student', '4', '3');

insert into Reference (id, description, date, userProfileId, referenceType) values (1, 'He is a good guy.', '2017-3-04', 11, 1);
insert into Reference (id, description, date, userProfileId, referenceType) values (2, 'Not a good experience.', '2017-6-02', 11, 1);

INSERT INTO Itinerary (`id`, `arrivalDate`, `city`, `country`, `departureDate`, `message`, `state`, `user_id`) VALUES ('1', '2018-03-03', 'Fairfield', 'USA', '2018-03-05', 'Visiting Campus', 'IA', '11');
INSERT INTO Itinerary (`id`, `arrivalDate`, `city`, `country`, `departureDate`, `message`, `state`, `user_id`) VALUES ('2', '2018-03-05', 'Chicago', 'USA', '2018-03-08', 'Love to see Chicago', 'IA', '11');
