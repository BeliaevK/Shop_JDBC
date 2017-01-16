package Utilities;

/**
 * Created by k.beliaev on 22.11.2016.
 */
public class IdGenerator {

    private static int count=1;

    public static int nextId() {
        return count++;
    }
}
