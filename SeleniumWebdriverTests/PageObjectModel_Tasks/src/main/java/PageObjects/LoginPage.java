package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    // Using By as a locator for elements
    private By username = By.id("txtUsername");

    public void enterUsername (String uName) {
        driver.findElement(username).sendKeys(uName);
    }

    public void enterUserPassword (String pWord) {
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys(pWord);
    }

    public DashboardPage clickLoginButton ()
    {
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        return new DashboardPage(driver);
    }
}
