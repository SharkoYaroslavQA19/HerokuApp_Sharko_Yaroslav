
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class Input extends BaseTest {
    @BeforeMethod
    public void navigate() {
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/inputs");
    }
    @AfterMethod
    public void quitDriver () {
        super.exit();
    }

    @Test
    public void inputsTest() {
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        String upKeyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(upKeyResult, "1");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        String downKeyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(downKeyResult, "-3");

        // проверить ручной ввод буквенных симолов
        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys("qqq");
        String alphaResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(alphaResult, "");

        // проверить ручной ввод цифровых симолов
        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys("8");
        String numericResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals(numericResult, "8");
    }
}