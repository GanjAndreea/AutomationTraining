package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    //Variabila driver o sa fie folosita in toate paginile care o sa mosteneasca BasePage
public WebDriver driver;

//Facem un constructor care sa initializeze driverul
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Facem o metoda abstracta pe care fiecare pagina trebuie sa o implementeze pentru a verifica daca pagina e incarcata corect

    abstract void isPageLoaded();
}
