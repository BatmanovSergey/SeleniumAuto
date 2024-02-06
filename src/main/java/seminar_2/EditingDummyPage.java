package seminar_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditingDummyPage {
    private final WebDriverWait wait;
    @FindBy(xpath = "//form[@id='upsert-item']/div[1]/label/input")
    private WebElement firstNameInputField;

    @FindBy(css = "button[form='upsert-item']")
    private WebElement saveButton;

    public EditingDummyPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public void ChangeDummyFirstName(String name) throws InterruptedException {

        Thread.sleep(3000L);
//        String text = wait.until(ExpectedConditions.visibilityOf(firstNameInputField)).getAttribute("value");

//        if (text.length() > 5) {
////            Thread.sleep(3000L);
//            firstNameInputField.clear();
//            firstNameInputField.sendKeys("newName");
//            wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
//        } else {
////            Thread.sleep(2000L);
//            String a = RandomStringUtils.randomAlphabetic(1);
//            String b = RandomStringUtils.randomAlphanumeric(1);
//            String newName = text + a + b;
//            firstNameInputField.sendKeys(newName);
//            wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
//        }

        firstNameInputField.clear();
        wait.until(ExpectedConditions.visibilityOf(firstNameInputField)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
    }


}
