package training.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import training.pages.FramesPage;
import training.pages.HomePage;

public class FramesTest extends BaseTest {

    @Test
    public void frameTest(){
        homePage.isPageLoaded();
        homePage.goToDesireMenu("Alerts, Frame & Windows");
        commonPage.isPageLoaded();
        commonPage.selectSubMenu("Frames");
        FramesPage framesPage = new FramesPage(driver);
        framesPage.isPageLoaded();
        framesPage.interactWithFrameOne();
        framesPage.switchToDefaultPage();/''
        framesPage.interactWithFrameTwo();
        framesPage.switchToDefaultPage();
//        openBrowser();
//        clickOnAlertsFrameAndWindowMenu();
//        clickOnFramesSubmenu();
//        interactWithFrameOne();
//        switchToDefaultPage();
//        interactWithFrameTwo();
//        switchToDefaultPage();
    }

    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().setSize(new Dimension(1980, 1080));
    }

    public void clickOnAlertsFrameAndWindowMenu() {
        scrollDown();
        WebElement alertsFramesAndWindowsMenuElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertsFramesAndWindowsMenuElement.click();
    }

    public void scrollDown (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
    }

//    public void clickOnFramesSubmenu() {
//        WebElement framesSubmenuElement = driver.findElement(By.xpath("//span[text()='Frames']"));
//        framesSubmenuElement.click();
//    }
//
//    public void interactWithFrameOne(){
//        WebElement frame1Element = driver.findElement(By.xpath("//iframe[@id='frame1']"));
//        driver.switchTo().frame(frame1Element);
//        System.out.println("Textul din frameul1 este " + driver.findElement(By.id("sampleHeading")).getText());
//    }
//
//    public void switchToDefaultPage(){
//        driver.switchTo().defaultContent();
//    }
//
//    public void interactWithFrameTwo(){
//        WebElement frame2Element = driver.findElement(By.xpath("//iframe[@id='frame2']"));
//        driver.switchTo().frame(frame2Element);
//        System.out.println("Textul din frameul2 este " + driver.findElement(By.id("sampleHeading")).getText());
//    }
}
