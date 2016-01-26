/*
 *  This module performs all the backend logic of computing total rental amounts of a tenant based on the 
 *  information read from the input files.
 */
package motelrental;

/**
 * The following class contains information related to 
 * constructors, methods to calculate the monthly,
 * yearly rental amounts and the discount amounts.
 * 
 * @author S525252
 */
public class MotelRental {
    
    private double standardMotelRentalAmount;
    private double seasonalRate;
    private double yearlyDiscount;

    
    /**
     * MotelRental constructor to initialize the input fields necessary for calculation
     * @param astandardMotelRentalAmount
     * @param aseasonalRate
     * @param ayearlyDiscount 
     */
    public MotelRental(double astandardMotelRentalAmount, double aseasonalRate, double ayearlyDiscount){
        
        standardMotelRentalAmount = astandardMotelRentalAmount;
        seasonalRate = aseasonalRate;
        yearlyDiscount = ayearlyDiscount;
    }
    /**
     * The following methods returns the value of standard motel rental amount which is read from the file. 
     * @return standard motel rental amount
     */
    public double getStandardMotelRentalAmount(){
         return standardMotelRentalAmount;
    }
    /**
     * The following methods returns the value of seasonal rate percentage which is read from the file.
     * @return seasonal rate
     */
    public double getSeasonalRate(){
         return seasonalRate;
    }
    /**
     * The following methods returns the value of yearly discount amount which is read from the file.
     * @return yearly discount
     */
    public double getYearlyDiscount(){
         return yearlyDiscount;
    }
    /**
     * Calculates the monthly rental amount based on the month starting parameter passed from main class
     * @param amonth
     * @return monthly rental amount
     */
    public double getMonthlyRental(int amonth){
         /**
          * Return the standard motel rental amount if the months are other than January or December
          */
         if((amonth!=0)&&(amonth!=11)){
             return standardMotelRentalAmount;
         }
         else
         {
             return(standardMotelRentalAmount + (standardMotelRentalAmount * seasonalRate));
         }            
    }
    /**
     * Calculates the yearly rental amount by deducting the yearly discount
     * @return yearly rental amount
     */
    public double getYearlyRental(){
         return (standardMotelRentalAmount*12 - standardMotelRentalAmount*12*yearlyDiscount) ;
    }
    /**
     * The following method calculates the monthly rental amount based on the starting of the lease agreement month 
     * and the number of months the lease is about.
     * @param amonth
     * @param anumberOfMonths
     * @return 
     */
    public double getMonthlyRental(int amonth, int anumberOfMonths){
     
        int monthsLeft=anumberOfMonths%12;;
        int i,j;
        double sumRent=0.0;
        /**
         * Calculates the total rental amount if the number of lease months forms a 
         * complete year or years without having any partial months.
         */   
        if(monthsLeft==0){
             return ((anumberOfMonths/12) *(standardMotelRentalAmount*12 - standardMotelRentalAmount*12*yearlyDiscount)) ;
        }  
        /**
        * Calculates the total rental amount if the number of lease months cannot form a 
        * complete year. i.e Ex : lease is about 3 years 4 months or a half-yearly lease
        */ 
        else{ 
                 if((anumberOfMonths/12)>0){                     
                    sumRent= (anumberOfMonths/12) *(standardMotelRentalAmount*12 - standardMotelRentalAmount*12*yearlyDiscount);
                    /**
                     * Calculates the rental amount for the partial months
                     */
                    for(i=0;i<monthsLeft;i++){ 
                        if((((monthsLeft + i)==11)||(monthsLeft + i)==12)){
                             
                           sumRent = sumRent + (standardMotelRentalAmount + standardMotelRentalAmount * seasonalRate);
                          }
                        else{
                            sumRent = sumRent + standardMotelRentalAmount;
                        }    
                    }
                 }  
                 /**
                  * calculates the total rental amount if the lease is less than a year
                  */
                 else 
                 {
                     for(j=0;j<anumberOfMonths;j++){ 
                        if((((amonth + j)==11)||(amonth + j)==12)){
                             
                            sumRent = sumRent + (standardMotelRentalAmount + standardMotelRentalAmount * seasonalRate);
                        }
                        else{
                            sumRent = sumRent + standardMotelRentalAmount;                          
                        }                         
                     }
                 }
            return (sumRent);
        }          
    }
    /**
     * Returns the motel rental fee,seasonal rate and the yearly discount amount which are initialized by the constructor
     * @return rental fee,seasonal rate and the yearly discount amount
     */
    public String toString(){
          return ("Motel rental fee is " + standardMotelRentalAmount + "; " + "the seasonal rate is " + seasonalRate + " the yearly discount is " + yearlyDiscount);
    } 
}
