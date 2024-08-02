package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"login_email\"]")
	private WebElement userName;

	@FindBy(xpath = "//*[@id=\"login_password\"]")
	private WebElement password;

	@FindBy(xpath = "(//*[@id=\"page-login\"]//button[@type=\"submit\"])[1]")
	private WebElement login;

	@FindBy(xpath = "//*[@id=\"headlessui-menu-button-1\"]/button/div[1]/div[1]")
	private WebElement AssertTaTr;

	@FindBy(xpath = "//*[text()=\"Genesis\"]")
	private WebElement AssertGenesis;

	@FindBy(xpath = "(//*[@id=\"headlessui-menu-button-1\"]/button)[1]")
	private WebElement ClickProfile;
	
	@FindBy(xpath = "//*[text()=\"Log out\"]")
	private WebElement ClickLogout;

	
	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getAssertTaTr() {
		return AssertTaTr;
	}

	public WebElement getAssertGenesis() {
		return AssertGenesis;
	}

	public WebElement getClickProfile() {
		return ClickProfile;
	}
	
	public WebElement getClickLogout() {
		return ClickLogout;
	}
}