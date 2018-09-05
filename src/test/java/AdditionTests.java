import arithmeticOperations.Addition;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AdditionTests {

    private Addition addition = new Addition();

    @Test
    public void sumTwoNumbers() throws Exception {
        Assert.assertEquals(5.0, addition.addition(2, 3));
        Reporter.log("When use Addition with 2, 3, out value = 5", true);
    }

    @Test
    public void sumWhenFirstNumberIsZero() throws Exception {
        Assert.assertEquals(2.0, addition.addition(2, 0));
    }

    @Test
    public void sumWhenSecondNumberIsZero() throws Exception {
        Assert.assertEquals(2.0, addition.addition(0, 2));
    }

    @Test
    public void sumWhenBothNumbersIsZero() throws Exception {
        Assert.assertEquals(0.0, addition.addition(0, 0));
    }

}