package br.com.matheusrodrigues_pg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='carousel-inner']")
    public WebElement divCarousel;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
    public WebElement aLogged;

    @FindBy(css = "html > body > section:nth-of-type(2) > div > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(1) > div:nth-of-type(1) > p")
    public WebElement item1;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")
    public WebElement h2Bitem1;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    public WebElement linkViewProduct1;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
    public WebElement deleteAccount;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    public WebElement bAccountDeleted;

    @FindBy(xpath = "//a[contains(@class, 'btn')]")
    public WebElement linkContinueButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    public WebElement linkLogout;

    @FindBy(xpath = "//*[@id='quantity']")
    public WebElement inputQuantity;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement buttonAddCart;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[1]/div/div/div[2]/p[2]/a/u")
    public WebElement uViewCart;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    public WebElement descriptionItem;

    @FindBy(xpath = "//button[@class='disabled']")
    public WebElement quantityDesc;

    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div")
    public WebElement spanCart;

    public HomePage(WebDriver driver) {
        super(driver);
    }

}
