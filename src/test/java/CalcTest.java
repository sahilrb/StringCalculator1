import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class CalcTest {
    Calc calc;

    @Before
    public void init() {
        calc = new Calc();
    }

    @Test
    public void isEmptyCheck() {
        Assert.assertEquals(0,calc.Add(""));
    }

    @Test
    public void isSingleValue() {
        Assert.assertEquals(1,calc.Add("1"));
    }

    @Test
    public void sumofTwoValue() {
        Assert.assertEquals(3,calc.Add("1,2"));
    }
}