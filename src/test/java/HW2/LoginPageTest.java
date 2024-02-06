package HW2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seminar_2.CreatePostPage;
import seminar_2.ElementPage;
import seminar_2.LoginPage;
import seminar_2.MainPage;

import java.util.List;

public class LoginPageTest extends AbstractTest {

    @Test// Работа на семинаре
    void loginTest() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginInSystem("Ms.TestTwo", "03b10cd119");

        Thread.sleep(2000L);
        List<WebElement> searchList = driver.findElements(By.partialLinkText("Hello"));
        Assertions.assertEquals(1, searchList.size());

        MainPage mainPage = new MainPage(driver);
        mainPage.createPost();

        List<WebElement> title = driver.findElements(By.xpath("//*[@type='text']"));
        Assertions.assertEquals(1, title.size());

        CreatePostPage createPostPage = new CreatePostPage(driver);
        createPostPage.savePost("11111111", "22222222");

        Thread.sleep(2000L);
        ElementPage elementPage = new ElementPage(driver);
        elementPage.deletePost();

    }

}
