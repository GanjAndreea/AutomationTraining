package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import training.helpers.AlertHelpers;
import training.helpers.ElementsHelper;
import training.helpers.FrameHelpers;
import training.helpers.WindowHelpers;

public abstract class BasePage {

    //Variabila driver o sa fie folosita in toate paginile care o sa mosteneasca BasePage
public WebDriver driver;

public ElementsHelper elementsHelper;

public AlertHelpers alertHelpers;

public WindowHelpers windowHelpers;

public FrameHelpers frameHelpers;


//Facem un constructor care sa initializeze driverul
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.elementsHelper = new ElementsHelper(driver);
        this.alertHelpers = new AlertHelpers(driver);
        this.windowHelpers = new WindowHelpers(driver);
        this.frameHelpers = new FrameHelpers(driver);
        PageFactory.initElements(driver, this);
    }

    //Facem o metoda abstracta pe care fiecare pagina trebuie sa o implementeze pentru a verifica daca pagina e incarcata corect

    abstract void isPageLoaded();
}
