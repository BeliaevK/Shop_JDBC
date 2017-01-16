package Entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by k.beliaev on 30.11.2016.
 */
public class ConsoleDispatcher {

    public static void sendMessage (String message){
        System.out.println(message);
    }

    public static String readLine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
