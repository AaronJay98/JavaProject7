import java.util.Scanner;

public class E13_9 {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String userString1;
        String userString2;
        System.out.println("Welcome to my program that lets you know at what starting position the second string you inputted is in the first string or else if not it returns -1");
        System.out.println("Please enter the first word where second word will be inside of: ");
        userString1 = userInput.next().trim();
        System.out.println("Please enter the second word who we will try to find in the first word: ");
        userString2 = userInput.next().trim();

        System.out.println("The second word starts at index: " + indexOf(userString1, userString2));
    }

    public static int indexOf(String text, String str) {
        String subString = text.substring(0, str.length());
        if(subString.equals(str)) {
            return 0;
        }

        if(text.length() == 1) {
            return -1;
        }
        else {
            int index = indexOf(text.substring(1), str);
            if(index != -1) {
                return index + 1;
            }
            else
                return index;
        }
    }
}
