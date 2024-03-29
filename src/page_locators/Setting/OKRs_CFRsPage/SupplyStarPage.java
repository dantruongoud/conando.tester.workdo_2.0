package page_locators.Setting.OKRs_CFRsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SupplyStarPage {

    WebDriver driver;

    @FindBy(css = "a[href='/config/okrs/stars/plus']")
    private WebElement supplyStar;

    @FindBy(css = "a[class='button is-link']")
    private WebElement create_btn;

    @FindBy(xpath = "//span[contains(text(),'Cập nhật')]")
    private WebElement save_btn;

    @FindBy(xpath = "//span[contains(text(),'Xác nhận')]")
    private WebElement confirm_btn;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private WebElement choseUser_btn;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement starNumber_input;

    @FindBy(xpath = "//div[@class='select']//select")
    private WebElement selectWallet;

    public SupplyStarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void naviga_supplyStar() {
        try {
            if (supplyStar.isDisplayed()) {
                supplyStar.click();
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

    public void click_confirm() {
        try {
            if (confirm_btn.isDisplayed()) {
                confirm_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_choseUser() {
        try {
            if (choseUser_btn.isDisplayed()) {
                choseUser_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void supply(String number) {
        starNumber_input.sendKeys(number);
        save_btn.click();
    }

    public void choseWallet() {
        try {
            Select choseWallet = new Select(selectWallet);
            choseWallet.selectByValue("2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
