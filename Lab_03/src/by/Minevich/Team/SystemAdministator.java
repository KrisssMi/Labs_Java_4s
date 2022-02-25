package by.Minevich.Team;
import by.Minevich.Human.Human;

public class SystemAdministator extends Human {
    public SystemAdministator(String surname, String name, int age, int salary, int exprerience) {
        super(surname, name, age, salary, exprerience);
    }

    public SystemAdministator() {
        super();
    }

    @Override
    public String toString() {
        return "\n\t\t > Системный администратор: " + surname + ' ' + name +
                "\n\tвозраст: " + age + ", з/п: " + salary + ", опыт: " + experience;
    }
}
