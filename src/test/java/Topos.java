
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


import java.util.List;

import static org.testng.Assert.assertEquals;

public class Topos extends  BaseTest {
    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/typos");
    }

    @Test
    public void typosTest() {
        for (int i = 0; i < 10; i++) {
            driver.navigate().refresh();
            List<WebElement> expected = driver.findElements(By.tagName("p"));
            assertEquals(expected.get(1).getText(), "Sometimes you'll see a typo, other times you won't.", "Error: the word 'won,t' is misspelled");
        }
    }
}