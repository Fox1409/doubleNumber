import java.io.IOException;

public class Main {
    private static boolean isTwofold(int numberToCheck) {
        Integer firstFoundDigit = null;
        Integer secondFoundDigit = null;
        while (numberToCheck > 0) {
            int currentDigit = numberToCheck % 10;
            numberToCheck /= 10;

            if (firstFoundDigit == null) {
                firstFoundDigit = currentDigit;
                continue;
            } else if (firstFoundDigit == currentDigit) {
                continue;
            }
            if(secondFoundDigit == null) {
                secondFoundDigit = currentDigit;
            } else if (secondFoundDigit!=currentDigit) {
                return false;
            }
        }
        return true;
    }

    private static int findNearestTwoFold(int current){
        if(isTwofold(current)) return current;

        int ascending = current;
        int descending = current;

        while (true) {
            ascending++;
            descending--;
            if(isTwofold(ascending)) {
                return ascending;
            }
            if(isTwofold(descending)) {
                return descending;
            }
        }

    }

    public static void main (String [] ars) {
      try {
            String input = FileDao.readOneLineFromFile();
            String result = ""+findNearestTwoFold(Integer.parseInt(input));
            FileDao.writeStringToFile(result);
        } catch (IOException | NullPointerException e) {
            System.err.println(e.toString());
        }

    }
}
