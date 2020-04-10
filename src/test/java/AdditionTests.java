import arithmeticOperations.Addition;
import arithmeticOperations.Division;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static java.lang.Double.NaN;

public class AdditionTests {

    @Test
    public void sumTwoNumbers() throws Exception {
        Assert.assertEquals(5.0, Addition.addition(2, 3));
        Reporter.log("When use Addition with 2, 3, out value = 5", true);
    }

    @Test
    public void sumWhenFirstNumberIsZero() throws Exception {
        Assert.assertEquals(2.0, Addition.addition(2, 0));
    }

    @Test
    public void sumWhenSecondNumberIsZero() throws Exception {
        Assert.assertEquals(2.0, Addition.addition(0, 2));
    }

    @Test
    public void sumWhenBothNumbersIsZero() throws Exception {
        Assert.assertEquals(0.0, Addition.addition(0, 0));
    }

    @Test
    public void divisionByZero() throws Exception {
        Assert.assertEquals(NaN, Division.division(0, 0));
    }


}