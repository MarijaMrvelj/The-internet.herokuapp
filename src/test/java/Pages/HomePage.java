package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    public WebDriver driver;
    public WebDriverWait wait;
    String homePageUrl;
    WebElement addRemoveElementsButton;
    WebElement fileUploadButton;
    WebElement fileDownloadButton;
    WebElement checkboxesButton;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getHomePageUrl() {
        return "https://the-internet.herokuapp.com/";
    }

    public WebElement getAddRemoveElementsButton() {
        return driver.findElement(By.linkText("Add/Remove Elements"));
    }

    public WebElement getFileUploadButton() {
        return driver.findElement(By.linkText("File Upload"));
    }

    public WebElement getFileDownloadButton() {
        return driver.findElement(By.linkText("File Download"));
    }

    public WebElement getCheckboxesButton() {
        return driver.findElement(By.linkText("Checkboxes"));
    }

    //---------------

    public void clickOnAddRemoveElementsButton() {
        getAddRemoveElementsButton().click();
    }

    public void clickOnFileUploadButton() {
        getFileUploadButton().click();
    }
    public void clickOnFileDownloadButton() {
        getFileDownloadButton().click();
    }

    public void clickOnCheckboxesButton() {
        getCheckboxesButton().click();
    }
}
