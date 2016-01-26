package sortingandexceptions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rajiv Kurapati
 */
public class StudioInsurance
        extends HouseInsurance {

    /**
     *
     * @param ownerName
     * @param apartmentNumber
     * @param totalYearsOfPayment
     * @param ssn
     * @param location
     */
    public StudioInsurance(String ownerName, String apartmentNumber, int totalYearsOfPayment, String ssn, String location) {
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
                StudioInsurance studioInsuranceObject = (StudioInsurance) object;
                flag = this.getApartmentNumber().equals(studioInsuranceObject.getApartmentNumber());
            }
        }
        return flag;
    }

}
