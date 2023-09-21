package lab1;
import java.util.Scanner;
import Calculator.StringCalculator;



public class App {
    public static void main(String[] args){
        StringCalculator stringCalculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the string: ");
            String str = scanner.nextLine();


            int sum = stringCalculator.add(str);

            System.out.println();
            if (sum != Integer.MIN_VALUE) System.out.println("The sum of the numbers is: " + sum);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
