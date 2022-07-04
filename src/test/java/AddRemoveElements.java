import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


import static org.testng.Assert.assertEquals;

public class AddRemoveElements extends BaseTest {


    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test
    public void addRemoveElementsTest() {
        WebElement addButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
        addButton.click();
        addButton.click();
        int buttonsQuantity = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        assertEquals(buttonsQuantity, 2, "Two button is remaining");
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        int deletedButtonsQuantity = driver.findElements(By.className("added-manually")).size();
        assertEquals(deletedButtonsQuantity, 1, "One button is remaining");
    }
}