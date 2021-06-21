package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
    private By welcomeAdmin = By.id("welcome");
    private By logOut = By.linkText("Logout");

    public void clickWelcomeAdmin () throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(welcomeAdmin).click();
    }

    public LoginPage clickLogOutButton () throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(logOut).click();
        return new LoginPage(driver);
    }


}
