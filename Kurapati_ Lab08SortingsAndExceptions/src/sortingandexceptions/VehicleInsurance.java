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
public class VehicleInsurance extends Object implements PropertyInsurance, java.lang.Comparable<VehicleInsurance> {

    private String telephoneNumber;
    private int totalYearsOfPayment;
    private String vehicleMake;
    private String vehicleNumber;
    private String vehicleOwnerName;
    private int vehiclePurchaseYear;

    /**
     *
     * @param vehicleOwnerName
     * @param vehicleNumber
     * @param vehicleMake
     * @param vehiclePurchaseYear
     * @param totalYearsOfPayment
     * @param telephoneNumber
     */
    public VehicleInsurance(String vehicleOwnerName, String vehicleNumber, String vehicleMake, int vehiclePurchaseYear, int totalYearsOfPayment, String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        this.totalYearsOfPayment = totalYearsOfPayment;
        this.vehicleMake = vehicleMake;
        this.vehicleNumber = vehicleNumber;
        this.vehicleOwnerName = vehicleOwnerName;
        this.vehiclePurchaseYear = vehiclePurchaseYear;
    }

    /**
     *
     * @return
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     *
     * @param telephoneNumber
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
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
     * @return
     */
    public String getVehicleMake() {
        return vehicleMake;
    }

    /**
     *
     * @param vehicleMake
     */
    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    /**
     *
     * @return
     */
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    /**
     *
     * @param vehicleNumber
     */
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    /**
     *
     * @return
     */
    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    /**
     *
     * @param vehicleOwnerName
     */
    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    /**
     *
     * @return
     */
    public int getVehiclePurchaseYear() {
        return vehiclePurchaseYear;
    }

    /**
     *
     * @param vehiclePurchaseYear
     */
    public void setVehiclePurchaseYear(int vehiclePurchaseYear) {
        this.vehiclePurchaseYear = vehiclePurchaseYear;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        // return "VehicleInsurance{" + "telephoneNumber=" + telephoneNumber + ", totalYearsOfPayment=" + totalYearsOfPayment + ", vehicleMake=" + vehicleMake + ", vehicleNumber=" + String.format("%-10s", vehicleNumber) + ", vehicleOwnerName=" + String.format("%-10s", vehicleOwnerName) + ", vehiclePurchaseYear=" + vehiclePurchaseYear + '}';

        return String.format("%-10s ", vehicleOwnerName) + String.format("%-10s ", vehicleNumber) + String.format("%-10s ", vehicleMake)
                + String.format("%3d ", vehiclePurchaseYear) + String.format("%3d ", totalYearsOfPayment) + telephoneNumber.substring(0, 3) + "-"
                + telephoneNumber.substring(3, 6) + "-" + telephoneNumber.substring(6);
    }

    /**
     *
     * @param telephoneNumber
     * @throws IncorrectAreaCodeException
     * @throws IncorrectLengthException
     * @throws NonDigitFoundException
     */
    public void checkPhoneNumber(java.lang.String telephoneNumber)
            throws IncorrectAreaCodeException,
            IncorrectLengthException,
            NonDigitFoundException {

        if (telephoneNumber.length() + 1 == 10) {
            throw new IncorrectLengthException();
        } else {
            if (!(telephoneNumber.startsWith("660")) || (telephoneNumber.startsWith("816"))) {
                throw new IncorrectAreaCodeException("IncorrectAreaCodeException: Area code must be 660 or 816.");
            } else {
                for (int i = 0; i < telephoneNumber.length(); i++) {
                    if (!(Character.isDigit(telephoneNumber.charAt(i)))) {
                        throw new NonDigitFoundException("NonDigitFoundException: Some values in the telephone number are not digits.");
                    }
                }

            }
        }
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
                result = LONG_TERM_PLAN * noOfYears - 0.10 * LONG_TERM_PLAN * noOfYears;
                break;
            case 3:
                result = LONG_TERM_PLAN * noOfYears - 0.15 * LONG_TERM_PLAN * noOfYears;
                break;
            case 2:
                result = LONG_TERM_PLAN * noOfYears - 0.20 * LONG_TERM_PLAN * noOfYears;
                break;
            case 1:
                result = LONG_TERM_PLAN * noOfYears - 0.25 * LONG_TERM_PLAN * noOfYears;
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
                VehicleInsurance vehicleInsuranceObject = (VehicleInsurance) object;
                flag = this.getTelephoneNumber().equals(vehicleInsuranceObject.getTelephoneNumber());
            }
        }
        return flag;
    }

    /**
     *
     * @param vehicleInsurance
     * @return
     */
    public int compareTo(VehicleInsurance vehicleInsurance) {
        return this.getTelephoneNumber().compareTo(vehicleInsurance.getTelephoneNumber());
    }

}
