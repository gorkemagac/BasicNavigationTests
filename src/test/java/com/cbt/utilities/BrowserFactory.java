package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browserType)
    {
        String os = System.getProperty("os.name");
        if(os.contains("windows") && browserType.equalsIgnoreCase("safari"))
        {
            return null;
        }
        else if (os.contains("mac") && browserType.equalsIgnoreCase("edge"))
        {
            return null;
        }
        else
        {
        if(browserType.equalsIgnoreCase("chrome"))
            {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            else if (browserType.equalsIgnoreCase("firefox"))
            {
               WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            else if (browserType.equalsIgnoreCase("edge"))
            {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            else if (browserType.equalsIgnoreCase("safari"))
            {
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            }
            else
            {
                System.out.println("Given browser type does not exist or is not currently supported");
                System.out.println("Driver = null");
                return null;
            }
    }

    }

}
