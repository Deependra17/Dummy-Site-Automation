package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    public String getUrl() {
        return url;
    }

    public String getValidEmail() {
        return ValidEmail;
    }

    public String getValidPassword() {
        return ValidPassword;
    }

    public String getInvalidEmail() {
        return InvalidEmail;
    }

    public String getInvalidPassword() {
        return InvalidPassword;
    }

    public String getClickOnMyAccount() {
        return ClickOnMyAccount;
    }

    public String getEnterEmail() {
        return EnterEmail;
    }

    public String getEnterPassword() {
        return EnterPassword;
    }

    public String getClickOnLogin() {
        return ClickOnLogin;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public String getCheckOut() {
        return CheckOut;
    }

    public String getLogOutMessage() {
        return LogOutMessage;
    }

    public String getClickOnHome() {
        return ClickOnHome;
    }

    public String getSearchField() {
        return SearchField;
    }

    public String getSearchButton() {
        return SearchButton;
    }

    private String url;
    private String ValidEmail;
    private String ValidPassword;
    private String InvalidEmail;
    private String InvalidPassword;
    private String ClickOnMyAccount;
    private String EnterEmail;
    private String EnterPassword;
    private String ClickOnLogin;
    private String ErrorMessage;
    private String CheckOut;
    private String LogOutMessage;
    private String ClickOnHome;
    private String SearchField;
    private String SearchButton;


    Configuration() {

        try (
                InputStream input = new FileInputStream("src/main/resources/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);
            this.url = prop.getProperty("url");
            this.ValidEmail = prop.getProperty("ValidEmail");
            this.ValidPassword = prop.getProperty("ValidPassword");
            this.InvalidEmail = prop.getProperty("InvalidEmail");
            this.InvalidPassword = prop.getProperty("InvalidPassword");
            this.ClickOnMyAccount = prop.getProperty("ClickOnMyAccount");
            this.EnterEmail = prop.getProperty("EnterEmail");
            this.EnterPassword = prop.getProperty("EnterPassword");
            this.ClickOnLogin = prop.getProperty("ClickOnLogin");
            this.ErrorMessage = prop.getProperty("ErrorMessage");
            this.CheckOut = prop.getProperty("CheckOut");
            this.LogOutMessage = prop.getProperty("LogOutMessage");
            this.ClickOnHome = prop.getProperty("ClickOnHome");
            this.SearchField = prop.getProperty("SearchField");
            this.SearchButton=prop.getProperty("SearchButton");

        } catch (
                IOException ex) {
            ex.printStackTrace();
        }

    }
}
