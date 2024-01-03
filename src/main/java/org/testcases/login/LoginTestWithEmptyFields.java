package org.testcases.login;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.DriverFactory;
import utils.LoginUtil;
import utils.ScreenShots;

public class LoginTestWithEmptyFields {
    private WebDriver driver;
    LoginUtil loginUtil;
    ScreenShots src = new ScreenShots();

    @BeforeMethod
    @Parameters({"browser"})
    public void beforeMethod(String browser) {
        driver = DriverFactory.build(browser);
        loginUtil = new LoginUtil(driver);
    }

    @Test()
    public void emptyFieldTest(){
        loginUtil.loginWithEmptyFields();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        src.takeScreenshotOnFailure(driver, result);
        driver.quit();
    }
}
