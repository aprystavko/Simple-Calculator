import static mainLogic.MainLogic.*;
import static textsInApplication.TextsInApplication.*;

public class Calculator {

    public static void main(String[] args) {
        boolean repeat = true;
        while (repeat == true)
        {
            printColorMessage(INPUT_FIRST_NUMBER, "green");
            double numberOne = getNumber();

            printColorMessage(INPUT_SECOND_NUMBER, "green");
            double numberTwo = getNumber();

            int numberOperation = getArithmeticOperations();
            double result = calculateArithmeticOperations(numberOperation, numberOne, numberTwo);

            System.out.println(RESULT + result);
            repeat = repeatProgram();
        }
    }
}