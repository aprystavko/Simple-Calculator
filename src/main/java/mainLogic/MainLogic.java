package mainLogic;

import java.util.Scanner;

import static arithmeticOperations.Addition.addition;
import static arithmeticOperations.Division.division;
import static arithmeticOperations.Multiplication.multiplication;
import static arithmeticOperations.Subtraction.subtraction;
import static textsInApplication.TextsInApplication.*;

public class MainLogic {

    static Scanner sc = new Scanner(System.in);

    public static void printColorMessage(String message, String Color) {
        String style;
        if (Color.equals("red")) {
            style = "[31m";

        } else if (Color.equals("green")) {
            style = "[32m";

        } else if (Color.equals("yellow")) {
            style = "[33m";

        } else if (Color.equals("blue")) {
            style = "[34m";

        } else if (Color.equals("violet")) {
            style = "[35m";

        } else {
            style = "[31m";
        }
        System.out.println((char) 27 + style + message);
    }

    public static double getNumber() {
        double number;
        if (sc.hasNextDouble()) {
            number = sc.nextDouble();
        } else {
            printColorMessage(NUMBER_IS_NOT_VALID, "red");
            sc.next();
            number = getNumber();
        }
        return number;
    }

    public static int getArithmeticOperations() {
        printColorMessage(INPUT_ARITHMETIC_OPERATIONS, "blue");
        int operationNumber;
        if (sc.hasNextInt()) {
            operationNumber = sc.nextInt();
        } else {
            printColorMessage(ARITHMETIC_OPERATION_IS_NOT_SUPPORTED, "red");
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
                printColorMessage(ARITHMETIC_OPERATION_IS_NOT_SUPPORTED, "red");
                result = calculateArithmeticOperations(getArithmeticOperations(), numberOne, numberTwo);
        }
        return result;
    }

    public static int getRepeatProgram() {
        int repeat;
        printColorMessage(REPEAT_PROGRAM, "violet");
        if (sc.hasNextInt()) {
            repeat = sc.nextInt();

            if ((repeat != 1) && (repeat != 2)) {
                printColorMessage(REPEAT_CHOICE, "red");
                repeat = getRepeatProgram();
            }

        } else {
            printColorMessage(REPEAT_CHOICE, "red");
            sc.next();
            repeat = getRepeatProgram();
        }
        return repeat;
    }
}