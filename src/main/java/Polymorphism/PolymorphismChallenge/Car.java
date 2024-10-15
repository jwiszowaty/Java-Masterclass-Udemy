package Polymorphism.PolymorphismChallenge;

public class Car {
    private String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.println("Starting the engine");
    }

    protected void runEngine() {
        System.out.println("The engine is starting");
    }

    public void drive() {
        System.out.println("The car is moving. It is " + getClass().getSimpleName());
        runEngine();
    }
}
