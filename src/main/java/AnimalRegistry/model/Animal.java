package AnimalRegistry.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.SortedSet;
import java.util.TreeSet;

public abstract class Animal implements Serializable {
    private static int counterId = 1;
    private final int id = counterId++;
    private String nickname;
    private LocalDate birthday;
    private final SortedSet<String> commands = new TreeSet<>();

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate date) {
        this.birthday = date;
    }

    public String getCommandsInString() {
        if (commands.isEmpty()) {
            return "Nothing";
        } else {
            StringBuilder sb = new StringBuilder();
            for (String command : commands) {
                sb.append(", ");
                sb.append(command);
            }
            sb.delete(0, 2);
            return sb.toString();
        }
    }

    public String addCommand(String command) {
        if (this.commands.add(command)) {
            return this.nickname + " разучил новую команду: " + command;
        } else {
            return this.nickname + " уже знает команду: " + command;
        }
    }

    public String removeCommand (String command) {
        if (this.commands.remove(command)) {
            return this.nickname + " потерял навык: " + command;
        } else {
            return this.nickname + ", в целом, и не умел: " + command;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Id(%s): %d. Имя: %s. Дата рождения: %s. Умеет: %s",
                this.getClass().getSimpleName(),
                getId(),
                getNickname(),
                getBirthday(),
                getCommandsInString());
    }
}
