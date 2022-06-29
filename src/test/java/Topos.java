
import org.openqa.selenium.By;
import org.testng.annotations.*;


import static org.testng.Assert.assertEquals;

public class Topos extends  BaseTest {
    @BeforeMethod
    public void navigate() {
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/typos");
    }
    @AfterMethod
    public void quitDriver () {
        super.exit();
    }

    @Test
    public void typosTest() {
        for (int i = 0; i < 10; i++) {
            driver.navigate().refresh();
            String expected = driver.findElement(By.xpath("/html/body/div[2]/div/div/p[2]")).getText();
            assertEquals(expected, "Sometimes you'll see a typo, other times you won't.", "Error: the word 'won,t' is misspelled");
        }
    }
}