package setupbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import page_locators.SignInPage;

public class baseSetup {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    // Khởi tạo cấu hình của Browser
    public WebDriver initChromeDriver() {

        SignInPage index = new SignInPage(driver);
        ChromeOptions useragent = new ChromeOptions();

        // Disable notifications chrome
        useragent.addArguments("disable-notifications");
        useragent.addArguments("--remote-allow-origins=*");
        // useragent.addArguments("--headless=new");

        driver = new ChromeDriver(useragent);
        System.out.println("Launching Chrome browser...");
        driver.manage().window().maximize();

        driver.get("https://work.conando.vn/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

        index.waitForPageLoaded();
        return driver;
    }
}