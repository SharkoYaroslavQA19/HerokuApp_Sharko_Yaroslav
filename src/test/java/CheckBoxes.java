
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CheckBoxes extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void checkBoxesTest() {
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        assertEquals(checkBoxes.get(0).isSelected(), false, "the 1st checkbox is unchecked");
        checkBoxes.get(0).click();
        assertEquals(checkBoxes.get(0).isSelected(), true, "the 1st checkbox is checked");
        assertEquals(checkBoxes.get(1).isSelected(), true, "the 2nd checkbox is checked");
        checkBoxes.get(1).click();
        assertEquals(checkBoxes.get(1).isSelected(), false, "the 2nd checkbox is unchecked");
    }
}


