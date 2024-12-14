package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddEmployeeSteps
{
	String ExpectedEmpID="";
	String ActualEmpID ="";
	WebDriver driver;

	//press ctrl+Shift+O from krybaord to impoort all packages for below methods

	@Given("^User navigates url in a Browser$")
	public void user_navigates_url_in_a_Browser() throws Throwable 
	{
		//System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^User logs with username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_logs_with_username_as_and_password_as(String username, String password) throws Throwable
	{
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
	}


	@When("^User click Login buton$")
	public void user_click_Login_buton() throws Throwable
	{

		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

	}

	@When("^User CLick PIM button  and CLick Add button$")
	public void user_CLick_PIM_button_and_CLick_Add_button() throws Throwable 
	{
		driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();  //clcik add button
	}

	@When("^User Enter Firstname as \"([^\"]*)\"$")
	public void user_Enter_Firstname_as(String firstname) throws Throwable 
	{
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstname); //take value from FFile
	}

	@When("^User Enter Middlename as \"([^\"]*)\"$")
	public void user_Enter_Middlename_as(String middlename) throws Throwable 
	{
		driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys(middlename);
	}

	@When("^User Enter Lastname as \"([^\"]*)\"$")
	public void user_Enter_Lastname_as(String lastname) throws Throwable
	{
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastname);
	}

	@When("^user Capture Employee ID in runtime before Adding Save button$")
	public void user_Capture_Employee_ID_in_runtime_before_Adding_Save_button() throws Throwable
	{

		ExpectedEmpID= driver.findElement(By.xpath("//input[@id='employeeId']")).getAttribute("value"); //we have define type for Empid already
	}

	@When("^User CLick Save as button$")
	public void user_CLick_Save_as_button() throws Throwable
	{
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();	
	}

	@When("^User Capture Employee ID after Adding in personal info$")
	public void user_Capture_Employee_ID_after_Adding_in_personal_info() throws Throwable 
	{

		ActualEmpID= driver.findElement(By.xpath("//input[@id='personal_txtEmployeeId']")).getAttribute("value");
		
		
	}

	@Then("^User Validates with Employee ID$")
	public void user_Validates_with_Employee_ID() throws Throwable 
	{
		if( ExpectedEmpID.equals(ActualEmpID) )
		{

			System.out.println("Adding EMployee Sucess"  +ExpectedEmpID+ "  "+ActualEmpID);
		}

		else
		{
			System.out.println("Adding EMployee Fail"  +ExpectedEmpID+ "  " +ActualEmpID);

		}

	}


	@Then("^User Added Successfully can close browser$")
	public void user_Added_Successfully_can_close_browser() throws Throwable 
	{
		driver.quit();

	}
	


}
