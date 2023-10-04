package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AvailableExamplesTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }

    @Test
    public void verifyThatElementsCanBeAdded() {
        homePage.clickOnAddRemoveElementsButton();
        addRemoveElementsPage.addElement();
        addRemoveElementsPage.addElement();
        addRemoveElementsPage.addElement();
        addRemoveElementsPage.addElement();

        Assert.assertFalse(addRemoveElementsPage.getDeleteButton().isEmpty());
        Assert.assertEquals(addRemoveElementsPage.getDeleteButton().size(), addRemoveElementsPage.countElements());
        Assert.assertTrue(addRemoveElementsPage.getDeleteButton().get(0).isDisplayed());
        Assert.assertTrue(addRemoveElementsPage.getDeleteButton().get(1).isDisplayed());
        Assert.assertTrue(addRemoveElementsPage.getDeleteButton().get(2).isDisplayed());
        Assert.assertTrue(addRemoveElementsPage.getDeleteButton().get(3).isDisplayed());
    }

    @Test
    public void verifyThatMultipleElementsCanBeAdded() {
        homePage.clickOnAddRemoveElementsButton();
        addRemoveElementsPage.addSpecifiedNumberOfElements(45);

        Assert.assertFalse(addRemoveElementsPage.getDeleteButton().isEmpty());
        Assert.assertEquals(addRemoveElementsPage.getDeleteButton().size(), addRemoveElementsPage.countElements());
    }

    @Test
    public void verifyThatElementsCanBeDeleted() {
        homePage.clickOnAddRemoveElementsButton();
        addRemoveElementsPage.addElement();
        addRemoveElementsPage.addElement();
        addRemoveElementsPage.addElement();
        addRemoveElementsPage.addElement();
        addRemoveElementsPage.deleteElement(2);
        addRemoveElementsPage.deleteElement(1);
        addRemoveElementsPage.addElement();
        addRemoveElementsPage.addElement();
        addRemoveElementsPage.deleteAllElements();

        Assert.assertTrue(addRemoveElementsPage.getDeleteButton().isEmpty());
        Assert.assertEquals(addRemoveElementsPage.getDeleteButton().size(), addRemoveElementsPage.countElements());
    }

    @Test
    public void verifyThatImageCanBeUploaded() {
        String fileName = "meme.jpg";
        homePage.clickOnFileUploadButton();
        fileUploadPage.uploadFileWithChooseFileButton("C:\\Users\\HP\\Desktop\\" + fileName);

        Assert.assertTrue(fileUploadedPage.getMessage().isDisplayed());
        Assert.assertEquals(fileUploadedPage.getUploadedFile().getText(), fileName);

        driver.navigate().to(homePage.getHomePageUrl());
        homePage.clickOnFileDownloadButton();
        Assert.assertTrue(fileDownloadPage.getFile(fileName).isDisplayed());
    }

    @Test
    public void verifyThatPdfFileCanBeUploaded() {
        String fileName = "SQL2.pdf";
        homePage.clickOnFileUploadButton();
        fileUploadPage.uploadFileWithChooseFileButton("C:\\Users\\HP\\Desktop\\" + fileName);

        Assert.assertTrue(fileUploadedPage.getMessage().isDisplayed());
        Assert.assertEquals(fileUploadedPage.getUploadedFile().getText(), fileName);

        driver.navigate().to(homePage.getHomePageUrl());
        homePage.clickOnFileDownloadButton();
        Assert.assertTrue(fileDownloadPage.getFile(fileName).isDisplayed());
    }

    @Test
    public void verifyThatWordDocumentCanBeUploaded() {
        String fileName = "Testiranje.docx";
        homePage.clickOnFileUploadButton();
        fileUploadPage.uploadFileWithChooseFileButton("C:\\Users\\HP\\Desktop\\" + fileName);

        Assert.assertTrue(fileUploadedPage.getMessage().isDisplayed());
        Assert.assertEquals(fileUploadedPage.getUploadedFile().getText(), fileName);

        driver.navigate().to(homePage.getHomePageUrl());
        homePage.clickOnFileDownloadButton();
        Assert.assertTrue(fileDownloadPage.getFile(fileName).isDisplayed());
    }

    @Test
    public void verifyThatTextDocumentCanBeUploaded() {
        String fileName = "KodoviCas.txt";
        homePage.clickOnFileUploadButton();
        fileUploadPage.uploadFileWithChooseFileButton("C:\\Users\\HP\\Desktop\\" + fileName);

        Assert.assertTrue(fileUploadedPage.getMessage().isDisplayed());
        Assert.assertEquals(fileUploadedPage.getUploadedFile().getText(), fileName);

        driver.navigate().to(homePage.getHomePageUrl());
        homePage.clickOnFileDownloadButton();
        Assert.assertTrue(fileDownloadPage.getFile(fileName).isDisplayed());
    }

    @Test
    public void verifyThatFileCanBeDownloaded() {
        String fileName = "ocean.jpg";
        homePage.clickOnFileUploadButton();
        fileUploadPage.uploadFileWithChooseFileButton("C:\\Users\\HP\\Desktop\\" + fileName);

        Assert.assertTrue(fileUploadedPage.getMessage().isDisplayed());
        Assert.assertEquals(fileUploadedPage.getUploadedFile().getText(), fileName);

        driver.navigate().to(homePage.getHomePageUrl());
        homePage.clickOnFileDownloadButton();
        Assert.assertTrue(fileDownloadPage.getFile(fileName).isDisplayed());

        fileDownloadPage.downloadFile(fileName);
        Assert.assertTrue(fileDownloadPage.isFileDownloaded("C:\\Users\\HP\\Downloads\\", fileName));
    }

    @Test
    public void verifyThatCheckboxesCanBeUnchecked() {
        homePage.clickOnCheckboxesButton();
        checkboxesPage.uncheckCheckboxes();

        Assert.assertFalse(checkboxesPage.getCheckbox1().isSelected());
        Assert.assertFalse(checkboxesPage.getCheckbox2().isSelected());
    }

    @Test
    public void verifyThatCheckboxesCanBeCheckedOneByOne() {
        homePage.clickOnCheckboxesButton();
        checkboxesPage.uncheckCheckboxes();

        Assert.assertFalse(checkboxesPage.getCheckbox1().isSelected());
        Assert.assertFalse(checkboxesPage.getCheckbox2().isSelected());

        checkboxesPage.selectOneCheckbox(checkboxesPage.getCheckbox1());
        checkboxesPage.selectOneCheckbox(checkboxesPage.getCheckbox2());

        Assert.assertTrue(checkboxesPage.getCheckbox1().isSelected());
        Assert.assertTrue(checkboxesPage.getCheckbox2().isSelected());
    }

    @Test
    public void verifyThatCheckboxesCanBeChecked() {
        homePage.clickOnCheckboxesButton();
        checkboxesPage.uncheckCheckboxes();

        Assert.assertFalse(checkboxesPage.getCheckbox1().isSelected());
        Assert.assertFalse(checkboxesPage.getCheckbox2().isSelected());

        checkboxesPage.selectCheckboxes();

        Assert.assertTrue(checkboxesPage.getCheckbox1().isSelected());
        Assert.assertTrue(checkboxesPage.getCheckbox2().isSelected());
    }

    @Test
    public void verifyThatSliderCanBeSlidedToTheRightEnd() {
        homePage.clickOnHorizontalSliderButton();
        horizontalSliderPage.slideToTheRight(9);

        Assert.assertEquals(horizontalSliderPage.rangeNumber(), "5");
    }

    @Test
    public void verifyThatSliderCanBeSlidedToTheLeftEnd() {
        homePage.clickOnHorizontalSliderButton();
        horizontalSliderPage.slideToTheRight(9);
        Assert.assertEquals(horizontalSliderPage.rangeNumber(), "5");

        horizontalSliderPage.slideToTheLeft(9);
        Assert.assertEquals(horizontalSliderPage.rangeNumber(), "0");
    }

    @Test
    public void verifyThatSliderCanBeSlidedRight() {
        homePage.clickOnHorizontalSliderButton();
        horizontalSliderPage.slideToTheRight(5);

        Assert.assertEquals(horizontalSliderPage.rangeNumber(), "3");
    }

    @Test
    public void verifyThatSliderCanBeSlidedLeft() {
        homePage.clickOnHorizontalSliderButton();
        horizontalSliderPage.slideToTheRight(6);
        Assert.assertEquals(horizontalSliderPage.rangeNumber(), "3.5");

        horizontalSliderPage.slideToTheLeft(3);
        Assert.assertEquals(horizontalSliderPage.rangeNumber(), "1.5");
    }
}
