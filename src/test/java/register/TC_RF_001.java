package register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_001 {

    @Test
    public void verifyRegisteringAccountUsingMandatoryFields() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://tutorialsninja.com/demo");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("John");
        driver.findElement(By.id("input-lastname")).sendKeys("Martin");
        driver.findElement(By.id("input-email")).sendKeys(generateEmailAddress());
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item' and text()='Logout']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());

        String expectedSuccessHeading = "Your Account Has Been Created!";
        String expectedSuccessParaOne = "Congratulations! Your new account has been successfully created!";
        String expectedSuccessParaTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String expectedSuccessParaThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String expectedSuccessParaFour = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//*[text()='" + expectedSuccessHeading + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//*[text()='" + expectedSuccessParaOne + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//*[text()='" + expectedSuccessParaTwo + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//*[text()='" + expectedSuccessParaThree + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//*[text()='" + expectedSuccessParaFour + "']")).isDisplayed());

        driver.findElement(By.linkText("Continue")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

        driver.quit();
    }

    public String generateEmailAddress() {
        return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@gmail.com";
    }
}
