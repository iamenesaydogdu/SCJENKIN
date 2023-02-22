package code.stepsDefinitions;

import code.pages.OrangeHRMAdmin;
import code.pages.OrangeHRMHome;
import code.pages.OrangeHRMLogin;
import code.utils.BrowserUtils;
import code.utils.ConfigurationsReader;
import code.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

public class OrangeHRMSteps extends BrowserUtils {

   OrangeHRMLogin orangeHRMLogin = new OrangeHRMLogin();
   OrangeHRMHome orangeHRMHome = new OrangeHRMHome();

   OrangeHRMAdmin orangeHRMAdmin = new OrangeHRMAdmin() ;

    private static final Logger logger = Logger.getLogger(OrangeHRMSteps.class);


    @Given("The user wants to go to OrangeHRM Website")
    public void the_user_wants_to_go_to_orange_hrm_website() {
        System.out.println("Browser is launched and testing started");
        Driver.getDriver().get(ConfigurationsReader.getProperties("OrangeHRMTest")) ;
        waitForPageToLoad(4);


    }
    @When("The user wants to enter usurname and password")
    public void the_user_wants_to_enter_usurname_and_password() {
        orangeHRMLogin.setUserName(ConfigurationsReader.getProperties("userName"));
        orangeHRMLogin.setPassWord(ConfigurationsReader.getProperties("password"));
        logger.info( "Username and password provided succesfully");
    }
    @Then("The user wants to click on Login button")
    public void the_user_wants_to_click_on_login_button() {
        orangeHRMLogin.setLoginButton();

    }
    @Then("The user wants to verify that browser landed or Dashboard")
    public void the_user_wants_to_verify_that_browser_landed_or_dashboard() {
     orangeHRMHome.setDashBoard();
        System.out.println("Verification is success and test is ending for this step");

    }

    @Then("The user wants to verify that browser landed on {string}")
    public void the_user_wants_to_verify_that_browser_landed_on(String string) { // biz bunu seneryoda " Dashboard " olarak yazinca string geldi
        orangeHRMHome.setDashBoard(string);
    }
    @Then("The user wants to click on PIM Module")
    public void the_user_wants_to_click_on_pim_module() {

        orangeHRMHome.setPIM();
    }
    @Then("The user wants to go to Add Employee Page")
    public void the_user_wants_to_go_to_add_employee_page() {

        orangeHRMHome.setAddEmployee();
    }
    @Then("The user wants to add first name as {string}")
    public void the_user_wants_to_add_first_name_as(String string) {

        orangeHRMHome.setFirstName(string);
    }
    @Then("The user wants to add last name as {string}")
    public void the_user_wants_to_add_last_name_as(String string)
    {
        orangeHRMHome.setLastName(string);
    }
    @Then("The user wants to save personal information")
    public void the_user_wants_to_save_personal_information() {

        orangeHRMHome.setSaveButton();
    }
    @Then("The user should be able to see {string}")
    public void the_user_should_be_able_to_see(String string) {

        orangeHRMHome.setPersonalDetailsHeader(string);
    }
    @Then("The user wants to add employee's first and last name as following")
    public void the_user_wants_to_add_employee_s_first_and_last_name_as_following(Map<String,String> dataTable) {
      //io.cucumber.datatable.DataTable dataTable)
        orangeHRMHome.setFirstName(dataTable.get("Firstname")); // seneryo icinde key yazmam yeterli value dcagiriyor saten
        orangeHRMHome.setLastName(dataTable.get("Lastname"));

    }
    @Then("The user wants to add login details as following")
    public void the_user_wants_to_add_login_details_as_following(Map<String,String> dataTable) {
        //(io.cucumber.datatable.DataTable dataTable)
      orangeHRMHome.setAddLoginDetails();
      orangeHRMHome.setUserName(dataTable.get("UserName"));
      orangeHRMHome.setPassword(dataTable.get("Password"));
      orangeHRMHome.setConfirmPassword(dataTable.get("Password"));
      orangeHRMHome.setStatusDropdown(dataTable.get("Status"));
      logger.info("Username , Paassword and Status of account provided succesfully ");

    }
    //SELECT CLASS ile yapicaz

    @Then("The user wants to add employee's first and last name as Following list")
    public void the_user_wants_to_add_employee_s_first_and_last_name_as_following_list(List<List<String>> dataTable) {



      orangeHRMHome.setFirstName(dataTable.get(1).get(0)); // first row first collam
        orangeHRMHome.setLastName(dataTable.get(1).get(1)); // second collom // 2 yazrsak bsa 3 uncu row

    }
    @Then("The user wants to add Login in a list way")
    public void the_user_wants_to_add_login_in_a_list_way(List<List<String>> dataTable){
        orangeHRMHome.setAddLoginDetails();

        orangeHRMHome.setUserName(dataTable.get(0).get(0));
        orangeHRMHome.setPassword(dataTable.get(0).get(1));
        orangeHRMHome.setConfirmPassword(dataTable.get(0).get(1));
        orangeHRMHome.setStatusDropdown(dataTable.get(0).get(2)); // ilk sira ikinci sutun // disabled olan





    }
    @Then("The user wants to add login information {string} {string} {string}")
    public void the_user_wants_to_add_login_information(String username, String password, String status) {
        orangeHRMHome.setAddLoginDetails();
        logger.info("Add login details button os clicked succesfully");
        orangeHRMHome.setUserName(username);
        logger.info(username+"is provied as username ");
        orangeHRMHome.setPassword(password);
        logger.info(password+"is provied as password ");
        orangeHRMHome.setConfirmPassword(password);
        orangeHRMHome.setStatusDropdown(status);


    }
    @Then("The user wants to add employee's as {string} {string}")
    public void the_user_wants_to_add_employee_s_as(String firstName, String lastName) {
   orangeHRMHome.setFirstName(firstName);
   orangeHRMHome.setLastName(lastName);
    }
    @Then("The user wants to go to Admin Module")
    public void the_user_wants_to_go_to_admin_module() {
       orangeHRMAdmin.setAdminButton();
    }
    @Then("The user wants to go to Nationalities Section")
    public void the_user_wants_to_go_to_nationalities_section() {
      orangeHRMAdmin.setNationalitiesSection();
    }
    @Then("The user wants to click on add new nationality")
    public void the_user_wants_to_click_on_add_new_nationality() {
    orangeHRMAdmin.setAddButton();
    }
    @Then("The user wants to add new nationalities as {string}")
    public void the_user_wants_to_add_new_nationalities_as(String nationality) {
        orangeHRMAdmin.setNameOfNationalityBox(nationality);
        orangeHRMAdmin.setSaveButton();
        orangeHRMAdmin.setNationalitiesList(nationality);

    }



 /*
    @Given("The user wants to login OrangeHRM using Excel File")
    public void the_user_wants_to_login_orange_hrm_using_excel_file() throws IOException {
        Driver.getDriver().get(ConfigurationsReader.getProperties("OrangeHRMTest"));
        String filePath="C:\\Users\\oralr\\IdeaProjects\\RenastechLily\\04_CucumberBDD\\src\\test\\resources\\externalSheet.xlsx"; // icne attigimiz world path sag clcik yap copy paste yap buraya
        FileInputStream fileInputStream=new FileInputStream(filePath); // bunu tanimak icin yaz
        XSSFWorkbook workbook= new XSSFWorkbook(fileInputStream); // WE are opening the file
        XSSFSheet sheet=workbook.getSheet("Sheet1"); // WE are accessing to specific sheet

        System.out.println(sheet.getRow(0).getCell(0).toString());
        System.out.println(sheet.getRow(0).getCell(1).toString());
        System.out.println(sheet.getRow(1).getCell(0).toString());
        System.out.println(sheet.getRow(1).getCell(1).toString());

        int rows=sheet.getLastRowNum(); // this will tell us how many rows we have in the file
        int columns=sheet.getRow(0).getLastCellNum(); specific row icinde ne var dersek altta gtmek icin run yaptiktak sonra row 0 deik . ynindaki kod normal yazican he p

        System.out.println("Total Rows :"+rows+", Total columns:"+columns);

        String username=sheet.getRow(1).getCell(0).toString();
        String password=sheet.getRow(1).getCell(1).toString();
        //   orangeHRMLogin.setDatafromExcel(sheet.getRow(1).getCell(0).toString(),sheet.getRow(1).getCell(1).toString());
        orangeHRMLogin.setDatafromExcel(username,password);
        //We use excell as external file whenever we need a large set of data because we cannot keep large set of data in cucumber framework
    }
*/
}







