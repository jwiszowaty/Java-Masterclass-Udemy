package Polymorphism.CompositionChallenge;

public class SmartKitchen {
    CoffeeMaker brewMaster;
    DishWasher dishWasher;
    Refrigerator iceBox;
    public SmartKitchen(CoffeeMaker brewMaster, DishWasher dishWasher, Refrigerator iceBox) {
        this.brewMaster = brewMaster;
        this.dishWasher = dishWasher;
        this.iceBox = iceBox;
    }
    public CoffeeMaker getBrewMaster() {
        return brewMaster;
    }
    public DishWasher getDishWasher() {
        return dishWasher;
    }
    public Refrigerator getIceBox() {
        return iceBox;
    }
    public void setKitchenState(boolean addWater, boolean pourMilk, boolean loadDishwasher) {
        brewMaster.updateStatus(addWater);
        iceBox.updateStatus(pourMilk);
        dishWasher.updateStatus(loadDishwasher);
    }
}
