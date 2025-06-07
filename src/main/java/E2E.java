import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2E {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");


//        One way trip

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

//        From City

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@class='dropdownDiv']//a[@value='BLR']")).click();

//        To City

        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        driver.findElement(By.xpath("(//a[@value='MAA'])[1]")).click();

//        Depart Date

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

//        Select number of Passengers

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        for (int i = 1; i < 3; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        for (int i = 0; i < 2; i++) {
            driver.findElement(By.id("hrefIncChd")).click();
        }

        int i = 0;
        while(i < 1) {
            driver.findElement(By.id("hrefIncInf")).click();
            i++;
        }

        driver.findElement(By.id("btnclosepaxoption")).click();

//        Select Currency

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);

        dropdown.selectByIndex(1);
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("USD");
        System.out.println(dropdown.getFirstSelectedOption().getText());

//        Checkbox

        driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();

//        Submit Button

        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();


    }
}
