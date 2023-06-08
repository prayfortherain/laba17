import java.util.Scanner;

public class Calculator<T extends Number> {
    private final T a;
    private final T b;

    public Calculator(T a, T b) {
        this.a = a;
        this.b = b;
    }

    public double calculate(char op) {
        return switch (op) {
            case '+' -> a.doubleValue() + b.doubleValue();
            case '-' -> a.doubleValue() - b.doubleValue();
            case '*' -> a.doubleValue() * b.doubleValue();
            case '/' -> a.doubleValue() / b.doubleValue();
            default -> throw new IllegalArgumentException("Invalid operator: " + op);
        };
    }
    public static int findIndexOfOperator(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String expression = scanner.nextLine().trim();
        int opIndex = Calculator.findIndexOfOperator(expression);
        if (opIndex == -1) {
            System.out.println("Invalid expression");
            return;
        }

        double a = Double.parseDouble(expression.substring(0, opIndex).trim());
        double b = Double.parseDouble(expression.substring(opIndex + 1).trim());
        char op = expression.charAt(opIndex);

        Calculator<Double> calculator = new Calculator<>(a, b);
        double result = calculator.calculate(op);

        System.out.println("Result: " + result);
    }
}