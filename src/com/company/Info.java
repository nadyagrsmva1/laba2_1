package com.company;

public class Info {
    private String name;
    private String manufacturer;
    private Integer quantity;
    private Integer price;
    public Info(String name, String manufacturer, Integer quantity, Integer price){
        this.name = name;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.price = price;
    }
    public Info() {
        this("","",0,0);
    }
    public String GetName(){
    return name;
    }
    public String GetManufacturer(){
        return manufacturer;
    }
    public Integer GetQuantity(){
        return quantity;
    }
    public Integer GetPrice(){
        return price;
    }
    public void SetName(String newName){
        this.name = newName;
    }
    public void SetManufacturer(String newManufacturer){
        this.manufacturer = newManufacturer;
    }
    public void SetQuantity(Integer newQuantity){
        this.quantity = newQuantity;
    }
    public void SetPrice(Integer newPrice){
        this.price = newPrice;
    }

    public String toString(){
        return name + " " + manufacturer + " " + quantity + " " + price;
    }
}