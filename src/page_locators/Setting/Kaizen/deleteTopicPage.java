package page_locators.Setting.Kaizen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class deleteTopicPage {
     WebDriver driver;

    @FindBy(xpath = "//tbody/tr[1]/td[3]/div[1]/a[2]/i[1]")
    private WebElement tbody;

    public deleteTopicPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checklist() {
        try {
            if (tbody.isDisplayed()) {
                tbody.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
