package training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FramesPage extends BasePage{

    @FindBy(xpath = "//h1")
    private WebElement pageTitleElement;

    @FindBy(xpath = "//iframe[@id='frame1']")
    private WebElement frame1Element;

    @FindBy(id = "sampleHeading")
    private WebElement sampleText;

    @FindBy(xpath = "//iframe[@id='frame2']")
    private WebElement frame2Element;

    public FramesPage(WebDriver driver) {
        super(driver);
    }

//    public void switchToDefaultPage() {
//       driver.switchTo().defaultContent();
//    }

    public void interactWithAllFrames (){
        interactWithFrameOne();
        interactWithFrameTwo();
    }

    public void interactWithFrameOne(){
        frameHelpers.switchOnFrame(frame1Element);
        System.out.println("Textul din frameul1 este " + sampleText.getText());
        frameHelpers.switchToDefaultPage();
    }

    public void interactWithFrameTwo(){
        frameHelpers.switchOnFrame(frame2Element);
        System.out.println("Textul din frameul2 este " + sampleText.getText());
        frameHelpers.switchToDefaultPage();
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(pageTitleElement.getText(),"Frames","Title is invalid and actual value is " + pageTitleElement.getText());
    }
}
