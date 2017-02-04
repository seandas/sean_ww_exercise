import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by SDAS on 2/4/2017.
 */
/*
a) Display the third and fifth item from the above list. Your output should be:
Applesauce, unsweetened
Juice, Cranberry-apple drink
*/
public class TEST02_Question2a_Food_Items_Display_Third_N_Fifth extends AbstractStartWebDriver {
    @Test(priority = 1, description = "Get Third And Fifth Item From List of Food Items")
    public void getThirdAndFifthItemFromList() throws InterruptedException {
        List<WebElement> itemList = wDriver.findElements(By.cssSelector(".title.ng-binding"));

        Reporter.log("Third Item: " + itemList.get(2).getText(), true);
        Reporter.log("Fifth Item: " + itemList.get(4).getText(), true);

        Assert.assertEquals(itemList.get(2).getText(),"Applesauce, unsweetened", "Third Item" );
        Assert.assertEquals(itemList.get(4).getText(),"Juice, Cranberry-apple drink", "Fifth Item" );


        /*        for (int i = 0; i < itemList.size(); i++) {
            Reporter.log("Item Value: " + waitForElement(wDriver, itemList.get(i)).getText(), true);
        }*/

    }
}
