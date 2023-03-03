package page_locators.Todolist;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PendingTodoPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='dropdown is-hoverable']/div[@class='dropdown-trigger']/a[1]")
    private WebElement btnMenustatus;

    @FindBy(xpath = "//a[normalize-space()='Pending']")
    private WebElement btnPending;

    @FindBy(xpath = "//i[normalize-space()='chevron_right']")
    public WebElement btnNextday;

    @FindBy(xpath = "//span[contains(text(),'Thêm công việc')]")
    private WebElement btnAddWork;

    @FindBy(xpath = "//input[@class='input']")
    private WebElement txtWorks;

    @FindBy(xpath = "//span[contains(text(),'Cập nhật')]")
    private WebElement btnSave;

    @FindBy(xpath = "//a[@class='button is-link']//span[contains(text(),'Check-in')]")
    private WebElement btnCheckin;

    @FindBy(xpath = "//a[@class='button is-danger']")
    private WebElement btnCheckout;

    @FindBy(xpath = "//div[@class='field is-grouped is-grouped-right']//a[@class='button is-danger']")
    public WebElement btnCheckoutModal;

    @FindBy(css = ".modal-card-title")
    public WebElement titleModal;

    public PendingTodoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createTodo() {
        try {
            // btnNextday.click();
            Thread.sleep(1000);
            btnAddWork.click();
            Thread.sleep(Duration.ofSeconds(1));
            txtWorks.sendKeys("todo pending");
            chosePending();
            btnSave.click();
            Thread.sleep(1000);
            btnCheckin.click();
            Thread.sleep(1000);
            driver.switchTo().alert().accept();
            Thread.sleep(1000);
            btnCheckout.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chosePending() {
        try {
            btnMenustatus.click();
            Thread.sleep(1000);
            btnPending.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
