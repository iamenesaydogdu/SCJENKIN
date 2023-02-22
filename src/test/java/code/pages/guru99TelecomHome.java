package code.pages;

import code.utils.BrowserUtils;
import code.utils.Driver;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class guru99TelecomHome extends BrowserUtils {
    public guru99TelecomHome() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static final Logger logger = Logger.getLogger(guru99TelecomHome.class);
    @FindBy(xpath = "(//a[.='Add Customer'])[1]")
    private WebElement addCustomerButton;
    @FindBy(xpath = "//h1[.='Add Customer']")
    private WebElement addCustomerHeader;
    @FindBy(xpath = "//input[@type='radio']")
    private List<WebElement> backgroundCheck;
    @FindBy(id = "fname")
    private WebElement firstName;
    @FindBy(id = "lname")
    private WebElement lastName;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement address;
    @FindBy(id = "telephoneno")
    private WebElement mobileNumber;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//h1[.='Access Details to Guru99 Telecom']")
    private WebElement verificationHeader;

    public void setAddCustomerButton() {

        addCustomerButton.click();
        //iframe var onu gidermek icin actions calss olursturduk
        Actions actions = new Actions(Driver.getDriver());
        actions.moveByOffset(0,0).click().build().perform(); // bu yol farmi kapatmiypor sayfayi gero aliyor oyle kapatiyor
    }

    public void setAddCustomerHeader(String addcustomerHeader) {
        Assert.assertEquals(addCustomerHeader.getText(), addcustomerHeader); // arkada yazicaz diger sayfada
    }

    public void setBackgroundCheck(String backgroundcheck) {

        for (WebElement each : backgroundCheck) {                       // id="pending" id="
            if (each.getAttribute("id").equals(backgroundcheck)) { // bu id sayfadaki eleemtnin id leri yani demo ve pendogning
                // each.click();
                JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver(); //inscerupter hatasi alinca bunu kullanican
                executor.executeScript("arguments[0].click();", each); // arguments[0].click();
                //Whenever we have ELEMENTNOTINTERACTABLE exception we can use javascrip executor to handle it.
                // in the above javasascript executor we just needto  provide element to it
                // Either actions class or Javascript executor they help us to execute javascript in the browser
            } else {

                logger.error("The option you have provided is not found. Please check your selection");
                logger.error(backgroundcheck + " is the provided option");
            }


        }
    }

    public void setFirstName(String firstname) {
        firstName.sendKeys(firstname);
    }

    public void setLastName(String lastname) {
        lastName.sendKeys(lastname);
    }

    public void setEmail(String emaill) {
        email.sendKeys(emaill);
    }

    public void setAddress(String Address) {
        address.sendKeys(Address);
    }

    public void setMobileNumber(String mobilenumber) {
        mobileNumber.sendKeys(mobilenumber);
    }

    public void setSubmitButton() {
        submitButton.click();
    }

    public WebElement getVerificationHeader() {

        return verificationHeader;
    }




}
