package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import training.helpers.ElementsHelper;

public abstract class BasePage {

    //Variabila driver o sa fie folosita in toate paginile care o sa mosteneasca BasePage
public WebDriver driver;

public ElementsHelper elementsHelper;

//Facem un constructor care sa initializeze driverul
    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementsHelper = new ElementsHelper(driver);
        PageFactory.initElements(driver, this);
    }

    //Facem o metoda abstracta pe care fiecare pagina trebuie sa o implementeze pentru a verifica daca pagina e incarcata corect

    abstract void isPageLoaded();
}
