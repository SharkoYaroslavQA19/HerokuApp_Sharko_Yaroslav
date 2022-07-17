
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;


public class ContextMenuTest extends BaseTest {
    final static String EXPECTED = "You selected a context menu";

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
    }

    @Test
    public void checkBoxesTest() {
        WebElement ContextMenu =driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(ContextMenu).perform();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals(text, EXPECTED);

    }
}