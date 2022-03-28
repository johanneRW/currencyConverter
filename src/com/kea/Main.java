package com.kea;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Velkommen til valuta-omregneren");

        System.out.println("Hvilken valuta har du? (skriv forkortelse eller fulde navn)");
        String haveCurrency = scanner.nextLine();
        double haveRate = calculator.findRate(haveCurrency);

        System.out.println("Hvor mange " + haveCurrency + " har du? (brug punktum i stedet for komma)");
        String amountAsString = scanner.nextLine();
        double haveAmount = Double.parseDouble(amountAsString);

        System.out.println("Hvilken valuta vil du omregne til?");
        String wantCurrency = scanner.nextLine();
        double wantRate = calculator.findRate(wantCurrency);

        double resultAmount = calculator.convert(haveAmount, haveRate, wantRate);
        System.out.printf("Resultatet er: %.02f " + wantCurrency, resultAmount);
    }
}
