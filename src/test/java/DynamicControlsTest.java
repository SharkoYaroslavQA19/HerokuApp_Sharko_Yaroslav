import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicControlsTest extends BaseTest{

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }
    By Checkbox = By.id("checkbox");
    public boolean isCheckboxPresent(By checkboxLocator) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            driver.findElement(checkboxLocator);
        } catch (NoSuchElementException exception) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        return true;
    }
    @Test
    public void DynamicControlsCheckboxInputTest(){
        WebElement checkboxElement = driver.findElement(Checkbox);
        WebElement removeButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"),"It's gone!"));
        Assert.assertFalse(isCheckboxPresent(Checkbox));
        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(input.isEnabled());
        WebElement enableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableButton.click();
        wait.until(ExpectedConditions.and(ExpectedConditions.textToBePresentInElementLocated(By.id("message"),"It's enabled!")));
        Assert.assertTrue(input.isEnabled(), "Input must be enabled");
    }
}
