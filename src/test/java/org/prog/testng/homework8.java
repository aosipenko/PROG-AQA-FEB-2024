package org.prog.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class homework8 {
    private WebDriver driver;
    private By searchInput = By.id("searchInput");
    private By searchButton = By.id("searchButton");
    private By searchResult = By.cssSelector(".search-result");
    private By pagination = By.cssSelector(".pagination");
    private By pageNumberLink = By.cssSelector(".pagination li a");

    public homework8(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String query) {
        driver.findElement(searchInput).sendKeys(query);
        driver.findElement(searchButton).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(searchResult));
    }

    public void switchToPage(int pageNumber) {
        WebElement paginationElement = driver.findElement(pagination);
        List<WebElement> pageNumberLinks = paginationElement.findElements(pageNumberLink);
        for (WebElement link : pageNumberLinks) {
            if (Integer.parseInt(link.getText()) == pageNumber) {
                link.click();
                break;
            }
        }
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(searchResult));
    }

    public void switchToNextPage() {
        WebElement paginationElement = driver.findElement(pagination);
        List<WebElement> pageNumberLinks = paginationElement.findElements(pageNumberLink);
        WebElement nextPageLink = pageNumberLinks.get(pageNumberLinks.size() - 1);
        nextPageLink.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(searchResult));
    }

    public void switchToPreviousPage() {
        WebElement paginationElement = driver.findElement(pagination);
        List<WebElement> pageNumberLinks = paginationElement.findElements(pageNumberLink);
        WebElement previousPageLink = pageNumberLinks.get(0);
        previousPageLink.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(searchResult));
    }
}
public class SearchTest {
    private WebDriver driver;
    private SearchPage searchPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testSearchAndSwitchPages() {
        searchPage.search("iPhone 15");
        // Verify that the searched value is present on the first page
        // ...
        searchPage.switchToNextPage();
        // Verify that the searched value is present on the second page
        // ...
        searchPage.switchToPreviousPage();
        // Verify that the searched value is present on the first page again
        // ...
        searchPage.switchToPage(3);
        // Verify that the searched value is present on the third page
        // ...
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}