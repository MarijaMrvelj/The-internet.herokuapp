package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    public WebDriver driver;
    public WebDriverWait wait;
    WebElement addRemoveElementsButton;
    WebElement fileUploadButton;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getAddRemoveElementsButton() {
        return driver.findElement(By.linkText("Add/Remove Elements"));
    }

    public WebElement getFileUploadButton() {
        return driver.findElement(By.linkText("File Upload"));
    }

    public void clickOnAddRemoveElementsButton() {
        getAddRemoveElementsButton().click();
    }

    public void clickOnFileUploadButton() {
        getFileUploadButton().click();
    }
}
