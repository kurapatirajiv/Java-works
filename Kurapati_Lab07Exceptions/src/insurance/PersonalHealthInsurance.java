/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance;

/**
 * PersonalHealthInsurance class implementation
 *
 * @author Rajiv kurapati
 */
public class PersonalHealthInsurance
        extends HealthInsurance {

    private Person person;

    /**
     * Initialize the person by using one-arg constructor.
     *
     * @param person Person type variable.
     */
    public PersonalHealthInsurance(Person person) {
        this.person = person;
    }

    /**
     * This method calculates the life insurance value of the individual person.
     * If totalMonths is 42, which is equivalent to 3 years and 6 months. The
     * method should return the sum of the number of years times the return
     * value of the calcYearlyInstallment() method and the number of months
     * times the return value of the calcMontlyInstallment() method.
     *
     * @param totalMonths The number of months.
     * @return Returns the value of life insurance calculation.
     * @throws IncorrectMonthException If the totalMonths is less than 0.
     */
    @Override
    public double calcLifeInsurance(int totalMonths)
            throws IncorrectMonthException {

        double result;
        if (totalMonths < 0) {
            throw new IncorrectMonthException("IncorrectMonthException : The Total months are less than Zero");
        }

        result = (totalMonths / 12) * calcYearlyInstallment();
        result += (totalMonths % 12) * calcMontlyInstallment();

        return result;

    }

    /**
     * This method calculates the yearly installment value of the individual
     * person. If the persons age is less than or equal to 10.00 or greater than
     * or equal to 60.00, then the method should return the difference of the
     * yearly installment of one time payment and the 20% of the yearly
     * installment of one time payment; else the method should return the yearly
     * installment of one time payment value.
     *
     * @return Returns the value of yearly installment calculation.
     */

    public double calcYearlyInstallment() {
        double yearlyInstallment = YEARLY_INSTALLMENT_ONETIME_PAYMENT;

        if (person.getAge() <= 10.00 || person.getAge() >= 60.00) {
            yearlyInstallment = YEARLY_INSTALLMENT_ONETIME_PAYMENT - (20 * YEARLY_INSTALLMENT_ONETIME_PAYMENT / 100);
        }

        return yearlyInstallment;

    }

    /**
     * This method calculates the monthly installment value of the individual
     * person. If the persons age is less than or equal to 10.00 or greater than
     * or equal to 60.00, then the method should return the difference of the
     * monthly installment and the 20% of the monthly installment; else the
     * method should return the monthly installment value.
     *
     * @return Returns the value of monthly installment calculation.
     */

    public double calcMontlyInstallment() {

        double monthlyInstallment = MONTHLY_INSTALLMENT;

        if (person.getAge() <= 10.00 || person.getAge() >= 60.00) {
            monthlyInstallment = MONTHLY_INSTALLMENT - (20 * MONTHLY_INSTALLMENT / 100);
        }

        return monthlyInstallment;

    }

    /**
     * This method calculates the exemption amount value of the individual
     * person. The method should return the difference of the
     * calcLifeInsurance() method value in it's super class and the value of
     * calcLifeInsurance() method.
     *
     * @param totalMonths The number of months.
     * @return Returns the value of Exemption calculation.
     * @throws IncorrectMonthException If the totalMonths is less than 0.
     */

    public double calcExemption(int totalMonths) throws IncorrectMonthException {
        if (totalMonths < 0) {
            throw new IncorrectMonthException("IncorrectMonthException : The Total months are less than Zero");
        }
        return (super.calcLifeInsurance(totalMonths) - calcLifeInsurance(totalMonths));
    }

    /**
     * The string representation consists of the person, calcMontlyInstallment()
     * and the calcYearlyInstallment(). Please refer to the word document for
     * the sample output.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "" + person + "; Monthly Installment: $" + String.format("%.2f", calcMontlyInstallment())
                + "; Yearly Installment: $" + String.format("%.2f", calcYearlyInstallment());

    }

}
