package by.Minevich.Task_2;

public class Parking {
    private Car[] parking;
    private int parkingSize;

    public Parking(int size) {
        this.parkingSize = size;
        parking = new Car[size];
    }

    public int getFreePlace() {
        for (int i = 0; i < parkingSize; i++) {
            if (parking[i] == null)
                return i;
        }
        return -1;
    }

    public synchronized void setCar(Car car) {
        System.out.println("Car: " + car.getCarName() + " is parked.");
        parking[getFreePlace()] = car;
    }

    public synchronized void leaveCar(Car car){
        for(int i=0;i<parkingSize;i++){
            if(parking[i] == car){
                parking[i] = null;
                System.out.println("Car: " + car.getCarName() + " leave the parking.");
            }
        }
    }

    public void showParking() {
        System.out.println("Parking places: {");
        for (int i = 0; i < parkingSize; i++) {
            if(parking[i] != null){
                System.out.println("\t"+ i + ") " + parking[i].getCarName());
            }
            else{
                System.out.println("\t"+i + ") empty");
            }
        }
        System.out.println(" }");
    }
}
