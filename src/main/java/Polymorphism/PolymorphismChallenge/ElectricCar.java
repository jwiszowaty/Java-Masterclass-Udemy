package Polymorphism.PolymorphismChallenge;

public class ElectricCar extends Car{
    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String description) {
        super(description);
    }

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }
    @Override
    public void startEngine() {
        System.out.println("Electric - Starting the engine");
    }
    @Override
    protected void runEngine() {
        System.out.println(" Electric - The engine is starting");
    }
}
