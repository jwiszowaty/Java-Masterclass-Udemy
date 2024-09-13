package ExpressionsStatementsAndMore;

public class MegaBytesConverter {
    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        if(kiloBytes < 0) {
            System.out.print("Invalid Value");
        } else {
            int kBInMB = 1024;
            int kiloBytesToMegaBytes = kiloBytes / kBInMB;
            int remainderKiloBytes = kiloBytes % kBInMB;
            System.out.print(kiloBytes + " KB = " + kiloBytesToMegaBytes + " MB and " + remainderKiloBytes + " KB");
        }
    }
}
