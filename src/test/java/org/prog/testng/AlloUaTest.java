package org.prog.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        page.switchToNextPage();
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was present on the second page");
        page.switchToPreviousPage();
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was present again on the first page");
    }

    @Test
    public void searchForPhoneOnPage2() {
        String phoneName = "iPhone 15";
        page.loadPage();
        page.searchForGoods(phoneName);
        page.switchToPage(2);
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was present on the second page");
    }

    @Test
    public void searchForPhoneOnPage2AndBackToPage1() {
        String phoneName = "iPhone 15";
        page.loadPage();
        page.searchForGoods(phoneName);
        page.switchToPage(2);
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was present on the second page");
        page.switchToPreviousPage();
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was present again on the first page");
    }

    private void clickArrow(String direction) {
        if (direction.equalsIgnoreCase("next")) {
            page.clickNextPageArrow();
        } else if (direction.equalsIgnoreCase("prev")) {
            page.clickPreviousPageArrow();
        }
    }

    private class AlloUaPageUsingPageObject extends AlloUaPage {
        public void switchToPage(int pageNumber) {
            super.switchToPage(pageNumber);
        }

        public void switchToNextPage() {
            clickArrow("next");
        }

        public void switchToPreviousPage() {
            clickArrow("prev");
        }
    }

    @Override
    AlloUaPage getPage() {
        return new AlloUaPageUsingPageObject();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}