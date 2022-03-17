package by.minevich.bstu.human;

public abstract class Human {
    protected float salary;

    public String name;
    public int age;
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Human(String name, int age, float salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Human() { }

    public abstract void show();
}
