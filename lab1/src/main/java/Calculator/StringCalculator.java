package Calculator;
import java.util.ArrayList;

public class StringCalculator {
    public int add(String numbers){
        String delimeter = ",\n";
        if (numbers.isEmpty()) return 0;

        ArrayList<Integer> numArr = new ArrayList<>();
        int j = 0;
        String temp = "";
        try {

            //Reading one number (part of the string before delimiter
            while (j < numbers.length()) {
                while (j < numbers.length() && !delimeter.contains(String.valueOf(numbers.charAt(j)))) {
                    temp += numbers.charAt(j);
                    j++;
                }
                if (temp.isEmpty()) throw new Exception("Error: Invalid delimiter usage");


                //adding given numbers
                numArr.add(Integer.parseInt(temp));
                temp = "";
                j++;

            }
        } catch (Exception e){
            System.out.println(e);
            return Integer.MIN_VALUE;
        }
        return numArr.stream().mapToInt(Integer::intValue).sum(); //sum of all elements in array

    }
}
