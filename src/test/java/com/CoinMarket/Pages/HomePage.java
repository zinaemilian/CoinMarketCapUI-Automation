package com.CoinMarket.Pages;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class HomePage extends BasePage {
    private static HomePage login;



    @FindBy(xpath = "/html/body/div[3]/div[2]/div[4]/button")
    public WebElement nextBtn;
    @FindBy(css = "script[data-nscript=lazyOnload]")
    public WebElement exitPrivacyPolicy;

    @FindBy(xpath = "//button[contains(@class,'jgNqHP')]")
    public List<WebElement> rows;
    @FindBy(xpath = "//button[contains(@color,'var(--primary-color-black)')]")
    public List<WebElement> filterOptions;
    @FindBy(xpath = "//li[contains(@class,'optionGroupItem')]")
    public List<WebElement> algorithOptns;


    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[3]/div[1]/div")
    public WebElement showRows;


    @FindBy(xpath = "/html/body/div[3]/div[2]/div[4]/button")
    public WebElement goItBtn;
    @FindBy(xpath = "//*[@id=\"cmc-cookie-policy-banner\"]/div[2]")
    public WebElement cookieBanner;








}

