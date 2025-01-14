package training.tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import propertyUtility.PropertyUtility;
import training.pages.CommonPage;
import training.pages.HomePage;

public class BaseTest {

    public WebDriver driver;
    public HomePage homePage;
    public CommonPage commonPage;
    public PropertyUtility propertyUtility;

    @BeforeMethod
    public void openBroswer(){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

        driver.get("https://demoqa.com/");

        //Facem fereastra la dimensiune maxima
        driver.manage().window().maximize();

        //facem fereastra la dimensiunea dorita 1980 cu 1080
        //driver.manage().window().setSize(new Dimension(1980,1080));
    }

    @AfterMethod
    public void quitBroswer(){
        if (driver!= null){
            driver.quit();
        }
    }
}
