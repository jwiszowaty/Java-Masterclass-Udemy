package Polymorphism.PolymorphismChallenge;

public class GasPoweredCar extends Car{
    private double avgKmPerLitre;
    private int cylinders = 6;

    public GasPoweredCar(String description) {
        super(description);
    }

    public GasPoweredCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.println("Gas - Starting the engine");
    }
    @Override
    protected void runEngine() {
        System.out.println(" Gas - The engine is starting");
    }
}
