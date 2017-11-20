package main2;

import java.util.Random;
import java.lang.Math;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Registration {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

                //TempEmail
        driver.get("https://www.mydlo.ru/");
        WebElement RegistrationEmail = driver.findElement(By.id("mbox-address"));
        String TempEmail = RegistrationEmail.getAttribute("textContent");
        System.out.println("Temp email is " + TempEmail);

                //Random
        String RandomWebmoney = RandomWord2(12);
        System.out.println("Random Webmoney is " + RandomWebmoney);
        String RandomCard = RandomWord2(16);
        System.out.println("Random BankCard is " + RandomCard);
        String RandomEpayments = (RandomWord2(3) + "-" + RandomWord2(6));
        System.out.println("Random Epayments is " + RandomEpayments);
        String RandomPassword = RandomWord(6);
        System.out.println("Random password is " + RandomPassword);

                //Registration page
        driver.get("http://cpa.kpilead.ru");
        WebElement Registration = driver.findElement(By.xpath("/html/body/header/nav/div/div/div[2]/div/a[7]"));
        Registration.click();

                //Webmoney
        String[] ArrayWebmoney = {
                "1230",
                "1",
                "1231238831239",
                RandomWebmoney,
                "1234567890",
                "03487362",
                "<script>alert('aa');</script>",
        };
        boolean Correct;
        for (String Array : ArrayWebmoney) {
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/fieldset[2]/div[1]/div/label")).click();
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/fieldset[3]/div[1]/div/div/div[2]/div/ul/li[2]")).click();
            driver.findElement(By.name("User[email]")).clear();
            driver.findElement(By.name("User[email]")).sendKeys("test@t.ru");
            driver.findElement(By.name("User[password]")).clear();
            driver.findElement(By.name("User[password]")).sendKeys("tes8");
            driver.findElement(By.name("User[password2]")).clear();
            driver.findElement(By.name("User[password2]")).sendKeys("tes9");
            driver.findElement(By.name("User[skype]")).clear();
            driver.findElement(By.name("User[skype]")).sendKeys("TestSkype");
            driver.findElement(By.name("User[payment_system_value]")).clear();
            driver.findElement(By.name("User[payment_system_value]")).sendKeys("R" + Array);
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/div[2]/div/button")).click();
            try {
                driver.findElement(By.xpath("//*[contains(text(), 'Incorrect data of the payment system')]"));
                Correct = false;
            } catch (NoSuchElementException e) {
                Correct = true;
            }
            if (Correct)
            {
                System.out.println("Correct = " + Array);
                break;
            } else System.out.println("Not correct = " + Array);
        }
        try {
            driver.findElement(By.xpath("//*[contains(text(), 'Incorrect data of the payment system')]"));
            Correct = false;
        } catch (NoSuchElementException e) {
            Correct = true;
        }
        if (Correct)
        {
            System.out.println("Webmoney is correct!");
        } else System.out.println("Webmoney is not correct!");

                //BankCard
        String[] ArrayCard = {
                "1",
                "<script>alert('aa');</script>",
                RandomCard,
                "1231238831239",
                "%$^#&@*",
                "5539701699173755",
                "5440428656542891",
                "5421899858045672",
        };
        for (String Array : ArrayCard) {
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/fieldset[2]/div[1]/div/label")).click();
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/fieldset[3]/div[1]/div/div/div[2]/div/ul/li")).click();
            driver.findElement(By.name("User[payment_system_value]")).clear();
            driver.findElement(By.name("User[payment_system_value]")).sendKeys(Array);
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/div[2]/div/button")).click();
            try {
                driver.findElement(By.xpath("//*[contains(text(), 'Incorrect data of the payment system')]"));
                Correct = false;
            } catch (NoSuchElementException e) {
                Correct = true;
            }
            if (Correct) {
                System.out.println("Correct = " + Array);
                break;
            } else System.out.println("Not correct = " + Array);
        }
        try {
            driver.findElement(By.xpath("//*[contains(text(), 'Incorrect data of the payment system')]"));
            Correct = false;
        } catch (NoSuchElementException e) {
            Correct = true;
        }
        if (Correct) {
            System.out.println("BankCard is correct");
        } else System.out.println("BankCard is not correct");

                //Epayments
        String[] ArrayEpayments = {
                "1230",
                "1",
                "<script>alert('aa');</script>",
                "1231238831239",
                "%$^#&@*",
                "5539701699173755",
                RandomEpayments,
        };
        for (String Array : ArrayEpayments) {
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/fieldset[2]/div[1]/div/label")).click();
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/fieldset[3]/div[1]/div/div/div[2]/div/ul/li[3]")).click();
            driver.findElement(By.name("User[payment_system_value]")).clear();
            driver.findElement(By.name("User[payment_system_value]")).sendKeys(Array);
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/div[2]/div/button")).click();
            try {
                driver.findElement(By.xpath("//*[contains(text(), 'Incorrect data of the payment system')]"));
                Correct = false;
            } catch (NoSuchElementException e) {
                Correct = true;
            }
            if (Correct) {
                System.out.println("Correct = " + Array);
                break;
            } else System.out.println("Not correct = " + Array);
        }
        try {
            driver.findElement(By.xpath("//*[contains(text(), 'Incorrect data of the payment system')]"));
            Correct = false;
        } catch (NoSuchElementException e) {
            Correct = true;
        }
        if (Correct) {
            System.out.println("Epayments is correct!");
        } else System.out.println("Epayments is not correct!");

                //Email
        String[] ArrayEmail = {
                "123@pppp.ru",
                "*&^%$#!@!~`/.-mail.ru",
                "123@mail.noru",
                "<script>alert('aa');</script>",
                "%$^#&@*",
                "hokkkk@.778.ru",
                TempEmail,
                "test54@yandex.ru",
        };
        for (String Array : ArrayEmail) {
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/fieldset[2]/div[1]/div/label")).click();
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/fieldset[3]/div[1]/div/div/div[2]/div/ul/li[3]")).click();
            driver.findElement(By.name("User[email]")).clear();
            driver.findElement(By.name("User[email]")).sendKeys(Array);
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/div[2]/div/button")).click();
            try {
                driver.findElement(By.xpath("//*[contains(text(), 'E-mail is not a valid email address')]"));
                Correct = false;
            } catch (NoSuchElementException e) {
                Correct = true;
            }
            if (Correct) {
                System.out.println("Correct = " + Array);
                break;
            } else System.out.println("Not correct = " + Array);
        }
        try {
            driver.findElement(By.xpath("//*[contains(text(), 'E-mail is not a valid email address')]"));
            Correct = false;
        } catch (NoSuchElementException e) {
            Correct = true;
        }
        if (Correct) {
            System.out.println("Email is correct!");
        } else System.out.println("Email is not correct!");

                //Password1
        String[] ArrayPassword1 = {
                "123",
                RandomPassword,
                "*&^%$#!@!~`/.-@mail.ru",
                "'@#$%^'",
                "<script>alert('aa');</script>",
                "gfhjkm456",
        };
        for (String Array : ArrayPassword1) {
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/fieldset[2]/div[1]/div/label")).click();
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/fieldset[3]/div[1]/div/div/div[2]/div/ul/li[3]")).click();
            driver.findElement(By.name("User[password]")).clear();
            driver.findElement(By.name("User[password]")).sendKeys(Array);
            driver.findElement(By.name("User[password2]")).clear();
            driver.findElement(By.name("User[password2]")).sendKeys("tes");
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/div[2]/div/button")).click();
            try {
                driver.findElement(By.xpath("//*[contains(text(), 'Password is too short (minimum is 6 characters)')]"));
                Correct = false;
            } catch (NoSuchElementException e) {
                Correct = true;
            }
            if (Correct) {
                System.out.println("Correct = " + Array);
                break;
            } else System.out.println("Not correct = " + Array);
        }
        try {
            driver.findElement(By.xpath("//*[contains(text(), 'Password is too short (minimum is 6 characters)')]"));
            Correct = false;
        } catch (NoSuchElementException e) {
            Correct = true;
        }
        if (Correct) {
            System.out.println("Password1 is correct!");
        } else System.out.println("Password1 is not correct!");

                //Password2
        String[] ArrayPassword2 = {
                "123",
                "*&^%$#!@!~`/.-@mail.ru",
                "'@#$%^'",
                "<script>alert('aa');</script>",
                RandomPassword,
                "gfhjkm456",
        };
        for (String Array : ArrayPassword2) {
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/fieldset[2]/div[1]/div/label")).click();
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/fieldset[3]/div[1]/div/div/div[2]/div/ul/li[3]")).click();
            driver.findElement(By.name("User[password2]")).clear();
            driver.findElement(By.name("User[password2]")).sendKeys(Array);
            driver.findElement(By.xpath("//*[@id=\"registration-form\"]/div[2]/div/button")).click();
            try {
                driver.findElement(By.xpath("//*[contains(text(), 'Password must be repeated exactly')]"));
                Correct = false;
            } catch (NoSuchElementException e) {
                Correct = true;
            }
            if (Correct) {
                System.out.println("Correct = " + Array);
                break;
            } else System.out.println("Not correct = " + Array);
        }
        try {
            driver.findElement(By.xpath("//*[contains(text(), 'Password must be repeated exactly')]"));
            Correct = false;
        } catch (NoSuchElementException e) {
            Correct = true;
        }
        if (Correct) {
            System.out.println("Password2 is correct!");
        } else System.out.println("Password2 is not correct!");

        Thread.sleep(4000);

                //Verify
        try {
            driver.findElement(By.xpath("//*[contains(text(), 'Registration is completed')]"));
            Correct = true;
        } catch (NoSuchElementException e) {
            Correct = false;
        }
        if (Correct) {
            System.out.println("Registration complete! :)");
        }
        else {
            System.out.println("Registration failed! :(");
        }
        Thread.sleep(4000);
        driver.quit();
    }

            //Randomize
    private static int randomize(int min, int max)
    {
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
    private static String RandomWord(int length)
    {
        String s = "";
        for (int i=0; i< length; i++)
            s+=(char)randomize(65,90);
        return s;
    }

    private static int randomize2(int min, int max)
    {
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
    private static String RandomWord2(int length)
    {
        String s = "";
        for (int i=0; i< length; i++)
            s+=(char)randomize2(48,57);
        return s;
    }
}
