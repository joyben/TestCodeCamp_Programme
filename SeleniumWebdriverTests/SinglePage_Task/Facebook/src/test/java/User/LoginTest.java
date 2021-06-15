package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    //import selenium WebDriver
    private WebDriver driver;

    @BeforeClass
        public void setup() throws InterruptedException {
        //fetch the chromeDriver.exe file
        System.setProperty ("webdriver.chrome.driver","resources/chromedriver.exe");
        //launch the chromedriver.exe file
        driver = new ChromeDriver();
        //input the website URL
        driver.get ("https://web.facebook.com/login");
        //wait for the page to load in 5 seconds
        Thread.sleep(5000);
        //Maximize the browser
        driver.manage().window ().fullscreen();
        //Get Page title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
        public void loginTest() throws InterruptedException {
        //Click on the email address field and input a valid email address "divaregina73@gmail.com"
        driver.findElement (By.id("email")).sendKeys("divaregina73@gmail.com");
        //Click on your password field and input a valid password "regina1993"
        driver.findElement(By.id("pass")).sendKeys("regina1993");
        //Click on the login/signin button
        driver.findElement (By.xpath("//*[@id=\"loginbutton\"]"));
        Thread.sleep(5000);
        if (driver.getCurrentUrl().contains("https://web.facebook.com/")){
            System.out.println("PASSED - User has successfully logged in");
        }else{
            System.out.println("FAILED - The user was unable to login");
        }
        Thread.sleep(5000);
    }

    @AfterTest
    public void teardown(){
        System.out.println("DRIVER VALUE >>> "+driver);
        driver.quit ();
    }



}
