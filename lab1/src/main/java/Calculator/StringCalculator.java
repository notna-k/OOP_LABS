package Calculator;

public class StringCalculator {
    public int add(String numbers){
        String delimeter = ",";
        int sum = 0;
        if (numbers.isEmpty()) return 0;

        String[] numArr = numbers.split(delimeter);
        for (String s : numArr) {
            sum += Integer.parseInt(s);
        }
        return sum;

    }
}
