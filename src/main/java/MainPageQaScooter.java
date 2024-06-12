import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageQaScooter {
    private WebDriver driver;
    // Локатор первой кнопки "Заказать"
    private By firstButtonOrder = By.xpath(".//button[@class= 'Button_Button__ra12g']");
    // Локатор второй кнопки "Заказать"
    private By secondButtonOrder = By.xpath(".//button[contains(@class, 'Button_UltraBig__UU3Lp')]");
    private By logoSamokat = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']");
    private By logoYandex = By.xpath(".//a[@class='Header_LogoYandex__3TSOI']");

    public MainPageQaScooter(WebDriver driver) {
        this.driver = driver;
    }

    //метод для нажатия на кнопку "Заказать"
    public void clickFirstButtonOrder() {
        driver.findElement(firstButtonOrder).click();
    }

    // Метод для нажатия на кнопку "Заказать" в середине страницы
    public void clickSecondButtonOrder() {
        driver.findElement(secondButtonOrder).click();
    }
    // Метод для прокрутки главной страницы
    public void scrollToElement(String elementLocation) {
        WebElement element = driver.findElement(By.id(elementLocation));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    // Метод для клика по полям часто задоваемых вопросов
    public void clickFaqElement(String elementlocation) {
        driver.findElement(By.id(elementlocation)).click();
    }
    //Метод для проверки выводимой информации в ответе на часто задоваемый вопрос
    public void testFaqField(String elementLocation, String resultText) {
        Assert.assertEquals(driver.findElement(By.xpath(elementLocation)).getText(), resultText);
    }
    // Метод для ожидания прогрузки элемента
    public void waitDropText(String elementLocation) {
        new WebDriverWait(driver, 5).until(driver -> (driver.findElement(By.xpath(elementLocation))).getText() != null
                && !driver.findElement(By.xpath(elementLocation)).getText().isEmpty());
    }
    public void clickLogoSamokat() {
        driver.findElement(logoSamokat).click();
    }
    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }
    public void currenUrl() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa-scooter.praktikum-services.ru/");
    }
    public void currenUrlYandex() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://dzen.ru/?yredirect=true");
    }
}