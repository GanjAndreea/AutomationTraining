package training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage extends BasePage{

    //WebElemente specifice pentru pagina
    @FindBy(xpath = "//h1")
    private WebElement pageTitleElement;

    @FindBy (id = "firstName")
    private WebElement fillFirstName;

    @FindBy (id = "lastName")
    private WebElement fillLastName;

    @FindBy (id = "userEmail")
    private WebElement fillEmail;

    @FindBy (xpath = "//label[@for='gender-radio-1']")
    private WebElement maleGenderCheckBoxElement;

    @FindBy (xpath = "//label[@for='gender-radio-2']")
    private WebElement femaleGenderCheckBoxElement;

    @FindBy (xpath = "//label[@for='gender-radio-3']")
    private WebElement otherGenderCheckBoxElement;


    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    //Metode specifice paginii

    public void fillEntireForm(){
        fillFirstName();
        fillLastName();
        scrollDown();
        fillEmail();
        fillGender("Male");
    }

    public void fillEmail() {
        fillEmail.sendKeys("exemplu@yahoo.com");
    }

    public void fillFirstName(){
        fillFirstName.sendKeys("Bogdan");
    }

    public void fillLastName(){
        fillLastName.sendKeys("Popescu");
    }

    public void fillGender(String gender) {
        List<WebElement> genderListElements = new ArrayList<>();
        genderListElements.add(maleGenderCheckBoxElement);
        genderListElements.add(femaleGenderCheckBoxElement);
        genderListElements.add(otherGenderCheckBoxElement);
        for(int i = 0; i < genderListElements.size(); i++){
            if (genderListElements.get(i).getText().equals(gender)){
                genderListElements.get(i).click();
            }
        }
    }

    public void scrollDown (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(pageTitleElement.getText(), "Practice Form", "Title is invalid and actual value is: " +pageTitleElement.getText());
    }
}
