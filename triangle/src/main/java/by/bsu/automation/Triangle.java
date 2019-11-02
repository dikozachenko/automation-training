package by.bsu.automation;

import by.bsu.automation.exception.TriangleException;

import java.util.stream.Stream;

public class Triangle {

    public static boolean isTriangle(double a, double b, double c) {
        if (checkInputValue(a, b, c)) {
            throw new TriangleException("Incorrect values");
        }
        return check(a, b, c) && check(a, c, b) && check(b, c, a);
    }

    private static boolean check(double a, double b, double c) {
        return a + b > c;
    }

    private static boolean checkInputValue(double a, double b, double c) {
        return Stream.of(a, b, c)
                .anyMatch(it-> isCorrect(it));
    }

    private static boolean isCorrect(Double value) {
        return (value <= 0 || value.isInfinite() || value.isNaN());
    }
}
