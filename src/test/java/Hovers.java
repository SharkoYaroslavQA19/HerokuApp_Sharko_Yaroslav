
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class Hovers extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/hovers");
    }

    @Test
    public void hoversTest() {
        WebElement firstUser = driver.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][1]"));
        WebElement secondUser = driver.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][2]"));
        WebElement thirdUser = driver.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][3]"));

        Actions hoverAction = new Actions(driver);

        hoverAction.moveToElement(firstUser).build().perform();
        WebElement userName = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement link1 = driver.findElement(By.xpath("//h5[text()='name: user1']/following-sibling::a"));
        Assert.assertTrue(userName.isDisplayed());
        link1.click();
        WebElement verifyPage = driver.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(verifyPage.isDisplayed());
        driver.navigate().back();


        secondUser = driver.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][2]"));
        hoverAction.moveToElement(secondUser).build().perform();
        WebElement userTwoName = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement link2 = driver.findElement(By.xpath("//h5[text()='name: user2']/following-sibling::a"));
        Assert.assertTrue(userTwoName.isDisplayed());
        link2.click();
        verifyPage = driver.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(verifyPage.isDisplayed());
        driver.navigate().back();


        thirdUser = driver.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][3]"));
        hoverAction.moveToElement(thirdUser).build().perform();
        WebElement userThirdName = driver.findElement(By.xpath("//h5[text()='name: user3']"));
        WebElement link3 = driver.findElement(By.xpath("//h5[text()='name: user3']/following-sibling::a"));
        Assert.assertTrue(userThirdName.isDisplayed());
        link3.click();
        verifyPage = driver.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(verifyPage.isDisplayed());
        driver.navigate().back();

    }
}