package utilities;

import java.util.Random;

public class Util {
    public static String generateIdentifier(int identifierSize) {
        Random random = new Random();
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str = "";
        for (int i = 0; i <= identifierSize; i++) {
            str.concat(String.valueOf(candidateChars.charAt(random.nextInt(candidateChars.length()))));
        }
        return str;
    }
}
