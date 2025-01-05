package training;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowTest {

    WebDriver driver;

    @Test

    public void testMethod(){
        openBrowser();
        clickOnAlertsFrameAndWindowMenu();
        clickOnBrowserWindowSubmenu();
        clickOnNewTabButton();
        interactWithNewTab();
        closeWindow();
        switchToDefaultWindow();
        clickOnNewWindowButton();
        interactWithNewWindow();
        closeWindow();
        switchToDefaultWindow();
        quitBrowser();
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

    public void clickOnBrowserWindowSubmenu() {
        WebElement brwserWindowSubmenuElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        brwserWindowSubmenuElement.click();
    }

    public void clickOnNewTabButton(){
        WebElement newTabButtonElement = driver.findElement(By.xpath("//button[@id='tabButton']"));
        newTabButtonElement.click();
    }

    public void interactWithNewTab(){
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(1));
        System.out.println("Textul din noul tab este " + driver.findElement(By.id("sampleHeading")).getText());
    }

    public void closeWindow(){
        driver.close();
    }

    public void switchToDefaultWindow(){
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(0));
    }

    public void clickOnNewWindowButton(){
        WebElement newWindowButtonElement = driver.findElement(By.xpath("//button[@id='windowButton']"));
        newWindowButtonElement.click();
    }

    public void interactWithNewWindow(){
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(1));
        System.out.println("Textul din noua fereastra este " + driver.findElement(By.id("sampleHeading")).getText());
    }

    public void quitBrowser(){
        driver.quit();
    }


}
