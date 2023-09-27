package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationTests {
    public static void main(String[] args) {
        String browser="";
       for (int i =0; i<3; i++)
        {
            if(i == 1)
            {
                browser = "chrome";
            }
            else if(i==2)
            {
                browser = "firefox";
            }
            else
            {
                browser = "edge";
            }


            WebDriver driver = BrowserFactory.getDriver(browser);

            driver.get("https://www.google.com");

            String firstTitleGoogle = driver.getTitle();

            driver.get("https://www.etsy.com");

            String firstTitleEtsy = driver.getTitle();

            driver.navigate().back();

            String secondTitleGoogle = driver.getTitle();

            String currentUrlGoogle = driver.getCurrentUrl();
            int start = currentUrlGoogle.indexOf(".");
            int end = currentUrlGoogle.lastIndexOf(".");
            String outStr = currentUrlGoogle.substring(start + 1, end);

            StringUtility.VerifyEquals(firstTitleGoogle, secondTitleGoogle, outStr);

            driver.navigate().forward();

            String secondTitleEtsy = driver.getTitle();

            String currentUrlEtsy = driver.getCurrentUrl();
            start = currentUrlEtsy.indexOf(".");
            end = currentUrlEtsy.lastIndexOf(".");
            outStr = currentUrlEtsy.substring(start + 1, end);

            StringUtility.VerifyEquals(firstTitleEtsy, secondTitleEtsy, outStr);

            driver.quit();
        }
    }
}
