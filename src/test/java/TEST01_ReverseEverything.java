import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by SDAS on 2/2/2017.
 */
public class TEST01_ReverseEverything extends ReusableMethods {
    public String s = "It's always a pleasure to meet someone friendly! I wish everyone were friendly!!!";


    @Test(priority = 1, description = "testReverseEverythingPos")
    public void displayReversedString(){
        Reporter.log("Reversed String Value is: \n" + reverseEverything(s), true);
    }

/*    @Test(priority = 2, description = "testReverseEverythingPos")
    public void testReverseEverythingNeg(){
        Assert.assertEquals(reverseEverything(s).length(), s.length());
        Assert.assertEquals(reverseEverything(reverseEverything(s)), s);
    }*/



}
