package by.minevich.bstu.company;

import by.minevich.bstu.exceptions.AddException;
import by.minevich.bstu.human.Human;

public interface ICompany {
    public void add(Human human) throws AddException;
}
