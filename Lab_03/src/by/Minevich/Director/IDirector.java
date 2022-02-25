package by.Minevich.Director;

import by.Minevich.Company.Company;
import by.Minevich.Human.Human;
import java.util.ArrayList;

public interface IDirector {
    int counting(Company company);
    void sort(ArrayList<Human> list);
    void find(Company company,int exp);
}
