package AnimalRegistry.model.pets;


import AnimalRegistry.model.Animal;

import java.io.Serializable;

public abstract class Pet extends Animal implements Serializable {
    private static int counterPetId = 1;
    private final int petId = counterPetId++;

    public int getPetId() {
        return petId;
    }

    @Override
    public String toString() {
        return String.format(
                "PetId(%s): %d. Имя: %s. Дата рождения: %s. Умеет: %s",
                this.getClass().getSimpleName(),
                getPetId(),
                getNickname(),
                getBirthday(),
                getCommandsInString());
    }
}



