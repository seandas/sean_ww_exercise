import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by SDAS on 2/4/2017.

 b) Fetch each food name and its servings and store them in a Map.
Iterate through all the entries in the Map and print them.
*/
public class TEST03_Question2b_Iterate_Through_Food_Items_List extends AbstractStartWebDriver {
    @Test(priority = 1, description = "Iterate Through All Items in Food List")
    public void iterateThroughAllEntries() {
        List<WebElement> foodNames = wDriver.findElements(By.cssSelector(".title.ng-binding"));
        System.out.println("Total Food Items \t: " + foodNames.size());
        LinkedHashMap<String, String> foodMap = getFoodServingMap();
        //Formatting output to display nicely aligned
        Reporter.log("===========================================", true);
        Reporter.log(String.format("%1$-30s : %2$-20s", "Food Name","Servings"), true);
        Reporter.log("===========================================", true);
        for (String key : foodMap.keySet()) {
            String output = String.format("%1$-30s : %2$-20s", key,foodMap.get(key));
            Reporter.log(output, true);
        }
    }

    
    private LinkedHashMap<String, String> getFoodServingMap() {
        LinkedHashMap<String, String> foodMap = new LinkedHashMap<String, String>();
        List<WebElement> foodNames = wDriver.findElements(By.cssSelector(".title.ng-binding"));
        List<WebElement> foodServings = wDriver.findElements(By.cssSelector(".description.ng-binding"));
        if (foodNames.size() == foodServings.size()) {
            for (int i = 0; i < foodNames.size(); i++) {
                foodMap.put(foodNames.get(i).getText().toString(), foodServings.get(i).getText().toString());
            }
        }
        return foodMap;
    }


}
