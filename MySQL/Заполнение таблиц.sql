USE Human_Friends;

INSERT INTO Animals (animal_class)
VALUES ('Pets'), ('Pack_animals');

INSERT INTO Pets (animal_id, pet_class)
VALUES (1, 'Dogs'), (1, 'Cats'), (1, 'Hamsters');

INSERT INTO Pack_animals (animal_id, pack_animal_class)
VALUES (2, 'Horses'), (2, 'Camels'), (2, 'Donkeys');

INSERT INTO Dogs (pet_id, name, birthday, commands)
VALUES
(1, 'Fido', '2020-01-01', 'Sit, Stay, Fetch'), 
(1, 'Buddy', '2018-12-10', 'Sit, Paw, Bark'),
(1, 'Bella', '2019-11-11', 'Sit, Stay, Roll');

INSERT INTO Cats (pet_id, name, birthday, commands)
VALUES
(2, 'Whiskers', '2019-05-15', 'Sit, Pounce'), 
(2, 'Smudge', '2020-02-20', 'Sit, Pounce, Scratch'),
(2, 'Oliver', '2020-06-30', 'Meow, Scratch, Jump');

INSERT INTO Hamsters (pet_id, name, birthday, commands)
VALUES
(3, 'Hammy', '2021-03-10', 'Roll, Hide'), 
(3, 'Peanut', '2021-08-01', 'Roll, Spin');

INSERT INTO Horses (pack_animal_id, name, birthday, commands)
VALUES
(1, 'Thunder', '2015-07-21', 'Trot, Canter, Gallop'), 
(1, 'Storm', '2014-05-05', 'Trot, Canter'),
(1, 'Blaze', '2016-02-29', 'Trot, Jump, Gallop');

INSERT INTO Camels (pack_animal_id, name, birthday, commands)
VALUES
(2, 'Sandy', '2016-11-03', 'Walk, Carry Load'), 
(2, 'Dune', '2018-12-12', 'Walk, Sit'),
(2, 'Sahara', '2015-08-14', 'Walk, Run');

INSERT INTO Donkeys (pack_animal_id, name, birthday, commands)
VALUES
(3, 'Eeyore', '2017-09-18', 'Walk, Carry Load, Bray'), 
(3, 'Burro', '2019-01-23', 'Walk, Bray, Kick');