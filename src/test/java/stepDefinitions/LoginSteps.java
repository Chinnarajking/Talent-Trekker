package stepDefinitions;

import java.util.concurrent.TimeUnit;

import Pages.LoginPage;
import Utility.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass {

//	public LoginSteps() {
//		super();
//		
//	}
		
	 LoginPage loginPage = new Pages.LoginPage(driver);
	
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        browserLaunch("http://qa.talent-trekker.com/#login");
    }
    
    @When("the user enters the valid username and password")
    public void the_user_enters_the_valid_username_and_password() {
        inputText(loginPage.getUserName(), "dharshini@riverstonetech.com");  
        inputText(loginPage.getPassword(), "Trekker2024!");
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        btnClick(loginPage.getLogin());
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    //	Thread.sleep(3000);
        assertTextEquals(loginPage.getAssertTaTr(), "Talent Trekker");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        getText(loginPage.getAssertTaTr());
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        assertTextEquals(loginPage.getAssertGenesis(), "Genesis");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        getText(loginPage.getAssertGenesis());
    }

    @Then("the user logs out of the portal")
    public void the_user_logs_out_of_the_portal() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	btnClick(loginPage.getClickProfile());
    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
     //   Thread.sleep(3000);
    	btnClick(loginPage.getClickLogout());
    }
}