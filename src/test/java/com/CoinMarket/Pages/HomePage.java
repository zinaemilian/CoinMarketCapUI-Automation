package com.CoinMarket.Pages;




import com.CoinMarket.Pojo.CryptoCurrency;
import com.CoinMarket.Utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class HomePage extends BasePage {
    private static HomePage login;


    public static HomePage newInstance() {
        if (login == null)
            login = new HomePage();
        return login;
    }

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


    @FindBy(xpath = "(//button[contains(@class,'sc-a4a6801b-0 gNHIvn sc-c8c9e58f-0 eTWSGQ table-control-filter')])[2]")
    public WebElement filters;
    @FindBy(xpath = "(//button[contains(@class,'sc-a4a6801b-0 gNHIvn sc-cc37dd9f-0 sc-7b31fd38-0 cmPAGl')])[4]")
    public WebElement addFilterBtn;
    @FindBy(xpath = "(//label[contains(@class,'sc-f3593cc1-1 jZWMqF switch-label')])[1]")
    public WebElement toggleMnineable;
    @FindBy(xpath = "//button[contains(@class,'sc-a4a6801b-0 ccMCCm') and text()='Maybe later']")
    public WebElement maybeLater;
    @FindBy(xpath = "(//*[contains(@class,'sc-aef7b723-0 dsDrxm') and contains(@viewBox,'0 0 24 24')])[2]")
    public WebElement allCryp;
    @FindBy(xpath = "//button[contains(@class,'sc-a4a6801b-0 bcMxzk cmc-option-button') and text()='Coins']")
    public WebElement coinsbtn;
    String customAllCryp = "//button[contains(@class,'sc-a4a6801b-0 bcMxzk cmc-option-button') and text()=";
    @FindBy(xpath = "//button[contains(@class,'sc-a4a6801b-0 cGFzGl cmc-filter-button')and text()='Price']")
    public WebElement pricebtn;
    @FindBy(xpath = "(//input[contains(@class,'sc-714c8115-0 fYvFYt sc-67bdc129-3 eduQxS')])[1]")
    public WebElement priceRangeFrom;
    @FindBy(xpath = "(//input[contains(@class,'sc-714c8115-0 fYvFYt sc-67bdc129-3 eduQxS')])[2]")
    public WebElement priceRangeTo;
    @FindBy(xpath = "//button[text()='Apply Filter']")
    public WebElement applyPriceRangeFilter;
    @FindBy(xpath = "//button[text()='Show results']")
    public WebElement showResults;

    public void closeGetMoreOutOfOurSearchFeaturePopUp() {
        BrowserUtils.waitForClickablility(nextBtn, Duration.ofSeconds(5));
        if(nextBtn.isDisplayed()) {nextBtn.click();
        }
    }

    public void closeMakeThisTableWorkForYou() {
        BrowserUtils.waitForClickablility(goItBtn, Duration.ofSeconds(5));
        if(goItBtn.isDisplayed()){goItBtn.click();}
    }
    //    public void closeSingUpForFreeBanner(){
//        if(maybeLater.isDisplayed()){
//            BrowserUtils.waitForClickablility(maybeLater,Duration.ofSeconds(5));
//        }
//
//    }
    //sc-95300295-0 cpQOeV cmc-cookie-policy-banner
    public void closeCookiePolicyBanner() {
        BrowserUtils.waitForClickablility(cookieBanner, Duration.ofSeconds(5));
        if(cookieBanner.isDisplayed()){
            cookieBanner.click();}
    }

    public void ApplyFilters() {filters.click();}

    public void ScrollUpToPage() {
        BrowserUtils.scrollToElement(showRows);
    }

    public void filterByNumberOfRows(String rowNumber) {
        showRows.click();
        BrowserUtils.waitFor(3);

        BrowserUtils.ClickBtnOption(rowNumber, rows);


    }

    /* public  List<String>  PageContentTexts(List<WebElement> pageContents)
    {
        return BrowserUtils.getElementsText(pageContents);
    }*/
    public void ApplyFilters(String filterName) {
        BrowserUtils.waitFor(3);
        BrowserUtils.ClickBtnOption(filterName, filterOptions);

    }

    public void ApplyAlgorithms(String algorithmName) {

        BrowserUtils.ByExactOption(algorithmName, algorithOptns);
        BrowserUtils.waitFor(5);
    }

    public void AddFilter() {
        BrowserUtils.waitFor(5);
        addFilterBtn.click();
        System.out.println("applyfilter  is clicked");

    }

    public void ClickMineable() {
        BrowserUtils.waitFor(5);
        toggleMnineable.click();
        System.out.println("toggle  is clicked");
    }

    public void ClickMaybeLater() {
        maybeLater.click();
        System.out.println("later  is clicked");
    }

    public void ClickAllCryp() {
        BrowserUtils.clickWithTimeOut(allCryp, 3);
        // allCryp.click();
        System.out.println("allcryp  is clicked");
    }

    public void SelectCoin() {
        BrowserUtils.clickWithTimeOut(coinsbtn, 3);
        System.out.println("coins  is clicked");

    }

    public void SelectPrice() {
        BrowserUtils.clickWithTimeOut(pricebtn, 3);
        System.out.println("price  is clicked");

    }

    public void senKeysPriceRange(String min, String max) {
        BrowserUtils.clickWithTimeOut(priceRangeFrom, 3);
        priceRangeFrom.sendKeys(min);
        BrowserUtils.clickWithTimeOut(priceRangeTo, 3);
        priceRangeTo.sendKeys(max);
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithTimeOut(maybeLater, 3);
    }

    public void ApplyPriceRageFilter() {
        BrowserUtils.waitForClickablility(applyPriceRangeFilter, Duration.ofSeconds(2));
        System.out.println("apply rage filetr");
        BrowserUtils.clickWithTimeOut(applyPriceRangeFilter, 3);
        System.out.println("apply Rage filter");
    }

    public void ApplyShowResults() {
        BrowserUtils.waitForClickablility(showResults, Duration.ofSeconds(2));
        BrowserUtils.clickWithTimeOut(showResults, 3);
        System.out.println("show results filter");
    }

    @FindBy(css = "div.sc-7510a17-0.hEduBL")
    public List<WebElement> marketCapOnlyFirst;
    @FindBy(css = "span.sc-b2299d0c-1.hHzHwP")
    public List<WebElement> marketCapOnlyLast;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    public List<WebElement> cryptoCurrencies;

    public List<String> PageContentsMarketCap(String contentName)
    {
        List<CryptoCurrency> cryptoCurrencyList=new ArrayList<CryptoCurrency>();
        for (WebElement element : cryptoCurrencies) {

            CryptoCurrency cryptoCurrency=new CryptoCurrency();
            cryptoCurrency.setCurrencyName(element.getText());
            cryptoCurrency.setCurrencyCode(element.getText());
            cryptoCurrency.setCurrencyName(element.getText());
            cryptoCurrency.setCurrencyName(element.getText());
            cryptoCurrencyList.add(cryptoCurrency);
        }
        List<String> contentTexts = new ArrayList<>();
//        switch (contentName) {
//        case "MarketCapFirst":
//
//            contentTexts=webUtilities.pageContent(marketCapOnlyFirst);
//
//            System.out.println(contentTexts);
//
//            break;
//
//
//        case "MarketCapLast":
//
//            contentTexts=webUtilities.pageContent(marketCapOnlyLast);
//            System.out.println(contentTexts);
//            break;
//
//        default:

        System.out.println("no match");

//        List<CryptoCurrency> cryptoCurrencyList=new ArrayList<CryptoCurrency>();
//        CryptoCurrency bitCoin=new CryptoCurrency();
//        CryptoCurrency xcoin=new CryptoCurrency();
//        cryptoCurrencyList.add(bitCoin);
//        cryptoCurrencyList.add(xcoin);
//        bitCoin.setCurrencyMarketCap(nextBtn.getText());
        // return contentTexts;

        return contentTexts;}




}

