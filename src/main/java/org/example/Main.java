package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //Create a driver instance using WebDriver interface.
        //Navigate to the URL https://qaiotlorawan.ccbp.tech/
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://qaiotlorawan.ccbp.tech/");

        //Print the Heading text.
        String HeadingText = driver.findElement(By.tagName("h1")).getText();
        System.out.println(HeadingText);
        //Perform the following actions in the <iframe> element - use name attribute to switch,

        driver.switchTo().frame("conference");

        //Print the Heading text of the embedded Home page.
        String HeadEleFrame = driver.findElement(By.className("conference-title")).getText();
        System.out.println(HeadEleFrame);
        //Click the "Know more" button.

        driver.findElement(By.tagName("button")).click();

        WebElement iframeElement = driver.findElement(By.className("embed-responsive-item"));
        driver.switchTo().frame(iframeElement);

        //Wait and Verify the Video title of the embedded video element - use WebElement to switch,

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ytp-title-text")));

        WebElement videoTitleElement = driver.findElement(By.className("ytp-title-text"));

        String actualVideoTitle  = videoTitleElement.getText();

        //Expected text: The Things Conference India 2019 | After Movie
        String expectedTitle = "The Things Conference India 2019 | After Movie";
        //If the video title matches the expected text, print "Video title matched".
        if(actualVideoTitle.equals(expectedTitle)){
            System.out.println("Video title matched");
        }else{
            System.out.println("Mismatch found in the video title");
        }
        //Else, print "Mismatch found in the video title".


        //Verify the Heading text of the embedded Details page.
        //Expected text: The Things Conference
        //If the video title matches the expected text, print "Heading matched".
        //Else, print "Mismatch found in the heading".

         driver.switchTo().parentFrame();

         WebElement headingElement = driver.findElement(By.tagName("h1"));
        String expectedText = "The Things Conference";
        String actualText = headingElement.getText();
        if(actualText.equals(expectedText)) {
            System.out.println("Heading matched");
        } else {
            System.out.println("Mismatch found in the heading");
        }

       
    }
}