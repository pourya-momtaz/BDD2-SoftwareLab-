package calculator;

public class Calculator {
    public double reverse(int input) throws Exception {
        if (input == 0){
            throw new Exception("can't handle division by zero");
        }
        return 1/((double)input);
    }

    public double sqrt(int input) throws Exception {
        if (input < 2 && input >= 0) {
            return input;
        } else if (input < 0) {
            throw new Exception("can't handle negative values");
        }
        double  y = (double)input;
        double  result = (y + ((double )input/y)) / 2;
        while (y - result >= 0.0000001 || result - y >= 0.0000001) {
            y = result;
            result = (y + (input / y)) / 2;
        }
        return Math.round(result * 100000000.0) / 100000000.0;
    }
}
