package AnimalRegistry.model;


import java.time.LocalDate;

public class Validator {
    public static String checkString(String input) throws Exception {
        if (!input.matches("^[a-zA-Zа-яА-ЯёЁ0-9]*$")) {
            throw new Exception(
                    "Неверный формат имени/фамилии. Используйте только буквенно-цифровые символы");
        }
        return input;
    }

    public static int checkAnimalType(String input) throws Exception {
        int type;
        try {
            type = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            type = 0;
        }
        if (type >= 1 && type <= 6) {
            return type;
        } else {
            throw new Exception(
                "Введите вид животного цифрой, от 1 до 6");
        }
    }

    public static LocalDate checkDate(String input) throws Exception {
        String[] inputData = input.split("\\D");

        try {
            StringBuilder sb = new StringBuilder();
            sb.append(inputData[2]);
            sb.append("-");
            sb.append(inputData[1]);
            sb.append("-");
            sb.append(inputData[0]);

            return LocalDate.parse(sb);
        } catch (Exception e) {
            throw new Exception(
                    "Неверный формат даты рождения. Введите в формате dd.mm.yyyy!");
        }
    }
}
