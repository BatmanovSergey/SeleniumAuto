package HW2;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import seminar_2.DummyCredentialsPage;
import seminar_2.EditingDummyPage;
import seminar_2.LoginPage;
import seminar_2.StudentPage;

public class DummyTest extends AbstractTest {

    @Test
        // Домашнее задание 2: задача 1
    void loginWithOutAuthorizationTest() {
        driver.get("https://test-stand.gb.ru/login");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginWithOutAuthorization();

        WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h2[@class='svelte-uwkxn9']")));
        Assertions.assertEquals("401", error.getText());
    }

    @Test
        // Домашнее задание 2: задача 2
    void dummyChangeNameTest() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginInSystem("GB202306611b512", "a5c6730434");

        WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[@href='/about']")));
        Assertions.assertEquals("About", search.getText());

        StudentPage studentPage = new StudentPage(driver, wait);
        studentPage.editStudent("20004");

        WebElement searchId = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(" //span[@slot='title']")));
        Assertions.assertEquals("Editing Dummy 20004", searchId.getText());

        String a = RandomStringUtils.randomAlphabetic(3); // генерит буквы
        String b = RandomStringUtils.randomAlphanumeric(3); // генерит буквы и цифры
        String newName = a + b;

        EditingDummyPage editingDummyPage = new EditingDummyPage(driver, wait);
        editingDummyPage.ChangeDummyFirstName(newName);

        String checkName = studentPage.getStudentNameByid("20004");
        Assertions.assertNotEquals(newName, checkName);
    }

    @Test
        // Домашнее задание 2: задача 3
    void credentialsWindowTest() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginInSystem("GB202306611b512", "a5c6730434");

        WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[@href='/about']")));
        Assertions.assertEquals("About", search.getText());

        StudentPage studentPage = new StudentPage(driver, wait);
        studentPage.checkStudent("20004");

        // Вариант проверки - 1
        WebElement checkTitle = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(" //h2[@id='simple-title']")));
//        Assertions.assertEquals("Dummy credentials", checkTitle.getText());
        WebElement checkLoginAndPW = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(" //div[@id='simple-content']")));
//        Assertions.assertTrue((checkLoginAndPW.getText().contains("Login")));
//        Assertions.assertTrue((checkLoginAndPW.getText().contains("PW")));
        WebElement checkCloseButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(" //div[@class='mdc-dialog__actions']/button/span")));
//        Assertions.assertEquals("CLOSE", checkButton.getText());

        // или проверка через Assertions.assertAll
        Assertions.assertAll(() -> Assertions.assertEquals("Dummy credentials", checkTitle.getText()),
                () -> Assertions.assertTrue(checkLoginAndPW.getText().contains("Login")),
                () -> Assertions.assertTrue(checkLoginAndPW.getText().contains("PW")),
                () -> Assertions.assertEquals("CLOSE", checkCloseButton.getText()));

        // Вариант проверки - 2

        DummyCredentialsPage dummyCredentialsPage = new DummyCredentialsPage(driver, wait);
        Assertions.assertEquals("Dummy credentials", dummyCredentialsPage.findTitle().getText());
        Assertions.assertTrue((dummyCredentialsPage.findLoginAndPW().getText().contains("Login")));
        Assertions.assertTrue((dummyCredentialsPage.findLoginAndPW().getText().contains("PW")));
        Assertions.assertEquals("CLOSE", dummyCredentialsPage.findCloseButton().getText());

        // или проверка через Assertions.assertAll
//        Assertions.assertAll(() -> Assertions.assertEquals("Dummy credentials", dummyCredentialsPage
//                        .findTitle().getText()),
//                () -> Assertions.assertTrue((dummyCredentialsPage.findLoginAndPW().getText().contains("Login"))),
//                () -> Assertions.assertTrue((dummyCredentialsPage.findLoginAndPW().getText().contains("PW"))),
//                () -> Assertions.assertEquals("CLOSE", dummyCredentialsPage.findCloseButton().getText()));

    }
}
