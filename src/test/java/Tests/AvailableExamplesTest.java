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


}
