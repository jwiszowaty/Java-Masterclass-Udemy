package Polymorphism.OOPMasterChallenge;

public class Side {
private String type;
private String size;

    public Side(String type, String size) {
        this.type = type;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Side{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
