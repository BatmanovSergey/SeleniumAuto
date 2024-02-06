package seminar_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriverWait wait;
    @FindBy(xpath = "//*[@type='text']")
    private WebElement loginField;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordField;

    @FindBy(css = "form#login button")
    private WebElement button;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public void loginInSystem(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        button.click();
    }

    public void loginWithOutAuthorization() {
        wait.until(ExpectedConditions.visibilityOf(button)).click();
    }

}
