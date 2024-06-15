import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstOrderPage {
    private WebDriver driver;
    // локатор для поля "Имя"
    private By nameField = By.xpath(".//input[contains(@placeholder, '* Имя')]");
    // локатор для поля "Фамилия"
    private By familyNameField = By.xpath(".//input[contains(@placeholder, '* Фамилия')]");
    // локатор для поля "Адрес: куда привезти заказ"
    private By addressField = By.xpath(".//input[contains(@placeholder, '* Адрес: куда привезти заказ')]");
    // локатор для поля "Станция метро"
    private By stationField = By.xpath(".//input[contains(@placeholder, '* Станция метро')]");
    // локатор для станции Авиамоторная в выпадающем списке
    private By stationAviamotornaya = By.xpath(".//div[text()='Авиамоторная']");
    // локатор для поля "Телефон: на него позвонит курьер"
    private By telephoneField = By.xpath(".//input[contains(@placeholder, '* Телефон: на него позвонит курьер')]");
    // локатор для кнопки "Далее"
    private By buttonNext = By.xpath(".//button[text()='Далее']");

    public FirstOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    // Метод для заполнения поля "Имя"
    public void setNameField(String username) {
        driver.findElement(nameField).sendKeys(username);
    }
    // Метод для заполнения поля "Фамилия"
    public void setFamilyNameField(String userFamilyName) {
        driver.findElement(familyNameField).sendKeys(userFamilyName);
    }
    // Метод для заполнения поля "Адрес"
    public void setAddressField(String userAddress) {
        driver.findElement(addressField).sendKeys(userAddress);
    }
    // Метод для клика по полю "Станция метро"
    public void clickStationField() {
        driver.findElement(stationField).click();
    }
    // Метод для выбора станции "Авиамоторная"
    public void clickStationAviamotornaya() {
        driver.findElement(stationAviamotornaya).click();
    }
    // Метод для заполнения поля "Телефон: на него позвонит курьер"
    public void setTelephoneField(String telefone) {
        driver.findElement(telephoneField).sendKeys(telefone);
    }
    // Метод для клика по кнопке "Далее"
    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }
    // Метод для ожидания выпадающего списка станций
    public void waitDropListStation(){
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(stationAviamotornaya)).getText() != null
                && !driver.findElement(stationAviamotornaya).getText().isEmpty());
    }
    // Метод для скрола до станции "Авиамотрная"
    public void scrollToAviamotornaya(){
        WebElement element = driver.findElement(stationAviamotornaya);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}