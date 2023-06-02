import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Function;


public class Main {
    public static void main(String[] args) {
        BinaryOperator<Double> plus = (x, y)-> x+y;
        BinaryOperator<Double> minus = (x, y)-> x-y;
        BinaryOperator<Double> multiply = (x, y) -> x*y;
        BinaryOperator<Double> divide = (x, y) -> x/y;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число:");
        double x = in.nextDouble();
        System.out.println("Введите второе число:");
        double y = in.nextDouble();
        System.out.println("Введите математическое действие:");
        String action = in.next();
        double result = 0;
        switch (action) {
            case "+" -> result = plus.apply(x, y);
            case "-" -> result = minus.apply(x, y);
            case "*" -> result = multiply.apply(x, y);
            case "/" -> result = divide.apply(x, y);
            default -> System.out.println("There is no match");
        }

        System.out.println(x + action + y + "=" +result);
    }
    public static int isInteger(double x){
        return (int) (x % 1 == 0 ? x : null);
    }
}