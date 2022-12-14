package page_locators.Setting.Gift_exchange.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@href='config/gift']")
    private WebElement naviga;

    @FindBy(css = "a[class='button is-link']")
    private WebElement create_btn;

    @FindBy(xpath = "//html/body/main/section/div/div[2]/form/ul/li[1]/div/div/input")
    private WebElement nameProduct_input;

    @FindBy(xpath = "//body[1]/main[1]/section[1]/div[1]/div[2]/form[1]/ul[1]/li[4]/div[1]/div[1]/input[1]")
    private WebElement starNumber_input;

    @FindBy(xpath = "//span[contains(text(),'Cập nhật')]")
    private WebElement save_btn;

    @FindBy(xpath = "//html/body/main/section/section/div[2]/div/table/tbody/tr[1]/td[2]/div/a")
    private WebElement text;

    public WebDriver getDriver() {
        return this.driver;
    }

    public CreateProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyText() {
        String name = text.getText().strip();
        return name.equals("name");
    }

    public void createProduct(String name, String number) {
        nameProduct_input.sendKeys(name);
        starNumber_input.sendKeys(number);
        save_btn.click();
    }

    public void print() {
        System.out.println("PASSED");
        System.out.println("=========================");
        clear();
    }

    public void clear() {
        starNumber_input.clear();
        nameProduct_input.clear();
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

    public void navigation_exchange() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
