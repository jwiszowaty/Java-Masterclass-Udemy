package Polymorphism.EncapsulationChallenge;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount) {
        int newLevel = tonerLevel + tonerAmount;
        if (newLevel < 0) {
            return -1;
        } else tonerLevel = Math.min(newLevel, 100);
        return tonerLevel;
    }
    public int printPages(int pages) {
        int sheets = duplex ? (pages + pages%2 )/2 : pages;
        pagesPrinted += sheets;
        if (duplex) System.out.println("duplex printing in progress");
        return sheets;
    }

}
