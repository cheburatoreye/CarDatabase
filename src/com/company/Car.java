package com.company;

import java.util.Objects;

public class Car {

    private String vin;
    private String number;
    private String mark;
    private String model;
    private String mileage;
    private String year;
    private String color;
    private String body;
    private String price;


    public Car(String vin, String number, String mark, String model, String mileage, String year, String color, String body, String price) {
        this.vin = vin;
        this.number = number;
        this.mark = mark;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.color = color;
        this.body = body;
        this.price = price;
    }

    void print(){
        System.out.println("\n"+"Car data: ");
        System.out.println("\n"+"VIN: "+getVin());
        System.out.println("NUMBER: "+getNumber());
        System.out.println("MARK: "+getMark());
        System.out.println("MODEL: "+getModel());
        System.out.println("MILEAGE: "+getMileage()+" kilometers");
        System.out.println("YEAR: "+getYear());
        System.out.println("COLOR: "+getColor());
        System.out.println("BODY: "+getBody());
        System.out.println("PRICE: "+getPrice()+"\n");
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", number='" + number + '\'' +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", mileage='" + mileage + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                ", body='" + body + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(vin, car.vin) &&
                Objects.equals(number, car.number) &&
                Objects.equals(mark, car.mark) &&
                Objects.equals(model, car.model) &&
                Objects.equals(mileage, car.mileage) &&
                Objects.equals(year, car.year) &&
                Objects.equals(color, car.color) &&
                Objects.equals(body, car.body) &&
                Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin, number, mark, model, mileage, year, color, body, price);
    }

    protected String getVin() {
        return vin;
    }

    protected void setVin(String vin) {
        this.vin = vin;
    }

    protected String getNumber() {
        return number;
    }

    protected void setNumber(String number) {
        this.number = number;
    }

    protected String getMark() {
        return mark;
    }

    protected void setMark(String mark) {
        this.mark = mark;
    }

    protected String getModel() {
        return model;
    }

    protected void setModel(String model) {
        this.model = model;
    }

    protected String getMileage() {
        return mileage;
    }

    protected void setMileage(String mileage) {
        this.mileage = mileage;
    }

    protected String getYear() {
        return year;
    }

    protected void setYear(String year) {
        this.year = year;
    }

    protected String getColor() {
        return color;
    }

    protected void setColor(String color) {
        this.color = color;
    }

    protected String getBody() {
        return body;
    }

    protected void setBody(String body) {
        this.body = body;
    }

    protected String getPrice() {
        return price;
    }

    protected void setPrice(String price) {
        this.price = price;
    }
}
