package Polymorphism.PolymorphismChallenge;

public class HybridCar extends Car{
    private double avgKmPerLitre;
    private int batterySize;
    private int cylinders;

    public HybridCar(String description) {
        super(description);
    }

    public HybridCar(String description, double avgKmPerLitre, int batterySize, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.println("Hybrid - Starting the engine");
    }
    @Override
    protected void runEngine() {
        System.out.println(" Hybrid - The engine is starting");
    }
}
