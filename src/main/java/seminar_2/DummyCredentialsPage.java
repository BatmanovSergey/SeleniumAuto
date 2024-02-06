package seminar_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DummyCredentialsPage {
    private final WebDriverWait wait;
    @FindBy(xpath = "//h2[@id='simple-title']")
    private WebElement titleElement;
    @FindBy(xpath = "//div[@id='simple-content']")
    private WebElement contentElement;
    @FindBy(xpath = "//div[@class='mdc-dialog__actions']/button/span")
    private WebElement buttonCloseElement;

    public DummyCredentialsPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public WebElement findTitle () {
        return wait.until(ExpectedConditions.visibilityOf(titleElement));
    }

    public WebElement findLoginAndPW () {
        return wait.until(ExpectedConditions.visibilityOf(contentElement));
    }

    public WebElement findCloseButton () {
        return wait.until(ExpectedConditions.visibilityOf(buttonCloseElement));
    }

}
