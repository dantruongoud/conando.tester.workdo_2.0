package page_locators.OKRs;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOKRsPage {

    String[] tagline = { "Nhập các mục tiêu của bạn !",
            "Nhập đầy đủ tiêu đề của các kết quả then chốt hoặc xóa kết quả then chốt không cần thiết !",
            "Nhập đầy đủ mục tiêu của các kết quả then chốt !" };

    public List<String> listNoti = Arrays.asList(tagline);
    
    private WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='OKRs']")
    private WebElement naviga_OKRs_btn;

    @FindBy(xpath = "//span[contains(text(),'Thiết lập')]")
    private WebElement naviga_create_btn;

    @FindBy(xpath = "//span[contains(text(),'Tạo OKRs')]")
    private WebElement naviga_CreatePage;

    @FindBy(css = "a[class='button']")
    private WebElement create_btn;

    @FindBy(xpath = "//input[@class='input has-text-weight-semibold is_bg']")
    private WebElement nameOKRs_input;

    @FindBy(css = "a[class='button is-link']")
    private WebElement save_btn;

    @FindBy(css = "div[class='control is-expanded'] input[placeholder='Bắt buộc nhập...']")
    private WebElement nameResult_input;

    @FindBy(css = "input[placeholder='Nhập giá trị']")
    private WebElement number_input;

    @FindBy(css = "input[placeholder='Đơn vị tính']")
    private WebElement unit_input;

    public CreateOKRsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click_navigation_OKRs() {
        try {
            if (naviga_OKRs_btn.isDisplayed()) {
                naviga_OKRs_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_navigation_CreateOKRs() {
        try {
            if (naviga_create_btn.isDisplayed()) {
                naviga_create_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_navigation_CreatePage() {
        try {
            if (naviga_CreatePage.isDisplayed()) {
                naviga_CreatePage.click();
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

    public void create_OKRs(String nameOKRs, String nameResult, String number, String unit) {
        nameOKRs_input.sendKeys(nameOKRs);
        nameResult_input.sendKeys(nameResult);
        number_input.sendKeys(number);
        unit_input.sendKeys(unit);
        save_btn.click();
    }

    public void cleartxt() {
        nameOKRs_input.clear();
        nameResult_input.clear();
        number_input.clear();
        unit_input.clear();
    }

    public void print() {
        System.out.println("Status: PASSED");
        System.out.println("======================");
        cleartxt();
    }

    public boolean verifyOKRs(String a) {
        try {
            String tdname = "";
            List<WebElement> trlist = driver.findElements(By.tagName("tr"));
            for (int i = 0; i < trlist.size(); i++) {
                List<WebElement> tdlist = trlist.get(i).findElements(By.tagName("td"));
                if (tdlist.size() == 5) {
                    WebElement td = tdlist.get(0);
                    tdname = td.getText().strip();
                    System.out.println(tdname);
                    break;
                }
            }
            return tdname.equals(a);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
