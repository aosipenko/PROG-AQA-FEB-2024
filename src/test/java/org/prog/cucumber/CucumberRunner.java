package org.prog.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StepDefinitions {

    private Connection connection;

    @Given("the SQL table for products exists")
    public void the_SQL_table_for_products_exists() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:test");
            String sql = "CREATE TABLE IF NOT EXISTS PRODUCTS (NAME VARCHAR(255), PRICE DECIMAL(10, 2))";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            Assert.fail("Failed to create the SQL table for products: " + e.getMessage());
        }
    }

    @When("the price for the product {string} is {double}")
    public void the_price_for_the_product_is(String product, double price) {
        try {
            String sql = "INSERT INTO PRODUCTS (NAME, PRICE) VALUES (?, ?) ON CONFLICT (NAME) DO UPDATE SET PRICE = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, product);
                stmt.setDouble(2, price);
                stmt.setDouble(3, price);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            Assert.fail("Failed to record the product price in the database: " + e.getMessage());
        }
    }

    @When("the current price for the product {string} is {double}")
    public void the_current_price_for_the_product_is(String product, double price) {
        // This method can be implemented using a web scraping library or an API
        // In this example, we'll assume the price is retrieved from an external source
        // and stored in the `currentPrice` variable
        double currentPrice = 19.99;
        updateProductPriceInDatabase(product, currentPrice);
    }

    @Then("the price in the database should be {double}")
    public void the_price_in_the_database_should_be(double expectedPrice) {
        try {
            String sql = "SELECT PRICE FROM PRODUCTS WHERE NAME = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, "Test Product");
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        double price = rs.getDouble("PRICE");
                        Assert.assertEquals("The price in the database is not the same as the expected price.", expectedPrice, price, 0.01);
                    } else {
                        Assert.fail("The product was not found in the database.");
                    }
                }
            }
        } catch (SQLException e) {
            Assert.fail("Failed to retrieve the product price from the database: " + e.getMessage());
        }
    }

    private void updateProductPriceInDatabase(String product, double price) {
        try {
            String sql = "UPDATE PRODUCTS SET PRICE = ? WHERE NAME = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setDouble(1, price);
                stmt.setString(2, product);
                {
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);}
