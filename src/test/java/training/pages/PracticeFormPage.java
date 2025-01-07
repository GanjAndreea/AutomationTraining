package training.pages;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

    @FindBy (id = "userNumber")
    private WebElement fillphoneNumber;

    @FindBy (id = "subjectsInput")
    private WebElement selectsubjects;

    @FindBy (xpath = "//label[text()=\"Sports\"]")
    private WebElement selectHobbies;

    @FindBy (xpath = "//label[text()=\"Reading\"]")
    private WebElement selectHobbies2;

    @FindBy (id = "currentAddress")
    private WebElement currentAddress;

    @FindBy (id = "uploadPicture")
    private WebElement uploadPicture;

    @FindBy (id = "dateOfBirthInput")
    private WebElement dateOfBirth;
    @FindBy (id = "dateOfBirthInput")
    private WebElement defaultElement;

    @FindBy (xpath = "//*[@id=\"react-select-3-input\"]")
    private WebElement selectState;
    @FindBy (xpath = "//*[@id=\"react-select-4-input\"]")
    private WebElement selectCity;

    @FindBy (id = "submit")
    private WebElement submitButton;

    @FindBy (id = "closeLargeModal")
    private WebElement closeForm;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    //Metode specifice paginii

    public void fillEntireForm(){
        fillFirstName();
        fillLastName();
        elementsHelper.scrollDown();
        fillEmail();
        fillGender("Male");
        fillPhoneNumber();
        selectSubjects();
        selectHobbies();
        setCurrentAddress();
        uploadPicture();
        dateOfBirth();
        elementsHelper.scrollDown();
        stateAndCity();
        pause();
        submitButton();
        pause();
    }

    public void fillEmail() {
        elementsHelper.fillElement(fillEmail,"exemplu@yahoo.com");
    }

    public void fillFirstName(){
        elementsHelper.fillElement(fillFirstName, "Bogdan");
    }

    public void fillLastName(){
        elementsHelper.fillElement(fillLastName, "Popescu");
    }

    public void fillGender(String gender) {
        List<WebElement> genderListElements = new ArrayList<>();
        genderListElements.add(maleGenderCheckBoxElement);
        genderListElements.add(femaleGenderCheckBoxElement);
        genderListElements.add(otherGenderCheckBoxElement);

       elementsHelper.selectElementByTextFromList(gender,genderListElements);
    }

    public void fillPhoneNumber(){
        elementsHelper.fillElement(fillphoneNumber, "072712345678");
    }

    public void selectSubjects(){
        elementsHelper.selectElementUsingKeys(selectsubjects, "Accounting", Keys.ENTER);
        elementsHelper.selectElementUsingKeys(selectsubjects, "Maths",Keys.ENTER);
    }

    public void selectHobbies(){
        elementsHelper.clickElement(selectHobbies);
        elementsHelper.clickElement(selectHobbies2);
    }

    public void setCurrentAddress (){
        elementsHelper.fillElement(currentAddress, "Strada Visinului");
    }

    public void uploadPicture(){
        elementsHelper.uploadFileToElement(uploadPicture);
    }

    public void dateOfBirth (){
        elementsHelper.selectElementUsingKeys(dateOfBirth,"2 Aprilie 1996",Keys.HOME);
        for (int index = 1; index <=11 ; index++){
            elementsHelper.keyboardEnters(defaultElement,Keys.DELETE);
        }
        elementsHelper.keyboardEnters(dateOfBirth,Keys.ENTER);
    }

//    public void scrollDown (){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,400)");
//    }

    public void stateAndCity(){
        elementsHelper.selectElementUsingKeys(selectState,"NCR",Keys.ENTER);
        elementsHelper.selectElementUsingKeys(selectCity,"Delhi",Keys.ENTER);
    }

    public void pause(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void submitButton(){
        elementsHelper.clickElement(submitButton);
    }

    public void closeTheForm(){
        elementsHelper.clickElement(closeForm);
    }

    @Override
    public void isPageLoaded() {
        elementsHelper.waitForElement(pageTitleElement);
        Assert.assertEquals(pageTitleElement.getText(), "Practice Form", "Title is invalid and actual value is: " +pageTitleElement.getText());
    }
}
