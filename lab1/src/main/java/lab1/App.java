package lab1;
import java.util.Locale;
import java.util.Scanner;
import Calculator.StringCalculator;



public class App {
    public static void main(String[] args){

        StringCalculator stringCalculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);
        String str;


        try {
            System.out.println("Custom delimiter?[Y/n]: ");
            String ifyes = scanner.nextLine();

            System.out.print("Enter the string: ");
            if(ifyes.toLowerCase().equals("y")) {
                String str1 = scanner.nextLine();
                str1 += '\n';
                String str2 = scanner.nextLine();
                str = str1.concat(str2);
            } else {
                str = scanner.nextLine();
            }
            int sum = stringCalculator.add(str);

            System.out.println(str.charAt(3));
            if (sum != Integer.MIN_VALUE) System.out.println("The sum of the numbers is: " + sum);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
