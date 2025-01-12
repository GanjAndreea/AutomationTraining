package training.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import propertyUtility.PropertyUtility;
import training.pages.CommonPage;
import training.pages.HomePage;
import training.pages.PracticeFormPage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static training.constants.MenuKeys.FORMS_MENU;
import static training.constants.SubMenuKeys.PRACTICE_FORM_SUBMENIU;

public class PracticeFormTest extends BaseTest {

    //cream o metoda de test care sa mearga de pe pagina principala pana pe pagina Practice Form


    @Test
    public void navigateFromHomepageToPracticeFormPage (){
        homePage.isPageLoaded();
        homePage.goToDesireMenu(FORMS_MENU);
        commonPage.isPageLoaded();
        commonPage.selectSubMenu(PRACTICE_FORM_SUBMENIU);
        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.isPageLoaded();
        propertyUtility = new  PropertyUtility("PracticeFormTest");
        Map <String,Object> practiceFormDataEntry = propertyUtility.getAllProperties();
        List<String> subjectList = List.of("Accounting","Maths");
        List<String> hobbiesList = List.of("Sports","Music");
        practiceFormPage.fillEntireFormWithPropertiesData(practiceFormDataEntry);
//        practiceFormPage.fillFirstName();
//        practiceFormPage.fillLastName();
//        practiceFormPage.fillEmail();
//        practiceFormPage.fillEntireForm("Stanciu","Ionut","exemplu@yahoo.com", "Male","0712345678",subjectList,hobbiesList, "Strada Pantof",
//                "2 Aprilie 1996","NCR","Delhi" );
//        practiceFormPage.fillEntireForm(
//        propertyUtility.getProperty("firstName"),
//        propertyUtility.getProperty("lastName"),
//        propertyUtility.getProperty("email"),
//        propertyUtility.getProperty("phoneNumber"),
//        propertyUtility.getProperty("gender"),
//        propertyUtility.getPropertyAsList("subject"),
//        propertyUtility.getPropertyAsList("hobbies"),
//        propertyUtility.getProperty("address"),
//        propertyUtility.getProperty("DOB"),
//        propertyUtility.getProperty("state"),
//        propertyUtility.getProperty("city")
//                );
//        clickOnPracticeFormSubmenu();
//        scrollDown();
//        fillFirstName();
//        fillLastName();
//        fillEmail();
//        scrollDown();
//        fillGender("Male");
//        selectSubjects();
//        fillHobbies("Sports");
//        uploadPicture();
//        fillCurentAddress();
//        fillPhoneNumber();
//        scrollDown();
//        fillDateOfBirth("02 Aprilie 1996");
//        fillTheState();
//        fillTheCity();
//        clickOnSubmitButton();

    }

    //Facem o metoda care sa deschida Browserul Chrome
//    public void openBrowser(){
//        driver = new ChromeDriver();
//        driver.get("https://demoqa.com/");
//        driver.manage().window().maximize();
//    }

    //Facem o metoda care sa faca click pe meniul Forms
//    public void clickOnFormsMenu (){
//        scrollDown();
//        WebElement formsMenuElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
//        formsMenuElement.click();
//    }

    //Facem o metoda care sa faca scroll down pe pagina
    public void scrollDown (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
    }

    //Facem o metoda care sa faca click pe submeniul Practice Form
    public void clickOnPracticeFormSubmenu(){
        WebElement practiceFormSubmenuElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormSubmenuElement.click();
   }

    //Facem o metoda sa completam campul First Name
//    public void fillFirstName(){
//        WebElement firstNameFieldElement = driver.findElement(By.id("firstName"));
//        firstNameFieldElement.sendKeys("Bogdan");
//    }

    //Facem o metoda care sa completeze campul Last Name
//    public void fillLastName(){
//        WebElement lastNameFieldElement = driver.findElement(By.id("lastName"));
//        lastNameFieldElement.sendKeys("Popescu");
//    }

    //Facem o metoda care sa completeze campul e-mail
//    public void fillEmail() {
//        WebElement emailFieldElement= driver.findElement(By.xpath("//input[@id='userEmail']"));
//        emailFieldElement.sendKeys("exemplu@yahoo.com");
//    }

    //Facem o metoda care sa selecteze genul
//    public void fillGender(String gender) {
//        WebElement maleGenderCheckBoxElement= driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
//        WebElement femaleGenderCheckBoxElement= driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
//        WebElement otherGenderCheckBoxElement= driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
//        List<WebElement> genderListElements = new ArrayList<>();
//        genderListElements.add(maleGenderCheckBoxElement);
//        genderListElements.add(femaleGenderCheckBoxElement);
//        genderListElements.add(otherGenderCheckBoxElement);
//        for(int i = 0; i<genderListElements.size(); i++){
//            if (genderListElements.get(i).getText().equals(gender)){
//                genderListElements.get(i).click();
//            }
//        }
//    }

    //Facem o metoda care sa completeze campul Phone Number
    public void fillPhoneNumber() {
        WebElement phoneNumberFieldElement= driver.findElement(By.xpath("//input[@id='userNumber']"));
        phoneNumberFieldElement.sendKeys("0712345678");
    }

    //Facem o metoda care sa completeze campul Data Nasterii
    public void fillDateOfBirth (String dateOfBirth) {
        WebElement dateOfBirthField= driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthField.click();
        dateOfBirthField.sendKeys(Keys.chord( Keys.CONTROL,"a"));
        dateOfBirthField.sendKeys(dateOfBirth);
        dateOfBirthField.sendKeys(Keys.ENTER);
    }


    //Facem o metoda care sa completeze campul Subjects
    public void selectSubjects(){
        WebElement selectSubjectInputField = driver.findElement(By.id("subjectsInput"));
        selectSubjectInputField.sendKeys("Accounting");
        selectSubjectInputField.sendKeys(Keys.ENTER);
    }

    //Facem o metoda care sa selecteze optiunile de la Hobbies
    public void fillHobbies(String hobbies) {
        WebElement sportsHobbiesCheckboxElement= driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        WebElement readingHobbiesCheckboxElement= driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        WebElement musicCheckboxElement= driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
        List<WebElement> hobbiesListsElements = new ArrayList<>();
        hobbiesListsElements.add(sportsHobbiesCheckboxElement);
        hobbiesListsElements.add(readingHobbiesCheckboxElement);
        hobbiesListsElements.add(musicCheckboxElement);
        for(int i = 0; i<hobbiesListsElements.size(); i++){
            if (hobbiesListsElements.get(i).getText().equals(hobbies)){
                hobbiesListsElements.get(i).click();
            }
        }
    }

    //Facem o metoda care sa incarce un fisier in formular

    public void uploadPicture (){
        String pictureFiledPath = "src/test/resources/picture.png";
        File file = new File(pictureFiledPath);
        WebElement inputPictureButton = driver.findElement(By.cssSelector("#uploadPicture"));
        inputPictureButton.sendKeys(file.getAbsolutePath());
    }

    //Vom face scroll down

    //Facem o metoda care sa completeze campul Current Adress
    public void fillCurentAddress() {
        WebElement currentAddresFieldElement= driver.findElement(By.id("currentAddress"));
        currentAddresFieldElement.sendKeys("Strada Visinului, Nr.18");
    }

    //Facem o metoda care sa selecteze Statul
    public void fillTheState(){
        WebElement theStateElements = driver.findElement(By.id("rect-select-3-input"));
        theStateElements.sendKeys("NCR");
        theStateElements.sendKeys(Keys.ENTER);
    }

    //Facem o metoda care sa selecteze Orasul
    public void fillTheCity(){
        WebElement theCityElements = driver.findElement(By.id("rect-select-4-input"));
        theCityElements.sendKeys("Delhi");
        theCityElements.sendKeys(Keys.ENTER);
    }

    //Facem o metoda care sa faca click pe Submit
    public void clickOnSubmitButton(){
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();
    }

    //De validat tabelul de valori

}

