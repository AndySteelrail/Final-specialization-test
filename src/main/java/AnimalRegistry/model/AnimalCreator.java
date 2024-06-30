package AnimalRegistry.model;


import AnimalRegistry.model.pets.Dog;
import AnimalRegistry.model.pets.Cat;
import AnimalRegistry.model.pets.Hamster;
import AnimalRegistry.model.pack_animals.Horse;
import AnimalRegistry.model.pack_animals.Camel;
import AnimalRegistry.model.pack_animals.Donkey;
import java.time.LocalDate;

public abstract class AnimalCreator {
    public static Animal create(
            AnimalType type, String nickname, LocalDate birthday, String strCommands) {

        Animal animal = switch (type) {
            case Cat -> new Cat();
            case Dog -> new Dog();
            case Hamster -> new Hamster();
            case Horse -> new Horse();
            case Camel -> new Camel();
            case Donkey -> new Donkey();
        };
        animal.setNickname(nickname);
        animal.setBirthday(birthday);

        if (strCommands != null) {
            String[] commands = strCommands.split(",");
            for (String command : commands) {
                animal.addCommand(command);
            }
        }
        return animal;
    }
}