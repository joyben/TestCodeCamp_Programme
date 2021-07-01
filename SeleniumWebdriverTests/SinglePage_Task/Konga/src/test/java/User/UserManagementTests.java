package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserManagementTests {
    //import selenium WebDriver
    private WebDriver driver;
    private By addItem;
    private int itemNumber;
    private int count;

    @BeforeClass
    public void setUp() throws InterruptedException {
        //fetch the chromeDriver.exe file
        System.setProperty("webdriver.chrome.driver","Resources/chromedriver.exe");
        //launch the chromedriver.exe file
        driver = new ChromeDriver();
        //input the website URL
        driver.get("https://www.konga.com/");
        //wait for the page to load in 5 seconds
        Thread.sleep (5000);
        //Maximize the browser
        driver.manage().window().fullscreen();
        //Get Page title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
        public void loginTest() throws InterruptedException {
        //Click on LoginSignUpButton
        driver.findElements(By.xpath("//a[@class='_7ad32_SD12Y _16536_xxIKG']")).get(3).click();
        Thread.sleep(5000);
        //Click on the email address field and input a valid email address "divaregina73@gmail.com"
        driver.findElement(By.id("username")).sendKeys("divaregina73@gmail.com");
        //Click on the password field and input a valid password "GFz7H9=X"
        driver.findElement(By.id("password")).sendKeys("GFz7H9=X");
        //Click on the login button
        driver.findElement(By.xpath("//button[@class='_0a08a_3czMG _988cf_1aDdJ']")).click();
        Thread.sleep(5000);
        if(driver.getCurrentUrl().contains("https://www.konga.com/")){
            System.out.println("PASSED - User has successfully logged in");
        }else{
            System.out.println("FAILED - User was unable to login");
        }
        Thread.sleep(5000);
    }

    @Test
        public void subcategoryTest() throws InterruptedException {
        int categorynumber = 1;
        Actions executeAction = new Actions(driver);
        WebElement selectedCategory = driver.findElements(By.className("ef511_2c5_i")).get(categorynumber);
        //Mouse hover on the selected category
        executeAction.moveToElement(selectedCategory).perform();
        Thread.sleep(7000);

        //Wait for the element to appear before clicking on the selected subcategory
        //wait.until(ExpectedConditions.visibilityOfElementLocated(subcategory));
        //Click on the MacBook
        driver.findElement(By.xpath(".//a[contains(text(),'Macbooks')]")).click();
        Thread.sleep(20000);
    }



    @Test
        public void addtocartTest() throws InterruptedException {
        By AddToCart = By.cssSelector("#mainContent > section._8d917_1ixfS > section > section > section > section > ul > li:nth-child(3) > div > div > div._4941f_1HCZm > form > div._2aac2_3bwnD._549f7_zvZ8u._49c0c_3Cv2D > button");
        By MyCartButton = By.cssSelector("#app-content-wrapper > div.e5dc4_DR8xw > nav > div._2d4bb_2rbWX > div > div > a._79484_1sLEt._7ad32_SD12Y._16536_xxIKG");
        By CheckOutButton = By.cssSelector("#app-content-wrapper > div.c6dfe_HidJc > section > section > aside > div.fb90d_2mSyi > div > div._2aac2_3bwnD._841f1_1RZK9 > button");

        //Click the first Add to cart button
        driver.findElement(AddToCart).click();
        Thread.sleep(5000);
        //Click My Cart Button
        driver.findElement(MyCartButton).click();
        Thread.sleep(5000);
        //Click on check out button
        driver.findElement(CheckOutButton).click();
        Thread.sleep(5000);
    }


    @Test
        public void paymentTest() throws InterruptedException {
        //Click on select pickup location
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/form/div/div/section[1]/div[2]/div/div[1]/div/div[2]/form/div/div/a")).click();
        Thread.sleep(5000);
        //Click on select this pickup location
        driver.findElement(By.xpath("//button[@name='selectPickupLocation']")).click();
        Thread.sleep(5000);
        //Click on Use this address
        driver.findElement(By.xpath("//a[contains(text(),'Use this Address')]")).click();
        Thread.sleep(5000);
        //Click on Paynow button
        driver.findElement(By.xpath("//button[@name='selectPaymentMethod']")).click();
        Thread.sleep(5000);
        //Click on Continue on Payment and select Card
        driver.findElement(By.xpath("//button[@name='placeOrder']")).click();
        Thread.sleep(5000);
        WebElement checkoutframe = driver.findElement(By.id("kpg-frame-component"));
        driver.switchTo().frame(checkoutframe);
        driver.findElement(By.cssSelector(".Card")).click();
        //Click on the Card Number and add an invalid card number "4421766260026264"
        driver.findElement(By.id("card-number")).sendKeys("4421766260026264");
        //Click on date and add an invalid card date "06/06"
        driver.findElement(By.id("expiry")).sendKeys("05/26");
        //Click on cvv and add an invalid cvv "324
        driver.findElement(By.id("cvv")).sendKeys("284");
        Thread.sleep(5000);
        //Click on the Pay Now button
        driver.findElement(By.id("validateCardForm")).click();
        Thread.sleep(20000);
        //Print out the error message for the card number field.
        System.out.println(driver.findElement(By.id("error-message")));
        driver.findElement(By.xpath("//aside[@onclick='UIHelper.returnToMerchantPage()']"));
        Thread.sleep(5000);
        }


    @AfterTest
        public void tearDown(){
        driver.quit ();
    }

}
