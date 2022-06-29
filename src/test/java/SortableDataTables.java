
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.util.List;


import static org.testng.Assert.assertEquals;

public class SortableDataTables extends BaseTest {
    @BeforeMethod
    public void navigate() {
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/tables");
    }
    @AfterMethod
    public void quitDriver () {
        super.exit();
    }

@Test
    public void sortableDataTablesTest() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".tablesorter thead tr th"));
        for (WebElement element : elements) {
            assertEquals(elements.get(0).getText(), "Last Name");
            assertEquals(elements.get(1).getText(), "First Name");
            assertEquals(elements.get(2).getText(), "Email");
            assertEquals(elements.get(3).getText(), "Due");
            assertEquals(elements.get(4).getText(), "Web Site");
            assertEquals(elements.get(5).getText(), "Action");
        }
        List<WebElement> johnSmith = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        for (WebElement element : johnSmith) {
            assertEquals(johnSmith.get(0).getText(), "Smith");
            assertEquals(johnSmith.get(1).getText(), "John");
            assertEquals(johnSmith.get(2).getText(), "jsmith@gmail.com");
            assertEquals(johnSmith.get(3).getText(), "$50.00");
            assertEquals(johnSmith.get(4).getText(), "http://www.jsmith.com");
            assertEquals(johnSmith.get(5).getText(), "edit delete");
        }
        List<WebElement> bachFrank = driver.findElements(By.xpath("//tbody/tr[2]/td"));
        for (WebElement element : bachFrank) {
            assertEquals(bachFrank.get(0).getText(), "Bach");
            assertEquals(bachFrank.get(1).getText(), "Frank");
            assertEquals(bachFrank.get(2).getText(), "fbach@yahoo.com");
            assertEquals(bachFrank.get(3).getText(), "$51.00");
            assertEquals(bachFrank.get(4).getText(), "http://www.frank.com");
            assertEquals(bachFrank.get(5).getText(), "edit delete");
        }
        List<WebElement> doeJason = driver.findElements(By.xpath("//tbody/tr[3]/td"));
        for (WebElement element : doeJason) {
            assertEquals(doeJason.get(0).getText(), "Doe");
            assertEquals(doeJason.get(1).getText(), "Jason");
            assertEquals(doeJason.get(2).getText(), "jdoe@hotmail.com");
            assertEquals(doeJason.get(3).getText(), "$100.00");
            assertEquals(doeJason.get(4).getText(), "http://www.jdoe.com");
            assertEquals(doeJason.get(5).getText(), "edit delete");
        }
        List<WebElement> timConway = driver.findElements(By.xpath("//tbody/tr[4]/td"));
        for (WebElement element : timConway) {
            assertEquals(timConway.get(0).getText(), "Conway");
            assertEquals(timConway.get(1).getText(), "Tim");
            assertEquals(timConway.get(2).getText(), "tconway@earthlink.net");
            assertEquals(timConway.get(3).getText(), "$50.00");
            assertEquals(timConway.get(4).getText(), "http://www.timconway.com");
            assertEquals(timConway.get(5).getText(), "edit delete");
        }
    }
}