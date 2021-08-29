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
            Assert.assertEquals(3, calc.Add("3"));
        }

        @Test
            public void SumofTwo() {
                Assert.assertEquals(3, calc.Add("1,2"));
            }

        @Test
            public void SumofMultiple() {
                Assert.assertEquals(15, calc.Add("1,2,3,4,5"));
            }

        @Test
        public void SUMofMultipleNewline() {
                Assert.assertEquals(21,calc.Add("1,2\n3\n4,5,6"));
            }
        @Test
        public void Newline() {
            Assert.assertEquals(0,calc.Add("\n\n\n\n\n\n"));
        }

        @Test
        public void delimiters() {
                Assert.assertEquals(3,calc.Add("//;\n1;2"));
        }

        @Test
        public void negativeNumber() {
            try {
                calc.Add("1,2,-8,4,-10,6");
            } catch (IllegalArgumentException e) {
                Assert.assertEquals("Negative numbers not allowed: -8,-10", e.getMessage());
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
    public void Ignored1000() {
        Assert.assertEquals(111,calc.Add("20002,1001,100,10,1"));
    }

    @Test
    public void SingleD1000Ignored() {
        Assert.assertEquals(0,calc.Add("5000"));
    }

    @Test
    public void randomDelimiter() {
        Assert.assertEquals(15,calc.Add("//[xxx]\n1xxx2xxx3xxx4xxx5"));
    }

    @Test
    public void multipleDelimiters() {
        Assert.assertEquals(10,calc.Add("//[;][,][;]\n1;2,3;4"));
    }

    @Test
    public void multipleDelimitersofAnyLength() {
        Assert.assertEquals(10, calc.Add("//[**][,][;]\n1**2,3,4"));
    }
}