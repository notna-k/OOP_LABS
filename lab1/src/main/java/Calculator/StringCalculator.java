package Calculator;

import java.util.ArrayList;


public class StringCalculator {



    public int add(String numbers) throws IllegalArgumentException{
            if (numbers.isEmpty()) return 0;

            ArrayList<String> delimiter = new ArrayList<>();
            ArrayList<Integer> numArr = new ArrayList<>();
            ArrayList<Integer> negativeNumArr = new ArrayList<>();
            String NUMBERS = "-0123456789";

            String defaultDelimiters = ",\n";


            int j;

            try{
                //cutting the delimiter from string
                if(numbers.startsWith("//[")) {
                    j = 3;
                    String temp = "";
                    while(numbers.charAt(j) != '\n') {

                        while (numbers.charAt(j) != ']') {
                            if (NUMBERS.contains(String.valueOf(numbers.charAt(j)))) throw new IllegalArgumentException("Delimiters cannot be numbers");
                            temp += numbers.charAt(j);
                            if (j >= numbers.length()) throw new Exception("Invalid delimiter Schema provided");
                            j++;
                        }
                        delimiter.add(temp);
                        temp = "";
                        if(numbers.charAt(j + 1) != '\n'){
                            j = j + 2;
                        } else j++;

                    }
                    j++;                                //missing the '\n'
                    numbers = numbers.substring(j);     //cutting the number's part from string

                } else {
                    for (char el : defaultDelimiters.toCharArray()){    //if custom delimiter not defined, writing a default
                        delimiter.add(String.valueOf(el));
                    }
                }

                j = 0;
                String temp = "";
                String delim = "";


                //Reading one number (part of the string before delimiter
                while (j < numbers.length()) {

                    //saving all numeric elements
                    while (j < numbers.length() && NUMBERS.contains(String.valueOf(numbers.charAt(j)))) {
                        temp += numbers.charAt(j);
                        j++;

                    }

                    //saving the delimiter
                    while (j < numbers.length() && !NUMBERS.contains(String.valueOf(numbers.charAt(j)))) {
                        delim += numbers.charAt(j);
                        j++;

                    }

                    //writing our number to arraylist
                    if (delimiter.contains(delim) || j == numbers.length()){
                        int currentNumber = Integer.parseInt(temp);
                        if(currentNumber < 0){
                            negativeNumArr.add(currentNumber);
                        }else if (currentNumber < 1001){
                            numArr.add(currentNumber);

                        }
                        temp = "";
                        delim = "";

                    } else throw new Exception("Invalid delimiters usage");



                }

                if (!negativeNumArr.isEmpty()) throw new Exception("Negative numbers forbidden");

                return numArr.stream().mapToInt(Integer::intValue).sum();                    //sum of all elements in array
            } catch (Exception e){
                // handling exceptions
                if (!negativeNumArr.isEmpty()) System.out.println(negativeNumArr);
                throw new IllegalArgumentException(e.getMessage());
            }


        }
    }
