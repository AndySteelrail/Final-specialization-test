DROP DATABASE IF EXISTS Human_Friends;
CREATE DATABASE Human_Friends;
USE Human_Friends;

DROP TABLE IF EXISTS Animals;
CREATE TABLE Animals (
	animal_id SERIAL PRIMARY KEY,
    animal_class VARCHAR(50)
);

DROP TABLE IF EXISTS Pets;
CREATE TABLE Pets (
	pet_id SERIAL PRIMARY KEY,
	animal_id BIGINT UNSIGNED NOT NULL,
	pet_class VARCHAR(50),
    FOREIGN KEY (animal_id) REFERENCES Animals (animal_id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS Pack_animals;
CREATE TABLE Pack_animals (
	pack_animal_id SERIAL PRIMARY KEY,
	animal_id BIGINT UNSIGNED NOT NULL,
	pack_animal_class VARCHAR(50),
    FOREIGN KEY (animal_id) REFERENCES Animals (animal_id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS Dogs;
CREATE TABLE Dogs (
	dog_id SERIAL PRIMARY KEY,
	pet_id BIGINT UNSIGNED NOT NULL,
	name VARCHAR(50),
	birthday DATE,
	commands TEXT,
    FOREIGN KEY (pet_id) REFERENCES Pets (pet_id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS Cats;
CREATE TABLE Cats (
	cat_id SERIAL PRIMARY KEY,
	pet_id BIGINT UNSIGNED NOT NULL,
	name VARCHAR(50),
	birthday DATE,
	commands TEXT,
    FOREIGN KEY (pet_id) REFERENCES Pets (pet_id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS Hamsters;
CREATE TABLE Hamsters (
	hamster_id SERIAL PRIMARY KEY,
	pet_id BIGINT UNSIGNED NOT NULL,
	name VARCHAR(50),
	birthday DATE,
	commands TEXT,
    FOREIGN KEY (pet_id) REFERENCES Pets (pet_id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS Horses;
CREATE TABLE Horses (
	horse_id SERIAL PRIMARY KEY,
	pack_animal_id BIGINT UNSIGNED NOT NULL,
	name VARCHAR(50),
	birthday DATE,
	commands TEXT,
    FOREIGN KEY (pack_animal_id) REFERENCES Pack_animals (pack_animal_id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS Camels;
CREATE TABLE Camels (
	camel_id SERIAL PRIMARY KEY,
	pack_animal_id BIGINT UNSIGNED NOT NULL,
	name VARCHAR(50),
	birthday DATE,
	commands TEXT,
    FOREIGN KEY (pack_animal_id) REFERENCES Pack_animals (pack_animal_id) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS Donkeys;
CREATE TABLE Donkeys (
	donkey_id SERIAL PRIMARY KEY,
	pack_animal_id BIGINT UNSIGNED NOT NULL,
	name VARCHAR(50),
	birthday DATE,
	commands TEXT,
    FOREIGN KEY (pack_animal_id) REFERENCES Pack_animals (pack_animal_id) ON UPDATE CASCADE ON DELETE CASCADE
);