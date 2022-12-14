package page_locators.Setting.Gift_exchange.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class editProductPage {
    private WebDriver driver;

    private By nameProduct = By.linkText("name");

    public editProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyProduct() {
        try {
            WebElement nameLinktext = driver.findElement(nameProduct);
            return nameLinktext.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void clickNameProduct() {
        try {
            WebElement namelinkText = driver.findElement(nameProduct);
            if (namelinkText.isDisplayed()) {
                namelinkText.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
