package com.CoinMarket.Pages;

import com.CoinMarket.Utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    //private BrowserUtils _browserUtil;
   // private WebUtilities _webUtil;

   // private WebDriver driver;
    /*The initElements() method of PageFactory class is
    used to initialize WebElements declared in the page class.
    It is a static method. That's why we call it using the class name.
    It is called inside a constructor that will automatically initialize all the elements
    in the page class when it is instantiated.*/
    //public LoginPage(WebDriver driver) {
    //		this.driver = driver;
    //	}

  public BasePage() {PageFactory.initElements(Driver.get(), this);}








}
