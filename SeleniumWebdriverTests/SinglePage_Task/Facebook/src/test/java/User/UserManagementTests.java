package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserManagementTests {
    //import selenium WebDriver
    private WebDriver driver;

    @BeforeClass
        public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","Resources/chromedriver.exe");
        //launch the chromedriver.exe file
        driver = new ChromeDriver ();
        //input the website URL
        driver.get("https://web.facebook.com/login");
        //wait for the page to load in 5 seconds
        Thread.sleep (5000);
        //Maximize the browser
        driver.manage().window().fullscreen();
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
        public void loginTest() throws InterruptedException {
        //Click on the email address field and input a valid email address "divaregina73@gmail.com"
        driver.findElement(By.id("email")).sendKeys ("divaregina73@gmail.com");
        //Click on the password field and input a valid password "regina1993"
        driver.findElement(By.id("pass")).sendKeys("regina1993");
        //Click on the login/signin button
        driver.findElement (By.xpath("//*[@id=\"loginbutton\"]")).click();
        Thread.sleep(5000);
        if(driver.getCurrentUrl().contains("https://web.facebook.com/")){
            System.out.println("PASSED - User has successfully logged in");
        }else{
            System.out.println("FAILED - The User was unable to login");
        }
        Thread.sleep(5000);
    }

    @Test
        public void logoutTest() throws InterruptedException {
        //Click on the drop-down button
        driver.findElement(By.cssSelector("div[aria-label=\"Account\"]")).click();
        //wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //click on log out button
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div")).click();
        Thread.sleep(5000);
        if (driver.getCurrentUrl().contains("https://web.facebook.com/login")){
            System.out.println("PASSED - User has successfully logged out");
        }else{
            System.out.println("FAILED - The user is still logged in");
        }
        Thread.sleep(5000);

    }

    @AfterTest
    public void teardown(){
        driver.quit ();
    }

}