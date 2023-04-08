package calculator;

public class Calculator {
    public double reverse(int input) {
        return 1/((double)input);
    }

    public int sqrt(int input) {
        if (input < 2) {
            return input;
        }
        int y = input;
        int result = (y + (input/y)) / 2;
        while (y - result >= 0.0000001 || result - y >= 0.0000001) {
            y = result;
            result = (y + (input / y)) / 2;
        }
        return result;
    }
}
