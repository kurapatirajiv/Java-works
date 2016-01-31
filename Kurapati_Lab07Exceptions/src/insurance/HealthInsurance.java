/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance;

/**
 *
 * @author Rajiv kurapati
 */
public abstract class HealthInsurance implements Health {

    /**
     * Does nothing
     */
    public HealthInsurance() {

    }

    /**
     * This method calculates the life insurance value.
     *
     * @param totalMonths The number of months.
     * @return Returns the value of life insurance calculation.
     * @throws IncorrectMonthException If the totalMonths is less than 0.
     */
    public double calcLifeInsurance(int totalMonths)
            throws IncorrectMonthException {
        double result;

        result = ((totalMonths / 12) * YEARLY_INSTALLMENT_ONETIME_PAYMENT);
        result += ((totalMonths % 12) * MONTHLY_INSTALLMENT);

        return (result);
    }

}
