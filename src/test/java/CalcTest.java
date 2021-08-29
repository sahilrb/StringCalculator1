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
        public void isEmpty() {
            Assert.assertEquals(0,calc.Add(""));
        }

    @Test
    public void isSingleValue() {
    public void isSingle() {
        Assert.assertEquals(1,calc.Add("1"));
    }

    @Test
    public void sumofTwoValue() {
        public void sumofTwo() {
            Assert.assertEquals(3,calc.Add("1,2"));
        }

    @Test
    public void sumofMultipleValue() {
        public void sumofMultiple() {
            Assert.assertEquals(15,calc.Add("1,2,3,4,5"));
        }

    @Test
    public void sumofMultipleNewline() {
            Assert.assertEquals(15,calc.Add("1,2,3\n4,5"));
        }
    }
}