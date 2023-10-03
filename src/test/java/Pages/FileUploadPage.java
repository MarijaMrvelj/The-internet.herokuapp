package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadPage {

    WebDriver driver;
    WebDriverWait wait;
    WebElement chooseFileButton;
    WebElement uploadButton;
    WebElement dragDropUploadField;

    public FileUploadPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getChooseFileButton() {
        return driver.findElement(By.id("file-upload"));
    }

    public WebElement getUploadButton() {
        return driver.findElement(By.id("file-submit"));
    }

    /*public WebElement getDragDropUploadField() {
        //return driver.findElement(By.id("drag-drop-upload"));
        return driver.findElement(By.cssSelector(".dz-success-mark.dz-clickable"));
    }*/

    public void uploadFileWithChooseFileButton(String location) {
        getChooseFileButton().sendKeys(location);
        getUploadButton().click();
    }

    /*public void uploadFileWithDragDropField(String location) {
        getDragDropUploadField().sendKeys(location);
        getUploadButton().click();
    }*/

}
