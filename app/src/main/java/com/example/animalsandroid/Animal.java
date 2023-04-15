package com.example.animalsandroid;

public class Animal {
    private String name;
    private String continent;
    public Animal(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
    public String getName() {
        return name;
    }
    public String getContinent() {
        return continent;
    }
    public int getBackgroundColor() {
        int backgroundColor = R.color.colorAmerica;
        switch (continent) {
            case "Africa":
                backgroundColor = R.color.colorAfrica;
                break;
            case "Asia":
                backgroundColor = R.color.colorAsia;
                break;
            case "Europa":
                backgroundColor = R.color.colorEuropa;
                break;
            case "America":
                backgroundColor = R.color.colorAmerica;
                break;
            case "Australia":
                backgroundColor = R.color.colorAustralia;
                break;
        }
        return backgroundColor;
    }

}
