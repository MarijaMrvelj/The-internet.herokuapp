package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddRemoveElementsPage {
    public WebDriver driver;
    public WebDriverWait wait;
    WebElement addElementButton;
    WebElement deleteButton;

    public AddRemoveElementsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getAddElementButton() {
        return driver.findElement(By.cssSelector("#content > div > button"));
    }

    public List<WebElement> getDeleteButton() {
        return driver.findElements(By.className("added-manually"));
    }

    public void addElement() {
        getAddElementButton().click();
    }

    public void deleteElement(int position) {
        for (int i = 0; i < getDeleteButton().size(); i++) {
            if (i == position) {
                getDeleteButton().get(i).click();
                break;
            }
        }
    }

    public void deleteAllElements() {
        int i = 0;
        while (i < getDeleteButton().size())
            getDeleteButton().get(i).click();
    }

    public int countElements() {
        return getDeleteButton().size();
    }

}
