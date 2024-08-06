import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class TestPositiveSceneryTopButton {
    private final int buttonOrder;
    private final String name;
    private final String family;
    private final String address;
    private final String telephone;
    private final String date;
    private final String comment;
    public TestPositiveSceneryTopButton (int buttonOrder, String name, String family, String address, String telephone, String date, String comment) {
        this.buttonOrder = buttonOrder;
        this.name = name;
        this.family = family;
        this.address = address;
        this.telephone = telephone;
        this.date = date;
        this.comment = comment;

    }
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    private WebDriver driver;
    @Parameterized.Parameters
    public  static  Object[][] getCredentials() {
        return new Object[][] {
                {2, "Павел", "Андрианов", "Авиамоторная 17","+79999999999", "12.06.2024", "Код от домофона 179*235"},
                {5, "Екатерина", "Васильева", "Московский бульвар", "+79998887744", "13.06.2024", ""}
        };
    }
    @Test
    public void checkAllFlowPositiveCase() {

        MainPageQaScooter objMainPageQaScooter = new MainPageQaScooter(driver);
        objMainPageQaScooter.scrollToElementButton(buttonOrder);
        objMainPageQaScooter.waitButtonOrder(buttonOrder);
        objMainPageQaScooter.clickButtonOrder(buttonOrder);
        FirstOrderPage objFirstOrderPage = new FirstOrderPage(driver);
        objFirstOrderPage.setNameField(name);
        objFirstOrderPage.setFamilyNameField(family);
        objFirstOrderPage.setAddressField(address);
        objFirstOrderPage.clickStationField();
        objFirstOrderPage.waitDropListStation();
        objFirstOrderPage.scrollToAviamotornaya();
        objFirstOrderPage.clickStationAviamotornaya();
        objFirstOrderPage.setTelephoneField(telephone);
        objFirstOrderPage.clickButtonNext();
        SecondOrderPage objSecondOrderPage = new SecondOrderPage(driver);
        objSecondOrderPage.setDateField(date);
        objSecondOrderPage.clickOfRentHeader();
        objSecondOrderPage.clickTermRentField();
        objSecondOrderPage.clickEnterTermRentField();
        objSecondOrderPage.clickColorField();
        objSecondOrderPage.setCommentField(comment);
        objSecondOrderPage.clickEndOrderButton();
        objSecondOrderPage.clickYesButton();
        objSecondOrderPage.waitResultHeader();
        objSecondOrderPage.descriptionFieldResult();
    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
