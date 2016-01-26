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
public class BikeInsurance extends VehicleInsurance {

    /**
     *
     * @param vehicleOwnerName
     * @param vehicleNumber
     * @param vehicleMake
     * @param vehiclePurchaseYear
     * @param totalYearsOfPayment
     * @param telephoneNumber
     */
    public BikeInsurance(String vehicleOwnerName, String vehicleNumber, String vehicleMake, int vehiclePurchaseYear, int totalYearsOfPayment, String telephoneNumber) {
        super(vehicleOwnerName, vehicleNumber, vehicleMake, vehiclePurchaseYear, totalYearsOfPayment, telephoneNumber);
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
                BikeInsurance bikeInsuranceObject = (BikeInsurance) object;
                flag = this.getVehicleOwnerName().equals(bikeInsuranceObject.getVehicleOwnerName());
            }
        }
        return flag;
    }

}
