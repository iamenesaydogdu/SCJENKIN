package code.pages;

import code.utils.BrowserUtils;
import code.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class guru99GatewayHome extends BrowserUtils { // eger browserutils degilde driver extends etsek bu sefer browsersden yararlanamayiz
    public guru99GatewayHome() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //We use private Webelements because this is where we apply encapculation
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buyNow;


    @FindBy(xpath = "//select[@name='quantity']")
    private WebElement quantityDropDown;

    public void getBuyNow() {
        buyNow.click();
    }

    public void getQuantityDropDown(String str) {
        Select select = new Select(quantityDropDown);
        select.selectByValue(str);

        //This is another way of selecting from dropdown. WE used method in our BrowserUtils class
        //  BrowserUtils.selectFromDropDown(quantityDropDown,str);

    }
}


