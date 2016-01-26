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
public class ApartmentInsurance
        extends HouseInsurance {

    /**
     *
     * @param ownerName
     * @param apartmentNumber
     * @param totalYearsOfPayment
     * @param ssn
     * @param location
     */
    public ApartmentInsurance(String ownerName, String apartmentNumber, int totalYearsOfPayment, String ssn, String location) {
        super(ownerName, apartmentNumber, totalYearsOfPayment, ssn, location);
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
                ApartmentInsurance apartmentInsuranceObject = (ApartmentInsurance) object;
                flag = super.getLocation().equals(apartmentInsuranceObject.getLocation());
            }
        }
        return flag;
    }
}
