package Calculator;

import java.util.ArrayList;


public class StringCalculator {



    public int add(String numbers) throws IllegalArgumentException{
            if (numbers.isEmpty()) return 0;

            ArrayList<String> delimiter = new ArrayList<>();
            ArrayList<Integer> numArr = new ArrayList<>();
            ArrayList<Integer> negativeNumArr = new ArrayList<>();

            String defaultDelimiters = ",\n";


            int j;

            try{
                //cutting the delimiter from string
                if(numbers.startsWith("//[")) {
                    j = 3;
                    String temp = "";
                    while(numbers.charAt(j) != '\n') {

                        while (numbers.charAt(j) != ']') {
                            temp += numbers.charAt(j);
                            if (j >= numbers.length()) throw new Exception("Invalid delimiter Schema provided");
                            j++;
                        }
                        delimiter.add(temp);
                        temp = "";
                        if(numbers.charAt(j + 1) != '\n'){
                            j = j + 2;
                        } else j++;
                                              //missing the "]["
                    }
                    j++;                                //missing the '\n'
                    numbers = numbers.substring(j);     //cutting the number's part from string

                } else {
                    for (char el : defaultDelimiters.toCharArray()){
                        delimiter.add(String.valueOf(el));
                    }
                }

                j = 0;
                String temp = "";



                //Reading one number (part of the string before delimiter
                while (j < numbers.length()) {

                    while (j < numbers.length() && !delimiter.contains(String.valueOf(numbers.charAt(j)))) {
                        temp += numbers.charAt(j);
                        j++;
                    }
                    while (j < numbers.length() && delimiter.contains(String.valueOf(numbers.charAt(j)))) {
                        j++;
                    }


                    //adding given numbers
                    if (temp.isEmpty()) throw new Exception("Delimiters cannot go one after another");
                    int currentNumber = Integer.parseInt(temp);
                    if(currentNumber < 0){
                        negativeNumArr.add(currentNumber);
                    }else if (currentNumber < 1001){
                        numArr.add(currentNumber);
                    }
                    temp = "";




                }

                if (!negativeNumArr.isEmpty()) throw new Exception("Negative numbers forbidden");
            } catch (Exception e){
                // handling exceptions
                System.out.println(negativeNumArr);
                throw new IllegalArgumentException(e.getMessage());
            }
            return numArr.stream().mapToInt(Integer::intValue).sum(); //sum of all elements in array

        }
    }
