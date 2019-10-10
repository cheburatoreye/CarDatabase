package com.company;

public interface Crud {
    void buildcar();
    void redactcar(String vin);
    void createcar(String vin);
    void createcar2(String vin,
                    String number ,
                    String mark ,
                    String model ,
                    String mileage,
                    String year,
                    String color ,
                    String body ,
                    String price );
    void readcar(String vin);
    void updatecar(String vin);
    void deletecarByVin(String vin);
    void deletecarByNumber(String number);
    void deleteByMarkModel(String mark,String model);
    void deletecarByMileage(String mileagestart,String mileageend);
    void deleteByYear(String yearstart,String yearend);
    void deleteByPrice(String pricestart,String priceend);
    void deleteAll();

    void showAll();
    void showByMark(String mark);
    void showByNumber(String number);
    void showByYear(String yearstart,String yearend);
    void showByMileage(String mileagestart,String mileageend);
    void showByPrice(String pricestart,String priceend);
    void showByMarkModel(String mark,String model);
}
