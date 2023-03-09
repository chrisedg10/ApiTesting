package ravn.Contexts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PokeApi {
    private WebDriver driver;

    public PokeApi(WebDriver driver){
        this.driver = driver;
    }

    public WebElement apiInput(){
        WebElement inputElement = driver.findElement(By.id("url-input"));
        return inputElement;
    }

    public WebElement submitApi(){
        WebElement button = driver.findElement(By.className("Input-module__button--3cQfp"));
        return button;
    }

    public WebElement clipboardBtn(){
        WebElement button = driver.findElement(By.className("ClipboardButton-module__buttoncopy--4ZooZ"));
        return button;
    }

    public WebElement viewRaw(){
        WebElement checkbox = driver.findElement(By.cssSelector("*>div.JsonViewer-module__toolbar--1qg2d>label>input"));
        return checkbox;
    }

    public WebElement apiLink(){
        WebElement link = driver.findElement(By.partialLinkText("https://pokeapi.co/api/v2/"));
        return link;
    }

    public WebElement code(){
        WebElement code = driver.findElement(By.cssSelector("code"));
        return code;
    }
}
