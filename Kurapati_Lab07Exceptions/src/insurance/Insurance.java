/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance;

/**
 * Insurance interface implementation
 *
 * @author Rajiv kurapati
 */
public interface Insurance {

    /**
     * MONTHLY_INSTALLMENT assigned to 1000. YEARLY_INSTALLMENT_ONETIME_PAYMENT
     * assigned to 10000.
     *
     */
    static double MONTHLY_INSTALLMENT = 1000;
    static double YEARLY_INSTALLMENT_ONETIME_PAYMENT = 10000;

    /**
     * The exemption amount a person gets for a given number of months.
     *
     * @return Returns the value of monthly installment calculation.
     */
    double calcMontlyInstallment();

    /**
     * Calculates yearly installment.
     *
     * @return Returns the value of yearly installment calculation.
     */
    double calcYearlyInstallment();

    /**
     * The exemption amount a person gets for a given number of months.
     * @param totalMonths The number of months.
     * @return Returns the value of discount amount calculation.
     * @throws IncorrectMonthException If the totalMonths is less than 0.
     */
    double calcExemption(int totalMonths) throws IncorrectMonthException;

}
