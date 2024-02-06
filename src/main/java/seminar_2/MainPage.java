package seminar_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(id = "create-btn")
    private WebElement createNewPost;
    @FindBy(xpath = "//li[@class='svelte-1rc85o5 mdc-menu-surface--anchor']/a")
    private WebElement userButton;
    @FindBy(xpath =  "//ul[@role='menu']/li")
    private WebElement profileButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createPost() {
        createNewPost.click();
    }

    public void openProfile() {
        userButton.click();
        profileButton.click();
    }


}
