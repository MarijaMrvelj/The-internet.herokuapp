package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AvailableExamplesTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
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
        homePage.clickOnFileUploadButton();
        fileUploadPage.uploadFileWithChooseFileButton("C:\\Users\\HP\\Desktop\\meme.jpg");

        Assert.assertTrue(fileUploadedPage.getMessage().isDisplayed());
        Assert.assertEquals(fileUploadedPage.getUploadedFile().getText(), "meme.jpg");
    }

    @Test
    public void verifyThatPdfFileCanBeUploaded() {
        homePage.clickOnFileUploadButton();
        fileUploadPage.uploadFileWithChooseFileButton("C:\\Users\\HP\\Desktop\\SQL2.pdf");

        Assert.assertTrue(fileUploadedPage.getMessage().isDisplayed());
        Assert.assertEquals(fileUploadedPage.getUploadedFile().getText(), "SQL2.pdf");
    }

    @Test
    public void verifyThatWordDocumentCanBeUploaded() {
        homePage.clickOnFileUploadButton();
        fileUploadPage.uploadFileWithChooseFileButton("C:\\Users\\HP\\Desktop\\Testiranje.docx");

        Assert.assertTrue(fileUploadedPage.getMessage().isDisplayed());
        Assert.assertEquals(fileUploadedPage.getUploadedFile().getText(), "Testiranje.docx");
    }

    @Test
    public void verifyThatTextDocumentCanBeUploaded() {
        homePage.clickOnFileUploadButton();
        fileUploadPage.uploadFileWithChooseFileButton("C:\\Users\\HP\\Desktop\\KodoviCas.txt");

        Assert.assertTrue(fileUploadedPage.getMessage().isDisplayed());
        Assert.assertEquals(fileUploadedPage.getUploadedFile().getText(), "KodoviCas.txt");
    }


    //Internal Server Error:
    /*@Test
    public void verifyThatImageCannotBeUploadedUsingDragDropField() throws InterruptedException {
        homePage.clickOnFileUploadButton();
        Thread.sleep(2000);
        fileUploadPage.uploadFileWithDragDropField("C:\\Users\\HP\\Desktop\\meme.jpg");
        Assert.assertTrue(fileUploadedPage.getServerMessage().isDisplayed());
        Assert.assertEquals(fileUploadedPage.getServerMessage().getText(), fileUploadedPage.serverMessageText());
    }*/

}
