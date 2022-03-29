package by.Minevich.Task_1;

public class Main {

    /* Вход в университет. В БГТУ есть две двери, через которые студенты
       могут входить и выходить. По обоим концам дврей собралось много
       студентов. Обеспечить безопасное движение в обоих направлениях. Студента
       можно перенаправить из одной двери в другую при превышении заданного времени ожидания. */

    public static final int StudentCount = 15;
    public static final int FuditoriumSize = 5;

    public static void main(String[] args) {
        Auditorium parking = new Auditorium(FuditoriumSize);

        for (int i = 0; i < StudentCount; i++) {
            (new Students(i, parking)).start();
            try{
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
            }
        }
    }
}
