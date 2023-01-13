package page_locators.Setting.Gift_exchange.category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class categoryPage {

    WebDriver driver;

    @FindBy(css = "a[href='/config/gift/category']")
    public WebElement nvgCategory;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement txtCate;

    @FindBy(xpath = "//div[@class='buttons is-right']//a[@class='button is-link']")
    private WebElement btnSave;

    public categoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void CreateCate(String cate) {
        try {
            txtCate.sendKeys(cate);
            Thread.sleep(500);
            btnSave.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
