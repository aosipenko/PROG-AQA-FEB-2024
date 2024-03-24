package org.prog.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlloUaPage {

    private WebDriver driver;

    public AlloUaPage(WebDriver driver) {
        this.driver = driver;
    }

    // ... other methods here ...

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(css = ".goods-tile-title")
    private WebElement searchResults;

    @FindBy(css = ".pagination-next")
    private WebElement nextPageButton;

    @FindBy(css = ".pagination-prev")
    private WebElement previousPageButton;

    @FindBy(css = ".pagination-list a")
    private List<WebElement> pageButtons;

    public void searchForGoods(String goodsName) {
        searchInput.sendKeys(goodsName);
        searchButton.click();
    }

    public boolean searchResultsContain(String goodsName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(searchResults));
        return searchResults.getText().contains(goodsName);
    }

    public void clickNextPage() {
        nextPageButton.click();
    }

    }

