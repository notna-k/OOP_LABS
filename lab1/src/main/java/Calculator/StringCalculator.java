package Calculator;
import java.util.ArrayList;

public class StringCalculator {

    public int add(String numbers){
        /*
        delimiter schema:
        //[delimiter]\n[numbers]
         */
        if (numbers.isEmpty()) return 0;

        String delimiter = ",\n";
        ArrayList<Integer> numArr = new ArrayList<>();
        int j;

        try{
            //cutting the delimiter from string
            if(numbers.startsWith("//")) {
                j = 2;
                delimiter = "";
                while (numbers.charAt(j) != '\n') {
                    delimiter += numbers.charAt(j);
                    if (j >= numbers.length()) throw new Exception("Invalid delimiter Schema provided");
                    j++;
                }
                j++;
                numbers = numbers.substring(j);

            }

            j = 0;
            String temp = "";


            //Reading one number (part of the string before delimiter
            while (j < numbers.length()) {
                while (j < numbers.length() && !delimiter.contains(String.valueOf(numbers.charAt(j)))) {
                    temp += numbers.charAt(j);
                    j++;
                }
                if (temp.isEmpty()) throw new Exception("Delimiters cannot go one after another");
                numArr.add(Integer.parseInt(temp));
                temp = "";


                //adding given numbers
                j++;

            }
        } catch (Exception e){
            System.out.println(e);
            return Integer.MIN_VALUE;
        }
        return numArr.stream().mapToInt(Integer::intValue).sum(); //sum of all elements in array

    }
}
