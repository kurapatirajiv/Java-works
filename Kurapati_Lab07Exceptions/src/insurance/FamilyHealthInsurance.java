/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance;

/**
 * Family Health insurance class implementation
 *
 * @author Rajiv kurapati
 */
public class FamilyHealthInsurance extends HealthInsurance {

    /**
     * familyMembers array of Person type. personsCount The personsCount denotes
     * the number of members in family at an instance of time.
     */
    private Person[] familyMembers;
    private int personsCount = 0;

    /**
     * Initialize the length of the familyMembers array by using one-arg
     * constructor.
     *
     * @param noOfPersons the number of persons
     */
    public FamilyHealthInsurance(int noOfPersons) {
        familyMembers = new Person[noOfPersons];
    }

    /**
     * This method adds the person to the familyMembers array.
     *
     * @param person Person type object
     * @throws IllegalFamilyMemberException throws an illegal family exception
     */
    public void addPerson(Person person) throws IllegalFamilyMemberException {

        if (personsCount > (familyMembers.length - 1)) {
            throw new IllegalFamilyMemberException("IllegalFamilyMemberException : The Persons count in the list is exceeding the size of the array");
        }
        familyMembers[personsCount] = person;
        personsCount++;
    }

    /**
     *
     * @param index
     * @return
     */
    public Person getFamilyMember(int index) {

        return familyMembers[index];
    }

    /**
     * gets the current persons count
     *
     * @return current persons count
     */
    public int getPersonsCount() {
        return personsCount;
    }

    /**
     * This method calculates the exemption amount value of the whole family.
     *
     * @param totalMonths the total months
     * @return returns the exemption amount that is calculated
     * @throws IncorrectMonthException throws the Incorrect month exception
     */
   
    public double calcExemption(int totalMonths) throws IncorrectMonthException {
        double exemption;
        if (totalMonths < 0) {
            throw new IncorrectMonthException("IncorrectMonthException : The Total months are less than Zero");
        }
        exemption = super.calcLifeInsurance(totalMonths) * personsCount - calcLifeInsurance(totalMonths);
        return exemption;
    }

    /**
     * This method calculates the life insurance value for the whole family.
     *
     * @param totalMonths the total months
     * @return the exemption amount that is calculated
     * @throws IncorrectMonthException throws the Incorrect month exception
     */

    public double calcLifeInsurance(int totalMonths) throws IncorrectMonthException {
        double result;
        if (totalMonths < 0) {
            throw new IncorrectMonthException("IncorrectMonthException : The Total months are less than Zero");
        }
        result = (totalMonths / 12) * calcYearlyInstallment();
        result += (totalMonths % 12) * calcMontlyInstallment();

        return result;
    }

    /**
     * This method calculates the monthly installment value for the whole
     * family.
     *
     * @return the final monthly installment
     */

    public double calcMontlyInstallment() {

        double monthlyInstallment;
        double finalMonthlyInstallment = 0.00;
        for (int i = 0; i < personsCount; i++) {
            if ((familyMembers[i].getAge() <= 10.00) || (familyMembers[i].getAge() >= 60.00)) {
                monthlyInstallment = MONTHLY_INSTALLMENT - (20 * MONTHLY_INSTALLMENT / 100);
            } else {
                monthlyInstallment = MONTHLY_INSTALLMENT;
            }
            finalMonthlyInstallment += calcFamilyDiscount(monthlyInstallment);
        }
        return finalMonthlyInstallment;

    }

    /**
     * This method calculates the yearly installment value for the whole family.
     *
     * @return returns the final yearly installment
     */
    
    public double calcYearlyInstallment() {
        double yearlyInstallment;
        double finalYearlyInstallment = 0.00;
        for (int i = 0; i < personsCount; i++) {
            if (familyMembers[i].getAge() <= 10.00 || familyMembers[i].getAge() >= 60.00) {
                yearlyInstallment = YEARLY_INSTALLMENT_ONETIME_PAYMENT - (20 * YEARLY_INSTALLMENT_ONETIME_PAYMENT / 100);
            } else {
                yearlyInstallment = YEARLY_INSTALLMENT_ONETIME_PAYMENT;
            }
            finalYearlyInstallment += calcFamilyDiscount(yearlyInstallment);
        }
        return finalYearlyInstallment;
    }

    /**
     * This method calculates the family discount value for the whole family.
     *
     * @param valueBasedOnAge value based on age
     * @return the family discount amount
     */
    public double calcFamilyDiscount(double valueBasedOnAge) {

        double familyDiscount = valueBasedOnAge;
        if (personsCount == 4) {
            familyDiscount -= 15 * valueBasedOnAge / 100;
        } else if (personsCount >= 5) {
            familyDiscount -= 20 * valueBasedOnAge / 100;
        }

        return familyDiscount;
    }

    /**
     * The string representation consists of the familyMembers array,
     * calcMontlyInstallment() and the calcYearlyInstallment().
     *
     * @return returns the Monthly and the yearly installments of the family
     * members
     */
    @Override
    public String toString() {

        String result = "";
        for (int i = 0; i < personsCount; i++) {
            result += familyMembers[i] + "; Family Monthly Installment: $" + String.format("%.2f", calcMontlyInstallment())
                    + "; Family Yearly Installment: $" + String.format("%.2f", calcYearlyInstallment()) + "\n";
        }
        return result;
    }

}
