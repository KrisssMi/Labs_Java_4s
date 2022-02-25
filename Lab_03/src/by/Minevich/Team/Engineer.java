package by.Minevich.Team;
import by.Minevich.Human.Human;

public class Engineer extends Human {
    public Engineer(String surname, String name, int age, int salary, int exprerience) {
        super(surname, name, age, salary, exprerience);
    }

    public Engineer() {
        super();
    }

    @Override
    public String toString() {
        return "\n\t\t > ИНЖЕНЕР: " + surname + ' ' + name +
                "\n\tвозраст: " + age + ", з/п: " + salary + ", опыт: " + experience;
    }
}
