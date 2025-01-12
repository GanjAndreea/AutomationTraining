package training.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage{

    //WebElemente specifice pentru pagina
    @FindBy(xpath = "//h1")
    private WebElement pageTitleElement;

    @FindBy(id ="alertButton")
    private WebElement firstAlertButton;

    @FindBy(id ="timerAlertButton")
    private WebElement secondAlertButton;

    @FindBy(id ="confirmButton")
    private WebElement thirdAlertButton;

    @FindBy(xpath ="//button[@id='promtButton']")
    private WebElement fourthAlertButton;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    //metode specifice pentru pagina
    public void interactWithAllAlerts(String alertText){
        interactWithFirstAlert();
        interactWithWaitingAlert();
        interactWithThirdAlert();
        interactWithFourthAlert(alertText);
    }
    public void interactWithFirstAlert(){
        firstAlertButton.click();
        alertHelpers.acceptAlert();
    }

//    public void interactWithAlertOk(){
//        Alert alertOk = driver.switchTo().alert();
//        alertOk.accept();
//    }

    public void interactWithWaitingAlert(){
        elementsHelper.clickElement(secondAlertButton);
        alertHelpers.timerAlert();
//    clickOnSecondAlertButton();
//    waitForAlert();
//    acceptSecondAlert();
    }

//    public void clickOnSecondAlertButton(){
//        secondAlertButton.click();
//    }
//
//    public void acceptSecondAlert(){
//        waitForAlert();
//        Alert timerAlert = driver.switchTo().alert();
//        timerAlert.accept();
//    }

//    public void waitForAlert (){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
//        wait.until(ExpectedConditions.alertIsPresent());
//    }

    public void interactWithThirdAlert(){
        elementsHelper.clickElement(thirdAlertButton);
        alertHelpers.dismissAlert();
    }

//    public void interactWithConfirmAlert(){
//        Alert confirmAlert = driver.switchTo().alert();
//        confirmAlert.dismiss();
//    }

    public void interactWithFourthAlert(String text){
        elementsHelper.clickElement(fourthAlertButton);
        alertHelpers.promtAlert(text);
    }

//    public void interactWithTextAlert(){
//        Alert textAlert = driver.switchTo().alert();
//        textAlert.sendKeys("Am reusit sa termin ora cu succes");
//        textAlert.accept();
//    }

    @Override
   public void isPageLoaded() {
        Assert.assertEquals(pageTitleElement.getText(),"Alerts","Title is invalid and actual value is " + pageTitleElement.getText());
    }
}
