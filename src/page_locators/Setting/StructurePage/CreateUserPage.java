package page_locators.Setting.StructurePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUserPage {

    public String[] tagline = {
            "Bạn chưa nhập địa chỉ email, hoặc địa chỉ email không đúng!",
            "Bạn chưa nhập họ và tên cho tài khoản!",
            "Bạn chưa nhật mật khẩu cho tài khoản!"
    };
    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Nhân sự')]")
    private WebElement naviga;

    @FindBy(xpath = "//span[contains(text(),'Thêm mới')]")
    private WebElement create_btn;

    @FindBy(css = "input[placeholder='Email sẽ dùng để đăng nhập...']")
    private WebElement username_input;

    @FindBy(xpath = "//li[contains(@class,'column is-full')]//input[contains(@type,'text')]")
    private WebElement password_input;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement lastname_input;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    private WebElement firstname_input;

    @FindBy(xpath = "//span[contains(text(),'Thêm mới')]")
    private WebElement save_btn;

    public CreateUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigation_user() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_create() {
        try {
            if (create_btn.isDisplayed()) {
                create_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createUser(String email, String lastname, String firstname, String password) {
        username_input.sendKeys(email);
        lastname_input.sendKeys(lastname);
        firstname_input.sendKeys(firstname);
        password_input.sendKeys(password);
        save_btn.click();
    }

    public void clearDataTest() {
        username_input.clear();
        lastname_input.clear();
        firstname_input.clear();
        password_input.clear();
    }

    // public void print() {
    // System.out.println("Status: PASSED");
    // System.out.println("=========================");
    // }
}
