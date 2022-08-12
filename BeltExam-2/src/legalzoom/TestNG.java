/**
 * @author Mawaddah Hanbali
 */
package legalzoom;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG {
	public WebDriver driver;

	/**
	 * Set up browser settings and open the application
	 */

	@BeforeSuite
	public void setUp() {
		// the path for open WebSite
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lo0ol\\" + "Downloads\\Compressed\\chromedriver_win32_2\\chromedriver.exe");
		driver = new ChromeDriver();

		// Navigate to a WebSite
		driver.navigate().to("https://www.legalzoom.com/");

		// Maximize current window
		driver.manage().window().maximize();
	}

	/**
	 * Test confirming the error message
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void LegalZoomWebSite() throws InterruptedException {
		Actions action = new Actions(driver);

		// to avoid loading status error
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// -------------------------- Home Page --------------------------------
		// personal menu
		WebElement personal = driver.findElement(By.linkText("Personal"));
		wait.until(ExpectedConditions.visibilityOf(personal));
		personal.click();
		Thread.sleep(5000);

		// living Trust text
		WebElement livingTrust = driver.findElement(By.partialLinkText("Living trust"));
		wait.until(ExpectedConditions.visibilityOf(livingTrust));

		if (livingTrust.isDisplayed()) {
			livingTrust.click();
		}
		Thread.sleep(5000);

		// ---------------------------------Living trust Page-----------------------
		// Start my living trust Button
		WebElement start = driver.findElement(By.xpath(
				"//p//child::a[@data-ga-label='hero_start_button' and contains(@class,'btn btn-action btn-lg ')]"));
		wait.until(ExpectedConditions.visibilityOf(start));
		start.click();
		Thread.sleep(5000);

		// -------------------------- Pricing Page -------------------------------
		WebElement basicPlan = driver.findElement(By.xpath("//div[contains(text(),'$279')]//preceding-sibling::a"));
		wait.until(ExpectedConditions.visibilityOf(basicPlan));
		basicPlan.sendKeys(Keys.DOWN); // scroll down to the princing plan
		basicPlan.click(); // click on Basic Plan it
		Thread.sleep(5000);

		// ------------------- Personal Info Page -----------------------------
		// ------------- Section: What to expect in this questionnaire.
		// "save and continue" button
		WebElement saveAndContinue1 = driver
				.findElement(By.xpath("//div[@class='float-left']//ancestor-or-self::input"));
		wait.until(ExpectedConditions.visibilityOf(saveAndContinue1));
		Thread.sleep(5000);

		// Actions class with moveToElement() and click()
		action.moveToElement(saveAndContinue1).build().perform();
		action.click(saveAndContinue1).build().perform();
		Thread.sleep(5000);

		// ------------- Section: Who is making this trust?
		// checkbox
		WebElement checkBox = driver
				.findElement(By.xpath("//input[@id='chkctlgrantor_cograntor_CB' and @type='checkbox']"));
		wait.until(ExpectedConditions.visibilityOf(checkBox));
		checkBox.click();
		Thread.sleep(5000);

		// "save and continue" button
		WebElement saveAndContinue2 = driver.findElement(By.xpath("//input[@alt='Continue']//self::input"));
		saveAndContinue2.click();
		Thread.sleep(5000);

		// ------------- Section: Tell us about yourself.
		// first name
		WebElement firstNameU = driver
				.findElement(By.xpath("//input[@id='grantor_first' or @class='textbox required']"));
		wait.until(ExpectedConditions.visibilityOf(firstNameU));
		firstNameU.sendKeys("Mawaddah");
		firstNameU.sendKeys(Keys.RETURN);
		Thread.sleep(5000);

		// middle name
		WebElement middleNameU = driver.findElement(By.cssSelector("input#grantor_middle[name*='grantor_middle']"));
		middleNameU.sendKeys("Sabaa");
		middleNameU.sendKeys(Keys.RETURN);
		Thread.sleep(5000);

		// select firstName
		action.moveToElement(firstNameU).click().build().perform();
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform(); // select
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform(); // copy
		Thread.sleep(5000);

		WebElement middleNameU1 = driver.findElement(By.xpath("//table//following::input[@id='grantor_middle']"));
		action.moveToElement(middleNameU1).click().build().perform();
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform(); // paste
		Thread.sleep(5000);

		// last name
		WebElement lastNameU = driver.findElement(By.cssSelector("#grantor_last"));
		lastNameU.sendKeys("Hanbali");
		Thread.sleep(5000);

		// "are u married" list
		WebElement isMarriedU = driver.findElement(By.xpath("//select[@id='grantor_married_MC']//option[3]"));
		isMarriedU.click();
		Thread.sleep(5000);

		// "have a children" list
		WebElement haveChildrenU = driver
				.findElement(By.xpath("//option[@value='Yes|~|428853']//following-sibling::option"));
		haveChildrenU.click();
		Thread.sleep(5000);

		// "save and continue" button
		WebElement saveAndContinue3 = driver.findElement(By.cssSelector("input[name$='Continue2']"));
		saveAndContinue3.click();
		Thread.sleep(5000);

		// ------------- Section: Tell us about your Co-Grantor.
		// first name
		WebElement firstNameC = driver.findElement(By.id("co_first"));
		wait.until(ExpectedConditions.visibilityOf(firstNameC));
		firstNameC.sendKeys("Arwa");
		Thread.sleep(5000);

		// middle name
		WebElement middleNameC = driver.findElement(By.xpath("//input[@id='co_middle'][@type='text']"));
		middleNameC.sendKeys("Ahmad");
		Thread.sleep(5000);

		// last name
		WebElement lastNameC = driver.findElement(By.xpath("//input[@id='co_last'][@size='30']"));
		lastNameC.sendKeys("Komo");
		Thread.sleep(5000);

		// "are u married" list
		WebElement isMarriedC = driver
				.findElement(By.xpath("//parent::select[@id='cograntor_married_MC']//child::option[3]"));
		isMarriedC.click();
		Thread.sleep(5000);

		// "have a children" list
		WebElement haveChildrenC = driver.findElement(By.xpath("//option[@value='No|~|428911']"));
		haveChildrenC.click();
		Thread.sleep(5000);

		// "save and continue" button
		WebElement saveAndContinue4 = driver
				.findElement(By.xpath("//input[@alt='Continue' and contains(@type,'image')]"));
		saveAndContinue4.click();
		Thread.sleep(5000);

		// ------------- Section: Where do you live?
		// Street Address
		WebElement streetAddressU = driver.findElement(By.id("grantor_address"));
		wait.until(ExpectedConditions.visibilityOf(streetAddressU));
		streetAddressU.sendKeys("saudi arabia");
		Thread.sleep(5000);

		// City
		WebElement cityU = driver.findElement(By.cssSelector("input[id=grantor_city]"));
		cityU.sendKeys("Makkah");
		cityU.clear();
		Thread.sleep(5000);

		// "State" List
		WebElement stateU = driver.findElement(By.xpath("//option[contains(@value,'New York')]"));
		stateU.click();
		Thread.sleep(5000);

		// ZIP
		WebElement zipU = driver.findElement(By.xpath("//input[@id='grantor_zip' and @class='textbox ']"));
		zipU.sendKeys("123456");
		Thread.sleep(5000);

		// "save and continue" button
		WebElement saveAndContinue5 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		saveAndContinue5.click();
		Thread.sleep(5000);

		// ------------- Section: Where does your co-grantor live?
		// "State" List
		WebElement stateC = driver.findElement(By.xpath("//option[text()='California']"));
		stateC.click();
		Thread.sleep(5000);

		// "save and continue" button
		WebElement saveAndContinue6 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		saveAndContinue6.click();
		Thread.sleep(5000);

		// ------Section: Which state's laws do you want to govern the trust?
		// laws
		WebElement laws = driver.findElement(By.xpath("//option[starts-with(@value,'My ')]"));
		laws.click();
		Thread.sleep(5000);

		// "save and continue" button
		WebElement saveAndContinue7 = driver
				.findElement(By.xpath("//input[@alt='Continue' or @onclick='pushEpOutboundSaleInfo();']"));
		saveAndContinue7.click();
		Thread.sleep(5000);

		// -------------- Property Page ------------------------
		// ---- Section: Overview of how property is placed in a trust.
		// "save and continue" button
		WebElement saveAndContinue8 = driver.findElement(By.cssSelector("input[alt='Continue'][type='image']"));
		wait.until(ExpectedConditions.visibilityOf(saveAndContinue8));
		saveAndContinue8.click();
		Thread.sleep(5000);

		// ---- Section: What types of property will be put into trust?
		WebElement checkbox1 = driver.findElement(By.name("chkctlproperty_realestate_CB"));
		checkbox1.click();
		Thread.sleep(5000);

		WebElement checkbox2 = driver
				.findElement(By.xpath("//input[@name='chkctlproperty_realestate_CB']//following::input[4]"));
		checkbox2.click();
		Thread.sleep(5000);

		// "save and continue" button
		WebElement saveAndContinue9 = driver.findElement(By.cssSelector("div > input[alt='Continue']"));
		saveAndContinue9.click();
		Thread.sleep(5000);

		// ------------- Section: Real estate details.
		// "save and continue" button
		WebElement saveAndContinue10 = driver
				.findElement(By.xpath("//input[@alt='Continue' and @src='/img/buttonContinueFat.gif']"));
		saveAndContinue10.click();
		Thread.sleep(5000);

		// ------------- Section: Stock and bond details.
		// "save and continue" button
		WebElement saveAndContinue11 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		wait.until(ExpectedConditions.visibilityOf(saveAndContinue11));
		saveAndContinue11.click();
		Thread.sleep(5000);
		// ---------------------------- Gifts Page --------------------
		// ------------- Section: Overview of how gifts are handled in a trust.
		// "save and continue" button
		WebElement saveAndContinue12 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		wait.until(ExpectedConditions.visibilityOf(saveAndContinue12));
		saveAndContinue12.sendKeys(Keys.DOWN); // scroll down to the princing plan
		saveAndContinue12.click();
		Thread.sleep(5000);

		// Section: What should happen to the property placed in the trust when the
		// first co-grantor passes away?
		// checkbox
		WebElement checkbox3 = driver.findElement(By.name("chkctlother_heirs_cograntor_CB"));
		wait.until(ExpectedConditions.visibilityOf(checkbox3));
		checkbox3.click();
		Thread.sleep(5000);

		// "save and continue" button
		WebElement saveAndContinue13 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		saveAndContinue13.sendKeys(Keys.DOWN);
		saveAndContinue13.click();
		Thread.sleep(5000);

		// ------------- Section: Who will receive your portion of the trust property?
		// percentage textfield
		WebElement percentage = driver
				.findElement(By.xpath("//input[@class='textbox required decimalNumber percentFormat formatInput']"));
		wait.until(ExpectedConditions.visibilityOf(percentage));
		percentage.sendKeys("100%");
		Thread.sleep(5000);

		// full Name textfield
		WebElement fullName = driver.findElement(By.xpath("//input[@class='textbox required'][@type='text']"));
		fullName.sendKeys("Mawaddah Hanbali");
		Thread.sleep(5000);

		// "save and continue" button
		WebElement saveAndContinue15 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		saveAndContinue15.sendKeys(Keys.DOWN);
		saveAndContinue15.click();
		Thread.sleep(5000);

		// ------------- Section: Who will receive your co-grantor's portion of the
		// trust property?
		// percentage textfield
		WebElement percentageC = driver
				.findElement(By.xpath("//input[@class='textbox required decimalNumber percentFormat formatInput']"));
		wait.until(ExpectedConditions.visibilityOf(percentageC));
		percentageC.sendKeys("100%");
		Thread.sleep(5000);

		// percentage textfield
		WebElement fullNameC = driver.findElement(By.xpath("//input[@class='textbox required'][@type='text']"));
		fullNameC.sendKeys("Arwa Komo");
		Thread.sleep(5000);

		// "save and continue" button
		WebElement saveAndContinue16 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		saveAndContinue16.click();
		Thread.sleep(5000);

		// ------------- Section: Do you want to give any specific and charitable gifts?
		WebElement saveAndContinue17 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		wait.until(ExpectedConditions.visibilityOf(saveAndContinue17));
		saveAndContinue17.click();
		Thread.sleep(5000);

		// ------------- Section: Do you want any gifts held in a subtrust?
		WebElement saveAndContinue18 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		wait.until(ExpectedConditions.visibilityOf(saveAndContinue18));
		saveAndContinue18.click();
		Thread.sleep(5000);

		// ------------- Section: Do you want a pour-over will?
		WebElement saveAndContinue19 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		wait.until(ExpectedConditions.visibilityOf(saveAndContinue19));
		saveAndContinue19.click();
		Thread.sleep(5000);

		// --------------- Representatives Page -----------------
		// -------- Section: Overview of representatives named in trust documents.
		WebElement saveAndContinue20 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		wait.until(ExpectedConditions.visibilityOf(saveAndContinue20));
		saveAndContinue20.click();
		Thread.sleep(5000);

		// ------------- Section: Who are the successor trustees?
		// First Choice
		WebElement firstChoice = driver
				.findElement(By.xpath("//input[@class='textbox required' and @id='first_successor_trustee']"));
		wait.until(ExpectedConditions.visibilityOf(firstChoice));
		firstChoice.sendKeys("Mawaddah");
		Thread.sleep(5000);

		WebElement saveAndContinue21 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		wait.until(ExpectedConditions.visibilityOf(saveAndContinue21));
		saveAndContinue21.click();
		Thread.sleep(5000);

		// ---- Section: Do you want the successor trustee to act as the executor?
		WebElement saveAndContinue22 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		wait.until(ExpectedConditions.visibilityOf(saveAndContinue22));
		saveAndContinue22.click();
		Thread.sleep(5000);

		// --------------- Additional Options Page -----------------
		// ------------- Section: Do you want to include optional provisions?
		WebElement saveAndContinue23 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		wait.until(ExpectedConditions.visibilityOf(saveAndContinue23));
		saveAndContinue23.click();
		Thread.sleep(5000);

		// ------------- Section: Would you like to name the trust?
		WebElement saveAndContinue24 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		wait.until(ExpectedConditions.visibilityOf(saveAndContinue24));
		saveAndContinue24.click();
		Thread.sleep(5000);

		// ------------- Section: Other estate planning options.
		WebElement saveAndContinue25 = driver.findElement(By.cssSelector("input[alt='Continue']"));
		wait.until(ExpectedConditions.visibilityOf(saveAndContinue25));
		saveAndContinue25.click();
		Thread.sleep(5000);

		// --------------- Congratulations Page ------------------------
		WebElement saveAndContinue26 = driver.findElement(By.xpath("//input[@id='ibTestContinueBottom']"));
		wait.until(ExpectedConditions.visibilityOf(saveAndContinue26));
		saveAndContinue26.click();
		Thread.sleep(5000);

		// --------------- Choose your package Page --------------------
		WebElement saveAndContinue27 = driver.findElement(By.xpath("//input[@value='Continue']"));
		wait.until(ExpectedConditions.visibilityOf(saveAndContinue27));
		saveAndContinue27.click();
		Thread.sleep(5000);

		// ----------- Secure Checkout Page ----------------
		WebElement next = driver.findElement(By.xpath("//a[@id='button-next']"));
		wait.until(ExpectedConditions.visibilityOf(next));
		next.click();
		Thread.sleep(5000);

		// ---------------- Complete your order Page -----------------
		// First name
		WebElement firstName = driver
				.findElement(By.xpath("//ul[@class='primary-contact-information']//li[1]//child::input[1]"));
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys("Mawaddah");
		Thread.sleep(5000);

		// Last name
		WebElement lastName = driver.findElement(By.xpath(
				"//li[@class='last-name primary-last-name']//following::input[@type='text' and @data-field-name='txt_ContactInfo_LName']"));
		lastName.sendKeys("Hanbali");
		Thread.sleep(5000);

		// Email
		WebElement email = driver
				.findElement(By.xpath("//label[starts-with(normalize-space(),'Email address')]//following::input[1]"));
		email.sendKeys("mawaddah@gmail.com");
		Thread.sleep(5000);

		// phoneNumber
		WebElement phoneNumber = driver
				.findElement(By.xpath("//li[@class='phone']//div[@class='error-text']//preceding::input[1]"));
		phoneNumber.sendKeys("12012987481");
		phoneNumber.clear();
		phoneNumber.sendKeys("12012987481");
		phoneNumber.sendKeys(Keys.RETURN);
		Thread.sleep(5000);

		// Address
		WebElement address = driver.findElement(By.xpath("//input[@type='text'][@tabindex='5']"));
		address.sendKeys("Makkah");
		Thread.sleep(5000);

		// Zip Code
		WebElement zipCode = driver.findElement(By.xpath("//input[@type='text' and @maxlength='10']"));
		zipCode.sendKeys("12343");
		Thread.sleep(5000);

		// City
		WebElement city = driver
				.findElement(By.xpath("//input[@type='text' and @maxlength='10']//following::input[1]"));
		city.sendKeys("Makkah");
		Thread.sleep(5000);

		// State
		WebElement state = driver
				.findElement(By.xpath("//option[text()='DC' or @value='29']//following::option[text()='FL']"));
		state.click();
		Thread.sleep(5000);

		// Country
		WebElement country = driver
				.findElement(By.xpath("//option[@value='188']//preceding-sibling::option[starts-with(@value,'187')]"));
		country.click();
		Thread.sleep(5000);

		// Payment First Name
		WebElement paymentFirstName = driver.findElement(By.xpath(
				"//ul[@class='payment-information-form']//following::input[@tabindex='26' and @data-field-name='txt_PaymentInfo_FName']"));
		Thread.sleep(5000);

		// Payment Last Name
		WebElement paymentLastName = driver
				.findElement(By.xpath("//input[@tabindex='26' and @data-field-name='txt_PaymentInfo_LName']"));
		Thread.sleep(5000);

		// copy and paste the first and last name from above textfield to this fields
		action.moveToElement(firstName).click().build().perform();
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform(); // select
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform(); // copy
		action.moveToElement(paymentFirstName).click().build().perform();
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform(); // paste
		Thread.sleep(5000);

		action.moveToElement(lastName).click().build().perform();
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform(); // select
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform(); // copy
		action.moveToElement(paymentLastName).click().build().perform();
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform(); // paste
		Thread.sleep(5000);

		// Card number
		WebElement cardNumber = driver.findElement(By.xpath("//div//input[@value='0']//following-sibling::input[1]"));
		cardNumber.sendKeys("12345678942314");
		Thread.sleep(5000);

		// Month
		WebElement month = driver.findElement(By.xpath("// option[contains(text(),'June')][@value='6']"));
		month.click();
		Thread.sleep(5000);

		// Year
		WebElement year = driver.findElement(By.cssSelector("option[value$='028']"));
		year.click();
		Thread.sleep(5000);

		// Billing zip code
		WebElement billingZipCode = driver
				.findElement(By.xpath("//span[text()='5 digit zip code']//preceding-sibling::input"));
		billingZipCode.sendKeys("12345");
		Thread.sleep(5000);

		// CVV
		WebElement cvv = driver.findElement(By.xpath("//li[@class='cvv']//input[1]"));
		cvv.sendKeys("777");
		Thread.sleep(5000);

		// checkbox4
		WebElement checkbox4 = driver.findElement(By.xpath("//p[@class='disclaimer epDisclaimerAccepted']"));
		wait.until(ExpectedConditions.visibilityOf(checkbox4));
		action.moveToElement(checkbox4).click().build().perform();
		Thread.sleep(5000);

		WebElement next1 = driver.findElement(By.xpath("//a[@class='button orange flex has-right checkout-submit']"));
		next1.click();

		WebElement error = driver.findElement(By.xpath("//span[text()='Invalid Credit Card Number']"));
		if (error.isDisplayed()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", error);
			String text = error.getText();
			Assert.assertEquals(text, "Invalid Credit Card Number");
			System.out.println("Finshied: Complete your order Page the text error is: " + text);
		}
		Thread.sleep(5000);
	}

	/**
	 * Tear down the setup after test completes
	 */
	@AfterTest
	public void terminateBrowser() {
		// Close the browser
		driver.quit();
	}

}
