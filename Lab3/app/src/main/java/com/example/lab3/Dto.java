package com.example.lab3;

public class Dto {
    private String name;
    private String price_range;
    private String manufacturer;

    public Dto(String name, String price_range, String manufacturer) {
        this.name = name;
        this.price_range = price_range;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public String getPrice_range(){
        return price_range;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Dish: " + name + ", Price range: " + price_range + ", Manufactuter(s): " + manufacturer;
    }
}
