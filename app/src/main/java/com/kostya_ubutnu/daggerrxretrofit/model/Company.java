package com.kostya_ubutnu.daggerrxretrofit.model;

public class Company {
    String name,catсhPhrase,bs;

    public Company(String name, String catсhPhrase, String bs) {
        this.name = name;
        this.catсhPhrase = catсhPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatсhPhrase() {
        return catсhPhrase;
    }

    public void setCatсhPhrase(String catсhPhrase) {
        this.catсhPhrase = catсhPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
