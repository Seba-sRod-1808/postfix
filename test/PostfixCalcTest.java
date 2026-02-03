package test;

import src.Calc;
import src.PostfixCalc;

public class PostfixCalcTest {

    static Calc calc = new PostfixCalc();

    public static void main(String[] args) {
        testBasicOperations();
        testComplexExpression();
        testDecimals();
        testNegativeNumbers();
        testDivisionByZero();
        testEmptyExpression();
        testInvalidOperator();
        testMalformedExpression();
    }

    static void testBasicOperations() {
        assert calc.operate("3 4 +") == 7 : "sum failed";
        assert calc.operate("10 3 -") == 7 : "subtraction failed";
        assert calc.operate("4 5 *") == 20 : "multiplication failed";
        assert calc.operate("20 4 /") == 5 : "division failed";
        assert calc.operate("2 3 ^") == 8 : "power failed";
        System.out.println("testBasicOperations pasó");
    }

    static void testComplexExpression() {
        assert calc.operate("5 1 2 + 4 * + 3 -") == 14 : "complex failed";
        System.out.println("testComplexExpression pasó");
    }

    static void testDecimals() {
        assert calc.operate("3.5 2 +") == 5.5 : "decimals failed";
        System.out.println("testDecimals pasó");
    }

    static void testNegativeNumbers() {
        assert calc.operate("-5 3 +") == -2 : "negative failed";
        System.out.println("testNegativeNumbers pasó");
    }

    static void testDivisionByZero() {
        try {
            calc.operate("10 0 /");
            assert false : "should throw";
        } catch (ArithmeticException e) {
            System.out.println("testDivisionByZero pasó");
        }
    }

    static void testEmptyExpression() {
        try {
            calc.operate("");
            assert false : "should throw";
        } catch (IllegalArgumentException e) {
            System.out.println("testEmptyExpression pasó");
        }
    }

    static void testInvalidOperator() {
        try {
            calc.operate("3 4 %");
            assert false : "should throw";
        } catch (IllegalArgumentException e) {
            System.out.println("testInvalidOperator pasó");
        }
    }

    static void testMalformedExpression() {
        try {
            calc.operate("3 +");
            assert false : "should throw";
        } catch (IllegalArgumentException e) {
            System.out.println("testMalformedExpression pasó");
        }
    }
}
