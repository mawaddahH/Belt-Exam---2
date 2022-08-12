# Belt-Exam---2
Belt Exam 2 for Track 2 - SDA - Software QA Bootcamp


## Table of contents
* [Question](#question)
* [Test Result Report](#test-result-report)
* [Codes And Screenshot](#codes-and-screenshot)
* [Full Run](#full-run)

---
## Question
Create an Automation Suite using Selenium (using the TestNG Framework) for confirming the error message when a wrong credit card number is entered for living trust Application form in the legal zoom.


---
## Test Result Report

In this belt exam, I used [legalzoom](https://www.legalzoom.com/) the website to test if an error message for a card number can detect it or not when the user enters a wrong number.


> About [legalzoom](https://www.legalzoom.com/) website:  tech company to make legal help, offer expert tax advice and accounting solutions that include full-service prep and filing.


So the test scenario and test case for the error message were as follows:
- `Test Scenario` : Verify the error message function for the credit card number
- `Test case` : Check if the error message displayed `Invalid Credit Card Number` when the user enters the wrong credit card number.

I started the test from step zero `Open the browser` to the final step click on the `Agree & Place Order` button, here is the screenshot of the test case steps (workflow):

<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/184367087-675ba11e-3a34-4374-b34a-8e3c995e1127.jpg" width=60% height=60%>


</p>

And as you can see above the expected result it was successful as an actual result for all steps. as a final result, the state of the test case is PASS.

Then I started to do the automation suit test using `Selenium` and `TestingNG` by creating a TestNG class and using `@BeforeSuite`, `@Test` , and `@AfterTest` annotation. 
in this way, by following the step in the test case, the test also ends with a PASS result as seen below:

<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/184295914-4f28963e-f846-4c41-9fe9-9feb534d3e7f.png" width=60% height=60%>


</p>


---

## Codes And Screenshot
### First:
Setup Latest Web Driver for Chrome  Driver.
Donwload the necessary jar files:
- Selenium (Lastest).
- TestNG (Lastest).
- commander (Lastest).

### Second:
Add them as a library in the classpath of the project
- _click-reight on the file project >Build path > configure Bild path > Java Build Path > Libraries > classpath > add external JARs > Apply and close_.

### Third:
#### STEP 1: I used `Actions` class to do some actions and I used `WebDriverWait` class to avoid loading status error.

```md
ctions action = new Actions(driver);
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
```

#### STEP 2: Navigate to the "Personal" Menu and click on the "living Trust" text, in this code I used `linkText` , and `partialLinkText` locator

- personal menu
```md
WebElement personal = driver.findElement(By.linkText("Personal"));
wait.until(ExpectedConditions.visibilityOf(personal));
personal.click();
```

- living Trust text
```md
WebElement livingTrust = driver.findElement(By.partialLinkText("Living trust"));
wait.until(ExpectedConditions.visibilityOf(livingTrust));
if (livingTrust.isDisplayed()) {
livingTrust.click();
}
```


<p align="center">

https://user-images.githubusercontent.com/48597284/184271824-d5949732-10e4-4726-978f-0b1f59df52ed.mp4

</p>


---

#### STEP 3: Then I click on the "Start my living trust" button, Then I scroll down to the pricing plan and select the "Basic Living Trust" plan, in this code, I used the `child` Axes , and the `contains` function.

- "Start my living trust" Button
```md
WebElement start = driver.findElement(By.xpath("//p//child::a[@data-ga-label='hero_start_button' and contains(@class,'btn btn-action btn-lg ')]"));
wait.until(ExpectedConditions.visibilityOf(start));
start.click();
```

- Pricing plan
```md
WebElement basicPlan = driver.findElement(By.xpath("//div[contains(text(),'$279')]//preceding-sibling::a"));
wait.until(ExpectedConditions.visibilityOf(basicPlan));
basicPlan.sendKeys(Keys.DOWN); // scroll down to the princing plan
basicPlan.click(); // click on Basic Plan it
```


<p align="center">

https://user-images.githubusercontent.com/48597284/184273113-a8d66e9d-01bd-4131-bbd0-7466d1fdf277.mp4

</p>

---

#### STEP 4: For the "Personal Info" I started by clicking on the "save and continue" button by using the `Actions` class, Then I check on the checkbox button and then I click on the "save and continue" button.

In this code, I used `ancestor-or-self` Axes, and `and` operation.

- "save and continue" button , Actions class with moveToElement() and click()
```md
WebElement saveAndContinue1 = driver.findElement(By.xpath("//div[@class='float-left']//ancestor-or-self::input"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue1));
action.moveToElement(saveAndContinue1).build().perform();
action.click(saveAndContinue1).build().perform();
```

- checkbox
```md
WebElement checkBox = driver.findElement(By.xpath("//input[@id='chkctlgrantor_cograntor_CB' and @type='checkbox']"));
wait.until(ExpectedConditions.visibilityOf(checkBox));
checkBox.click();
```

- "save and continue" button
```md
WebElement saveAndContinue2 = driver.findElement(By.xpath("//input[@alt='Continue']//self::input"));
saveAndContinue2.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184275541-ca525d75-ee68-403e-be9c-aab0a27d762a.mp4

</p>


---

#### STEP 5: In this code, I filled up the required information in the "Tell us about yourself" form, in this code I used `or` operation, `*` and `#` and `$` for contains in CSSselector, `Keys.CONTROL` for copy and paste text, `[3]` order , and `following-sibling` Axes.

- first name
```md
WebElement firstNameU = driver.findElement(By.xpath("//input[@id='grantor_first' or @class='textbox required']"));
wait.until(ExpectedConditions.visibilityOf(firstNameU));
firstNameU.sendKeys("Mawaddah");
firstNameU.sendKeys(Keys.RETURN);
```

- middle name
```md
WebElement middleNameU = driver.findElement(By.cssSelector("input#grantor_middle[name*='grantor_middle']"));
middleNameU.sendKeys("Sabaa");
middleNameU.sendKeys(Keys.RETURN);
```


- select firstName cope & paste to middleNameU1
```md
action.moveToElement(firstNameU).click().build().perform();
action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform(); // select
action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform(); // copy


WebElement middleNameU1 = driver.findElement(By.xpath("//table//following::input[@id='grantor_middle']"));
action.moveToElement(middleNameU1).click().build().perform();
action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform(); // paste
```

- last name
```md
WebElement lastNameU = driver.findElement(By.cssSelector("#grantor_last"));
lastNameU.sendKeys("Hanbali");
```

- "are u married" list
```md
WebElement isMarriedU = driver.findElement(By.xpath("//select[@id='grantor_married_MC']//option[3]"));
isMarriedU.click();
```


- "have a children" list
```md
WebElement haveChildrenU = driver.findElement(By.xpath("//option[@value='Yes|~|428853']//following-sibling::option"));
haveChildrenU.click();
```

- "save and continue" button
```md
WebElement saveAndContinue3 = driver.findElement(By.cssSelector("input[name$='Continue2']"));
saveAndContinue3.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184276794-28b9a740-c660-4136-8d0d-cfd5746a8dea.mp4

</p>


---

#### STEP 6: In this code, I fill up the required information in the section "Tell us about your Co-Grantor" , and I used `id` locator, XPath combination , and `parent` Axes.


- first name
```md
WebElement firstNameC = driver.findElement(By.id("co_first"));
wait.until(ExpectedConditions.visibilityOf(firstNameC));
firstNameC.sendKeys("Arwa");
```

- middle name
```md
WebElement middleNameC = driver.findElement(By.xpath("//input[@id='co_middle'][@type='text']"));
middleNameC.sendKeys("Ahmad");
```

- last name
```md
WebElement lastNameC = driver.findElement(By.xpath("//input[@id='co_last'][@size='30']"));
lastNameC.sendKeys("Komo");
```

- "are ur co married" list
```md
WebElement isMarriedC = driver.findElement(By.xpath("//parent::select[@id='cograntor_married_MC']//child::option[3]"));
isMarriedC.click();
```

- "are ur co have a children" list
```md
WebElement haveChildrenC = driver.findElement(By.xpath("//option[@value='No|~|428911']"));
haveChildrenC.click();
```

- "save and continue" button
```md
WebElement saveAndContinue4 = driver.findElement(By.xpath("//input[@alt='Continue' and contains(@type,'image')]"));
saveAndContinue4.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184278332-b47d112a-b332-4975-93d3-3777f1693da9.mp4

</p>

---

#### STEP 7: In this code, I filled up the required information in sections "Where do you live?" and "Where does your co-grantor live?"

// ------------- Section: Where do you live?
- Street Address
```md
WebElement streetAddressU = driver.findElement(By.id("grantor_address"));
wait.until(ExpectedConditions.visibilityOf(streetAddressU));
streetAddressU.sendKeys("saudi arabia");
```

- City
```md
WebElement cityU = driver.findElement(By.cssSelector("input[id=grantor_city]"));
cityU.sendKeys("Makkah");
cityU.clear();
```

- "State" List
```md
WebElement stateU = driver.findElement(By.xpath("//option[contains(@value,'New York')]"));
stateU.click();
```

- ZIP
```md
WebElement zipU = driver.findElement(By.xpath("//input[@id='grantor_zip' and @class='textbox ']"));
zipU.sendKeys("123456");
```


- "save and continue" button
```md
WebElement saveAndContinue5 = driver.findElement(By.cssSelector("input[alt='Continue']"));
saveAndContinue5.click();
```

// ------------- Section: Where does your co-grantor live?
- "State" List
```md
WebElement stateC = driver.findElement(By.xpath("//option[text()='California']"));
stateC.click();
```

- "save and continue" button
```md
WebElement saveAndContinue6 = driver.findElement(By.cssSelector("input[alt='Continue']"));
saveAndContinue6.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184279127-f3fb810c-1bac-4e2a-a5c9-66634e544254.mp4

</p>

---

#### STEP 8: In this code, I filled up the required information in section "Which state's laws do you want to govern the trust?"

- laws
```md
WebElement laws = driver.findElement(By.xpath("//option[starts-with(@value,'My ')]"));
laws.click();
```

- "save and continue" button
```md
WebElement saveAndContinue7 = driver.findElement(By.xpath("//input[@alt='Continue' or @onclick='pushEpOutboundSaleInfo();']"));
saveAndContinue7.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184279743-c8d0599b-e492-400e-8444-0cd9f0bacbbe.mp4

</p>


---

#### STEP 9: In this code, I filled up the required information in Property Page for sections "Overview of how property is placed in a trust.", "What types of property will be put into trust?", "Real estate details.", and "Stock and bond details."., and I used cssSelector combination , `name` locatior , and `following` Axes


// ---- Section: Overview of how property is placed in a trust.
- "save and continue" button
```md
WebElement saveAndContinue8 = driver.findElement(By.cssSelector("input[alt='Continue'][type='image']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue8));
saveAndContinue8.click();
```

// ---- Section: What types of property will be put into trust?
```md
WebElement checkbox1 = driver.findElement(By.name("chkctlproperty_realestate_CB"));
checkbox1.click();
```

```md
WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='chkctlproperty_realestate_CB']//following::input[4]"));
checkbox2.click();
```

- "save and continue" button
```md
WebElement saveAndContinue9 = driver.findElement(By.cssSelector("div > input[alt='Continue']"));
saveAndContinue9.click();
```

// ------------- Section: Real estate details.
- "save and continue" button
```md
WebElement saveAndContinue10 = driver.findElement(By.xpath("//input[@alt='Continue' and @src='/img/buttonContinueFat.gif']"));
saveAndContinue10.click();
```


// ------------- Section: Stock and bond details.
- "save and continue" button
```md
WebElement saveAndContinue11 = driver.findElement(By.cssSelector("input[alt='Continue']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue11));
saveAndContinue11.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184284666-1107bb26-1e96-4273-9a68-7a9e6f8bd435.mp4

</p>

---

#### STEP 10: In this code, I filled up the required information in Gifts Page for sections and I used cssSelector combination , `name` locatior , and `following` Axes



// ------------- Section: Overview of how gifts are handled in a trust.
- "save and continue" button
```md
WebElement saveAndContinue12 = driver.findElement(By.cssSelector("input[alt='Continue']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue12));
saveAndContinue12.sendKeys(Keys.DOWN); // scroll down to the princing plan
saveAndContinue12.click();
```

// Section: What should happen to the property placed in the trust when the first co-grantor passes away?
- "checkbox" button
```md
WebElement checkbox3 = driver.findElement(By.name("chkctlother_heirs_cograntor_CB"));
wait.until(ExpectedConditions.visibilityOf(checkbox3));
checkbox3.click();
```

- "save and continue" button
```md
WebElement saveAndContinue13 = driver.findElement(By.cssSelector("input[alt='Continue']"));
saveAndContinue13.sendKeys(Keys.DOWN);
saveAndContinue13.click();
Thread.sleep(5000);
```

// ------------- Section: Who will receive your portion of the trust property?
- percentage textfield
```md
WebElement percentage = driver.findElement(By.xpath("//input[@class='textbox required decimalNumber percentFormat formatInput']"));
wait.until(ExpectedConditions.visibilityOf(percentage));
percentage.sendKeys("100%");
```

- full Name textfield
```md
WebElement fullName = driver.findElement(By.xpath("//input[@class='textbox required'][@type='text']"));
fullName.sendKeys("Mawaddah Hanbali");
```

- "save and continue" button
```md
WebElement saveAndContinue15 = driver.findElement(By.cssSelector("input[alt='Continue']"));
saveAndContinue15.sendKeys(Keys.DOWN);
saveAndContinue15.click();
```

// ------------- Section: Who will receive your co-grantor's portion of the trust property?
- percentage textfield
```md
WebElement percentageC = driver.findElement(By.xpath("//input[@class='textbox required decimalNumber percentFormat formatInput']"));
wait.until(ExpectedConditions.visibilityOf(percentageC));
percentageC.sendKeys("100%");
```

- fullNameC textfield
```md
WebElement fullNameC = driver.findElement(By.xpath("//input[@class='textbox required'][@type='text']"));
fullNameC.sendKeys("Arwa Komo");
```

- "save and continue" button
```md
WebElement saveAndContinue16 = driver.findElement(By.cssSelector("input[alt='Continue']"));
saveAndContinue16.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184285440-2f14cf1f-b552-46fc-b1a1-8b95676e508f.mp4

</p>

---

#### STEP 11: In this code, I just went through other forms that are not required to fill up



// -------------  Section: Do you want to give any specific and charitable gifts?
- "save and continue" button
```md
WebElement saveAndContinue17 = driver.findElement(By.cssSelector("input[alt='Continue']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue17));
saveAndContinue17.click();
```

// ------------- Section: Do you want any gifts held in a subtrust?
- "save and continue" button
```md
WebElement saveAndContinue18 = driver.findElement(By.cssSelector("input[alt='Continue']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue18));
saveAndContinue18.click();
```


// ------------- Section: Do you want a pour-over will?
- "save and continue" button
```md
WebElement saveAndContinue19 = driver.findElement(By.cssSelector("input[alt='Continue']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue19));
saveAndContinue19.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184286700-71bec53b-f77d-4036-8284-533cc77f1618.mp4

</p>

---

#### STEP 12:  In this code, I filled up the required information on the "Representatives" and "Additional Options" Pages


// --------------- Representatives Page -----------------

// ------------- Section: Overview of representatives named in trust documents.
- "save and continue" button
```md
WebElement saveAndContinue20 = driver.findElement(By.cssSelector("input[alt='Continue']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue20));
saveAndContinue20.click();
```


// ------------- Section: Who are the successor trustees?
- First Choice
```md
WebElement firstChoice = driver.findElement(By.xpath("//input[@class='textbox required' and @id='first_successor_trustee']"));
wait.until(ExpectedConditions.visibilityOf(firstChoice));
firstChoice.sendKeys("Mawaddah");
```

- "save and continue" button
```md
WebElement saveAndContinue21 = driver.findElement(By.cssSelector("input[alt='Continue']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue21));
saveAndContinue21.click();
```


// -------------  Section: Do you want the successor trustee to act as the executor?
- "save and continue" button
```md
WebElement saveAndContinue22 = driver.findElement(By.cssSelector("input[alt='Continue']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue22));
saveAndContinue22.click();
```

// --------------- Additional Options Page -----------------

// ------------- Section: Do you want to include optional provisions?
- "save and continue" button
```md
WebElement saveAndContinue23 = driver.findElement(By.cssSelector("input[alt='Continue']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue23));
saveAndContinue23.click();
```


// ------------- Section: Would you like to name the trust?
- "save and continue" button
```md
WebElement saveAndContinue24 = driver.findElement(By.cssSelector("input[alt='Continue']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue24));
saveAndContinue24.click();
```


// ------------- Section: Other estate planning options.
- "save and continue" button
```md
WebElement saveAndContinue25 = driver.findElement(By.cssSelector("input[alt='Continue']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue25));
saveAndContinue25.click();
```


<p align="center">

https://user-images.githubusercontent.com/48597284/184287324-88b7bda1-b38e-489d-9251-6b67fe14816c.mp4

</p>

---

#### STEP 13:  In this code, I Just went through all pages until I go to the "Complete your order" Page

- Congratulations Page
```md
WebElement saveAndContinue26 = driver.findElement(By.xpath("//input[@id='ibTestContinueBottom']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue26));
saveAndContinue26.click();
```

- Choose your package Page
- "save and continue" button
```md
WebElement saveAndContinue27 = driver.findElement(By.xpath("//input[@value='Continue']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue27));
saveAndContinue27.click();
```

-  Secure Checkout Page
```md
WebElement next = driver.findElement(By.xpath("//a[@id='button-next']"));
wait.until(ExpectedConditions.visibilityOf(next));
next.click();
```


<p align="center">

https://user-images.githubusercontent.com/48597284/184287717-6788f20f-4874-4eaf-85c0-618279f54c9e.mp4

</p>

---

#### STEP 14: In this code, I fill up all the required information, and for the card number, I entered the wrong number to detect the error message.

- First name
```md
WebElement firstName = driver.findElement(By.xpath("//ul[@class='primary-contact-information']//li[1]//child::input[1]"));
wait.until(ExpectedConditions.visibilityOf(firstName));
firstName.sendKeys("Mawaddah");
```

- Last name
```md
WebElement lastName = driver.findElement(By.xpath("//li[@class='last-name primary-last-name']//following::input[@type='text' and @data-field-name='txt_ContactInfo_LName']"));
lastName.sendKeys("Hanbali");
```

- Email
```md
WebElement email = driver.findElement(By.xpath("//label[starts-with(normalize-space(),'Email address')]//following::input[1]"));
email.sendKeys("mawaddah@gmail.com");
```

- Phone Number
```md
WebElement phoneNumber = driver.findElement(By.xpath("//li[@class='phone']//div[@class='error-text']//preceding::input[1]"));
phoneNumber.sendKeys("12012987481");
phoneNumber.clear();
phoneNumber.sendKeys("12012987481");
phoneNumber.sendKeys(Keys.RETURN);
Thread.sleep(5000);
```

- Address
```md
WebElement address = driver.findElement(By.xpath("//input[@type='text'][@tabindex='5']"));
address.sendKeys("Makkah");
```

- Zip Code
```md
WebElement zipCode = driver.findElement(By.xpath("//input[@type='text' and @maxlength='10']"));
zipCode.sendKeys("12343");
```

- City
```md
WebElement city = driver.findElement(By.xpath("//input[@type='text' and @maxlength='10']//following::input[1]"));
city.sendKeys("Makkah");
```

- State
```md
WebElement state = driver.findElement(By.xpath("//option[text()='DC' or @value='29']//following::option[text()='FL']"));
state.click();
```

- Country
```md
WebElement country = driver.findElement(By.xpath("//option[@value='188']//preceding-sibling::option[starts-with(@value,'187')]"));
country.click();
Thread.sleep(5000);
```

- Payment First Name and Last Name
```md
WebElement paymentFirstName = driver.findElement(By.xpath("//ul[@class='payment-information-form']//following::input[@tabindex='26' and @data-field-name='txt_PaymentInfo_FName']"));

WebElement paymentLastName = driver.findElement(By.xpath("//input[@tabindex='26' and @data-field-name='txt_PaymentInfo_LName']"));

// copy and paste the first and last name from above textfield to this fields
action.moveToElement(firstName).click().build().perform();
action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform(); // select
action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform(); // copy
action.moveToElement(paymentFirstName).click().build().perform();
action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform(); // paste

action.moveToElement(lastName).click().build().perform();
action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform(); // select
action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform(); // copy
action.moveToElement(paymentLastName).click().build().perform();
action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform(); // paste
```

- Card number
```md
WebElement cardNumber = driver.findElement(By.xpath("//div//input[@value='0']//following-sibling::input[1]"));
cardNumber.sendKeys("12345678942314");
```

- Month
```md
WebElement month = driver.findElement(By.xpath("// option[contains(text(),'June')][@value='6']"));
month.click();
```

- Year
```md
WebElement year = driver.findElement(By.cssSelector("option[value$='028']"));
year.click();
```

- Billing zip code
```md
WebElement billingZipCode = driver.findElement(By.xpath("//span[text()='5 digit zip code']//preceding-sibling::input"));
billingZipCode.sendKeys("12345");
```

- CVV
```md
WebElement cvv = driver.findElement(By.xpath("//li[@class='cvv']//input[1]"));
cvv.sendKeys("777");
```

- checkbox4
```md
WebElement checkbox4 = driver.findElement(By.xpath("//p[@class='disclaimer epDisclaimerAccepted']"));
wait.until(ExpectedConditions.visibilityOf(checkbox4));
action.moveToElement(checkbox4).click().build().perform();
```

```md
WebElement next1 = driver.findElement(By.xpath("//a[@class='button orange flex has-right checkout-submit']"));
next1.click();
```


<p align="center">

https://user-images.githubusercontent.com/48597284/184288586-ea1a26f2-8ee8-4cb0-8ec8-8441775bf8aa.mp4

</p>

---

#### STEP 15:  In this code, I detect the error and compared it with the expected result.

```md
WebElement error = driver.findElement(By.xpath("//span[text()='Invalid Credit Card Number']"));
if (error.isDisplayed()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", error);
			String text = error.getText();
			Assert.assertEquals(text, "Invalid Credit Card Number");
			System.out.println("Finshied: Complete your order Page the text error is: " + text);
}
```


<p align="center">

https://user-images.githubusercontent.com/48597284/184288691-aed372de-1910-476c-b52d-8c178519cc5c.mp4

</p>

---
## Full Run:

<p align="center">


https://user-images.githubusercontent.com/48597284/184292028-ed5e7480-5249-4677-9c7b-e8dea276a055.mp4


</p>
