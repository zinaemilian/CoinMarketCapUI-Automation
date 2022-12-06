package com.CoinMarket.Step_Definitions;


import com.CoinMarket.Pages.HomePage;
import com.CoinMarket.Utilities.BrowserUtils;
import com.CoinMarket.Utilities.ConfigurationReader;
import com.CoinMarket.Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class PageContent_Stepdefs {
    HomePage homePage =new HomePage();
    List<String> pagePriceTextsFirst = new ArrayList<>();
    List<String> pagePriceTextsLast = new ArrayList<>();
    @Given("I navigate to the home page")
    public void iNavigateToTheHomePage()  {
        Driver.get().get(ConfigurationReader.get("url"));
        homePage.closeGetMoreOutOfOurSearchFeaturePopUp();
        System.out.println("Test is next");
        homePage.closeMakeThisTableWorkForYou();
        System.out.println("Test is click");
        homePage.closeCookiePolicyBanner();
        System.out.println("Test is cookie");
    }

    @When("I show rows by {string}")
    public void iShowRowsBy(String rowNumber) {

        homePage.filterByNumberOfRows(rowNumber);

    }

    @And("I capture all page content")
    public void iCaptureAllPageContent() {

      pagePriceTextsFirst= homePage.PageContentsMarketCap( "MarketCapFirst");
    }

    @And("I filter by {string} - {string}")
    public void iFilterByAlgorithmPoW(String algorytm, String poW)
    {
        homePage.ScrollUpToPage();
        homePage.ApplyFilters();
        System.out.println( "applyfilters");
        homePage.ApplyFilters(algorytm);
        System.out.println( "applyfilters by algorith");
        homePage.ApplyAlgorithms(poW);
        System.out.println( " aplyalgorith by Pow");
    }


    @And("I follow by {string}")
    public void iFollowBy(String arg0) {
        BrowserUtils.waitFor(3);
        homePage.AddFilter();
        System.out.println( "filter Added");

    }

    @And("I toggle {string}")
    public void iToggle(String arg0) {
        System.out.println( "Test is 3");
        homePage.ClickMineable();
      //  _homePage.ClickMaybeLater();

    }

    @And("I select {string}")
    public void iSelect(String arg0) {
        System.out.println( "Test is 4");
        homePage.ClickAllCryp();
    }



    @Then("I should see the comparisan is true")
    public void iShouldSeeTheComparisanIsTrue() {

      pagePriceTextsLast= homePage.PageContentsMarketCap("MarketCapLast");
    }


    @And("I select {string} from filter options")
    public void iSelectFromFilterOptions(String coins) {
        homePage.SelectCoin();
        System.out.println( "coin 5");
    }

    @And("I select prize and set min value to {string} and max {string}")
    public void iSelectPrizeAndSetMinValueToAndMax(String min, String max) {
        homePage.SelectPrice();
        homePage.senKeysPriceRange(min,max);
        homePage.ApplyPriceRageFilter();
        homePage.ApplyShowResults();
    }
}
