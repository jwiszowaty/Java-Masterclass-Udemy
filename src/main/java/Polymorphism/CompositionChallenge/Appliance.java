package Polymorphism.CompositionChallenge;

public class Appliance {
    boolean hasWorkToDo;
    public Appliance(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
    public void updateStatus(boolean status) {
        hasWorkToDo = status;
        if (hasWorkToDo) System.out.println("Work is being done...");
    }
}
