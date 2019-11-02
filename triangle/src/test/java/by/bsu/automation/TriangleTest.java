package by.bsu.automation;

import by.bsu.automation.exception.TriangleException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    public void twoSidesAreEqualsPositiveTest() {
        assertTrue(Triangle.isTriangle(11.5, 11.5, 7));
    }

    @Test
    public void twoSidesAreEqualsNegativeTest() {
        assertFalse(Triangle.isTriangle(3.0, 3.0, 7));
    }

    @Test
    public void allSidesAreEqualsTest() {
        assertTrue(Triangle.isTriangle(6.0, 6.0, 6.0));
    }

    @Test
    public void sumOf2SidesEqualsThird() {
        assertFalse(Triangle.isTriangle(2, 3, 5));
    }

    @Test
    public void sideIsNaNTest() {
        assertThrows(TriangleException.class, () -> {
            Triangle.isTriangle(Double.NaN, 5, 7);
        });
    }

    @Test
    public void sideIsPositiveInfinityTest() {
        assertThrows(TriangleException.class, () -> {
            Triangle.isTriangle(Double.POSITIVE_INFINITY, 56, 77);
        });
    }

    @Test
    public void sideIsNegativeInfinityTest() {
        assertThrows(TriangleException.class, () -> {
            Triangle.isTriangle(Double.NEGATIVE_INFINITY, 56, 77);
        });
    }

    @Test
    public void allSidesEqualsZeroTest() {
        assertThrows(TriangleException.class, () -> {
            Triangle.isTriangle(0, 0, 0);
        });
    }

    @Test
    public void allSidesAreNegativeTest() {
        assertThrows(TriangleException.class, () -> {
            Triangle.isTriangle(-1, -2, -3);
        });
    }

    @Test
    public void oneSideEqualsZeroTest() {
        assertThrows(TriangleException.class, () -> {
            Triangle.isTriangle(0, 7, 4);
        });
    }
}
