import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondOrderPage {
    private WebDriver driver;
    // локатор для поля "Когда привезти самокат"
    private By dateField = By.xpath(".//input[contains(@placeholder, '* Когда привезти самокат')]");
    // локатор заголовок страницы "Про аренду"
    private By ofRentHeader = By.xpath(".//div[text()='Про аренду']");
    // локатор для поля "Срок аренды"
    private By termRentField = By.xpath(".//div[text()='* Срок аренды']");
    // локатор для выбора "сутки" в поле "Срок аренды"
    private By enterTermRentField = By.xpath(".//div[text()='сутки']");
    // локатор для выбора цвета самоката "Чёрный жемчуг"
    private By colorField = By.id("black");
    // локатор для поля "Комментарий для курьера"
    private By commentField = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]");
    // локатор для кнопки "Заказать" в конце страницы
    private By endOrderButton = By.xpath(".//button[2][text()='Заказать']");
    // локатор для кнопки "Да"
    private By yesButton = By.xpath(".//button[text()='Да']");
    // локатор для заголовка с результатом заказа "Заказ оформлен"
    private By resultHeader = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public SecondOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    //Метод для заполнения поля "Дата"
    public void setDateField(String date) {
        driver.findElement(dateField).sendKeys(date);
    }
    // Метод для клика по по заголовку страницы(использую для снятия фокуса с поля"
    public void clickOfRentHeader() {
        driver.findElement(ofRentHeader).click();
    }
    // Метод для слика по полю "Срок аренды"
    public void clickTermRentField() {
        driver.findElement(termRentField).click();
    }
    // Метод для выбора срока аренды из выпадющего списка
    public void clickEnterTermRentField() {
        driver.findElement(enterTermRentField).click();
    }
    // Метод для выбора цвета самоката
    public void clickColorField() {
        driver.findElement(colorField).click();
    }
    // Метод для указания комментария для курьера
    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    // Метод для нажатия на кнопку "Заказать" в конце заказа(нижняя кнопка)
    public void clickEndOrderButton() {
        driver.findElement(endOrderButton).click();
    }
    // Метод для клика по кнопке "Да"
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    // Метод для проверки появления на экране текста "Заказ оформлен"
    public void descriptionFieldResult() {
        Assert.assertTrue(driver.findElement(resultHeader).getText().contains("Заказ оформлен"));
    }
    public void waitResultHeader(){
        new WebDriverWait(driver, 5).until(driver -> (driver.findElement(resultHeader)).getText() != null
                && !driver.findElement(resultHeader).getText().isEmpty());
    }
}
