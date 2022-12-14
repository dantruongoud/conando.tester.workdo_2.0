package page_locators.Setting.StructurePage;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Từ khóa: email, tên...']")
    private WebElement search_input;

    @FindBy(xpath = "//span[contains(text(),'Tìm kiếm')]")
    private WebElement search_btn;

    @FindBy(className = "user_item")
    private WebElement chose_user;

    @FindBy(xpath = "//body[1]/main[1]/section[1]/section[1]/div[2]/div[1]/form[1]/ul[1]/li[3]/div[1]/div[1]/input[1]")
    private WebElement lastname_input;

    @FindBy(xpath = "//body[1]/main[1]/section[1]/section[1]/div[2]/div[1]/form[1]/ul[1]/li[4]/div[1]/div[1]/input[1]")
    private WebElement firstname_input;

    @FindBy(xpath = "//span[contains(text(),'Cập nhật')]")
    private WebElement save_btn;

    public EditUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Hàm check input disable
    public boolean isElementEnable(WebDriver driver, String locator) {
        try {
            WebElement usernametxt;
            usernametxt = driver.findElement(By.xpath(locator));
            return usernametxt.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Hàm check input username
    public void check_usernameDisable() {
        String username_input = "//input[@type='email']";
        if (isElementEnable(driver, username_input)) {
            System.out.println("FAILED: INPUT IS ENABLE...");
        } else {
            System.out.println("PASSED: INPUT IS DISABLE");
        }
    }

    public void enterSearch(String email) {
        try {
            if (search_input.isDisplayed()) {
                search_input.sendKeys(email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_search() {
        try {
            if (search_btn.isDisplayed()) {
                search_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_choseUser() {
        try {
            if (chose_user.isDisplayed()) {
                chose_user.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cleartxt() {
        lastname_input.clear();
        firstname_input.clear();
    }

    public void editUser(String lastname, String firstname) {
        lastname_input.sendKeys(lastname);
        firstname_input.sendKeys(firstname);
        save_btn.click();
    }

    public void print() {
        System.out.println("Status: PASSED");
        System.out.println("=========================");
        cleartxt();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean verifyTitle() {
        String a = "Thông tin tài khoản";
        return getTitle().equals(a);
    }
}
