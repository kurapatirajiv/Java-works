/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingandexceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Rajiv Kurapati
 */
public class Driver {

    public static void main(String[] args) throws FileNotFoundException {
        //Note: The 1st,3rd,5th and so on lines in property.txt represents the 
        //      Car properties. 
        //      The 2nd,4rth,6th and so on lines in property.txt represents the 
        //      Bike properties.
        //      
        // Note: Limit all the calculated value to 2 decimal.

        //1. Declare and initialize a Scanner object named 'scanner' to read
        //from the file "property.txt".
        Scanner scanner = new Scanner(new File("property.txt"));
        //2. Create an ArrayList of CarInsurance and name it as 'carList'.
        ArrayList<CarInsurance> carList = new ArrayList<>();
        //3. Create and ArrayList of BikeInsurance and name it s 'bikeList'.
        ArrayList<BikeInsurance> bikeList = new ArrayList<>();
        //4. Create an object reference named 'carInsurance' of CarInsurance class.
        CarInsurance carInsurance;
        //5. Create an object reference named 'bikeInsurance' of BikeInsurance class.
        BikeInsurance bikeInsurance;
        //6. while property.txt has more data 
        // {
        // Read in the data and store the 1st line of the text file to 
        // carInsurance object and the second line of the text file to
        // bikeInsurance object.

        // Add the 'carInsurance' object to the 'carList' ArrayList.
        // Add the 'bikeInsurance' object to the 'bikeList' ArrayList.
        // }   
        while (scanner.hasNext()) {

            carInsurance = new CarInsurance(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.next());
            bikeInsurance = new BikeInsurance(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.next());
            carList.add(carInsurance);
            bikeList.add(bikeInsurance);
        }

        System.out.println("*************************************************");

        System.out.println("\nCar Insurance List Of Elements: ORIGINAL LIST");
        for (CarInsurance ci : carList) {
            System.out.println(ci);
        }

        //7. Use enhanced for loop to print the carList.
        System.out.println("*************************************************");
        System.out.println("\nBike Insurance List Of Elements: ORIGINAL LIST");
        //8. Use enhanced for loop to print the bikeList.
        for (BikeInsurance bi : bikeList) {
            System.out.println(bi);
        }
        System.out.println("*************************************************");

        //9. Print the Car Insurance List Of Elements As Per the Phone Number 
        //   in Natural Order.
        //      For Example: Collections.sort(carList);
        System.out.println("\nCar Insurance List Of Elements: NATURAL ORDER LIST"
                + " AS PER THE PHONE NUMBER");
        Collections.sort(carList);
        for (CarInsurance ci : carList) {
            System.out.println(ci);
        }
        System.out.println("*************************************************");

        //10. Print the Bike Insurance List Of Elemebts As Per the Phone Number 
        //    in Natural Order.
        System.out.println("\nBike Insurance List Of Elements: NATURAL ORDER "
                + "LIST AS PER THE PHONE NUMBER");
        Collections.sort(bikeList);
        for (BikeInsurance bi : bikeList) {
            System.out.println(bi);
        }
        System.out.println("*************************************************");

        //11. Use the Anonymous class and print the total years of payment in Descending Order for CarInsurance.
        System.out.println("\nCarInsurance List Of Elements: Sort by Total Years Of Payment Using Anonymous Class in Descending Order:");
        Collections.sort(carList, new Comparator<CarInsurance>() {

            @Override
            public int compare(CarInsurance t, CarInsurance t1) {
                return t1.getTotalYearsOfPayment() - t.getTotalYearsOfPayment();
            }
        }
        );
        for (CarInsurance ci : carList) {
            System.out.println(ci);
        }

        // Use enhanced for loop to print the carList.
        // 12. Use the separate class to override the natural order and print 
        //     the BikeInsurance list of Elements according to the vehicle 
        //     purchase year.
        Collections.sort(bikeList, new BikeInsuranceYearComparator());
        System.out.println("*************************************************");

        System.out.println("BikeInsurance List Of Elements: Sorted List overidding natural Order Using separate class according to year of purchase");
        // Use enhanced for loop to print the bikeList.
        for (BikeInsurance bi : bikeList) {
            System.out.println(bi);
        }

        System.out.println("*************************************************");

        //13. Create an CarInsurance object named "carInsurance1" and pass the parameters as 
        //  "Sara", "Kansas 123 Sara","Fiat",2014,4,"6603451234"
        CarInsurance carInsurance1 = new CarInsurance("Sara", "Kansas 123 Sara", "Fiat", 2014, 4, "6603451234");
        //14. Create an CarInsurance object named "carInsurance2" and pass the parameters as 
        //  "Lindcy", "Maryville 123 Lindcy","Dodge",2015,4,"5634561234"
        CarInsurance carInsurance2 = new CarInsurance("Lindcy", "Maryville 123 Lindcy", "Dodge", 2015, 4, "5634561234");
        //15. Create an CarInsurance object named "carInsurance3" and pass the parameters as 
        //  "Jack", "Chicago 123 Jack","FIA",2009,5,"8163451234"
        CarInsurance carInsurance3 = new CarInsurance("Jack", "Chicago 123 Jack", "FIA", 2009, 5, "8163451234");
        //16. Check the Equals method with respect to vehicle make using carInsurance1
        //    and carInsurance2 objects.
        System.out.println("\nChecking Equals Method w.r.t vehicle Make Using "
                + "carInsurance1 and carInsurance2 objects: " + carInsurance1.equals(carInsurance2));

        System.out.println("*************************************************");

        //17. Calculate the value of calcShortTermPlan() method using carInsurance1 object.
        System.out.println("\nCalculating Value calcShortTermPlan() method using carInsurance1 object:");
        try {
            System.out.println("The Value Of Insurance to be paid by a person if he/she pays the insurance within "
                    + carInsurance1.getTotalYearsOfPayment() + " years is :$ " + String.format("%.2f", carInsurance1.calcShortTermPlan(carInsurance1.getTotalYearsOfPayment())));
        } catch (IncorrectYearsException ex) {
            System.out.println(ex.getMessage());
        }
        //Sample Output: 
        //"The Value Of Insurance to be paid by a person if he pays the insurance within 4 years is :$ 360000.00"
        //18. Calculate the value of calcLongTermPlan() method using carInsurance3 object
        System.out.println("\nCalculating Value calcLongTermPlan() method using carInsurance3 object:");
        try {
            System.out.println("The Value Of Insurance to be paid by a person if he/she pays the insurance within "
                    + carInsurance3.getTotalYearsOfPayment() + " years is :$ " + String.format("%.2f", carInsurance3.calcLongTermPlan(carInsurance3.getTotalYearsOfPayment())));
        } catch (IncorrectYearsException ex) {
            System.out.println(ex.getMessage());
        }
        //Sample Output: 
        //"The Value Of Insurance to be paid by a person if he pays the insurance within 5 years is :$ 550000.00"
        System.out.println("*************************************************");

        //19. Test checkPhoneNumber() method using 'carInsurance2' object in Car Insurance class.
        System.out.println("Testing checkPhoneNumber() method using 'carInsurance2' object in Car Insurance class: ");
        try {
            carInsurance2.checkPhoneNumber(carInsurance2.getTelephoneNumber());
        } catch (IncorrectAreaCodeException | IncorrectLengthException | NonDigitFoundException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("*************************************************");
        System.out.println("");
        System.out.println("********* House Insurance Implementation*********");

        // 20. Create an ApartmentInsurance object 'apartmentInsurance' object 
        //     and pass the parameters as 
        //     "Ashley","Apt 79", 4, "3331242345", "Maryville"
        ApartmentInsurance apartmentInsurance = new ApartmentInsurance("Ashley", "Apt 79", 4, "3331242345", "Maryville");

        // 21. Create an ApartmentInsurance object 'apartmentInsurance1' object 
        //     and pass the parameters as 
        //     "Mike","Apt 34",5,"44534Y3322","Kansas"
        ApartmentInsurance apartmentInsurance1 = new ApartmentInsurance("Mike", "Apt 34", 5, "44534Y3322", "Kansas");
        // 22. Create and ApartmentInsurance object 'apartmentInsurance2' object
        //     and pass the parameters as
        //     "James","Apt 32",3,"3349034442","Warrensburg"
        ApartmentInsurance apartmentInsurance2 = new ApartmentInsurance("James", "Apt 32", 3, "3349034442", "Warrensburg");
        System.out.println("");

        // 23. Test the checkSSNNumber() method using 'apartmentInsurance1' object in House Insurance class:
        System.out.println("Testing checkSSNNumber() method in House Insurance class using apartmentInsurance1: ");
        try {
            apartmentInsurance1.checkSSNNumber(apartmentInsurance1.getSsn());
        } catch (NonDigitFoundException ex) {
            System.out.println(ex.getMessage());
        }
        // 24. Create an StudioInsurance object 'studioInsurance' object and pass
        //     the parameters as 
        //      "Brad","Apt 10",4,"3330002233","Dallas"
        StudioInsurance studioInsurance = new StudioInsurance("Brad", "Apt 10", 4, "3330002233", "Dallas");
        // 25. Create an StudionInsurance object 'studioInsurance1' object and pass
        //     the parameters as 
        //      "Liu","Apt 45",3,"2234445634","Houston"
        StudioInsurance studioInsurance1 = new StudioInsurance("Liu", "Apt 45", 3, "2234445634", "Houston");
        // 26. Create an StudionInsurance object 'studioInsurance2' object and pass
        //     the parameters as 
        //      "Tim","Apt 20",3,"3344091232", "Chicago"
        StudioInsurance studioInsurance2 = new StudioInsurance("Tim", "Apt 20", 3, "3344091232", "Chicago");

        // 27. Create an StudionInsurance object 'studioInsurance3' object and pass
        //     the parameters as 
        //      "Ellice", "Apt 20", 6, "3402341234", "Newyork"
        StudioInsurance studioInsurance3 = new StudioInsurance("Ellice", "Apt 20", 6, "3402341234", "Newyork");
        // 28. Create an StudionInsurance object 'studioInsurance4' object and pass
        //     the parameters as 
        //      "Leo", "Apt 40", 5, "3344234422", "Washington"
        StudioInsurance studioInsurance4 = new StudioInsurance("Leo", "Apt 40", 5, "3344234422", "Washington");

        System.out.println("*************************************************");

        // 29. Check the Equals method with respect to Apartment number using studioInsurance
        //    and studioInsurance2 objects.
        System.out.println("Checking Equals Method w.r.t Apartment Number Using "
                + "studioInsurance and studioInsurance2 objects: " + studioInsurance.equals(studioInsurance2));

        System.out.println("*************************************************");

        // 30. Calculate calcShortTermPlan() method using studioInsurance1 object in StudioInsurance class.
        System.out.println("Calculating calcShortTermPlan() method using studioInsurance1 object:");
        try {
            System.out.println("The Value Of Insurance to be paid by a person if he/she pays the insurance within "
                    + studioInsurance1.getTotalYearsOfPayment()
                    + " years is : $ " + String.format("%.2f", studioInsurance1.calcShortTermPlan(studioInsurance1.getTotalYearsOfPayment())));
        } catch (IncorrectYearsException ex) {
            System.out.println(ex.getMessage());
        }
        //Sample output:
        //"The Value Of Insurance to be paid by a person if he pays the insurance within 3 years is : $ 231000.00"
        // 31. Calculate calcLongTermPlan() method using studioInsurance4 object:
        System.out.println("*************************************************");
        System.out.println("Calculating calcLongTermPlan() method using studioInsurance4 object:");
        try {
            System.out.println("The Value Of Insurance to be paid by a person if he/she pays the insurance within "
                    + studioInsurance4.getTotalYearsOfPayment() + " years is : $ " + String.format("%.2f", studioInsurance4.calcLongTermPlan(studioInsurance4.getTotalYearsOfPayment())));
        } catch (IncorrectYearsException ex) {
            System.out.println(ex.getMessage());
        }
        //Sample output:
        //"The Value Of Insurance to be paid by a person if he pays the insurance within 5 years is : $ 550000.00"
        System.out.println("*************************************************");

        // 32. Test calcShortTermPlan() method using studioInsurance3 object:
        System.out.println("Testing calcShortTermPlan() method using studioInsurance3 object:");
        try {
            System.out.println("The Value Of Insurance to be paid by a person if he pays the insurance within "
                    + studioInsurance3.getTotalYearsOfPayment() + " years is :$ " + String.format("%.2f", studioInsurance3.calcShortTermPlan(studioInsurance3.getTotalYearsOfPayment())));
        } catch (IncorrectYearsException ex) {
            System.out.println(ex.getMessage());
        }
        // 33. Create an ArrayList of named 'studioList' of StudioInsurance class
        ArrayList<StudioInsurance> studioList = new ArrayList<>();
        // 34. Add 'studioInsurance', 'studioInsurance1', 'studioInsurance2',
        //      and 'studioInsurance3' to the 'studioList' ArrayList.
        studioList.add(studioInsurance);
        studioList.add(studioInsurance1);
        studioList.add(studioInsurance2);
        studioList.add(studioInsurance3);
        System.out.println("\nStudio Insurance List Of Elements: ORIGINAL LIST");
        // 35. Use enhanced for loop to print the studioList.

        for (StudioInsurance si : studioList) {
            System.out.println(si);
        }
        System.out.println("*************************************************");
        // 36. Print the Studio Insurance List Of Elements As Per the Apartment Number 
        //     in Natural Order.
        //     For Example: Collections.sort(studioList);
        Collections.sort(studioList);
        System.out.println("Studio Insurance List Of Elements: NATURAL ORDER LIST AS PER THE APARTMENT NUMBER");
        for (StudioInsurance si : studioList) {
            System.out.println(si);
        }
        // 38. Use the Anonymous class and print the total years of payment in Descending Order for Studio Insurance.
        System.out.println("*************************************************");
        System.out.println("\nStudio Insurance List Of Elements: Sort by Total Years Of Payment Using Anonymous Class in Descending Order:");
        Collections.sort(studioList, new Comparator<StudioInsurance>() {

            @Override
            public int compare(StudioInsurance t, StudioInsurance t1) {
                return t1.getTotalYearsOfPayment() - t.getTotalYearsOfPayment();
            }

        });
        // 39. Use enhanced for loop to print the studioList.
        for (StudioInsurance si : studioList) {
            System.out.println(si);
        }

    }
}
