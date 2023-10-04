package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxesPage {

    public WebDriver driver;
    public WebDriverWait wait;
    WebElement checkbox1;
    WebElement checkbox2;


    public CheckboxesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getCheckbox1() {
        return driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)"));
    }

    public WebElement getCheckbox2() {
        return driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)"));
    }

    //---------------------

    public void selectCheckboxes() {
        if (!getCheckbox1().isSelected())
            getCheckbox1().click();
        if (!getCheckbox2().isSelected())
            getCheckbox2().click();
    }

    public void selectOneCheckbox(WebElement checkbox) {
        if (!checkbox.isSelected())
            checkbox.click();
    }

    public void uncheckCheckboxes() {
        if (getCheckbox1().isSelected())
            getCheckbox1().click();
        if (getCheckbox2().isSelected())
            getCheckbox2().click();
    }

}
