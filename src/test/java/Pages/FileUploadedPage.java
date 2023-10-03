package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUploadedPage {

    WebDriver driver;
    WebDriverWait wait;
    WebElement message;
    WebElement uploadedFile;
    WebElement serverMessage;

    public FileUploadedPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getMessage() {
        return driver.findElement(By.cssSelector("#content > div > h3"));
    }

    public WebElement getUploadedFile() {
        return driver.findElement(By.id("uploaded-files"));
    }

    /*public WebElement getServerMessage() {
        return driver.findElement(By.cssSelector("body > h1"));
    }
    public String serverMessageText() {
        return getServerMessage().getText();
    }*/
}
