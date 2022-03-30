/*
* The "BlowUp" program Blows Up a string.
*
* @author  Abdul Basit Butt
* @version 1.0
* @since   2022-02-03
*/

import java.util.Scanner;

/**
* A class.
*/
final class BlowUp {
    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    *
    */
    private BlowUp() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * The starting blowUp() function.
    *
    * @param stringArray is any string
    *
    * @return reversed array
    */
    public static String blowUp(final String stringArray) {
        String returnValue = "";
        final char firstLetter = stringArray.charAt(0);
        final int stringLen = stringArray.length();
        if (stringLen == 1) {
            if (!Character.isDigit(firstLetter)) {
                returnValue = Character.toString(firstLetter);
            }
        } else if (stringLen > 1) {
            if (Character.isDigit(firstLetter)) {
                final int firtCharNum = Character.getNumericValue(firstLetter);
                if (Character.isDigit(stringArray.charAt(1))) {
                    for (int counter = 0; counter < firtCharNum; counter++) {
                        returnValue = returnValue + stringArray.charAt(1);
                    }
                } else {
                    for (int counter = 1; counter < firtCharNum; counter++) {
                        returnValue = returnValue + stringArray.charAt(1);
                    }
                }
                returnValue = returnValue + blowUp(stringArray.substring(1));
            } else {
                returnValue = firstLetter
                    + blowUp(stringArray.substring(1));
            }
        } else {
            returnValue = Character.toString(firstLetter);
        }
        return returnValue;
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string:");
        final String input = scanner.nextLine();

        final String blownAway = blowUp(input);
        System.out.println("\nYour string was BLOWN UP!\n" + blownAway);

        System.out.println("\nDone.");
    }
}
