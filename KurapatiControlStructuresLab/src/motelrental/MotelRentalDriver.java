/*
 * Functinality of this application is to read the various rental amount
 * calcuation factors from two files and compute the monthly,yearly rental
 * amounts accordingly.
 */
package motelrental;

/**
 * Importing Util.Scanner ,io.FIlE to support Scanner methods used as part of taking input from text files.
 * Importing io.FileNotFoundException to support the  main class to throw an exception when the input files are not available.
 * @author S525252
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class MotelRentalDriver {
    
    public static void main(String args[]) throws FileNotFoundException{
        Scanner readMotel = new Scanner(new File("motelData.txt"));        
        int noOfMonths;
        int begOfLease;
        /**
         * Read the motel information from the file and initialize the motel information in the local variables.
         */
        while(readMotel.hasNext()){
            
        System.out.println("\nNEW MOTEL ROOM CREATED:");    
        MotelRental room = new MotelRental(readMotel.nextDouble(),readMotel.nextDouble(),readMotel.nextDouble());
        System.out.println(room.toString());
        
        System.out.println("\nTESTING GETTERS");
        System.out.println("Standard rental fee = " +room.getStandardMotelRentalAmount());
        System.out.println("Seasonal rate = " +room.getSeasonalRate());
        System.out.println("Yearly discount = " +room.getYearlyDiscount());   
        System.out.println("\nTESTING getMonthlyRental(int month)");
        /**
         * Calculate the monthly rental amount of all the months based on the data read from the file
         */
        for(int i=0;i<=11;i++){
            System.out.println("Rental fee for month " +i +" is " + room.getMonthlyRental(i));           
        }
        System.out.println("\nTESTING getYearlyRental()");
        System.out.println("Yearly rental fee = " +room.getYearlyRental() + "\n");
        Scanner readMonth = new Scanner(new File("monthData.txt"));
        /**
         * Calculate the rental amounts for all the data present in the monthData.txt file
         */
        while(readMonth.hasNext()){
            begOfLease = readMonth.nextInt();
            noOfMonths = readMonth.nextInt();
            System.out.println("Rental Fee for " + noOfMonths + " months, beginning with month " + begOfLease + " is " +room.getMonthlyRental(begOfLease,noOfMonths));
        }
        /**
         * Closing the input file monthData.txt which is opened as part of scanner object
         */
        readMonth.close();
        }
    /**
    * Closing the input file motelData.txt which is opened as part of scanner object
    */
    readMotel.close();
    }     
    
}