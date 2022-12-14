package page_locators.OKRs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class deleteOKRsPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Xóa']")
    private WebElement delete_btn;

    public deleteOKRsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void click_delete() {
        try {
            if (delete_btn.isDisplayed()) {
                delete_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
