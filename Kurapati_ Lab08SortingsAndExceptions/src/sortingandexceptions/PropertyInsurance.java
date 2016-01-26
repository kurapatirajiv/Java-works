/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingandexceptions;

/**
 *
 * @author Rajiv Kurapati
 */
public interface PropertyInsurance {

    static double INSURANCE_DURATION = 5;
    static double LONG_TERM_PLAN = 100000;
    
    
    double calcShortTermPlan(int noOfYears) throws IncorrectYearsException;
    double calcLongTermPlan(int noOfYears) throws IncorrectYearsException;
    
    
}
