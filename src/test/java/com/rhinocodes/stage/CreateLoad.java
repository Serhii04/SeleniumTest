package com.rhinocodes.stage;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateLoad {

    @Test
    public void CreateLoad() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://tms-stage.rhinocodes.com/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("[type=\"email\"]")).sendKeys("serhii.popov@rhinocodes.com");
        driver.findElement(By.cssSelector("[type=\"password\"]")).sendKeys("l3e8w25k");

        WebElement root = driver.findElement(By.id("root"));
        root.findElement(By.cssSelector("[class=\"button button-blue button-small \"]")).click();

        System.out.println("The Test started successfully!");

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/div/a")));

        driver.findElement(By.cssSelector("[href=\"/loads/create\"]")).click();
        System.out.println("The Created Load Card -> General tab is opened");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[2]/div[2]/button")));

        Actions actions = new Actions(driver);
/*
        // List of Dispatchers (Create Load Card / General Tab)
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div[1]/div/div[1]/div/div/div/div")).click();
        Thread.sleep(1500);

        WebElement List = driver.findElement(By.cssSelector("[class=\"styles_select_component__3kExJ__menu-list css-11unzgr\"]"));
        List<WebElement> Dispatchers = List.findElements(By.cssSelector("[class=\"styles_select_component__3kExJ__option css-yt9ioa-option\"]"));
        System.out.println(Dispatchers.size());
        System.out.println("The list of Dispatcher: ");
        System.out.println(List.getText());

        for (int i = 0; i < Dispatchers.size(); i++) {
            System.out.println(Dispatchers.get(i).getText());
        }
*/

        //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div[1]/div/div[1]/h3")).click();
        driver.findElement(By.xpath("//*[@id=\"react-select-dispatcher-input\"]")).sendKeys("Lena_90 inst_ua");
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"react-select-dispatcher-input\"]"))).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();

        //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div[1]/div/div[2]/h3")).click();
        //Stirng Customer = "Home for Stage";

        driver.findElement(By.xpath("//*[@id=\"react-select-customer-input\"]")).sendKeys("Home for Stage");
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"react-select-customer-input\"]"))).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();

        driver.findElement(By.cssSelector("[name=\"refNumbersList[0]\"]")).sendKeys("Selenium_2902");
        driver.findElement(By.cssSelector("[placeholder=\"total rate\"]")).sendKeys("777.77");

        driver.findElement(By.cssSelector("[class=\"button button-green button-large \"]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[2]/div[2]/button[2]")));
        System.out.println("The load create pages step 2 is opened");

        //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div/div/div/div/div/div[2]/div")).click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"react-select-7-input\"]")).sendKeys("Denver, CO 80206, US");
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"react-select-7-input\"]"))).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[1]/div/div[1]/div/input")).sendKeys("12:12");

        driver.findElement(By.xpath("//*[@id=\"react-select-check_in_as-input\"]")).sendKeys("Home for Stage");
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"react-select-check_in_as-input\"]"))).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div/div[2]/div[3]/div/div[2]/div[1]/div[1]/input")).sendKeys("444");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div/div[2]/div[3]/div/div[2]/div[2]/div/div/div[1]/input")).sendKeys("666");

        //driver.findElement(By.xpath("//*[@id=\"react-select-8-input\"]")).click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//*[@id=\"react-select-8-input\"]")).click(); Thread.sleep(1000);
        //driver.findElement(By.xpath("//*[@id=\"react-select-8-input\"]")).click(); Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div/div[3]/div[2]/div/div[2]/div[2]/div/div/div[3]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div/div[3]/div[2]/div/div[2]/div[3]/div/div/div[1]/div/div[1]/div/input")).sendKeys("21:21");

        //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div/div[3]/div[2]/div/div[1]/div/div/div/div/div")).click();
        //Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div/div[3]/div[2]/div/div[1]/div/div/div/div")).click(); Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div/div[3]/div[2]/div/div[1]/div/div/div/div")).click();
/*
        WebElement List = driver.findElement(By.cssSelector("[class=\"select styles_select_component__3kExJ css-2b097c-container\"]"));
        List<WebElement> BookingDispatchers = List.findElements(By.xpath("//*[@id=\"react-select-customer-option-4\"]"));
        System.out.println(BookingDispatchers.size());
*/

        Thread.sleep(3000);
        //actions.sendKeys(Keys.DOWN).build().perform();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div/div[3]/div[2]/div/div[1]/div/div/div/div")).findElement(By.tagName("input")).sendKeys("Los Angeles, CA 91331, US");
        Thread.sleep(1000);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        //actions.sendKeys(Keys.ENTER).build().perform();

        //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div/div[3]/div[2]/div/div[1]/div/div/div/div/div/div[1]/div[2]/div")).sendKeys("Denver, CO 80206, US");
        //Thread.sleep(1000);
        //actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[1]/div/div[1]/div/div[3]/div[2]/div/div[1]/div/div/div/div/div/div[1]/div[1]"))).build().perform();
        //actions.sendKeys(Keys.ENTER).build().perform();

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/form/div[2]/div[2]/button[2]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[3]/div[2]/a[2]")));
        System.out.println("The new load has been created successfully");

        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div[2]/a[2]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/div[2]/div/div[2]/div[3]/button[9]")));
        System.out.println("The new load profile has been opened on view successfully");


    }

}
