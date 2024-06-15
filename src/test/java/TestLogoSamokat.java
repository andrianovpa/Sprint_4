import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogoSamokat {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    private WebDriver driver;

    @Test
    public void checkFirstPointDropList() {

        MainPageQaScooter objMainPageQaScooter = new MainPageQaScooter(driver);
        objMainPageQaScooter.clickLogoSamokat();
        objMainPageQaScooter.currenUrl();
    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}

