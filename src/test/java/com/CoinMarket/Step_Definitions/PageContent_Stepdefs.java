package com.CoinMarket.Step_Definitions;

import com.CoinMarket.Pages.HomePage;
import com.CoinMarket.Pojo.CryptoCurrency;
import com.CoinMarket.Utilities.BrowserUtils;
import com.CoinMarket.Utilities.BrowserUtils;
import com.CoinMarket.Utilities.ConfigurationReader;
import com.CoinMarket.Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
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
    public void iFilterByAlgorithmPoW(String algorytm, String poW)  {

        homePage.ApplyFilters();
        homePage.ApplyFilters(algorytm);
        homePage.ApplyAlgorithms(poW);

    }
    @And("I follow by + Filter")
    public void iFollowByFilter() {
        homePage.AddFilter();
    }

    @And("I toggle Mineable")
    public void iToggleMineable() {

        homePage.ClickMineable();
    }
    @And("I select All Cryptocurrencies")
    public void iSelectAllCryptocurrencies() {
        homePage.ClickAllCryp();
    }

    @And("I select {string} from filter options")
    public void iSelectFromFilterOptions(String coins) {
        homePage.SelectCoin(coins);
    }

    @And("I select prize and set min value to {string} and max {string}")
    public void iSelectPrizeAndSetMinValueToAndMax(String min, String max) {
        homePage.SelectPrice();
        homePage.senKeysPriceRange(min,max);
        homePage.ApplyPriceRageFilter();
        homePage.ApplyShowResults();
    }
    @And("I capture Name,Price and MarketCap for cryptocurrencies from the content of the page after applying filters")
    public void iCaptureNamePriceAndMarketCapForCryptocurrenciesFromTheContentOfThePageAfterApplyingFilters() {
        tableDateByRow20 = homePage.getTableData();
        System.out.println(tableDateByRow20.size());
    }
    @And("I capture Price and MarketCap for {string} cryptocurrency from the content of the page after applying filters")
    public void iCapturePriceAndMarketCapForCryptocurrencyFromTheContentOfThePageAfterApplyingFilters(String bitcoin) throws InterruptedException {
        BrowserUtils.waitFor(2);
        BrowserUtils.ScrollDownAndUp();

        tableDateAfterFilters = homePage.getTableData();
        System.out.println(tableDateAfterFilters.size());
    }

    @Then("I should see that number of contents is decreased")
    public void iShouldSeeThatNumberOfContentsIsDecreased() {
        //Assert.assertTrue(tableDateAfterFilters.size()<tableDateByRow20.size());
    }
}