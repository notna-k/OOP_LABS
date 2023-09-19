package Calculator;

public class StringCalculator {
    public int add(String numbers){
        String delimeter = ",";
        int sum = 0;
        if (numbers.isEmpty()) return 0;

        String[] numArr = numbers.split(delimeter);
        if (numArr.length > 2) throw new Error("String length must not be greater than 2");
        for (String s : numArr) {
            sum += Integer.parseInt(s);
        }
        return sum;

    }
}
