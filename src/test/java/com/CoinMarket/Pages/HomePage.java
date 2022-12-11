package com.CoinMarket.Pages;



import com.CoinMarket.Pojo.CryptoCurrency;
import com.CoinMarket.Utilities.BrowserUtils;
import com.CoinMarket.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class HomePage extends BasePage {
    private static HomePage login;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[4]/button")
    public WebElement nextBtn;
    @FindBy(xpath = "//button[contains(@class,'jgNqHP')]")
    public List<WebElement> rows;
    @FindBy(xpath = "//li[contains(@class,'filter')]//div//span//button")
    public List<WebElement> filterOptions;
    @FindBy(xpath = "//ul//li//li")
    public List<WebElement> popularAlgorithms;
    @FindBy(xpath = "//div//button")
    public List<WebElement> rangeFilterCrypto;
    @FindBy(xpath = "//tbody")
    public WebElement tableContent;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[3]/div[1]/div")
    public WebElement showRows;
    @FindBy(xpath = "/html/body/div[3]/div[2]/div[4]/button")
    public WebElement goItBtn;
    @FindBy(xpath = "//*[@id=\"cmc-cookie-policy-banner\"]/div[2]")
    public WebElement cookieBanner;
    @FindBy(xpath = "//label[@id='mineable']")
    public WebElement toggleMnineable;
    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div[2]/button[2]")
    public WebElement maybeLater;
    @FindBy(xpath = "//div//input[@data-qa-id='range-filter-input-min']")
    public WebElement rangeFilterInputMin;
    @FindBy(xpath = "//div//input[@data-qa-id='range-filter-input-max']")
    public WebElement rangeFilterInputMax;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[5]/div/div/div[2]/div/div[4]/div[2]/div/button[1]")
    public WebElement applyPriceRangeFilter;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[5]/div/div/div[2]/div[2]/button[1]")
    public WebElement showResults;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div/span")
    public WebElement pageUpArrrow;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[5]/div/div/div[2]/div[1]/div[1]/button/div")
    public WebElement allCryptoCurrencies;


    public void closeGetMoreOutOfOurSearchFeaturePopUp() {
        BrowserUtils.waitForClickablility(nextBtn, Duration.ofSeconds(5));
        if (nextBtn.isDisplayed()) {
            nextBtn.click();
        }
    }

    public void closeMakeThisTableWorkForYou() {
        BrowserUtils.waitForClickablility(goItBtn, Duration.ofSeconds(5));
        if (goItBtn.isDisplayed()) {
            goItBtn.click();
        }
    }

    public void closeCookiePolicyBanner() {
        BrowserUtils.waitForClickablility(cookieBanner, Duration.ofSeconds(5));
        if (cookieBanner.isDisplayed())
        {
            cookieBanner.click();
        }
    }

    public void applyFilters() throws InterruptedException {
        BrowserUtils.clickWithWait(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[3]/div[2]/button[1]"),10);

    }

    public void filterByNumberOfRows(String rowNumber) {
        BrowserUtils.clickWithJS(showRows);
        BrowserUtils.waitFor(3);
        BrowserUtils.ClickAddFilterOption(rowNumber, rows);

    }

    public void applyFilters(String filterName) throws InterruptedException {
        BrowserUtils.ScrollUp();
        BrowserUtils.ClickAddFilterOption(filterName, filterOptions);
    }

    public void applyAlgorithms(String algorithmName) {
        BrowserUtils.ClickAddFilterOption(algorithmName, popularAlgorithms);
    }

    public void clickMineable(String mineable) {
        addMoreFilters(mineable);
    }

    public void clickAllCryp(String allCryptocurrencies) {

        addMoreFilters(allCryptocurrencies);
    }

    public void selectCoin(String currencyOption) {
        BrowserUtils.ClickAddFilterOption(currencyOption,rangeFilterCrypto);
    }

    public void selectPrice(String price) {
        addMoreFilters(price);
    }

    public void senKeysPriceRange(String min, String max) {
        BrowserUtils.clickWithTimeOut(rangeFilterInputMin, 3);
        rangeFilterInputMin.sendKeys(min);
        BrowserUtils.clickWithTimeOut(rangeFilterInputMax, 3);
        rangeFilterInputMax.sendKeys(max);
    }

    public void applyPriceRageFilter() {
        BrowserUtils.clickWithJS(applyPriceRangeFilter);
    }

    public void applyShowResults() {
       BrowserUtils.waitFor(3);
       BrowserUtils.doubleClick(showResults);
    }
    public void scrollToUpToPage() {
        BrowserUtils.waitForClickablility(showRows, Duration.ofSeconds(5));
        if (showRows.isDisplayed()) {
            BrowserUtils.scrollToElement(showRows);
        }
    }
    public void clickUp(){
    BrowserUtils.waitForClickablility(pageUpArrrow,Duration.ofSeconds(3));
    pageUpArrrow.click();
}
    public List<CryptoCurrency> getTableData() {
        BrowserUtils.waitForPageToLoad(Duration.ofSeconds(3));
        List<CryptoCurrency> data = new ArrayList<>();
        List<WebElement> elements = tableContent.findElements(By.xpath("//tbody//tr"));
        BrowserUtils.waitForPageToLoad(Duration.ofSeconds(3));
        for (int i = 1; i<= elements.size(); i++) {
            try {
                CryptoCurrency currency = getCryptoCurrency(i);
                data.add(currency);
            } catch (Exception e) {
                try {
                    if(elements.size()>2){
                        BrowserUtils.ScrollDown();
                    }else{
                        pageUpArrrow.click();
                    }
                    CryptoCurrency currency = getCryptoCurrency(i);
                    data.add(currency);
                    BrowserUtils.doubleClick(pageUpArrrow);
                    if (data.size()==elements.size()){
                        break;
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        return data;
    }

    private static CryptoCurrency getCryptoCurrency(int i) {
        BrowserUtils.waitForVisibility(Driver.get().findElement(By.xpath("//tbody/tr[" + i + "]/td[3]/div/a/div/div/p")),Duration.ofSeconds(50));

        final String name = Driver.get().findElement(By.xpath("//tbody/tr[" + i + "]/td[3]/div/a/div/div/p")).getText();
        final String pricetext = Driver.get().findElement(By.xpath("//tbody/tr["+ i +"]/td[4]/div/a/span")).getText();
        final String marketCap = Driver.get().findElement(By.xpath("//tbody/tr["+ i +"]/td[8]/p/span[1]")).getText();
        CryptoCurrency currency = new CryptoCurrency(name, pricetext, marketCap);
        final NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
        try {
            currency.setAmount(currencyInstance.parse(currency.getCurrencyPrice()).doubleValue());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return currency;
    }
 private static void addMoreFilters(String filterOption)
 {
     String costumLocator="//button[@data-qa-id='filter-dd-toggle' and text()='"+filterOption+"']";
     System.out.println("string custom locator"+costumLocator);
      WebElement optionWE=Driver.get().findElement(By.xpath(costumLocator));
    optionWE.click();
 }
    public void applyAddFilter() {
        BrowserUtils.clickWithWait(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/ul/li[5]/button"),1);
    }
}
