package page_locators;

import java.util.List;

import java.awt.Robot;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class SignInPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Nhập email...']")
    @CacheLookup
    private WebElement username_input;

    @FindBy(xpath = "//input[@placeholder='Nhập password...']")
    @CacheLookup
    private WebElement password_input;

    @FindBy(xpath = "//span[contains(text(),'Đăng nhập')]")
    @CacheLookup
    private WebElement login_btn;

    @FindBy(how = How.ID, using = "notify")
    private List<WebElement> tagline;

    @FindBy(xpath = "//span[contains(text(),'Cấu hình')]")
    @CacheLookup
    private WebElement naviga;

    @FindBy(css = "a[class='button is-link']")
    private WebElement saveBtn;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean verifyTitle(String nameTitle) {
        try {
            return getTitle().equals(nameTitle);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean SignIn(String email, String password) {
        try {
            username_input.sendKeys(email);
            password_input.sendKeys(password);
            login_btn.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println("Timeout waiting for Page Load Request to complete.");
        }
    }

    public void login() {
        try {
            Thread.sleep(2000);
            username_input.sendKeys("ndtruong.conando@gmail.com");
            Thread.sleep(1000);
            password_input.sendKeys("dantruong2410");
            Thread.sleep(1000);
            login_btn.click();
            waitForPageLoaded();
            chose_company();
            waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String messgaeError_tagline() {
        try {
            String validation = "";
            if (tagline.size() > 0) {
                validation = tagline.get(0).getText().strip();
                System.out.println("Notify: " + validation);
            }
            return validation;
        } catch (Exception e) {
            e.printStackTrace();
            return "Tagline is not Display...";
        }
    }

    public void chose_company() {
        try {
            List<WebElement> companyList = driver.findElements(By.className("has-text-weight-bold"));
            for (WebElement row : companyList) {
                String company_name = row.getText().strip();
                System.out.println(company_name);
                if (company_name.equals("Công Ty Demo")) {
                    row.click();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cleartxt() {
        try {
            username_input.clear();
            password_input.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String displayedlogout() {
        WebElement logout = driver.findElement(By.tagName("h1"));
        return logout.getText().strip();
    }

    public void error_titlePage() {
        System.out.println("Status: FAILED");
        System.out.println("Sai tiêu đề trang hiển thị...");
        System.out.println("=========================");
        driver.close();
    }

    public void navigation() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uploadImage(String upfile_btn, String typeFind) {
        try {
            WebElement upBtn;
            if (typeFind == "id") {
                upBtn = driver.findElement(By.id(upfile_btn));
            } else if (typeFind == "class") {
                upBtn = driver.findElement(By.className(upfile_btn));
            } else {
                upBtn = driver.findElement(By.xpath(upfile_btn));
            }
            String filePath = "C:\\Users\\Admin\\Downloads\\test3.jpg";

            // Click để mở form upload
            upBtn.click();
            Thread.sleep(3000);

            // Khởi tạo Robot class
            Robot rb = null;
            try {
                rb = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }

            // Copy File path vào Clipboard
            StringSelection str = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

            Thread.sleep(2000);

            // Nhấn Control+V để dán
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);

            Thread.sleep(2000);

            // Nhấn Enter
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);

            rb.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Button_Component() {
        try {
            if (saveBtn.isDisplayed()) {
                saveBtn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void failed() {
        System.out.println("Status: FAILED");
        System.out.println("======================");
    }

    public void passed() {
        System.out.println("Status: PASSED");
        System.out.println("======================");
    }

    public void tagline_isDisplayed() {
        System.out.println("Status: FAILED");
        System.out.println("Tagline is not Displayed");
        System.out.println("======================");
    }

}
