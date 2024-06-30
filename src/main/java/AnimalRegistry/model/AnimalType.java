package AnimalRegistry.model;

public enum AnimalType {
    Cat,
    Dog,
    Hamster,
    Horse,
    Camel,
    Donkey;

    public static AnimalType getType(int typeId) {
        return switch (typeId) {
            case 1 -> AnimalType.Cat;
            case 2 -> AnimalType.Dog;
            case 3 -> AnimalType.Hamster;
            case 4 -> AnimalType.Horse;
            case 5 -> AnimalType.Camel;
            case 6 -> AnimalType.Donkey;
            default -> null;
        };
    }
}
