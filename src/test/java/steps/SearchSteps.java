package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.SearchResultsPage;
import pages.YandexSearchPage;

import java.util.concurrent.TimeUnit;

public class SearchSteps {
    private WebDriver driver;
    private YandexSearchPage yandexSearchPage;
    private SearchResultsPage searchResultsPage;
    private String searchWord;

    @Before
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        yandexSearchPage = new YandexSearchPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("Word for search is {string}")
    public void wordForSearchIs(String arg0) {
        this.searchWord = arg0;
    }

    @And("I enter search word")
    public void iEnterSearchWord() {
        yandexSearchPage.setSearchInputValue(searchWord);
    }

    @And("I press search button")
    public void iPressSearchButton() {
        yandexSearchPage.clickSearchButton();
    }

    @Then("First result contains search word in title")
    public void firstResultContainsSearchWordInTitle() {
        String firstResultText = searchResultsPage.getSearchResultTitleByIndex(1);
        boolean doesContains = firstResultText.toLowerCase().trim().contains(searchWord.toLowerCase().trim());
        Assert.assertTrue(doesContains);
    }

    @Then("There are {int} results are present")
    public void thereAreResultsArePresent(int arg0) {
        Assert.assertEquals(searchResultsPage.getSearchResultsCount(), arg0);
    }

    @When("I navigate to yandex.by")
    public void iNavigateToYandexBy() {
        yandexSearchPage.open();
    }

    @Given("pre condition")
    public void preCondition() {
        System.out.println("I am pre-condition");
    }
}
