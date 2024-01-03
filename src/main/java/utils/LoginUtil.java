package utils;

import org.apache.commons.lang3.StringUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class LoginUtil {
    private final WebDriver driver;
    Configuration config = new Configuration();
//    public WebDriver getDriver() {
//        return driver;
//    }
    public LoginUtil(WebDriver driver) {
        this.driver = driver;
    }
    public void login(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(config.getUrl());
        driver.manage().window().maximize();
        System.out.println("Url is opened successfully");

        WebElement account = driver.findElement(By.xpath(config.getClickOnMyAccount()));
        account.click();

        WebElement email=driver.findElement(By.id(config.getEnterEmail()));
        email.sendKeys(config.getValidEmail());
        System.out.println("Valid email is entered");

        WebElement pass= driver.findElement(By.id(config.getEnterPassword()));
        pass.sendKeys(config.getValidPassword());
        System.out.println("Valid password is entered");

        WebElement button=driver.findElement(By.xpath(config.getClickOnLogin()));
        if (button.isEnabled()) {
            button.click();
            System.out.println("Button clicked successfully");
        } else {
            System.out.println("Button is not clickable");
        }
        System.out.println("User is logged in successfully");

        String expectedUrl = "https://ecommerce-playground.lambdatest.io";
        String actualUrl = driver.getCurrentUrl();
       // Assert.assertEquals(expectedUrl, actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl, "Url does not match");

    }

    public void invalidCredentials() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(config.getUrl());
        driver.manage().window().maximize();
        System.out.println("Url is opened successfully");

        WebElement account = driver.findElement(By.xpath(config.getClickOnMyAccount()));
        account.click();

        WebElement email=driver.findElement(By.id(config.getEnterEmail()));
        email.sendKeys(config.getValidEmail());
        System.out.println("Valid email is entered");

        WebElement pass= driver.findElement(By.id(config.getEnterPassword()));
        pass.sendKeys(config.getInvalidPassword());
        System.out.println("Invalid password is entered");

        WebElement button=driver.findElement(By.xpath(config.getClickOnLogin()));
        button.click();
        WebElement errorMessage = driver.findElement(By.xpath(config.getErrorMessage()));
        Assert.assertTrue(errorMessage.isDisplayed());

        String expectedError="Warning: No match for E-Mail Address and/or Password.";
        String actualError=driver.findElement(By.xpath(config.getErrorMessage())).getText();
        System.out.println("Actual error: " + actualError);
        Assert.assertEquals(actualError, expectedError, "Error message does not match");

    }
    public void loginWithEmptyFields() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(config.getUrl());
        driver.manage().window().maximize();
        System.out.println("Url is opened successfully");

        WebElement account = driver.findElement(By.xpath(config.getClickOnMyAccount()));
        account.click();

        WebElement button=driver.findElement(By.xpath(config.getClickOnLogin()));
        button.click();
        WebElement errorMessage = driver.findElement(By.xpath(config.getErrorMessage()));
        Assert.assertTrue(errorMessage.isDisplayed());

        String expectedError="Warning: No match for E-Mail Address and/or Password.";
        String actualError=driver.findElement(By.xpath(config.getErrorMessage())).getText();
        System.out.println("Actual error: " + actualError);
        Assert.assertEquals(actualError, expectedError, "Error message does not match");
    }
    public void checkOut() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(config.getUrl());
        driver.manage().window().maximize();
        System.out.println("Url is opened successfully");

        WebElement account = driver.findElement(By.xpath(config.getClickOnMyAccount()));
        account.click();

        WebElement email=driver.findElement(By.id(config.getEnterEmail()));
        email.sendKeys(config.getValidEmail());
        System.out.println("Valid email is entered");

        WebElement pass= driver.findElement(By.id(config.getEnterPassword()));
        pass.sendKeys(config.getValidPassword());
        System.out.println("Valid password is entered");

        WebElement button=driver.findElement(By.xpath(config.getClickOnLogin()));
        button.click();
        System.out.println("User is logged in successfully");

        driver.findElement(By.xpath(config.getCheckOut()));
        WebElement linkElement = driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[14]"));
        linkElement.click();

        String expectedMessage="Account Logout";
        String actualMessage=driver.findElement(By.xpath(config.getLogOutMessage())).getText();
        System.out.println("Actual Message: " + actualMessage);
        if (StringUtils.equals(actualMessage, expectedMessage)) {
            System.out.println("User is successfully logged out");
        } else {
            System.out.println("Unable to logout");
        }

    }
    public void searchItem(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(config.getUrl());
        driver.manage().window().maximize();
        System.out.println("Url is opened successfully");

        WebElement account = driver.findElement(By.xpath(config.getClickOnMyAccount()));
        account.click();

        WebElement email=driver.findElement(By.id(config.getEnterEmail()));
        email.sendKeys(config.getValidEmail());
        System.out.println("Valid email is entered");

        WebElement pass= driver.findElement(By.id(config.getEnterPassword()));
        pass.sendKeys(config.getValidPassword());
        System.out.println("Valid password is entered");

        WebElement button=driver.findElement(By.xpath(config.getClickOnLogin()));
        button.click();
        System.out.println("User is logged in successfully");

        WebElement home= driver.findElement(By.xpath(config.getClickOnHome()));
        home.click();
        System.out.println("Home button is clicked");

        WebElement search= driver.findElement(By.xpath(config.getSearchField()));
        search.sendKeys("iMac");

        WebElement searchBtn=driver.findElement(By.xpath(config.getSearchButton()));
        if (searchBtn.isEnabled()) {
            searchBtn.click();
            System.out.println("Search button is clicked");
        }
        else {
            System.out.println("button does not click");
        }

    }
}



