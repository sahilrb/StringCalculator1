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
            public void isEmpty () {
                Assert.assertEquals(0, calc.Add(""));
            }

        @Test
        public void isSingle() {
            Assert.assertEquals(1,calc.Add("1"));
        }

        @Test
            public void sumofTwo() {
                Assert.assertEquals(3,calc.Add("1,2"));
            }

        @Test
            public void sumofMultiple() {
                Assert.assertEquals(15,calc.Add("1,2,3,4,5"));
            }

        @Test
        public void sumofMultipleNewline() {
                Assert.assertEquals(21,calc.Add("1,2\n3\n4,5,6"));
            }
        @Test
        public void onlyNewline() {
            Assert.assertEquals(0,calc.Add("\n\n\n\n\n\n"));
        }

        @Test
        public void delimiters() {
                Assert.assertEquals(3,calc.Add("//;\n1;2"));
        }

        @Test
        public void negativeNumber() {
            try {
                calc.Add("1,2,-3,4,-5,6");
            } catch (IllegalArgumentException e) {
                Assert.assertEquals("Negative numbers not allowed: -3,-5", e.getMessage());
            }
        }
    @Test
    public void negativeNumberSingle() {
        try {
            calc.Add("-5");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Negative numbers not allowed: -5",e.getMessage());
        }
    }
    @Test
    public void GT1000Ignored() {
        Assert.assertEquals(111,calc.Add("1001,100,10,1"));
    }

    @Test
    public void SingleGT1000Ignored() {
        Assert.assertEquals(0,calc.Add("5000"));
    }

    public void randomDelimiter() {
        Assert.assertEquals(15,calc.Add("//[xxx]\n1xxx2xxx3xxx4xxx5"));
    }

    @Test
    public void multipleDelimiters() {
        Assert.assertEquals(6,calc.Add("//[a][b]\n1c2d3"));
    }
}