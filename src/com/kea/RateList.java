package com.kea;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class RateList {
    public ArrayList<Rateinfo> loadRates() {
        try {
            ArrayList<Rateinfo> rateinfos = new ArrayList();
            Rateinfo dkk = new Rateinfo("DKK", "Danske kroner", "100");
            rateinfos.add(dkk);

            //Instantiating the URL class
            URL url = new URL("https://www.nationalbanken.dk/_vti_bin/DN/DataService.svc/CurrencyRatesXML?lang=da");
            //Retrieving the contents of the specified page
            Scanner sc = new Scanner(url.openStream());

            int i = 0;
            String code = null;
            String desc = null;
            String rate;

            while (sc.hasNext()) {
                String t = sc.next();
                i++;

                if (i > 12 && i < 181) {
                    if (t.contains("code")) {
                        code = t.replaceAll("code=", "").replaceAll("\"", "");
                    } else if (t.contains("desc")) {
                        t = t.replaceAll("desc=", "").replaceAll("\"", "").replaceAll("�", "æ");
                        if (t.contains("Euro")) {
                            desc = t;
                        } else {
                            t = t + " " + sc.next();
                            t = t.replaceAll("\"", "");
                            desc = t;
                        }
                    } else if (t.contains("rate")) {
                        t = t.replaceAll("rate=", "").replaceAll("\"", "");
                        rate = t;
                        Rateinfo ri = new Rateinfo(code, desc, rate);
                        rateinfos.add(ri);
                    }
                }

            }
            return rateinfos;
        } catch (IOException e) {
            System.out.println("Couldn't load the data");
        }
        return null;
    }
}
