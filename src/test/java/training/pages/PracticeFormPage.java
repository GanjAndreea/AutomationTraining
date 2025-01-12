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
import java.util.Map;

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

    @FindBy (xpath = "//label[text()=\"Music\"]")
    private WebElement selectHobbies3;

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

    public void fillEntireForm(String firstName, String lastName,String emailValue, String gender, String phoneNumber,
                               List<String> subjects, List<String> hobbies, String address, String DOB, String state, String city){
        fillFirstName(firstName);
        fillLastName(lastName);
        elementsHelper.scrollDown();
        fillEmail(emailValue);
        fillGender(gender);
        fillPhoneNumber(phoneNumber);
        selectSubjects(subjects);
        selectHobbies(hobbies);
        setCurrentAddress(address);
        uploadPicture();
        dateOfBirth(DOB);
        elementsHelper.scrollDown();
        stateAndCity(state,city);
        pause();
        submitButton();
        pause();
    }

    public void fillEntireFormWithPropertiesData(Map<String,Object> practiceFormData){
        fillFirstName((String) practiceFormData.get("firstName"));
        fillLastName((String) practiceFormData.get("lastName"));
        elementsHelper.scrollDown();
        fillEmail((String) practiceFormData.get("email"));
        fillGender((String) practiceFormData.get("gender"));
        fillPhoneNumber((String) practiceFormData.get("phoneNumber"));
        selectSubjects((List <String>) practiceFormData.get("subject"));
        selectHobbies((List <String>) practiceFormData.get("hobbies"));
        setCurrentAddress((String) practiceFormData.get("address"));
        uploadPicture();
        dateOfBirth((String) practiceFormData.get("DOB"));
        elementsHelper.scrollDown();
        stateAndCity((String) practiceFormData.get("state"), (String) practiceFormData.get("city"));
        pause();
        submitButton();
        pause();
    }

    public void fillEmail(String emailValue) {
        elementsHelper.fillElement(fillEmail,emailValue);
    }

    public void fillFirstName(String firstName){
        elementsHelper.fillElement(fillFirstName, firstName);
    }

    public void fillLastName(String lastName){
        elementsHelper.fillElement(fillLastName, lastName);
    }

    public void fillGender(String gender) {
        List<WebElement> genderListElements = new ArrayList<>();
        genderListElements.add(maleGenderCheckBoxElement);
        genderListElements.add(femaleGenderCheckBoxElement);
        genderListElements.add(otherGenderCheckBoxElement);

       elementsHelper.selectElementByTextFromList(gender,genderListElements);
    }

    public void fillPhoneNumber(String phoneNumber){
        elementsHelper.fillElement(fillphoneNumber, phoneNumber);
    }

    public void selectSubjects(List<String> subjectList){
        for (String subject : subjectList){
            elementsHelper.selectElementUsingKeys(selectsubjects, subject, Keys.ENTER);
        }
//        elementsHelper.selectElementUsingKeys(selectsubjects,"Accounting" , Keys.ENTER);
//        elementsHelper.selectElementUsingKeys(selectsubjects, "Maths",Keys.ENTER);
    }

    public void selectHobbies(List<String> hobbiesList){
        List <WebElement> hobbiesElementsList = List.of(selectHobbies,selectHobbies2,selectHobbies3);
        for (String hobby : hobbiesList ){
            elementsHelper.selectElementByTextFromList(hobby,hobbiesElementsList);
        }

    }

    public void setCurrentAddress (String address){
        elementsHelper.fillElement(currentAddress, address);
    }

    public void uploadPicture(){
        elementsHelper.uploadFileToElement(uploadPicture);
    }

    public void dateOfBirth (String dateOfBirthValue){
        elementsHelper.selectElementUsingKeys(dateOfBirth,dateOfBirthValue,Keys.HOME);
        for (int index = 1; index <=11 ; index++){
            elementsHelper.keyboardEnters(defaultElement,Keys.DELETE);
        }
        elementsHelper.keyboardEnters(dateOfBirth,Keys.ENTER);
    }

//    public void scrollDown (){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,400)");
//    }

    public void stateAndCity(String stateValue, String cityValue){
        elementsHelper.selectElementUsingKeys(selectState,stateValue,Keys.ENTER);
        elementsHelper.selectElementUsingKeys(selectCity,cityValue,Keys.ENTER);
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
