package HW2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seminar_2.LoginPage;
import seminar_2.ProfilePage;
import seminar_2.StudentPage;

public class HW4SeleniumTest extends AbstractTest {

    @Test
    void changeBirthDayInProfileSeleniumTest () throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginInSystem("GB202306611b512", "a5c6730434");

        StudentPage studentPage = new StudentPage(driver, wait);
        studentPage.openProfile();

        ProfilePage profilePage = new ProfilePage(driver, wait);
        profilePage.clickEditProfile();

        String filePath = System.getProperty("user.dir") + "/src/main/resources/anime.jpeg";
        profilePage.uploadNewAvatarImage(filePath);
        profilePage.uploadnewBirthDayDate("01.01.2001");
        profilePage.clickSaveProfileUpdateData();
        profilePage.clickCloseWidowEditingProfile();

        Assertions.assertTrue(profilePage.getUploadFileName().contains("anime.jpeg"));
        Assertions.assertEquals("C:\\fakepath\\anime.jpeg",profilePage.getUploadFileName());
        Assertions.assertEquals("01.01.2001",profilePage.getDayOfBirthText());

    }

}
