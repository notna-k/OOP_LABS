package lab1;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import Calculator.StringCalculator;



public class App {
    public static void main(String[] args){

        StringCalculator stringCalculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);


        try {
            String str = "";

            System.out.println("Custom delimiter?[Y/n]: ");
            String ifyes = scanner.nextLine();

            System.out.print("Enter the string: ");
            if(ifyes.toLowerCase().equals("y")) {
                String str1 = scanner.nextLine();
                str1 += '\n';
                String str2 = scanner.nextLine();
                str = str1.concat(str2);
            } else {
                System.out.println("(,)/(\\n):");
                String delimiter = scanner.nextLine();
                if(delimiter.equals(",")){
                    System.out.println("Enter the string: ");
                    str = scanner.nextLine();
                } else if (delimiter.equals("\\n")){
                    System.out.println("Enter the string (empty value to end):");
                    String temp;
                    while(true){
                        temp = scanner.nextLine();
                        if (temp.isEmpty()) break;
                        str += temp;
                        str += '\n';
                    }

                } else throw new Exception("Invalid delimiter provided");

            }
            int sum = stringCalculator.add(str);

            if (sum != Integer.MIN_VALUE) System.out.println("The sum of the numbers is: " + sum);

        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }

}
