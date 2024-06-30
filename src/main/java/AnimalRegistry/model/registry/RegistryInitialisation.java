package AnimalRegistry.model.registry;

import AnimalRegistry.model.Animal;
import AnimalRegistry.model.AnimalCreator;
import AnimalRegistry.model.AnimalType;
import AnimalRegistry.model.pets.Pet;
import AnimalRegistry.model.pack_animals.PackAnimal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class RegistryInitialisation<A extends Animal> {
    public void initFromFiles(Registry registry) throws Exception {
        TreeMap<Integer, Pet> newPets =
                (TreeMap<Integer, Pet>) readRegistryFromFile("Pets");
        TreeMap<Integer, PackAnimal> newPackAnimals =
                (TreeMap<Integer, PackAnimal>) readRegistryFromFile("PackAnimals");

        if (!newPets.isEmpty()) {
            for(Map.Entry<Integer, Pet> pet : newPets.entrySet()){
                registry.addAnimal(AnimalCreator.create(
                        AnimalType.valueOf(pet.getValue().getClass().getSimpleName()),
                        pet.getValue().getNickname(),
                        pet.getValue().getBirthday(),
                        pet.getValue().getCommandsInString()));
            }
        }
        if (!newPackAnimals.isEmpty()) {
            for(Map.Entry<Integer, PackAnimal> packAnimal : newPackAnimals.entrySet()){
                registry.addAnimal(AnimalCreator.create(
                        AnimalType.valueOf(packAnimal.getValue().getClass().getSimpleName()),
                        packAnimal.getValue().getNickname(),
                        packAnimal.getValue().getBirthday(),
                        packAnimal.getValue().getCommandsInString()));
            }
        }
    }

    public void initWithAnimalCreator(Registry registry) {

        registry.addAnimal(AnimalCreator.create(
                AnimalType.Dog,
                "Fido",
                LocalDate.of(2022, 1, 1),
                "Sit, Stay, Fetch"));
        registry.addAnimal(AnimalCreator.create(
                AnimalType.Cat,
                "Whiskers",
                LocalDate.of(2019, 5, 15),
                "Sit, Pounce"));
        registry.addAnimal(AnimalCreator.create(
                AnimalType.Hamster,
                "Hammy",
                LocalDate.of(2021, 3, 10),
                "Roll, Hide"));
        registry.addAnimal(AnimalCreator.create(
                AnimalType.Dog,
                "Buddy",
                LocalDate.of(2018, 12, 10),
                "Sit, Paw, Bark"));
        registry.addAnimal(AnimalCreator.create(
                AnimalType.Cat,
                "Smudge",
                LocalDate.of(2020, 2, 20),
                "Sit, Pounce, Scratch"));
        registry.addAnimal(AnimalCreator.create(
                AnimalType.Hamster,
                "Peanut",
                LocalDate.of(2021, 8, 1),
                "Roll, Spin"));
        registry.addAnimal(AnimalCreator.create(
                AnimalType.Dog,
                "Bella",
                LocalDate.of(2019, 11, 1),
                "Sit, Stay, Roll"));
        registry.addAnimal(AnimalCreator.create(
                AnimalType.Cat,
                "Oliver",
                LocalDate.of(2020, 6, 30),
                "Meow, Scratch, Jump"));

        registry.addAnimal(AnimalCreator.create(
                AnimalType.Horse,
                "Thunder",
                LocalDate.of(2015, 7, 21),
                "Trot, Canter, Gallop"));
        registry.addAnimal(AnimalCreator.create(
                AnimalType.Camel,
                "Sandy",
                LocalDate.of(2016, 11, 3),
                "Walk, Carry Load"));
        registry.addAnimal(AnimalCreator.create(
                AnimalType.Donkey,
                "Eeyore",
                LocalDate.of(2017, 9, 18),
                "Walk, Carry Load, Bray"));
        registry.addAnimal(AnimalCreator.create(
                AnimalType.Horse,
                "Storm",
                LocalDate.of(2014, 5, 5),
                "Trot, Canter"));
        registry.addAnimal(AnimalCreator.create(
                AnimalType.Camel,
                "Dune",
                LocalDate.of(2018, 12, 12),
                "Walk, Sit"));
        registry.addAnimal(AnimalCreator.create(
                AnimalType.Donkey,
                "Burro",
                LocalDate.of(2019, 1, 23),
                "Walk, Bray, Kick"));
        registry.addAnimal(AnimalCreator.create(
                AnimalType.Horse,
                "Blaze",
                LocalDate.of(2016, 2, 29),
                "Trot, Jump, Gallop"));
        registry.addAnimal(AnimalCreator.create(
                AnimalType.Camel,
                "Sahara",
                LocalDate.of(2015, 8, 14),
                "Walk, Run"));
    }

    public TreeMap<Integer, A> readRegistryFromFile(String filename) throws Exception {
        String path = "src/main/resources/";
        String fullPath = path + filename + ".ser";
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fullPath)))
        {
            return (TreeMap<Integer, A>) ois.readObject();
        }
        catch(Exception ex){
            throw new Exception(
                    "Не вышло прочитать животных из файла. Реестр пуст.");
        }
    }

    public void writeRegistryToFile(String filename, TreeMap<Integer, A> animals) throws Exception {
        String path = "src/main/resources/";
        String fullPath = path + filename + ".ser";
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fullPath)))
        {
            oos.writeObject(animals);
        }
        catch(Exception ex){
            throw new Exception(
                    "Не вышло записать животных файл. Реестр пуст.");
        }
    }

    public void saveRegistriesToFile(Registry registry) throws Exception {
        writeRegistryToFile("Pets", (TreeMap<Integer, A>) registry.pets);
        writeRegistryToFile("PackAnimals", (TreeMap<Integer, A>) registry.packAnimals);
    }
}
