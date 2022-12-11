package com.CoinMarket.Step_Definitions;

import com.CoinMarket.Pages.HomePage;
import com.CoinMarket.Pojo.CryptoCurrency;
import com.CoinMarket.Utilities.BrowserUtils;
import com.CoinMarket.Utilities.ConfigurationReader;
import com.CoinMarket.Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class PageContent_Stepdefs {
  HomePage homePage =new HomePage();
    private List<CryptoCurrency> tableDateByRow20;
    private List<CryptoCurrency> tableDateAfterFilters;

    @Given("I navigate to the home page")
    public void iNavigateToTheHomePage()  {
        Driver.get().get(ConfigurationReader.get("url"));
        homePage.closeGetMoreOutOfOurSearchFeaturePopUp();
        homePage.closeMakeThisTableWorkForYou();
        homePage.closeCookiePolicyBanner();

    }

    @When("I show rows by {string}")
    public void iShowRowsBy(String rowNumber) {
        homePage.filterByNumberOfRows(rowNumber);
        homePage.scrollToUpToPage();

    }
    @And("I capture Name,Price and MarketCap for cryptocurrencies from the content of the page before applying filters")
    public void iCaptureNamePriceAndMarketCapForCryptocurrenciesFromTheContentOfThePageBeforeApplyingFilters() {
        tableDateByRow20 = homePage.getTableData();
    }
    @And("I filter by {string} - {string}")
    public void iFilterByAlgorithmPoW(String algorytm, String poW) throws InterruptedException {
        homePage.applyFilters();
        homePage.applyFilters(algorytm);
        homePage.applyAlgorithms(poW);
    }
    @And("I follow by Add Filter")
    public void iFollowByAddFilter() {
        homePage.applyAddFilter();
    }
    @And("I toggle {string}")
    public void iToggle(String mineable) {
        homePage.clickMineable(mineable);
    }
    @And("I select {string}")
    public void iSelect(String allCryptoCurrencies) {
        homePage.clickAllCryp(allCryptoCurrencies);

    }
    @And("I select {string} from filter options")
    public void iSelectFromFilterOptions(String coins) {
        homePage.selectCoin(coins);
    }
    @And("I select {string} and set min value to {string} and max {string}")
    public void iSelectAndSetMinValueToAndMax(String price, String minAmount, String maxAmount) {
        homePage.selectPrice(price);
        homePage.senKeysPriceRange(minAmount,maxAmount);
        homePage.applyPriceRageFilter();
        homePage.applyShowResults();
    }

    @And("I capture Name,Price and MarketCap for cryptocurrencies from the content of the page after applying filters")
    public void iCaptureNamePriceAndMarketCapForCryptocurrenciesFromTheContentOfThePageAfterApplyingFilters() throws InterruptedException {
         homePage.clickUp();
         BrowserUtils.waitFor(3);
        tableDateAfterFilters = homePage.getTableData();
    }
    @Then("I should see that number of contents is decreased")
    public void iShouldSeeThatNumberOfContentsIsDecreased() {
        Assert.assertNotSame(tableDateAfterFilters,tableDateByRow20);
    }

}
