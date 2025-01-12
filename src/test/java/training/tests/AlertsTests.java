package training.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import training.pages.AlertsPage;

import java.time.Duration;

import static training.constants.MenuKeys.ALERTS_FRAMES_WINDOWS_MENU;
import static training.constants.SubMenuKeys.ALERTS_SUBMENU;

public class AlertsTests extends BaseTest {

  //  WebDriver driver;

    @Test
    public void alertsTests(){
        homePage.isPageLoaded();
        homePage.goToDesireMenu(ALERTS_FRAMES_WINDOWS_MENU);
        commonPage.isPageLoaded();
        commonPage.selectSubMenu(ALERTS_SUBMENU);
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.isPageLoaded();
        alertsPage.interactWithAllAlerts("Alerts Test");
//        alertsPage.clickFirstAlert();
//        alertsPage.interactWithAlertOk();
//        alertsPage.clickOnThirdAlertButton();
//        alertsPage.interactWithConfirmAlert();
//        alertsPage.clickOnFourthAlertButton();
//        alertsPage.interactWithTextAlert();

        //Prima versiune fara page object model
//        openBrowser();
//        clickOnAlertsFramesAndWindowsMenu();
//        clickOnAlertsSubmenu();
//        clickFirstAlert();
//        interactWithAlertOk();
//        clickOnSecondAlertButton();
//        interactWithTimerAlert();
//        clickOnThirdAlertButton();
//        interactWithConfirmAlert();
//        clickOnFourthAlertButton();
//        interactWithTextAlert();
    }

//    public void openBrowser() {
//        driver = new ChromeDriver();
//        driver.get("https://demoqa.com/");
//        driver.manage().window().setSize(new Dimension(1980, 1080));
//    }

//    public void clickOnAlertsFramesAndWindowsMenu() {
//        scrollDown();
//        WebElement alertsFrameesAndWindowsMenuElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        alertsFrameesAndWindowsMenuElement.click();
//    }

    public void scrollDown (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
    }

//    public void clickOnAlertsSubmenu() {
//        WebElement alertsElements = driver.findElement(By.xpath("//span[text()='Alerts']"));
//        alertsElements.click();
//    }

//    public void clickFirstAlert(){
//        WebElement firstAlertButton = driver.findElement(By.xpath("//button[@id='alertButton']"));
//        firstAlertButton.click();
//    }
//
//    public void interactWithAlertOk(){
//        Alert alertOk = driver.switchTo().alert();
//        alertOk.accept();
//    }

//    public void clickOnSecondAlertButton(){
//        WebElement secondAlertButton = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
//        secondAlertButton.click();
//    }
//
//    public void interactWithTimerAlert(){
//        waitForAlert();
//        Alert timerAlert = driver.switchTo().alert();
//        timerAlert.accept();
//    }
//
//    public void waitForAlert (){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//    }

//    public void clickOnThirdAlertButton(){
//        WebElement thirdAlertButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
//        thirdAlertButton.click();
//    }
//
//    public void interactWithConfirmAlert(){
//        Alert confirmAlert = driver.switchTo().alert();
//        confirmAlert.dismiss();
//    }
//
//    public void clickOnFourthAlertButton(){
//        WebElement fourthAlertButton = driver.findElement(By.xpath("//button[@id='promtButton']"));
//        fourthAlertButton.click();
//    }
//
//    public void interactWithTextAlert(){
//        Alert textAlert = driver.switchTo().alert();
//        textAlert.sendKeys("Am reusit sa termin ora cu succes");
//        textAlert.accept();
//    }
}
