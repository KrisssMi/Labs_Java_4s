package by.minevich.bstu.company;

import by.minevich.bstu.team.Programmer;
import by.minevich.bstu.comparator.CustomComparator;
import by.minevich.bstu.level.Level;

public class Director {
    public static void count(Company company) {
        System.out.println(company.name + " has " + company.getList().size() + " members\n");
    }

    public static void sort(Company company) {
        company.getList().sort(new CustomComparator());
    }

    public static void find(Company company, Level level) {
        for(var i : company.getList()) {
            if (i instanceof Programmer)
                if (((Programmer) i).level == level)
                    i.show();
        }
    }
}
