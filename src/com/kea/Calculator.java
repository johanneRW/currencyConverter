package com.kea;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Rateinfo> rateinfos;
    private RateList rateList = new RateList();

    public Calculator() {
        rateinfos = rateList.loadRates();
    }

    private double stringToDouble(String rateAsString) {
        rateAsString=rateAsString.replace(",",".");
        double rate = Double.parseDouble(rateAsString);
        return rate;
    }

    public double findRate(String input) {
        String rate = null;

        for (Rateinfo rateinfo : rateinfos) {
            String currentName = rateinfo.getDesc();
            String currentCode=rateinfo.getCode();
            if (currentName.equalsIgnoreCase(input)||currentCode.equalsIgnoreCase(input)) {
                rate = rateinfo.getRate();
            }
        }
        double rateAsDouble =stringToDouble(rate);
        return rateAsDouble;
    }


    private double convertFromDkk(double amount, double wantRate){
        double exchangeRate = wantRate / 100.0;
        double result = amount / exchangeRate;
        return result;
    }

    private double convertToDkk(double amount, double haveRate) {
        double exchangeRate = haveRate / 100.0;
        double result = amount * exchangeRate;
        return result;
    }

    private double convertOther(double amount, double haveRate, double wantRate) {
        double haveInDkk = convertToDkk(amount, haveRate);
        double result = convertFromDkk(haveInDkk, wantRate);
        return result;
    }

    public double convert(double haveAmount, double haveRate, double wantRate) {
        if (haveRate == 100) {
            return convertFromDkk(haveAmount, wantRate);
        } else if (wantRate == 100) {
            return convertToDkk(haveAmount, haveRate);
        } else {
            return convertOther(haveAmount, haveRate, wantRate);
        }
    }
}
