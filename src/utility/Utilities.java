package utility;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

//    public static boolean onlyContainsNumbers(String text) {
//        return (text.matches("[0-9]+"));
//    }

    public static String onlyContainsNumbers(String text) {
        return (text.matches("[0-9]+")) ? text : "Contains letters. Not valid number";
    }

    public static String max40Chars(String string){
        return (string.length()<=40) ? string : string.substring(0,40);
    }

    public static boolean validEmail(String email){
        return (email.contains("@") && email.contains("."));
    }

    public static boolean validIntRange(int start, int end, int value){
        return ((value >= start) && (value <= end));
    }

    public static boolean validDoubleNonNegative(double number) { return (number >=0);}

//    public static boolean validIndex(int index, FloorList list){
//        return (index >= 0 && index < list.size());
//    }

//    public static boolean validPhoneNumber(String phoneNumber) {
//        String regex = "^\\+?[0-9. ()-]{10,25}$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(phoneNumber);
//        return matcher.matches();
//    }

    public static boolean validParty(String party){
        party=party.toLowerCase();
        if(party.equals("finna fail") || party.equals("sinn fein") || party.equals("fine gael") || party.equals("green party") || party.equals("labour party"))
            return true;
        else
            return false;
    }

    public static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1).toLowerCase();
    }

    public static int readNextInt(String prompt) {
        do {
            var scanner = new Scanner(System.in);
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.next());
            }
            catch (NumberFormatException e) {
                System.err.println("\tEnter a number please.");
            }
        }  while (true);
    }

    public static double readNextDouble(String prompt) {
        do {
            var scanner = new Scanner(System.in);
            try{
                System.out.print(prompt);
                return Double.parseDouble(scanner.next());
            }
            catch (NumberFormatException e) {
                System.err.println("\tEnter a number please.");
            }
        }  while (true);
    }

    public static Float readNextFloat(String prompt) {
        do {
            var scanner = new Scanner(System.in);
            try{
                System.out.print(prompt);
                return Float.parseFloat(scanner.next());
            }
            catch (NumberFormatException e) {
                System.err.println("\tEnter a number please.");
            }
        }  while (true);
    }

    public static String validNextLine(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        return input.nextLine();
    }

    public static char validNextChar(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        return input.next().charAt(0);
    }
}
