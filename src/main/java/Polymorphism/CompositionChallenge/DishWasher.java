package Polymorphism.CompositionChallenge;

public class DishWasher extends Appliance{
    public DishWasher(boolean hasWorkToDo) {
        super(hasWorkToDo);
    }
    public void doDishes() {
        updateStatus(true);
    }
}
