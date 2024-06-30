package AnimalRegistry.view;

public enum Menu {
    INIT_FROM_FILES,
    DEFAULT_INIT,
    SAVE_REGISTRY,
    ADD_ANIMAL,
    REMOVE_ANIMAL,
    ANIMAL_INFO,
    ADD_COMMAND,
    REMOVE_COMMAND,
    ANIMAL_COUNTER,
    REGISTRY_INFO,
    EXIT;

    public static Menu getType(String typeId) {
        return switch (typeId) {
            case "1" -> Menu.INIT_FROM_FILES;
            case "2" -> Menu.DEFAULT_INIT;
            case "3" -> Menu.SAVE_REGISTRY;
            case "4" -> Menu.ADD_ANIMAL;
            case "5" -> Menu.REMOVE_ANIMAL;
            case "6" -> Menu.ANIMAL_INFO;
            case "7" -> Menu.ADD_COMMAND;
            case "8" -> Menu.REMOVE_COMMAND;
            case "9" -> Menu.ANIMAL_COUNTER;
            case "10" -> Menu.REGISTRY_INFO;
            case "11" -> Menu.EXIT;
            default -> throw new IllegalStateException("Введите рекомендуемое число - команду");
        };
    }
}
