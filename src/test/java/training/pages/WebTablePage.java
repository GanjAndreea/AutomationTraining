package training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class WebTablePage extends BasePage{

    //Webelementele specifice paginii
    @FindBy(xpath = "//h1")
    private WebElement pageTitleElement;

    @FindBy(id = "addNewRecordButton")
    private WebElement addButtonElement;

    @FindBy(id = "firstName")
    private WebElement firstNameElement;

    @FindBy(id = "lastName")
    private WebElement lastNameElement;

    @FindBy(id = "userEmail")
    private WebElement emailAddressElement;

    @FindBy(id = "age")
    private WebElement ageElement;

    @FindBy(id = "salary")
    private WebElement salaryElement;

    @FindBy(id = "department")
    private WebElement departamentElement;

    @FindBy(id = "submit")
    private WebElement submitButtonElement;

    int initialTableSize = 0;

    @FindBy(xpath ="//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']" )
    private List<WebElement>tableElements;

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddButon() {
        elementsHelper.clickElement(addButtonElement);
    }

    public void fillTableRow(Map<String,Object> webElementData){
        List <String> firstNameValues = (List<String>) webElementData.get("firstName");
        List <String> lastNameValues = (List<String>) webElementData.get("lastName");
        List <String> emailValues = (List<String>) webElementData.get("email");
        List <String> ageValues = (List<String>) webElementData.get("age");
        List <String> salaryValues = (List<String>) webElementData.get("salary");
        List <String> departmentValues = (List<String>) webElementData.get("department");
        for (int i = 0 ; i<firstNameValues.size(); i++){
            clickOnAddButon();
            fillFirstName(firstNameValues.get(i));
            fillLastName(lastNameValues.get(i));
            fillEmailAddress(emailValues.get(i));
            fillAge(ageValues.get(i));
            fillSalary(salaryValues.get(i));
            fillDepartament(departmentValues.get(i));
            clickOnSubmitButton();
        }

    }

    public void fillFirstName(String name){
        elementsHelper.fillElement(firstNameElement, name);
    }

    public void fillLastName(String numeFamilie){
        elementsHelper.fillElement(lastNameElement, numeFamilie);
    }

    public void fillEmailAddress(String email) {
        elementsHelper.fillElement(emailAddressElement,email);
    }

    public void fillAge(String age) {
        elementsHelper.fillElement(ageElement,age);
    }

    public void fillSalary(String salary) {
        elementsHelper.fillElement(salaryElement,salary);
    }

    public void fillDepartament(String department) {
        elementsHelper.fillElement(departamentElement,department);
    }

    public void clickOnSubmitButton(){
        elementsHelper.clickElement(submitButtonElement);
    }



    //Facem o metoda prin care sa luam dimensiunea initiala a tabelului
    public int getInitialTableSize(){
        initialTableSize = tableElements.size();
        System.out.println("Tabelul are " + initialTableSize + " randuri");
        return initialTableSize;
    }

    //Facem o mettoda prin care sa validam ca dupa introducerea datelor in formular am mai introdus o linie in tabel
    public void checkNewTableRecord(){
        int actualTableSize = tableElements.size();
        int expectedTableSize = initialTableSize + 1;
        Assert.assertEquals(actualTableSize,expectedTableSize, "Actual table size " + actualTableSize + " is different than expected table size: " + expectedTableSize);
        System.out.println("Actual table size is  " + initialTableSize + " and expected table size is " + expectedTableSize);
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(pageTitleElement.getText(),"Web Tables","Title is invalid and actual value is " + pageTitleElement.getText());
    }
}
