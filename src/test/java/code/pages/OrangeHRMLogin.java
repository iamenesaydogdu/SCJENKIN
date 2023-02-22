package code.pages;

import code.utils.BrowserUtils;
import code.utils.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLogin extends BrowserUtils {

    public OrangeHRMLogin(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    private static final Logger logger = Logger.getLogger(OrangeHRMLogin.class);


    @FindBy(id="txtUsername")
    private WebElement userName;

    @FindBy(id="txtPassword")
    private WebElement passWord;
    @FindBy(id="btnLogin")
    private WebElement loginButton ;

    public void setUserName(String username) {
        if(!username.isEmpty()){  // if its not empty anlmina gelir// if(username==null){
            //logger kullandik .. bunu cogalta biliriz bu bizi ek bilgi veriyor hizlica hatanin nerde oldugunu anlayabiliriz
            //bunu if kuillanarak iste password 7 karakterden olusur mu , username bos mu degil mi felan ...
            logger.error("username is empty . Please check balue you provided");
            logger.info("Please check of you provided username correctly");
        }
        staticWait(1);
    userName.sendKeys(username);
    }

    public void setPassWord(String password) {
        passWord.sendKeys(password);

    }

    public void setLoginButton( ) {
        loginButton.click();
    }

public void setDatafromExcel(String username , String password){
        userName.sendKeys(username);
        passWord.sendKeys(password);
        loginButton.click();
}

}
