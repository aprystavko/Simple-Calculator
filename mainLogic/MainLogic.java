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
        switch (Color) {
            case "red":
                style = "[31m";
                break;
            case "green":
                style = "[32m";
                break;
            case "yellow":
                style = "[33m";
                break;
            case "blue":
                style = "[34m";
                break;
            case "violet":
                style = "[35m";
                break;
            default:
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

    public static boolean repeatProgram() {
        printColorMessage(REPEAT_PROGRAM, "violet");
        boolean repeatProgram;
        int repeat;

        if (sc.hasNextInt()) {
            repeat = sc.nextInt();

            switch (repeat) {
                case 1:
                    repeatProgram = true;
                case 2:
                    repeatProgram = false;
            }
        } else
            printColorMessage(REPEAT_CHOICE, "red");
        sc.next();
        repeatProgram = repeatProgram();
        return repeatProgram;
    }


}