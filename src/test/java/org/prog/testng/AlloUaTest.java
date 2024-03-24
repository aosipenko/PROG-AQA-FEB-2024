package org.prog.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.pages.AlloUaPage;
import org.prog.web.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AlloUaTest {

    private final WebDriver driver = WebDriverFactory.getDriver();
    private AlloUaPage page;

    @BeforeSuite
    public void setUp() {
        page = new AlloUaPage(driver);
    }

    @Test
    public void searchForPhone() {
        String phoneName = "iPhone 15";
        page.loadPage();
        page.searchForGoods(phoneName);
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was present on page");
        page.scrollToElement(page.pagination());
        page.clickNextPage();
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was present on the next page");
    }

    @Test
    public void changePageAndSearchForPhone() {
        String phoneName = "iPhone 15";
        page.loadPage();
        page.clickPage(2);
        page.searchForGoods(phoneName);
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was present on page");
        page.clickPreviousPage();
        Assert.assertFalse(page.searchResultsContain(phoneName),
                "Phone with name '" + phoneName + "' was present on the previous page");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}