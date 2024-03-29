package by.minevich.bstu.company;

import by.minevich.bstu.exceptions.AddException;
import by.minevich.bstu.human.Human;

import java.util.ArrayList;

public class Company implements ICompany{
    private int count = 0;
    private final int maxCount;
    private final ArrayList<Human> list;
    public String name;

    public Company(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        list = new ArrayList<>();
    }

    public Company(String name) {
        this.name = name;
        this.maxCount = 5;
        list = new ArrayList<>();
    }

    public void add(Human human) throws AddException {
        if (count < maxCount) {
            list.add(human);
            count++;
        }
        else
            throw new AddException("Company is full", count);
    }

    public ArrayList<Human> getList() {
        return list;
    }

    public void show() {
        for(var i : list) {
            i.show();
        }
    }
}
