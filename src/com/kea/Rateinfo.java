package com.kea;

public class Rateinfo {
    private String code;
    private String desc;
    private String rate;

    /**
     * @param code Kode der anvendes for denne valuta
     * @param desc Beskrivelse til valuta
     * @param rate Antal danske kr for 100 af den valuta vi omregner til
     */
    public Rateinfo(String code, String desc, String rate) {
        this.code = code;
        this.desc = desc;
        this.rate = rate;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Rateinfo " + code + ", " + desc + ", " + rate;
    }
}
