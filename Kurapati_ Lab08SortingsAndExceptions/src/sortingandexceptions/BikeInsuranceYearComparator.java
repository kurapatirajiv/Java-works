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
public class BikeInsuranceYearComparator
        extends Object
        implements java.util.Comparator<BikeInsurance> {

    /**
     *
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(BikeInsurance o1, BikeInsurance o2) {
        return o1.getVehiclePurchaseYear() - o2.getVehiclePurchaseYear();
    }

    /**
     *
     */
    public BikeInsuranceYearComparator() {
    }

}
