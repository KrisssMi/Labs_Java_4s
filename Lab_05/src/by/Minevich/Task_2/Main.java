package by.Minevich.Task_2;

/* Автостоянка. Есть две автостоянки на которых доступно n и m
   машиномест соответсвенно. На одном месте может находиться только один
   автомобиль. Если все места заняты, то автомобиль не станет ждать больше
   определенного времени и уедет на другую стоянку (по кругу). Организовать парковку k автомашин. */

public class Main {
    public static final int CarCount = 10;
    public static final int ParkingPlaces = 4;

    public static void main(String[] args) {
        Parking parking = new Parking(ParkingPlaces);

        for (int i = 0; i < CarCount; i++) {
            (new Car(i, parking)).start();
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
