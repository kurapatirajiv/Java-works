/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance;

/**
 * Health Interface implementation
 *
 * @author Rajiv kurapati
 */
public interface Health extends Insurance {

    /**
     * The exemption amount a person gets for a given number of months.
     *
     * @param totalMonths the total months
     * @return Returns the value of life insurance calculation.
     * @throws IncorrectMonthException If the totalMonths is less than 0.
     */
    double calcLifeInsurance(int totalMonths) throws IncorrectMonthException;

}
