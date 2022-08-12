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

In this code, I used `ancestor-or-self` Axes, `and` operation.


```md
// "save and continue" button
WebElement saveAndContinue1 = driver.findElement(By.xpath("//div[@class='float-left']//ancestor-or-self::input"));
wait.until(ExpectedConditions.visibilityOf(saveAndContinue1));

// Actions class with moveToElement() and click()
action.moveToElement(saveAndContinue1).build().perform();
action.click(saveAndContinue1).build().perform();

// checkbox
WebElement checkBox = driver.findElement(By.xpath("//input[@id='chkctlgrantor_cograntor_CB' and @type='checkbox']"));
wait.until(ExpectedConditions.visibilityOf(checkBox));
checkBox.click();

// "save and continue" button
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

// "are u married" list
WebElement isMarriedU = driver.findElement(By.xpath("//select[@id='grantor_married_MC']//option[3]"));
isMarriedU.click();

// "have a children" list
WebElement haveChildrenU = driver.findElement(By.xpath("//option[@value='Yes|~|428853']//following-sibling::option"));
haveChildrenU.click();

// "save and continue" button
WebElement saveAndContinue3 = driver.findElement(By.cssSelector("input[name$='Continue2']"));
saveAndContinue3.click();
```

<p align="center">

https://user-images.githubusercontent.com/48597284/184276794-28b9a740-c660-4136-8d0d-cfd5746a8dea.mp4

</p>

---
## Output Screenshots:

<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/183262086-ab51da27-a092-4a51-9628-05bd170b010d.png" width=80% height=80%>


https://user-images.githubusercontent.com/48597284/183262155-e9b54ada-1207-4318-92f6-3cef3c95e3eb.mp4

</p>
