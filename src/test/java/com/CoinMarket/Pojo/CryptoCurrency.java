package com.CoinMarket.Pojo;

public class CryptoCurrency {
    private String currencyName;
    private String currencyPrice;

    private String currencyMarketCap;
    private double amount;

    public CryptoCurrency() {
    }

    public CryptoCurrency(String currencyName, String currencyPrice, String currencyMarketCap) {
        this.currencyName = currencyName;
        this.currencyPrice = currencyPrice;
        this.currencyMarketCap = currencyMarketCap;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
