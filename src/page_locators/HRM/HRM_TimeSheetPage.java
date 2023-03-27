package page_locators.HRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRM_TimeSheetPage {

    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='HRM']")
    private WebElement nav_HRM;

    @FindBy(xpath = "//a[@href='hrm/timesheets']")
    private WebElement nav_TimeSheet;

    public HRM_TimeSheetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
