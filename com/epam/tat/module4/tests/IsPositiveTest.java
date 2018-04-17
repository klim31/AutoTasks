import epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Klim_Starykau on 4/13/2018.
 */
public class IsPositiveTest {
    private Calculator calc;

    @BeforeGroups
    public void setUp() {
        calc = new Calculator();
        System.out.println("BeforeClass IsPositive");
    }


    @Test(dataProvider = "DP for long Positive")
    public void testSumPositive(long a,boolean b){
        Assert.assertEquals(calc.isPositive(a),b);
    }

    @Parameters({"negativeVal1,negativeVal2"})
    @Test
    public void testSumNegative(long a,boolean b){
        Assert.assertNotEquals(calc.isPositive(a),b);
    }

    @DataProvider(name = "DP for long Positive")
    private Object[][] dPLong(){
        return new Object[][]{
                {1L,true},
                {-7L,false}};
    }

    @AfterClass
    public void tearDown(){
        System.out.println("AfterClass IsPositive");
    }
}
