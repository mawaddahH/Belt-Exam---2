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



---
## Output Screenshots:

<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/183262086-ab51da27-a092-4a51-9628-05bd170b010d.png" width=80% height=80%>


https://user-images.githubusercontent.com/48597284/183262155-e9b54ada-1207-4318-92f6-3cef3c95e3eb.mp4

</p>
