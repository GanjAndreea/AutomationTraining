package training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

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

    public void fillTableRow(){
        fillFirstName();
        fillLastName();
        fillEmailAddress();
        fillAge();
        fillSalary();
        fillDepartament();
    }

    public void fillFirstName(){
        elementsHelper.fillElement(firstNameElement, "Ionut");
    }

    public void fillLastName(){
        elementsHelper.fillElement(lastNameElement, "Tester");
    }

    public void fillEmailAddress() {
        elementsHelper.fillElement(emailAddressElement,"ionut.tester@yahoo.com");
    }

    public void fillAge() {
        elementsHelper.fillElement(ageElement,"99");
    }

    public void fillSalary() {
        elementsHelper.fillElement(salaryElement,"999999");
    }

    public void fillDepartament() {
        elementsHelper.fillElement(departamentElement,"IT/MC");
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
