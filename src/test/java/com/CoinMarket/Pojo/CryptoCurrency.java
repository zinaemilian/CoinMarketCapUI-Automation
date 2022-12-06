package com.CoinMarket.Pojo;

public class CryptoCurrency {
    public String currencyName;
    public String currencyCode;
    public String currencyPrice;
    public String currencyMarketCap;

    public CryptoCurrency() {
    }

    public CryptoCurrency(String currencyName, String currencyCode, String currencyPrice, String currencyMarketCap) {
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
        this.currencyPrice = currencyPrice;
        this.currencyMarketCap = currencyMarketCap;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyPrice() {
        return currencyPrice;
    }

    public void setCurrencyPrice(String currencyPrice) {
        this.currencyPrice = currencyPrice;
    }

    public String getCurrencyMarketCap() {
        return currencyMarketCap;
    }

    public void setCurrencyMarketCap(String currencyMarketCap) {
        this.currencyMarketCap = currencyMarketCap;
    }
}
