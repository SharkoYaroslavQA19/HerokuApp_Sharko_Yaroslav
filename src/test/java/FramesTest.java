import org.bouncycastle.crypto.tls.SRTPProtectionProfile;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTest {
    final static String EXPECTED = "Your content goes here.";

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/frames");
    }

    @Test
    public void checkBoxesTest() {
        WebElement iframeButton =driver.findElement(By.xpath("//a[@href='/iframe']"));
        iframeButton.click();
        WebElement iframe =driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(0);
        String actualText = driver.findElement(By.cssSelector("#tinymce p")).getText();
        Assert.assertEquals(actualText, EXPECTED);

    }
}
