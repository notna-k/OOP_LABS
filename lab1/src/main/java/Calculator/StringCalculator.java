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
        ArrayList<Integer> negativeNumArr = new ArrayList<>();
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

                //adding given numbers
                if (temp.isEmpty()) throw new Exception("Delimiters cannot go one after another");
                int currentNumber = Integer.parseInt(temp);
                if(Integer.parseInt(temp) < 0){
                    negativeNumArr.add(currentNumber);
                }else {
                    numArr.add(currentNumber);
                }
                temp = "";



                j++;

            }

            if (!negativeNumArr.isEmpty()) throw new Exception("Negative numbers forbidden");
        } catch (Exception e){
            System.out.println(e);
            if (!negativeNumArr.isEmpty()) System.out.println(negativeNumArr);
            return Integer.MIN_VALUE;
        }
        return numArr.stream().mapToInt(Integer::intValue).sum(); //sum of all elements in array

    }
}
