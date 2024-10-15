package Polymorphism.PolymorphismChallenge;

public class Main {
    public static void main(String[] args) {
        Car car = new HybridCar("a car");
        runRace(car);
        Car car2 = new ElectricCar("electric", 2,2);
        runRace(car2);
        Car car3 = new GasPoweredCar("gas", 3, 3);
        runRace(car3);
    }
    public static void runRace(Car car) {
        car.startEngine();
        car.drive();
    }
}
