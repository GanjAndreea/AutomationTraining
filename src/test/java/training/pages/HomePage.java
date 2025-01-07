package training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import training.helpers.ElementsHelper;

import java.util.List;

public class HomePage extends BasePage{
    //Identificam webelementele specifice paginii
    @FindBy(xpath = "//h5")
    private List<WebElement> menuListElement;

    @FindBy(xpath = "//img[@class='banner-image']")
    private WebElement pageTitle;

    //Un constructor care preia din clasa BasePage
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Implementare proprie pentru HomePage a metodei abstracte din BasePage
    @Override
    public void isPageLoaded() {
        Assert.assertTrue(pageTitle.getAttribute("alt").equals("Selenium Online Training"),"Page is not loaded correctly");
    }

    //Facem metode specifice pentru pagina
    //Facem o metoda care sa faca click pe meniul Forms
//    public void clickOnFormsMenu (){
//        scrollDown();
//        formsMenuElement.click();
//    }

    //Facem o metoda care sa faca click pe un meniu ales de noi
    public void goToDesireMenu(String menuName){
        elementsHelper.scrollDown();
        elementsHelper.selectElementByTextFromList(menuName,menuListElement);

    }

    //Facem o metoda care sa faca scroll down pe pagina
//    public void scrollDown (){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,400)");
//    }
}
