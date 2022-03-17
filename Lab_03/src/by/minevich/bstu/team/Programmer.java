package by.minevich.bstu.team;

import by.minevich.bstu.human.Human;
import by.minevich.bstu.level.Level;

public class Programmer extends Human {
    public Level level;

    public Programmer(String name, int age, Level level, float salary) {
        super(name, age, salary);
        this.level = level;
    }

    public void show() {
        System.out.println("Name: " + name +
                "\nAge: " + age +
                "\nLevel: " + level +
                "\nSalary: " + salary + "\n");
    }
}
