package training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WindowsPage extends BasePage{

    @FindBy(xpath = "//h1")
    private WebElement pageTitleElement;

    @FindBy(xpath = "//button[@id='tabButton']")
    private WebElement newTabButtonElement;

    @FindBy(id = "sampleHeading")
    private WebElement sampleText;

    @FindBy(xpath = "//button[@id='windowButton']")
    private WebElement newWindowButtonElement;

    @FindBy (xpath = "//button[@id='messageWindowButton']")
    private WebElement newWindowMessage;

    @FindBy (xpath = "//body")
    private WebElement messageText;

    public WindowsPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnBrowserWindowSubmenu() {
        WebElement brwserWindowSubmenuElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        brwserWindowSubmenuElement.click();
    }

    public void clickOnNewTabButton(){
        newTabButtonElement.click();
    }

    public void interactWithNewTab(){
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(1));
        System.out.println("Textul din noul tab este " + sampleText.getText());
    }

    public void switchToDefaultWindow(){
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(0));
    }

    public void clickOnNewWindowButton(){
        newWindowButtonElement.click();
    }

    public void interactWithNewWindow(){
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(1));
        System.out.println("Textul din noua fereastra este " + messageText.getText());
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(pageTitleElement.getText(), "Browser Windows", "Title is invalid and actual value is: " +pageTitleElement.getText());
    }
}
