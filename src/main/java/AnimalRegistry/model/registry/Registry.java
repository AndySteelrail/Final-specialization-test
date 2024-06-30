package AnimalRegistry.model.registry;


import AnimalRegistry.model.Animal;
import AnimalRegistry.model.pack_animals.PackAnimal;
import AnimalRegistry.model.pets.Pet;

import java.util.Map;
import java.util.TreeMap;

public class Registry {
    public TreeMap<Integer, Pet> pets = new TreeMap<>();
    public TreeMap<Integer, PackAnimal> packAnimals = new TreeMap<>();
    public int catCount = 0;
    public int dogCount = 0;
    public int hamsterCount = 0;
    public int horseCount = 0;
    public int camelCount = 0;
    public int donkeyCount = 0;

    public int getAnimalIdByName(String name) {
        for(Map.Entry<Integer, Pet> pet : pets.entrySet()){
            if (pet.getValue().getNickname().equals(name)) {
                return pet.getKey();
            }
        }
        for(Map.Entry<Integer, PackAnimal> packAnimal : packAnimals.entrySet()){
            if (packAnimal.getValue().getNickname().equals(name)) {
                return packAnimal.getKey();
            }
        }
        return 0;
    }

    public String getInfoAboutAnimalById(int id) {
        if (pets.containsKey(id)) {
            return id + ". Дом.животное: " + pets.get(id) + "\n";
        }
        if (packAnimals.containsKey(id)) {
            return id + ". Вьючное животное: " + packAnimals.get(id) + "\n";
        }
        return "";
    }

    public String addCommandByName(String name, String command) {
        int id = getAnimalIdByName(name);
        if (pets.containsKey(id)) {
            return pets.get(id).addCommand(command);
        }
        if (packAnimals.containsKey(id)) {
            return packAnimals.get(id).addCommand(command);
        }
        return "";
    }

    public String removeCommandByName(String name, String command) {
        int id = getAnimalIdByName(name);
        if (pets.containsKey(id)) {
            return pets.get(id).removeCommand(command);
        }
        if (packAnimals.containsKey(id)) {
            return packAnimals.get(id).removeCommand(command);
        }
        return "";
    }

    public String addAnimal(Animal animal) {
        if (animal instanceof Pet) {
            addPet((Pet) animal);
        } else if (animal instanceof PackAnimal) {
            addPackAnimal((PackAnimal) animal);
        }
        return "В реестр добавлен: " + animal.getNickname() + "\n";
    }

    private void addPet(Pet pet) {
        pets.put(pet.getId(), pet);
        switch (pet.getClass().getSimpleName()) {
            case "Cat" -> catCount++;
            case "Dog" -> dogCount++;
            case "Hamster" -> hamsterCount++;
        }
    }

    private void addPackAnimal(PackAnimal packAnimal) {
        packAnimals.put(packAnimal.getId(), packAnimal);
        switch (packAnimal.getClass().getSimpleName()) {
            case "Horse" -> horseCount++;
            case "Camel" -> camelCount++;
            case "Donkey" -> donkeyCount++;
        }
    }

    public String removeAnimalByName(String name) {
        int id = getAnimalIdByName(name);
        boolean result = false;
        if (pets.containsKey(id)) {
            removePet(pets.get(id));
            result = true;
        }
        if (packAnimals.containsKey(id)) {
            removePackAnimal(packAnimals.get(id));
            result = true;
        }
        if (result) {
            return "Из реестра удалён: " + name + "\n";
        } else {
            return "В реестре нет такого животного как: " + name + "\n";
        }
    }

    private void removePet(Pet pet) {
        pets.remove(pet.getId());
        switch (pet.getClass().getSimpleName()) {
            case "Cat" -> catCount--;
            case "Dog" -> dogCount--;
            case "Hamster" -> hamsterCount--;
        }
    }

    private void removePackAnimal(PackAnimal packAnimal) {
        packAnimals.remove(packAnimal.getId());
        switch (packAnimal.getClass().getSimpleName()) {
            case "Horse" -> horseCount--;
            case "Camel" -> camelCount--;
            case "Donkey" -> donkeyCount--;
        }
    }

    public String getInfoAboutCounts() {
        return "Общее количество животных: " + (pets.size() + packAnimals.size()) + "\n" +
                "     Домашних животных: " + pets.size() + "\n" +
                "         Котов: " + catCount + "\n" +
                "         Собак: " + dogCount + "\n" +
                "         Хомяков: " + hamsterCount + "\n" +
                "     Вьючных животных: " + packAnimals.size() + "\n" +
                "         Лошадей: " + horseCount + "\n" +
                "         Верблюдов: " + camelCount + "\n" +
                "         Ослов: " + donkeyCount + "\n";
    }

    public String getAllDataFromRegistry() {
        StringBuilder sb = new StringBuilder();
        sb.append("Дом.животные:\n");
        for(Map.Entry<Integer, Pet> pet : pets.entrySet()){
            sb.append("    AnimalId: ").
                    append(pet.getKey()).
                    append(". ").
                    append(pet.getValue()).
                    append("\n");
        }
        sb.append("Вьючные животные:\n");
        for(Map.Entry<Integer, PackAnimal> packAnimal : packAnimals.entrySet()){
            sb.append("    AnimalId: ").
                    append(packAnimal.getKey()).
                    append(". ").
                    append(packAnimal.getValue()).
                    append("\n");
        }
        return sb.toString();
    }
}
