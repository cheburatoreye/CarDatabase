package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int exit=1;
        int search=0;
        int yearstart;
        int yearstop;
        int mileagestart;
        int mileagestop;
        int pricestart;
        int pricestop;
        String vin;
        String number;
        String mark;
        String model;
        String year_start;
        String year_stop;
        String mileage_start;
        String mileage_stop;
        String price_start;
        String price_stop;
        Scanner sc=new Scanner(System.in);
        Crud crud =new CarBuilder();
        crud.createcar2("OEIHFUIUE945995","ВН4568ОУ","BMW","I3","123544","1985","red","sedan","500");
        crud.createcar2("TGHEDSWIUE9434652","ВН5555ОУ","OPEL","ZAFIRA","100654","1989","GREE","sedan","800");
        crud.createcar2("OCEDFUIUE947952","ВН3214ОУ","OPEL","VECTRA","122654","1989","blue","sedan","2000");
        crud.createcar2("TLHLTKELW568345","ВН32456ОУ","TOYOTA","COROLLA","320214","1996","grey","sedan","3000");
        crud.createcar2("JSJFGKELW216448","ВН8523ОУ","TOYOTA","COROLLA","300214","1995","grey","sedan","2000");
        Menu menu=new Menu();

        while (exit==1){

            switch (search){
                case 0:{
                    menu.setState(new MenuStart());
                    menu.printState();
                    search = sc.nextInt();
                    break;
                }
                case 1:{
                    menu.setState(new MenuSearch());
                    menu.printState();
                    search = sc.nextInt();
                    switch (search){
                        case 1:{
                            if (search==1){
                                menu.next();
                                menu.printState();
                                vin = sc.next();
                                if (vin.equals("0")){
                                    search=0;
                                }
                                else {
                                        System.out.println( "Enter VIN for search or type 0 to go back .");
                                        if (!vin.equals("0")){
                                            crud.readcar(vin);
                                        }
                                }
                                if (search==0){
                                    menu.previous();
                                    search=1;
                                }
                            }
                            break;
                        }
                        case 2:{
                                System.out.println( "Enter car number for search or type 0 to go back .");
                                number=sc.next();
                                if (!number.equals("0")){
                                    crud.showByNumber(number);
                                }
                            search=1;
                            break;
                        }
                        case 3:{
                            do {
                                System.out.println( " First enter car mark than type model for search or type 0 to go back .");
                                mark=sc.next();
                                if ((!mark.equals("0"))){
                                    System.out.println("Now type MODEL: ");
                                    model=sc.next();
                                    System.out.println("Entered car MARK: "+" " +mark+".");
                                    System.out.println("Entered car MODEL: " +model+".");
                                    if ((mark.equals("0"))||(model.equals("0"))){
                                        System.out.println("Entered data wrong try again.");}
                                    else{
                                        System.out.println("Type 1 to search using this data or 0 to go back.");
                                        search=sc.nextInt();
                                        if (search==1){ System.out.println("searching...");
                                            crud.showByMarkModel(mark,model);
                                            System.out.println("car not found.");}
                                    }
                                }
                                else{search=0;mark="0";model="0";}
                            }while ((!mark.equals("0"))&&(!model.equals("0"))&&((search!=0)));
                            search=1;
                            break;
                        }
                        case 4:{
                            do {
                                System.out.println( "Enter car year start searching than type end year or type 0 to go back .");
                                search=yearstart=sc.nextInt();
                                if ((search!=0)){
                                    year_start = Integer.toString(search);
                                    System.out.println("Now type end year: ");
                                    search=yearstop=sc.nextInt();
                                    year_stop = String.valueOf(search);
                                    System.out.println("Searching year from: "+" " +year_start+".");
                                    System.out.println("Searching year to: " +year_stop+".");
                                    if ((year_start.equals("0"))||(year_stop.equals("0"))||((yearstart>yearstop))){
                                        System.out.println("Entered data wrong try again.");}
                                    else{
                                        System.out.println("Type 1 to search using this data or 0 to go back.");
                                        search=sc.nextInt();
                                        if (search==1){ System.out.println("searching...");
                                            crud.showByYear(year_start,year_stop);
                                            System.out.println("car not found.");}
                                    }
                                }
                                else{search=0;year_start="0";year_stop="0";}
                            }while ((!year_start.equals("0"))&&(!year_stop.equals("0"))&&((search!=0)));
                            search=1;
                            break;
                        }
                        case 5:{
                            do {
                                System.out.println( "Enter car mileage start searching than type end mileage or type 0 to go back .");
                                search=mileagestart=sc.nextInt();
                                if ((search!=0)){
                                    mileage_start = Integer.toString(search);
                                    System.out.println("Now type end mileage: ");
                                    search=mileagestop=sc.nextInt();
                                    mileage_stop = String.valueOf(search);
                                    System.out.println("Searching mileage from: "+" "+mileage_start+".");
                                    System.out.println("Searching mileage to: " +mileage_stop+".");
                                    if ((mileage_start.equals("0"))||(mileage_stop.equals("0"))||((mileagestart>mileagestop))){
                                        System.out.println("Entered data wrong try again.");}
                                    else{
                                        System.out.println("Type 1 to search using this data or 0 to go back.");
                                        search=sc.nextInt();
                                        if (search==1){ System.out.println("searching...");
                                            crud.showByMileage(mileage_start,mileage_stop);
                                            System.out.println("car not found.");}
                                    }
                                }
                                else{search=0;mileage_start="0";mileage_stop="0";}
                            }while ((!mileage_start.equals("0"))&&(!mileage_stop.equals("0"))&&((search!=0)));
                            search=1;
                            break;
                        }
                        case 6:{
                            do {
                                System.out.println( "Enter car price start searching than type end price or type 0 to go back .");
                                search=pricestart=sc.nextInt();
                                if ((search!=0)){
                                    price_start = Integer.toString(search);
                                    System.out.println("Now type end price: ");
                                    search=pricestop=sc.nextInt();
                                    price_stop = String.valueOf(search);
                                    System.out.println("Searching price from: "+" "+price_start+".");
                                    System.out.println("Searching price to: " +price_stop+".");
                                    if ((price_start.equals("0"))||(price_stop.equals("0"))||((pricestart>pricestop))){
                                        System.out.println("Entered data wrong try again.");}
                                    else{
                                        System.out.println("Type 1 to search using this data or 0 to go back.");
                                        search=sc.nextInt();
                                        if (search==1){ System.out.println("searching...");

                                            crud.showByPrice(price_start,price_stop);
                                            System.out.println("car not found.");}
                                    }
                                }
                                else{search=0;price_start="0";price_stop="0";}
                            }while ((!price_start.equals("0"))&&(!price_stop.equals("0"))&&((search!=0)));
                            search=1;
                            break;
                        }
                        case 7:{
                            System.out.println( "The list of the cars in database: ");
                            crud.showAll();
                            search=1;
                            break;
                        }
                        case 8:{
                            do {
                                System.out.println( " First enter car mark for search or type 0 to go back .");
                                mark=sc.next();
                                if ((!mark.equals("0"))){
                                    System.out.println("Entered car MARK: "+" " +mark+".");

                                    if ((mark.equals("0"))){
                                        System.out.println("Entered data wrong try again.");}
                                    else{
                                        System.out.println("Type 1 to search using this data or 0 to go back.");
                                        search=sc.nextInt();
                                        if (search==1){ System.out.println("searching...");
                                            crud.showByMark(mark);
                                            System.out.println("car not found.");}
                                    }
                                }
                                else{search=0;mark="0";model="0";}
                            }while ((!mark.equals("0"))&&((search!=0)));
                            search=1;
                            break;
                        }
                    }
                    break;
                }
                case 2:{
                    menu.setState(new MenuAddingCars());
                    menu.printState();
                    crud.buildcar();
                    search=0;
                    break;
                }
                case 3:{
                    menu.setState(new MenuRedacting());
                    menu.printState();
                    do {
                        System.out.println( "Enter car VIN to redact car information or 0 to go back .");
                        vin=sc.next();
                        if (!vin.equals("0")){
                            crud.updatecar(vin);
                        }
                    }while (!vin.equals("0"));
                    search=0;
                    break;
                }
                case 4:{
                    menu.setState(new MenuDeleting());
                    menu.printState();
                    search = sc.nextInt();
                    switch (search){
                        case 1:{
                            do {
                                System.out.println( "Enter VIN for delete or type 0 to go back .");
                                vin=sc.next();
                                if (!vin.equals("0")){
                                    crud.deletecarByVin(vin);
                                }
                            }while (!vin.equals("0"));
                            search = 4;
                            break;
                        }
                        case 2:{
                            do {
                                System.out.println( "Enter car number for delete or type 0 to go back .");
                                number=sc.next();
                                if (!number.equals("0")){
                                    crud.deletecarByNumber(number);
                                }
                            }while (!number.equals("0"));
                            search = 4;
                            break;
                        }
                        case 3:{
                            do {
                                System.out.println( " First enter car mark than type model for deleting or type 0 to go back .");
                                mark=sc.next();
                                if ((!mark.equals("0"))){
                                    System.out.println("Now type MODEL: ");
                                    model=sc.next();
                                    System.out.println("Entered car MARK: "+" " +mark+".");
                                    System.out.println("Entered car MODEL: " +model+".");
                                    if ((mark.equals("0"))||(model.equals("0"))){
                                        System.out.println("Entered data wrong try again.");}
                                    else{
                                        System.out.println("Type 1 to delete using this data or 0 to go back.");
                                        search=sc.nextInt();
                                        if (search==1){ System.out.println("deleting...");
                                            crud.deleteByMarkModel(mark,model);
                                        }
                                    }
                                }
                                else{search=0;mark="0";model="0";}
                            }while ((!mark.equals("0"))&&(!model.equals("0"))&&((search!=0)));
                            search = 4;
                            break;
                        }
                        case 4:{
                            do {
                                System.out.println( "Enter car mileage start deleting than type end mileage or type 0 to go back .");
                                search=mileagestart=sc.nextInt();
                                if ((search!=0)){
                                    mileage_start = Integer.toString(search);
                                    System.out.println("Now type end mileage: ");
                                    search=mileagestop=sc.nextInt();
                                    mileage_stop = String.valueOf(search);
                                    System.out.println("Deleting mileage from: "+" "+mileage_start+".");
                                    System.out.println("Deleting mileage to: " +mileage_stop+".");
                                    if ((mileage_start.equals("0"))||(mileage_stop.equals("0"))||((mileagestart>mileagestop))){
                                        System.out.println("Entered data wrong try again.");}
                                    else{
                                        System.out.println("Type 1 to deleting using this data or 0 to go back.");
                                        search=sc.nextInt();
                                        if (search==1){ System.out.println("deleting...");
                                            crud.deletecarByMileage(mileage_start,mileage_stop);
                                        }
                                    }
                                }
                                else{search=0;mileage_start="0";mileage_stop="0";}
                            }while ((!mileage_start.equals("0"))&&(!mileage_stop.equals("0"))&&((search!=0)));
                            search = 4;
                            break;
                        }
                        case 5:{
                            do {
                                System.out.println( "Enter car price start deleting than type end price or type 0 to go back .");
                                search=pricestart=sc.nextInt();
                                if ((search!=0)){
                                    price_start = Integer.toString(search);
                                    System.out.println("Now type end price: ");
                                    search=pricestop=sc.nextInt();
                                    price_stop = String.valueOf(search);
                                    System.out.println("Deleting price from: "+" "+price_start+".");
                                    System.out.println("Deleting price to: " +price_stop+".");
                                    if ((price_start.equals("0"))||(price_stop.equals("0"))||((pricestart>pricestop))){
                                        System.out.println("Entered data wrong try again.");}
                                    else{
                                        System.out.println("Type 1 to search using this data or 0 to go back.");
                                        search=sc.nextInt();
                                        if (search==1){ System.out.println("deleting...");

                                            crud.deleteByPrice(price_start,price_stop);
                                            System.out.println("car not found.");}
                                    }
                                }
                                else{search=0;price_start="0";price_stop="0";}
                            }while ((!price_start.equals("0"))&&(!price_stop.equals("0"))&&((search!=0)));
                            search = 4;
                            break;
                        }
                        case 6:{
                            do {
                                System.out.println( "Enter car year start deleting than type end year or type 0 to go back .");
                                search=yearstart=sc.nextInt();
                                if ((search!=0)){
                                    year_start = Integer.toString(search);
                                    System.out.println("Now type end year: ");
                                    search=yearstop=sc.nextInt();
                                    year_stop = String.valueOf(search);
                                    System.out.println("Deleting year from: "+" " +year_start+".");
                                    System.out.println("Deleting year to: " +year_stop+".");
                                    if ((year_start.equals("0"))||(year_stop.equals("0"))||((yearstart>yearstop))){
                                        System.out.println("Entered data wrong try again.");}
                                    else{
                                        System.out.println("Type 1 to search using this data or 0 to go back.");
                                        search=sc.nextInt();
                                        if (search==1){ System.out.println("deleting...");
                                            crud.deleteByYear(year_start,year_stop);
                                         }
                                    }
                                }
                                else{search=0;year_start="0";year_stop="0";}
                            }while ((!year_start.equals("0"))&&(!year_stop.equals("0"))&&((search!=0)));
                            search = 4;
                            break;
                        }
                        case 7:{
                            crud.deleteAll();
                            search = 4;
                            break;
                        }
                            }
                    break;
                }
                case -1:{
                    exit = 0;
                    System.out.println("Goodbye see you :)");
                    break;
                }
            }
        }
    }
}
