package AnimalRegistry.controller;


import AnimalRegistry.model.registry.Registry;
import AnimalRegistry.model.Animal;
import AnimalRegistry.model.AnimalCreator;
import AnimalRegistry.model.AnimalType;
import AnimalRegistry.model.Validator;
import AnimalRegistry.view.ConsoleView;

import java.time.LocalDate;
import java.util.Objects;

public class Controller {
    private final Registry registry = new Registry();

    public Controller() {
        while (true) {
            try {
                switch (ConsoleView.mainMenu()) {
                    case INIT_FROM_FILES -> ControllerInitialisation.initFromFiles(registry);
                    case DEFAULT_INIT -> ControllerInitialisation.initWithAnimalCreator(registry);
                    case SAVE_REGISTRY -> ControllerInitialisation.saveRegistriesToFiles(registry);
                    case ADD_ANIMAL -> addAnimal();
                    case REMOVE_ANIMAL -> removeAnimal();
                    case ANIMAL_INFO -> provideAnimalInfo();
                    case ADD_COMMAND -> addCommand();
                    case REMOVE_COMMAND -> removeCommand();
                    case ANIMAL_COUNTER -> provideAnimalCounter();
                    case REGISTRY_INFO -> provideRegistry();
                    case EXIT -> System.exit(0);
                }
            } catch (Exception e) {
                ConsoleView.printError(e.getMessage());
            }
        }
    }

    private void addAnimal() {
        try {
            Animal animal = AnimalCreator.create(
                    requestAnimalType(3),
                    requestAnimalName(3),
                    requestBirthdate(3),
                    requestCommand(3));
            ConsoleView.printAddedAnimalMessage(
                    registry.addAnimal(animal));
        } catch (Exception e) {
            ConsoleView.printError(e.getMessage());
        }
    }

    private void removeAnimal() {
        try {
            String name = requestAnimalName(3);
            ConsoleView.printRemovedAnimalMessage(
                    registry.removeAnimalByName(name));
        } catch (Exception e) {
            ConsoleView.printError(e.getMessage());
        }
    }

    private void provideAnimalInfo() {
        try {
            String name = requestAnimalName(3);
            int id = registry.getAnimalIdByName(name);
            String info = registry.getInfoAboutAnimalById(id);
            ConsoleView.printAnimalInfo(info);
        } catch (Exception e) {
            ConsoleView.printError(e.getMessage());
        }
    }

    private void addCommand() {
        try {
            String name = requestAnimalName(3);
            String command = requestCommand(3);
            String result = registry.addCommandByName(name, command);
            ConsoleView.printAddedCommand(result);
        } catch (Exception e) {
            ConsoleView.printError(e.getMessage());
        }
    }

    private void removeCommand() {
        try {
            String name = requestAnimalName(3);
            String command = requestCommand(3);
            String result = registry.removeCommandByName(name, command);
            ConsoleView.printAddedCommand(result);
        } catch (Exception e) {
            ConsoleView.printError(e.getMessage());
        }
    }

    private AnimalType requestAnimalType(int attempts) throws Exception {
        checkAttemptNumbers(attempts, "тип животного");
        String strType = ConsoleView.requestAnimalType();
        try {
            int intType = Validator.checkAnimalType(strType);
            AnimalType type = AnimalType.getType(intType);
            return Objects.requireNonNull(type);
        } catch (Exception e) {
            ConsoleView.printError(e.getMessage());
        }
        return requestAnimalType(attempts - 1);
    }

    private String requestAnimalName(int attempts) throws Exception {
        checkAttemptNumbers(attempts, "имя");
        String name = ConsoleView.requestAnimalByName();
        try {
            return Validator.checkString(name);
        } catch (Exception e) {
            ConsoleView.printError(e.getMessage());
        }
        return requestAnimalName(attempts - 1);
    }

    private String requestCommand(int attempts) throws Exception {
        checkAttemptNumbers(attempts, "команды");
        String command = ConsoleView.requestNewCommand();
        try {
            return Validator.checkString(command);
        } catch (Exception e) {
            ConsoleView.printError(e.getMessage());
        }
        return requestCommand(attempts - 1);
    }

    private LocalDate requestBirthdate(int attempts) throws Exception {
        checkAttemptNumbers(attempts, "дата рождения");
        String date = ConsoleView.requestBirthday();
        try {
            return Validator.checkDate(date);
        } catch (Exception e) {
            ConsoleView.printError(e.getMessage());
        }
        return requestBirthdate(attempts - 1);
    }

    private void provideAnimalCounter() {
        String message = registry.getInfoAboutCounts();
        ConsoleView.printCounter(message);
    }

    private void provideRegistry() {
        String message = registry.getAllDataFromRegistry();
        ConsoleView.printAllDataFromRegistry(message);
    }

    private void checkAttemptNumbers(int attempts, String message) throws Exception {
        if (attempts == 0) {
            throw new Exception(
                    "Как-то не вышло у вас верно заполнить поле: " + message + ". Попробуйте позже.\n");
        }
    }
}