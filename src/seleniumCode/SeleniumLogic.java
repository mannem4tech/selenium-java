package seleniumCode;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SeleniumLogic {

    public static void main(final String[] args) throws InterruptedException {
        // final ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("--whitelist-ip *");
        // chromeOptions.addArguments("--proxy-server='direct://'");
        // chromeOptions.addArguments("--proxy-bypass-list=*");
        final WebDriver driver = new ChromeDriver();
        final WebDriverWait wait = new WebDriverWait(driver, 2000);
        try {
            driver.get("https://google.com/ncr");
            driver.findElement(By.name("q")).sendKeys("protractortest" + Keys.ENTER);
            wait.until(presenceOfElementLocated(By.linkText("Protractor API")));
            driver.findElement(By.linkText("Protractor API")).click();
            wait.until(presenceOfElementLocated(By.cssSelector("#searchInput")));
            driver.findElement(By.cssSelector("#searchInput")).sendKeys("debugger" + Keys.ENTER);
            wait.until(presenceOfElementLocated(By.linkText("debugger")));
            driver.findElement(By.linkText("debugger")).click();
            wait.until(elementToBeClickable(By.cssSelector("pre[ptor-code='currentItem.example']")));
            WebElement firstResult = driver.findElement(By.cssSelector("pre[ptor-code='currentItem.example']"));
            System.out.println(firstResult.getAttribute("innerText"));
            driver.findElement(By.linkText("Protractor Tests")).click();
            wait.until(visibilityOfElementLocated(By.linkText("Tutorial")));
            driver.findElement(By.linkText("Tutorial")).click();
            Thread.sleep(2000);
        } finally {
            driver.quit();
        }
    }
}

