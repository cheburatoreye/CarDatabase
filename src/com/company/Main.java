package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
    //------------------------------------------------------------------------------------------------------------------
        //Init
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
        Menu menu=new Menu();

        //Stored database-----------------------------------------------------------------------------------------------
        Map<String,Car>hashset=new HashMap<>();
        Car car5=new Car("OEIHFUIUE945995","ВН4568ОУ","BMW","I3","123544","1985","red","sedan","500");
        Car car6=new Car("TGHEDSWIUE9434652","ВН5555ОУ","OPEL","ZAFIRA","100654","1989","GREE","sedan","800");
        Car car7=new Car("OCEDFUIUE947952","ВН3214ОУ","OPEL","VECTRA","122654","1989","blue","sedan","2000");
        Car car8=new Car("TLHLTKELW568345","ВН32456ОУ","TOYOTA","COROLLA","320214","2019","grey","sedan","3000");
        Car car9=new Car("JSJFGKELW216448","ВН8523ОУ","TOYOTA","COROLLA","300214","2019","grey","sedan","2000");
        Car car10=new Car("TGOTGKGKELW215948","ВН8548ОУ","MAZDA","CX3","22132","2019","YELLOW","SEDAN","18000");
        hashset.put("OEIHFUIUE945995",car5);
        hashset.put("TGHEDSWIUE9434652",car6);
        hashset.put("OCEDFUIUE947952",car7);
        hashset.put("TLHLTKELW568345",car8);
        hashset.put("JSJFGKELW216448",car9);
        hashset.put("TGOTGKGKELW215948",car10);

        //Stored database-----------------------------------------------------------------------------------------------

        //--------------------------------------------------------------------------------------------------------------
        List<Car>listcars=new ArrayList<>();
        Car car1=new Car("OEIFIFJEUE9459343","ВН988ОУ","BMW","I3","1235234544","1995","red","sedan","1500");
        Car car2=new Car("WDEFWSWSQJEUE94593","ВН7872ОУ","MAZDA","6","159234544","1998","black","sedan","1600");
        Car car3=new Car("XAZDDFWW9459343","ВН7785ОУ","NIVA","2111","1242387554","2003","blue","sedan","1800");
        Car car4=new Car("PLKIFJEUE5451943","ВН123ОУ","DAEWOO","LANOS","54124","2005","GREEN","sedan","3000");
        listcars.add(car1);
        listcars.add(car2);
        listcars.add(car3);
        listcars.add(car4);
        //--------------------------------------------------------------------------------------------------------------
        //Menu loop
        while (exit==1){

            switch (search){
                //------------------------------------------------------------------------------------------------------
                // Menu main
                case 0:{
                    menu.setState(new MenuStart());
                    menu.printState();
                    search = sc.nextInt();
                    break;
                }
                //------------------------------------------------------------------------------------------------------
                // Menu search
                case 1:{
                    menu.setState(new MenuSearch());
                    menu.printState();
                    search = sc.nextInt();
                    switch (search){
                        //----------------------------------------------------------------------------------------------
                        // Menu search by VIN sub menu search
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
                        //----------------------------------------------------------------------------------------------
                        // Menu search by NUMBER sub menu search
                        case 2:{
                                System.out.println( "Enter car number for search or type 0 to go back .");
                                number=sc.next();
                                if (!number.equals("0")){
                                    crud.showByNumber(number);
                                }
                            search=1;
                            break;
                        }
                        //----------------------------------------------------------------------------------------------
                        // Menu search by MARK and MODEL sub menu search
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
                        //----------------------------------------------------------------------------------------------
                        // Menu search by YEAR sub menu search
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
                        //----------------------------------------------------------------------------------------------
                        // Menu search by MILEAGE sub menu search
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
                        //----------------------------------------------------------------------------------------------
                        // Menu search by PRICE sub menu search
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
                        //----------------------------------------------------------------------------------------------
                        // Menu search ALL sub menu search
                        case 7:{
                            System.out.println( "The list of the cars in database: ");
                            crud.showAll();
                            search=1;
                            break;
                        }
                        //----------------------------------------------------------------------------------------------
                        // Menu search by MARK sub menu search
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
                                        }
                                    }
                                }
                                else{search=0;mark="0";model="0";}
                            }while ((!mark.equals("0"))&&((search!=0)));
                            search=1;
                            break;
                        }
                        //----------------------------------------------------------------------------------------------
                    }
                    break;
                }
                //------------------------------------------------------------------------------------------------------
                // Menu adding
                case 2:{
                    menu.setState(new MenuAddingCars());
                    menu.printState();
                    crud.buildcar();
                    search=0;
                    break;
                }
                //------------------------------------------------------------------------------------------------------
                // Menu redact
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
                //------------------------------------------------------------------------------------------------------
                // Menu deleting
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
                //------------------------------------------------------------------------------------------------------
                // Menu merge
                case 5:{
                    menu.setState(new MenuMerge());
                    menu.printState();
                    crud.mergeListHashSet(listcars,hashset);
                    search=0;
                    break;}
                //------------------------------------------------------------------------------------------------------
                // Menu exit
                case -1:{
                    exit = 0;
                    System.out.println("Goodbye see you :)");
                    break;
                }
                //------------------------------------------------------------------------------------------------------
            }
        }
    }
}
