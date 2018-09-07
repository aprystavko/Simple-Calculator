package mainLogic;

import java.util.Scanner;

import static arithmeticOperations.Addition.addition;
import static arithmeticOperations.Division.division;
import static arithmeticOperations.Multiplication.multiplication;
import static arithmeticOperations.Subtraction.subtraction;
import static textsInApplication.TextsInApplication.*;

public class MainLogic {

    static Scanner sc = new Scanner(System.in);

    public static void printColorBoldMessage(String message, String Color) {
        String style;
        if (Color.equals("red")) {
            style = "[01;31m";
        } else if (Color.equals("green")) {
            style = "[01;32m";
        } else if (Color.equals("yellow")) {
            style = "[01;33m";
        } else if (Color.equals("blue")) {
            style = "[01;34m";
        } else if (Color.equals("violet")) {
            style = "[01;35m";
        } else if (Color.equals("turquoise")) {
            style = "[01;36m";
        } else if (Color.equals("grey")) {
            style = "[01;37m";
        } else {
            style = "[01;31m";
        }
        System.out.println((char) 27 + style + message);
    }

    public static double getNumber() {
        double number;
        if (sc.hasNextDouble()) {
            number = sc.nextDouble();
        } else {
            printColorBoldMessage(NUMBER_IS_NOT_VALID, "red");
            sc.next();
            number = getNumber();
        }
        return number;
    }

    public static int getArithmeticOperations() {
        printColorBoldMessage(INPUT_ARITHMETIC_OPERATIONS, "blue");
        int operationNumber;
        if (sc.hasNextInt()) {
            operationNumber = sc.nextInt();
        } else {
            printColorBoldMessage(ARITHMETIC_OPERATION_IS_NOT_SUPPORTED, "red");
            sc.next();
            operationNumber = getArithmeticOperations();
        }
        return operationNumber;
    }

    public static double calculateArithmeticOperations(int arithmeticOperation, double numberOne, double numberTwo) {
        double result;
        switch (arithmeticOperation) {
            case 1:
                result = addition(numberOne, numberTwo);
                break;
            case 2:
                result = subtraction(numberOne, numberTwo);
                break;
            case 3:
                result = multiplication(numberOne, numberTwo);
                break;
            case 4:
                result = division(numberOne, numberTwo);
                break;
            default:
                printColorBoldMessage(ARITHMETIC_OPERATION_IS_NOT_SUPPORTED, "red");
                result = calculateArithmeticOperations(getArithmeticOperations(), numberOne, numberTwo);
        }
        return result;
    }

    public static int getRepeatProgram() {
        int repeat;
        printColorBoldMessage(REPEAT_PROGRAM, "violet");
        if (sc.hasNextInt()) {
            repeat = sc.nextInt();

            if ((repeat != 1) && (repeat != 2)) {
                printColorBoldMessage(REPEAT_CHOICE, "red");
                repeat = getRepeatProgram();
            }

        } else {
            printColorBoldMessage(REPEAT_CHOICE, "red");
            sc.next();
            repeat = getRepeatProgram();
        }
        return repeat;
    }

}
