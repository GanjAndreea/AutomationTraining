package training.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import propertyUtility.PropertyUtility;
import training.pages.WebTablePage;

import java.util.List;
import java.util.Map;

import static training.constants.MenuKeys.ELEMENT_MENU;
import static training.constants.SubMenuKeys.WEBTABLE_SUBMENU;

public class WebTablesTest extends BaseTest{

   //Declaram o variabila globala pentru dimensiunea tabelului
    int initialTableSize = 0;

    @Test
    public void navigateFromHomePageToPracticeElementsPage() {
        homePage.isPageLoaded();
        homePage.goToDesireMenu(ELEMENT_MENU);
        commonPage.isPageLoaded();
        commonPage.selectSubMenu(WEBTABLE_SUBMENU);
        WebTablePage webTablePage = new WebTablePage(driver);
        propertyUtility =new PropertyUtility("WebElementTest");

//        webTablePage.fillTableRow();
        Map<String,Object> webElementDataEntry = propertyUtility.getAllProperties();
        webTablePage.isPageLoaded();
//        webTablePage.getInitialTableSize();
        webTablePage.fillTableRow(webElementDataEntry);
//        webTablePage.checkNewTableRecord();
//        openBrowser();
//        clickOnElementsMenu();
//        openWebTables();
//        getInitialTableSize();
//        clickOnAddButon();
//        fillRegistrationForm();
//        checkNewTableRecord();
    }
//
//    public void openBrowser() {
//        driver = new ChromeDriver();
//        driver.get("https://demoqa.com/");
//        driver.manage().window().setSize(new Dimension(1980, 1080));
//    }

//    public void clickOnElementsMenu() {
//        WebElement formsMenuElement = driver.findElement(By.xpath("//h5[text()='Elements']"));
//        formsMenuElement.click();
//    }
//
//    public void openWebTables() {
//        WebElement webTablesElements = driver.findElement(By.xpath("//span[text()='Web Tables']"));
//        webTablesElements.click();
//    }
//
//    //Fac o metoda sa apas pe add button
//    public void clickOnAddButon() {
//        WebElement addButtonElement = driver.findElement(By.id("addNewRecordButton"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(addButtonElement).click().perform();
//    }

    //Facem o metoda care completeaza tot formularul deodata
//    public void fillRegistrationForm(){
//        fillFirstName("Ionut");
//        fillLastName("Tester");
//        fillEmailAddress("ionut.tester@yahoo.com");
//        fillAge("99");
//        fillSalary("999999");
//        fillDepartament("IT/MC");
//        clickOnSubmitButton();
//    }

    //Fac o metoda care sa completeze First Name
//    public void fillFirstName(String firstName){
//        WebElement firstNameElement = driver.findElement(By.xpath("//input[@id='firstName']"));
//        firstNameElement.sendKeys(firstName);
//    }

    //Fac o metoda care sa completeze Last Name
//    public void fillLastName(String lastName){
//        WebElement lastNameElement = driver.findElement(By.xpath("//input[@id='lastName']"));
//        lastNameElement.sendKeys(lastName);
//    }
//
//    //Fac o metoda care sa completeze Email
//    public void fillEmailAddress(String emailAddress) {
//        WebElement emailAddressElement= driver.findElement(By.xpath("//input[@id='userEmail']"));
//        emailAddressElement.sendKeys(emailAddress);
//    }
//
//    //Fac o metoda care sa completeze Age
//    public void fillAge(String age) {
//        WebElement ageElement= driver.findElement(By.xpath("//input[@id='age']"));
//        ageElement.sendKeys(age);
//    }
//
//    //Fac o metoda care sa completeze Salary
//    public void fillSalary(String salary) {
//        WebElement salaryElement= driver.findElement(By.xpath("//input[@id='salary']"));
//        salaryElement.sendKeys(salary);
//    }
//
//    //Fac o metoda care sa completeze Department
//    public void fillDepartament(String departament) {
//        WebElement departamentElement= driver.findElement(By.xpath("//input[@id='department']"));
//        departamentElement.sendKeys(departament);
//    }
//
//    //Fac o metoda care sa apese Submit Button
//    public void clickOnSubmitButton(){
//        WebElement submitButtonElement = driver.findElement(By.xpath("//button[@id='submit']"));
//        Actions action = new Actions(driver);
//        action.moveToElement(submitButtonElement).click().perform();
//    }

    //Fac o metoda prin care dovedesc ca am adaugat un rand in tabel (Tema)

    //Facem o metoda prin care sa luam dimensiunea initiala a tabelului
//    public int getInitialTableSize(){
//        List<WebElement> tableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
//        initialTableSize = tableElements.size();
//        System.out.println("Tabelul are " + initialTableSize + " randuri");
//        return initialTableSize;
//    }

//    public void scrollDown (){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,400)");
//    }
//
//    public void waitForElement (WebElement element){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait.until(ExpectedCondition.visibilityOf(element));
//    }

//    //Facem o mettoda prin care sa validam ca dupa introducerea datelor in formular am mai introdus o linie in tabel
//    public void checkNewTableRecord(){
//        List<WebElement> tableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
//        int actualTableSize = tableElements.size();
//        int expectedTableSize = initialTableSize + 1;
//        Assert.assertEquals(actualTableSize,expectedTableSize, "Actual table size " + actualTableSize + " is different than expected table size: " + expectedTableSize);
//        System.out.println("Actual table size is  " + actualTableSize + " and expected table size is " + expectedTableSize);
//    }

}
