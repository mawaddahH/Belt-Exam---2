# Belt-Exam---2
Belt Exam 2 for Track 2 - SDA - Software QA Bootcamp


## Table of contents
* [Question](#question)
* [Answer](#answer)
* [Output Screenshots](#output-screenshots)

---
## Question
Create an Automation Suite using Selenium (using the TestNG Framework) for confirming the error message when a wrong credit card number is entered for living trust Application form in the legal zoom.
https://www.legalzoom.com/

## Answer
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
- STEP 1: I used `Actions` class to do some actions and I used `WebDriverWait` class to avoid loading status error.

```md
ctions action = new Actions(driver);
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
```

- STEP 2: Navigate to the "Personal" Menu and click on the "living Trust" text, in this code I used `linkText` , and `partialLinkText` locator

```md
// personal menu
WebElement personal = driver.findElement(By.linkText("Personal"));
wait.until(ExpectedConditions.visibilityOf(personal));
personal.click();

// living Trust text
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

- STEP 3: Then I click on the "Start my living trust" button, Then I scroll down to the pricing plan and select the "Basic Living Trust" plan, in this code, I used the `child` Axes , and the `contains` function.

```md
// -Start my living trust- Button
WebElement start = driver.findElement(By.xpath("//p//child::a[@data-ga-label='hero_start_button' and contains(@class,'btn btn-action btn-lg ')]"));
wait.until(ExpectedConditions.visibilityOf(start));
start.click();

WebElement basicPlan = driver.findElement(By.xpath("//div[contains(text(),'$279')]//preceding-sibling::a"));
wait.until(ExpectedConditions.visibilityOf(basicPlan));
basicPlan.sendKeys(Keys.DOWN); // scroll down to the princing plan
basicPlan.click(); // click on Basic Plan it
```


<p align="center">

https://user-images.githubusercontent.com/48597284/184273113-a8d66e9d-01bd-4131-bbd0-7466d1fdf277.mp4

</p>

---

- STEP 4: For the "Personal Info" I started by clicking on the "save and continue" button by using the `Actions` class, Then I check on the checkbox button and then I click on the "save and continue" button.

In this code, I used `ancestor-or-self` Axes, and `and` operation.


```md
// -save and continue- button
WebElement saveAndContinue1 = driver.findElement(By.xpath("//div[@class='float-left']//ancestor-or-self::input"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue1));

// Actions class with moveToElement() and click()
action.moveToElement(saveAndContinue1).build().perform();
action.click(saveAndContinue1).build().perform();

// checkbox
WebElement checkBox = driver.findElement(By.xpath("//input[@id='chkctlgrantor_cograntor_CB' and @type='checkbox']"));
wait.until(ExpectedConditions.visibilityOf(checkBox));
checkBox.click();

// -save and continue- button
WebElement saveAndContinue2 = driver.findElement(By.xpath("//input[@alt='Continue']//self::input"));
saveAndContinue2.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184275541-ca525d75-ee68-403e-be9c-aab0a27d762a.mp4

</p>


---

- STEP 5: In this code, I filled up the required information in the "Tell us about yourself" form, in this code I used `or` operation, `*` and `#` and `$` for contains in CSSselector, `Keys.CONTROL` for copy and paste text, `[3]` order , and `following-sibling` Axes.


```md
// first name
WebElement firstNameU = driver.findElement(By.xpath("//input[@id='grantor_first' or @class='textbox required']"));
wait.until(ExpectedConditions.visibilityOf(firstNameU));
firstNameU.sendKeys("Mawaddah");
firstNameU.sendKeys(Keys.RETURN);

// middle name
WebElement middleNameU = driver.findElement(By.cssSelector("input#grantor_middle[name*='grantor_middle']"));
middleNameU.sendKeys("Sabaa");
middleNameU.sendKeys(Keys.RETURN);

// select firstName
action.moveToElement(firstNameU).click().build().perform();
action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform(); // select
action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform(); // copy

WebElement middleNameU1 = driver.findElement(By.xpath("//table//following::input[@id='grantor_middle']"));
action.moveToElement(middleNameU1).click().build().perform();
action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform(); // paste

// last name
WebElement lastNameU = driver.findElement(By.cssSelector("#grantor_last"));
lastNameU.sendKeys("Hanbali");

// -are u married- list
WebElement isMarriedU = driver.findElement(By.xpath("//select[@id='grantor_married_MC']//option[3]"));
isMarriedU.click();

// -have a children- list
WebElement haveChildrenU = driver.findElement(By.xpath("//option[@value='Yes|~|428853']//following-sibling::option"));
haveChildrenU.click();

// -save and continue- button
WebElement saveAndContinue3 = driver.findElement(By.cssSelector("input[name$='Continue2']"));
saveAndContinue3.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184276794-28b9a740-c660-4136-8d0d-cfd5746a8dea.mp4

</p>


---

- STEP 6: In this code, I fill up the required information in the section "Tell us about your Co-Grantor" , and I used `id` locator, XPath combination , and `parent` Axes.


```md
// first name
WebElement firstNameC = driver.findElement(By.id("co_first"));
wait.until(ExpectedConditions.visibilityOf(firstNameC));
firstNameC.sendKeys("Arwa");

// middle name
WebElement middleNameC = driver.findElement(By.xpath("//input[@id='co_middle'][@type='text']"));
middleNameC.sendKeys("Ahmad");

// last name
WebElement lastNameC = driver.findElement(By.xpath("//input[@id='co_last'][@size='30']"));
lastNameC.sendKeys("Komo");

// -are u married- list
WebElement isMarriedC = driver.findElement(By.xpath("//parent::select[@id='cograntor_married_MC']//child::option[3]"));
isMarriedC.click();

// -have a children- list
WebElement haveChildrenC = driver.findElement(By.xpath("//option[@value='No|~|428911']"));
haveChildrenC.click();

// -save and continue- button
WebElement saveAndContinue4 = driver.findElement(By.xpath("//input[@alt='Continue' and contains(@type,'image')]"));
saveAndContinue4.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184278332-b47d112a-b332-4975-93d3-3777f1693da9.mp4

</p>

---

- STEP 7: In this code, I filled up the required information in sections "Where do you live?" and "Where does your co-grantor live?"


```md
// ------------- Section: Where do you live?
// Street Address
WebElement streetAddressU = driver.findElement(By.id("grantor_address"));
wait.until(ExpectedConditions.visibilityOf(streetAddressU));
streetAddressU.sendKeys("saudi arabia");

// City
WebElement cityU = driver.findElement(By.cssSelector("input[id=grantor_city]"));
cityU.sendKeys("Makkah");
cityU.clear();

// -State- List
WebElement stateU = driver.findElement(By.xpath("//option[contains(@value,'New York')]"));
stateU.click();

// ZIP
WebElement zipU = driver.findElement(By.xpath("//input[@id='grantor_zip' and @class='textbox ']"));
zipU.sendKeys("123456");

// -save and continue- button
WebElement saveAndContinue5 = driver.findElement(By.cssSelector("input[alt='Continue']"));
saveAndContinue5.click();

// ------------- Section: Where does your co-grantor live?
// "State" List
WebElement stateC = driver.findElement(By.xpath("//option[text()='California']"));
stateC.click();

// -save and continue- button
WebElement saveAndContinue6 = driver.findElement(By.cssSelector("input[alt='Continue']"));
saveAndContinue6.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184279127-f3fb810c-1bac-4e2a-a5c9-66634e544254.mp4

</p>

---

- STEP 8: In this code, I filled up the required information in section "Which state's laws do you want to govern the trust?"

```md
// laws
WebElement laws = driver.findElement(By.xpath("//option[starts-with(@value,'My ')]"));
laws.click();

// -save and continue- button
WebElement saveAndContinue7 = driver.findElement(By.xpath("//input[@alt='Continue' or @onclick='pushEpOutboundSaleInfo();']"));
saveAndContinue7.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184279743-c8d0599b-e492-400e-8444-0cd9f0bacbbe.mp4

</p>


---

- STEP 9: In this code, I filled up the required information in Property Page for sections "Overview of how property is placed in a trust.", "What types of property will be put into trust?", "Real estate details.", and "Stock and bond details."., and I used cssSelector combination , `name` locatior , and `following` Axes

```md
// -------------- Property Page ------------------------
// ---- Section: Overview of how property is placed in a trust.
// -save and continue- button
WebElement saveAndContinue8 = driver.findElement(By.cssSelector("input[alt='Continue'][type='image']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue8));
saveAndContinue8.click();

// ---- Section: What types of property will be put into trust?
WebElement checkbox1 = driver.findElement(By.name("chkctlproperty_realestate_CB"));
checkbox1.click();

WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='chkctlproperty_realestate_CB']//following::input[4]"));
checkbox2.click();

// -save and continue- button
WebElement saveAndContinue9 = driver.findElement(By.cssSelector("div > input[alt='Continue']"));
saveAndContinue9.click();

// ------------- Section: Real estate details.
// -save and continue- button
WebElement saveAndContinue10 = driver.findElement(By.xpath("//input[@alt='Continue' and @src='/img/buttonContinueFat.gif']"));
saveAndContinue10.click();

// ------------- Section: Stock and bond details.
// -save and continue- button
WebElement saveAndContinue11 = driver.findElement(By.cssSelector("input[alt='Continue']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue11));
saveAndContinue11.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184284666-1107bb26-1e96-4273-9a68-7a9e6f8bd435.mp4

</p>

---

- STEP 10: In this code, I filled up the required information in Gifts Page for sections and I used cssSelector combination , `name` locatior , and `following` Axes

```md
// ------------- Section: Overview of how gifts are handled in a trust.
// -save and continue- button
WebElement saveAndContinue12 = driver.findElement(By.cssSelector("input[alt='Continue']"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue12));
saveAndContinue12.sendKeys(Keys.DOWN); // scroll down to the princing plan
saveAndContinue12.click();

// Section: What should happen to the property placed in the trust when the first co-grantor passes away?
// checkbox
WebElement checkbox3 = driver.findElement(By.name("chkctlother_heirs_cograntor_CB"));
wait.until(ExpectedConditions.visibilityOf(checkbox3));
checkbox3.click();

// -save and continue- button
WebElement saveAndContinue13 = driver.findElement(By.cssSelector("input[alt='Continue']"));
saveAndContinue13.sendKeys(Keys.DOWN);
saveAndContinue13.click();
Thread.sleep(5000);
```


```md
// ------------- Section: Who will receive your portion of the trust property?
// percentage textfield
WebElement percentage = driver.findElement(By.xpath("//input[@class='textbox required decimalNumber percentFormat formatInput']"));
wait.until(ExpectedConditions.visibilityOf(percentage));
percentage.sendKeys("100%");

// full Name textfield
WebElement fullName = driver.findElement(By.xpath("//input[@class='textbox required'][@type='text']"));
fullName.sendKeys("Mawaddah Hanbali");

// -save and continue- button
WebElement saveAndContinue15 = driver.findElement(By.cssSelector("input[alt='Continue']"));
saveAndContinue15.sendKeys(Keys.DOWN);
saveAndContinue15.click();

// ------------- Section: Who will receive your co-grantor's portion of the trust property?
// percentage textfield
WebElement percentageC = driver.findElement(By.xpath("//input[@class='textbox required decimalNumber percentFormat formatInput']"));
wait.until(ExpectedConditions.visibilityOf(percentageC));
percentageC.sendKeys("100%");

// percentage textfield
WebElement fullNameC = driver.findElement(By.xpath("//input[@class='textbox required'][@type='text']"));
fullNameC.sendKeys("Arwa Komo");

// -save and continue- button
WebElement saveAndContinue16 = driver.findElement(By.cssSelector("input[alt='Continue']"));
saveAndContinue16.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184285440-2f14cf1f-b552-46fc-b1a1-8b95676e508f.mp4

</p>



---
## Output Screenshots:

<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/183262086-ab51da27-a092-4a51-9628-05bd170b010d.png" width=80% height=80%>


https://user-images.githubusercontent.com/48597284/183262155-e9b54ada-1207-4318-92f6-3cef3c95e3eb.mp4

</p>
