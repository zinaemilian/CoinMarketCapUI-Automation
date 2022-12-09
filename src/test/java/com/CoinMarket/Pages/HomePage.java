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
    @FindBy(xpath = "//li")
    public List<WebElement> algorithOptns;
    @FindBy(xpath = "//tbody")
    public WebElement tableContent;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[3]/div[1]/div")
    public WebElement showRows;
    @FindBy(xpath = "/html/body/div[3]/div[2]/div[4]/button")
    public WebElement goItBtn;
    @FindBy(xpath = "//*[@id=\"cmc-cookie-policy-banner\"]/div[2]")
    public WebElement cookieBanner;
    @FindBy(xpath = "(//button[contains(@class,'sc-a4a6801b-0 gNHIvn sc-cc37dd9f-0 sc-7b31fd38-0 cmPAGl')])[4]")
    public WebElement addFilterBtn;
    @FindBy(xpath = "(//label[contains(@class,'sc-f3593cc1-1 jZWMqF switch-label')])[1]")
    public WebElement toggleMnineable;
    @FindBy(xpath = "//button[contains(@class,'sc-a4a6801b-0 ccMCCm') and text()='Maybe later']")
    public WebElement maybeLater;
    @FindBy(xpath = "(//*[contains(@class,'sc-aef7b723-0 dsDrxm') and contains(@viewBox,'0 0 24 24')])[2]")
    public WebElement filterActiveOptnFirst;
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
    @FindBy(className = "icon-Chevron-up")
    public WebElement pageUpArrrow;


  public WebElement allCryptoCurrenciesMoreFiltersGetText(String option) {
        String costumCurrenciesName = "//button[contains(@class,'sc-a4a6801b-0 bcMxzk cmc-option-button') and text()='" + option + "']";
        Driver.get().findElement(By.xpath(costumCurrenciesName));
        return Driver.get().findElement(By.xpath(costumCurrenciesName));
    }

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
        if (cookieBanner.isDisplayed()) {
            cookieBanner.click();
        }
    }

    public void ApplyFilters() {

        pageUpArrrow.click();
        BrowserUtils.clickWithJS(Driver.get().findElement( By.xpath("(//button[contains(@class,'sc-a4a6801b-0 gNHIvn sc-c8c9e58f-0 eTWSGQ table-control-filter')])[2]")));

    }

    public void filterByNumberOfRows(String rowNumber) {

        BrowserUtils.clickWithJS(showRows);
        BrowserUtils.waitFor(3);
        BrowserUtils.ClickAddFilterOption(rowNumber, rows);

    }

    public void ApplyFilters(String filterName) {

        BrowserUtils.waitForPageToLoad(Duration.ofSeconds(3));
        BrowserUtils.ClickAddFilterOption(filterName, filterOptions);
    }

    public void ApplyAlgorithms(String algorithmName) {
        BrowserUtils.waitFor(3);
        BrowserUtils.ByExactOption(algorithmName, algorithOptns);
    }

    public void AddFilter() {
        BrowserUtils.waitFor(3);
        BrowserUtils.waitForClickablility(addFilterBtn, Duration.ofSeconds(5));
        BrowserUtils.clickWithJS(addFilterBtn);
    }

    public void ClickMineable() {

        BrowserUtils.waitForClickablility(toggleMnineable, Duration.ofSeconds(5));
        BrowserUtils.clickWithJS(toggleMnineable);
       
    }

    public void ClickAllCryp() {
        BrowserUtils.waitFor(3);
        filterActiveOptnFirst.click();
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithTimeOut(filterActiveOptnFirst,5);
        filterActiveOptnFirst.click();
    }

    public void SelectCoin(String currencyOption) {
        BrowserUtils.waitFor(3);
        allCryptoCurrenciesMoreFiltersGetText(currencyOption).click();
    }

    public void SelectPrice() {
        BrowserUtils.clickWithTimeOut(pricebtn, 3);
        
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
        BrowserUtils.clickWithTimeOut(applyPriceRangeFilter, 3);
       
    }

    public void ApplyShowResults() {
        BrowserUtils.waitForClickablility(showResults, Duration.ofSeconds(2));
        BrowserUtils.clickWithTimeOut(showResults, 3);

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
        List<CryptoCurrency> data = new ArrayList<>();
        List<WebElement> elements = tableContent.findElements(By.xpath("//tbody//tr"));
        BrowserUtils.waitForPageToLoad(Duration.ofSeconds(1));
        for (int i = 1; i<= elements.size(); i++) {
            try {
                CryptoCurrency currency = getCryptoCurrency(i);
                data.add(currency);
            } catch (Exception e) {
                try {
                    //BrowserUtils.waitFor(2);

                   BrowserUtils.ScrollDown();
                    CryptoCurrency currency = getCryptoCurrency(i);
                    data.add(currency);
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

}
