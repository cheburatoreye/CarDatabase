package com.company;

import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarBuilder extends CarTemp {
    private boolean conditionRedact=false;
    private Scanner sc=new Scanner(System.in);
    private Map<String,Car> database=new HashMap<>();
    private Car car=new Car("OEIHFUIUE945995","ВН4568ОУ","BMW","I3","123544","1985","red","sedan","2000");

    private boolean conditionVin=false;
    private boolean conditionNum=false;
    private boolean conditionMark=false;
    private boolean conditionModel=false;
    private boolean conditionMileage=false;
    private boolean conditionYear=false;
    private boolean conditionColor=false;
    private boolean conditionBody=false;
    private boolean conditionPrice=false;

    private String vin ;
    private String number ;
    private String mark ;
    private String model;
    private String mileage;
    private String year;
    private String color ;
    private String body ;
    private String price ;


    //----------------------------------------------------------------------------------------------------------------------
    @Override
    protected void carvin() {
        String temp;
        boolean t=false;
        boolean inDatabase=false;
        System.out.println("Type new car data step by step: ");
        System.out.println("\n"+"Type vin code using uppercase letters: ");
        do {
            if (t){
                System.out.println("Type vin code again using uppercase: ");
            }
            Pattern p = Pattern.compile("^[0-9]{1}+[A-Z&0-9]{10}+[0-9]{6}$");
            vin=sc.next();
            Matcher m = p.matcher(vin);
            if(m.find()){
                if (!vin.equals("0")){

                    for (Map.Entry<String,Car> item:database.entrySet()) {
                        if (item.getKey().contains(vin)){
                            inDatabase=true;
                        }

                    }
                    if (inDatabase){
                        conditionVin=false;//
                    }
                    else{
                        conditionVin=true;
                    }

                }
            }
            m.reset();

            if (conditionVin){
                System.out.println("Vin typed correct");
                temp="0";
            }
            else{
                t=true;
                System.out.println("Vin code is exist or incorrect, type 1 for retype or 0 to go out");
                temp=sc.next();
                conditionVin=false;
                vin="empty";
                inDatabase=false;
            }
        }while (!temp.equals("0"));

        System.out.println("Vin code: "+vin);
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    protected void carnumber() {

        if (conditionVin|conditionRedact){
            String temp;
            boolean t=false;
            System.out.println("\n"+"Type number using uppercase letters: ");
            if (conditionRedact){
                System.out.println("current car number is: "+car.getNumber());
                //Car car=new Car("OEIHFUIUE945995","ВН4568ОУ","BMW","I3","123544","1985","red","sedan","2000");
                vin=car.getVin();
                car=database.get(vin);
                conditionVin=true;
            }
            do {
                if (t){
                    System.out.println("Type number again using uppercase: ");
                }
                Pattern p = Pattern.compile("^[A-Z]{2}+[0-9]{4}+[A-Z]{2}|[А-Я]{2}+[0-9]{4}+[А-Я]{2}$");
                number=sc.next();
                Matcher m = p.matcher(number);
                if(m.find()){
                    if (!number.equals("0")){
                        conditionNum=true;//
                    }
                }
                m.reset();

                if (conditionNum){
                    System.out.println("number typed correct");
                    temp="0";
                }
                else{
                    t=true;
                    System.out.println("number is incorrect type 1 for retype or 0 to go out");
                    temp=sc.next();
                    conditionNum=false;
                    number="empty";
                }
            }while (!temp.equals("0"));

            System.out.println("number: "+number);
        }
        else {
            conditionNum=false;
        }

    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    protected void carmark() {

        if (conditionNum){
            String temp;
            boolean t=false;
            System.out.println("\n"+"Type mark using uppercase letters: ");
            if (conditionRedact){
                System.out.println("current car mark is: "+car.getMark());
            }
            do {
                if (t){
                    System.out.println("Type mark again using uppercase: ");
                }
                Pattern p = Pattern.compile("^[A-Z]|[А-Я]$");
                mark=sc.next();
                Matcher m = p.matcher(mark);
                if(m.find()){
                    if (!mark.equals("0")){
                        conditionMark=true;//
                    }
                }
                m.reset();

                if (conditionMark){
                    System.out.println("mark typed correct");
                    temp="0";
                }
                else{
                    t=true;
                    System.out.println("mark is incorrect type 1 for retype or 0 to go out");
                    temp=sc.next();
                    conditionMark=false;
                    mark="empty";
                }
            }while (!temp.equals("0"));

            System.out.println("mark: "+mark);
        }
        else {
            conditionMark=false;
        }

    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    protected void carmodel() {
        if (conditionMark){
            String temp;
            boolean t=false;
            System.out.println("\n"+"Type model using uppercase letters: ");
            if (conditionRedact){
                System.out.println("current car model is: "+car.getModel());
            }
            do {
                if (t){
                    System.out.println("Type model again using uppercase: ");
                }
                Pattern p = Pattern.compile("^[A-Z]|[А-Я]|[0-9]$");
                model=sc.next();
                Matcher m = p.matcher(model);
                if(m.find()){
                    if (!model.equals("0")){
                        conditionModel=true;//
                    }
                }
                m.reset();

                if (conditionModel){
                    System.out.println("model typed correct");
                    temp="0";
                }
                else{
                    t=true;
                    System.out.println("model is incorrect type 1 for retype or 0 to go out");
                    temp=sc.next();
                    conditionModel=false;
                    model="empty";
                }
            }while (!temp.equals("0"));

            System.out.println("model: "+model);
        }
        else {
            conditionModel=false;
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    protected void carmileage() {
        if (conditionModel){
            String temp;
            boolean t=false;
            System.out.println("\n"+"Type mileage using uppercase letters: ");
            if (conditionRedact){
                System.out.println("current car mileage is: "+car.getMileage());
            }
            do {
                if (t){
                    System.out.println("Type mileage again using uppercase: ");
                }
                Pattern p = Pattern.compile("[0-9]");
                mileage=sc.next();
                Matcher m = p.matcher(mileage);
                if(m.find()){
                    if (!mileage.equals("0")){
                        conditionMileage=true;//
                    }
                }
                m.reset();

                if (conditionMileage){
                    System.out.println("mileage typed correct");
                    temp="0";
                }
                else{
                    t=true;
                    System.out.println("mileage is incorrect type 1 for retype or 0 to go out");
                    temp=sc.next();
                    conditionMileage=false;
                    mileage="empty";
                }
            }while (!temp.equals("0"));

            System.out.println("mileage: "+mileage);
        }
        else {
            conditionMileage=false;
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    protected void caryear() {
        if (conditionMileage){
            String temp;
            boolean t=false;
            System.out.println("\n"+"Type year using uppercase letters: ");
            if (conditionRedact){
                System.out.println("current car year is: "+car.getYear());
            }
            do {
                if (t){
                    System.out.println("Type year again using uppercase: ");
                }
                Pattern p = Pattern.compile("[0-9]");
                year=sc.next();
                Matcher m = p.matcher(year);
                if(m.find()){
                    if (!year.equals("0")){
                        conditionYear=true;//
                    }
                }
                m.reset();

                if (conditionYear){
                    System.out.println("year typed correct");
                    temp="0";
                }
                else{
                    t=true;
                    System.out.println("year is incorrect type 1 for retype or 0 to go out");
                    temp=sc.next();
                    conditionYear=false;
                    year="empty";
                }
            }while (!temp.equals("0"));

            System.out.println("year: "+year);
        }
        else {
            conditionYear=false;
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    protected void carcolor() {
        if (conditionYear){
            String temp;
            boolean t=false;
            System.out.println("\n"+"Type color using uppercase letters: ");
            if (conditionRedact){
                System.out.println("current car color is: "+car.getColor());
            }
            do {
                if (t){
                    System.out.println("Type color again using uppercase: ");
                }
                Pattern p = Pattern.compile("[A-Z]|[А-Я]");
                color=sc.next();
                Matcher m = p.matcher(color);
                if(m.find()){
                    if (!color.equals("0")){
                        conditionColor=true;//
                    }
                }
                m.reset();

                if (conditionColor){
                    System.out.println("color typed correct");
                    temp="0";
                }
                else{
                    t=true;
                    System.out.println("color is incorrect type 1 for retype or 0 to go out");
                    temp=sc.next();
                    conditionColor=false;
                    color="empty";
                }
            }while (!temp.equals("0"));

            System.out.println("color: "+color);
        }
        else {
            conditionColor=false;
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    protected void carbody() {
        if (conditionColor){
            String temp;
            boolean t=false;
            System.out.println("\n"+"Type body using uppercase letters: ");
            if (conditionRedact){
                System.out.println("current car body is: "+car.getBody());
            }
            do {
                if (t){
                    System.out.println("Type body again using uppercase: ");
                }
                Pattern p = Pattern.compile("[A-Z]|[А-Я]");
                body=sc.next();
                Matcher m = p.matcher(body);
                if(m.find()){
                    if (!body.equals("0")){
                        conditionBody=true;//
                    }
                }
                m.reset();

                if (conditionBody){
                    System.out.println("body typed correct");
                    temp="0";
                }
                else{
                    t=true;
                    System.out.println("body is incorrect type 1 for retype or 0 to go out");
                    temp=sc.next();
                    conditionBody=false;
                    body="empty";
                }
            }while (!temp.equals("0"));

            System.out.println("body: "+body);
        }
        else {
            conditionBody=false;
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    protected void carprice() {
        if (conditionBody){
            String temp;
            boolean t=false;
            System.out.println("\n"+"Type price using only digits: ");
            if (conditionRedact){
                System.out.println("current car price is: "+car.getPrice());
            }
            do {
                if (t){
                    System.out.println("Type price again using uppercase: ");
                }

                Pattern p = Pattern.compile("[0-9]");
                price=sc.next();
                //price=String.valueOf(z);

                Matcher m = p.matcher(price);
                if(m.find()){
                    if (!price.equals("0")){
                        conditionPrice=true;//
                    }
                }
                m.reset();

                if (conditionPrice){
                    System.out.println("price typed correct");
                    temp="0";
                }
                else{
                    t=true;
                    System.out.println("price is incorrect type 1 for retype or 0 to go out");
                    temp=sc.next();
                    conditionPrice=false;
                    price="0";
                }
            }while (!temp.equals("0"));

            System.out.println("price: "+price);
        }
        else {
            conditionPrice=false;
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    //Проверка на кондицию параметров введенных данных по авто и созадание нового авто
    @Override
    protected void newcar() {
        if (conditionVin&conditionNum&conditionMark&conditionModel&conditionMileage&conditionYear&conditionBody&conditionColor&conditionPrice){
            Car car=new Car(vin,number,mark,model,mileage,year,color,body,price);
            database.put(vin,car);
            car.print();
            System.out.println("New car added to database successfully"+"\n");
        }
        else {
            System.out.println("\n"+"New car not added no correct data");
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    protected void redact() {
        if (conditionVin&conditionNum&conditionMark&conditionModel&conditionMileage&conditionYear&conditionBody&conditionColor&conditionPrice){
            Car car=new Car(vin,number,mark,model,mileage,year,color,body,price);
            database.put(vin,car);
            car.print();
            System.out.println("Car data changed successfully"+"\n");
        }
        else {
            System.out.println("\n"+"not correct data");
        }
    }
    //---------------------------------------------------------------------------------------------------------------------
    @Override
    public void createcar(String vin) {
        //Car car=new Car("OEIHFUIUE945995","ВН4568ОУ","BMW","I3","123544","1985","red","sedan","2000");
        car.setVin(vin);
        database.put(vin,car);
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public void createcar2(String vin, String number, String mark, String model, String mileage, String year, String color, String body, String price) {
        Car car=new Car(vin,number,mark,model,mileage,year,color,body,price);
        database.put(vin,car);
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public void readcar(String vin) {
        // Car car=new Car("OEIHFUIUE945995","ВН4568ОУ","BMW","I3","123544","1985","red","sedan","2000");
        for (Map.Entry<String, Car> item : database.entrySet()) {
            if (item.getKey().equals(vin)){
                car=database.get(vin);
                car.print();
            }
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
//Этот метод производит пошаговое редактирование данных авто в базе
    @Override
    public void updatecar(String vin) {
        // Car car=new Car("OEIHFUIUE945995","ВН4568ОУ","BMW","I3","123544","1985","red","sedan","2000");
        String scanvalue;
        List<String>listvin=new ArrayList<>();
        for (Map.Entry<String, Car> item : database.entrySet()) {
            if (item.getKey() != null) {
                listvin.add(item.getKey());
            }
        }
        if (listvin.contains(vin)){
            car=database.get(vin);
            System.out.println(car.getVin());
            conditionRedact=true;
            redactcar(vin);
            conditionRedact=false;
        }
        else {
            System.out.println("Such Car not existing!");
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public void deletecarByVin(String vin) {
        List<String> listvins = new ArrayList<>();
        for (Map.Entry<String, Car> item : database.entrySet()) {
            if (item.getValue() != null) {
                if (item.getValue().getVin().equals(vin)) {
                    listvins.add(item.getKey());
                }
            }
        }

        if (listvins.isEmpty()){
            System.out.println("no such car!");
        }
        else{
            for (String item : listvins) {
                for (Iterator<Map.Entry<String, Car>> it = database.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry<String, Car> entry = it.next();
                    if (entry.getKey().equals(item)) {
                        it.remove();
                    }
                }
            }
            System.out.println("deleted!");
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public void deletecarByNumber(String number) {

        List<String> listvins = new ArrayList<>();
            for (Map.Entry<String, Car> item : database.entrySet()) {
                if (item.getValue() != null) {
                    if (item.getValue().getNumber().equals(number)) {
                        listvins.add(item.getKey());
                    }
                }
            }

        if (listvins.isEmpty()){
            System.out.println("no such car!");
        }
        else{
            for (String item : listvins) {
                for (Iterator<Map.Entry<String, Car>> it = database.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry<String, Car> entry = it.next();
                    if (entry.getKey().equals(item)) {
                        it.remove();
                    }
                }
            }
            System.out.println("deleted!");
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override

    public void deleteByMarkModel(String mark, String model) {
        List<String> listvins = new ArrayList<>();
        for (Map.Entry<String, Car> item : database.entrySet()) {
            if (item.getValue() != null) {
                if (item.getValue().getMark().equals(mark) && item.getValue().getModel().equals(model)) {
                    listvins.add(item.getKey());
                }
            }
        }

    if (listvins.isEmpty()){
    System.out.println("no such car!");
    }
    else{
    for (String item : listvins) {
        for (Iterator<Map.Entry<String, Car>> it = database.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Car> entry = it.next();
            if (entry.getKey().equals(item)) {
                it.remove();
            }
        }
    }
    System.out.println("deleted!");
    }

    }
//----------------------------------------------------------------------------------------------------------------------
    @Override
    public void deletecarByMileage(String mileagestart,String mileageend) {

        int mileagestartInt;
        int mileageendInt;

        mileagestartInt = Integer.valueOf(mileagestart);
        mileageendInt = Integer.valueOf(mileageend);
        List<String> listvins = new ArrayList<>();
        for (int i = mileagestartInt; i <= mileageendInt; i++) {
            String s=String.valueOf(i);

            for (Map.Entry<String, Car> item : database.entrySet()) {
                if (item.getValue() != null) {
                    if (item.getValue().getMileage().equals(s)) {
                        listvins.add(item.getKey());
                    }
                }
            }
        }

        if (listvins.isEmpty()){
            System.out.println("no such car!");
        }
        else{
            for (String item : listvins) {
                for (Iterator<Map.Entry<String, Car>> it = database.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry<String, Car> entry = it.next();
                    if (entry.getKey().equals(item)) {
                        it.remove();
                    }
                }
            }
            System.out.println("deleted!");
        }
    }
//----------------------------------------------------------------------------------------------------------------------


    @Override
    public void deleteByYear(String yearstart, String yearend) {
        int yearstartInt;
        int yearendInt;

        yearstartInt = Integer.valueOf(yearstart);
        yearendInt = Integer.valueOf(yearend);
        List<String> listvins = new ArrayList<>();
        for (int i = yearstartInt; i <= yearendInt; i++) {
            String s=String.valueOf(i);

            for (Map.Entry<String, Car> item : database.entrySet()) {
                if (item.getValue() != null) {
                    if (item.getValue().getYear().equals(s)) {
                        listvins.add(item.getKey());
                    }
                }
            }
        }

        if (listvins.isEmpty()){
            System.out.println("no such car!");
        }
        else{
            for (String item : listvins) {
                for (Iterator<Map.Entry<String, Car>> it = database.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry<String, Car> entry = it.next();
                    if (entry.getKey().equals(item)) {
                        it.remove();
                    }
                }
            }
            System.out.println("deleted!");
        }
    }

//----------------------------------------------------------------------------------------------------------------------


    @Override
    public void deleteByPrice(String pricestart, String priceend) {
        int pricestartInt;
        int priceendInt;

        pricestartInt = Integer.valueOf(pricestart);
        priceendInt = Integer.valueOf(priceend);
        List<String> listvins = new ArrayList<>();
        for (int i = pricestartInt; i <= priceendInt; i++) {
            String s=String.valueOf(i);

            for (Map.Entry<String, Car> item : database.entrySet()) {
                if (item.getValue() != null) {
                    if (item.getValue().getPrice().equals(s)) {
                        listvins.add(item.getKey());
                    }
                }
            }
        }

        if (listvins.isEmpty()){
            System.out.println("no such car!");
        }
        else{
            for (String item : listvins) {
                for (Iterator<Map.Entry<String, Car>> it = database.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry<String, Car> entry = it.next();
                    if (entry.getKey().equals(item)) {
                        it.remove();
                    }
                }
            }
            System.out.println("deleted!");
        }
    }
//-----------------------------------------------------------------------------------------------------------------------
    @Override
    public void deleteAll() {
        int confirm;
        System.out.println("Are you sure? if yes type 1 if no type 0");
        confirm=sc.nextInt();
        if (confirm==1){
            database.clear();
            System.out.println("database cleared");
        }
        else {
            System.out.println("discard");
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public void showAll() {
        List<String> listvin=new ArrayList<>();
        for (Map.Entry<String, Car> item : database.entrySet()) {
            if (item.getKey() != null) {
                listvin.add(item.getKey());
            }
        }
        for (String item:listvin
        ) {
            // System.out.println(database.get(item));
            car=database.get(item);
            System.out.println("Car vin:"+car.getVin()+"|| number:"+car.getNumber()+"|| mark:"+car.getMark()+"|| model:"+car.getModel()+"|| mileage:"+car.getMileage()+"|| year:"+car.getYear()+"|| color:"+car.getColor()+"|| body:"+car.getBody()+"|| price:"+car.getPrice());
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public void showByMark(String mark) {
        Car car=new Car("OEIHFUIUE945995","ВН4568ОУ","BMW","I3","123544","1985","red","sedan","2000");

        List<Car>listcars=new ArrayList<>();
        for (Map.Entry<String, Car> item : database.entrySet()) {
            if (item.getValue() != null) {
                if (item.getValue().getMark().equals(mark)){
                    listcars.add(item.getValue());
                }
            }
        }
        for (Car item:listcars
        ) {
            System.out.println("Founded cars by mark: ");
            item.print();
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public void showByNumber(String number) {

        List<Car>listcars=new ArrayList<>();
        for (Map.Entry<String, Car> item : database.entrySet()) {
            if (item.getValue() != null) {
                if (item.getValue().getNumber().equals(number)){
                    listcars.add(item.getValue());
                }
            }
        }
        for (Car item:listcars
        ) {
            System.out.println("Founded cars by number: ");
            item.print();
        }

    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public void showByYear(String yearstart,String yearend) {
        int yearstartInt;
        int yearendInt;

        yearstartInt=Integer.valueOf(yearstart);
        yearendInt=Integer.valueOf(yearend);
        List<Car>listcars=new ArrayList<>();
        for(int i=yearstartInt;i<=yearendInt;i++){
            String s;
            s=Integer.toString(i);
            for (Map.Entry<String, Car> item : database.entrySet()) {
                if (item.getValue() != null) {
                    if (item.getValue().getYear().equals(s)){
                        listcars.add(item.getValue());
                    }
                }
            }

        }
        for (Car item:listcars) {
            System.out.println("Founded cars by year: ");
            item.print();
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public void showByMileage(String mileagestart,String mileageend) {
        int mileagestartInt;
        int mileageendInt;

        mileagestartInt = Integer.valueOf(mileagestart);
        mileageendInt = Integer.valueOf(mileageend);
        List<Car> listcars = new ArrayList<>();
        for (int i = mileagestartInt; i <= mileageendInt; i++) {
            String s;
            s = Integer.toString(i);
            for (Map.Entry<String, Car> item : database.entrySet()) {
                if (item.getValue() != null) {
                    if (item.getValue().getMileage().equals(s)) {
                        listcars.add(item.getValue());
                    }
                }
            }

        }
        for (Car item : listcars) {
            System.out.println("Founded cars by mileage: ");
            item.print();
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public void showByPrice(String pricestart,String priceend) {
        int pricestartInt;
        int priceendInt;

        pricestartInt = Integer.valueOf(pricestart);
        priceendInt = Integer.valueOf( priceend);
        List<Car> listcars = new ArrayList<>();
        for (int i = pricestartInt; i <= priceendInt; i++) {
            String s;
            s = Integer.toString(i);
            for (Map.Entry<String, Car> item : database.entrySet()) {
                if (item.getValue() != null) {
                    if (item.getValue().getPrice().equals(s)) {
                        listcars.add(item.getValue());
                    }
                }
            }

        }
        for (Car item : listcars) {
            System.out.println("Founded cars by price: ");
            item.print();
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    @Override
    public void showByMarkModel(String mark, String model) {

        List<Car> listcars = new ArrayList<>();
            for (Map.Entry<String, Car> item : database.entrySet()) {
                if (item.getValue() != null) {
                    if (item.getValue().getMark().equals(mark)&item.getValue().getModel().equals(model)) {
                        listcars.add(item.getValue());
                    }
                }
            }
        for (Car item : listcars) {
            System.out.println("Founded cars by price: ");
            item.print();
        }
    }
}
//----------------------------------------------------------------------------------------------------------------------