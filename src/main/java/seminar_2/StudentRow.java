package seminar_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentRow {
    private final WebElement root;
    private final WebDriverWait wait;

    public StudentRow(WebElement root, WebDriverWait wait) {
        this.root = root;
        this.wait = wait;
    }

    public String getIdStudent() {
        return wait.until(ExpectedConditions.visibilityOf(root)).
                findElement(By.xpath("./td[1]")).getText();
    }

    public String getNameStudent() {
        return root.findElement(By.xpath("./td[2]")).getText();
    }

    public void clickEditButtonInRow() {
        root.findElement(By.xpath("./td[7]/button[2]")).click();
    }

    public void clickCredentialButtonInRow() {
        root.findElement(By.xpath("./td[7]/button[1]")).click();
    }



}
