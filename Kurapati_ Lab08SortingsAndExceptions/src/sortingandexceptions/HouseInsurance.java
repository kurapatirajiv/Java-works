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
public class HouseInsurance extends Object
        implements PropertyInsurance, java.lang.Comparable<HouseInsurance> {

    private String apartmentNumber;
    private String location;
    private String ownerName;
    private String ssn;
    private int totalYearsOfPayment;

    /**
     *
     * @return
     */
    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    /**
     *
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     *
     * @param ownerName
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     *
     * @return
     */
    public String getSsn() {
        return ssn;
    }

    /**
     *
     * @param ssn
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     *
     * @return
     */
    public int getTotalYearsOfPayment() {
        return totalYearsOfPayment;
    }

    /**
     *
     * @param totalYearsOfPayment
     */
    public void setTotalYearsOfPayment(int totalYearsOfPayment) {
        this.totalYearsOfPayment = totalYearsOfPayment;
    }

    /**
     *
     * @param ownerName
     * @param apartmentNumber
     * @param totalYearsOfPayment
     * @param ssn
     * @param location
     */
    public HouseInsurance(String ownerName, String apartmentNumber, int totalYearsOfPayment, String ssn, String location) {
        this.apartmentNumber = apartmentNumber;
        this.location = location;
        this.ownerName = ownerName;
        this.ssn = ssn;
        this.totalYearsOfPayment = totalYearsOfPayment;
    }

    /**
     *
     * @param noOfYears
     * @return
     * @throws IncorrectYearsException
     */
    public double calcLongTermPlan(int noOfYears)
            throws IncorrectYearsException {
        double result = 0.0;
        if (noOfYears == INSURANCE_DURATION) {
            result = LONG_TERM_PLAN * noOfYears + 0.10 * LONG_TERM_PLAN * noOfYears;
        } else {
            if (noOfYears < INSURANCE_DURATION && noOfYears > 0) {
                result = calcShortTermPlan(noOfYears);
            } else {
                if (noOfYears > INSURANCE_DURATION || noOfYears <= 0) {
                    throw new IncorrectYearsException("Value of repayment shouldn't be greater than the insurance duration or less than equal to zero.");
                }
            }
        }
        return result;
    }

    /**
     *
     * @param noOfYears
     * @return
     * @throws IncorrectYearsException
     */
    public double calcShortTermPlan(int noOfYears)
            throws IncorrectYearsException {
        double result = 0.0;
        switch (noOfYears) {
            case 4:
                result = LONG_TERM_PLAN * noOfYears - (0.20 * LONG_TERM_PLAN * noOfYears);
                break;
            case 3:
                result = LONG_TERM_PLAN * noOfYears - (0.23 * LONG_TERM_PLAN * noOfYears);
                break;
            case 2:
                result = LONG_TERM_PLAN * noOfYears - (0.25 * LONG_TERM_PLAN * noOfYears);
                break;
            case 1:
                result = LONG_TERM_PLAN * noOfYears - (0.27 * LONG_TERM_PLAN * noOfYears);
                break;
            case (int) INSURANCE_DURATION:
                result = calcLongTermPlan(noOfYears);
                break;
            default:
                throw new IncorrectYearsException("Value of repayment shouldn't be greater than the insurance duration or less than equal to zero.");
        }
        return result;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(java.lang.Object object) {
        boolean flag = false;
        if (object != null) {
            if (this.getClass() == object.getClass()) {
                HouseInsurance houseObject = (HouseInsurance) object;
                flag = this.getOwnerName().equals(houseObject.getOwnerName());
            }
        }
        return flag;
    }

    /**
     *
     * @param houseInsurance
     * @return
     */
    public int compareTo(HouseInsurance houseInsurance) {
        return this.getApartmentNumber().compareTo(houseInsurance.getApartmentNumber());
    }

    /**
     *
     * @param ssn
     * @throws NonDigitFoundException
     */
    public void checkSSNNumber(java.lang.String ssn)
            throws NonDigitFoundException {

        for (int i = 0; i < ssn.length(); i++) {
            if (!(Character.isDigit(ssn.charAt(i)))) {
                throw new NonDigitFoundException("NonDigitFoundException: Some values in the SSN are not digits.");
            }
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("%-10s ", this.ownerName) + String.format("%-10s ", this.apartmentNumber)
                + String.format("%3d ", this.totalYearsOfPayment) + String.format("%-10s ", this.ssn) + String.format("%-10s ", this.location) + this.ssn.substring(0, 3) + "-"
                + this.ssn.substring(3, 6) + "-" + this.ssn.substring(6);

    }

}
