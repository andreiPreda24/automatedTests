import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class base {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
        addItems(driver, itemsNeeded);
        base b = new base();
        b.addItems(driver, itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
        System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());
        driver.quit();

    }


    public static void addItems(WebDriver driver, String[] itemsNeeded) {

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int j = 0;

        for (int i= 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String formatedName = name[0].trim();

            List itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formatedName)) {
                j++;
                //Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }

}
