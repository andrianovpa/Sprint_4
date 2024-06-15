import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageQaScooter {
    private WebDriver driver;
    // Локатор кнопки "Заказать"
    public String buttonOrderLocation = ".//div[%d]/button[contains(text(), 'Заказать')]";

    // Локатор для логотипа "Самокат"
    private By logoSamokat = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']");
    // Локатор для логотипа "Яндекс"
    private By logoYandex = By.xpath(".//a[@class='Header_LogoYandex__3TSOI']");
    //Локатор для вопросов о важном
    private String locationFieldQuest = ".//div[%d]/div[1]/div[@class = 'accordion__button']";
    //Локатор для ответов на вопросы о важном
    private String locationFieldAnswer = ".//div[@id = 'accordion__panel-%d']/p";

    public MainPageQaScooter(WebDriver driver) {
        this.driver = driver;
    }


    //метод для нажатия на кнопку "Заказать"
    public void clickButtonOrder(int indexButtonOrder) {
        driver.findElement(By.xpath(String.format(buttonOrderLocation, indexButtonOrder))).click();
    }
    //Метод для ожидания активации кнопки Заказать
    public void waitButtonOrder(int buttonOrder) {
        new WebDriverWait(driver, 5).until(driver -> (driver.findElement(By.xpath(String.format(buttonOrderLocation, buttonOrder)))).getText() != null
                && !driver.findElement(By.xpath(String.format(buttonOrderLocation, buttonOrder))).getText().isEmpty());
    }
    // Метод для прокрутки главной страницы до вопросов о важном
    public void scrollToElementQuest(int elementLocation) {
        WebElement element = driver.findElement(By.xpath(String.format(locationFieldQuest, elementLocation)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Метод для прокрутки главной страницы до кнопки заказать
    public void scrollToElementButton(int elementLocation) {
        WebElement element = driver.findElement(By.xpath(String.format(buttonOrderLocation, elementLocation)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    // Метод для клика по полям часто задоваемых вопросов
    public void clickFaqElement(int elementLocation) {
        driver.findElement(By.xpath(String.format(locationFieldQuest, elementLocation))).click();
    }
    //Метод для проверки выводимой информации в ответе на часто задоваемый вопрос
    public void testFaqField(int elementLocation, String resultText) {
        Assert.assertEquals(driver.findElement(By.xpath(String.format(locationFieldAnswer, elementLocation))).getText(), resultText);
    }
    // Метод для ожидания прогрузки элемента
    public void waitDropText(int elementLocation) {
        new WebDriverWait(driver, 5).until(driver -> (driver.findElement(By.xpath(String.format(locationFieldAnswer, elementLocation)))).getText() != null
                && !driver.findElement(By.xpath(String.format(locationFieldAnswer, elementLocation))).getText().isEmpty());
    }
    // Метод для нажатия на логотип "Самокат"
    public void clickLogoSamokat() {
        driver.findElement(logoSamokat).click();
    }
    // Метод для нажатия на логотип "Яндекс"
    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }
    // Метод для получения текущего URL
    public void currenUrl() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa-scooter.praktikum-services.ru/");
    }
    // Метод для проверки URL на соответствие
    public void currenUrlYandex() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://dzen.ru/?yredirect=true");
    }
}