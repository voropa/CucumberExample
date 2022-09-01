package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexSearchPage  extends BasePage {
    private final static By SEARCH_INPUT_LOCATOR = By.cssSelector("#text");
    private final static By SEARCH_BUTTON_LOCATOR = By.cssSelector("button[type=submit]");

    public YandexSearchPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://yandex.by/");
    }

    public void setSearchInputValue(String value) {
        driver.findElement(SEARCH_INPUT_LOCATOR).sendKeys(value);
    }

    public void clickSearchButton() {
        driver.findElement(SEARCH_BUTTON_LOCATOR).click();
    }
}
