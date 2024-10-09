package ExpressionsStatementsAndMore;

public class MegaBytesConverter {
    public static String printMegaBytesAndKiloBytes(int kiloBytes){
        if(kiloBytes < 0) {
            throw new IllegalArgumentException("number must not be negative");
        } else {
            int kBInMB = 1024;
            int kiloBytesToMegaBytes = kiloBytes / kBInMB;
            int remainderKiloBytes = kiloBytes % kBInMB;
            return (kiloBytes + " KB = " + kiloBytesToMegaBytes + " MB and " + remainderKiloBytes + " KB");
        }
    }
}
