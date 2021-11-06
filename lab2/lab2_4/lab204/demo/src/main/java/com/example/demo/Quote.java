package com.example.demo;

public class Quote {
    private final String quote;
    private final String role;
    private final String show;
    private final boolean contain_adult_lang;

    public Quote(String quote, String role, String show, boolean contain_adult_lang) {
        this.quote = quote;
        this.role = role;
        this.show = show;
        this.contain_adult_lang = contain_adult_lang;
    }

    public String getQuote() {
        return this.quote;
    }


    public String getRole() {
        return this.role;
    }


    public String getShow() {
        return this.show;
    }


    public boolean isContain_adult_lang() {
        return this.contain_adult_lang;
    }

}
