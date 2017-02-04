import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by SDAS on 2/2/2017.
 */
public class ReusableMethods {
    public static String reverseEverything(String s){
        String reversedStr = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            //System.out.println(s.charAt(i));
            reversedStr += s.charAt(i);
        }
        return reversedStr;
    }
    /**************
     * Wait for Element to be Loaded or Visible
     ************/
    public WebElement waitForElement(WebDriver wDriver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(wDriver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

}
