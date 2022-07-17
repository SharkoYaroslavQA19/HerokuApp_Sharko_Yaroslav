import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest{
    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/upload");
    }
    final static String FILE = "img.jpg";

    @Test
    public void uploaderTest(){
        WebElement fileButton = driver.findElement(By.id("file-upload"));
        fileButton.sendKeys(System.getProperty("user.dir")+"/src/resources/img.jpg");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, FILE);
    }
}