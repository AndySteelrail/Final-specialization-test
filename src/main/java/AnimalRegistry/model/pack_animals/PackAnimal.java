package AnimalRegistry.model.pack_animals;


import AnimalRegistry.model.Animal;

import java.io.Serializable;

public abstract class PackAnimal extends Animal implements Serializable {
    private static int counterPackAnimalId = 1;
    protected int packAnimalId = counterPackAnimalId++;

    public int getPackAnimalId() {
        return packAnimalId;
    }

    @Override
    public String toString() {
        return String.format(
                "PackAnimalId(%s): %d. Имя: %s. Дата рождения: %s. Умеет: %s",
                this.getClass().getSimpleName(),
                getPackAnimalId(),
                getNickname(),
                getBirthday(),
                getCommandsInString());
    }
}
