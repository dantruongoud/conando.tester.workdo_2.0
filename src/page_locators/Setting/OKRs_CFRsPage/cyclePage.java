package page_locators.Setting.OKRs_CFRsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cyclePage {
    private WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Thêm mới')]")
    private WebElement create_btn;

    private By cycleName_input = By.cssSelector("input[class='input']");

    private By start_input = By.xpath("/html/body/main/section/div/div[2]/form/div[3]/div[1]/div/div/input");

    private By end_input = By.xpath("/html/body/main/section/div/div[2]/form/div[3]/div[3]/div/div/input");

    private By save_btn = By.xpath("//span[contains(text(),'Cập nhật')]");

    private By naviga = By.cssSelector("a[href='config/okrs']");

    private By namecycle = By.xpath("//tbody/tr[1]/td[1]");

    public cyclePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getText() {
        WebElement namecycle_new = driver.findElement(namecycle);
        return namecycle_new.getText().strip();
    }

    public boolean verifycyclenew() {
        String a = "Cycle";
        return getText().equals(a);
    }

    public void navigation_OKRs_CFRs() {
        try {
            WebElement navigation = driver.findElement(naviga);
            if (navigation.isDisplayed()) {
                navigation.click();
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

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean verifytitle() {
        String a = "Cấu hình chu kỳ";
        return getTitle().equals(a);
    }

    public void enterCycleName(String cycleName) {
        try {
            WebElement cycleNametxt = driver.findElement(cycleName_input);
            if (cycleNametxt.isDisplayed()) {
                cycleNametxt.sendKeys(cycleName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterStart(String start) {
        try {
            WebElement startDaytxt = driver.findElement(start_input);
            if (startDaytxt.isDisplayed()) {
                startDaytxt.sendKeys(start);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterEnd(String end) {
        try {
            WebElement endDaytxt = driver.findElement(end_input);
            if (endDaytxt.isDisplayed()) {
                endDaytxt.sendKeys(end);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_save() {
        try {
            WebElement saveBtn = driver.findElement(save_btn);
            if (saveBtn.isDisplayed()) {
                saveBtn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create_cycle(String cycleName) {
        enterCycleName(cycleName);
        click_save();
    }

    public void print() {
        System.out.println("Status: PASSED");
        System.out.println("=========================");
        cleartxt();
    }

    public void cleartxt() {
        WebElement cycleNametxt = driver.findElement(cycleName_input);
        cycleNametxt.clear();
    }

}
