package Phone;

public class PhoneId {
    private static int seqNew = 0;  // DTM000...
    private static int seqOld = 0;  // DTC000...

    public static synchronized String nextNew() {
        return String.format("DTM%03d", seqNew++);
    }

    public static synchronized String nextOld() {
        return String.format("DTC%03d", seqOld++);
    }
}
