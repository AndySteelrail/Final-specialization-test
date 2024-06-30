package AnimalRegistry.controller;

import AnimalRegistry.model.registry.Registry;
import AnimalRegistry.model.registry.RegistryInitialisation;
import AnimalRegistry.view.ConsoleView;

public abstract class ControllerInitialisation {
    static RegistryInitialisation registryInit = new RegistryInitialisation();

    static void initFromFiles(Registry registry) {
        try {
            ConsoleView.printInitFromFilesMessage(
                    registryInit.initFromFiles(registry));
        } catch (Exception e) {
            ConsoleView.printError(e.getMessage());
        }
    }

    static void initWithAnimalCreator(Registry registry) {
        try {
            ConsoleView.printInitWithAnimalCreatorMessage(
                    registryInit.initWithAnimalCreator(registry));
        } catch (Exception e) {
            ConsoleView.printError(e.getMessage());
        }
    }

    static void saveRegistriesToFiles(Registry registry) {
        try {
            ConsoleView.printSaveRegistriesToFiles(
                    registryInit.saveRegistriesToFile(registry));
        } catch (Exception e) {
            ConsoleView.printError(e.getMessage());
        }
    }
}
