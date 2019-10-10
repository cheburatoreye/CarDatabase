package com.company;

import java.util.Scanner;

public class MenuSearch implements MenuState {

    @Override
    public void next(Menu menu) {
    menu.setState(new MenuSubSearch());
    }

    @Override
    public void previous(Menu menu) {

    }

    @Override
    public void printState() {
        System.out.println("\n"+"Menu search: ");
        System.out.println("1-search by VIN");
        System.out.println("2-search by number");
        System.out.println("3-search by mark and model");
        System.out.println("4-search by year");
        System.out.println("5-search by mileage");
        System.out.println("6-search by price");
        System.out.println("7-show all cars");
        System.out.println("8-search by mark");
        System.out.println("0-back");
        System.out.println("make your chose: ");

    }
}
