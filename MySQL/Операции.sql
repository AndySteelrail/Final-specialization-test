-- backup таблицы с верблюдами
CREATE TABLE Camels_old LIKE Camels;
INSERT INTO Camels_old
   SELECT * FROM Camels;

SET SQL_SAFE_UPDATES = 0;
DELETE FROM Camels;
SET SQL_SAFE_UPDATES = 1;

-- backup таблицы с лошадьми
CREATE TABLE Horses_old LIKE Horses;
INSERT INTO Horses_old
   SELECT * FROM Horses;

ALTER TABLE Horses RENAME Horses_and_donkeys;

INSERT INTO Horses_and_donkeys (pack_animal_id, name, birthday, commands)
	SELECT pack_animal_id, name, birthday, commands FROM Donkeys;

-- backup таблицы с ослами
CREATE TABLE Donkeys_old LIKE Donkeys;
INSERT INTO Donkeys_old
   SELECT * FROM Donkeys;
   
-- удаление таблицы с ослами. Понимаем под "объединить" то, что от 2х сущностей останется 1
SET SQL_SAFE_UPDATES = 0;
DROP TABLE Donkeys;
SET SQL_SAFE_UPDATES = 1;

-- создание таблицы со всеми животными, class - критерий принадлежности к исх.таблице
CREATE TABLE all_animals (
	animal_id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	birthday DATE,
	commands TEXT,
	class VARCHAR(50)
);

INSERT INTO all_animals (name, birthday, commands, class)
		  SELECT name, birthday, commands, 'Dogs' FROM Dogs
   	UNION SELECT name, birthday, commands, 'Cats' FROM Cats
   	UNION SELECT name, birthday, commands, 'Hamsters' FROM Hamsters
   	UNION SELECT name, birthday, commands, 'Horses' FROM Horses_old
   	UNION SELECT name, birthday, commands, 'Donkeys' FROM Donkeys_old;

-- создание таблицы с животными возрастом от 1го до 3х лет
CREATE TABLE Young_animals AS
SELECT
	*,
	TIMESTAMPDIFF(MONTH, birthday, CURDATE()) AS age_in_month
	FROM all_animals 
	WHERE birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(),INTERVAL -1 YEAR);