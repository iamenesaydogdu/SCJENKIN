package code.pages;

import code.utils.BrowserUtils;
import code.utils.Driver;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMHome extends  BrowserUtils{

        public OrangeHRMHome(){
            PageFactory.initElements(Driver.getDriver(),this);
        }

        //log4j yi kullanmaya basliyoruz 2
        private static final Logger logger = Logger.getLogger(OrangeHRMHome.class);



    @FindBy(xpath = "//h1[.='Dashboard']")
    private WebElement dashBoard;
    @FindBy(id = "menu_pim_viewPimModule")
    private WebElement PIM;
    @FindBy(id = "menu_pim_addEmployee")
    private WebElement addEmployee;
    @FindBy(id = "firstName")
    private WebElement firstName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "btnSave")
    private WebElement saveButton;
    @FindBy(xpath = "//h1[.='Personal Details']")
    private WebElement personalDetailsHeader;
    @FindBy(id = "chkLogin")
    private WebElement addLoginDetails;
    @FindBy(id = "user_name")
    private WebElement userName;

    @FindBy(id = "user_password")
    private WebElement password;
    @FindBy(id = "re_password")
    private WebElement confirmPassword;
    @FindBy(id = "status")
    private  WebElement statusDropdown;





    public void setDashBoard() {
        Assert.assertEquals("Dashboard",dashBoard.getText());
    }
    public void setDashBoard(String str) { // bu loaded olani dashboard
        Assert.assertEquals(str,dashBoard.getText());
    }

    public void setDashBoard(WebElement dashBoard) {
        this.dashBoard = dashBoard;
    }

    public void setPIM() {
        clickWithWait(PIM); // tiklayip beklicek
    }

    public void setAddEmployee( ) {
        clickWithWait(addEmployee);
    }

    public void setFirstName(String firstname) { // parametir yazdik seneryoda


        firstName.sendKeys(firstname);

        //logger step 3
        logger.info(firstname + " is successfullly entered");
    }

    public void setLastName(String lastname) { // parametir yazdik seneryoda

        lastName.sendKeys(lastname);

        //logger step 3
        logger.info(lastname + " is successfully entered");
    }

    public void setSaveButton( ) {

        clickWithWait(saveButton);
        logger.info(saveButton + " is successfully clicked");
    }

    public void setPersonalDetailsHeader(String expectedHeader) {
        staticWait(2);
       Assert.assertEquals(expectedHeader,personalDetailsHeader.getText());
        logger.info(expectedHeader + " is expected header and succesfully verified ");
    }

    public void setAddLoginDetails() {
       addLoginDetails.click();
       //yada clickWithWait(addLoginDetails)
        logger.info( "Add login details button was successfull clicked ");
    }

    public void setUserName(String username) {
        userName.sendKeys(username);
    }

    public void setPassword(String passWord) {
      password.sendKeys(passWord);
    }

    public void setConfirmPassword(String confirmpassword) {
        confirmPassword.sendKeys(confirmpassword);

    }

    public void setStatusDropdown(String statusdropdown) {
        selectFromDropDown(statusDropdown,statusdropdown);

    }









}
