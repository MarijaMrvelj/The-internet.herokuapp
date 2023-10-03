package Base;

import Pages.AddRemoveElementsPage;
import Pages.FileUploadPage;
import Pages.FileUploadedPage;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public AddRemoveElementsPage addRemoveElementsPage;
    public FileUploadPage fileUploadPage;
    public FileUploadedPage fileUploadedPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver, wait);
        addRemoveElementsPage = new AddRemoveElementsPage(driver, wait);
        fileUploadPage = new FileUploadPage(driver, wait);
        fileUploadedPage = new FileUploadedPage(driver, wait);
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
