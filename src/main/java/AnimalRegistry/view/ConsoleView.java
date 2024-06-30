package AnimalRegistry.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class ConsoleView {
    // BufferedReader reads information from the input stream into the console
    // and cannot return an IOException. These Exceptions do not need to be handled.
    // Also, there is no need to close it,
    // the System.in stream will close itself when the program completes.
    // Scanner is worse.
    private final static BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    public static Menu mainMenu() throws IOException {
        System.out.println("""
                Введите команду цифрой:
                1. Загрузить реестр животных из файлов.
                2. Загрузить исходный реестр животных.
                3. Сохранить реестр животных в файлы.
                4. Добавить животное в реестр.
                5. Удалить животное из реестра.
                6. Вывести информацию о животном.
                7. Добавить команду для животного.
                8. Удалить команду для животного
                9. Вывести информацию о количестве животных.
                10. Вывести полный реестр животных.
                11. Выйти.""");
        return Menu.getType(
                reader.readLine());
    }

    public static String requestAnimalType() throws IOException {
        System.out.println("""
                Введите вид нового животного цифрой:
                1. Кот.
                2. Собака.
                3. Хомяк.
                4. Конь.
                5. Верблюд
                6. Осёл""");
        return reader.readLine();
    }

    public static String requestAnimalByName() throws IOException {
        System.out.println("Введите имя животного:");
        return reader.readLine();
    }

    public static String requestBirthday() throws IOException {
        System.out.println("Введите дату рождения в формате dd.mm.yyyy:");
        return reader.readLine();
    }

    public static String requestNewCommand() throws IOException {
        System.out.println("Введите новую команду для животного:");
        return reader.readLine();
    }

    public static void printError(String str) {
        System.out.println(str);
    }

    // Interface segregation principle
    public static void printAddedCommand(String str) {
        System.out.println(str);
    }

    public static void printAnimalInfo(String str) {
        System.out.println(str);
    }

    public static void printCounter(String str) {
        System.out.println(str);
    }

    public static void printAllDataFromRegistry(String str) {
        System.out.println(str);
    }

    public static void printAddedAnimalMessage(String str) {
        System.out.println(str);
    }

    public static void printRemovedAnimalMessage(String str) {
        System.out.println(str);
    }
}
