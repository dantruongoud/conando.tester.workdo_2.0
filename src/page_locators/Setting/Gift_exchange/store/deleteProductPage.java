package page_locators.Setting.Gift_exchange.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class deleteProductPage {
    private WebDriver driver;

    private By delete_btn = By
            .xpath("//body[1]/main[1]/section[1]/section[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/a[2]");

    public deleteProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void click_delete() {
        try {
            WebElement deleteBtn = driver.findElement(delete_btn);
            if (deleteBtn.isDisplayed()) {
                deleteBtn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
