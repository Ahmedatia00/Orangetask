import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Orange1 {

    static String[] expected = {"Solutions",
            "Collaborative workspace",
            "Cloud",
            "Cyberdefense",
            "Services",
            "Data intelligence",
            "Customer experience",
            "Internet of things",
            "Mobile connectivity",
            "Network transformation",
            "All products"};
    static String expectedArticle = ("Managed Applications: improve operational capability in the cloud");

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ahmed\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Orange Business services");
        driver.manage().timeouts().getPageLoadTimeout();
        driver.findElement(By.name("btnK"));
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();
        WebElement OrangeURL = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/a/h3/span"));
        OrangeURL.click();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement SolutionsButton = driver.findElement(By.xpath("/html/body/div[3]/header/div/nav/div/div[3]/div[1]/nav/ul/li[1]/a"));
        SolutionsButton.click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        //Validate  list
        validateOptions(driver);

        WebElement Cloud = driver.findElement(By.xpath("/html/body/div[3]/header/div/nav/div/div[3]/div[1]/nav/ul/li[1]/ul/li/div/div[1]/ul/li[1]/a"));
        Cloud.click();
        WebElement Article = driver.findElement(By.xpath("/html/body/div[3]/div[2]/section/div/article/div/div/div[4]/div[2]/div[1]/div/div[3]/div/div/p[1]/a/strong"));
        Article.click();
        validateArticle(driver);

        driver.close();

    }

    private static void validateArticle(WebDriver driver) {
        WebElement actualArticle = driver.findElement(By.xpath("/html/body/div[3]/div[2]/section/div/section[2]/h1/span"));
        if (actualArticle.getAttribute("innerText").equals(expectedArticle)){
            System.out.println("Article is exist");
        }else{
            System.out.println("Article is not exist");
        }
    }

    private static void validateOptions(WebDriver driver) {
        List<String> expected1 = new ArrayList<>();
        expected1.addAll(Arrays.asList(expected));
        List<WebElement> Option1 = driver.findElements(By.xpath("/html/body/div[3]/header/div/nav/div/div[3]/div[1]/nav/ul/li[1]/ul/li/div"));
        List<String> options = Arrays.asList(Option1.get(0).getAttribute("innerText").split("\\r?\\n"));
        for (String option : options){
            if(expected1.contains(option)){
                System.out.println(option + " is exist");
            }else{
                System.out.println(option + " is not exist");
            }
        }
    }
}



