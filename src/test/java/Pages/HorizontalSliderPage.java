package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HorizontalSliderPage {

    public WebDriver driver;
    public WebDriverWait wait;
    WebElement slider;
    WebElement range;

    public HorizontalSliderPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getSlider() {
        return driver.findElement(By.cssSelector("#content > div > div > input[type=range]"));
    }

    public WebElement getRange() {
        return driver.findElement(By.id("range"));
    }

    //----------------

    public void slideToTheRight(int number) {
        for (int i = 0; i <= number; i++) {
            getSlider().sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public void slideToTheLeft(int number) {
        for (int i = 0; i <= number; i++) {
            getSlider().sendKeys(Keys.ARROW_LEFT);
        }
    }

    public String rangeNumber() {
        return getRange().getText();
    }
}
