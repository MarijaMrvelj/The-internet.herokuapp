package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class FileDownloadPage {

    WebDriver driver;
    WebDriverWait wait;
    WebElement files;
    WebElement file;

    public FileDownloadPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getFile(String linkedName) {
        return driver.findElement(By.linkText(linkedName));
    }

    //----------

    public void downloadFile(String linkedName) {
        getFile(linkedName).click();
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File f = new File(downloadPath + fileName);
       return f.exists();
    }

}
