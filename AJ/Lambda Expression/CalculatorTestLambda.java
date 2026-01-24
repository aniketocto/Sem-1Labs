interface ICalculator {
    int calculate(int a, int b);
}

public class CalculatorTestLambda {
    public static void main(String[] args) {
        ICalculator addition = (a, b) -> a + b;
        ICalculator subtraction = (a, b) -> a - b;
        ICalculator multiplication = (a, b) -> a * b;
        ICalculator division = (a, b) -> a / b;

        int a = 20;
        int b = 10;

        System.out.println("Addition: " + addition.calculate(a, b));
        System.out.println("Subtraction: " + subtraction.calculate(a, b));
        System.out.println("Multiplication: " + multiplication.calculate(a, b));
        System.out.println("Division: " + division.calculate(a, b));
    }
}